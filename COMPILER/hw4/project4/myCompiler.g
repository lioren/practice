grammar myCompiler;

options {
    language = Java;
}

@header {
    // import packages here.
    import java.util.HashMap;
    import java.util.ArrayList;
    import java.util.Stack;
    import java.util.Queue;
}

@members {
    boolean TRACEON = false;
    HashMap<String,Integer> symtab = new HashMap<String,Integer>();
    int labelCount = 0;
    String Reg[] = {"eax", "ecx", "edx","ebx", "r8d", "r9d", "r10d", "r11d", "r12d", "r13d", "r14d", "r15d"};

	  /*
    public enum TypeInfo {
    StringConstant,
    Integer,
		Float,
		Unknown,
		No_Exist,
		Error
    }
    */

    /* attr_type:
       1 => integer,
       2 => float,
       3 => String constant,
       -1 => do not exist,
       -2 => error
     */
     
    List<String> DataCode = new ArrayList<String>();
    List<String> TextCode = new ArrayList<String>();
 
    public static register reg = new register(0, 10);

    
    /*
     * Output prologue.
     */
    void prologue(String id)
    {
       TextCode.add("\n\n/* Text section */");
       TextCode.add("\t.section .text");
       TextCode.add("\t.global " + id);
       TextCode.add("\t.type " + id + ",@function");
       TextCode.add(id + ":");
       
       /* Follow x86 calling convention */
       TextCode.add("\t pushq \%rbp");
       TextCode.add("\t movq \%rsp,\%rbp");
       TextCode.add("\t pushq \%rbx"); //callee saved registers.
       TextCode.add("\t pushq \%r12"); //callee saved registers.
       TextCode.add("\t pushq \%r13"); //callee saved registers.
       TextCode.add("\t pushq \%r14"); //callee saved registers.
       TextCode.add("\t pushq \%r15"); //callee saved registers.
       TextCode.add("\t subq $8,\%rsp\n"); // aligned 16-byte boundary.
    }
    
    /*
     * Output epilogue.
     */
    void epilogue()
    {
       /* handle epilogue */
       
       /* Follow x86 calling convention */
       TextCode.add("\n\t addq $8,\%rsp");
       TextCode.add("\t popq \%r15");
       TextCode.add("\t popq \%r14");
       TextCode.add("\t popq \%r13");
       TextCode.add("\t popq \%r12");
       TextCode.add("\t popq \%rbx");
       TextCode.add("\t popq \%rbp");
       TextCode.add("\t ret");
    }
    
    
    /* Generate a new label */
    String newLabel()
    {
       labelCount ++;
       return (new String("L")) + Integer.toString(labelCount);
    } 
    
    
    public List<String> getDataCode()
    {
       return DataCode;
    }
    
    public List<String> getTextCode()
    {
       return TextCode;
    }
}


program
    : declarations functions
    ;


functions
    : function functions
    |
    ;
				  
function
    : type Identifier '(' ')' '{'
      {
         /* output function prologue */
         prologue($Identifier.text);
      }
      l_declarations statements '}'
      {
	     if (TRACEON)
		     System.out.println("type Identifier () {declarations statements}");
	    
		 /* output function epilogue */	  
	     epilogue();
	  }
	;


/* global declaraction */
declarations
    :
	  type Identifier ';' declarations
      { 
	    if (TRACEON) System.out.println("declarations: type Identifier : declarations");
		if (symtab.containsKey($Identifier.text)) {
		    System.out.println("Type Error: " + 
				                $Identifier.getLine() + 
							    ": Redeclared identifier.");
	    } else {
			/* Add ID and its attr_type into the symbol table. */
			symtab.put($Identifier.text, $type.attr_type);	   
	    }
		
		/* code generation */
		switch($type.attr_type) {
		case 1: /* Type: integer, size=> 4 bytes, alignment=> 4 byte boundary. */
		        DataCode.add("\t .common " + $Identifier.text + ",4,4\n");
				break;
		case 2: /* Type: float, size=> 4 bytes, alignment=> 4 byte boundary. */
		        DataCode.add("\t .common " + $Identifier.text + ",4,4\n");
				break;
		default:
		}
	  }
	  | type Identifier '[' Integer_constant ']' ';' declarations
      { 
	    if (TRACEON) System.out.println("declarations: type Identifier : declarations");
		if (symtab.containsKey($Identifier.text)) {
		    System.out.println("Type Error: " + 
				                $Identifier.getLine() + 
							    ": Redeclared identifier.");
	    } else {
			/* Add ID and its attr_type into the symbol table. */
			symtab.put($Identifier.text, $type.attr_type);	   
	    }
		
		/* code generation */
		switch($type.attr_type) {
		case 1: /* Type: integer, size=> 4 bytes, alignment=> 4 byte boundary. */
		        DataCode.add("\t .common " + $Identifier.text + ",12,4\n");
				break;
		case 2: /* Type: float, size=> 4 bytes, alignment=> 4 byte boundary. */
		        DataCode.add("\t .common " + $Identifier.text + ",12,4\n");
				break;
		default:
		}
	  }
	  | { if (TRACEON) System.out.println("declarations: ");}
    ;


