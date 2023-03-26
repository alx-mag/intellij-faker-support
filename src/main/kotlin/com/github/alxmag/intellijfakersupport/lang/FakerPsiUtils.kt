package com.github.alxmag.intellijfakersupport.lang

import com.github.alxmag.intellijfakersupport.lang.psi.*

val FakerFunctionNameSegment.name: String get() = this.text

val FakerParamList.params: MutableList<out FakerParam>
    get() = when (this) {
        is FakerL1ParamList -> this.params
        is FakerL2ParamList -> this.params
        else -> throw UnsupportedOperationException()
    }