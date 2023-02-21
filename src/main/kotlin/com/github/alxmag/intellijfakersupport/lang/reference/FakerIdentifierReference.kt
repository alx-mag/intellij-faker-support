package com.github.alxmag.intellijfakersupport.lang.reference

import com.github.alxmag.intellijfakersupport.datafaker.findFakerClass
import com.github.alxmag.intellijfakersupport.lang.name
import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionName
import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionNameSegment
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementPresentation
import com.intellij.openapi.util.Iconable
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiFormatUtil
import com.intellij.psi.util.PsiUtil
import com.intellij.psi.util.parentOfType

class FakerIdentifierReference(nameSegment: FakerFunctionNameSegment) : PsiReferenceBase<FakerFunctionNameSegment>(
    nameSegment,
    TextRange.from(0, nameSegment.text.length),
    true
), PsiPolyVariantReference {

    override fun resolve(): PsiElement? {
        return multiResolve(false)
            .takeIf { it.size == 1 }
            ?.first()
            ?.element
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val (parentClass, isLast) = ResolveHelper.resolveFunctionNameSegmentInfo(myElement)
            ?: return emptyArray()

        // TODO normalize name
        val targetMethodName = myElement.name

        if (isLast) {
            return parentClass.findMethodsByName(targetMethodName, true)
                .map(::PsiElementResolveResult)
                .toTypedArray()
        } else {
            val method = parentClass.findNoArgsApiMethod(targetMethodName) ?: return emptyArray()
            return arrayOf(PsiElementResolveResult(method))
        }
    }


    override fun getVariants(): Array<*> {
        val (parentClass, isLast) = ResolveHelper.resolveFunctionNameSegmentInfo(myElement) ?: return emptyArray<Any>()

        var variants = parentClass.allMethods
            .asSequence()
            .filter { it.isFakerApiMethod() }

        if (!isLast) {
            variants = variants.filter { it.isNoArgs() }
        }

        variants = variants.sortedBy { it.name }

        return variants.map { FakerMethodLookupElement(it) }
            .toList()
            .toTypedArray()
    }
}

class FakerMethodLookupElement(private val method: PsiMethod) : LookupElement() {
    override fun getLookupString(): String = method.name

    override fun renderElement(presentation: LookupElementPresentation?) {
        presentation!!.icon = method.getIcon(Iconable.ICON_FLAG_VISIBILITY)
        presentation.itemText = method.name

        presentation.tailText = method.parameterList.parameters.joinToString(separator = ", ", prefix = " ") { param ->
            val text = PsiFormatUtil.formatVariable(
                param,
                PsiFormatUtil.SHOW_NAME or PsiFormatUtil.SHOW_TYPE,
                PsiSubstitutor.EMPTY
            )
            "'$text'"
        }.takeIf { it.isNotBlank() }
        val returnType: PsiType? = method.returnType
        if (returnType != null) {
            presentation.typeText = returnType.presentableText
        }
    }

}

private object ResolveHelper {

    // TODO exclude primitive methods from chain (String, Int etc)
    fun resolveFunctionNameSegmentInfo(identifier: FakerFunctionNameSegment): FunctionNameSegmentInfo? {
        val (identifiersList, mySegmentIndex) = identifier.getInfo()
            ?: return null

        val project = identifier.project
        var parentClass = project.findFakerClass(identifier.resolveScope) ?: return null

        for (i in 0 until mySegmentIndex) {
            // TODO normalize method name
            val methodName = identifiersList[i].name
            val method = parentClass.findNoArgsApiMethod(methodName) ?: return null
            // The next parent class is the method return type
            parentClass = PsiUtil.resolveClassInType(method.returnType) ?: return null
        }

        return FunctionNameSegmentInfo(parentClass, mySegmentIndex == identifiersList.lastIndex)
    }

    val ObjectMethods = setOf(
        "toString",
        "equals",
        "hashCode",
        "notify",
        "wait",
        "notifyAll",
        "finalize",
        "clone",
        "getClass"
    )
}

private fun PsiClass.findNoArgsApiMethod(name: String): PsiMethod? {
    return this.findMethodsByName(name, true)
        .find { it.isFakerApiMethod() && it.isNoArgs() }
}

// TODO remove methods with params that can-not be provided via expression (non-primitives)
private fun PsiMethod.isFakerApiMethod() = this.isPublic() and
        this.isNonStatic() and
        !this.isConstructor and
        !this.isObjectMethod()

private fun PsiMethod.isObjectMethod() = this.name in ResolveHelper.ObjectMethods

private fun PsiMethod.isPublic() = modifierList.hasModifierProperty(PsiModifier.PUBLIC)

private fun PsiMethod.isNonStatic() = !modifierList.hasModifierProperty(PsiModifier.STATIC)

private fun PsiMethod.isNoArgs() = this.parameterList.parameters.isEmpty()

private data class FunctionNameSegmentInfo(val parentClass: PsiClass, val isLast: Boolean)

private data class IdentifierInfo(val identifiersList: List<FakerFunctionNameSegment>, val index: Int)

private fun FakerFunctionNameSegment.getInfo(): IdentifierInfo? {
    val functionName = this.parentOfType<FakerFunctionName>() ?: return null
    val identifiersList = functionName.segments
    val mySegmentIndex = identifiersList.indexOf(this)
        .takeIf { it != -1 } ?: return null
    return IdentifierInfo(identifiersList, mySegmentIndex)
}