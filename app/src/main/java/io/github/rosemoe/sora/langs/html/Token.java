package io.github.rosemoe.sora.langs.html;

public enum Token {
  WHITESPACE,
  NEWLINE,
  UNKNOWN,
  EOF,
  HTMLCOMMENTSTART,
  HTMLCOMMENTEND,
  CSSCOMMENTSTART,
  CSSCOMMENTEND,
  SHARP,
  // 注释类 Comments
  LONG_COMMENT, // 长注释 Long comment
  LINE_COMMENT, // 单行注释 Single line comment
  DIVS,
  MULT, // 乘
  IDENTIFIER, // 标识符
  INTEGER_LITERAL, // 整数
  DOT, // 点
  MINUS, // 减
  STRING, // 字符串
  CHARACTER_LITERAL, // 字符
  LPAREN, // 左小括号
  RPAREN, // 右小括号
  LBRACE, // 左大括号
  RBRACE, // 右大括号
  LBRACK, // 左中括号
  RBRACK, // 右中括号
  SEMICOLON, // 分号
  COMMA, // 逗号
  EQ, // 等于
  GT, // 大于
  LT, // 小于
  NOT, // 非
  COMP, // ~
  QUESTION, // 问号
  COLON, // 冒号
  AND, // 与
  OR, // 或
  PLUS, // 加
  XOR, // 异或
  MOD, // 百分号
  DIVEQ,
  MULTEQ,
  FLOATING_POINT_LITERAL, // 浮点数
  MINUSMINUS, // 减减
  MINUSEQ,
  EQEQ, // 等于等于
  GTEQ,
  RSHIFT, // 右位移
  LTEQ,
  LSHIFT, // 左位移
  NOTEQ,
  ANDEQ,
  ANDAND, // 与与
  OREQ,
  OROR, // 或或
  PLUSEQ,
  PLUSPLUS, // 加加
  XOREQ,
  MODEQ,
  RSHIFTEQ,
  URSHIFT,
  LSHIFTEQ,
  URSHIFTEQ,
  AT,
  //// Html5 keyword
  A,
  ABBR,
  ACRONYM,
  ADDRESS,
  APPLET,
  ARTICLE,
  ASIDE,
  AUDIO,
  B,
  BASEFONT,
  BDI,
  BDO,
  BGSOUND,
  BIG,
  BLINK,
  BLOCKQUOTE,
  BODY,
  BUTTON,
  CANVAS,
  CAPTION,
  CENTER,
  CIRCLE,
  CLIPPATH,
  CODE,
  COLGROUP,
  COMMAND,
  DATALIST,
  DD,
  DEFS,
  DEL,
  DETAILS,
  DFN,
  DIALOG,
  DIR,
  DIV,
  DL,
  DT,
  ELEMENT,
  ELLIPSE,
  EM,
  FIELDSET,
  FIGCAPTION,
  FIGURE,
  FOOTER,
  FOREIGNOBJECT,
  FORM,
  FRAME,
  FRAMESET,
  G,
  H1,
  H2,
  H3,
  H4,
  H5,
  H6,
  HEAD,
  HEADER,
  HGROUP,
  HTML,
  I,
  IFRAME,
  IMAGE,
  INS,
  ISINDEX,
  KBD,
  LABEL,
  LEGEND,
  LI,
  LINE,
  LINEARGRADIENT,
  LISTING,
  MAIN,
  MAP,
  MARK,
  MARQUEE,
  MASK,
  MATH,
  MENU,
  MENUITEM,
  METER,
  MULTICOL,
  NAV,
  NEXTID,
  NOBR,
  NOEMBED,
  NOFRAMES,
  NOSCRIPT,
  OBJECT,
  OL,
  OPTGROUP,
  OPTION,
  OUTPUT,
  P,
  PATH,
  PATTERN,
  PICTURE,
  PLAINTEXT,
  POLYGON,
  POLYLINE,
  PRE,
  PROGRESS,
  Q,
  RADIALGRADIENT,
  RB,
  RBC,
  RECT,
  RP,
  RT,
  RTC,
  RUBY,
  S,
  SAMP,
  SCRIPT,
  SECTION,
  SELECT,
  SHADOW,
  SLOT,
  SMALL,
  SPACER,
  SPAN,
  STOP,
  STRIKE,
  STRONG,
  STYLE,
  NOSTYLE,
  SUB,
  SUMMARY,
  SUP,
  SVG,
  TABLE,
  TBODY,
  TD,
  TEMPLATE,
  TEXT,
  TEXTAREA,
  TFOOT,
  TH,
  THEAD,
  TIME,
  TITLE,
  TR,
  TSPAN,
  TT,
  U,
  UL,

