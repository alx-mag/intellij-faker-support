package com.github.alxmag.intellijfakersupport.lang.psi.impl

interface FakerParametrizedExpression : FakerExpression {
    fun getParamQuoteSymbol(): String
}