package com.github.alxmag.intellijfakersupport.util

import com.github.alxmag.intellijfakersupport.lang.reference.FakerExpressionUtil
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifier

fun PsiMethod.isObjectMethod() = this.name in FakerExpressionUtil.ObjectMethods

fun PsiMethod.isPublic() = modifierList.hasModifierProperty(PsiModifier.PUBLIC)

fun PsiMethod.isNonStatic() = !modifierList.hasModifierProperty(PsiModifier.STATIC)

fun PsiMethod.hasNoArgs() = this.parameterList.parameters.isEmpty()