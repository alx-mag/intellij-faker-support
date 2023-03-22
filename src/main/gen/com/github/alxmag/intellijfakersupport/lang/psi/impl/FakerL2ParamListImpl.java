// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi.impl;

import com.github.alxmag.intellijfakersupport.lang.psi.FakerL2Param;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerL2ParamList;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerVisitor;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FakerL2ParamListImpl extends FakerParamListImpl implements FakerL2ParamList {

  public FakerL2ParamListImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull FakerVisitor visitor) {
    visitor.visitL2ParamList(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FakerVisitor) accept((FakerVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FakerL2Param> getL2ParamList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FakerL2Param.class);
  }

}
