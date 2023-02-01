package com.github.alxmag.intellijfakersupport.lang.codeinsight

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFileType
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class FakerCompletionContributorTest : BasePlatformTestCase() {

    fun testPattern() {
        myFixture.configureByText(FakerFileType.INSTANCE, "foo#{<caret>}")
        val element = myFixture.elementAtCaret
        println(element)
    }
}