package com.github.alxmag.intellijfakersupport.lang.reference

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionName
import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionNameSegment
import com.intellij.psi.util.parentOfType

data class FunctionIdentifierInfo(val identifiersList: List<FakerFunctionNameSegment>, val identifierIndex: Int)

fun FakerFunctionNameSegment.resolveIdentifierInfo(): FunctionIdentifierInfo? {
    val functionName = this.parentOfType<FakerFunctionName>() ?: return null
    val identifiersList = functionName.segments
    val mySegmentIndex = identifiersList.indexOf(this)
        .takeIf { it != -1 } ?: return null
    return FunctionIdentifierInfo(identifiersList, mySegmentIndex)
}