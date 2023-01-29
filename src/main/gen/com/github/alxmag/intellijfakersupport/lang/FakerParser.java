// This is a generated file. Not intended for manual editing.
package com.github.alxmag.intellijfakersupport.lang;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LightPsiParser;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

import static com.github.alxmag.intellijfakersupport.lang.FakerParserUtil.*;
import static com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes.*;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class FakerParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return fakerFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(PARAM_EXPRESSION, PARAM_LITERAL, PARAM_STATEMENT),
  };

  /* ********************************************************** */
  // EXPRESSION_LBRACE functionName paramsListDeclaration? EXPRESSION_RBRACE
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    if (!nextTokenIs(b, EXPRESSION_LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, null);
    r = consumeToken(b, EXPRESSION_LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, functionName(b, l + 1));
    r = p && report_error_(b, expression_2(b, l + 1)) && r;
    r = p && consumeToken(b, EXPRESSION_RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // paramsListDeclaration?
  private static boolean expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_2")) return false;
    paramsListDeclaration(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // paramDeclaration*
  public static boolean expressionParamsList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionParamsList")) return false;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_PARAMS_LIST, "<expression params list>");
    while (true) {
      int c = current_position_(b);
      if (!paramDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expressionParamsList", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // template_part_*
  static boolean fakerFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fakerFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!template_part_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fakerFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER (DOT IDENTIFIER)*
  public static boolean functionName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && functionName_1(b, l + 1);
    exit_section_(b, m, FUNCTION_NAME, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean functionName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionName_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!functionName_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionName_1", c)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean functionName_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionName_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !('}'|paramDeclaration)
  static boolean not_rbrace_or_next_param_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_rbrace_or_next_param_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !not_rbrace_or_next_param_declaration_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '}'|paramDeclaration
  private static boolean not_rbrace_or_next_param_declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_rbrace_or_next_param_declaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXPRESSION_RBRACE);
    if (!r) r = paramDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PARAM_BEGIN paramStatement PARAM_END
  public static boolean param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param")) return false;
    if (!nextTokenIs(b, PARAM_BEGIN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAM, null);
    r = consumeToken(b, PARAM_BEGIN);
    p = r; // pin = 1
    r = r && report_error_(b, paramStatement(b, l + 1));
    r = p && consumeToken(b, PARAM_END) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // param (','|&'}')
  static boolean paramDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = param(b, l + 1);
    p = r; // pin = 1
    r = r && paramDeclaration_1(b, l + 1);
    exit_section_(b, l, m, r, p, FakerParser::not_rbrace_or_next_param_declaration);
    return r || p;
  }

  // ','|&'}'
  private static boolean paramDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramDeclaration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = paramDeclaration_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'}'
  private static boolean paramDeclaration_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramDeclaration_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, EXPRESSION_RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EXPRESSION_LBRACE functionName EXPRESSION_RBRACE
  public static boolean paramExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramExpression")) return false;
    if (!nextTokenIs(b, EXPRESSION_LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAM_EXPRESSION, null);
    r = consumeToken(b, EXPRESSION_LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, functionName(b, l + 1));
    r = p && consumeToken(b, EXPRESSION_RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // REGULAR_STRING_PART?
  public static boolean paramLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramLiteral")) return false;
    Marker m = enter_section_(b, l, _NONE_, PARAM_LITERAL, "<param literal>");
    consumeToken(b, REGULAR_STRING_PART);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // paramExpression | paramLiteral
  public static boolean paramStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, PARAM_STATEMENT, "<param statement>");
    r = paramExpression(b, l + 1);
    if (!r) r = paramLiteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PARAMS_LIST_BEGIN expressionParamsList
  static boolean paramsListDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramsListDeclaration")) return false;
    if (!nextTokenIs(b, PARAMS_LIST_BEGIN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, PARAMS_LIST_BEGIN);
    p = r; // pin = 1
    r = r && expressionParamsList(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // REGULAR_STRING_PART|expression
  static boolean template_part_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "template_part_")) return false;
    if (!nextTokenIs(b, "", EXPRESSION_LBRACE, REGULAR_STRING_PART)) return false;
    boolean r;
    r = consumeToken(b, REGULAR_STRING_PART);
    if (!r) r = expression(b, l + 1);
    return r;
  }

}
