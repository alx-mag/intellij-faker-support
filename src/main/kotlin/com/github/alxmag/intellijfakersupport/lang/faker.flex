// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.alxmag.intellijfakersupport.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes;
import com.intellij.psi.TokenType;

%%

%class FakerLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]

IDENTIFIER=[:jletter:] [:jletterdigit:]*

%state IN_PARAM
%state IN_FUNCTION_ARGS
%state IN_EXPRESSION
%state IN_PARAM_EXPRESSION

%%

<YYINITIAL>
{
    ~"#{"            {
                       yypushback(2);
                       yybegin(IN_EXPRESSION);
                       return FakerTypes.REGULAR_STRING_PART;
                     }
    !([^]*"#{"[^]*)  { return FakerTypes.REGULAR_STRING_PART; }
}

<IN_EXPRESSION>
{
    "#{"            { return FakerTypes.EXPRESSION_LBRACE; }
    {IDENTIFIER}    { return FakerTypes.IDENTIFIER; }
    \.              { return FakerTypes.DOT; }
    "}"             {
                      yybegin(YYINITIAL);
                      return FakerTypes.EXPRESSION_RBRACE;
                    }
    {WHITE_SPACE}+  {
                      yybegin(IN_FUNCTION_ARGS);
                      return FakerTypes.PARAMS_LIST_BEGIN;
                    }
}

<IN_FUNCTION_ARGS>
{
    "'"  {
           yybegin(IN_PARAM);
           return FakerTypes.PARAM_BEGIN;
         }
    "}"  {
           yybegin(YYINITIAL);
           return FakerTypes.EXPRESSION_RBRACE;
         }
}

<IN_PARAM>
{
    "'"               {
                        yybegin(IN_FUNCTION_ARGS);
                        return FakerTypes.PARAM_END;
                      }
    "#{"              {
                        yybegin(IN_PARAM_EXPRESSION);
                        return FakerTypes.EXPRESSION_LBRACE;
                      }
//    !("#{")  { return FakerTypes.REGULAR_STRING_PART; }
    (#[^{#']) | [^\']  { return FakerTypes.REGULAR_STRING_PART; }
}

<IN_PARAM_EXPRESSION>
{
    "}"           {
                    yybegin(IN_PARAM);
                    return FakerTypes.EXPRESSION_RBRACE;
                  }
    {IDENTIFIER}  { return FakerTypes.IDENTIFIER; }
    \.            { return FakerTypes.DOT; }
}

"#"                      { return FakerTypes.REGULAR_STRING_PART; }
({CRLF}|{WHITE_SPACE})+  { return TokenType.WHITE_SPACE; }
","                      { return FakerTypes.COMMA; }
[^]                      { return TokenType.BAD_CHARACTER; }
