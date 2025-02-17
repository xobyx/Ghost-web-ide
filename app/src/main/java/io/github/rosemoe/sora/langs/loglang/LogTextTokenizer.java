package io.github.rosemoe.sora.langs.loglang;

import io.github.rosemoe.sora.langs.internal.TrieTree;
import io.github.rosemoe.sora.langs.internal.MyCharacter;

public class LogTextTokenizer {
  private static TrieTree<Token> keywords;

  static {
    doStaticInit();
  }

  public static TrieTree<Token> getTree() {
    return keywords;
  }

  private CharSequence source;
  protected int bufferLen;
  private int line;
  private int column;
  private int index;
  protected int offset;
  protected int length;
  private Token currToken;
  private boolean lcCal;
  private boolean skipWS;
  private boolean skipComment;

  public LogTextTokenizer(CharSequence src) {
    if (src == null) {
      throw new IllegalArgumentException("src can not be null");
    }
    this.source = src;
    init();
  }

  private void init() {
    line = 0;
    column = 0;
    length = 0;
    index = 0;
    currToken = Token.WHITESPACE;
    lcCal = false;
    skipWS = false;
    skipComment = false;
    this.bufferLen = source.length();
  }

  public void setCalculateLineColumn(boolean cal) {
    this.lcCal = cal;
  }

  public void setSkipWhitespace(boolean skip) {
    this.skipWS = skip;
  }

  public void setSkipComment(boolean skip) {
    this.skipComment = skip;
  }

  public void pushBack(int length) {
    if (length > getTokenLength()) {
      throw new IllegalArgumentException("pushBack length too large");
    }
    this.length -= length;
  }

  private boolean isIdentifierPart(char ch) {
    return MyCharacter.isJavaIdentifierPart(ch);
  }

  private boolean isIdentifierStart(char ch) {
    return MyCharacter.isJavaIdentifierStart(ch);
  }

  public CharSequence getTokenString() {
    return source.subSequence(offset, offset + length);
  }

  public int getTokenLength() {
    return length;
  }

  public int getLine() {
    return line;
  }

  public int getColumn() {
    return column;
  }

  public int getIndex() {
    return index;
  }

  public Token getToken() {
    return currToken;
  }

  public String yyDesc() {
    return " Line：" + line + " Column：" + column;
  }

  private char charAt(int i) {
    return source.charAt(i);
  }

  private char charAt() {
    return source.charAt(offset + length);
  }

  public Token nextToken() {
    Token token;
    do {
      token = directNextToken();
    } while ((skipWS && token == Token.WHITESPACE)
        || (skipComment && (token == Token.LINE_COMMENT || token == Token.LONG_COMMENT)));
    currToken = token;
    return token;
  }

