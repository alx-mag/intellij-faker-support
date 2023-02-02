// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi.impl;

import com.github.alxmag.intellijfakersupport.lang.psi.FakerNestedExpressionParamsList;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerNestedParam;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FakerNestedExpressionParamsListImpl extends ASTWrapperPsiElement implements FakerNestedExpressionParamsList {

  public FakerNestedExpressionParamsListImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FakerVisitor visitor) {
    visitor.visitNestedExpressionParamsList(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FakerVisitor) accept((FakerVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FakerNestedParam> getNestedParamList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FakerNestedParam.class);
  }

}
