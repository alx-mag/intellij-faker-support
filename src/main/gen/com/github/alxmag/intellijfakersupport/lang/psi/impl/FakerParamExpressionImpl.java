// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi.impl;

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionName;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerNestedExpressionParamsList;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerParamExpression;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerVisitor;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes.PARAMS_LIST_BEGIN;

public class FakerParamExpressionImpl extends FakerParamStatementImpl implements FakerParamExpression {

  public FakerParamExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull FakerVisitor visitor) {
    visitor.visitParamExpression(this);
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
  public FakerNestedExpressionParamsList getNestedExpressionParamsList() {
    return findChildByClass(FakerNestedExpressionParamsList.class);
  }

  @Override
  @Nullable
  public PsiElement getParamsListBegin() {
    return findChildByType(PARAMS_LIST_BEGIN);
  }

}