  VIDEO,
  XMP,
  CLASS,
  META,
  //// css3
  ALIGN_CONTENT,
  ALIGN_ITEMS,
  ALIGN_SELF,
  ALL,
  ANIMATION,
  ANIMATION_DELAY,
  ANIMATION_DIRECTION,
  ANIMATION_DURATION,
  ANIMATION_FILL_MODE,
  ANIMATION_ITERATION_COUNT,
  ANIMATION_NAME,
  ANIMATION_PLAY_STATE,
  ANIMATION_TIMING_FUNCTION,
  BACKFACE_VISIBILITY,
  BACKGROUND,
  BACKGROUND_ATTACHMENT,
  BACKGROUND_BLUR,
  BACKGROUND_CLIP,
  BACKGROUND_COLOR,
  BACKGROUND_IMAGE,
  BACKGROUND_ORIGIN,
  BACKGROUND_POSITION,
  BACKGROUND_REPEAT,
  BACKGROUND_SIZE,
  BORDER_BOTTOM,
  BORDER_BOTTOM_COLOR,
  BORDER_BOTTOM_LEFT_RADIUS,
  BORDER_BOTTOM_RIGHT_RADIUS,
  BORDER_BOTTOM_STYLE,
  BORDER_BOTTOM_WIDTH,
  BORDER_COLLAPSE,
  BORDER_COLOR,
  BORDER_IMAGE,
  BORDER_IMAGE_OUTSET,
  BORDER_IMAGE_REPEAT,
  BORDER_IMAGE_SLICE,
  BORDER_IMAGE_SOURCE,
  BORDER_IMAGE_WIDTH,
  BORDER_LEFT,
  BORDER_LEFT_COLOR,
  BORDER_LEFT_STYLE,
  BORDER_LEFT_WIDTH,
  BORDER_RADIUS,
  BORDER_RIGHT,
  BORDER_RIGHT_COLOR,
  BORDER_RIGHT_STYLE,
  BORDER_RIGHT_WIDTH,
  BORDER_SPACING,
  BORDER_STYLE,
  BORDER_TOP,
  BORDER_TOP_COLOR,
  BORDER_TOP_LEFT_RADIUS,
  BORDER_TOP_RIGHT_RADIUS,
  BORDER_TOP_STYLE,
  BORDER_TOP_WIDTH,
  BORDER_WIDTH,
  BOTTOM,
  BOX_DECORATION_BREAK,
  BOX_SHADOW,
  BOX_SIZING,
  BREAK_AFTER,
  BREAK_BEFORE,
  BREAK_INSIDE,
  CAPTION_SIDE,
  CARET_COLOR,
  CLEAR,
  CLIP,
  COLOR,
  COLUMN_COUNT,
  COLUMN_FILL,
  COLUMN_GAP,
  COLUMN_RULE,
  COLUMN_RULE_COLOR,
  COLUMN_RULE_STYLE,
  COLUMN_RULE_WIDTH,
  COLUMN_SPAN,
  COLUMN_WIDTH,
  COLUMNS,
  COUNTER_INCREMENT,
  COUNTER_RESET,
  CURSOR,
  DIRECTION,
  DISPLAY,
  EMPTY_CELLS,
  FILTER,
  FLEX,
  FLEX_BASIS,
  FLEX_DIRECTION,
  FLEX_FLOW,
  FLEX_GROW,
  FLEX_SHRINK,
  FLEX_WRAP,
  FONT,
  FONT_FAMILY,
  FONT_SIZE,
  FONT_SIZE_ADJUST,
  FONT_STRETCH,
  FONT_STYLE,
  FONT_VARIANT,
  FONT_VARIANT_CAPS,
  FONT_WEIGHT,
  GAP,
  GRID,
  GRID_AREA,
  GRID_AUTO_COLUMNS,
  GRID_AUTO_FLOW,
  GRID_AUTO_ROWS,
  GRID_COLUMN,
  GRID_COLUMN_END,
  GRID_COLUMN_GAP,
  GRID_COLUMN_START,
  GRID_GAP,
  GRID_ROW,
  GRID_ROW_END,
  GRID_ROW_GAP,
  GRID_ROW_START,
  GRID_TEMPLATE,
  GRID_TEMPLATE_AREAS,
  GRID_TEMPLATE_COLUMNS,
  GRID_TEMPLATE_ROWS,
  HEIGHT,
  IME_MODE,
  JUSTIFY_CONTENT,
  LEFT,
  LETTER_SPACING,
  LINE_BREAK,
  LINE_HEIGHT,
  LIST_STYLE,
  LIST_STYLE_IMAGE,
  LIST_STYLE_POSITION,
  LIST_STYLE_TYPE,
  MARGIN,
  MARGIN_BOTTOM,
  MARGIN_LEFT,
  MARGIN_RIGHT,
  MARGIN_TOP,
  MARKER_OFFSET,
  MAX_HEIGHT,
  MAX_WIDTH,
  MIN_HEIGHT,
  MIN_WIDTH,
  MIX_BLEND_MODE,
  OBJECT_FIT,
  OBJECT_POSITION,
  OPACITY,
  ORDER,
  ORPHANS,
  OUTLINE,
  OUTLINE_COLOR,
  OUTLINE_OFFSET,
  OUTLINE_STYLE,
  OUTLINE_WIDTH,
  OVERFLOW,
  OVERFLOW_WRAP,
  OVERFLOW_X,
  OVERFLOW_Y,
  PADDING,
  PADDING_BOTTOM,
  PADDING_LEFT,
  PADDING_RIGHT,
  PADDING_TOP,
  PAGE_BREAK_AFTER,
  PAGE_BREAK_BEFORE,
  PAGE_BREAK_INSIDE,
  PERSPECTIVE,
  PERSPECTIVE_ORIGIN,
  POINTER_EVENTS,
  POSITION,
  QUOTES,
  RESIZE,
  RIGHT,
  ROW_GAP,
  SCROLL_BEHAVIOR,
  SPEAK,
  TABLE_LAYOUT,
  TAB_SIZE,
  TEXT_ALIGN,
  TEXT_ALIGN_LAST,
  TEXT_DECORATION,
  TEXT_DECORATION_COLOR,
  TEXT_DECORATION_LINE,
  TEXT_DECORATION_SKIP,
  TEXT_DECORATION_STYLE,
  TEXT_INDENT,
  TEXT_JUSTIFY,
  TEXT_OVERFLOW,
  TEXT_SHADOW,
  TEXT_TRANSFORM,
  TEXT_UNDERLINE_POSITION,
  TOP,
  TRANSFORM,
  TRANSFORM_ORIGIN,
  TRANSFORM_STYLE,
  TRANSITION,
  TRANSITION_DELAY,
  TRANSITION_DURATION,
  TRANSITION_PROPERTY,
  TRANSITION_TIMING_FUNCTION,
  UNICODE_BIDI,
  VERTICAL_ALIGN,
  VISIBILITY,
  WHITE_SPACE,
  WIDOWS,
  WIDTH,
  WILL_CHANGE,
  WORD_BREAK,
  WORD_SPACING,
  WORD_WRAP,
  WRITING_MODE,
  Z_INDEX,
  /// Js
  ABSTRACT,
  ELSE,
  INSTANCEOF,
  SUPER,
  BOOLEAN,
  ENUM,
  INT,
  SWITCH,
  BREAK,
  EXPORT,
  INTERFACE,
  SYNCHRONIZED,
  BYTE,
  EXTENDS,
  LET,
  THIS,
  CASE,
  FALSE,
  LONG,
  THROW,
  CATCH,
  FINAL,
  NATIVE,
  THROWS,
  CHAR,
  FINALLY,
  NEW,
  TRANSIENT,
  FLOAT,
  NULL,
  TRUE,
  CONST,
  FOR,
  PACKAGE,
  TRY,
  CONTINUE,
  FUNCTION,
  PRIVATE,
  TYPEOF,
  DEBUGGER,
  GOTO,
  PROTECTED,
  VAR,

