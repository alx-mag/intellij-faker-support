// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface FakerExpression extends PsiElement {

  @Nullable
  FakerExpressionParamsList getExpressionParamsList();

  @Nullable
  FakerFunctionName getFunctionName();

  @Nullable
  PsiElement getParamsListBegin();

}
