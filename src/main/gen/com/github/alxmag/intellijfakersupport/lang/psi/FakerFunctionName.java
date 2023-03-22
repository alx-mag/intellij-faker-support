// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface FakerFunctionName extends PsiElement {

  @NotNull
  String getFunctionName();

  @NotNull
  List<FakerFunctionNameSegment> getSegments();

}
