package com.github.alxmag.intellijfakersupport.lang.psi.impl

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionName

object FakerPsiImplUtil {

    @JvmStatic
    fun getFunctionName(functionName: FakerFunctionName): String {
        return functionName.children.joinToString("") { element -> element.node.text }
    }
}