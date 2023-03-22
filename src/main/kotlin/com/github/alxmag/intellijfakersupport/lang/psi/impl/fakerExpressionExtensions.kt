package com.github.alxmag.intellijfakersupport.lang.psi.impl

val FakerExpression.isArgsSupported
    get() = this is FakerParametrizedExpression

val FakerExpression.argsQuoteSymbol
    get() = (this as? FakerParametrizedExpression)?.getParamQuoteSymbol()