package com.github.alxmag.intellijfakersupport.lang.psi.impl

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionName
import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionNameSegment
import com.github.alxmag.intellijfakersupport.lang.reference.FakerIdentifierReference
import com.intellij.psi.PsiReference

object FakerPsiImplUtil {

    @JvmStatic
    fun getFunctionName(functionName: FakerFunctionName): String {
        return functionName.segments.joinToString(".") { element -> element.text }
    }

    @JvmStatic
    fun getReference(functionNameSegment: FakerFunctionNameSegment): PsiReference {
        return FakerIdentifierReference(functionNameSegment)
    }
}