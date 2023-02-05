// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi.impl;

import com.github.alxmag.intellijfakersupport.lang.psi.FakerL2Param;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerL3Expression;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FakerL2ParamImpl extends ASTWrapperPsiElement implements FakerL2Param {

  public FakerL2ParamImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FakerVisitor visitor) {
    visitor.visitL2Param(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FakerVisitor) accept((FakerVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FakerL3Expression> getL3ExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FakerL3Expression.class);
  }

}
