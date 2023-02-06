package com.github.alxmag.intellijfakersupport.lang.editor

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFile
import com.github.alxmag.intellijfakersupport.lang.psi.FakerL2Expression
import com.intellij.codeInsight.CodeInsightSettings
import com.intellij.codeInsight.editorActions.TypedHandlerDelegate
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFile
import com.intellij.psi.util.parentOfType

class FakerTypedHandler : TypedHandlerDelegate() {
    override fun charTyped(c: Char, project: Project, editor: Editor, file: PsiFile): Result {
        if (file is FakerFile) {
            processBrace(c, editor) || processDoubleQuote(c, project, editor, file)
        }
        return super.charTyped(c, project, editor, file)
    }

    // Complete '#{' to '#{}'
    private fun processBrace(c: Char, editor: Editor): Boolean {
        if (c != '{') return false
        if (!CodeInsightSettings.getInstance().AUTOINSERT_PAIR_BRACKET) return false

        val caretOffset = editor.caretModel.offset
        // The typed brace is the very first char of the file
        if (caretOffset <= 1) return false

        val document = editor.document
        // Check if brace typed after '#'
        val isBeforeHash = document.getText(TextRange(caretOffset - 2, caretOffset - 1)) == "#"
        if (!isBeforeHash) {
            return false
        }

        document.insertString(caretOffset, "}")
        return true
    }

    // TODO does not reached if "'" typed.
    //  Seems this char intercepted by Quote handler ignoring this class.
    //  So this logic should be implemented there.
    private fun processDoubleQuote(c: Char, project: Project, editor: Editor, file: PsiFile): Boolean {
        if (c != '\'') return false

        val document = editor.document
        PsiDocumentManager.getInstance(project).commitDocument(document)
        val offset = editor.caretModel.offset
        val inL2Expression = file.findElementAt(offset)
            ?.parentOfType<FakerL2Expression>(true) != null
        if (!inL2Expression) {
            return false
        }

        document.insertString(offset, "'")
        return true
    }
}

