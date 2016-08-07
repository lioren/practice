// $ANTLR 3.5.1 myChecker.g 2014-05-23 19:52:47

  import java.lang.*;
  import java.io.*;
  import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myCheckerParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BREAK", "B_L", "B_R", "CHAR_TYPE", 
		"COMMENT1", "COMMENT2", "CONTINUE", "DEFAULT", "DO", "DOUBLE_TYPE", "ELSE", 
		"ENUM", "EO1", "EO2", "EO5", "EO6", "EO7", "EOF_", "EQ_OP", "EXTRA1", 
		"EXTRA10", "EXTRA11", "EXTRA12", "EXTRA13", "EXTRA8", "EXTRA9", "FLOAT_TYPE", 
		"FOR", "Floating_point_constant", "GE2_OP", "GE_OP", "GOTO", "IF_", "INT_TYPE", 
		"Identifier", "Integer_constant", "LE2_OP", "LETTER", "LE_OP", "LONG_TYPE", 
		"MAIN", "MM_OP", "M_L", "M_R", "NEWLINE_", "NE_OP", "PP_OP", "PRINTF", 
		"RETURN", "SIGNED", "SIZEOF", "STATIC", "STRUCT", "SWITCH", "S_L", "S_R", 
		"TAB_", "TOTALEO", "TYPEDEF", "UNSIGNED", "VOID_TYPE", "WHILE", "WS", 
		"'*'", "'+'", "'-'", "'/'"
	};
	public static final int EOF=-1;
	public static final int T__67=67;
	public static final int T__68=68;
	public static final int T__69=69;
	public static final int T__70=70;
	public static final int BREAK=4;
	public static final int B_L=5;
	public static final int B_R=6;
	public static final int CHAR_TYPE=7;
	public static final int COMMENT1=8;
	public static final int COMMENT2=9;
	public static final int CONTINUE=10;
	public static final int DEFAULT=11;
	public static final int DO=12;
	public static final int DOUBLE_TYPE=13;
	public static final int ELSE=14;
	public static final int ENUM=15;
	public static final int EO1=16;
	public static final int EO2=17;
	public static final int EO5=18;
	public static final int EO6=19;
	public static final int EO7=20;
	public static final int EOF_=21;
	public static final int EQ_OP=22;
	public static final int EXTRA1=23;
	public static final int EXTRA10=24;
	public static final int EXTRA11=25;
	public static final int EXTRA12=26;
	public static final int EXTRA13=27;
	public static final int EXTRA8=28;
	public static final int EXTRA9=29;
	public static final int FLOAT_TYPE=30;
	public static final int FOR=31;
	public static final int Floating_point_constant=32;
	public static final int GE2_OP=33;
	public static final int GE_OP=34;
	public static final int GOTO=35;
	public static final int IF_=36;
	public static final int INT_TYPE=37;
	public static final int Identifier=38;
	public static final int Integer_constant=39;
	public static final int LE2_OP=40;
	public static final int LETTER=41;
	public static final int LE_OP=42;
	public static final int LONG_TYPE=43;
	public static final int MAIN=44;
	public static final int MM_OP=45;
	public static final int M_L=46;
	public static final int M_R=47;
	public static final int NEWLINE_=48;
	public static final int NE_OP=49;
	public static final int PP_OP=50;
	public static final int PRINTF=51;
	public static final int RETURN=52;
	public static final int SIGNED=53;
	public static final int SIZEOF=54;
	public static final int STATIC=55;
	public static final int STRUCT=56;
	public static final int SWITCH=57;
	public static final int S_L=58;
	public static final int S_R=59;
	public static final int TAB_=60;
	public static final int TOTALEO=61;
	public static final int TYPEDEF=62;
	public static final int UNSIGNED=63;
	public static final int VOID_TYPE=64;
	public static final int WHILE=65;
	public static final int WS=66;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public myCheckerParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public myCheckerParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return myCheckerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "myChecker.g"; }


	boolean TRACEON = true;
	HashMap<String,Integer>symtab = new HashMap<String,Integer>();



	// $ANTLR start "program"
	// myChecker.g:18:1: program : MAIN S_L S_R B_L declarations statements B_R ;
	public final void program() throws RecognitionException {
		try {
			// myChecker.g:18:8: ( MAIN S_L S_R B_L declarations statements B_R )
			// myChecker.g:18:11: MAIN S_L S_R B_L declarations statements B_R
			{
			match(input,MAIN,FOLLOW_MAIN_in_program37); 
			match(input,S_L,FOLLOW_S_L_in_program39); 
			match(input,S_R,FOLLOW_S_R_in_program41); 
			match(input,B_L,FOLLOW_B_L_in_program43); 
			pushFollow(FOLLOW_declarations_in_program45);
			declarations();
			state._fsp--;

			pushFollow(FOLLOW_statements_in_program47);
			statements();
			state._fsp--;

			match(input,B_R,FOLLOW_B_R_in_program49); 
			if (TRACEON) System.out.println("MAIN () {declarations statements}");
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



	// $ANTLR start "declarations"
	// myChecker.g:21:1: declarations : ( type Identifier ';' declarations | type Identifier '=' arith_expression ';' declarations |);
	public final void declarations() throws RecognitionException {
		Token Identifier1=null;
		Token Identifier3=null;
		int type2 =0;
		int type4 =0;

		try {
			// myChecker.g:21:13: ( type Identifier ';' declarations | type Identifier '=' arith_expression ';' declarations |)
			int alt1=3;
			switch ( input.LA(1) ) {
			case INT_TYPE:
				{
				int LA1_1 = input.LA(2);
				if ( (LA1_1==67) ) {
					int LA1_6 = input.LA(3);
					if ( (LA1_6==Identifier) ) {
						int LA1_7 = input.LA(4);
						if ( (LA1_7==EXTRA10) ) {
							alt1=1;
						}
						else if ( (LA1_7==EXTRA8) ) {
							alt1=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 1, 7, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 6, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA1_1==Identifier) ) {
					int LA1_7 = input.LA(3);
					if ( (LA1_7==EXTRA10) ) {
						alt1=1;
					}
					else if ( (LA1_7==EXTRA8) ) {
						alt1=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 7, input);
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
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case FLOAT_TYPE:
				{
				int LA1_2 = input.LA(2);
				if ( (LA1_2==Identifier) ) {
					int LA1_7 = input.LA(3);
					if ( (LA1_7==EXTRA10) ) {
						alt1=1;
					}
					else if ( (LA1_7==EXTRA8) ) {
						alt1=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 7, input);
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
							new NoViableAltException("", 1, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CHAR_TYPE:
				{
				int LA1_3 = input.LA(2);
				if ( (LA1_3==67) ) {
					int LA1_8 = input.LA(3);
					if ( (LA1_8==Identifier) ) {
						int LA1_7 = input.LA(4);
						if ( (LA1_7==EXTRA10) ) {
							alt1=1;
						}
						else if ( (LA1_7==EXTRA8) ) {
							alt1=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 1, 7, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA1_3==Identifier) ) {
					int LA1_7 = input.LA(3);
					if ( (LA1_7==EXTRA10) ) {
						alt1=1;
					}
					else if ( (LA1_7==EXTRA8) ) {
						alt1=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 7, input);
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
							new NoViableAltException("", 1, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case DOUBLE_TYPE:
				{
				int LA1_4 = input.LA(2);
				if ( (LA1_4==Identifier) ) {
					int LA1_7 = input.LA(3);
					if ( (LA1_7==EXTRA10) ) {
						alt1=1;
					}
					else if ( (LA1_7==EXTRA8) ) {
						alt1=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 7, input);
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
							new NoViableAltException("", 1, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case BREAK:
			case B_R:
			case CONTINUE:
			case ELSE:
			case FOR:
			case IF_:
			case Identifier:
			case PRINTF:
			case RETURN:
			case WHILE:
				{
				alt1=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// myChecker.g:21:14: type Identifier ';' declarations
					{
					pushFollow(FOLLOW_type_in_declarations65);
					type2=type();
					state._fsp--;

					Identifier1=(Token)match(input,Identifier,FOLLOW_Identifier_in_declarations67); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_declarations69); 
					pushFollow(FOLLOW_declarations_in_declarations71);
					declarations();
					state._fsp--;

					 if (TRACEON) System.out.println("declarations: type Identifier : declarations");
					             if(symtab.containsKey((Identifier1!=null?Identifier1.getText():null))){
					             		 System.out.println("Type Error:"+Identifier1.getLine()+":Redeclared identifier.");
								 }
								 else{
								 		 symtab.put((Identifier1!=null?Identifier1.getText():null),type2);
								 }
					}
					break;
				case 2 :
					// myChecker.g:29:14: type Identifier '=' arith_expression ';' declarations
					{
					pushFollow(FOLLOW_type_in_declarations101);
					type4=type();
					state._fsp--;

					Identifier3=(Token)match(input,Identifier,FOLLOW_Identifier_in_declarations103); 
					match(input,EXTRA8,FOLLOW_EXTRA8_in_declarations105); 
					pushFollow(FOLLOW_arith_expression_in_declarations107);
					arith_expression();
					state._fsp--;

					match(input,EXTRA10,FOLLOW_EXTRA10_in_declarations109); 
					pushFollow(FOLLOW_declarations_in_declarations111);
					declarations();
					state._fsp--;

					 if (TRACEON) System.out.println("declarations: type Identifier : declarations");
					             if(symtab.containsKey((Identifier3!=null?Identifier3.getText():null))){
					             		 System.out.println("Type Error:"+Identifier3.getLine()+":Redeclared identifier.");
								 }
								 else{
								 		 symtab.put((Identifier3!=null?Identifier3.getText():null),type4);
								 }
					}
					break;
				case 3 :
					// myChecker.g:37:14: 
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



	// $ANTLR start "type"
	// myChecker.g:39:1: type returns [int attr_type] : ( INT_TYPE | FLOAT_TYPE | CHAR_TYPE | DOUBLE_TYPE | INT_TYPE '*' | CHAR_TYPE '*' );
	public final int type() throws RecognitionException {
		int attr_type = 0;


		try {
			// myChecker.g:39:29: ( INT_TYPE | FLOAT_TYPE | CHAR_TYPE | DOUBLE_TYPE | INT_TYPE '*' | CHAR_TYPE '*' )
			int alt2=6;
			switch ( input.LA(1) ) {
			case INT_TYPE:
				{
				int LA2_1 = input.LA(2);
				if ( (LA2_1==67) ) {
					alt2=5;
				}
				else if ( (LA2_1==Identifier) ) {
					alt2=1;
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
			case FLOAT_TYPE:
				{
				alt2=2;
				}
				break;
			case CHAR_TYPE:
				{
				int LA2_3 = input.LA(2);
				if ( (LA2_3==67) ) {
					alt2=6;
				}
				else if ( (LA2_3==Identifier) ) {
					alt2=3;
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
			case DOUBLE_TYPE:
				{
				alt2=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// myChecker.g:40:2: INT_TYPE
					{
					match(input,INT_TYPE,FOLLOW_INT_TYPE_in_type155); 
					 if (TRACEON) System.out.println("type: INT");attr_type =1;
					}
					break;
				case 2 :
					// myChecker.g:41:6: FLOAT_TYPE
					{
					match(input,FLOAT_TYPE,FOLLOW_FLOAT_TYPE_in_type164); 
					if (TRACEON) System.out.println("type: FLOAT");attr_type =2;
					}
					break;
				case 3 :
					// myChecker.g:42:6: CHAR_TYPE
					{
					match(input,CHAR_TYPE,FOLLOW_CHAR_TYPE_in_type173); 
					if (TRACEON) System.out.println("type:CHAR");attr_type =3;
					}
					break;
				case 4 :
					// myChecker.g:43:6: DOUBLE_TYPE
					{
					match(input,DOUBLE_TYPE,FOLLOW_DOUBLE_TYPE_in_type181); 
					if (TRACEON) System.out.println("type:DOUBLE");attr_type =4;
					}
					break;
				case 5 :
					// myChecker.g:44:6: INT_TYPE '*'
					{
					match(input,INT_TYPE,FOLLOW_INT_TYPE_in_type189); 
					match(input,67,FOLLOW_67_in_type191); 
					if (TRACEON) System.out.println("type:Pointer to int");
					}
					break;
				case 6 :
					// myChecker.g:45:6: CHAR_TYPE '*'
					{
					match(input,CHAR_TYPE,FOLLOW_CHAR_TYPE_in_type199); 
					match(input,67,FOLLOW_67_in_type201); 
					if (TRACEON) System.out.println("type:Pointer to char");
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
	// myChecker.g:47:1: statements : ( statement statements |);
	public final void statements() throws RecognitionException {
		try {
			// myChecker.g:47:11: ( statement statements |)
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==BREAK||LA3_0==CONTINUE||LA3_0==ELSE||LA3_0==FOR||LA3_0==IF_||LA3_0==Identifier||(LA3_0 >= PRINTF && LA3_0 <= RETURN)||LA3_0==WHILE) ) {
				alt3=1;
			}
			else if ( (LA3_0==B_R||LA3_0==S_R) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// myChecker.g:47:12: statement statements
					{
					pushFollow(FOLLOW_statement_in_statements211);
					statement();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statements213);
					statements();
					state._fsp--;

					}
					break;
				case 2 :
					// myChecker.g:48:10: 
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
	// myChecker.g:50:1: statement returns [int attr_type] : ( Identifier '=' arith_expression ';' | Identifier TOTALEO Identifier ';' | Identifier TOTALEO Integer_constant ';' | Identifier TOTALEO Identifier | Identifier TOTALEO Integer_constant | Identifier TOTALEO | Identifier TOTALEO ';' | BREAK ';' | CONTINUE ';' | FOR S_L statements S_R B_L declarations statements B_R | WHILE S_L statements S_R B_L declarations statements B_R | PRINTF S_L EXTRA13 primary_expression EXTRA13 S_R ';' | IF_ S_L statements S_R B_L declarations statements B_R | ELSE IF_ S_L statements S_R B_L declarations statements B_R | ELSE B_L declarations statements B_R | RETURN Integer_constant ';' );
	public final int statement() throws RecognitionException {
		int attr_type = 0;


		Token Identifier5=null;
		ParserRuleReturnScope arith_expression6 =null;

		try {
			// myChecker.g:51:5: ( Identifier '=' arith_expression ';' | Identifier TOTALEO Identifier ';' | Identifier TOTALEO Integer_constant ';' | Identifier TOTALEO Identifier | Identifier TOTALEO Integer_constant | Identifier TOTALEO | Identifier TOTALEO ';' | BREAK ';' | CONTINUE ';' | FOR S_L statements S_R B_L declarations statements B_R | WHILE S_L statements S_R B_L declarations statements B_R | PRINTF S_L EXTRA13 primary_expression EXTRA13 S_R ';' | IF_ S_L statements S_R B_L declarations statements B_R | ELSE IF_ S_L statements S_R B_L declarations statements B_R | ELSE B_L declarations statements B_R | RETURN Integer_constant ';' )
			int alt4=16;
			switch ( input.LA(1) ) {
			case Identifier:
				{
				int LA4_1 = input.LA(2);
				if ( (LA4_1==EXTRA8) ) {
					alt4=1;
				}
				else if ( (LA4_1==TOTALEO) ) {
					switch ( input.LA(3) ) {
					case Identifier:
						{
						switch ( input.LA(4) ) {
						case EXTRA10:
							{
							alt4=2;
							}
							break;
						case EXTRA8:
						case TOTALEO:
							{
							alt4=6;
							}
							break;
						case BREAK:
						case B_R:
						case CONTINUE:
						case ELSE:
						case FOR:
						case IF_:
						case Identifier:
						case PRINTF:
						case RETURN:
						case S_R:
						case WHILE:
							{
							alt4=4;
							}
							break;
						default:
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 14, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case Integer_constant:
						{
						int LA4_15 = input.LA(4);
						if ( (LA4_15==EXTRA10) ) {
							alt4=3;
						}
						else if ( (LA4_15==BREAK||LA4_15==B_R||LA4_15==CONTINUE||LA4_15==ELSE||LA4_15==FOR||LA4_15==IF_||LA4_15==Identifier||(LA4_15 >= PRINTF && LA4_15 <= RETURN)||LA4_15==S_R||LA4_15==WHILE) ) {
							alt4=5;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 15, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case EXTRA10:
						{
						alt4=7;
						}
						break;
					case BREAK:
					case B_R:
					case CONTINUE:
					case ELSE:
					case FOR:
					case IF_:
					case PRINTF:
					case RETURN:
					case S_R:
					case WHILE:
						{
						alt4=6;
						}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 11, input);
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
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case BREAK:
				{
				alt4=8;
				}
				break;
			case CONTINUE:
				{
				alt4=9;
				}
				break;
			case FOR:
				{
				alt4=10;
				}
				break;
			case WHILE:
				{
				alt4=11;
				}
				break;
			case PRINTF:
				{
				alt4=12;
				}
				break;
			case IF_:
				{
				alt4=13;
				}
				break;
			case ELSE:
				{
				int LA4_8 = input.LA(2);
				if ( (LA4_8==IF_) ) {
					alt4=14;
				}
				else if ( (LA4_8==B_L) ) {
					alt4=15;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 8, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case RETURN:
				{
				alt4=16;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// myChecker.g:52:5: Identifier '=' arith_expression ';'
					{
					Identifier5=(Token)match(input,Identifier,FOLLOW_Identifier_in_statement241); 
					match(input,EXTRA8,FOLLOW_EXTRA8_in_statement243); 
					pushFollow(FOLLOW_arith_expression_in_statement246);
					arith_expression6=arith_expression();
					state._fsp--;

					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement248); 
					 if (TRACEON) System.out.println("Assign value");
								  
						   		if (symtab.containsKey((Identifier5!=null?Identifier5.getText():null))) {
						       		attr_type = symtab.get((Identifier5!=null?Identifier5.getText():null));
						   		} else {
					           		attr_type = -2;
					           		System.out.println("Error!:" + (arith_expression6!=null?(arith_expression6.start):null).getLine() + ": Undeclared identifier.");
							   		return attr_type;
						   		}
							
						   		if (attr_type != (arith_expression6!=null?((myCheckerParser.arith_expression_return)arith_expression6).attr_type:0)) {
					           		System.out.println("Type Error: " + 
									              (arith_expression6!=null?(arith_expression6.start):null).getLine() +
											      ": Type mismatch for the two sides operands in an assignment statement.");
							   		attr_type = -2;
					      		}
							
					}
					break;
				case 2 :
					// myChecker.g:70:5: Identifier TOTALEO Identifier ';'
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement258); 
					match(input,TOTALEO,FOLLOW_TOTALEO_in_statement260); 
					match(input,Identifier,FOLLOW_Identifier_in_statement262); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement264); 
					}
					break;
				case 3 :
					// myChecker.g:71:5: Identifier TOTALEO Integer_constant ';'
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement270); 
					match(input,TOTALEO,FOLLOW_TOTALEO_in_statement272); 
					match(input,Integer_constant,FOLLOW_Integer_constant_in_statement274); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement276); 
					}
					break;
				case 4 :
					// myChecker.g:72:5: Identifier TOTALEO Identifier
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement282); 
					match(input,TOTALEO,FOLLOW_TOTALEO_in_statement284); 
					match(input,Identifier,FOLLOW_Identifier_in_statement286); 
					}
					break;
				case 5 :
					// myChecker.g:73:5: Identifier TOTALEO Integer_constant
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement292); 
					match(input,TOTALEO,FOLLOW_TOTALEO_in_statement294); 
					match(input,Integer_constant,FOLLOW_Integer_constant_in_statement296); 
					}
					break;
				case 6 :
					// myChecker.g:74:5: Identifier TOTALEO
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement302); 
					match(input,TOTALEO,FOLLOW_TOTALEO_in_statement304); 
					}
					break;
				case 7 :
					// myChecker.g:75:5: Identifier TOTALEO ';'
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement310); 
					match(input,TOTALEO,FOLLOW_TOTALEO_in_statement312); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement314); 
					}
					break;
				case 8 :
					// myChecker.g:77:5: BREAK ';'
					{
					match(input,BREAK,FOLLOW_BREAK_in_statement321); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement323); 
					if  (TRACEON) System.out.println("Break this for loop");
					}
					break;
				case 9 :
					// myChecker.g:79:5: CONTINUE ';'
					{
					match(input,CONTINUE,FOLLOW_CONTINUE_in_statement334); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement336); 
					if  (TRACEON) System.out.println("Continue to next for loop");
					}
					break;
				case 10 :
					// myChecker.g:81:5: FOR S_L statements S_R B_L declarations statements B_R
					{
					match(input,FOR,FOLLOW_FOR_in_statement350); 
					match(input,S_L,FOLLOW_S_L_in_statement352); 
					pushFollow(FOLLOW_statements_in_statement354);
					statements();
					state._fsp--;

					match(input,S_R,FOLLOW_S_R_in_statement356); 
					match(input,B_L,FOLLOW_B_L_in_statement358); 
					pushFollow(FOLLOW_declarations_in_statement360);
					declarations();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statement362);
					statements();
					state._fsp--;

					match(input,B_R,FOLLOW_B_R_in_statement364); 
					if  (TRACEON) System.out.println("For loop");
					}
					break;
				case 11 :
					// myChecker.g:83:5: WHILE S_L statements S_R B_L declarations statements B_R
					{
					match(input,WHILE,FOLLOW_WHILE_in_statement375); 
					match(input,S_L,FOLLOW_S_L_in_statement377); 
					pushFollow(FOLLOW_statements_in_statement379);
					statements();
					state._fsp--;

					match(input,S_R,FOLLOW_S_R_in_statement381); 
					match(input,B_L,FOLLOW_B_L_in_statement383); 
					pushFollow(FOLLOW_declarations_in_statement385);
					declarations();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statement387);
					statements();
					state._fsp--;

					match(input,B_R,FOLLOW_B_R_in_statement389); 
					if  (TRACEON) System.out.println("While loop");
					}
					break;
				case 12 :
					// myChecker.g:85:5: PRINTF S_L EXTRA13 primary_expression EXTRA13 S_R ';'
					{
					match(input,PRINTF,FOLLOW_PRINTF_in_statement400); 
					match(input,S_L,FOLLOW_S_L_in_statement402); 
					match(input,EXTRA13,FOLLOW_EXTRA13_in_statement404); 
					pushFollow(FOLLOW_primary_expression_in_statement406);
					primary_expression();
					state._fsp--;

					match(input,EXTRA13,FOLLOW_EXTRA13_in_statement408); 
					match(input,S_R,FOLLOW_S_R_in_statement410); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement412); 
					if  (TRACEON) System.out.println("Print data");
					}
					break;
				case 13 :
					// myChecker.g:87:5: IF_ S_L statements S_R B_L declarations statements B_R
					{
					match(input,IF_,FOLLOW_IF__in_statement426); 
					match(input,S_L,FOLLOW_S_L_in_statement428); 
					pushFollow(FOLLOW_statements_in_statement430);
					statements();
					state._fsp--;

					match(input,S_R,FOLLOW_S_R_in_statement432); 
					match(input,B_L,FOLLOW_B_L_in_statement434); 
					pushFollow(FOLLOW_declarations_in_statement436);
					declarations();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statement438);
					statements();
					state._fsp--;

					match(input,B_R,FOLLOW_B_R_in_statement440); 
					if  (TRACEON) System.out.println("If condition");
					}
					break;
				case 14 :
					// myChecker.g:89:5: ELSE IF_ S_L statements S_R B_L declarations statements B_R
					{
					match(input,ELSE,FOLLOW_ELSE_in_statement451); 
					match(input,IF_,FOLLOW_IF__in_statement453); 
					match(input,S_L,FOLLOW_S_L_in_statement455); 
					pushFollow(FOLLOW_statements_in_statement457);
					statements();
					state._fsp--;

					match(input,S_R,FOLLOW_S_R_in_statement459); 
					match(input,B_L,FOLLOW_B_L_in_statement461); 
					pushFollow(FOLLOW_declarations_in_statement463);
					declarations();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statement465);
					statements();
					state._fsp--;

					match(input,B_R,FOLLOW_B_R_in_statement467); 
					if  (TRACEON) System.out.println("Else if condition");
					}
					break;
				case 15 :
					// myChecker.g:91:5: ELSE B_L declarations statements B_R
					{
					match(input,ELSE,FOLLOW_ELSE_in_statement481); 
					match(input,B_L,FOLLOW_B_L_in_statement483); 
					pushFollow(FOLLOW_declarations_in_statement485);
					declarations();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statement487);
					statements();
					state._fsp--;

					match(input,B_R,FOLLOW_B_R_in_statement489); 
					if  (TRACEON) System.out.println("Else condition");
					}
					break;
				case 16 :
					// myChecker.g:93:5: RETURN Integer_constant ';'
					{
					match(input,RETURN,FOLLOW_RETURN_in_statement500); 
					match(input,Integer_constant,FOLLOW_Integer_constant_in_statement502); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement504); 
					if  (TRACEON) System.out.println("Return a value");
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


	public static class arith_expression_return extends ParserRuleReturnScope {
		public int attr_type;
	};


	// $ANTLR start "arith_expression"
	// myChecker.g:101:1: arith_expression returns [int attr_type] : a= arith_term ( '+' b= arith_term | '-' c= arith_term )* ;
	public final myCheckerParser.arith_expression_return arith_expression() throws RecognitionException {
		myCheckerParser.arith_expression_return retval = new myCheckerParser.arith_expression_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope c =null;

		try {
			// myChecker.g:101:41: (a= arith_term ( '+' b= arith_term | '-' c= arith_term )* )
			// myChecker.g:102:2: a= arith_term ( '+' b= arith_term | '-' c= arith_term )*
			{
			pushFollow(FOLLOW_arith_term_in_arith_expression532);
			a=arith_term();
			state._fsp--;

			 retval.attr_type = (a!=null?((myCheckerParser.arith_term_return)a).attr_type:0); 
			// myChecker.g:103:7: ( '+' b= arith_term | '-' c= arith_term )*
			loop5:
			while (true) {
				int alt5=3;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==68) ) {
					alt5=1;
				}
				else if ( (LA5_0==69) ) {
					alt5=2;
				}

				switch (alt5) {
				case 1 :
					// myChecker.g:103:9: '+' b= arith_term
					{
					match(input,68,FOLLOW_68_in_arith_expression544); 
					pushFollow(FOLLOW_arith_term_in_arith_expression550);
					b=arith_term();
					state._fsp--;

					 if ((a!=null?((myCheckerParser.arith_term_return)a).attr_type:0) != (b!=null?((myCheckerParser.arith_term_return)b).attr_type:0)) {
								  System.out.println("Type Error: " + 
									                 (a!=null?(a.start):null).getLine() +
											         ": Type mismatch for the operator + in an expression.");
							      retval.attr_type = -2;
							  }
									
					}
					break;
				case 2 :
					// myChecker.g:111:8: '-' c= arith_term
					{
					match(input,69,FOLLOW_69_in_arith_expression566); 
					pushFollow(FOLLOW_arith_term_in_arith_expression572);
					c=arith_term();
					state._fsp--;

					 if ((a!=null?((myCheckerParser.arith_term_return)a).attr_type:0) != (c!=null?((myCheckerParser.arith_term_return)c).attr_type:0)) {
										  System.out.println("Type Error: " + 
															 (a!=null?(a.start):null).getLine() +
															 ": Type mismatch for the operator - in an expression.");
										  retval.attr_type = -2;
									  }
									
					}
					break;

				default :
					break loop5;
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


	public static class arith_term_return extends ParserRuleReturnScope {
		public int attr_type;
	};


	// $ANTLR start "arith_term"
	// myChecker.g:122:3: arith_term returns [int attr_type] : a= arith_factor ( '*' b= arith_factor | '/' c= arith_factor )* ;
	public final myCheckerParser.arith_term_return arith_term() throws RecognitionException {
		myCheckerParser.arith_term_return retval = new myCheckerParser.arith_term_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope c =null;

		try {
			// myChecker.g:122:37: (a= arith_factor ( '*' b= arith_factor | '/' c= arith_factor )* )
			// myChecker.g:123:5: a= arith_factor ( '*' b= arith_factor | '/' c= arith_factor )*
			{
			pushFollow(FOLLOW_arith_factor_in_arith_term612);
			a=arith_factor();
			state._fsp--;

			 retval.attr_type = (a!=null?((myCheckerParser.arith_factor_return)a).attr_type:0); 
			// myChecker.g:124:6: ( '*' b= arith_factor | '/' c= arith_factor )*
			loop6:
			while (true) {
				int alt6=3;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==67) ) {
					alt6=1;
				}
				else if ( (LA6_0==70) ) {
					alt6=2;
				}

				switch (alt6) {
				case 1 :
					// myChecker.g:124:8: '*' b= arith_factor
					{
					match(input,67,FOLLOW_67_in_arith_term623); 
					pushFollow(FOLLOW_arith_factor_in_arith_term629);
					b=arith_factor();
					state._fsp--;

					if ((a!=null?((myCheckerParser.arith_factor_return)a).attr_type:0) !=(b!=null?((myCheckerParser.arith_factor_return)b).attr_type:0)){
										   System.out.println("Type Error: "+ (a!=null?(a.start):null).getLine() + ":Type mismatch for the operator * in an expression.");
										   retval.attr_type = -2;
									 }
						   
					}
					break;
				case 2 :
					// myChecker.g:130:9: '/' c= arith_factor
					{
					match(input,70,FOLLOW_70_in_arith_term647); 
					pushFollow(FOLLOW_arith_factor_in_arith_term653);
					c=arith_factor();
					state._fsp--;

					if ((a!=null?((myCheckerParser.arith_factor_return)a).attr_type:0) !=(c!=null?((myCheckerParser.arith_factor_return)c).attr_type:0)){
					       		   System.out.println("Type Error: "+ (a!=null?(a.start):null).getLine() + ":Type mismatch for the operator / in an expression.");
					       		   retval.attr_type = -2;
						     }
						   
					}
					break;

				default :
					break loop6;
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
	// $ANTLR end "arith_term"


	public static class arith_factor_return extends ParserRuleReturnScope {
		public int attr_type;
	};


	// $ANTLR start "arith_factor"
	// myChecker.g:144:1: arith_factor returns [int attr_type ] : ( primary_expression | '-' primary_expression );
	public final myCheckerParser.arith_factor_return arith_factor() throws RecognitionException {
		myCheckerParser.arith_factor_return retval = new myCheckerParser.arith_factor_return();
		retval.start = input.LT(1);

		int primary_expression7 =0;
		int primary_expression8 =0;

		try {
			// myChecker.g:144:38: ( primary_expression | '-' primary_expression )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==Floating_point_constant||(LA7_0 >= Identifier && LA7_0 <= Integer_constant)||LA7_0==S_L) ) {
				alt7=1;
			}
			else if ( (LA7_0==69) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// myChecker.g:145:4: primary_expression
					{
					pushFollow(FOLLOW_primary_expression_in_arith_factor690);
					primary_expression7=primary_expression();
					state._fsp--;

					 retval.attr_type = primary_expression7;
					}
					break;
				case 2 :
					// myChecker.g:146:13: '-' primary_expression
					{
					match(input,69,FOLLOW_69_in_arith_factor706); 
					pushFollow(FOLLOW_primary_expression_in_arith_factor708);
					primary_expression8=primary_expression();
					state._fsp--;

					 retval.attr_type = primary_expression8;
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
	// $ANTLR end "arith_factor"



	// $ANTLR start "primary_expression"
	// myChecker.g:148:1: primary_expression returns [int attr_type] : ( Integer_constant primary_expression | Floating_point_constant primary_expression | Identifier primary_expression | Integer_constant | Floating_point_constant | Identifier | '(' arith_expression ')' );
	public final int primary_expression() throws RecognitionException {
		int attr_type = 0;


		ParserRuleReturnScope arith_expression9 =null;

		try {
			// myChecker.g:148:43: ( Integer_constant primary_expression | Floating_point_constant primary_expression | Identifier primary_expression | Integer_constant | Floating_point_constant | Identifier | '(' arith_expression ')' )
			int alt8=7;
			switch ( input.LA(1) ) {
			case Integer_constant:
				{
				int LA8_1 = input.LA(2);
				if ( (LA8_1==Floating_point_constant||(LA8_1 >= Identifier && LA8_1 <= Integer_constant)||LA8_1==S_L) ) {
					alt8=1;
				}
				else if ( (LA8_1==EXTRA10||LA8_1==EXTRA13||LA8_1==S_R||(LA8_1 >= 67 && LA8_1 <= 70)) ) {
					alt8=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case Floating_point_constant:
				{
				int LA8_2 = input.LA(2);
				if ( (LA8_2==Floating_point_constant||(LA8_2 >= Identifier && LA8_2 <= Integer_constant)||LA8_2==S_L) ) {
					alt8=2;
				}
				else if ( (LA8_2==EXTRA10||LA8_2==EXTRA13||LA8_2==S_R||(LA8_2 >= 67 && LA8_2 <= 70)) ) {
					alt8=5;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case Identifier:
				{
				int LA8_3 = input.LA(2);
				if ( (LA8_3==Floating_point_constant||(LA8_3 >= Identifier && LA8_3 <= Integer_constant)||LA8_3==S_L) ) {
					alt8=3;
				}
				else if ( (LA8_3==EXTRA10||LA8_3==EXTRA13||LA8_3==S_R||(LA8_3 >= 67 && LA8_3 <= 70)) ) {
					alt8=6;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case S_L:
				{
				alt8=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// myChecker.g:149:8: Integer_constant primary_expression
					{
					match(input,Integer_constant,FOLLOW_Integer_constant_in_primary_expression739); 
					pushFollow(FOLLOW_primary_expression_in_primary_expression741);
					primary_expression();
					state._fsp--;

					}
					break;
				case 2 :
					// myChecker.g:150:20: Floating_point_constant primary_expression
					{
					match(input,Floating_point_constant,FOLLOW_Floating_point_constant_in_primary_expression762); 
					pushFollow(FOLLOW_primary_expression_in_primary_expression764);
					primary_expression();
					state._fsp--;

					}
					break;
				case 3 :
					// myChecker.g:151:20: Identifier primary_expression
					{
					match(input,Identifier,FOLLOW_Identifier_in_primary_expression785); 
					pushFollow(FOLLOW_primary_expression_in_primary_expression787);
					primary_expression();
					state._fsp--;

					}
					break;
				case 4 :
					// myChecker.g:152:20: Integer_constant
					{
					match(input,Integer_constant,FOLLOW_Integer_constant_in_primary_expression808); 
					 attr_type =1;
					}
					break;
				case 5 :
					// myChecker.g:153:20: Floating_point_constant
					{
					match(input,Floating_point_constant,FOLLOW_Floating_point_constant_in_primary_expression831); 
					 attr_type =2;
					}
					break;
				case 6 :
					// myChecker.g:154:20: Identifier
					{
					match(input,Identifier,FOLLOW_Identifier_in_primary_expression854); 
					}
					break;
				case 7 :
					// myChecker.g:155:21: '(' arith_expression ')'
					{
					match(input,S_L,FOLLOW_S_L_in_primary_expression877); 
					pushFollow(FOLLOW_arith_expression_in_primary_expression879);
					arith_expression9=arith_expression();
					state._fsp--;

					match(input,S_R,FOLLOW_S_R_in_primary_expression881); 
					attr_type =(arith_expression9!=null?((myCheckerParser.arith_expression_return)arith_expression9).attr_type:0);
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
	// $ANTLR end "primary_expression"

	// Delegated rules



	public static final BitSet FOLLOW_MAIN_in_program37 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_S_L_in_program39 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_S_R_in_program41 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_B_L_in_program43 = new BitSet(new long[]{0x00180070C00064D0L,0x0000000000000002L});
	public static final BitSet FOLLOW_declarations_in_program45 = new BitSet(new long[]{0x0018005080004450L,0x0000000000000002L});
	public static final BitSet FOLLOW_statements_in_program47 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_B_R_in_program49 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_declarations65 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_Identifier_in_declarations67 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_EXTRA10_in_declarations69 = new BitSet(new long[]{0x0000002040002080L});
	public static final BitSet FOLLOW_declarations_in_declarations71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_declarations101 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_Identifier_in_declarations103 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_EXTRA8_in_declarations105 = new BitSet(new long[]{0x040000C100000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_arith_expression_in_declarations107 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_EXTRA10_in_declarations109 = new BitSet(new long[]{0x0000002040002080L});
	public static final BitSet FOLLOW_declarations_in_declarations111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_TYPE_in_type155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_TYPE_in_type164 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_TYPE_in_type173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_TYPE_in_type181 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_TYPE_in_type189 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_type191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_TYPE_in_type199 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_type201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements211 = new BitSet(new long[]{0x0018005080004410L,0x0000000000000002L});
	public static final BitSet FOLLOW_statements_in_statements213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement241 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_EXTRA8_in_statement243 = new BitSet(new long[]{0x040000C100000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_arith_expression_in_statement246 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement258 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_TOTALEO_in_statement260 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_Identifier_in_statement262 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement264 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement270 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_TOTALEO_in_statement272 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_Integer_constant_in_statement274 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement276 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement282 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_TOTALEO_in_statement284 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_Identifier_in_statement286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement292 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_TOTALEO_in_statement294 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_Integer_constant_in_statement296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement302 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_TOTALEO_in_statement304 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement310 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_TOTALEO_in_statement312 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_in_statement321 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONTINUE_in_statement334 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement336 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_statement350 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_S_L_in_statement352 = new BitSet(new long[]{0x0818005080004410L,0x0000000000000002L});
	public static final BitSet FOLLOW_statements_in_statement354 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_S_R_in_statement356 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_B_L_in_statement358 = new BitSet(new long[]{0x00180070C00064D0L,0x0000000000000002L});
	public static final BitSet FOLLOW_declarations_in_statement360 = new BitSet(new long[]{0x0018005080004450L,0x0000000000000002L});
	public static final BitSet FOLLOW_statements_in_statement362 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_B_R_in_statement364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_statement375 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_S_L_in_statement377 = new BitSet(new long[]{0x0818005080004410L,0x0000000000000002L});
	public static final BitSet FOLLOW_statements_in_statement379 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_S_R_in_statement381 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_B_L_in_statement383 = new BitSet(new long[]{0x00180070C00064D0L,0x0000000000000002L});
	public static final BitSet FOLLOW_declarations_in_statement385 = new BitSet(new long[]{0x0018005080004450L,0x0000000000000002L});
	public static final BitSet FOLLOW_statements_in_statement387 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_B_R_in_statement389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINTF_in_statement400 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_S_L_in_statement402 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_EXTRA13_in_statement404 = new BitSet(new long[]{0x040000C100000000L});
	public static final BitSet FOLLOW_primary_expression_in_statement406 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_EXTRA13_in_statement408 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_S_R_in_statement410 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF__in_statement426 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_S_L_in_statement428 = new BitSet(new long[]{0x0818005080004410L,0x0000000000000002L});
	public static final BitSet FOLLOW_statements_in_statement430 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_S_R_in_statement432 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_B_L_in_statement434 = new BitSet(new long[]{0x00180070C00064D0L,0x0000000000000002L});
	public static final BitSet FOLLOW_declarations_in_statement436 = new BitSet(new long[]{0x0018005080004450L,0x0000000000000002L});
	public static final BitSet FOLLOW_statements_in_statement438 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_B_R_in_statement440 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_in_statement451 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_IF__in_statement453 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_S_L_in_statement455 = new BitSet(new long[]{0x0818005080004410L,0x0000000000000002L});
	public static final BitSet FOLLOW_statements_in_statement457 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_S_R_in_statement459 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_B_L_in_statement461 = new BitSet(new long[]{0x00180070C00064D0L,0x0000000000000002L});
	public static final BitSet FOLLOW_declarations_in_statement463 = new BitSet(new long[]{0x0018005080004450L,0x0000000000000002L});
	public static final BitSet FOLLOW_statements_in_statement465 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_B_R_in_statement467 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_in_statement481 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_B_L_in_statement483 = new BitSet(new long[]{0x00180070C00064D0L,0x0000000000000002L});
	public static final BitSet FOLLOW_declarations_in_statement485 = new BitSet(new long[]{0x0018005080004450L,0x0000000000000002L});
	public static final BitSet FOLLOW_statements_in_statement487 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_B_R_in_statement489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_in_statement500 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_Integer_constant_in_statement502 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement504 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arith_term_in_arith_expression532 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
	public static final BitSet FOLLOW_68_in_arith_expression544 = new BitSet(new long[]{0x040000C100000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_arith_term_in_arith_expression550 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
	public static final BitSet FOLLOW_69_in_arith_expression566 = new BitSet(new long[]{0x040000C100000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_arith_term_in_arith_expression572 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
	public static final BitSet FOLLOW_arith_factor_in_arith_term612 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000048L});
	public static final BitSet FOLLOW_67_in_arith_term623 = new BitSet(new long[]{0x040000C100000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_arith_factor_in_arith_term629 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000048L});
	public static final BitSet FOLLOW_70_in_arith_term647 = new BitSet(new long[]{0x040000C100000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_arith_factor_in_arith_term653 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000048L});
	public static final BitSet FOLLOW_primary_expression_in_arith_factor690 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_arith_factor706 = new BitSet(new long[]{0x040000C100000000L});
	public static final BitSet FOLLOW_primary_expression_in_arith_factor708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_constant_in_primary_expression739 = new BitSet(new long[]{0x040000C100000000L});
	public static final BitSet FOLLOW_primary_expression_in_primary_expression741 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Floating_point_constant_in_primary_expression762 = new BitSet(new long[]{0x040000C100000000L});
	public static final BitSet FOLLOW_primary_expression_in_primary_expression764 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_primary_expression785 = new BitSet(new long[]{0x040000C100000000L});
	public static final BitSet FOLLOW_primary_expression_in_primary_expression787 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_constant_in_primary_expression808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Floating_point_constant_in_primary_expression831 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_primary_expression854 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_S_L_in_primary_expression877 = new BitSet(new long[]{0x040000C100000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_arith_expression_in_primary_expression879 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_S_R_in_primary_expression881 = new BitSet(new long[]{0x0000000000000002L});
}
