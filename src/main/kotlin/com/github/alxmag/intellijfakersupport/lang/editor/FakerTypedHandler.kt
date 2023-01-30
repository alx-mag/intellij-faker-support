package com.github.alxmag.intellijfakersupport.lang.editor

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFile
import com.intellij.codeInsight.CodeInsightSettings
import com.intellij.codeInsight.editorActions.TypedHandlerDelegate
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile

class FakerTypedHandler : TypedHandlerDelegate() {
    override fun charTyped(c: Char, project: Project, editor: Editor, file: PsiFile): Result {
        if (file is FakerFile) {
            processBrace(c, editor)
        }
        return super.charTyped(c, project, editor, file)
    }

    // Complete '#{' to '#{}'
    private fun processBrace(c: Char, editor: Editor) {
        if (!CodeInsightSettings.getInstance().AUTOINSERT_PAIR_BRACKET) return
        if (c == '{') {
            val caretOffset = editor.caretModel.offset
            // The typed brace is the very first char of the file
            if (caretOffset <= 1) return

            val document = editor.document
            // Check if brace typed after '#'
            val isBeforeHash = document.getText(TextRange(caretOffset - 2, caretOffset - 1)) == "#"
            if (isBeforeHash) {
                document.insertString(caretOffset, "}")
            }
        }
    }
}

