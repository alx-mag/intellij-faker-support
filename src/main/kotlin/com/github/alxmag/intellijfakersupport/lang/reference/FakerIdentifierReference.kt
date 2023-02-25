package com.github.alxmag.intellijfakersupport.lang.reference

import com.github.alxmag.intellijfakersupport.lang.name
import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionNameSegment
import com.github.alxmag.intellijfakersupport.util.hasNoArgs
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementPresentation
import com.intellij.openapi.util.Iconable
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiFormatUtil

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
        val (parentClass, isLast) = myElement.resolveFunctionCallInfo()
            ?: return emptyArray()

        val targetMethodName = FakerExpressionUtil.normalizeMethodName(myElement.name)

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
        val (parentClass, isLast) = myElement.resolveFunctionCallInfo() ?: return emptyArray<Any>()

        var variants = parentClass.allMethods
            .asSequence()
            .filter { it.isFakerApiMethod() }

        if (!isLast) {
            variants = variants.filter { it.hasNoArgs() }
        }

        variants = variants.sortedBy { it.name }
            // Exclude inherited methods to prevent duplicates in lookup
            .filter { it.findSuperMethods().isEmpty() }

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