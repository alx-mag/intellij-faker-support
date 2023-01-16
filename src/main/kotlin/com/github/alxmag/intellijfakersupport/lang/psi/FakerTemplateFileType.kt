package com.github.alxmag.intellijfakersupport.lang.psi

import com.github.alxmag.intellijfakersupport.lang.FakerTemplateLanguage
import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class FakerTemplateFileType : LanguageFileType(FakerTemplateLanguage) {
    override fun getName(): String = "Faker Template File"

    override fun getDescription(): String = "Faker template file"

    override fun getDefaultExtension(): String = "faker"

    override fun getIcon(): Icon? = AllIcons.Actions.PrettyPrint

    companion object {
        val INSTANCE = FakerTemplateFileType()
    }
}