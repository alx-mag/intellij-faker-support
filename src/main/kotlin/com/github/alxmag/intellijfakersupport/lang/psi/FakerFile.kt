package com.github.alxmag.intellijfakersupport.lang.psi

import com.github.alxmag.intellijfakersupport.lang.FakerLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class FakerFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, FakerLanguage) {
    override fun getFileType(): FileType = FakerFileType.INSTANCE
}