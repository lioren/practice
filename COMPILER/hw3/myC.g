 grammar myC;

options {
  language = Java;
}

@header {
  import java.lang.*;
  import java.io.*;
  import java.util.HashMap;
}

@members {
boolean TRACEON = false;
HashMap<String,Integer>symtab = new HashMap<String,Integer>();
}

program:  MAIN S_L S_R B_L declarations statements B_R
        {if (TRACEON) System.out.println("MAIN () {declarations statements}");};

declarations:type Identifier ';' declarations
             { if (TRACEON) System.out.println("declarations: type Identifier : declarations");
             if(symtab.containsKey($Identifier.text)){
             		 System.out.println("Type Error:"+$Identifier.getLine()+":Redeclared identifier.");
			 }
			 else{
			 		 symtab.put($Identifier.text,$type.attr_type);
			 }}
           | type Identifier '=' arith_expression ';' declarations
             { if (TRACEON) System.out.println("declarations: type Identifier : declarations");
             if(symtab.containsKey($Identifier.text)){
             		 System.out.println("Type Error:"+$Identifier.getLine()+":Redeclared identifier.");
			 }
			 else{
			 		 symtab.put($Identifier.text,$type.attr_type);
			 }}
           | { if (TRACEON) System.out.println("declarations: ");} ;

type returns [int attr_type]: 
	INT_TYPE { if (TRACEON) System.out.println("type: INT");$attr_type=1;}
   | FLOAT_TYPE {if (TRACEON) System.out.println("type: FLOAT");$attr_type=2;}
   | CHAR_TYPE{if (TRACEON) System.out.println("type:CHAR");$attr_type=3;}
   | DOUBLE_TYPE{if (TRACEON) System.out.println("type:DOUBLE");$attr_type=4;}
   | INT_TYPE '*'{if (TRACEON) System.out.println("type:Pointer to int");}
   | CHAR_TYPE '*'{if (TRACEON) System.out.println("type:Pointer to char");}
   ;
statements:statement statements
        |;
		
statement returns [int attr_type]
:
		  Identifier '='  arith_expression ';'
		{ if (TRACEON) System.out.println("Assign value");
			  
	   		if (symtab.containsKey($Identifier.text)) {
	       		$attr_type = symtab.get($Identifier.text);
	   		} else {
           		$attr_type = -2;
           		System.out.println("Error! Undeclared identifier.");
		   		return $attr_type;
	   		}
		
	   		if ($attr_type != $arith_expression.attr_type) {
           		System.out.println("Type Error: " + 
				              $arith_expression.start.getLine() +
						      ": Type mismatch for the two sides operands in an assignment statement.");
		   		$attr_type = -2;
      		}
		}
		| Identifier TOTALEO Identifier ';'
		| Identifier TOTALEO Integer_constant ';'
		| Identifier TOTALEO Identifier
		| Identifier TOTALEO Integer_constant
		| Identifier TOTALEO
		| Identifier TOTALEO ';'
//		| Identifier CALCULATE Identifier TOTALEO Integer_constant 
		| BREAK ';'
			{if  (TRACEON) System.out.println("Break this for loop");}
		| CONTINUE ';'
		    {if  (TRACEON) System.out.println("Continue to next for loop");}
		| FOR S_L statements S_R B_L declarations statements B_R
			{if  (TRACEON) System.out.println("For loop");}
		| WHILE S_L statements S_R B_L declarations statements B_R
			{if  (TRACEON) System.out.println("While loop");}
		| PRINTF S_L EXTRA13 primary_expression EXTRA13 S_R ';'
		    {if  (TRACEON) System.out.println("Print data");}
		| IF_ S_L statements S_R B_L declarations statements B_R
			{if  (TRACEON) System.out.println("If condition");}
		| ELSE IF_ S_L statements S_R B_L declarations statements B_R
		    {if  (TRACEON) System.out.println("Else if condition");}
		| ELSE B_L declarations statements B_R
			{if  (TRACEON) System.out.println("Else condition");}
		| RETURN Integer_constant ';'
			{if  (TRACEON) System.out.println("Return a value");}
		;
//arith_expression:arith_term arith_expression1;
//arith_expression1:'+' arith_term arith_expression1
//                | '-' arith_term arith_expression1
//                |;

