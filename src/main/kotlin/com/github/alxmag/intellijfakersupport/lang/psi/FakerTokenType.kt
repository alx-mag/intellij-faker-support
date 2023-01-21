package com.github.alxmag.intellijfakersupport.lang.psi

import com.github.alxmag.intellijfakersupport.lang.FakerLanguage
import com.intellij.psi.tree.IElementType

class FakerTokenType(debugName: String) : IElementType(debugName, FakerLanguage) {
    override fun toString(): String = "FakerTokenType" + super.toString()
}