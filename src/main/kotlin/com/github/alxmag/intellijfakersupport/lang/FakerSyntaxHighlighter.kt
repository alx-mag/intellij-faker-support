package com.github.alxmag.intellijfakersupport.lang

import com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class FakerSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer = FakerLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> = when (tokenType) {
        FakerTypes.IDENTIFIER -> IDENTIFIER_KEYS
        FakerTypes.PARAM_BEGIN, FakerTypes.PARAM_END -> PARAM_QUOTE_KEYS

        FakerTypes.DOT -> DOT_KEYS
        FakerTypes.COMMA -> COMMA_KEYS

        FakerTypes.STRING_LITERAL, FakerTypes.REGULAR_STRING_PART -> STRING_LITERAL_KEYS
        FakerTypes.INT_LITERAL -> NUMBER_LITERAL_KEYS

        FakerTypes.EXPRESSION_LBRACE, FakerTypes.EXPRESSION_RBRACE -> BRACE_KEYS

        else -> EMPTY_KEYS
    }

    companion object FakerTextAttributes {
        val IDENTIFIER = createTextAttributesKey("Faker function name", DefaultLanguageHighlighterColors.KEYWORD)

        val DOT = createTextAttributesKey("Faker dot", DefaultLanguageHighlighterColors.DOT)
        val COMMA = createTextAttributesKey("Comma", DefaultLanguageHighlighterColors.COMMA)
        val PARAM_QUOTE = createTextAttributesKey("Faker Param Begin", DefaultLanguageHighlighterColors.STRING)

        val STRING_LITERAL = createTextAttributesKey("FAKER_LITERAL", DefaultLanguageHighlighterColors.STRING)
        val NUMBER_LITERAL = createTextAttributesKey("Faker int literal", DefaultLanguageHighlighterColors.NUMBER)

        val EXPRESSION_LBRACE =
            createTextAttributesKey("FAKER_EXPRESSION_LBRACE", DefaultLanguageHighlighterColors.BRACES)
        val EXPRESSION_RBRACE = createTextAttributesKey("FAKER_RBRACE", DefaultLanguageHighlighterColors.KEYWORD)

        val IDENTIFIER_KEYS = arrayOf(IDENTIFIER)

        val DOT_KEYS = arrayOf(DOT)
        val PARAM_QUOTE_KEYS = arrayOf(PARAM_QUOTE)
        val COMMA_KEYS = arrayOf(COMMA)

        val STRING_LITERAL_KEYS = arrayOf(STRING_LITERAL)
        val NUMBER_LITERAL_KEYS = arrayOf(NUMBER_LITERAL)

        val TEXT_KEYS = arrayOf(STRING_LITERAL)
        val BRACE_KEYS = arrayOf(EXPRESSION_RBRACE)

        val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }
}

