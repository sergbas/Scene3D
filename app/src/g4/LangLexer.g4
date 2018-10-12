lexer grammar LangLexer;

SCENE : 'scene' ;
ID : [a-zA-Z0-9]+ ;
OBJECT3D
    : 'sphere'
    | 'cube'
    | 'cylinder'
    | 'thorus'
    | 'cone'
    ;

EQUAL:               '=';
DIGITS : [0-9]+ ;

L_CURLY_BRACE : '{' ;
R_CURLY_BRACE : '}' ;

GREATER:             '>';
LESS:                '<';
EXCLAMATION:         '!';

PLUS_ASSIGN:         '+=';
MINUS_ASSIGN:        '-=';
MULT_ASSIGN:         '*=';
DIV_ASSIGN:          '/=';
MOD_ASSIGN:          '%=';
AND_ASSIGN:          '&=';
XOR_ASSIGN:          '^=';
OR_ASSIGN:           '|=';

DOUBLE_BAR:          '||';
DOT:                 '.';
UNDERLINE:           '_';
AT:                  '@';
SHARP:               '#';
DOLLAR:              '$';
LR_BRACKET:          '(';
RR_BRACKET:          ')';
COMMA:               ',';
SEMI:                ';';
COLON:               ':';
STAR:                '*';
DIVIDE:              '/';
MODULE:              '%';
PLUS:                '+';
MINUS:               '-';
BIT_NOT:             '~';
BIT_OR:              '|';
BIT_AND:             '&';
BIT_XOR:             '^';

WS : [ \t\n\r]+ -> skip ;