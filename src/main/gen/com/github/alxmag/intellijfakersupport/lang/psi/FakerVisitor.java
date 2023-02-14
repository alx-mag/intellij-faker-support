// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class FakerVisitor extends PsiElementVisitor {

  public void visitExpression(@NotNull FakerExpression o) {
    visitPsiElement(o);
  }

  public void visitFunctionName(@NotNull FakerFunctionName o) {
    visitPsiElement(o);
  }

  public void visitFunctionNameSegment(@NotNull FakerFunctionNameSegment o) {
    visitPsiElement(o);
  }

  public void visitL1Expression(@NotNull FakerL1Expression o) {
    visitExpression(o);
  }

  public void visitL1Param(@NotNull FakerL1Param o) {
    visitPsiElement(o);
  }

  public void visitL1Template(@NotNull FakerL1Template o) {
    visitTemplate(o);
  }

  public void visitL2Expression(@NotNull FakerL2Expression o) {
    visitExpression(o);
  }

  public void visitL2Param(@NotNull FakerL2Param o) {
    visitPsiElement(o);
  }

  public void visitL2Template(@NotNull FakerL2Template o) {
    visitTemplate(o);
  }

  public void visitL3Expression(@NotNull FakerL3Expression o) {
    visitExpression(o);
  }

  public void visitL3Template(@NotNull FakerL3Template o) {
    visitTemplate(o);
  }

  public void visitTemplate(@NotNull FakerTemplate o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
