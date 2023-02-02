// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi;

import com.github.alxmag.intellijfakersupport.lang.psi.impl.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

public interface FakerTypes {

  IElementType EXPRESSION = new FakerElementType("EXPRESSION");
  IElementType EXPRESSION_PARAMS_LIST = new FakerElementType("EXPRESSION_PARAMS_LIST");
  IElementType FUNCTION_NAME = new FakerElementType("FUNCTION_NAME");
  IElementType NESTED_EXPRESSION_PARAMS_LIST = new FakerElementType("NESTED_EXPRESSION_PARAMS_LIST");
  IElementType NESTED_PARAM = new FakerElementType("NESTED_PARAM");
  IElementType PARAM = new FakerElementType("PARAM");
  IElementType PARAM_EXPRESSION = new FakerElementType("PARAM_EXPRESSION");
  IElementType PARAM_LITERAL = new FakerElementType("PARAM_LITERAL");
  IElementType PARAM_STATEMENT = new FakerElementType("PARAM_STATEMENT");

  IElementType COMMA = new FakerTokenType(",");
  IElementType DOT = new FakerTokenType(".");
  IElementType EXPRESSION_LBRACE = new FakerTokenType("#{");
  IElementType EXPRESSION_RBRACE = new FakerTokenType("}");
  IElementType IDENTIFIER = new FakerTokenType("IDENTIFIER");
  IElementType PARAMS_LIST_BEGIN = new FakerTokenType("PARAMS_LIST_BEGIN");
  IElementType PARAM_BEGIN = new FakerTokenType("PARAM_BEGIN");
  IElementType PARAM_DOUBLE_QUOTE_BEGIN = new FakerTokenType("PARAM_DOUBLE_QUOTE_BEGIN");
  IElementType PARAM_DOUBLE_QUOTE_END = new FakerTokenType("PARAM_DOUBLE_QUOTE_END");
  IElementType PARAM_END = new FakerTokenType("PARAM_END");
  IElementType REGULAR_STRING_PART = new FakerTokenType("REGULAR_STRING_PART");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == EXPRESSION) {
        return new FakerExpressionImpl(node);
      }
      else if (type == EXPRESSION_PARAMS_LIST) {
        return new FakerExpressionParamsListImpl(node);
      }
      else if (type == FUNCTION_NAME) {
        return new FakerFunctionNameImpl(node);
      }
      else if (type == NESTED_EXPRESSION_PARAMS_LIST) {
        return new FakerNestedExpressionParamsListImpl(node);
      }
      else if (type == NESTED_PARAM) {
        return new FakerNestedParamImpl(node);
      }
      else if (type == PARAM) {
        return new FakerParamImpl(node);
      }
      else if (type == PARAM_EXPRESSION) {
        return new FakerParamExpressionImpl(node);
      }
      else if (type == PARAM_LITERAL) {
        return new FakerParamLiteralImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
