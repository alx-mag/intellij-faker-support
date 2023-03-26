package com.github.alxmag.intellijfakersupport.lang.reference

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionNameSegment
import com.github.alxmag.intellijfakersupport.lang.psi.impl.argsQuoteSymbol
import com.github.alxmag.intellijfakersupport.util.FakerPsiUtils
import com.github.alxmag.intellijfakersupport.util.hasNoArgs
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementPresentation
import com.intellij.openapi.util.Iconable
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*

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
        return myElement.resolveFunctionCallInfo()
            ?.resolveMethods()
            ?.map(::PsiElementResolveResult)
            ?.toTypedArray()
            ?: emptyArray()
    }

    override fun getVariants(): Array<*> {
        val (parentClass, _, noArgsMethod, expression) = myElement.resolveFunctionCallInfo()
            ?: return emptyArray<Any>()

        var psiMethods = parentClass.allMethods
            .asSequence()
            .filter { it.isFakerApiMethod() }

        if (noArgsMethod) {
            psiMethods = psiMethods.filter { it.hasNoArgs() }
        }

        psiMethods = psiMethods.sortedBy { it.name }

        return psiMethods.map { FakerMethodLookupElement(it, expression.argsQuoteSymbol) }
            .toList()
            .toTypedArray()
    }
}

class FakerMethodLookupElement(
    private val method: PsiMethod,
    /**
     * If provided, the lookup will render arguments available for the [method].
     */
    private val argsQuoteSymbol: String?
) : LookupElement() {
    override fun getLookupString(): String = method.name

    override fun renderElement(presentation: LookupElementPresentation?) {
        presentation!!.icon = method.getIcon(Iconable.ICON_FLAG_VISIBILITY)
        presentation.itemText = method.name

        if (argsQuoteSymbol != null) {
            presentation.tailText = method.parameterList
                .parameters
                .joinToString(separator = ", ", prefix = " ") { param ->
                    FakerPsiUtils.createExpressionParamText(param, argsQuoteSymbol)
                }
                .takeIf { it.isNotBlank() }
        }
        val returnType: PsiType? = method.returnType
        if (returnType != null) {
            presentation.typeText = returnType.presentableText
        }
    }
}