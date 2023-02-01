package com.github.alxmag.intellijfakersupport.lang.codeinsight

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFile
import com.github.alxmag.intellijfakersupport.lang.psi.FakerFunctionName
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext

class FakerCompletionContributor : CompletionContributor() {
    init {
        extend(CompletionType.BASIC, AFTER_TOP_LEVEL_EXPRESSION_LBRACE, FunctionNameCompletionProvider)
    }

    companion object {
        val AFTER_TOP_LEVEL_EXPRESSION_LBRACE: PsiElementPattern.Capture<PsiElement> = psiElement()
            .afterLeaf("#{")
            .withParent(FakerFunctionName::class.java)
            .withSuperParent(3, FakerFile::class.java)
    }
}

object FunctionNameCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        result.addElement(bothifyElement())
//        functions.forEach { f ->
//            result.addElement(LookupElementBuilder.create(f).bold())
//        }
    }

    fun bothifyElement(): LookupElement = createElement(
        "bothify",
        Param("template", "# - number, ? - letter")
    )

    private fun createElement(functionName: String, vararg params: Param): LookupElement {
        val tailText = " " + params.joinToString(", ") { param ->
            param.getDescription()
        }
        return LookupElementBuilder.create(functionName).bold()
            .withTailText(tailText)
            .withInsertHandler { context, item ->
                val editor = context.editor
                val caretModel = editor.caretModel

                // Put quotes for params populated with hints
                val insertion = " " + params.joinToString(", ") { it.hint.wrapWith("'") }

                // Insert text
                val caretOffset = caretModel.offset
                editor.document.insertString(caretOffset, insertion)

                if (params.isEmpty()) {
                    return@withInsertHandler
                }

                // Move caret before the first argument quote
                val afterQuoteOffset = caretOffset + insertion.indexOf("'") + 1
                caretModel.moveToOffset(afterQuoteOffset)

                // Select hint text in quoted param
                if (params.size == 1) {
                    editor.selectionModel.setSelection(afterQuoteOffset, afterQuoteOffset + insertion.length - 3)
                }
            }
    }

    data class Param(val name: String, val hint: String) {
        fun getDescription() = name.wrapWith("<", ">").wrapWith("'")
    }

    private val functions = arrayOf(
        "bothify",
        "letterify",
        "numerify",
        "csv",
        "json",
    )
}

private fun String.wrapWith(left: String, right: String = left) = left + this + right