package com.github.alxmag.intellijfakersupport.lang.editor

import com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes
import com.intellij.codeInsight.editorActions.MultiCharQuoteHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.openapi.util.TextRange

// TODO
class FakerQuoteHandler : MultiCharQuoteHandler {

    override fun isOpeningQuote(iterator: HighlighterIterator, offset: Int): Boolean {
        val tokenType = iterator.tokenType
        return OPENING_QUOTES.any { it == tokenType }
    }

    override fun isClosingQuote(iterator: HighlighterIterator, offset: Int): Boolean {
        val tokenType = iterator.tokenType
        return CLOSING_QUOTES.any { it == tokenType }
    }

    override fun hasNonClosedLiteral(editor: Editor, iterator: HighlighterIterator, offset: Int): Boolean = true

    override fun isInsideLiteral(iterator: HighlighterIterator): Boolean = false

    override fun getClosingQuote(iterator: HighlighterIterator, offset: Int): CharSequence? {
        if (offset >= 2) {
            val quote = iterator.document.getText(TextRange(offset - 2, offset))
            if (quote == "''") return quote
        }
        return null
    }

    companion object {
        private val OPENING_QUOTES = arrayOf(FakerTypes.PARAM_BEGIN, FakerTypes.PARAM_DOUBLE_QUOTE_BEGIN)
        private val CLOSING_QUOTES = arrayOf(FakerTypes.PARAM_END, FakerTypes.PARAM_DOUBLE_QUOTE_END)
    }
}