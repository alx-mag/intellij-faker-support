package com.github.alxmag.intellijfakersupport.util

import com.intellij.psi.PsiParameter
import com.intellij.psi.PsiSubstitutor
import com.intellij.psi.util.PsiFormatUtil

object FakerPsiUtils {
    fun createExpressionParamText(param: PsiParameter, quoteSymbol: String): String {
        val text = PsiFormatUtil.formatVariable(
            param,
            PsiFormatUtil.SHOW_NAME or PsiFormatUtil.SHOW_TYPE,
            PsiSubstitutor.EMPTY
        )
        return quoteSymbol + text + quoteSymbol
    }
}