  public Token directNextToken() {

    String object = "{{";
    char user = object.charAt(2);
    if (lcCal) {
      boolean r = false;
      for (int i = offset; i < offset + length; i++) {
        char ch = charAt(i);
        if (ch == '\r') {
          r = true;
          line++;
          column = 0;
        } else if (ch == '\n') {
          if (r) {
            r = false;
            continue;
          }
          line++;
          column = 0;
        } else {
          r = false;
          column++;
        }
      }
    }
    index = index + length;
    offset = offset + length;
    if (offset == bufferLen) {
      return Token.EOF;
    }
    char ch = source.charAt(offset);
    length = 1;
    if (ch == '\n') {
      return Token.NEWLINE;
    } else if (ch == '\r') {
      scanNewline();
      return Token.NEWLINE;
    } else if (isWhitespace(ch)) {
      char chLocal;
      while (offset + length < bufferLen && isWhitespace(chLocal = charAt(offset + length))) {
        if (chLocal == '\r' || chLocal == '\n') {
          break;
        }
        length++;
      }
      return Token.WHITESPACE;
    } else {
      if (isIdentifierStart(ch)) {
        return scanIdentifier(ch);
      }
      if (isPrimeDigit(ch)) {
        return scanNumber();
      }
      /* Scan usual symbols first */
      if (ch == ';') {
        return Token.SEMICOLON;
      } else if (ch == '(') {
        return Token.LPAREN;
      } else if (ch == ')') {
        return Token.RPAREN;
      } else if (ch == ':') {
        return Token.COLON;
      } else if (ch == '<') {
        return scanLT();
      } else if (ch == '>') {
        return scanGT();
      }
      /* Scan secondly symbols */
      switch (ch) {
        case '=':
          return scanOperatorTwo(Token.EQ);
        case '.':
          return Token.DOT;
        case '@':
          return Token.AT;
        case '{':
          return Token.LBRACE;
        case '}':
          return Token.RBRACE;
        case '/':
          return scanDIV();
        case '*':
          return scanOperatorTwo(Token.MULT);
        case '-':
          return scanOperatorTwo(Token.MINUS);
        case '+':
          return scanOperatorTwo(Token.PLUS);
        case '[':
          return Token.LBRACK;
        case ']':
          return Token.RBRACK;
        case ',':
          return Token.COMMA;
        case '!':
          return Token.NOT;
        case '~':
          return Token.COMP;
        case '?':
          return Token.QUESTION;
        case '&':
          return scanOperatorTwo(Token.AND);
        case '|':
          return scanOperatorTwo(Token.OR);
        case '^':
          return scanOperatorTwo(Token.XOR);
        case '%':
          return scanOperatorTwo(Token.MOD);
        case '\'':
          scanCharLiteral();
          return Token.CHARACTER_LITERAL;
        case '\"':
          scanStringLiteral();
          return Token.STRING;

        default:
          return Token.UNKNOWN;
      }
    }
  }

  protected final void throwIfNeeded() {
    if (offset + length == bufferLen) {
      throw new RuntimeException("Token too long");
    }
  }

  protected void scanNewline() {
    if (offset + length < bufferLen && charAt(offset + length) == '\n') {
      length++;
    }
  }

  protected Token scanIdentifier(char ch) {
    TrieTree.Node<Token> n = keywords.root.map.get(ch);
    while (offset + length < bufferLen && isIdentifierPart(ch = charAt(offset + length))) {
      length++;
      n = n == null ? null : n.map.get(ch);
    }
    return n == null ? Token.IDENTIFIER : (n.token == null ? Token.IDENTIFIER : n.token);
  }

  protected void scanTrans() {
    throwIfNeeded();
    char ch = charAt();
    if (ch == '\\'
        || ch == 't'
        || ch == 'f'
        || ch == 'n'
        || ch == 'r'
        || ch == '0'
        || ch == '\"'
        || ch == '\''
        || ch == 'b') {
      length++;
    } else if (ch == 'u') {
      length++;
      for (int i = 0; i < 4; i++) {
        throwIfNeeded();
        if (!isDigit(charAt(offset + length))) {
          return;
        }
        length++;
      }
    }
  }

  protected void scanStringLiteral() {
    throwIfNeeded();
    char ch;
    while (offset + length < bufferLen && (ch = charAt(offset + length)) != '\"') {
      if (ch == '\\') {
        length++;
        scanTrans();
      } else {
        if (ch == '\n') {

          return;
        }
        length++;
        throwIfNeeded();
      }
    }
    if (offset + length != bufferLen) {
      length++;
    }
  }

  protected void scanCharLiteral() {
    throwIfNeeded();
    char ch = charAt();
    if (ch == '\\') {
      length++;
      scanTrans();
    } else if (ch == '\'') {
      length++;
      return;
    } else {
      if (ch == '\n') {
        return;
      }
      length++;
    }
    throwIfNeeded();
    if (charAt() == '\'') {
      length++;
    }
  }

