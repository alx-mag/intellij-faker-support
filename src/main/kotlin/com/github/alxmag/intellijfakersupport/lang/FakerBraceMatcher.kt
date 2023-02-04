package com.github.alxmag.intellijfakersupport.lang

import com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class FakerBraceMatcher : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = PAIRS

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean = true

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset

    companion object {
        val PAIRS = arrayOf(
            BracePair(FakerTypes.EXPRESSION_LBRACE, FakerTypes.EXPRESSION_RBRACE, true)
        )
    }
}