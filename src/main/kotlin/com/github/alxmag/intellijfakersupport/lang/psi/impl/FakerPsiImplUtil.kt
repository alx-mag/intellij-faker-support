package com.github.alxmag.intellijfakersupport.lang.psi.impl

import com.github.alxmag.intellijfakersupport.lang.psi.*
import com.github.alxmag.intellijfakersupport.lang.reference.FakerIdentifierReference
import com.intellij.psi.PsiReference

object FakerPsiImplUtil {

    private const val L1_PARAM_QUOTE = "'"
    private const val L2_PARAM_QUOTE = "''"

    @JvmStatic
    fun getFunctionName(functionName: FakerFunctionName): String {
        return functionName.segments.joinToString(".") { element -> element.text }
    }

    @JvmStatic
    fun getReference(functionNameSegment: FakerFunctionNameSegment): PsiReference {
        return FakerIdentifierReference(functionNameSegment)
    }

    @JvmStatic
    fun getQuoteSymbol(@Suppress("UNUSED_PARAMETER") param: FakerL1Param) = L1_PARAM_QUOTE

    @JvmStatic
    fun getQuoteSymbol(@Suppress("UNUSED_PARAMETER") param: FakerL2Param) = L2_PARAM_QUOTE

    @JvmStatic
    fun getParamQuoteSymbol(@Suppress("UNUSED_PARAMETER") param: FakerL1Expression) = L1_PARAM_QUOTE

    @JvmStatic
    fun getParamQuoteSymbol(@Suppress("UNUSED_PARAMETER") param: FakerL2Expression) = L2_PARAM_QUOTE
}