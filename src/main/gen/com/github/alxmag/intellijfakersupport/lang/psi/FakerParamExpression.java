// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface FakerParamExpression extends FakerParamStatement {

  @Nullable
  FakerFunctionName getFunctionName();

  @Nullable
  FakerNestedExpressionParamsList getNestedExpressionParamsList();

  @Nullable
  PsiElement getParamsListBegin();

}
