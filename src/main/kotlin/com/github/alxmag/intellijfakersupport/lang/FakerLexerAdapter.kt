package com.github.alxmag.intellijfakersupport.lang

import com.intellij.lexer.FlexAdapter

class FakerLexerAdapter : FlexAdapter(FakerLexer(null))