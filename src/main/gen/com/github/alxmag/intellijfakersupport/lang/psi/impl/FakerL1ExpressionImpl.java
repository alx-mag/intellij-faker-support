// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi.impl;

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionName;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerL1Expression;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerL1ParamList;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
  @Nullable
  public PsiElement getParamsListSeparator() {
    return findChildByType(PARAMS_LIST_SEPARATOR);
  }

  @Override
  @Nullable
  public FakerL1ParamList getParamList() {
    return findChildByClass(FakerL1ParamList.class);
  }

  @Override
  @NotNull
  public String getParamQuoteSymbol() {
    return FakerPsiImplUtil.getParamQuoteSymbol(this);
  }

}
