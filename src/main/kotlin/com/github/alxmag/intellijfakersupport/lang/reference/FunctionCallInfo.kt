package com.github.alxmag.intellijfakersupport.lang.reference

import com.github.alxmag.intellijfakersupport.datafaker.findFakerClass
import com.github.alxmag.intellijfakersupport.lang.name
import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionNameSegment
import com.intellij.psi.PsiClass
import com.intellij.psi.util.PsiUtil

data class FunctionCallInfo(val parentClass: PsiClass, val isLast: Boolean)

fun FakerFunctionNameSegment.resolveFunctionCallInfo(): FunctionCallInfo? {
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

    return FunctionCallInfo(parentClass, mySegmentIndex == identifiersList.lastIndex)
}
