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

  public void visitParam(@NotNull FakerParam o) {
    visitPsiElement(o);
  }

  public void visitParamExpression(@NotNull FakerParamExpression o) {
    visitParam(o);
  }

  public void visitParamLiteral(@NotNull FakerParamLiteral o) {
    visitParam(o);
  }

  public void visitRegularString(@NotNull FakerRegularString o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
