// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.alxmag.intellijfakersupport.lang;

import com.intellij.psi.tree.IElementType;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes;
import com.intellij.psi.TokenType;
import com.intellij.util.containers.Stack;
import com.intellij.lexer.FlexLexer;

%%

%class FakerLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
    private Stack<Integer> stack = new Stack<>();

    public void yypushState(int newState) {
      stack.push(yystate());
      yybegin(newState);
    }

    public void yypopState() {
      yybegin(stack.pop());
    }
%}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]

IDENTIFIER=[:jletter:] [:jletterdigit:]*

%state IN_PARAM
%state IN_FUNCTION_ARGS
%state IN_EXPRESSION

%state IN_NESTED_EXPRESSION
%state IN_NESTED_EXPRESSION_ARGS
%state IN_NESTED_EXPRESSION_PARAM

%%

<YYINITIAL>
{
    ~"#{"            {
                               yypushback(2);
                               yypushState(IN_EXPRESSION);
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
                      yypopState();
                      return FakerTypes.EXPRESSION_RBRACE;
                    }
    {WHITE_SPACE}+  {
                      yypushState(IN_FUNCTION_ARGS);
                      return FakerTypes.PARAMS_LIST_BEGIN;
                    }
}

<IN_FUNCTION_ARGS>
{
    "'"  {
               yypushState(IN_PARAM);
               return FakerTypes.PARAM_BEGIN;
             }
    "}"  { //Exit from function args
           yypushback(1);
           yypopState();
         }
}

<IN_PARAM>
{
    "'"                {
                         yypopState();
                         return FakerTypes.PARAM_END;
                       }
    "#{"               {
                         yypushState(IN_NESTED_EXPRESSION);
                         return FakerTypes.EXPRESSION_LBRACE;
                       }
    (#[^{#']) | [^\']  { return FakerTypes.REGULAR_STRING_PART; }
}

// #{foo '#{<here>bar ''someText''}'}
<IN_NESTED_EXPRESSION>
{
    "}"             {
                          yypopState();
                          return FakerTypes.EXPRESSION_RBRACE;
                    }
    {IDENTIFIER}    { return FakerTypes.IDENTIFIER; }
    \.              { return FakerTypes.DOT; }
    {WHITE_SPACE}+  {
                      yypushState(IN_NESTED_EXPRESSION_ARGS);
                      return FakerTypes.PARAMS_LIST_BEGIN;
                    }
}

// #{foo '#{bar <here>''someText''}'}
<IN_NESTED_EXPRESSION_ARGS>
{
    // Param begin
    "''"  {
            yypushState(IN_NESTED_EXPRESSION_PARAM);
            return FakerTypes.PARAM_DOUBLE_QUOTE_BEGIN;
          }
    // Expression end
    "}"      {
                yypushback(1);
                yypopState();
              }
}

// #{foo '#{bar ''<here>someText''}'}
<IN_NESTED_EXPRESSION_PARAM>
{
    "''"  {
            yypopState();
            return FakerTypes.PARAM_DOUBLE_QUOTE_END;
          }
    "#{"  {
            yypushState(IN_NESTED_EXPRESSION);
            return FakerTypes.EXPRESSION_LBRACE;
          }
    (#[^{#']) | [^\']  {
                         return FakerTypes.REGULAR_STRING_PART;
                       }
}

"#"                      { return FakerTypes.REGULAR_STRING_PART; }
({CRLF}|{WHITE_SPACE})+  { return TokenType.WHITE_SPACE; }
","                      { return FakerTypes.COMMA; }
[^]                      { return TokenType.BAD_CHARACTER; }
