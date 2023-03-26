package com.github.alxmag.intellijfakersupport.lang.parameter

import com.github.alxmag.intellijfakersupport.lang.psi.FakerExpression
import com.github.alxmag.intellijfakersupport.lang.psi.FakerParametrizedExpression
import com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes
import com.github.alxmag.intellijfakersupport.lang.reference.isFakerApiMethod
import com.github.alxmag.intellijfakersupport.lang.reference.resolveFunctionCallInfo
import com.intellij.codeInsight.hint.api.impls.MethodParameterInfoHandler
import com.intellij.lang.parameterInfo.*
import com.intellij.psi.PsiMethod
import com.intellij.psi.util.parentOfType
import com.intellij.refactoring.suggested.endOffset

class FakerParameterInfoHandler : ParameterInfoHandler<FakerExpression, PsiMethod> {
    override fun findElementForParameterInfo(context: CreateParameterInfoContext): FakerExpression? {
        val expression = context.findExpression() ?: return null
        val lastSegment = expression.getFunctionName()
            ?.segments
            ?.lastOrNull()
        context.itemsToShow = lastSegment?.resolveFunctionCallInfo()
            ?.resolveMethods()
            ?.filter { it.isFakerApiMethod() }
            ?.toTypedArray()
        return expression
    }

    override fun findElementForUpdatingParameterInfo(context: UpdateParameterInfoContext): FakerExpression? {
        val element = context.file.findElementAt(context.offset) ?: return null
        val expression = element.parentOfType<FakerExpression>() ?: return null

        val paramList = (expression as? FakerParametrizedExpression)?.getParamList()
        if (paramList != null) {
            val offset = context.offset
            val expressionRange = expression.textRange
            var paramIndex = -1
            if (offset > expressionRange.startOffset && offset < expressionRange.endOffset) {
                paramIndex = ParameterInfoUtils.getCurrentParameterIndex(paramList.node, offset, FakerTypes.COMMA)
            }

            context.setCurrentParameter(paramIndex)
        }
        return expression
    }

    override fun updateUI(method: PsiMethod, context: ParameterInfoUIContext) {
        MethodParameterInfoHandler.updateMethodPresentation(method, null, context)
    }

    override fun updateParameterInfo(parameterOwner: FakerExpression, context: UpdateParameterInfoContext) {
        context.parameterOwner = parameterOwner
    }

    override fun showParameterInfo(element: FakerExpression, context: CreateParameterInfoContext) {
        val offset = element.getFunctionName()?.endOffset ?: -1
        context.showHint(element, offset, this)
    }

    private fun ParameterInfoContext.findExpression(): FakerExpression? {
        val element = this.file.findElementAt(this.offset)
        val expression = element?.parentOfType<FakerExpression>(true)
        return expression as? FakerParametrizedExpression
    }
}