package com.github.alxmag.intellijfakersupport.lang.parsing

import com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType

class FakerParser : PsiParser {
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()
        while (!builder.eof()) {
            val tokenType = builder.tokenType ?: break
            when (tokenType) {
                FakerTypes.REGULAR_STRING_PART -> {
                    val regularString = builder.mark()
                    builder.advanceLexer()
                    regularString.done(FakerTypes.REGULAR_STRING_PART)
                }
                FakerTypes.EXPRESSION_LBRACE -> {
                    val expressionLBrace = builder.mark()
                    builder.advanceLexer()
                    expressionLBrace.done(FakerTypes.EXPRESSION_LBRACE)
                }
                FakerTypes.EXPRESSION_RBRACE -> {
                    val expressionRBrace = builder.mark()
                    builder.advanceLexer()
                    expressionRBrace.done(FakerTypes.EXPRESSION_RBRACE)
                }
                else -> {
                    builder.advanceLexer()
                    //TODO
                    builder.error("My error")
                }
            }
        }
        rootMarker.done(FakerTypes.CONTENT)
        return builder.treeBuilt
    }
}