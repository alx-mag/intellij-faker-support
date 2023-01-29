// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi.impl;

import com.github.alxmag.intellijfakersupport.lang.psi.FakerParamLiteral;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerVisitor;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes.REGULAR_STRING_PART;

public class FakerParamLiteralImpl extends FakerParamStatementImpl implements FakerParamLiteral {

  public FakerParamLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull FakerVisitor visitor) {
    visitor.visitParamLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FakerVisitor) accept((FakerVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getRegularStringPart() {
    return findChildByType(REGULAR_STRING_PART);
  }

}
