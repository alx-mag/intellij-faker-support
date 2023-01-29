package com.github.alxmag.intellijfakersupport.lang

import com.github.alxmag.intellijfakersupport.lang.psi.FakerTokenSets
import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.MergingLexerAdapter

class FakerLexerAdapter : MergingLexerAdapter(
    FakerFlexLexer(),
    FakerTokenSets.REGULAR_STRING_PARTS
)

class FakerFlexLexer : FlexAdapter(FakerLexer(null))