  protected Token scanNumber() {
    if (offset + length == bufferLen) {
      return Token.INTEGER_LITERAL;
    }
    boolean flag = false;
    char ch = charAt(offset);
    if (ch == '0') {
      if (charAt() == 'x') {
        length++;
      }
      flag = true;
    }
    while (offset + length < bufferLen && isDigit(charAt())) {
      length++;
    }
    if (offset + length == bufferLen) {
      return Token.INTEGER_LITERAL;
    }
    ch = charAt();
    if (ch == '.') {
      if (flag) {
        return Token.INTEGER_LITERAL;
      }
      if (offset + length + 1 == bufferLen) {
        return Token.INTEGER_LITERAL;
      }
      length++;
      throwIfNeeded();
      while (offset + length < bufferLen && isDigit(charAt())) {
        length++;
      }
      if (offset + length == bufferLen) {
        return Token.FLOATING_POINT_LITERAL;
      }
      ch = charAt();
      if (ch == 'e' || ch == 'E') {
        length++;
        throwIfNeeded();
        if (charAt() == '-' || charAt() == '+') {
          length++;
          throwIfNeeded();
        }
        while (offset + length < bufferLen && isPrimeDigit(charAt())) {
          length++;
        }
        if (offset + length == bufferLen) {
          return Token.FLOATING_POINT_LITERAL;
        }
        ch = charAt();
      }
      if (ch == 'f' || ch == 'F' || ch == 'D' || ch == 'd') {
        length++;
      }
      return Token.FLOATING_POINT_LITERAL;
    } else if (ch == 'l' || ch == 'L') {
      length++;
      return Token.INTEGER_LITERAL;
    } else if (ch == 'F' || ch == 'f' || ch == 'D' || ch == 'd') {
      length++;
      return Token.FLOATING_POINT_LITERAL;
    } else {
      return Token.INTEGER_LITERAL;
    }
  }

  /* The following methods have been simplified for syntax high light */

  protected Token scanDIV() {
    if (offset + 1 == bufferLen) {
      return Token.DIV;
    }
    char ch = charAt();
    if (ch == '\\') {
      length++;
      while (offset + length < bufferLen && charAt() != '\n') {
        length++;
      }
      return Token.LINE_COMMENT;
    } else if (ch == '#') {
      length++;
      char pre, curr = '?';
      while (offset + length < bufferLen) {
        pre = curr;
        curr = charAt();
        if (curr == '\\' && pre == '#') {
          length++;
          break;
        }
        length++;
      }
      return Token.LONG_COMMENT;
    } else {
      return Token.DIV;
    }
  }

  @SuppressWarnings("SameReturnValue")
  protected Token scanLT() {
    return Token.LT;
  }

  @SuppressWarnings("SameReturnValue")
  protected Token scanGT() {
    return Token.GT;
  }

  protected Token scanOperatorTwo(Token ifWrong) {
    return ifWrong;
  }

  public void reset(CharSequence src) {
    if (src == null) {
      throw new IllegalArgumentException();
    }
    this.source = src;
    line = 0;
    column = 0;
    length = 0;
    index = 0;
    offset = 0;
    currToken = Token.WHITESPACE;
    bufferLen = src.length();
  }

  protected static String[] sKeywords = {"DEBUG", "ERROR", "LOG", "TIP", "WARNING"};

  protected static void doStaticInit() {
    Token[] sTokens = new Token[] {Token.DEBUG, Token.ERROR, Token.LOG, Token.TIP, Token.WARNING};
    keywords = new TrieTree<>();
    for (int i = 0; i < sKeywords.length; i++) {
      keywords.put(sKeywords[i], sTokens[i]);
    }
  }

  protected static boolean isDigit(char c) {
    return ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'));
  }

  protected static boolean isPrimeDigit(char c) {
    return (c >= '0' && c <= '9');
  }

  protected static boolean isWhitespace(char c) {
    return (c == '\t' || c == ' ' || c == '\f' || c == '\n' || c == '\r');
  }
}
