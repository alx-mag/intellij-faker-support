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
        """REGULAR_STRING_PART ('my#regular @## #str,r,ing')
          |#{ ('#{')
          |IDENTIFIER ('ident1')
          |. ('.')
          |IDENTIFIER ('ident2')
          |PARAMS_LIST_BEGIN (' ')
          |PARAM_BEGIN (''')
          |REGULAR_STRING_PART ('foo')
          |PARAM_END (''')
          |, (',')
          |WHITE_SPACE (' ')
          |PARAM_BEGIN (''')
          |REGULAR_STRING_PART ('bar')
          |PARAM_END (''')
          |, (',')
          |WHITE_SPACE (' ')
          |PARAM_BEGIN (''')
          |REGULAR_STRING_PART ('#')
          |#{ ('#{')
          |IDENTIFIER ('expr')
          |} ('}')
          |PARAM_END (''')
          |, (',')
          |WHITE_SPACE (' ')
          |PARAM_BEGIN (''')
          |#{ ('#{')
          |IDENTIFIER ('expr2')
          |} ('}')
          |PARAM_END (''')
          |} ('}')
          |REGULAR_STRING_PART ('#')""".trimMargin()
    )

    fun testOnlyRegularStrings() = doTest(
        "my#regular @## #str,r,ing# ,",
        "REGULAR_STRING_PART ('my#regular @## #str,r,ing# ,')"
    )

    fun testUnclosedExpression() = doTest(
        "foo#{bar",
        """REGULAR_STRING_PART ('foo')
          |#{ ('#{')
          |IDENTIFIER ('bar')""".trimMargin()
    )

    fun testTwoLBraces() = doTest(
        "foo#{#{",
        """REGULAR_STRING_PART ('foo')
          |#{ ('#{')
          |#{ ('#{')""".trimMargin()
    )

    fun testLBraceThenRegularString() = doTest(
        "foo#{123",
        """REGULAR_STRING_PART ('foo')
          |#{ ('#{')
          |BAD_CHARACTER ('1')
          |BAD_CHARACTER ('2')
          |BAD_CHARACTER ('3')""".trimMargin()
    )

    fun testBadIdentifier() = doTest(
        "foo#{1}",
        """REGULAR_STRING_PART ('foo')
          |#{ ('#{')
          |BAD_CHARACTER ('1')
          |} ('}')""".trimMargin()
    )

    fun testHashesAsParams() = doTest(
        "#{bothify '###'}",
        """REGULAR_STRING_PART ('')
                   |#{ ('#{')
                   |IDENTIFIER ('bothify')
                   |PARAMS_LIST_BEGIN (' ')
                   |PARAM_BEGIN (''')
                   |REGULAR_STRING_PART ('###')
                   |PARAM_END (''')
                   |} ('}')""".trimMargin()
    )

    // TODO
//    fun testNoSpaceBeforeArgs() = doTest(
//        "#{json'foo','bar'}",
//        """"""
//    )
}