  IF,
  PUBLIC,
  VOID,
  DELETE,
  IMPLEMENTS,
  RETURN,
  VOLATILE,
  DO,
  IMPORT,
  SHORT,
  WHILE,
  DOUBLE,
  IN,
  STATIC,
  WITH,
  OF,
  CONSOLE,
  LOG,
  PROTOTYPE,
  ALERT,
  SUPPORT,
  YIELD,
  ASYNC,
  DOCUMENT,
  ARGUMENTS,
  PARSEINT,
  AWAIT,
  UNDEFINED,
  PARSEFLOAT,
  GET,
  STORAGE,
  INFINITY,
  ESCAPE,
  __COUNT__,
  __PARENT__,
  __PROTO__,
  WINDOW,
  EVAL,
  GETELEMENTBYID,
  GETELEMENTBYCLASS,
  // attr html 5 ghost web full mode
  // tnks for ninja coder this in code for ghostweb ide dont using for other apps tnks
  // this code form ghost web ide 1.5.7 static mod
  ACCEPT,
  ACCESSKEY,
  ACTION,
  ALIGN,
  ALT,
  AUTOCOMPLETE,
  AUTOFOCUS,
  AUTOPLAY,
  BORDER,
  BGCOLOR,
  CHARSET,
  CHECKED,
  CITE,
  COLS,
  COLSPAN,
  CONTENT,
  CONTENTEDITABLE,
  CONTROLS,
  COORDS,
  DATA,
  DATETIME,
  DEFAULT,
  DEFER,
  DIRNAME,
  DISABLED,
  DRAGGABLE,
  DROPZONE,
  ENCTYPE,
  FACE,
  FORMACTION,
  HEADERS,

