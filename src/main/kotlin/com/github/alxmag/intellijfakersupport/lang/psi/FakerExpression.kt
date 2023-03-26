package com.github.alxmag.intellijfakersupport.lang.psi

import com.intellij.psi.PsiElement

interface FakerExpression : PsiElement {
    fun getFunctionName(): FakerFunctionName?
}