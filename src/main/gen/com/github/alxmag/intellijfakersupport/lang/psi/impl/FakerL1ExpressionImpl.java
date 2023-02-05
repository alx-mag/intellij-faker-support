// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi.impl;

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionName;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerL1Expression;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerL1Param;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes.PARAMS_LIST_SEPARATOR;

public class FakerL1ExpressionImpl extends ASTWrapperPsiElement implements FakerL1Expression {

  public FakerL1ExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FakerVisitor visitor) {
    visitor.visitL1Expression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FakerVisitor) accept((FakerVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FakerFunctionName getFunctionName() {
    return findChildByClass(FakerFunctionName.class);
  }

  @Override
  @NotNull
  public List<FakerL1Param> getL1ParamList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FakerL1Param.class);
  }

  @Override
  @Nullable
  public PsiElement getParamsListSeparator() {
    return findChildByType(PARAMS_LIST_SEPARATOR);
  }

}
