/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.alxmag.intellijfakersupport.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.alxmag.intellijfakersupport.lang.psi.FakerTypes;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>faker_template.flex</tt>
 */
class FakerLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int IN_FUNCTION_NAME = 2;
  public static final int IN_PARAM = 4;
  public static final int IN_FUNCTION_ARGS = 6;
  public static final int IN_EXPRESSION = 8;
  public static final int AFTER_HASH = 10;
  public static final int AFTER_EXPRESSION_PREFIX = 12;

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
   * Total runtime size is 18352 bytes
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
    "\1\35\5\7\1\36\1\37\4\0\1\40\1\41\1\22\3\7\1\42\1\43\1\22\1\44\1\45\1\0\1"+
    "\46\5\7\1\47\3\0\1\50\1\51\13\7\1\52\1\40\1\53\1\54\1\0\1\55\1\22\1\56\1\57"+
    "\3\7\3\0\1\60\12\7\1\61\1\0\1\62\1\22\1\0\1\63\3\7\1\47\1\64\1\65\2\7\1\61"+
    "\1\66\1\67\1\70\2\22\3\7\1\71\1\7\1\43\6\22\2\7\1\25\2\7\1\22\1\72\5\0\1\73"+
    "\6\7\1\74\2\0\1\75\1\7\1\76\1\0\1\6\1\7\1\77\1\100\1\101\2\7\1\102\1\103\1"+
    "\104\1\105\1\106\1\56\1\107\1\76\1\0\1\110\1\111\1\112\1\42\1\101\2\7\1\102"+
    "\1\113\1\114\1\115\1\116\1\117\1\120\1\121\1\0\1\122\1\22\1\112\1\32\1\31"+
    "\2\7\1\102\1\123\1\104\1\40\1\124\1\125\1\22\1\76\1\0\1\35\1\126\1\112\1\100"+
    "\1\101\2\7\1\102\1\123\1\104\1\105\1\116\1\127\1\107\1\76\1\0\1\35\1\22\1"+
    "\130\1\131\1\132\1\133\1\134\1\131\1\7\1\135\1\136\1\137\1\140\1\22\1\121"+
    "\1\0\1\22\1\35\1\141\1\25\1\102\2\7\1\102\1\7\1\142\1\143\1\137\1\144\1\43"+
    "\1\76\1\0\2\22\1\77\1\25\1\102\2\7\1\102\1\145\1\104\1\143\1\137\1\144\1\27"+
    "\1\76\1\0\1\146\1\22\1\73\1\25\1\102\4\7\1\147\1\143\1\150\1\151\1\152\1\76"+
    "\1\0\1\22\1\34\1\112\1\7\1\17\1\34\2\7\1\31\1\153\1\17\1\154\1\155\1\0\1\121"+
    "\1\0\1\156\1\22\1\6\5\7\1\157\1\160\1\161\1\162\1\0\1\5\4\22\1\133\1\163\2"+
    "\7\1\164\1\7\1\157\1\165\1\166\1\44\1\0\1\167\4\22\1\125\2\22\1\5\1\0\1\5"+
    "\1\170\1\171\1\7\1\6\3\7\1\23\1\37\1\0\1\143\1\172\1\0\1\37\3\0\1\173\1\174"+
    "\7\22\5\7\1\47\1\0\1\175\1\0\1\5\1\61\1\176\1\177\1\200\1\201\1\7\1\202\1"+
    "\203\1\0\1\44\4\7\1\32\1\15\5\7\1\163\51\7\1\132\1\17\1\132\5\7\1\132\4\7"+
    "\1\132\1\17\1\132\1\7\1\17\7\7\1\132\10\7\1\204\4\22\2\7\2\22\12\7\2\205\1"+
    "\6\114\7\1\100\2\7\1\6\2\7\1\43\11\7\1\131\1\7\1\125\1\7\1\25\1\206\1\22\2"+
    "\7\1\206\1\22\2\7\1\207\1\22\1\7\1\25\1\210\1\22\6\7\1\211\3\0\1\212\1\213"+
    "\1\0\1\5\3\22\1\214\1\0\1\5\13\7\1\125\1\215\4\7\1\216\10\7\1\205\1\22\3\7"+
    "\1\17\1\0\1\2\1\0\1\2\1\121\1\0\3\7\1\205\1\23\1\22\5\7\1\110\3\7\1\21\1\0"+
    "\1\5\4\22\2\7\1\161\1\2\6\7\1\172\1\162\3\0\1\105\1\0\1\5\1\0\1\5\1\152\1"+
    "\22\1\0\1\40\1\217\7\22\1\141\5\7\1\211\1\0\1\141\1\110\1\0\1\5\1\22\1\72"+
    "\1\2\1\22\1\220\3\7\1\75\1\200\1\0\1\63\4\7\1\61\1\0\1\2\1\22\4\7\1\211\2"+
    "\0\1\22\1\0\1\221\1\0\1\63\3\7\1\205\1\7\1\125\5\7\1\222\2\22\1\223\2\0\1"+
    "\224\1\225\1\226\30\7\7\0\1\227\42\7\2\205\4\7\2\205\1\7\1\230\3\7\1\205\6"+
    "\7\1\25\1\166\1\231\1\23\1\232\1\110\1\7\1\23\1\231\1\23\1\22\1\72\3\22\1"+
    "\233\1\22\1\152\1\125\1\22\1\234\1\22\1\143\1\0\1\35\1\152\2\22\1\7\1\23\4"+
    "\7\2\22\1\0\1\173\1\235\1\0\1\217\1\22\1\236\1\34\1\153\1\237\1\24\1\240\1"+
    "\7\1\241\1\242\1\243\2\22\5\7\1\125\116\22\5\7\1\17\5\7\1\17\20\7\1\23\1\244"+
    "\1\245\1\22\4\7\1\32\1\15\7\7\1\152\1\22\1\56\2\7\1\17\1\22\10\17\4\0\5\22"+
    "\1\152\72\22\1\242\3\22\1\6\1\202\1\237\1\23\1\6\11\7\1\17\1\246\1\6\12\7"+
    "\1\163\1\242\5\7\1\6\12\7\1\17\2\22\4\7\6\22\172\7\10\22\77\7\1\23\21\7\1"+
    "\23\10\22\5\7\1\205\41\7\1\23\2\7\1\0\1\245\2\22\5\7\1\161\1\247\1\250\3\7"+
    "\1\61\12\7\1\5\3\22\1\152\1\7\1\34\14\7\1\101\6\7\1\34\1\43\4\22\1\242\1\7"+
    "\1\251\1\252\2\7\1\47\1\253\1\22\1\125\6\7\1\110\1\22\1\63\5\7\1\211\1\0\1"+
    "\44\1\22\1\0\1\5\2\0\1\63\1\254\1\0\1\63\2\7\1\61\1\44\2\7\1\161\1\0\1\2\1"+
    "\22\3\7\1\23\1\73\5\7\1\47\1\0\1\217\1\152\1\0\1\5\1\255\1\7\1\0\1\256\5\7"+
    "\1\75\1\162\1\22\1\252\1\257\1\0\1\5\2\7\1\17\1\260\6\7\1\177\1\261\1\216"+
    "\2\22\1\262\1\7\1\47\1\263\1\22\3\264\1\22\2\17\5\7\1\163\1\7\1\21\16\7\1"+
    "\47\1\265\1\0\1\5\64\7\1\110\1\22\2\7\1\17\1\266\5\7\1\110\40\22\55\7\1\205"+
    "\15\7\1\21\4\22\1\17\1\22\1\266\1\267\1\7\1\102\1\17\1\166\1\270\15\7\1\21"+
    "\3\22\1\266\54\7\1\205\2\22\10\7\1\34\6\7\5\22\1\7\1\23\2\0\2\22\2\0\1\134"+
    "\2\22\1\242\3\22\1\35\1\25\20\7\1\271\1\234\1\22\1\0\1\5\1\6\2\7\1\42\1\6"+
    "\2\7\1\43\1\272\12\7\1\17\3\34\1\273\1\274\2\22\1\275\1\7\1\145\2\7\1\17\2"+
    "\7\1\276\1\7\1\205\1\7\1\205\4\22\17\7\1\43\10\22\6\7\1\23\20\22\1\277\20"+
    "\22\3\7\1\23\6\7\1\125\1\22\1\217\3\22\4\7\1\22\1\242\3\7\1\43\4\7\1\61\1"+
    "\300\3\7\1\205\4\7\1\110\1\7\1\237\5\22\23\7\1\205\1\0\1\5\4\7\1\110\4\7\1"+
    "\110\5\7\1\22\6\7\1\110\23\22\46\7\1\17\1\22\2\7\1\205\1\22\1\7\23\22\1\205"+
    "\1\102\4\7\1\32\1\301\2\7\1\205\1\22\2\7\1\17\1\22\3\7\1\17\10\22\2\7\1\302"+
    "\1\22\2\7\1\205\1\22\3\7\1\21\10\22\7\7\1\272\10\22\1\303\1\247\1\145\1\6"+
    "\2\7\1\205\1\115\4\22\3\7\1\23\3\7\1\23\4\22\1\7\1\6\2\7\1\304\3\22\6\7\1"+
    "\205\1\22\2\7\1\205\1\22\2\7\1\43\1\22\2\7\1\21\15\22\11\7\1\125\6\22\6\7"+
    "\1\43\1\22\6\7\1\43\1\22\4\7\1\211\1\22\1\0\1\5\50\22\5\7\1\305\1\21\11\22"+
    "\3\7\1\23\1\152\1\22\2\7\1\61\1\0\1\217\13\22\2\7\1\23\3\22\2\7\1\17\1\22"+
    "\1\220\6\7\1\0\1\162\3\22\1\121\1\0\1\22\1\56\1\220\5\7\1\0\1\306\1\22\1\277"+
    "\3\7\1\125\1\0\1\5\1\220\3\7\1\161\1\0\1\143\1\0\1\307\1\22\4\7\1\310\1\22"+
    "\1\220\5\7\1\47\1\0\1\311\1\312\1\0\1\313\4\22\2\7\1\31\2\7\1\211\1\0\1\174"+
    "\10\22\1\17\1\240\1\7\1\32\1\7\1\125\5\7\1\161\1\0\1\300\1\0\1\5\1\314\1\100"+
    "\1\101\2\7\1\102\1\123\1\315\1\105\1\116\1\140\1\242\1\76\2\173\21\22\6\7"+
    "\1\172\1\0\1\175\1\43\1\0\1\316\1\21\3\22\6\7\2\0\1\317\1\22\1\0\1\5\24\22"+
    "\5\7\1\161\1\44\1\0\1\217\2\22\1\257\4\22\6\7\2\0\1\320\1\22\1\0\1\5\4\22"+
    "\5\7\1\47\1\0\1\125\1\0\1\5\6\22\3\7\1\204\1\0\1\2\1\0\1\5\30\22\5\7\1\211"+
    "\1\0\1\300\14\22\10\7\1\0\1\5\1\22\1\152\1\17\1\321\1\322\3\7\1\40\1\323\1"+
    "\324\1\22\1\0\1\5\10\22\1\7\1\34\4\7\1\75\1\325\1\326\3\22\1\75\1\220\4\7"+
    "\1\47\1\327\1\56\1\22\1\75\1\73\5\7\1\202\1\0\1\330\4\22\7\7\1\125\40\22\1"+
    "\7\1\102\3\7\1\161\1\162\1\0\1\125\1\22\1\0\1\5\2\22\1\34\3\7\1\325\2\0\1"+
    "\37\1\162\11\22\1\17\1\31\4\7\1\331\1\332\1\203\1\22\1\0\1\5\1\32\1\102\3"+
    "\7\1\333\1\227\1\125\1\0\1\5\46\22\2\7\1\334\27\22\1\125\4\22\1\242\1\125"+
    "\3\22\63\7\1\21\14\22\15\7\1\17\2\22\30\7\1\110\27\22\5\7\1\17\1\0\1\217\70"+
    "\22\10\7\1\17\67\22\7\7\1\125\3\7\1\17\1\0\1\5\14\22\3\7\1\205\1\173\1\22"+
    "\6\7\1\162\1\22\1\110\1\22\1\0\1\5\1\266\2\7\1\242\2\7\26\22\10\7\20\22\11"+
    "\7\1\335\1\75\6\0\1\56\1\220\1\7\10\22\1\336\1\22\1\5\1\22\77\7\1\22\32\7"+
    "\1\205\5\22\1\7\1\125\36\22\43\7\1\17\6\22\1\43\1\22\1\337\1\22\61\7\1\110"+
    "\40\22\15\7\1\43\1\7\1\23\1\7\1\125\1\7\1\340\1\2\127\22\1\127\1\341\2\0\1"+
    "\342\1\2\3\22\1\343\22\22\1\344\67\22\12\7\1\25\10\7\1\25\1\345\1\346\1\7"+
    "\1\347\1\145\7\7\1\32\1\222\2\25\3\7\1\350\1\166\1\34\1\102\51\7\1\205\3\7"+
    "\1\102\2\7\1\163\3\7\1\163\2\7\1\25\3\7\1\25\2\7\1\17\3\7\1\17\3\7\1\102\3"+
    "\7\1\102\2\7\1\163\1\351\14\0\1\162\1\72\5\0\1\173\1\277\1\22\1\253\2\22\1"+
    "\72\1\37\1\0\52\22\1\162\2\0\1\352\1\353\1\300\32\22\5\7\1\23\1\175\1\205"+
    "\1\0\1\354\56\22\5\7\1\211\1\0\1\355\40\22\30\7\1\23\1\22\1\162\5\22\10\7"+
    "\1\211\1\356\1\0\1\5\52\22\1\125\51\22\1\145\3\7\1\357\1\6\1\163\1\360\1\236"+
    "\1\361\1\357\1\230\1\357\2\163\1\120\1\7\1\31\1\7\1\110\1\362\1\31\1\7\1\110"+
    "\146\22\1\0\1\5\33\7\1\205\4\22\106\7\1\23\1\22\33\7\1\205\120\7\1\21\1\22"+
    "\146\7\1\125\3\22\3\7\1\205\74\22\51\7\1\43\26\22\1\117\3\22\14\0\20\22\36"+
    "\0\2\22");

  /* The ZZ_CMAP_A table has 1944 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\4\2\2\1\1\1\2\1\1\6\4\4\0\1\2\1\0\1\6\1\7\1\3\2\0\1\13\4\0\1\14\1\0\1"+
    "\11\1\0\2\4\7\0\22\3\1\0\1\6\2\0\4\3\1\10\1\0\1\12\1\0\6\4\1\5\2\4\2\0\4\3"+
    "\4\0\1\3\2\0\1\4\7\0\1\3\4\0\1\3\5\0\7\3\1\0\2\3\4\0\4\3\16\0\5\3\7\0\1\3"+
    "\1\0\1\3\1\0\5\3\1\0\2\3\2\0\4\3\1\0\1\3\6\0\1\3\1\0\3\3\1\0\1\3\1\0\4\3\1"+
    "\0\13\3\1\0\3\3\1\0\5\4\2\0\6\3\1\0\1\3\6\0\1\3\6\0\1\3\1\0\15\4\1\0\1\4\1"+
    "\0\2\4\1\0\2\4\1\0\1\4\3\3\4\0\4\3\5\0\6\4\5\0\1\3\4\0\3\4\1\0\1\4\3\0\3\3"+
    "\7\4\4\0\2\3\1\4\13\3\1\0\1\3\7\4\2\3\2\4\1\0\4\4\2\3\2\4\3\3\2\0\1\3\7\0"+
    "\1\4\1\3\1\4\6\3\3\4\2\0\11\3\3\4\1\3\6\0\2\4\6\3\4\4\2\3\4\0\1\3\2\0\1\4"+
    "\2\3\2\4\1\3\11\4\1\3\3\4\1\3\5\4\2\0\1\3\3\4\7\0\11\4\6\3\3\4\1\3\2\4\1\3"+
    "\7\4\2\3\2\4\2\0\2\4\1\3\3\4\1\0\10\3\2\0\2\3\2\0\6\3\1\0\7\3\1\0\1\3\3\0"+
    "\4\3\2\0\1\4\1\3\7\4\2\0\2\4\2\0\3\4\1\3\5\0\2\3\1\0\5\3\7\0\2\3\1\0\1\4\2"+
    "\0\3\4\1\0\4\3\1\0\2\3\1\0\2\3\1\0\2\3\2\0\1\4\1\0\5\4\4\0\2\4\2\0\3\4\3\0"+
    "\1\4\7\0\4\3\1\0\1\3\7\0\4\4\3\3\1\4\2\0\1\3\1\0\2\3\1\0\3\3\2\4\1\0\3\4\2"+
    "\0\1\3\10\0\1\3\6\4\5\0\3\4\2\0\1\4\1\3\1\0\6\3\3\0\3\3\1\0\4\3\3\0\2\3\1"+
    "\0\1\3\1\0\2\3\3\0\2\3\3\0\2\3\4\0\5\4\3\0\3\4\1\0\4\4\2\0\1\3\6\0\6\4\5\3"+
    "\3\0\1\3\7\4\1\0\2\4\5\0\2\4\1\0\4\3\1\0\3\3\1\0\2\3\5\0\3\3\2\4\1\3\3\4\1"+
    "\0\4\4\1\3\5\0\3\3\1\4\7\0\5\3\1\0\1\3\4\0\1\4\4\0\6\4\1\0\1\4\3\0\2\4\4\0"+
    "\1\3\1\4\2\3\7\4\4\0\10\3\10\4\1\0\3\3\1\0\10\3\1\0\1\3\1\0\1\3\5\4\1\3\2"+
    "\0\5\3\1\0\1\3\1\0\2\4\2\0\4\3\5\0\1\4\1\0\1\4\1\0\1\4\4\0\2\4\5\3\10\4\11"+
    "\0\1\4\1\0\7\4\1\3\2\4\4\3\3\4\1\3\3\4\2\3\7\4\3\3\4\4\5\3\14\4\1\3\1\4\3"+
    "\3\2\0\3\4\6\3\2\0\2\3\3\4\3\0\2\3\2\4\4\0\1\3\1\0\2\4\4\0\4\3\10\4\3\0\1"+
    "\3\3\0\2\3\1\4\5\0\4\4\1\0\5\3\2\4\2\3\1\4\1\3\5\0\1\4\7\0\3\4\5\3\2\4\3\0"+
    "\6\3\2\0\3\3\3\4\1\0\5\4\4\3\1\4\6\3\1\4\2\3\3\4\1\3\5\0\2\4\1\0\5\4\1\0\1"+
    "\3\1\0\1\3\1\0\1\3\1\0\1\3\2\0\3\3\1\0\6\3\2\0\2\3\2\1\5\4\5\0\1\3\4\0\1\4"+
    "\3\0\3\4\2\0\1\3\4\0\1\3\1\0\5\3\2\0\1\3\1\0\4\3\1\0\3\3\2\0\4\3\5\0\5\3\4"+
    "\0\1\3\4\0\4\3\3\4\2\3\5\0\2\4\2\0\3\3\4\0\12\4\1\0\3\3\1\4\3\3\1\4\4\3\1"+
    "\4\4\3\4\0\1\4\6\0\1\3\1\0\2\3\1\4\5\3\1\4\2\3\2\4\5\3\1\0\4\3\2\4\4\0\1\3"+
    "\3\4\2\3\1\4\5\3\2\4\3\0\3\3\4\0\3\3\2\4\2\0\6\3\1\0\3\4\1\0\2\4\5\0\5\3\5"+
    "\0\1\3\1\4\3\3\1\0\2\3\1\0\7\3\2\0\1\4\6\0\2\3\2\0\3\3\3\0\2\3\3\0\2\3\2\0"+
    "\3\4\4\0\3\3\1\0\2\3\1\0\1\3\5\0\1\4\2\0\3\4\5\0\1\3\3\0\1\3\2\0\4\3\1\0\2"+
    "\3\2\0\1\3\3\4\1\0\2\4\1\0\5\3\2\4\1\0\2\3\1\0\2\4\3\0\3\4\2\0\1\4\6\0\1\3"+
    "\2\4\4\3\1\4\2\0\1\3\1\0\1\4\4\3\4\0\4\4\1\0\4\4\1\3\1\0\1\3\3\0\4\4\1\0\5"+
    "\3\1\0\2\4\1\3\4\4\4\0\1\4\1\3\4\4\2\3\1\0\1\3\1\4\3\0\1\3\4\0\1\3\2\0\10"+
    "\3\1\0\2\3\1\0\1\4\2\0\4\4\1\3\1\4\1\3\2\4\6\0\7\4\1\3\1\0\1\3\1\4\3\0\2\4"+
    "\1\3\4\4\1\0\2\4\3\0\1\3\2\0\1\3\6\4\3\0\1\4\1\0\2\4\1\0\1\4\2\3\5\4\1\0\3"+
    "\3\4\4\1\0\3\3\4\0\1\4\2\3\1\0\1\3\1\4\7\0\6\3\3\0\2\4\1\0\2\4\3\0\6\4\2\0"+
    "\3\4\2\0\4\4\4\0\3\4\5\0\1\3\2\0\2\3\2\0\4\3\1\0\4\3\1\0\1\3\1\0\5\3\1\0\4"+
    "\3\1\0\4\3\2\0\3\4\2\0\7\4\1\0\2\4\1\0\4\4\4\0\1\3\1\0\2\4\5\0\1\3\3\4\1\3"+
    "\5\0\2\3\1\0\1\3\2\0\1\3\1\0\1\3\1\0\1\3\5\0\1\3\1\0\1\3\1\0\3\3\1\0\3\3\1"+
    "\0\3\3");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\7\0\1\1\2\2\1\3\1\4\1\5\1\6\1\7"+
    "\2\10\1\11\1\12\1\13\1\14\1\15\1\16";

  private static int [] zzUnpackAction() {
    int [] result = new int[23];
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
    "\0\0\0\15\0\32\0\47\0\64\0\101\0\116\0\133"+
    "\0\150\0\165\0\202\0\217\0\234\0\150\0\150\0\251"+
    "\0\266\0\150\0\150\0\150\0\150\0\150\0\251";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[23];
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
    "\6\10\1\11\1\12\5\10\1\11\1\13\1\14\1\15"+
    "\1\11\1\13\3\11\1\16\2\11\1\17\7\20\1\21"+
    "\3\20\1\22\1\20\1\11\2\13\2\11\1\13\4\11"+
    "\1\23\1\24\1\17\1\11\2\13\1\15\1\11\1\13"+
    "\3\11\1\16\1\25\1\11\1\17\1\11\2\13\2\11"+
    "\1\13\6\11\1\17\1\11\1\13\1\14\1\15\1\11"+
    "\1\13\3\11\1\16\1\23\1\11\1\17\6\10\2\0"+
    "\5\10\25\0\1\26\5\0\2\13\2\0\1\13\10\0"+
    "\1\13\1\14\2\0\1\13\12\0\3\15\7\0\13\20"+
    "\1\0\11\20\1\27\2\20\1\0\1\20";

  private static int [] zzUnpackTrans() {
    int [] result = new int[195];
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
    "\7\0\1\1\1\11\4\1\2\11\2\1\5\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[23];
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
          case 15: break;
          case 2: 
            { return TokenType.BAD_CHARACTER;
            } 
            // fall through
          case 16: break;
          case 3: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 17: break;
          case 4: 
            { yybegin(IN_FUNCTION_ARGS); return FakerTypes.PARAMS_LIST_BEGIN;
            } 
            // fall through
          case 18: break;
          case 5: 
            { return FakerTypes.IDENTIFIER;
            } 
            // fall through
          case 19: break;
          case 6: 
            { return FakerTypes.DOT;
            } 
            // fall through
          case 20: break;
          case 7: 
            { return FakerTypes.COMMA;
            } 
            // fall through
          case 21: break;
          case 8: 
            { return FakerTypes.STRING_LITERAL;
            } 
            // fall through
          case 22: break;
          case 9: 
            { yybegin(IN_FUNCTION_ARGS); return FakerTypes.PARAM_END;
            } 
            // fall through
          case 23: break;
          case 10: 
            { yybegin(YYINITIAL); return FakerTypes.EXPRESSION_RBRACE;
            } 
            // fall through
          case 24: break;
          case 11: 
            { yybegin(IN_PARAM); return FakerTypes.PARAM_BEGIN;
            } 
            // fall through
          case 25: break;
          case 12: 
            { yybegin(IN_PARAM); return FakerTypes.EXPRESSION_RBRACE;
            } 
            // fall through
          case 26: break;
          case 13: 
            { yybegin(AFTER_EXPRESSION_PREFIX); return FakerTypes.EXPRESSION_LBRACE;
            } 
            // fall through
          case 27: break;
          case 14: 
            { yybegin(IN_EXPRESSION); return FakerTypes.EXPRESSION_LBRACE;
            } 
            // fall through
          case 28: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
