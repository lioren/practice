// $ANTLR 3.5.1 myCompiler.g 2014-06-20 22:23:18

    // import packages here.
    import java.util.HashMap;
    import java.util.ArrayList;
    import java.util.Stack;
    import java.util.Queue;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myCompilerParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHAR", "COMMENT", "EscapeSequence", 
		"FLOAT", "Floating_point_constant", "IF", "INT", "Identifier", "Integer_constant", 
		"STRING_LITERAL", "VOID", "WS", "'('", "')'", "'*'", "'+'", "','", "'-'", 
		"'/'", "';'", "'='", "'['", "']'", "'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int CHAR=4;
	public static final int COMMENT=5;
	public static final int EscapeSequence=6;
	public static final int FLOAT=7;
	public static final int Floating_point_constant=8;
	public static final int IF=9;
	public static final int INT=10;
	public static final int Identifier=11;
	public static final int Integer_constant=12;
	public static final int STRING_LITERAL=13;
	public static final int VOID=14;
	public static final int WS=15;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public myCompilerParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public myCompilerParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return myCompilerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "myCompiler.g"; }


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
	       TextCode.add("\t pushq %rbp");
	       TextCode.add("\t movq %rsp,%rbp");
	       TextCode.add("\t pushq %rbx"); //callee saved registers.
	       TextCode.add("\t pushq %r12"); //callee saved registers.
	       TextCode.add("\t pushq %r13"); //callee saved registers.
	       TextCode.add("\t pushq %r14"); //callee saved registers.
	       TextCode.add("\t pushq %r15"); //callee saved registers.
	       TextCode.add("\t subq $8,%rsp\n"); // aligned 16-byte boundary.
	    }
	    
	    /*
	     * Output epilogue.
	     */
	    void epilogue()
	    {
	       /* handle epilogue */
	       
	       /* Follow x86 calling convention */
	       TextCode.add("\n\t addq $8,%rsp");
	       TextCode.add("\t popq %r15");
	       TextCode.add("\t popq %r14");
	       TextCode.add("\t popq %r13");
	       TextCode.add("\t popq %r12");
	       TextCode.add("\t popq %rbx");
	       TextCode.add("\t popq %rbp");
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



	// $ANTLR start "program"
	// myCompiler.g:107:1: program : declarations functions ;
	public final void program() throws RecognitionException {
		try {
			// myCompiler.g:108:5: ( declarations functions )
			// myCompiler.g:108:7: declarations functions
			{
			pushFollow(FOLLOW_declarations_in_program43);
			declarations();
			state._fsp--;

			pushFollow(FOLLOW_functions_in_program45);
			functions();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "program"



	// $ANTLR start "functions"
	// myCompiler.g:112:1: functions : ( function functions |);
	public final void functions() throws RecognitionException {
		try {
			// myCompiler.g:113:5: ( function functions |)
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==CHAR||LA1_0==FLOAT||LA1_0==INT||LA1_0==VOID) ) {
				alt1=1;
			}
			else if ( (LA1_0==EOF) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// myCompiler.g:113:7: function functions
					{
					pushFollow(FOLLOW_function_in_functions63);
					function();
					state._fsp--;

					pushFollow(FOLLOW_functions_in_functions65);
					functions();
					state._fsp--;

					}
					break;
				case 2 :
					// myCompiler.g:115:5: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "functions"



	// $ANTLR start "function"
	// myCompiler.g:117:1: function : type Identifier '(' ')' '{' l_declarations statements '}' ;
	public final void function() throws RecognitionException {
		Token Identifier1=null;

		try {
			// myCompiler.g:118:5: ( type Identifier '(' ')' '{' l_declarations statements '}' )
			// myCompiler.g:118:7: type Identifier '(' ')' '{' l_declarations statements '}'
			{
			pushFollow(FOLLOW_type_in_function94);
			type();
			state._fsp--;

			Identifier1=(Token)match(input,Identifier,FOLLOW_Identifier_in_function96); 
			match(input,16,FOLLOW_16_in_function98); 
			match(input,17,FOLLOW_17_in_function100); 
			match(input,27,FOLLOW_27_in_function102); 

			         /* output function prologue */
			         prologue((Identifier1!=null?Identifier1.getText():null));
			      
			pushFollow(FOLLOW_l_declarations_in_function118);
			l_declarations();
			state._fsp--;

			pushFollow(FOLLOW_statements_in_function120);
			statements();
			state._fsp--;

			match(input,28,FOLLOW_28_in_function122); 

				     if (TRACEON)
					     System.out.println("type Identifier () {declarations statements}");
				    
					 /* output function epilogue */	  
				     epilogue();
				  
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function"



	// $ANTLR start "declarations"
	// myCompiler.g:135:1: declarations : ( type Identifier ';' declarations | type Identifier '[' Integer_constant ']' ';' declarations |);
	public final void declarations() throws RecognitionException {
		Token Identifier2=null;
		Token Identifier4=null;
		int type3 =0;
		int type5 =0;

		try {
			// myCompiler.g:136:5: ( type Identifier ';' declarations | type Identifier '[' Integer_constant ']' ';' declarations |)
			int alt2=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				int LA2_1 = input.LA(2);
				if ( (LA2_1==Identifier) ) {
					switch ( input.LA(3) ) {
					case 23:
						{
						alt2=1;
						}
						break;
					case 25:
						{
						alt2=2;
						}
						break;
					case 16:
						{
						alt2=3;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 6, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case FLOAT:
				{
				int LA2_2 = input.LA(2);
				if ( (LA2_2==Identifier) ) {
					switch ( input.LA(3) ) {
					case 23:
						{
						alt2=1;
						}
						break;
					case 25:
						{
						alt2=2;
						}
						break;
					case 16:
						{
						alt2=3;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 6, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case VOID:
				{
				int LA2_3 = input.LA(2);
				if ( (LA2_3==Identifier) ) {
					switch ( input.LA(3) ) {
					case 23:
						{
						alt2=1;
						}
						break;
					case 25:
						{
						alt2=2;
						}
						break;
					case 16:
						{
						alt2=3;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 6, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CHAR:
				{
				int LA2_4 = input.LA(2);
				if ( (LA2_4==Identifier) ) {
					switch ( input.LA(3) ) {
					case 23:
						{
						alt2=1;
						}
						break;
					case 25:
						{
						alt2=2;
						}
						break;
					case 16:
						{
						alt2=3;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 6, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case EOF:
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// myCompiler.g:137:4: type Identifier ';' declarations
					{
					pushFollow(FOLLOW_type_in_declarations150);
					type3=type();
					state._fsp--;

					Identifier2=(Token)match(input,Identifier,FOLLOW_Identifier_in_declarations152); 
					match(input,23,FOLLOW_23_in_declarations154); 
					pushFollow(FOLLOW_declarations_in_declarations156);
					declarations();
					state._fsp--;

					 
						    if (TRACEON) System.out.println("declarations: type Identifier : declarations");
							if (symtab.containsKey((Identifier2!=null?Identifier2.getText():null))) {
							    System.out.println("Type Error: " + 
									                Identifier2.getLine() + 
												    ": Redeclared identifier.");
						    } else {
								/* Add ID and its attr_type into the symbol table. */
								symtab.put((Identifier2!=null?Identifier2.getText():null), type3);	   
						    }
							
							/* code generation */
							switch(type3) {
							case 1: /* Type: integer, size=> 4 bytes, alignment=> 4 byte boundary. */
							        DataCode.add("\t .common " + (Identifier2!=null?Identifier2.getText():null) + ",4,4\n");
									break;
							case 2: /* Type: float, size=> 4 bytes, alignment=> 4 byte boundary. */
							        DataCode.add("\t .common " + (Identifier2!=null?Identifier2.getText():null) + ",4,4\n");
									break;
							default:
							}
						  
					}
					break;
				case 2 :
					// myCompiler.g:160:6: type Identifier '[' Integer_constant ']' ';' declarations
					{
					pushFollow(FOLLOW_type_in_declarations171);
					type5=type();
					state._fsp--;

					Identifier4=(Token)match(input,Identifier,FOLLOW_Identifier_in_declarations173); 
					match(input,25,FOLLOW_25_in_declarations175); 
					match(input,Integer_constant,FOLLOW_Integer_constant_in_declarations177); 
					match(input,26,FOLLOW_26_in_declarations179); 
					match(input,23,FOLLOW_23_in_declarations181); 
					pushFollow(FOLLOW_declarations_in_declarations183);
					declarations();
					state._fsp--;

					 
						    if (TRACEON) System.out.println("declarations: type Identifier : declarations");
							if (symtab.containsKey((Identifier4!=null?Identifier4.getText():null))) {
							    System.out.println("Type Error: " + 
									                Identifier4.getLine() + 
												    ": Redeclared identifier.");
						    } else {
								/* Add ID and its attr_type into the symbol table. */
								symtab.put((Identifier4!=null?Identifier4.getText():null), type5);	   
						    }
							
							/* code generation */
							switch(type5) {
							case 1: /* Type: integer, size=> 4 bytes, alignment=> 4 byte boundary. */
							        DataCode.add("\t .common " + (Identifier4!=null?Identifier4.getText():null) + ",12,4\n");
									break;
							case 2: /* Type: float, size=> 4 bytes, alignment=> 4 byte boundary. */
							        DataCode.add("\t .common " + (Identifier4!=null?Identifier4.getText():null) + ",12,4\n");
									break;
							default:
							}
						  
					}
					break;
				case 3 :
					// myCompiler.g:183:6: 
					{
					 if (TRACEON) System.out.println("declarations: ");
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declarations"



	// $ANTLR start "l_declarations"
	// myCompiler.g:187:1: l_declarations : ( type Identifier ';' l_declarations |);
	public final void l_declarations() throws RecognitionException {
		Token Identifier6=null;
		int type7 =0;

		try {
			// myCompiler.g:188:5: ( type Identifier ';' l_declarations |)
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==CHAR||LA3_0==FLOAT||LA3_0==INT||LA3_0==VOID) ) {
				alt3=1;
			}
			else if ( (LA3_0==IF||LA3_0==Identifier||LA3_0==28) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// myCompiler.g:189:5: type Identifier ';' l_declarations
					{
					pushFollow(FOLLOW_type_in_l_declarations220);
					type7=type();
					state._fsp--;

					Identifier6=(Token)match(input,Identifier,FOLLOW_Identifier_in_l_declarations222); 
					match(input,23,FOLLOW_23_in_l_declarations224); 
					pushFollow(FOLLOW_l_declarations_in_l_declarations226);
					l_declarations();
					state._fsp--;


						if (TRACEON) System.out.println("declarations: type Identifier : declarations");

					           if (symtab.containsKey((Identifier6!=null?Identifier6.getText():null))) {
					                   System.out.println("Type Error: " +
					                                              Identifier6.getLine() +
					                                                          ": Redeclared identifier.");
					           } else {
					                   /* Add ID and its attr_type into the symbol table. */
					                   symtab.put((Identifier6!=null?Identifier6.getText():null), type7);
					           }

							switch(type7) {
					                case 1: /* Type: integer, size=> 4 bytes, alignment=> 4 byte boundary. */
					                        DataCode.add("\t .common " + (Identifier6!=null?Identifier6.getText():null) + ",4,4\n");
					                                break;
					                case 2: /* Type: float, size=> 4 bytes, alignment=> 4 byte boundary. */
					                        DataCode.add("\t .common " + (Identifier6!=null?Identifier6.getText():null) + ",4,4\n");
					                                break;
					                default:
							}
					     
					}
					break;
				case 2 :
					// myCompiler.g:212:7: 
					{
					 if (TRACEON) System.out.println("declarations: ");
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "l_declarations"



	// $ANTLR start "type"
	// myCompiler.g:216:1: type returns [int attr_type] : ( INT | FLOAT | VOID | CHAR );
	public final int type() throws RecognitionException {
		int attr_type = 0;


		try {
			// myCompiler.g:217:5: ( INT | FLOAT | VOID | CHAR )
			int alt4=4;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt4=1;
				}
				break;
			case FLOAT:
				{
				alt4=2;
				}
				break;
			case VOID:
				{
				alt4=3;
				}
				break;
			case CHAR:
				{
				alt4=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// myCompiler.g:217:7: INT
					{
					match(input,INT,FOLLOW_INT_in_type262); 
					 if (TRACEON) System.out.println("type: INT");  attr_type =1; 
					}
					break;
				case 2 :
					// myCompiler.g:218:7: FLOAT
					{
					match(input,FLOAT,FOLLOW_FLOAT_in_type274); 
					 if (TRACEON) System.out.println("type: FLOAT");  attr_type =2; 
					}
					break;
				case 3 :
					// myCompiler.g:219:7: VOID
					{
					match(input,VOID,FOLLOW_VOID_in_type284); 
					}
					break;
				case 4 :
					// myCompiler.g:220:7: CHAR
					{
					match(input,CHAR,FOLLOW_CHAR_in_type292); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return attr_type;
	}
	// $ANTLR end "type"



	// $ANTLR start "statements"
	// myCompiler.g:223:1: statements : ( statement statements |);
	public final void statements() throws RecognitionException {
		try {
			// myCompiler.g:223:11: ( statement statements |)
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==IF||LA5_0==Identifier) ) {
				alt5=1;
			}
			else if ( (LA5_0==28) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// myCompiler.g:223:13: statement statements
					{
					pushFollow(FOLLOW_statement_in_statements304);
					statement();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statements306);
					statements();
					state._fsp--;

					}
					break;
				case 2 :
					// myCompiler.g:225:5: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statements"



	// $ANTLR start "statement"
	// myCompiler.g:227:1: statement returns [int attr_type] : ( Identifier '=' arith_expression ';' | Identifier '[' Integer_constant ']' '=' arith_expression ';' | IF '(' arith_expression ')' if_then_statements | Identifier func_argument );
	public final int statement() throws RecognitionException {
		int attr_type = 0;


		Token Identifier8=null;
		Token Identifier10=null;
		Token Identifier13=null;
		ParserRuleReturnScope arith_expression9 =null;
		ParserRuleReturnScope arith_expression11 =null;
		String func_argument12 =null;

		try {
			// myCompiler.g:228:5: ( Identifier '=' arith_expression ';' | Identifier '[' Integer_constant ']' '=' arith_expression ';' | IF '(' arith_expression ')' if_then_statements | Identifier func_argument )
			int alt6=4;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==Identifier) ) {
				switch ( input.LA(2) ) {
				case 24:
					{
					alt6=1;
					}
					break;
				case 25:
					{
					alt6=2;
					}
					break;
				case IF:
				case Identifier:
				case 16:
				case 28:
					{
					alt6=4;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}
			else if ( (LA6_0==IF) ) {
				alt6=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// myCompiler.g:228:7: Identifier '=' arith_expression ';'
					{
					Identifier8=(Token)match(input,Identifier,FOLLOW_Identifier_in_statement335); 
					match(input,24,FOLLOW_24_in_statement337); 
					pushFollow(FOLLOW_arith_expression_in_statement339);
					arith_expression9=arith_expression();
					state._fsp--;

					match(input,23,FOLLOW_23_in_statement341); 
					 
						    if (symtab.containsKey((Identifier8!=null?Identifier8.getText():null))) {
						       attr_type = symtab.get((Identifier8!=null?Identifier8.getText():null));
						    } else {
					         /* Add codes to report and handle this error */

						       attr_type = -2;
						    }
							  
						    if (attr_type != (arith_expression9!=null?((myCompilerParser.arith_expression_return)arith_expression9).attr_type:0)) {
						   System.out.println(attr_type +" "+ (arith_expression9!=null?((myCompilerParser.arith_expression_return)arith_expression9).attr_type:0)+"\n");
					           System.out.println("Type Error: " + 
							                       (arith_expression9!=null?(arith_expression9.start):null).getLine() +
					 		 	                   ": Type mismatch for the two silde operands in an assignment statement.");
							      attr_type = -2;
					      }
							
							  /* code generation */
					      TextCode.add("\t movl " + "%" + Reg[(arith_expression9!=null?((myCompilerParser.arith_expression_return)arith_expression9).reg_num:0)] + "," + (Identifier8!=null?Identifier8.getText():null) + "(%rip)");
						  
					}
					break;
				case 2 :
					// myCompiler.g:249:4: Identifier '[' Integer_constant ']' '=' arith_expression ';'
					{
					Identifier10=(Token)match(input,Identifier,FOLLOW_Identifier_in_statement351); 
					match(input,25,FOLLOW_25_in_statement353); 
					match(input,Integer_constant,FOLLOW_Integer_constant_in_statement355); 
					match(input,26,FOLLOW_26_in_statement357); 
					match(input,24,FOLLOW_24_in_statement358); 
					pushFollow(FOLLOW_arith_expression_in_statement360);
					arith_expression11=arith_expression();
					state._fsp--;

					match(input,23,FOLLOW_23_in_statement362); 
					 
						    if (symtab.containsKey((Identifier10!=null?Identifier10.getText():null))) {
						       attr_type = symtab.get((Identifier10!=null?Identifier10.getText():null));
						    } else {
					         /* Add codes to report and handle this error */

						       attr_type = -2;
						    }
							  
						    if (attr_type != (arith_expression11!=null?((myCompilerParser.arith_expression_return)arith_expression11).attr_type:0)) {
						   System.out.println(attr_type +" "+ (arith_expression11!=null?((myCompilerParser.arith_expression_return)arith_expression11).attr_type:0)+"\n");
					           System.out.println("Type Error: " + 
							                       (arith_expression11!=null?(arith_expression11.start):null).getLine() +
					 		 	                   ": Type mismatch for the two silde operands in an assignment statement.");
							      attr_type = -2;
					      }
							
							  /* code generation */
					      TextCode.add("\t movl " + "%" + Reg[(arith_expression11!=null?((myCompilerParser.arith_expression_return)arith_expression11).reg_num:0)] + "," + (Identifier10!=null?Identifier10.getText():null) + "(%rip)");
						  
					}
					break;
				case 3 :
					// myCompiler.g:270:7: IF '(' arith_expression ')' if_then_statements
					{
					match(input,IF,FOLLOW_IF_in_statement375); 
					match(input,16,FOLLOW_16_in_statement377); 
					pushFollow(FOLLOW_arith_expression_in_statement379);
					arith_expression();
					state._fsp--;

					match(input,17,FOLLOW_17_in_statement381); 
					pushFollow(FOLLOW_if_then_statements_in_statement383);
					if_then_statements();
					state._fsp--;

					}
					break;
				case 4 :
					// myCompiler.g:271:7: Identifier func_argument
					{
					Identifier13=(Token)match(input,Identifier,FOLLOW_Identifier_in_statement391); 
					pushFollow(FOLLOW_func_argument_in_statement393);
					func_argument12=func_argument();
					state._fsp--;


					      /* code generation */
					      TextCode.add("\t movq " + "$" + func_argument12 + ",%rdi");
					      TextCode.add("\t xor %rax, %rax");
					      TextCode.add("\t call " + (Identifier13!=null?Identifier13.getText():null));
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return attr_type;
	}
	// $ANTLR end "statement"



	// $ANTLR start "func_argument"
	// myCompiler.g:281:1: func_argument returns [String label] : (| '(' a= arith_expression ( ',' b= arith_expression | ',' c= arith_expression '[' Integer_constant ']' )* ')' ';' );
	public final String func_argument() throws RecognitionException {
		String label = null;


		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope c =null;

		try {
			// myCompiler.g:282:5: (| '(' a= arith_expression ( ',' b= arith_expression | ',' c= arith_expression '[' Integer_constant ']' )* ')' ';' )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==IF||LA8_0==Identifier||LA8_0==28) ) {
				alt8=1;
			}
			else if ( (LA8_0==16) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// myCompiler.g:283:5: 
					{
					}
					break;
				case 2 :
					// myCompiler.g:283:7: '(' a= arith_expression ( ',' b= arith_expression | ',' c= arith_expression '[' Integer_constant ']' )* ')' ';'
					{
					match(input,16,FOLLOW_16_in_func_argument428); 
					pushFollow(FOLLOW_arith_expression_in_func_argument434);
					a=arith_expression();
					state._fsp--;


					         /* handle function calls here. */
					         if ((a!=null?((myCompilerParser.arith_expression_return)a).attr_type:0) == 3) { // handle string type.
					            label = newLabel();
					            DataCode.add(label + ":");
					            DataCode.add("\t .string " + (a!=null?((myCompilerParser.arith_expression_return)a).str:null));
					         }
					      
					// myCompiler.g:292:10: ( ',' b= arith_expression | ',' c= arith_expression '[' Integer_constant ']' )*
					loop7:
					while (true) {
						int alt7=3;
						alt7 = dfa7.predict(input);
						switch (alt7) {
						case 1 :
							// myCompiler.g:292:12: ',' b= arith_expression
							{
							match(input,20,FOLLOW_20_in_func_argument456); 
							pushFollow(FOLLOW_arith_expression_in_func_argument460);
							b=arith_expression();
							state._fsp--;


											TextCode.add("\t movl " + (b!=null?input.toString(b.start,b.stop):null) + "(%rip), %esi");
										
							}
							break;
						case 2 :
							// myCompiler.g:297:11: ',' c= arith_expression '[' Integer_constant ']'
							{
							match(input,20,FOLLOW_20_in_func_argument482); 
							pushFollow(FOLLOW_arith_expression_in_func_argument486);
							c=arith_expression();
							state._fsp--;

							match(input,25,FOLLOW_25_in_func_argument488); 
							match(input,Integer_constant,FOLLOW_Integer_constant_in_func_argument490); 
							match(input,26,FOLLOW_26_in_func_argument492); 

											TextCode.add("\t movl " + (c!=null?input.toString(c.start,c.stop):null) + "(%rip), %esi");
										
							}
							break;

						default :
							break loop7;
						}
					}

					match(input,17,FOLLOW_17_in_func_argument509); 
					match(input,23,FOLLOW_23_in_func_argument511); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return label;
	}
	// $ANTLR end "func_argument"


	public static class arith_expression_return extends ParserRuleReturnScope {
		public int attr_type;
		public int reg_num;
		public String str;
	};


	// $ANTLR start "arith_expression"
	// myCompiler.g:307:1: arith_expression returns [int attr_type, int reg_num, String str] : a= multExpr ( '+' b= multExpr | '-' c= multExpr )* ;
	public final myCompilerParser.arith_expression_return arith_expression() throws RecognitionException {
		myCompilerParser.arith_expression_return retval = new myCompilerParser.arith_expression_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope c =null;

		try {
			// myCompiler.g:308:2: (a= multExpr ( '+' b= multExpr | '-' c= multExpr )* )
			// myCompiler.g:308:4: a= multExpr ( '+' b= multExpr | '-' c= multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_arith_expression540);
			a=multExpr();
			state._fsp--;


				         retval.attr_type = (a!=null?((myCompilerParser.multExpr_return)a).attr_type:0);
				         retval.reg_num = (a!=null?((myCompilerParser.multExpr_return)a).reg_num:0);
				         retval.str = (a!=null?((myCompilerParser.multExpr_return)a).str:null);
				      
			// myCompiler.g:314:5: ( '+' b= multExpr | '-' c= multExpr )*
			loop9:
			while (true) {
				int alt9=3;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==19) ) {
					alt9=1;
				}
				else if ( (LA9_0==21) ) {
					alt9=2;
				}

				switch (alt9) {
				case 1 :
					// myCompiler.g:314:7: '+' b= multExpr
					{
					match(input,19,FOLLOW_19_in_arith_expression557); 
					pushFollow(FOLLOW_multExpr_in_arith_expression563);
					b=multExpr();
					state._fsp--;

					 
						        if ((a!=null?((myCompilerParser.multExpr_return)a).attr_type:0) != (b!=null?((myCompilerParser.multExpr_return)b).attr_type:0)) {
								       System.out.println("Type Error: " + 
									                 (a!=null?(a.start):null).getLine() +
											            ": Type mismatch for the operator + in an expression.");
							         retval.attr_type = -2;
							      }
							  
							      /* code generation */
					          TextCode.add("\t addl " + "%" + Reg[(b!=null?((myCompilerParser.multExpr_return)b).reg_num:0)] + ", %" + Reg[retval.reg_num]);
					        
					}
					break;
				case 2 :
					// myCompiler.g:326:6: '-' c= multExpr
					{
					match(input,21,FOLLOW_21_in_arith_expression579); 
					pushFollow(FOLLOW_multExpr_in_arith_expression585);
					c=multExpr();
					state._fsp--;

					 
						        	if ((a!=null?((myCompilerParser.multExpr_return)a).attr_type:0) != (c!=null?((myCompilerParser.multExpr_return)c).attr_type:0)) {
								       System.out.println("Type Error: " + 
									                 (a!=null?(a.start):null).getLine() +
											            ": Type mismatch for the operator - in an expression.");
							         retval.attr_type = -2;
							      	}
							  
							      	/* code generation */
					          		TextCode.add("\t subl " + "%" + Reg[(c!=null?((myCompilerParser.multExpr_return)c).reg_num:0)] + ", %" + Reg[retval.reg_num]);
							
					}
					break;

				default :
					break loop9;
				}
			}

			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "arith_expression"


	public static class multExpr_return extends ParserRuleReturnScope {
		public int attr_type;
		public int reg_num;
		public String str;
	};


	// $ANTLR start "multExpr"
	// myCompiler.g:342:1: multExpr returns [int attr_type, int reg_num, String str] : a= signExpr ( '*' b= signExpr | '/' c= signExpr )* ;
	public final myCompilerParser.multExpr_return multExpr() throws RecognitionException {
		myCompilerParser.multExpr_return retval = new myCompilerParser.multExpr_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope c =null;

		try {
			// myCompiler.g:343:2: (a= signExpr ( '*' b= signExpr | '/' c= signExpr )* )
			// myCompiler.g:343:4: a= signExpr ( '*' b= signExpr | '/' c= signExpr )*
			{
			pushFollow(FOLLOW_signExpr_in_multExpr620);
			a=signExpr();
			state._fsp--;

			 
				     retval.attr_type = (a!=null?((myCompilerParser.signExpr_return)a).attr_type:0);
				     retval.reg_num = (a!=null?((myCompilerParser.signExpr_return)a).reg_num:0);
				     retval.str = (a!=null?((myCompilerParser.signExpr_return)a).str:null);
				  
			// myCompiler.g:349:7: ( '*' b= signExpr | '/' c= signExpr )*
			loop10:
			while (true) {
				int alt10=3;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==18) ) {
					alt10=1;
				}
				else if ( (LA10_0==22) ) {
					alt10=2;
				}

				switch (alt10) {
				case 1 :
					// myCompiler.g:349:9: '*' b= signExpr
					{
					match(input,18,FOLLOW_18_in_multExpr636); 
					pushFollow(FOLLOW_signExpr_in_multExpr640);
					b=signExpr();
					state._fsp--;


						        if ((a!=null?((myCompilerParser.signExpr_return)a).attr_type:0) != (b!=null?((myCompilerParser.signExpr_return)b).attr_type:0)) {
								       System.out.println("Type Error: " + 
									                 (a!=null?(a.start):null).getLine() +
											            ": Type mismatch for the operator + in an expression.");
							         retval.attr_type = -2;
							      }
							  
							      /* code generation */
					          TextCode.add("\t imul " + "%" + Reg[(b!=null?((myCompilerParser.signExpr_return)b).reg_num:0)] + ", %" + Reg[retval.reg_num]);
					        
					}
					break;
				case 2 :
					// myCompiler.g:361:9: '/' c= signExpr
					{
					match(input,22,FOLLOW_22_in_multExpr657); 
					pushFollow(FOLLOW_signExpr_in_multExpr661);
					c=signExpr();
					state._fsp--;


						        if ((a!=null?((myCompilerParser.signExpr_return)a).attr_type:0) != (c!=null?((myCompilerParser.signExpr_return)c).attr_type:0)) {
								       System.out.println("Type Error: " + 
									                 (a!=null?(a.start):null).getLine() +
											            ": Type mismatch for the operator + in an expression.");
							         retval.attr_type = -2;
							      }
							  
							      /* code generation */
					          TextCode.add("\t idiv " + "%" + Reg[(c!=null?((myCompilerParser.signExpr_return)c).reg_num:0)] + ", %" + Reg[retval.reg_num]);
					        
					}
					break;

				default :
					break loop10;
				}
			}

			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "multExpr"


	public static class signExpr_return extends ParserRuleReturnScope {
		public int attr_type;
		public int reg_num;
		public String str;
	};


	// $ANTLR start "signExpr"
	// myCompiler.g:378:1: signExpr returns [int attr_type, int reg_num, String str] : ( primaryExpr | '-' primaryExpr );
	public final myCompilerParser.signExpr_return signExpr() throws RecognitionException {
		myCompilerParser.signExpr_return retval = new myCompilerParser.signExpr_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope primaryExpr14 =null;

		try {
			// myCompiler.g:379:2: ( primaryExpr | '-' primaryExpr )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==Floating_point_constant||(LA11_0 >= Identifier && LA11_0 <= STRING_LITERAL)) ) {
				alt11=1;
			}
			else if ( (LA11_0==21) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// myCompiler.g:379:4: primaryExpr
					{
					pushFollow(FOLLOW_primaryExpr_in_signExpr688);
					primaryExpr14=primaryExpr();
					state._fsp--;

					 
						     retval.attr_type = (primaryExpr14!=null?((myCompilerParser.primaryExpr_return)primaryExpr14).attr_type:0);
						     retval.reg_num = (primaryExpr14!=null?((myCompilerParser.primaryExpr_return)primaryExpr14).reg_num:0);
						     retval.str = (primaryExpr14!=null?((myCompilerParser.primaryExpr_return)primaryExpr14).str:null);
						  
					}
					break;
				case 2 :
					// myCompiler.g:385:4: '-' primaryExpr
					{
					match(input,21,FOLLOW_21_in_signExpr698); 
					pushFollow(FOLLOW_primaryExpr_in_signExpr700);
					primaryExpr();
					state._fsp--;

					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "signExpr"


	public static class primaryExpr_return extends ParserRuleReturnScope {
		public int attr_type;
		public int reg_num;
		public String str;
	};


	// $ANTLR start "primaryExpr"
	// myCompiler.g:389:1: primaryExpr returns [int attr_type, int reg_num, String str] : ( Integer_constant | Floating_point_constant | STRING_LITERAL | Identifier );
	public final myCompilerParser.primaryExpr_return primaryExpr() throws RecognitionException {
		myCompilerParser.primaryExpr_return retval = new myCompilerParser.primaryExpr_return();
		retval.start = input.LT(1);

		Token Integer_constant15=null;
		Token STRING_LITERAL16=null;
		Token Identifier17=null;

		try {
			// myCompiler.g:390:5: ( Integer_constant | Floating_point_constant | STRING_LITERAL | Identifier )
			int alt12=4;
			switch ( input.LA(1) ) {
			case Integer_constant:
				{
				alt12=1;
				}
				break;
			case Floating_point_constant:
				{
				alt12=2;
				}
				break;
			case STRING_LITERAL:
				{
				alt12=3;
				}
				break;
			case Identifier:
				{
				alt12=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// myCompiler.g:390:7: Integer_constant
					{
					Integer_constant15=(Token)match(input,Integer_constant,FOLLOW_Integer_constant_in_primaryExpr719); 
					 
					         retval.attr_type = 1;
					         retval.str = null;
					         
					         /* code generation */
					         retval.reg_num = reg.get();  /* get an register */
						
					         TextCode.add("\t movl " + "$" + (Integer_constant15!=null?Integer_constant15.getText():null) + ", %" + Reg[retval.reg_num]); 
					      
					}
					break;
				case 2 :
					// myCompiler.g:400:7: Floating_point_constant
					{
					match(input,Floating_point_constant,FOLLOW_Floating_point_constant_in_primaryExpr735); 
					 
						 retval.attr_type = 2; 
					      
					}
					break;
				case 3 :
					// myCompiler.g:403:7: STRING_LITERAL
					{
					STRING_LITERAL16=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_primaryExpr745); 
					 retval.attr_type = 3; retval.str = (STRING_LITERAL16!=null?STRING_LITERAL16.getText():null); 
					}
					break;
				case 4 :
					// myCompiler.g:404:7: Identifier
					{
					Identifier17=(Token)match(input,Identifier,FOLLOW_Identifier_in_primaryExpr755); 

					         retval.attr_type = symtab.get((Identifier17!=null?Identifier17.getText():null));
					         retval.str = null;
					         
					         /* code generation */
					         retval.reg_num = reg.get(); /* get an register */
					         TextCode.add("\t movl " + (Identifier17!=null?Identifier17.getText():null) + "(%rip), %" + Reg[retval.reg_num]);
					      
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "primaryExpr"



	// $ANTLR start "if_then_statements"
	// myCompiler.g:416:1: if_then_statements : ( statement | '{' statements '}' );
	public final void if_then_statements() throws RecognitionException {
		try {
			// myCompiler.g:417:2: ( statement | '{' statements '}' )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==IF||LA13_0==Identifier) ) {
				alt13=1;
			}
			else if ( (LA13_0==27) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// myCompiler.g:417:4: statement
					{
					pushFollow(FOLLOW_statement_in_if_then_statements779);
					statement();
					state._fsp--;

					}
					break;
				case 2 :
					// myCompiler.g:418:4: '{' statements '}'
					{
					match(input,27,FOLLOW_27_in_if_then_statements784); 
					pushFollow(FOLLOW_statements_in_if_then_statements786);
					statements();
					state._fsp--;

					match(input,28,FOLLOW_28_in_if_then_statements788); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "if_then_statements"

	// Delegated rules


	protected DFA7 dfa7 = new DFA7(this);
	static final String DFA7_eotS =
		"\136\uffff";
	static final String DFA7_eofS =
		"\136\uffff";
	static final String DFA7_minS =
		"\1\21\1\uffff\1\10\4\21\5\10\2\uffff\10\21\1\10\4\21\1\10\4\21\1\10\4"+
		"\21\1\10\10\21\2\10\4\21\2\10\10\21\1\10\4\21\1\10\4\21\1\10\4\21\1\10"+
		"\20\21";
	static final String DFA7_maxS =
		"\1\24\1\uffff\1\25\4\31\1\15\4\25\2\uffff\10\31\1\15\4\31\1\15\4\31\1"+
		"\15\4\31\1\15\10\31\2\25\4\31\2\25\10\31\1\15\4\31\1\15\4\31\1\15\4\31"+
		"\1\15\20\31";
	static final String DFA7_acceptS =
		"\1\uffff\1\3\12\uffff\1\1\1\2\120\uffff";
	static final String DFA7_specialS =
		"\136\uffff}>";
	static final String[] DFA7_transitionS = {
			"\1\1\2\uffff\1\2",
			"",
			"\1\4\2\uffff\1\6\1\3\1\5\7\uffff\1\7",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\17\2\uffff\1\21\1\16\1\20",
			"\1\23\2\uffff\1\25\1\22\1\24\7\uffff\1\26",
			"\1\30\2\uffff\1\32\1\27\1\31\7\uffff\1\33",
			"\1\35\2\uffff\1\37\1\34\1\36\7\uffff\1\40",
			"\1\42\2\uffff\1\44\1\41\1\43\7\uffff\1\45",
			"",
			"",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\47\2\uffff\1\51\1\46\1\50",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\53\2\uffff\1\55\1\52\1\54",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\61\2\uffff\1\63\1\60\1\62",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\67\2\uffff\1\71\1\66\1\70",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\14\1\10\1\12\1\14\1\13\1\11\2\uffff\1\15",
			"\1\73\2\uffff\1\75\1\72\1\74\7\uffff\1\76",
			"\1\100\2\uffff\1\102\1\77\1\101\7\uffff\1\103",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\105\2\uffff\1\107\1\104\1\106\7\uffff\1\110",
			"\1\112\2\uffff\1\114\1\111\1\113\7\uffff\1\115",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\117\2\uffff\1\121\1\116\1\120",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\123\2\uffff\1\125\1\122\1\124",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\127\2\uffff\1\131\1\126\1\130",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\133\2\uffff\1\135\1\132\1\134",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\56\1\12\1\14\1\13\1\57\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15",
			"\1\14\1\64\1\12\1\14\1\13\1\65\2\uffff\1\15"
	};

	static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
	static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
	static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
	static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
	static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
	static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
	static final short[][] DFA7_transition;

	static {
		int numStates = DFA7_transitionS.length;
		DFA7_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
		}
	}

	protected class DFA7 extends DFA {

		public DFA7(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 7;
			this.eot = DFA7_eot;
			this.eof = DFA7_eof;
			this.min = DFA7_min;
			this.max = DFA7_max;
			this.accept = DFA7_accept;
			this.special = DFA7_special;
			this.transition = DFA7_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 292:10: ( ',' b= arith_expression | ',' c= arith_expression '[' Integer_constant ']' )*";
		}
	}

	public static final BitSet FOLLOW_declarations_in_program43 = new BitSet(new long[]{0x0000000000004490L});
	public static final BitSet FOLLOW_functions_in_program45 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_functions63 = new BitSet(new long[]{0x0000000000004490L});
	public static final BitSet FOLLOW_functions_in_functions65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_function94 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Identifier_in_function96 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_function98 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_function100 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_function102 = new BitSet(new long[]{0x0000000010004E90L});
	public static final BitSet FOLLOW_l_declarations_in_function118 = new BitSet(new long[]{0x0000000010000A00L});
	public static final BitSet FOLLOW_statements_in_function120 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_function122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_declarations150 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Identifier_in_declarations152 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_declarations154 = new BitSet(new long[]{0x0000000000004490L});
	public static final BitSet FOLLOW_declarations_in_declarations156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_declarations171 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Identifier_in_declarations173 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_declarations175 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_Integer_constant_in_declarations177 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_declarations179 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_declarations181 = new BitSet(new long[]{0x0000000000004490L});
	public static final BitSet FOLLOW_declarations_in_declarations183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_l_declarations220 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_Identifier_in_l_declarations222 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_l_declarations224 = new BitSet(new long[]{0x0000000000004490L});
	public static final BitSet FOLLOW_l_declarations_in_l_declarations226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_type262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_type274 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_in_type284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_in_type292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements304 = new BitSet(new long[]{0x0000000000000A00L});
	public static final BitSet FOLLOW_statements_in_statements306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement335 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_statement337 = new BitSet(new long[]{0x0000000000203900L});
	public static final BitSet FOLLOW_arith_expression_in_statement339 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_statement341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement351 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_statement353 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_Integer_constant_in_statement355 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_statement357 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_statement358 = new BitSet(new long[]{0x0000000000203900L});
	public static final BitSet FOLLOW_arith_expression_in_statement360 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_statement362 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_statement375 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_statement377 = new BitSet(new long[]{0x0000000000203900L});
	public static final BitSet FOLLOW_arith_expression_in_statement379 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_statement381 = new BitSet(new long[]{0x0000000008000A00L});
	public static final BitSet FOLLOW_if_then_statements_in_statement383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement391 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_func_argument_in_statement393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_func_argument428 = new BitSet(new long[]{0x0000000000203900L});
	public static final BitSet FOLLOW_arith_expression_in_func_argument434 = new BitSet(new long[]{0x0000000000120000L});
	public static final BitSet FOLLOW_20_in_func_argument456 = new BitSet(new long[]{0x0000000000203900L});
	public static final BitSet FOLLOW_arith_expression_in_func_argument460 = new BitSet(new long[]{0x0000000000120000L});
	public static final BitSet FOLLOW_20_in_func_argument482 = new BitSet(new long[]{0x0000000000203900L});
	public static final BitSet FOLLOW_arith_expression_in_func_argument486 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_func_argument488 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_Integer_constant_in_func_argument490 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_func_argument492 = new BitSet(new long[]{0x0000000000120000L});
	public static final BitSet FOLLOW_17_in_func_argument509 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_func_argument511 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression540 = new BitSet(new long[]{0x0000000000280002L});
	public static final BitSet FOLLOW_19_in_arith_expression557 = new BitSet(new long[]{0x0000000000203900L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression563 = new BitSet(new long[]{0x0000000000280002L});
	public static final BitSet FOLLOW_21_in_arith_expression579 = new BitSet(new long[]{0x0000000000203900L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression585 = new BitSet(new long[]{0x0000000000280002L});
	public static final BitSet FOLLOW_signExpr_in_multExpr620 = new BitSet(new long[]{0x0000000000440002L});
	public static final BitSet FOLLOW_18_in_multExpr636 = new BitSet(new long[]{0x0000000000203900L});
	public static final BitSet FOLLOW_signExpr_in_multExpr640 = new BitSet(new long[]{0x0000000000440002L});
	public static final BitSet FOLLOW_22_in_multExpr657 = new BitSet(new long[]{0x0000000000203900L});
	public static final BitSet FOLLOW_signExpr_in_multExpr661 = new BitSet(new long[]{0x0000000000440002L});
	public static final BitSet FOLLOW_primaryExpr_in_signExpr688 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_signExpr698 = new BitSet(new long[]{0x0000000000003900L});
	public static final BitSet FOLLOW_primaryExpr_in_signExpr700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_constant_in_primaryExpr719 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Floating_point_constant_in_primaryExpr735 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_primaryExpr745 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_primaryExpr755 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_if_then_statements779 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_if_then_statements784 = new BitSet(new long[]{0x0000000010000A00L});
	public static final BitSet FOLLOW_statements_in_if_then_statements786 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_if_then_statements788 = new BitSet(new long[]{0x0000000000000002L});
}
