package com.github.alxmag.intellijfakersupport.lang.editor

import com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes
import com.intellij.codeInsight.editorActions.QuoteHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.highlighter.HighlighterIterator

class FakerQuoteHandler : QuoteHandler {

    override fun isOpeningQuote(iterator: HighlighterIterator, offset: Int): Boolean {
        return iterator.tokenType == FakerTypes.PARAM_BEGIN
    }

    override fun isClosingQuote(iterator: HighlighterIterator, offset: Int): Boolean {
        return iterator.tokenType == FakerTypes.PARAM_END
    }

    override fun hasNonClosedLiteral(editor: Editor?, iterator: HighlighterIterator?, offset: Int): Boolean = true

    override fun isInsideLiteral(iterator: HighlighterIterator?): Boolean = false
}