l_declarations
    :
    type Identifier ';' l_declarations
    {
	if (TRACEON) System.out.println("declarations: type Identifier : declarations");

           if (symtab.containsKey($Identifier.text)) {
                   System.out.println("Type Error: " +
                                              $Identifier.getLine() +
                                                          ": Redeclared identifier.");
           } else {
                   /* Add ID and its attr_type into the symbol table. */
                   symtab.put($Identifier.text, $type.attr_type);
           }

		switch($type.attr_type) {
                case 1: /* Type: integer, size=> 4 bytes, alignment=> 4 byte boundary. */
                        DataCode.add("\t .common " + $Identifier.text + ",4,4\n");
                                break;
                case 2: /* Type: float, size=> 4 bytes, alignment=> 4 byte boundary. */
                        DataCode.add("\t .common " + $Identifier.text + ",4,4\n");
                                break;
                default:
		}
     }
    | { if (TRACEON) System.out.println("declarations: ");}
    ;


type returns [int attr_type]
    : INT   { if (TRACEON) System.out.println("type: INT");  $attr_type=1; }
    | FLOAT { if (TRACEON) System.out.println("type: FLOAT");  $attr_type=2; }
    | VOID
    | CHAR
    ;

statements: statement statements
    |
    ;
		
statement returns [int attr_type]
    : Identifier '=' arith_expression ';'
	  { 
	    if (symtab.containsKey($Identifier.text)) {
	       $attr_type = symtab.get($Identifier.text);
	    } else {
         /* Add codes to report and handle this error */

	       $attr_type = -2;
	    }
		  
	    if ($attr_type != $arith_expression.attr_type) {
	   System.out.println($attr_type +" "+ $arith_expression.attr_type+"\n");
           System.out.println("Type Error: " + 
		                       $arith_expression.start.getLine() +
 		 	                   ": Type mismatch for the two silde operands in an assignment statement.");
		      $attr_type = -2;
      }
		
		  /* code generation */
      TextCode.add("\t movl " + "\%" + Reg[$arith_expression.reg_num] + "," + $Identifier.text + "(\%rip)");
	  }
	| Identifier '[' Integer_constant ']''=' arith_expression ';'
	  { 
	    if (symtab.containsKey($Identifier.text)) {
	       $attr_type = symtab.get($Identifier.text);
	    } else {
         /* Add codes to report and handle this error */

	       $attr_type = -2;
	    }
		  
	    if ($attr_type != $arith_expression.attr_type) {
	   System.out.println($attr_type +" "+ $arith_expression.attr_type+"\n");
           System.out.println("Type Error: " + 
		                       $arith_expression.start.getLine() +
 		 	                   ": Type mismatch for the two silde operands in an assignment statement.");
		      $attr_type = -2;
      }
		
		  /* code generation */
      TextCode.add("\t movl " + "\%" + Reg[$arith_expression.reg_num] + "," + $Identifier.text + "(\%rip)");
	  }
    | IF '(' arith_expression ')' if_then_statements
    | Identifier func_argument
    {
      /* code generation */
      TextCode.add("\t movq " + "$" + $func_argument.label + ",\%rdi");
      TextCode.add("\t xor \%rax, \%rax");
      TextCode.add("\t call " + $Identifier.text);
    }
    ;


