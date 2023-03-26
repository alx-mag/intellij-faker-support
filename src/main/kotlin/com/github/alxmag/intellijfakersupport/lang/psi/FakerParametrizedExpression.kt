package com.github.alxmag.intellijfakersupport.lang.psi

interface FakerParametrizedExpression : FakerExpression {
    fun getParamQuoteSymbol(): String
    fun getParamList(): FakerParamList?
}