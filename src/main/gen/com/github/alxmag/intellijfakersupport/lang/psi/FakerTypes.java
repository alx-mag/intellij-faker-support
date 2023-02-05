// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang.psi;

import com.github.alxmag.intellijfakersupport.lang.psi.impl.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

public interface FakerTypes {

  IElementType FUNCTION_NAME = new FakerElementType("FUNCTION_NAME");
  IElementType L_1_EXPRESSION = new FakerElementType("L_1_EXPRESSION");
  IElementType L_1_PARAM = new FakerElementType("L_1_PARAM");
  IElementType L_2_EXPRESSION = new FakerElementType("L_2_EXPRESSION");
  IElementType L_2_PARAM = new FakerElementType("L_2_PARAM");
  IElementType L_2_PARAMS_LIST = new FakerElementType("L_2_PARAMS_LIST");
  IElementType L_3_EXPRESSION = new FakerElementType("L_3_EXPRESSION");

  IElementType COMMA = new FakerTokenType(",");
  IElementType DOT = new FakerTokenType(".");
  IElementType EXPRESSION_LBRACE = new FakerTokenType("#{");
  IElementType EXPRESSION_RBRACE = new FakerTokenType("}");
  IElementType IDENTIFIER = new FakerTokenType("IDENTIFIER");
  IElementType PARAMS_LIST_SEPARATOR = new FakerTokenType("PARAMS_LIST_SEPARATOR");
  IElementType PARAM_BEGIN = new FakerTokenType("PARAM_BEGIN");
  IElementType PARAM_DOUBLE_QUOTE_BEGIN = new FakerTokenType("PARAM_DOUBLE_QUOTE_BEGIN");
  IElementType PARAM_DOUBLE_QUOTE_END = new FakerTokenType("PARAM_DOUBLE_QUOTE_END");
  IElementType PARAM_END = new FakerTokenType("PARAM_END");
  IElementType REGULAR_STRING_PART = new FakerTokenType("REGULAR_STRING_PART");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == FUNCTION_NAME) {
        return new FakerFunctionNameImpl(node);
      }
      else if (type == L_1_EXPRESSION) {
        return new FakerL1ExpressionImpl(node);
      }
      else if (type == L_1_PARAM) {
        return new FakerL1ParamImpl(node);
      }
      else if (type == L_2_EXPRESSION) {
        return new FakerL2ExpressionImpl(node);
      }
      else if (type == L_2_PARAM) {
        return new FakerL2ParamImpl(node);
      }
      else if (type == L_2_PARAMS_LIST) {
        return new FakerL2ParamsListImpl(node);
      }
      else if (type == L_3_EXPRESSION) {
        return new FakerL3ExpressionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
