// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi.impl;

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionName;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class FakerFunctionNameImpl extends ASTWrapperPsiElement implements FakerFunctionName {

  public FakerFunctionNameImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FakerVisitor visitor) {
    visitor.visitFunctionName(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FakerVisitor) accept((FakerVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public String getFunctionName() {
    return FakerPsiImplUtil.getFunctionName(this);
  }

}
