// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface FakerL1Expression extends PsiElement {

  @Nullable
  FakerFunctionName getFunctionName();

  @NotNull
  List<FakerL1Param> getL1ParamList();

  @Nullable
  PsiElement getParamsListSeparator();

}