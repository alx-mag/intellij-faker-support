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
    create_token_set_(L_1_TEMPLATE, L_2_TEMPLATE, L_3_TEMPLATE),
    create_token_set_(L_1_EXPRESSION, L_2_EXPRESSION, L_3_EXPRESSION),
  };

  /* ********************************************************** */
  // REGULAR_STRING_PART
  static boolean content(PsiBuilder b, int l) {
    return consumeToken(b, REGULAR_STRING_PART);
  }

  /* ********************************************************** */
  // l1Template
  static boolean fakerFile(PsiBuilder b, int l) {
    return l1Template(b, l + 1);
  }

  /* ********************************************************** */
  // functionNameSegment (DOT functionNameSegment)*
  public static boolean functionName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionNameSegment(b, l + 1);
    r = r && functionName_1(b, l + 1);
    exit_section_(b, m, FUNCTION_NAME, r);
    return r;
  }

  // (DOT functionNameSegment)*
  private static boolean functionName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionName_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!functionName_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionName_1", c)) break;
    }
    return true;
  }

  // DOT functionNameSegment
  private static boolean functionName_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionName_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && functionNameSegment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean functionNameSegment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionNameSegment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FUNCTION_NAME_SEGMENT, r);
    return r;
  }

  /* ********************************************************** */
  // EXPRESSION_LBRACE (functionName l1ParamsListDeclaration?)? EXPRESSION_RBRACE
  public static boolean l1Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l1Expression")) return false;
    if (!nextTokenIs(b, "<Expression>", EXPRESSION_LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, L_1_EXPRESSION, "<Expression>");
    r = consumeToken(b, EXPRESSION_LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, l1Expression_1(b, l + 1));
    r = p && consumeToken(b, EXPRESSION_RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (functionName l1ParamsListDeclaration?)?
  private static boolean l1Expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l1Expression_1")) return false;
    l1Expression_1_0(b, l + 1);
    return true;
  }

  // functionName l1ParamsListDeclaration?
  private static boolean l1Expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l1Expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionName(b, l + 1);
    r = r && l1Expression_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // l1ParamsListDeclaration?
  private static boolean l1Expression_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l1Expression_1_0_1")) return false;
    l1ParamsListDeclaration(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // l1ParamDeclaration*
  static boolean l1ExpressionParamsList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l1ExpressionParamsList")) return false;
    while (true) {
      int c = current_position_(b);
      if (!l1ParamDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "l1ExpressionParamsList", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // PARAM_BEGIN l2Template PARAM_END
  public static boolean l1Param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l1Param")) return false;
    if (!nextTokenIs(b, "<Single-quoted parameter>", PARAM_BEGIN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, L_1_PARAM, "<Single-quoted parameter>");
    r = consumeToken(b, PARAM_BEGIN);
    p = r; // pin = 1
    r = r && report_error_(b, l2Template(b, l + 1));
    r = p && consumeToken(b, PARAM_END) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // l1Param (','|&'}')
  static boolean l1ParamDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l1ParamDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = l1Param(b, l + 1);
    p = r; // pin = 1
    r = r && l1ParamDeclaration_1(b, l + 1);
    exit_section_(b, l, m, r, p, FakerParser::not_rbrace_or_next_l1ParamDeclaration);
    return r || p;
  }

  // ','|&'}'
  private static boolean l1ParamDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l1ParamDeclaration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = l1ParamDeclaration_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'}'
  private static boolean l1ParamDeclaration_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l1ParamDeclaration_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, EXPRESSION_RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PARAMS_LIST_SEPARATOR l1ExpressionParamsList
  static boolean l1ParamsListDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l1ParamsListDeclaration")) return false;
    if (!nextTokenIs(b, PARAMS_LIST_SEPARATOR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, PARAMS_LIST_SEPARATOR);
    p = r; // pin = 1
    r = r && l1ExpressionParamsList(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // (l1Expression | content)*
  public static boolean l1Template(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l1Template")) return false;
    Marker m = enter_section_(b, l, _NONE_, L_1_TEMPLATE, "<l 1 template>");
    while (true) {
      int c = current_position_(b);
      if (!l1Template_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "l1Template", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // l1Expression | content
  private static boolean l1Template_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l1Template_0")) return false;
    boolean r;
    r = l1Expression(b, l + 1);
    if (!r) r = content(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // EXPRESSION_LBRACE (functionName l2ExpressionParamsList?)? EXPRESSION_RBRACE
  public static boolean l2Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l2Expression")) return false;
    if (!nextTokenIs(b, "<Nested expression>", EXPRESSION_LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, L_2_EXPRESSION, "<Nested expression>");
    r = consumeToken(b, EXPRESSION_LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, l2Expression_1(b, l + 1));
    r = p && consumeToken(b, EXPRESSION_RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (functionName l2ExpressionParamsList?)?
  private static boolean l2Expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l2Expression_1")) return false;
    l2Expression_1_0(b, l + 1);
    return true;
  }

  // functionName l2ExpressionParamsList?
  private static boolean l2Expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l2Expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionName(b, l + 1);
    r = r && l2Expression_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // l2ExpressionParamsList?
  private static boolean l2Expression_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l2Expression_1_0_1")) return false;
    l2ExpressionParamsList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // PARAMS_LIST_SEPARATOR l2ParamsList
  static boolean l2ExpressionParamsList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l2ExpressionParamsList")) return false;
    if (!nextTokenIs(b, PARAMS_LIST_SEPARATOR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, PARAMS_LIST_SEPARATOR);
    p = r; // pin = 1
    r = r && l2ParamsList(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // PARAM_DOUBLE_QUOTE_BEGIN l3Template PARAM_DOUBLE_QUOTE_END
  public static boolean l2Param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l2Param")) return false;
    if (!nextTokenIs(b, "<Double apostrophe parameter>", PARAM_DOUBLE_QUOTE_BEGIN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, L_2_PARAM, "<Double apostrophe parameter>");
    r = consumeToken(b, PARAM_DOUBLE_QUOTE_BEGIN);
    p = r; // pin = 1
    r = r && report_error_(b, l3Template(b, l + 1));
    r = p && consumeToken(b, PARAM_DOUBLE_QUOTE_END) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // l2Param (','|&'}')
  static boolean l2ParamDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l2ParamDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = l2Param(b, l + 1);
    p = r; // pin = 1
    r = r && l2ParamDeclaration_1(b, l + 1);
    exit_section_(b, l, m, r, p, FakerParser::not_rbrace_or_next_l2ParamDeclaration);
    return r || p;
  }

  // ','|&'}'
  private static boolean l2ParamDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l2ParamDeclaration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = l2ParamDeclaration_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &'}'
  private static boolean l2ParamDeclaration_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l2ParamDeclaration_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, EXPRESSION_RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // l2ParamDeclaration*
  static boolean l2ParamsList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l2ParamsList")) return false;
    while (true) {
      int c = current_position_(b);
      if (!l2ParamDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "l2ParamsList", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (l2Expression | content)*
  public static boolean l2Template(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l2Template")) return false;
    Marker m = enter_section_(b, l, _NONE_, L_2_TEMPLATE, "<l 2 template>");
    while (true) {
      int c = current_position_(b);
      if (!l2Template_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "l2Template", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // l2Expression | content
  private static boolean l2Template_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l2Template_0")) return false;
    boolean r;
    r = l2Expression(b, l + 1);
    if (!r) r = content(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // EXPRESSION_LBRACE functionName? EXPRESSION_RBRACE
  public static boolean l3Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l3Expression")) return false;
    if (!nextTokenIs(b, "<Nested expression>", EXPRESSION_LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, L_3_EXPRESSION, "<Nested expression>");
    r = consumeToken(b, EXPRESSION_LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, l3Expression_1(b, l + 1));
    r = p && consumeToken(b, EXPRESSION_RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // functionName?
  private static boolean l3Expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l3Expression_1")) return false;
    functionName(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (l3Expression | content)*
  public static boolean l3Template(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l3Template")) return false;
    Marker m = enter_section_(b, l, _NONE_, L_3_TEMPLATE, "<l 3 template>");
    while (true) {
      int c = current_position_(b);
      if (!l3Template_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "l3Template", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // l3Expression | content
  private static boolean l3Template_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "l3Template_0")) return false;
    boolean r;
    r = l3Expression(b, l + 1);
    if (!r) r = content(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // !('}'|l1ParamDeclaration)
  static boolean not_rbrace_or_next_l1ParamDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_rbrace_or_next_l1ParamDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !not_rbrace_or_next_l1ParamDeclaration_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '}'|l1ParamDeclaration
  private static boolean not_rbrace_or_next_l1ParamDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_rbrace_or_next_l1ParamDeclaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXPRESSION_RBRACE);
    if (!r) r = l1ParamDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !('}'|l2ParamDeclaration)
  static boolean not_rbrace_or_next_l2ParamDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_rbrace_or_next_l2ParamDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !not_rbrace_or_next_l2ParamDeclaration_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '}'|l2ParamDeclaration
  private static boolean not_rbrace_or_next_l2ParamDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_rbrace_or_next_l2ParamDeclaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXPRESSION_RBRACE);
    if (!r) r = l2ParamDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
