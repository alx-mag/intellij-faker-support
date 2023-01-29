package com.github.alxmag.intellijfakersupport.lang

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFile
import com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class FakerParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?): Lexer = FakerLexerAdapter()
    override fun createParser(project: Project?): PsiParser = FakerParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = TokenSet.EMPTY

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode): PsiElement {
        return FakerTypes.Factory.createElement(node)

//        return when (node.elementType) {
//            FakerTypes.EXPRESSION_LBRACE -> FakerExpressionLBrace(node)
//            FakerTypes.EXPRESSION_RBRACE -> FakerExpressionRBrace(node)
//            FakerTypes.REGULAR_STRING_PART -> FakerString(node)
//            else -> throw AssertionError("Unknown type: " + node.elementType)
//        }
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile = FakerFile(viewProvider)
    companion object {
        val FILE = IFileElementType(FakerLanguage)
    }
}