func_argument returns [String label]
    : 
    | '(' a = arith_expression 
      {
         /* handle function calls here. */
         if ($a.attr_type == 3) { // handle string type.
            label = newLabel();
            DataCode.add(label + ":");
            DataCode.add("\t .string " + $a.str);
         }
      }
	        ( ',' b=arith_expression
			{
				TextCode.add("\t movl " + $b.text + "(\%rip), \%esi");
			}
	 | 
	         ',' c=arith_expression '[' Integer_constant ']'
			{
				TextCode.add("\t movl " + $c.text + "(\%rip), \%esi");
			}
	 )*
	    ')' ';' 
   
    ;

	
arith_expression returns [int attr_type, int reg_num, String str]
	: a = multExpr
	      {
	         $attr_type = $a.attr_type;
	         $reg_num = $a.reg_num;
	         $str = $a.str;
	      }
    ( '+' b = multExpr
	      { 
	        if ($a.attr_type != $b.attr_type) {
			       System.out.println("Type Error: " + 
				                 $a.start.getLine() +
						            ": Type mismatch for the operator + in an expression.");
		         $attr_type = -2;
		      }
		  
		      /* code generation */
          TextCode.add("\t addl " + "\%" + Reg[$b.reg_num] + ", \%" + Reg[$reg_num]);
        }
	  | '-' c = multExpr
		    { 
	        	if ($a.attr_type != $c.attr_type) {
			       System.out.println("Type Error: " + 
				                 $a.start.getLine() +
						            ": Type mismatch for the operator - in an expression.");
		         $attr_type = -2;
		      	}
		  
		      	/* code generation */
          		TextCode.add("\t subl " + "\%" + Reg[$c.reg_num] + ", \%" + Reg[$reg_num]);
		}
	  )*
	;

	
multExpr returns [int attr_type, int reg_num, String str]
	: a = signExpr 
	  { 
	     $attr_type = $a.attr_type;
	     $reg_num = $a.reg_num;
	     $str = $a.str;
	  }
      ( '*' b=signExpr
	    {
	        if ($a.attr_type != $b.attr_type) {
			       System.out.println("Type Error: " + 
				                 $a.start.getLine() +
						            ": Type mismatch for the operator + in an expression.");
		         $attr_type = -2;
		      }
		  
		      /* code generation */
          TextCode.add("\t imul " + "\%" + Reg[$b.reg_num] + ", \%" + Reg[$reg_num]);
        }
      | '/' c=signExpr
	{
	        if ($a.attr_type != $c.attr_type) {
			       System.out.println("Type Error: " + 
				                 $a.start.getLine() +
						            ": Type mismatch for the operator + in an expression.");
		         $attr_type = -2;
		      }
		  
		      /* code generation */
          TextCode.add("\t idiv " + "\%" + Reg[$c.reg_num] + ", \%" + Reg[$reg_num]);
        }
	
	  )*
	;


signExpr returns [int attr_type, int reg_num, String str]
	: primaryExpr
	  { 
	     $attr_type = $primaryExpr.attr_type;
	     $reg_num = $primaryExpr.reg_num;
	     $str = $primaryExpr.str;
	  }
	| '-' primaryExpr
	;


primaryExpr returns [int attr_type, int reg_num, String str]
    : Integer_constant
      { 
         $attr_type = 1;
         $str = null;
         
         /* code generation */
         $reg_num = reg.get();  /* get an register */
	
         TextCode.add("\t movl " + "\$" + $Integer_constant.text + ", \%" + Reg[$reg_num]); 
      }
    | Floating_point_constant { 
	 $attr_type = 2; 
      }
    | STRING_LITERAL { $attr_type = 3; $str = $STRING_LITERAL.text; }
    | Identifier
      {
         $attr_type = symtab.get($Identifier.text);
         $str = null;
         
         /* code generation */
         $reg_num = reg.get(); /* get an register */
         TextCode.add("\t movl " + $Identifier.text + "(\%rip), \%" + Reg[$reg_num]);
      }
    ;

	
if_then_statements
	: statement
	| '{' statements '}'
	;

	
/* description of the tokens */
FLOAT:'float';
INT:'int';
VOID: 'void';
CHAR: 'char';
IF: 'if';

Identifier:('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
Integer_constant:'0'..'9'+;
Floating_point_constant:'0'..'9'+ '.' '0'..'9'+;

STRING_LITERAL
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    ;


WS:( ' ' | '\t' | '\r' | '\n' ) {$channel=HIDDEN;};
COMMENT:'/*' .* '*/' {$channel=HIDDEN;};