  HIGH,
  HREF,
  HREFLANG,
  HTTP,
  EQUIV,
  ID,
  ISMAP,
  KIND,
  LANG,
  LIST,
  LOOP,
  LOW,
  MAX,
  MAXLENGTH,
  MEDIA,
  METHOD,
  MIN,
  MULTIPLE,
  MUTED,
  NAME,
  NOVALIDATE,
  ONABORT,
  ONAFTERPRINT,
  ONBEFOREPRINT,
  ONBEFOREUNLOAD,
  ONBLUR,
  ONCANPLAY,
  ONCANPLAYTHROUGH,
  ONCHANGE,
  ONCLICK,
  ONCONTEXTMENU,
  ONCOPY,
  ONCUECHANGE,
  ONCUT,
  ONDBLCLICK,
  ONDRAG,
  ONDRAGEND,
  ONDRAGENTER,
  ONDRAGLEAVE,
  ONDRAGOVER,
  ONDRAGSTART,
  ONDROP,
  ONDURATIONCHANGE,
  ONEMPTIED,
  ONENDED,
  ONERROR,
  ONFOCUS,
  ONHASHCHANGE,
  ONINPUT,
  ONINVALID,
  ONKEYDOWN,
  ONKEYPRESS,
  ONKEYUP,
  ONLOAD,
  ONLOADEDDATA,
  ONLOADEDMETADATA,
  ONLOADSTART,
  ONMOUSEDOWN,
  ONMOUSEMOVE,
  ONMOUSEOUT,
  ONMOUSEOVER,
  ONMOUSEUP,
  ONMOUSEWHEEL,
  ONOFFLINE,
  ONONLINE,
  ONPAGEHIDE,
  ONPAGESHOW,
  ONPASTE,
  ONPLAY,
  ONPLAYING,
  ONPOPSTATE,
  ONPROGRESS,
  ONRATECHANGE,
  ONRESET,
  ONRESIZE,
  ONSCROLL,
  ONSEARCH,
  ONSEEKED,
  ONSEEKING,
  ONSELECT,
  ONSTALLED,
  ONSTORAGE,
  ONSUBMIT,
  ONSUSPEND,
  ONTIMEUPDATE,
  ONTOGGLE,
  ONUNLOAD,
  ONVOLUMECHANGE,
  ONWAITING,
  ONWHEEL,
  OPEN,
  OPTIMUM,
  PLACEHOLDER,
  POSTER,
  PRELOAD,
  READONLY,
  REL,
  REQUIRED,
  REVERSED,
  ROWS,
  ROWSPAN,
  SANDBOX,
  SCOPE,
  SELECTED,
  SHAPE,
  SIZE,
  SIZES,
  SPELLCHECK,
  SRC,
  SRCDOC,
  SRCLANG,
  SRCSET,
  START,
  STEP,
  TABINDEX,
  TARGET,
  TRANSLATE,
  TYPE,
  USEMAP,
  VALUE,
  WRAP,
  /// html attr
  AREA,
  BASE,
  BR,
  COL,
  EMBED,
  HR,
  IMG,
  INPUT,
  KEYGEN,
  LINK,
  PARAM,
  SOURCE,
  TRACK,
  WBR,
  /// css3 attr
  PX,
  VIM,
  REM,
  VH,
  VW,
  PT,
  CM,
  MM,
  PC,
  EX,
  CH,
  DEG,
  GRAD,
  RAD,
  TURN,
  MS,
  FR,
  UNDERLINE,
  ITALIC,
  BOLD,
  NORMAL,
  RGBA,
  HSL,
  URL,
  NONE,
  BLOCK,
  INLINE,
  CELL,
  ROW,
  ABSOLUTE,
  RELATIVE,
  FIXED,
  COLLAPSE,
  VISIBLE,
  UPPERCASE,
  LOWERCASE,
  CAPITALIZE,
  SHRINK,
  REVERSE,
  NOWRAP,
  HORIZONTAL,
  VERTICAL,
  REPEAT,
  NO,
  /// the color see beta test
  RED,
  // TagSlash -></
  TAGSLASH,
  ALICEBLUE,
  //new Color
  ANTIQUEWHITE,
  AQUA,
  AQUAMARINE,
  AZURE,
  BEIGE,
  BISQUE,
  BLACK,
  BLANCHEDALMOND,
  BLUE,
  BLUEVIOLET,
  
  BROWN
  
}
