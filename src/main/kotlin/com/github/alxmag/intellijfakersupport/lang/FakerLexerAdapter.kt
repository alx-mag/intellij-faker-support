package com.github.alxmag.intellijfakersupport.lang

import com.github.alxmag.intellijfakersupport.lang.psi.FakerElement
import com.github.alxmag.intellijfakersupport.lang.psi.FakerElementType
import com.github.alxmag.intellijfakersupport.lang.psi.FakerTokenSets
import com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes
import com.intellij.lexer.*

class FakerLexerAdapter : MergingLexerAdapter(
    FakerFlexLexer(),
    FakerTokenSets.REGULAR_STRING_PARTS
)

class FakerFlexLexer : FlexAdapter(FakerLexer(null))
//class FakerLookAheadLexer : LookAheadLexer(FakerFlexLexer()) {
//    override fun lookAhead(baseLexer: Lexer) {
//        val tokenType = baseLexer.tokenType
//        when (tokenType) {
//            FakerTypes.HASH -> {
//                advanceLexer(baseLexer)
//                baseLexer.tokenType
//            }
//            else -> super.lookAhead(baseLexer)
//        }
//    }
//}