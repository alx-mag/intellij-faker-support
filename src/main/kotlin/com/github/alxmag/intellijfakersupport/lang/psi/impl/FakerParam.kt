package com.github.alxmag.intellijfakersupport.lang.psi.impl

import com.github.alxmag.intellijfakersupport.lang.psi.FakerTemplate
import com.intellij.psi.PsiElement

interface FakerParam : PsiElement {
    fun getQuoteSymbol(): String

    fun getValue(): FakerTemplate?
}