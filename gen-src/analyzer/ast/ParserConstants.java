/* Generated By:JJTree&JavaCC: Do not edit this line. ParserConstants.java */
package analyzer.ast;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface ParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int SINGLE_LINE_COMMENT = 5;
  /** RegularExpression Id. */
  int FORMAL_COMMENT = 6;
  /** RegularExpression Id. */
  int MULTI_LINE_COMMENT = 7;
  /** RegularExpression Id. */
  int IF = 9;
  /** RegularExpression Id. */
  int THEN = 10;
  /** RegularExpression Id. */
  int ELSE = 11;
  /** RegularExpression Id. */
  int WHILE = 12;
  /** RegularExpression Id. */
  int FOR = 13;
  /** RegularExpression Id. */
  int FOREACH = 14;
  /** RegularExpression Id. */
  int BOOLEAN = 15;
  /** RegularExpression Id. */
  int TRUE = 16;
  /** RegularExpression Id. */
  int FALSE = 17;
  /** RegularExpression Id. */
  int DEC = 18;
  /** RegularExpression Id. */
  int ENDDEC = 19;
  /** RegularExpression Id. */
  int TYPE = 20;
  /** RegularExpression Id. */
  int BOOL = 21;
  /** RegularExpression Id. */
  int NUM = 22;
  /** RegularExpression Id. */
  int REALVAL = 23;
  /** RegularExpression Id. */
  int ARRAYTYPE = 24;
  /** RegularExpression Id. */
  int LISTNUM = 25;
  /** RegularExpression Id. */
  int LISTBOOL = 26;
  /** RegularExpression Id. */
  int LISTREAL = 27;
  /** RegularExpression Id. */
  int ASSIGN = 28;
  /** RegularExpression Id. */
  int COMPARE = 29;
  /** RegularExpression Id. */
  int MULOP = 30;
  /** RegularExpression Id. */
  int BOOLOP = 31;
  /** RegularExpression Id. */
  int PLUS = 32;
  /** RegularExpression Id. */
  int MINUS = 33;
  /** RegularExpression Id. */
  int EQUAL = 34;
  /** RegularExpression Id. */
  int LESS = 35;
  /** RegularExpression Id. */
  int LESSEQUAL = 36;
  /** RegularExpression Id. */
  int GREAT = 37;
  /** RegularExpression Id. */
  int GREATEQUAL = 38;
  /** RegularExpression Id. */
  int DIFF = 39;
  /** RegularExpression Id. */
  int EQUALEQUAL = 40;
  /** RegularExpression Id. */
  int FOIS = 41;
  /** RegularExpression Id. */
  int DIV = 42;
  /** RegularExpression Id. */
  int MOD = 43;
  /** RegularExpression Id. */
  int AND = 44;
  /** RegularExpression Id. */
  int OR = 45;
  /** RegularExpression Id. */
  int NOT = 46;
  /** RegularExpression Id. */
  int LPAREN = 47;
  /** RegularExpression Id. */
  int RPAREN = 48;
  /** RegularExpression Id. */
  int LACC = 49;
  /** RegularExpression Id. */
  int RACC = 50;
  /** RegularExpression Id. */
  int LSBRAC = 51;
  /** RegularExpression Id. */
  int RSBRAC = 52;
  /** RegularExpression Id. */
  int COLON = 53;
  /** RegularExpression Id. */
  int SEMICOLON = 54;
  /** RegularExpression Id. */
  int IDENTIFIER = 55;
  /** RegularExpression Id. */
  int LETTER = 56;
  /** RegularExpression Id. */
  int DIGIT = 57;
  /** RegularExpression Id. */
  int INTEGER = 58;
  /** RegularExpression Id. */
  int REAL = 59;
  /** RegularExpression Id. */
  int EXPONENT = 60;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int IN_SINGLE_LINE_COMMENT = 1;
  /** Lexical state. */
  int IN_FORMAL_COMMENT = 2;
  /** Lexical state. */
  int IN_MULTI_LINE_COMMENT = 3;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "<token of kind 1>",
    "\"//\"",
    "<token of kind 3>",
    "\"/*\"",
    "<SINGLE_LINE_COMMENT>",
    "\"*/\"",
    "\"*/\"",
    "<token of kind 8>",
    "\"if\"",
    "\"then\"",
    "\"else\"",
    "\"while\"",
    "\"for\"",
    "\"foreach\"",
    "<BOOLEAN>",
    "\"true\"",
    "\"false\"",
    "\"Declaration\"",
    "\"EndDeclaration\"",
    "<TYPE>",
    "\"bool\"",
    "\"num\"",
    "\"real\"",
    "<ARRAYTYPE>",
    "\"listnum\"",
    "\"listbool\"",
    "\"listreal\"",
    "<ASSIGN>",
    "<COMPARE>",
    "<MULOP>",
    "<BOOLOP>",
    "\"+\"",
    "\"-\"",
    "\"=\"",
    "\"<\"",
    "\"<=\"",
    "\">\"",
    "\">=\"",
    "\"!=\"",
    "\"==\"",
    "\"*\"",
    "\"/\"",
    "\"%\"",
    "\"&&\"",
    "\"||\"",
    "\"!\"",
    "\"(\"",
    "\")\"",
    "\"{\"",
    "\"}\"",
    "\"[\"",
    "\"]\"",
    "\":\"",
    "\";\"",
    "<IDENTIFIER>",
    "<LETTER>",
    "<DIGIT>",
    "<INTEGER>",
    "<REAL>",
    "<EXPONENT>",
  };

}
