// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi.impl;

import com.github.alxmag.intellijfakersupport.lang.psi.FakerContent;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerL1Param;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerL2Expression;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FakerL1ParamImpl extends ASTWrapperPsiElement implements FakerL1Param {

  public FakerL1ParamImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FakerVisitor visitor) {
    visitor.visitL1Param(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FakerVisitor) accept((FakerVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FakerContent> getContentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FakerContent.class);
  }

  @Override
  @NotNull
  public List<FakerL2Expression> getL2ExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FakerL2Expression.class);
  }

}
