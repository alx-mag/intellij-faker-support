package com.github.alxmag.intellijfakersupport

import com.github.alxmag.intellijfakersupport.lang.FakerLexerAdapter
import com.intellij.lexer.Lexer
import com.intellij.testFramework.LexerTestCase
import com.intellij.testFramework.TestDataPath

@TestDataPath("\$CONTENT_ROOT/testData")
class LexerTest : LexerTestCase() {
    override fun createLexer(): Lexer = FakerLexerAdapter()

    override fun getDirPath(): String = "lexer"

    fun getTestDataPath(): String = "test-data"

    override fun getPathToTestDataFile(extension: String?): String {
        return getTestDataPath() + "/" + dirPath + "/" + super.getTestName(true) + extension
    }

    fun testOnlyRegularText() {
        doFileTest("faker")
    }
}