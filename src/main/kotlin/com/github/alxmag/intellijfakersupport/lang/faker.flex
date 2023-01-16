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

%state IN_FUNCTION_NAME
%state IN_PARAM
%state IN_FUNCTION_ARGS
%state IN_EXPRESSION

%%

<YYINITIAL> {
  {IDENTIFIER}             { yybegin(IN_FUNCTION_NAME); return FakerTypes.IDENTIFIER; }
}

<IN_FUNCTION_NAME> {
   {WHITE_SPACE}+  { yybegin(IN_FUNCTION_ARGS); return FakerTypes.PARAMS_LIST_BEGIN; }
   "\."            { return FakerTypes.DOT; }
   {IDENTIFIER}    { return FakerTypes.IDENTIFIER; }
}

<IN_FUNCTION_ARGS> {
    "\'"  { yybegin(IN_PARAM); return FakerTypes.PARAM_BEGIN; }
}

<IN_PARAM> {
    "\'"        { yybegin(IN_FUNCTION_ARGS); return FakerTypes.PARAM_END; }
    "#{"        { yybegin(IN_EXPRESSION); return FakerTypes.EXPRESSION_LBRACE; }
//    {mNUM_INT}  { return FakerTypes.INT_LITERAL; }
    [^\']       { return FakerTypes.STRING_LITERAL; }
//    .           { return FakerTypes.STRING_LITERAL; }
}

<IN_EXPRESSION> {
    "}"           { yybegin(IN_PARAM); return FakerTypes.EXPRESSION_RBRACE; }
    "\."          { return FakerTypes.DOT; }
    {IDENTIFIER}  { return FakerTypes.IDENTIFIER; }
}

({CRLF}|{WHITE_SPACE})+  { return TokenType.WHITE_SPACE; }
","                      { return FakerTypes.COMMA; }
[^]                      { return TokenType.BAD_CHARACTER; }