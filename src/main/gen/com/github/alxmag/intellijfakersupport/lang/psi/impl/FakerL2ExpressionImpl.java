// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi.impl;

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionName;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerL2Expression;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerL2ParamsList;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes.PARAMS_LIST_SEPARATOR;

public class FakerL2ExpressionImpl extends ASTWrapperPsiElement implements FakerL2Expression {

  public FakerL2ExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FakerVisitor visitor) {
    visitor.visitL2Expression(this);
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
  public FakerL2ParamsList getL2ParamsList() {
    return findChildByClass(FakerL2ParamsList.class);
  }

  @Override
  @Nullable
  public PsiElement getParamsListSeparator() {
    return findChildByType(PARAMS_LIST_SEPARATOR);
  }

}
