package com.github.alxmag.intellijfakersupport.lang.reference

import com.github.alxmag.intellijfakersupport.datafaker.findFakerClass
import com.github.alxmag.intellijfakersupport.lang.name
import com.github.alxmag.intellijfakersupport.lang.psi.FakerExpression
import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionNameSegment
import com.github.alxmag.intellijfakersupport.lang.psi.impl.isArgsSupported
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiMethod
import com.intellij.psi.util.PsiUtil
import com.intellij.psi.util.parentOfType

data class FunctionCallInfo(
    val clazz: PsiClass,
    val methodName: String,
    /**
     * Indicates that the method is declared in the middle of expressions chain, thus it no-args method.
     */
    val noArgsMethod: Boolean,
    val expression: FakerExpression
) {
    fun resolveMethods(): Array<PsiMethod> = if (noArgsMethod) {
        clazz.findNoArgsApiMethod(methodName)
            ?.let { arrayOf(it) }
            ?: emptyArray()
    } else {
        clazz.findMethodsByName(methodName, true)
    }
}

fun FakerFunctionNameSegment.resolveFunctionCallInfo(): FunctionCallInfo? {
    val expression = this.parentOfType<FakerExpression>()
        ?: return null // we don't expect ot find here a segment that out of FakerExpression anyway

    val (identifiersList, mySegmentIndex) = resolveIdentifierInfo()
        ?: return null

    val project = project
    var parentClass = project.findFakerClass(resolveScope) ?: return null

    for (i in 0 until mySegmentIndex) {
        val methodName = FakerExpressionUtil.normalizeMethodName(identifiersList[i].name)
        val method = parentClass.findNoArgsApiMethod(methodName) ?: return null
        // The next parent class is the method return type
        parentClass = PsiUtil.resolveClassInType(method.returnType)
            ?.takeIf { !it.isValueType() } // Value types are not used as parents
            ?: return null
    }

    return FunctionCallInfo(
        parentClass,
        FakerExpressionUtil.normalizeMethodName(this.name),
        !expression.isArgsSupported || mySegmentIndex != identifiersList.lastIndex,
        expression
    )
}
