package com.github.alxmag.intellijfakersupport.lang.psi

import com.github.alxmag.intellijfakersupport.lang.FakerLanguage
import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class FakerFileType : LanguageFileType(FakerLanguage) {
    override fun getName(): String = "Faker Template File"

    override fun getDescription(): String = "Faker template file"

    override fun getDefaultExtension(): String = "faker"

    override fun getIcon(): Icon = AllIcons.Actions.PrettyPrint

    companion object {
        @Suppress("unused")
        val INSTANCE = FakerFileType()
    }
}