package com.github.alxmag.intellijfakersupport.lang.psi

import com.intellij.psi.PsiElement

interface FakerParam : PsiElement {
    fun getQuoteSymbol(): String

    fun getValue(): FakerTemplate?
}