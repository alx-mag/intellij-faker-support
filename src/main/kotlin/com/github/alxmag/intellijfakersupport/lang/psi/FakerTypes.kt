package com.github.alxmag.intellijfakersupport.lang.psi

import com.intellij.psi.tree.IElementType

object FakerTypes {

    @JvmField
    val CONTENT = FakerElementType("Content")

    @JvmField
    val WHITESPACE = FakerElementType("WHITESPACE")
    @JvmField
    val DOT = FakerElementType(".")
    @JvmField
    val COMMA = FakerElementType(",")

    @JvmField
    val IDENTIFIER = FakerElementType("Identifier")
    @JvmField
    val PARAMS_LIST_BEGIN = FakerElementType("Params list begin")

    @JvmField
    val PARAM_BEGIN = FakerElementType("Param begin")
    @JvmField
    val PARAM_END = FakerElementType("Param end")

    @JvmField
    val STRING_LITERAL = FakerElementType("String param")
    @JvmField
    val INT_LITERAL = FakerElementType("Integer literal")

    @JvmField
    var REGULAR_STRING_PART: IElementType = FakerElementType("Regular String Part")
    @JvmField
    var HASH: IElementType = FakerElementType("Hash")

    @JvmField
    val EXPRESSION_LBRACE = FakerElementType("Expression lbrace")
    @JvmField
    val EXPRESSION_RBRACE = FakerElementType("Expression rbrace")
}