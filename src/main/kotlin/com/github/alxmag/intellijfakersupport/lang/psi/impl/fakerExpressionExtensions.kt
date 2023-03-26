package com.github.alxmag.intellijfakersupport.lang.psi.impl

import com.github.alxmag.intellijfakersupport.lang.psi.FakerExpression
import com.github.alxmag.intellijfakersupport.lang.psi.FakerParametrizedExpression

val FakerExpression.isArgsSupported
    get() = this is FakerParametrizedExpression

val FakerExpression.argsQuoteSymbol
    get() = (this as? FakerParametrizedExpression)?.getParamQuoteSymbol()