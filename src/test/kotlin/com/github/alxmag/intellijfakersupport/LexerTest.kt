package com.github.alxmag.intellijfakersupport

import com.github.alxmag.intellijfakersupport.lang.FakerLexerAdapter
import com.intellij.lexer.Lexer
import com.intellij.testFramework.LexerTestCase

class LexerTest : LexerTestCase() {
    override fun createLexer(): Lexer = FakerLexerAdapter()
    //    override fun createLexer(): Lexer = FakerFlexLexer()
    override fun getDirPath(): String  = throw UnsupportedOperationException()


    fun testValidCasesTemplate() = doTest(
        "my#regular @## #str,r,ing#{ident1.ident2 'foo', 'bar', '##{expr}', '#{expr2}'}#",
        """Regular String Part ('my#regular @## #str,r,ing')
          |Expression lbrace ('#{')
          |Identifier ('ident1')
          |. ('.')
          |Identifier ('ident2')
          |Params list begin (' ')
          |Param begin (''')
          |Regular String Part ('foo')
          |Param end (''')
          |, (',')
          |WHITE_SPACE (' ')
          |Param begin (''')
          |Regular String Part ('bar')
          |Param end (''')
          |, (',')
          |WHITE_SPACE (' ')
          |Param begin (''')
          |Regular String Part ('#')
          |Expression lbrace ('#{')
          |Identifier ('expr')
          |Expression rbrace ('}')
          |Param end (''')
          |, (',')
          |WHITE_SPACE (' ')
          |Param begin (''')
          |Expression lbrace ('#{')
          |Identifier ('expr2')
          |Expression rbrace ('}')
          |Param end (''')
          |Expression rbrace ('}')
          |Regular String Part ('#')""".trimMargin()
    )

    fun testOnlyRegularStrings() = doTest(
        "my#regular @## #str,r,ing# ,",
        """Regular String Part ('my#regular @## #str,r,ing# ,')""".trimMargin()
    )

    fun testUnclosedExpression() = doTest(
        "foo#{bar",
        """Regular String Part ('foo')
          |Expression lbrace ('#{')
          |Identifier ('bar')""".trimMargin()
    )

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
}