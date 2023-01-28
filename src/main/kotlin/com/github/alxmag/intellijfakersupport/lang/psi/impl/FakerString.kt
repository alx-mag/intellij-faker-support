package com.github.alxmag.intellijfakersupport.lang.psi.impl

import com.github.alxmag.intellijfakersupport.lang.psi.FakerElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

class FakerString(node: ASTNode) : ASTWrapperPsiElement(node), FakerElement {
}

class FakerExpressionLBrace(node: ASTNode) : ASTWrapperPsiElement(node), FakerElement
class FakerExpressionRBrace(node: ASTNode) : ASTWrapperPsiElement(node), FakerElement