arith_expression returns [int attr_type]:
	a = arith_term { $attr_type = $a.attr_type; }
      ( '+' b = arith_term
	    { if ($a.attr_type != $b.attr_type) {
			  System.out.println("Type Error: " + 
				                 $a.start.getLine() +
						         ": Type mismatch for the operator + in an expression.");
		      $attr_type = -2;
		  }
				}
			  | '-' c = arith_term
				{ if ($a.attr_type != $c.attr_type) {
					  System.out.println("Type Error: " + 
										 $a.start.getLine() +
										 ": Type mismatch for the operator - in an expression.");
					  $attr_type = -2;
				  }
				}
			  )*
			;

		arith_term returns [int attr_type]: 
			 a = arith_factor { $attr_type = $a.attr_type; }
			  ( '*' b = arith_factor
			   {if ($a.attr_type !=$b.attr_type){
					   System.out.println("Type Error: "+ $a.start.getLine() + ":Type mismatch for the operator * in an expression.");
					   $attr_type = -2;
				 }
	   }
      | '/' c = arith_factor 
       {if ($a.attr_type !=$c.attr_type){
       		   System.out.println("Type Error: "+ $a.start.getLine() + ":Type mismatch for the operator / in an expression.");
       		   $attr_type = -2;
	     }
	   }
	  )*
	;

//arith_term:arith_factor arith_term1;
//arith_term1:'*' arith_factor arith_term1
//          | '/' arith_factor arith_term1
//          |;

arith_factor returns [int attr_type ]:
			primary_expression { $attr_type = $primary_expression.attr_type;}
           |'-' primary_expression { $attr_type = $primary_expression.attr_type;}
           ;
primary_expression returns [int attr_type]:
				   Integer_constant primary_expression
                 | Floating_point_constant primary_expression
                 | Identifier primary_expression
                 | Integer_constant { $attr_type=1;}
                 | Floating_point_constant { $attr_type=2;}
                 | Identifier 
                 |  '(' arith_expression ')' {$attr_type=$arith_expression.attr_type;}
                 ;
//header: EXTRA1 LETTER EXTRA2 LETTER  EXTRA3 {if (TRACEON) System.out.println("okok");};
 
/*----------------------*/
/*   Reserved Keywords  */
/*----------------------*/
INT_TYPE  : 'int';
MAIN : 'main';
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
FOR       : 'for';
DEFAULT   : 'default';
SIZEOF    : 'sizeof';
STRUCT    : 'struct';
TYPEDEF   : 'typedef';
SIGNED    : 'signed';
UNSIGNED  : 'unsigned';
SWITCH    : 'switch';
PRINTF    : 'printf';
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
TOTALEO : (EQ_OP|LE_OP|GE_OP|LE2_OP|GE2_OP|NE_OP|PP_OP|MM_OP|EO1|EO2|EO5|EO6|EO7)*;
 fragment EQ_OP : '==';
 fragment LE_OP : '<=';
 fragment LE2_OP: '<';
 fragment GE_OP : '>=';
 fragment GE2_OP: '>';
 fragment NE_OP : '!=';
 fragment PP_OP : '++';
 fragment MM_OP : '--';
 fragment EO1   : '&&' ;
 fragment EO2   : '||';
 fragment EO5   : '!' ;
 fragment EO6   : '^' ;
 fragment EO7   : '~' ;
//CALCULATE: (EO9|EO10|EO11|EO12)+;
// fragment EO9   : '+' ;
// fragment EO10  : '-' ;
// fragment EO11  : '*' ;
// fragment EO12  : '/' ;
// fragmnet EO13  : '%' ;


//DEC_NUM : ('0' | ('1'..'9')(DIGIT)*);

//ID :(Integer_constant | LETTER)*;

//FLOAT_NUM: FLOAT_NUM1 | FLOAT_NUM2 | FLOAT_NUM3;
//fragment FLOAT_NUM1: (DIGIT)+'.'(DIGIT)*;
//fragment FLOAT_NUM2: '.'(DIGIT)+;
//fragment FLOAT_NUM3: (DIGIT)+;
 

/* Comments */
COMMENT1 : '//'(.)*'\n';
COMMENT2 : '/*' (options{greedy=false;}: .)* '*/';

Identifier:('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
//Identifier2:('a'..'z'|'A'..'Z')+;
Integer_constant:'0'..'9'+;
Floating_point_constant:'0'..'9'+ '.' '0'..'9'+;
WS:( ' ' | '\t' | '\r' | '\n' ) {$channel=HIDDEN;};
//COMMENT:'/*' .* '*/' {$channel=HIDDEN;};

//NEW_LINE: '\n';
fragment LETTER : ('a'..'z' | 'A'..'Z')+;
//fragment DIGIT : '0'..'9';
EXTRA1 : '#';
S_L : '(';
S_R : ')';
M_L : '[';
M_R : ']';
B_L : '{';
B_R : '}';
EXTRA8 : '=';
EXTRA9 : ',';
EXTRA10 : ';';
EXTRA11 : '\\';
EXTRA12 : '\'';
EXTRA13 : '"';

//WS  : (' '|'\r'|'\t')+
//   ;
