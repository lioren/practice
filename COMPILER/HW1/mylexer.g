lexer grammar mylexer;

options {
  language = Java;
}

/*----------------------*/
/*   Reserved Keywords  */
/*----------------------*/
INT_TYPE  : 'int';
CHAR_TYPE : 'char';
VOID_TYPE : 'void';
FLOAT_TYPE: 'float';
DOUBLE_TYPE: 'double';
LONG_TYPE : 'long';
//fragment WHILE_    : 'while';
STATIC    : 'static';
ELSE      : 'else';
ENUM      : 'enum';
GOTO      : 'goto';
CONTINUE  : 'continue';
BREAK     : 'break';
DO        : 'do';
DEFAULT   : 'default';
SIZEOF    : 'sizeof';
STRUCT    : 'struct';
TYPEDEF   : 'typedef';
SIGNED    : 'signed';
UNSIGNED  : 'unsigned';
SWITCH    : 'switch';
RETURN    : 'return';
EOF_       : '\\0';
NEWLINE_   : '\\n';
TAB_       : '\\t';
//WHILEFUNCTION : (WHILE_) (.)*'\n' ;
//IFFUNCTION : (IF_) (.)*'\n
IF_  : 'if';
WHILE    : 'while';
/*----------------------*/
/*  Compound Operators  */
/*----------------------*/

EQ_OP : '==';
LE_OP : '<=';
GE_OP : '>=';
NE_OP : '!=';
PP_OP : '++';
MM_OP : '--';
EO1   : '&&' ;
EO2   : '||';
EO3   : '&' ;
EO4   : '|' ;
EO5   : '!' ;
EO6   : '^' ;
EO7   : '~' ;
EO8   : '%' ;
EO9   : '+' ;
EO10  : '-' ;
EO11  : '*' ;
EO12  : '/' ;


RSHIFT_OP : '<<';
LSHIFT_OP : '>>';


DEC_NUM : ('0' | ('1'..'9')(DIGIT)*);

ID : (LETTER)(LETTER | DIGIT)*;

FLOAT_NUM: FLOAT_NUM1 | FLOAT_NUM2 | FLOAT_NUM3;
fragment FLOAT_NUM1: (DIGIT)+'.'(DIGIT)*;
fragment FLOAT_NUM2: '.'(DIGIT)+;
fragment FLOAT_NUM3: (DIGIT)+;
 

/* Comments */
COMMENT1 : '//'(.)*'\n';
COMMENT2 : '/*' (options{greedy=false;}: .)* '*/';


NEW_LINE: '\n';
fragment LETTER : 'a'..'z' | 'A'..'Z' | '_' | '.';
fragment DIGIT : '0'..'9';
EXTRA1 : '#';
EXTRA2 : '<';
EXTRA3 : '>';
EXTRA4 : '(';
EXTRA5 : ')';
EXTRA6 : '{';
EXTRA7 : '}';
EXTRA8 : '=';
EXTRA9 : ',';
EXTRA10 : ';';
EXTRA11 : '\\';
EXTRA12 : '\'';
EXTRA13 : '"';

WS  : (' '|'\r'|'\t')+
    ;
