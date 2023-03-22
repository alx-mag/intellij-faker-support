package com.github.alxmag.intellijfakersupport.lang.parameter

import com.github.alxmag.intellijfakersupport.lang.psi.impl.FakerExpression
import com.github.alxmag.intellijfakersupport.lang.reference.resolveFunctionCallInfo
import com.github.alxmag.intellijfakersupport.util.FakerPsiUtils
import com.intellij.lang.parameterInfo.*
import com.intellij.psi.PsiMethod
import com.intellij.psi.util.parentOfType

class FakerParameterInfoHandler : ParameterInfoHandler<FakerExpression, PsiMethod> {
    override fun findElementForParameterInfo(context: CreateParameterInfoContext): FakerExpression? {
        val expression = context.findExpression() ?: return null
        val lastSegment = expression.getFunctionName()
            ?.segments
            ?.lastOrNull()
        context.itemsToShow = lastSegment?.resolveFunctionCallInfo()
            ?.resolveMethods()
        return expression
    }

    override fun findElementForUpdatingParameterInfo(context: UpdateParameterInfoContext): FakerExpression? {
        // TODO
//        val element = context.file.findElementAt(context.offset)
//        PsiTreeUtil.getParentOfType(element, FakerPar)
        return context.findExpression()
    }

    override fun updateUI(method: PsiMethod, context: ParameterInfoUIContext) {
        val parameters = method.parameterList.parameters
        val text = if (parameters.isEmpty()) {
            "<no arguments>"
        } else {
            parameters.joinToString(separator = ", ") {
                // TODO quote symbol should be taken basing on expression level
                FakerPsiUtils.createExpressionParamText(it, "'")
            }
        }
        context.setupUIComponentPresentation(
            text,
            -1,
            -1,
            false,
            false,
            true,
            context.defaultParameterColor
        )
    }

    override fun updateParameterInfo(parameterOwner: FakerExpression, context: UpdateParameterInfoContext) {
        context.parameterOwner = parameterOwner
    }

    override fun showParameterInfo(element: FakerExpression, context: CreateParameterInfoContext) {
        context.showHint(element, element.textRange.startOffset + 1, this)
    }

    private fun ParameterInfoContext.findExpression(): FakerExpression? {
        val element = this.file.findElementAt(this.offset)
        return element?.parentOfType(true)
    }
}