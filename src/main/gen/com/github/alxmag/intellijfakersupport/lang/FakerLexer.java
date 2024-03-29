/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.alxmag.intellijfakersupport.lang;

import com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.Stack;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>faker.flex</tt>
 */
class FakerLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int IN_PARAM = 2;
  public static final int IN_FUNCTION_ARGS = 4;
  public static final int IN_EXPRESSION = 6;
  public static final int IN_NESTED_EXPRESSION = 8;
  public static final int IN_NESTED_EXPRESSION_ARGS = 10;
  public static final int IN_NESTED_EXPRESSION_PARAM = 12;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6, 6
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [12, 6, 3]
   * Total runtime size is 18336 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>9]<<6)|((ch>>3)&0x3f)]<<3)|(ch&0x7)];
  }

  /* The ZZ_CMAP_Z table has 2176 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1"+
    "\20\5\21\1\22\1\23\1\24\1\21\14\25\1\26\50\25\1\27\2\25\1\30\1\31\1\32\1\33"+
    "\25\25\1\34\20\21\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1"+
    "\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\25\1\61\1\62\5\21\2\25\1\63"+
    "\7\21\1\25\1\64\20\21\1\25\1\65\1\21\1\66\13\25\1\67\2\25\1\70\21\21\1\71"+
    "\1\72\4\21\1\73\11\21\1\74\1\75\1\76\1\77\1\21\1\100\2\21\1\101\1\102\2\21"+
    "\1\103\1\21\1\104\1\105\5\21\1\106\2\21\123\25\1\107\7\25\1\110\1\111\12\25"+
    "\1\112\15\25\1\113\6\21\1\25\1\114\2\21\11\25\1\115\u0576\21\1\116\u017f\21");

  /* The ZZ_CMAP_Y table has 5056 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\0\1\2\1\3\1\4\1\0\1\5\1\6\2\7\1\10\1\6\2\7\1\11\1\12\3\0\1\13\1"+
    "\14\1\15\1\16\2\7\1\17\3\7\1\17\71\7\1\20\1\7\1\21\1\22\1\23\1\24\2\22\16"+
    "\0\1\25\1\26\1\27\1\30\2\7\1\31\11\7\1\32\21\7\1\33\1\34\24\7\1\6\3\7\1\17"+
    "\1\35\5\7\1\36\1\37\4\0\1\40\1\41\1\22\3\7\1\10\1\42\1\22\1\43\1\44\1\0\1"+
    "\45\5\7\1\46\3\0\1\47\1\50\13\7\1\51\1\40\1\52\1\53\1\0\1\54\1\22\1\55\1\56"+
    "\3\7\3\0\1\57\12\7\1\60\1\0\1\61\1\22\1\0\1\62\3\7\1\46\1\63\1\64\2\7\1\60"+
    "\1\65\1\66\1\67\2\22\3\7\1\70\1\7\1\42\6\22\2\7\1\25\2\7\1\22\1\71\5\0\1\72"+
    "\6\7\1\73\2\0\1\74\1\7\1\75\1\0\1\6\1\7\1\76\1\77\1\100\2\7\1\101\1\102\1"+
    "\103\1\104\1\105\1\55\1\106\1\75\1\0\1\107\1\110\1\111\1\10\1\100\2\7\1\101"+
    "\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\0\1\121\1\22\1\111\1\32\1\31"+
    "\2\7\1\101\1\122\1\103\1\40\1\123\1\124\1\22\1\75\1\0\1\35\1\125\1\111\1\77"+
    "\1\100\2\7\1\101\1\122\1\103\1\104\1\115\1\126\1\106\1\75\1\0\1\35\1\22\1"+
    "\127\1\130\1\131\1\132\1\133\1\130\1\7\1\134\1\135\1\136\1\137\1\22\1\120"+
    "\1\0\1\22\1\35\1\140\1\25\1\101\2\7\1\101\1\7\1\141\1\142\1\136\1\143\1\42"+
    "\1\75\1\0\2\22\1\76\1\25\1\101\2\7\1\101\1\144\1\103\1\142\1\136\1\143\1\27"+
    "\1\75\1\0\1\145\1\22\1\72\1\25\1\101\4\7\1\146\1\142\1\147\1\150\1\151\1\75"+
    "\1\0\1\22\1\34\1\111\1\7\1\17\1\34\2\7\1\31\1\152\1\17\1\153\1\154\1\0\1\120"+
    "\1\0\1\155\1\22\1\6\5\7\1\156\1\157\1\160\1\161\1\0\1\5\4\22\1\132\1\162\2"+
    "\7\1\163\1\7\1\156\1\164\1\165\1\43\1\0\1\166\4\22\1\124\2\22\1\5\1\0\1\5"+
    "\1\167\1\170\1\7\1\6\3\7\1\23\1\37\1\0\1\142\1\171\1\0\1\37\3\0\1\172\1\173"+
    "\7\22\5\7\1\46\1\0\1\174\1\0\1\5\1\60\1\175\1\176\1\177\1\200\1\7\1\201\1"+
    "\202\1\0\1\43\4\7\1\32\1\15\5\7\1\162\51\7\1\131\1\17\1\131\5\7\1\131\4\7"+
    "\1\131\1\17\1\131\1\7\1\17\7\7\1\131\10\7\1\203\4\22\2\7\2\22\12\7\2\204\1"+
    "\6\114\7\1\77\2\7\1\6\2\7\1\42\11\7\1\130\1\7\1\124\1\7\1\25\1\205\1\22\2"+
    "\7\1\205\1\22\2\7\1\206\1\22\1\7\1\25\1\207\1\22\6\7\1\210\3\0\1\211\1\212"+
    "\1\0\1\5\3\22\1\213\1\0\1\5\13\7\1\124\1\214\4\7\1\215\10\7\1\204\1\22\3\7"+
    "\1\17\1\0\1\2\1\0\1\2\1\120\1\0\3\7\1\204\1\23\1\22\5\7\1\107\3\7\1\21\1\0"+
    "\1\5\4\22\2\7\1\160\1\2\6\7\1\171\1\161\3\0\1\104\1\0\1\5\1\0\1\5\1\151\1"+
    "\22\1\0\1\40\1\216\7\22\1\140\5\7\1\210\1\0\1\140\1\107\1\0\1\5\1\22\1\71"+
    "\1\2\1\22\1\217\3\7\1\74\1\177\1\0\1\62\4\7\1\60\1\0\1\2\1\22\4\7\1\210\2"+
    "\0\1\22\1\0\1\220\1\0\1\62\3\7\1\204\1\7\1\124\5\7\1\221\2\22\1\222\2\0\1"+
    "\223\1\224\1\225\30\7\7\0\1\226\42\7\2\204\4\7\2\204\1\7\1\227\3\7\1\204\6"+
    "\7\1\25\1\165\1\230\1\23\1\231\1\107\1\7\1\23\1\230\1\23\1\22\1\71\3\22\1"+
    "\232\1\22\1\151\1\124\1\22\1\233\1\22\1\142\1\0\1\35\1\151\2\22\1\7\1\23\4"+
    "\7\2\22\1\0\1\172\1\234\1\0\1\216\1\22\1\235\1\34\1\152\1\236\1\24\1\237\1"+
    "\7\1\240\1\241\1\242\2\22\5\7\1\124\116\22\5\7\1\17\5\7\1\17\20\7\1\23\1\243"+
    "\1\244\1\22\4\7\1\32\1\15\7\7\1\151\1\22\1\55\2\7\1\17\1\22\10\17\4\0\5\22"+
    "\1\151\72\22\1\241\3\22\1\6\1\201\1\236\1\23\1\6\11\7\1\17\1\245\1\6\12\7"+
    "\1\162\1\241\5\7\1\6\12\7\1\17\2\22\4\7\6\22\172\7\10\22\77\7\1\23\21\7\1"+
    "\23\10\22\5\7\1\204\41\7\1\23\2\7\1\0\1\244\2\22\5\7\1\160\1\246\1\247\3\7"+
    "\1\60\12\7\1\5\3\22\1\151\1\7\1\34\14\7\1\100\6\7\1\34\1\42\4\22\1\241\1\7"+
    "\1\250\1\251\2\7\1\46\1\252\1\22\1\124\6\7\1\107\1\22\1\62\5\7\1\210\1\0\1"+
    "\43\1\22\1\0\1\5\2\0\1\62\1\253\1\0\1\62\2\7\1\60\1\43\2\7\1\160\1\0\1\2\1"+
    "\22\3\7\1\23\1\72\5\7\1\46\1\0\1\216\1\151\1\0\1\5\1\254\1\7\1\0\1\255\5\7"+
    "\1\74\1\161\1\22\1\251\1\256\1\0\1\5\2\7\1\17\1\257\6\7\1\176\1\260\1\215"+
    "\2\22\1\261\1\7\1\46\1\262\1\22\3\263\1\22\2\17\5\7\1\162\1\7\1\21\16\7\1"+
    "\46\1\264\1\0\1\5\64\7\1\107\1\22\2\7\1\17\1\265\5\7\1\107\40\22\55\7\1\204"+
    "\15\7\1\21\4\22\1\17\1\22\1\265\1\266\1\7\1\101\1\17\1\165\1\267\15\7\1\21"+
    "\3\22\1\265\54\7\1\204\2\22\10\7\1\34\6\7\5\22\1\7\1\23\2\0\2\22\2\0\1\133"+
    "\2\22\1\241\3\22\1\35\1\25\20\7\1\270\1\233\1\22\1\0\1\5\1\6\2\7\1\10\1\6"+
    "\2\7\1\42\1\271\12\7\1\17\3\34\1\272\1\273\2\22\1\274\1\7\1\144\2\7\1\17\2"+
    "\7\1\275\1\7\1\204\1\7\1\204\4\22\17\7\1\42\10\22\6\7\1\23\20\22\1\276\20"+
    "\22\3\7\1\23\6\7\1\124\1\22\1\216\3\22\4\7\1\22\1\241\3\7\1\42\4\7\1\60\1"+
    "\277\3\7\1\204\4\7\1\107\1\7\1\236\5\22\23\7\1\204\1\0\1\5\4\7\1\107\4\7\1"+
    "\107\5\7\1\22\6\7\1\107\23\22\46\7\1\17\1\22\2\7\1\204\1\22\1\7\23\22\1\204"+
    "\1\101\4\7\1\32\1\300\2\7\1\204\1\22\2\7\1\17\1\22\3\7\1\17\10\22\2\7\1\301"+
    "\1\22\2\7\1\204\1\22\3\7\1\21\10\22\7\7\1\271\10\22\1\302\1\246\1\144\1\6"+
    "\2\7\1\204\1\114\4\22\3\7\1\23\3\7\1\23\4\22\1\7\1\6\2\7\1\303\3\22\6\7\1"+
    "\204\1\22\2\7\1\204\1\22\2\7\1\42\1\22\2\7\1\21\15\22\11\7\1\124\6\22\6\7"+
    "\1\42\1\22\6\7\1\42\1\22\4\7\1\210\1\22\1\0\1\5\50\22\5\7\1\304\1\21\11\22"+
    "\3\7\1\23\1\151\1\22\2\7\1\60\1\0\1\216\13\22\2\7\1\23\3\22\2\7\1\17\1\22"+
    "\1\217\6\7\1\0\1\161\3\22\1\120\1\0\1\22\1\55\1\217\5\7\1\0\1\305\1\22\1\276"+
    "\3\7\1\124\1\0\1\5\1\217\3\7\1\160\1\0\1\142\1\0\1\306\1\22\4\7\1\307\1\22"+
    "\1\217\5\7\1\46\1\0\1\310\1\311\1\0\1\312\4\22\2\7\1\31\2\7\1\210\1\0\1\173"+
    "\10\22\1\17\1\237\1\7\1\32\1\7\1\124\5\7\1\160\1\0\1\277\1\0\1\5\1\313\1\77"+
    "\1\100\2\7\1\101\1\122\1\314\1\104\1\115\1\137\1\241\1\75\2\172\21\22\6\7"+
    "\1\171\1\0\1\174\1\42\1\0\1\315\1\21\3\22\6\7\2\0\1\316\1\22\1\0\1\5\24\22"+
    "\5\7\1\160\1\43\1\0\1\216\2\22\1\256\4\22\6\7\2\0\1\317\1\22\1\0\1\5\4\22"+
    "\5\7\1\46\1\0\1\124\1\0\1\5\6\22\3\7\1\203\1\0\1\2\1\0\1\5\30\22\5\7\1\210"+
    "\1\0\1\277\14\22\10\7\1\0\1\5\1\22\1\151\1\17\1\320\1\321\3\7\1\40\1\322\1"+
    "\323\1\22\1\0\1\5\10\22\1\7\1\34\4\7\1\74\1\324\1\325\3\22\1\74\1\217\4\7"+
    "\1\46\1\326\1\55\1\22\1\74\1\72\5\7\1\201\1\0\1\327\4\22\7\7\1\124\40\22\1"+
    "\7\1\101\3\7\1\160\1\161\1\0\1\124\1\22\1\0\1\5\2\22\1\34\3\7\1\324\2\0\1"+
    "\37\1\161\11\22\1\17\1\31\4\7\1\330\1\331\1\202\1\22\1\0\1\5\1\32\1\101\3"+
    "\7\1\332\1\226\1\124\1\0\1\5\46\22\2\7\1\333\27\22\1\124\4\22\1\241\1\124"+
    "\3\22\63\7\1\21\14\22\15\7\1\17\2\22\30\7\1\107\27\22\5\7\1\17\1\0\1\216\70"+
    "\22\10\7\1\17\67\22\7\7\1\124\3\7\1\17\1\0\1\5\14\22\3\7\1\204\1\172\1\22"+
    "\6\7\1\161\1\22\1\107\1\22\1\0\1\5\1\265\2\7\1\241\2\7\26\22\10\7\20\22\11"+
    "\7\1\334\1\74\6\0\1\55\1\217\1\7\10\22\1\335\1\22\1\5\1\22\77\7\1\22\32\7"+
    "\1\204\5\22\1\7\1\124\36\22\43\7\1\17\6\22\1\42\1\22\1\336\1\22\61\7\1\107"+
    "\40\22\15\7\1\42\1\7\1\23\1\7\1\124\1\7\1\337\1\2\127\22\1\126\1\340\2\0\1"+
    "\341\1\2\3\22\1\342\22\22\1\343\67\22\12\7\1\25\10\7\1\25\1\344\1\345\1\7"+
    "\1\346\1\144\7\7\1\32\1\221\2\25\3\7\1\347\1\165\1\34\1\101\51\7\1\204\3\7"+
    "\1\101\2\7\1\162\3\7\1\162\2\7\1\25\3\7\1\25\2\7\1\17\3\7\1\17\3\7\1\101\3"+
    "\7\1\101\2\7\1\162\1\350\14\0\1\161\1\71\5\0\1\172\1\276\1\22\1\252\2\22\1"+
    "\71\1\37\1\0\52\22\1\161\2\0\1\351\1\352\1\277\32\22\5\7\1\23\1\174\1\204"+
    "\1\0\1\353\56\22\5\7\1\210\1\0\1\354\40\22\30\7\1\23\1\22\1\161\5\22\10\7"+
    "\1\210\1\355\1\0\1\5\52\22\1\124\51\22\1\144\3\7\1\356\1\6\1\162\1\357\1\235"+
    "\1\360\1\356\1\227\1\356\2\162\1\117\1\7\1\31\1\7\1\107\1\361\1\31\1\7\1\107"+
    "\146\22\1\0\1\5\33\7\1\204\4\22\106\7\1\23\1\22\33\7\1\204\120\7\1\21\1\22"+
    "\146\7\1\124\3\22\3\7\1\204\74\22\51\7\1\42\26\22\1\116\3\22\14\0\20\22\36"+
    "\0\2\22");

  /* The ZZ_CMAP_A table has 1936 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\4\2\2\1\1\1\2\1\1\6\4\4\0\1\2\2\0\1\6\1\3\2\0\1\12\4\0\1\13\1\0\1\10\1"+
    "\0\2\4\7\0\22\3\4\0\4\3\1\7\1\0\1\11\1\0\6\4\1\5\2\4\2\0\4\3\4\0\1\3\2\0\1"+
    "\4\7\0\1\3\4\0\1\3\5\0\7\3\1\0\2\3\4\0\4\3\16\0\5\3\7\0\1\3\1\0\1\3\1\0\5"+
    "\3\1\0\2\3\2\0\4\3\1\0\1\3\6\0\1\3\1\0\3\3\1\0\1\3\1\0\4\3\1\0\13\3\1\0\3"+
    "\3\1\0\5\4\2\0\6\3\1\0\1\3\6\0\1\3\6\0\1\3\1\0\15\4\1\0\1\4\1\0\2\4\1\0\2"+
    "\4\1\0\1\4\3\3\5\0\6\4\5\0\1\3\4\0\3\4\1\0\1\4\3\0\3\3\7\4\4\0\2\3\1\4\13"+
    "\3\1\0\1\3\7\4\2\3\2\4\1\0\4\4\2\3\2\4\3\3\2\0\1\3\7\0\1\4\1\3\1\4\6\3\3\4"+
    "\2\0\11\3\3\4\1\3\6\0\2\4\6\3\4\4\2\3\4\0\1\3\2\0\1\4\2\3\2\4\1\3\11\4\1\3"+
    "\3\4\1\3\5\4\2\0\1\3\3\4\7\0\11\4\6\3\3\4\1\3\2\4\1\3\7\4\2\3\2\4\2\0\2\4"+
    "\1\3\3\4\1\0\10\3\2\0\2\3\2\0\6\3\1\0\7\3\1\0\1\3\3\0\4\3\2\0\1\4\1\3\7\4"+
    "\2\0\2\4\2\0\3\4\1\3\5\0\2\3\1\0\5\3\7\0\2\3\1\0\1\4\2\0\3\4\1\0\4\3\1\0\2"+
    "\3\1\0\2\3\1\0\2\3\2\0\1\4\1\0\5\4\4\0\2\4\2\0\3\4\3\0\1\4\7\0\4\3\1\0\1\3"+
    "\7\0\4\4\3\3\1\4\2\0\1\3\1\0\2\3\1\0\3\3\2\4\1\0\3\4\2\0\1\3\10\0\1\3\6\4"+
    "\5\0\3\4\2\0\1\4\1\3\1\0\6\3\3\0\3\3\1\0\4\3\3\0\2\3\1\0\1\3\1\0\2\3\3\0\2"+
    "\3\3\0\2\3\4\0\5\4\3\0\3\4\1\0\4\4\2\0\1\3\6\0\6\4\5\3\3\0\1\3\7\4\1\0\2\4"+
    "\5\0\2\4\1\0\4\3\1\0\3\3\1\0\2\3\5\0\3\3\2\4\1\3\3\4\1\0\4\4\1\3\5\0\3\3\1"+
    "\4\7\0\5\3\1\0\1\3\4\0\1\4\4\0\6\4\1\0\1\4\3\0\2\4\4\0\1\3\1\4\2\3\7\4\4\0"+
    "\10\3\10\4\1\0\3\3\1\0\10\3\1\0\1\3\1\0\1\3\5\4\1\3\2\0\5\3\1\0\1\3\1\0\2"+
    "\4\2\0\4\3\5\0\1\4\1\0\1\4\1\0\1\4\4\0\2\4\5\3\10\4\11\0\1\4\1\0\7\4\1\3\2"+
    "\4\4\3\3\4\1\3\3\4\2\3\7\4\3\3\4\4\5\3\14\4\1\3\1\4\3\3\2\0\3\4\6\3\2\0\2"+
    "\3\3\4\3\0\2\3\2\4\4\0\1\3\1\0\2\4\4\0\4\3\10\4\3\0\1\3\3\0\2\3\1\4\5\0\4"+
    "\4\1\0\5\3\2\4\2\3\1\4\1\3\5\0\1\4\7\0\3\4\5\3\2\4\3\0\6\3\2\0\3\3\3\4\1\0"+
    "\5\4\4\3\1\4\6\3\1\4\2\3\3\4\1\3\5\0\2\4\1\0\5\4\1\0\1\3\1\0\1\3\1\0\1\3\1"+
    "\0\1\3\2\0\3\3\1\0\6\3\2\0\2\3\2\1\5\4\5\0\1\3\4\0\1\4\3\0\3\4\2\0\1\3\4\0"+
    "\1\3\1\0\5\3\2\0\1\3\1\0\4\3\1\0\3\3\2\0\4\3\5\0\5\3\4\0\1\3\4\0\4\3\3\4\2"+
    "\3\5\0\2\4\2\0\3\3\4\0\12\4\1\0\3\3\1\4\3\3\1\4\4\3\1\4\4\3\4\0\1\4\6\0\1"+
    "\3\1\0\2\3\1\4\5\3\1\4\2\3\2\4\5\3\1\0\4\3\2\4\4\0\1\3\3\4\2\3\1\4\5\3\2\4"+
    "\3\0\3\3\4\0\3\3\2\4\2\0\6\3\1\0\3\4\1\0\2\4\5\0\5\3\5\0\1\3\1\4\3\3\1\0\2"+
    "\3\1\0\7\3\2\0\1\4\6\0\2\3\2\0\3\3\3\0\2\3\3\0\2\3\2\0\3\4\4\0\3\3\1\0\2\3"+
    "\1\0\1\3\5\0\1\4\2\0\3\4\5\0\1\3\3\0\1\3\2\0\4\3\1\0\2\3\2\0\1\3\3\4\1\0\2"+
    "\4\1\0\5\3\2\4\1\0\2\3\1\0\2\4\3\0\3\4\2\0\1\4\6\0\1\3\2\4\4\3\1\4\2\0\1\3"+
    "\1\0\1\4\4\3\4\0\4\4\1\0\4\4\1\3\1\0\1\3\3\0\4\4\1\0\5\3\1\0\2\4\1\3\4\4\4"+
    "\0\1\4\1\3\4\4\2\3\1\0\1\3\1\4\3\0\1\3\4\0\1\3\2\0\10\3\1\0\2\3\1\0\1\4\2"+
    "\0\4\4\1\3\1\4\1\3\2\4\6\0\7\4\1\3\1\0\1\3\1\4\3\0\2\4\1\3\4\4\1\0\2\4\3\0"+
    "\1\3\2\0\1\3\6\4\3\0\1\4\1\0\2\4\1\0\1\4\2\3\5\4\1\0\3\3\4\4\1\0\3\3\4\0\1"+
    "\4\2\3\1\0\1\3\1\4\7\0\6\3\3\0\2\4\1\0\2\4\3\0\6\4\2\0\3\4\2\0\4\4\4\0\3\4"+
    "\5\0\1\3\2\0\2\3\2\0\4\3\1\0\4\3\1\0\1\3\1\0\5\3\1\0\4\3\1\0\4\3\2\0\3\4\2"+
    "\0\7\4\1\0\2\4\1\0\4\4\4\0\1\3\1\0\2\4\5\0\1\3\3\4\1\3\5\0\2\3\1\0\1\3\2\0"+
    "\1\3\1\0\1\3\1\0\1\3\5\0\1\3\1\0\1\3\1\0\3\3\1\0\3\3\1\0\3\3");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\6\0\4\1\1\2\1\3\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\1\1\12\1\13\1\14\1\15"+
    "\1\16\1\3\1\1\1\3\1\17\1\20\1\21\1\22"+
    "\1\23\1\24";

  private static int [] zzUnpackAction() {
    int [] result = new int[34];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\14\0\30\0\44\0\60\0\74\0\110\0\124"+
    "\0\140\0\154\0\170\0\140\0\140\0\154\0\140\0\140"+
    "\0\140\0\204\0\220\0\234\0\140\0\140\0\250\0\140"+
    "\0\140\0\264\0\300\0\314\0\140\0\140\0\140\0\140"+
    "\0\140\0\140";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[34];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\6\1\1\10\5\1\1\11\2\12\2\11\1\12\1\13"+
    "\3\11\1\14\1\11\1\15\2\16\2\15\1\16\1\11"+
    "\2\15\1\17\1\20\1\21\1\15\1\16\1\22\1\23"+
    "\1\15\1\16\1\24\1\15\1\25\1\26\1\15\1\21"+
    "\1\15\1\16\1\27\1\23\1\15\1\16\1\11\1\15"+
    "\1\25\1\30\1\15\1\21\1\15\2\16\2\15\1\16"+
    "\1\11\2\15\1\31\1\32\1\21\1\11\2\12\2\11"+
    "\1\12\1\33\3\11\1\34\1\11\6\1\1\10\1\35"+
    "\4\1\15\0\2\16\2\0\1\16\6\0\6\11\1\0"+
    "\1\36\2\11\1\0\1\11\1\0\1\16\1\22\2\0"+
    "\1\16\11\0\3\23\15\0\1\37\5\0\1\16\1\27"+
    "\2\0\1\16\20\0\1\40\1\0\6\11\1\0\1\41"+
    "\2\11\1\0\1\11\12\0\1\42\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[216];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\1\6\0\1\1\1\11\2\1\2\11\1\1\3\11"+
    "\3\1\2\11\1\1\2\11\3\1\6\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[34];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    private Stack<Integer> stack = new Stack<>();

    public void yypushState(int newState) {
      stack.push(yystate());
      yybegin(newState);
    }

    public void yypopState() {
      yybegin(stack.pop());
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  FakerLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return FakerTypes.REGULAR_STRING_PART;
            } 
            // fall through
          case 21: break;
          case 2: 
            { yypopState();
                         return FakerTypes.PARAM_END;
            } 
            // fall through
          case 22: break;
          case 3: 
            { return TokenType.BAD_CHARACTER;
            } 
            // fall through
          case 23: break;
          case 4: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 24: break;
          case 5: 
            { //Exit from function args
           yypushback(1);
           yypopState();
            } 
            // fall through
          case 25: break;
          case 6: 
            { yypushState(IN_PARAM);
               return FakerTypes.PARAM_BEGIN;
            } 
            // fall through
          case 26: break;
          case 7: 
            { return FakerTypes.COMMA;
            } 
            // fall through
          case 27: break;
          case 8: 
            { yypushState(IN_FUNCTION_ARGS);
                      return FakerTypes.PARAMS_LIST_SEPARATOR;
            } 
            // fall through
          case 28: break;
          case 9: 
            { return FakerTypes.IDENTIFIER;
            } 
            // fall through
          case 29: break;
          case 10: 
            { return FakerTypes.DOT;
            } 
            // fall through
          case 30: break;
          case 11: 
            { yypopState();
                      return FakerTypes.EXPRESSION_RBRACE;
            } 
            // fall through
          case 31: break;
          case 12: 
            { yypushState(IN_NESTED_EXPRESSION_ARGS);
                      return FakerTypes.PARAMS_LIST_SEPARATOR;
            } 
            // fall through
          case 32: break;
          case 13: 
            { yypopState();
                          return FakerTypes.EXPRESSION_RBRACE;
            } 
            // fall through
          case 33: break;
          case 14: 
            { yypushback(1);
                yypopState();
            } 
            // fall through
          case 34: break;
          case 15: 
            { yypushback(2);
                               yypushState(IN_EXPRESSION);
                               return FakerTypes.REGULAR_STRING_PART;
            } 
            // fall through
          case 35: break;
          case 16: 
            { yypushState(IN_NESTED_EXPRESSION);
                         return FakerTypes.EXPRESSION_LBRACE;
            } 
            // fall through
          case 36: break;
          case 17: 
            { return FakerTypes.EXPRESSION_LBRACE;
            } 
            // fall through
          case 37: break;
          case 18: 
            { yypushState(IN_NESTED_EXPRESSION_PARAM);
            return FakerTypes.PARAM_DOUBLE_QUOTE_BEGIN;
            } 
            // fall through
          case 38: break;
          case 19: 
            { yypushState(IN_NESTED_EXPRESSION);
            return FakerTypes.EXPRESSION_LBRACE;
            } 
            // fall through
          case 39: break;
          case 20: 
            { yypopState();
            return FakerTypes.PARAM_DOUBLE_QUOTE_END;
            } 
            // fall through
          case 40: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
