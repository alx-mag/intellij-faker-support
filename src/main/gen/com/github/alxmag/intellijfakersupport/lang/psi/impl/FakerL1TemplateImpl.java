// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi.impl;

import com.github.alxmag.intellijfakersupport.lang.psi.FakerL1Expression;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerL1Template;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerVisitor;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FakerL1TemplateImpl extends FakerTemplateImpl implements FakerL1Template {

  public FakerL1TemplateImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull FakerVisitor visitor) {
    visitor.visitL1Template(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FakerVisitor) accept((FakerVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FakerL1Expression> getExpressions() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FakerL1Expression.class);
  }

}
