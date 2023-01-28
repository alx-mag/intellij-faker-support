package com.github.alxmag.intellijfakersupport

import com.github.alxmag.intellijfakersupport.lang.FakerLexerAdapter
import com.intellij.lexer.Lexer
import com.intellij.testFramework.LexerTestCase
import com.intellij.testFramework.TestDataPath

@TestDataPath("\$CONTENT_ROOT/testData")
class LexerTest : LexerTestCase() {
    override fun createLexer(): Lexer = FakerLexerAdapter()
//    override fun createLexer(): Lexer = FakerFlexLexer()

    override fun getDirPath(): String = "lexer"

    private fun getTestDataPath(): String = "test-data"

    override fun getPathToTestDataFile(extension: String?): String {
        return getTestDataPath() + "/" + dirPath + "/" + super.getTestName(true) + extension
    }

    fun testValidCasesTemplate() = doFileTest()

    fun testOnlyRegularStrings() = doFileTest()

    fun testUnclosedExpression() = doFileTest()

    fun testTwoLBraces() = doTest(
        "foo#{#{",
        """Regular String Part ('foo')
          |Expression lbrace ('#{')
          |Expression lbrace ('#{')""".trimMargin()
    )

    fun testLBraceThenRegularString() = doTest(
        "foo#{123",
        """Regular String Part ('foo')
          |Expression lbrace ('#{')
          |BAD_CHARACTER ('1')
          |BAD_CHARACTER ('2')
          |BAD_CHARACTER ('3')""".trimMargin()
    )

    fun testBadIdentifier() = doTest(
        "foo#{1}",
        """Regular String Part ('foo')
          |Expression lbrace ('#{')
          |BAD_CHARACTER ('1')
          |Expression rbrace ('}')""".trimMargin()
    )

    // TODO
//    fun testNoSpaceBeforeArgs() = doTest(
//        "#{json'foo','bar'}",
//        """"""
//    )

    private fun doFileTest() = doFileTest("faker")
}