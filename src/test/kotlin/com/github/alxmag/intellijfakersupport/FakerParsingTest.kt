package com.github.alxmag.intellijfakersupport

import com.github.alxmag.intellijfakersupport.lang.FakerParserDefinition
import com.intellij.testFramework.ParsingTestCase
import com.intellij.testFramework.TestDataPath

@TestDataPath("\$CONTENT_ROOT/testData/parsing")
class FakerParsingTest : ParsingTestCase("parsing", "faker", true, FakerParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/testData"

    fun testRegularStringOnly() = doTest(true)

    fun testStringExprString() = doTest(true)

    fun testOnlyExpr() = doTest(true)

    fun testDoubleExpr() = doTest(true)

    fun testExprWithStringArg() = doTest(true)

    fun testExprWith2Args() = doTest(true)

    fun testExprWithEmptyStringArg() = doTest(true)
}