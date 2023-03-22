package com.github.alxmag.intellijfakersupport.lang.psi.impl

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionName
import com.intellij.psi.PsiElement

interface FakerExpression : PsiElement {
    fun getFunctionName(): FakerFunctionName?
}