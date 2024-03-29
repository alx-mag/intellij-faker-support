package com.github.alxmag.intellijfakersupport.lang.editor

import com.github.alxmag.intellijfakersupport.lang.psi.FakerFileType
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class FakerTypedHandlerTest : BasePlatformTestCase() {

    fun testQuoteAfterFunctionName() = doQuoteTest(
        "#{foo <caret>}",
        "#{foo '<caret>'}"
    )

    fun testQuoteInRegularString() = doQuoteTest(
        "my<caret>Text#{foo}",
        "my'<caret>Text#{foo}"
    )

    fun testBraceAfterHash() = doBraceTest(
        "text#<caret>",
        "text#{<caret>}"
    )

    fun `test Brace at Start of the String`() = doBraceTest(
        "<caret>",
        "{<caret>"
    )

    private fun doQuoteTest(before: String, after: String) = doTypeTest("'", before, after)
    private fun doBraceTest(before: String, after: String) = doTypeTest("{", before, after)

    private fun doTypeTest(type: String, before: String, after: String) {
        myFixture.configureByText(FakerFileType.INSTANCE, before)
        myFixture.type(type)
        myFixture.checkResult(after)
    }
}