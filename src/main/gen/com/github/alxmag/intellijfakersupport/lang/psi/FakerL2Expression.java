// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface FakerL2Expression extends FakerExpression {

  @Nullable
  FakerFunctionName getFunctionName();

  @Nullable
  PsiElement getParamsListSeparator();

  @NotNull
  List<FakerL2Param> getParams();

}
