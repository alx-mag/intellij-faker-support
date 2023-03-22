// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi;

import com.github.alxmag.intellijfakersupport.lang.psi.impl.FakerParametrizedExpression;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface FakerL1Expression extends FakerParametrizedExpression {

  @Nullable
  FakerFunctionName getFunctionName();

  @Nullable
  PsiElement getParamsListSeparator();

  @Nullable
  FakerL1ParamList getParamList();

  @NotNull
  String getParamQuoteSymbol();

}
