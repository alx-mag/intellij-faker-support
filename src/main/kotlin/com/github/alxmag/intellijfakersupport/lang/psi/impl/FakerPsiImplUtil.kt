package com.github.alxmag.intellijfakersupport.lang.psi.impl

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionName
import com.github.alxmag.intellijfakersupport.lang.psi.FakerL1Param

object FakerPsiImplUtil {

    @JvmStatic
    fun getFunctionName(functionName: FakerFunctionName): String {
        return functionName.children.joinToString("") { element -> element.node.text }
    }

    fun isLiteralParam(fakerL1Param: FakerL1Param): Boolean = fakerL1Param.l2ExpressionList.isEmpty()
}