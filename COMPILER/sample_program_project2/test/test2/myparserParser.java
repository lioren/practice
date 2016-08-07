// $ANTLR 3.5.1 myparser.g 2014-05-02 10:55:50

  import java.lang.*;
  import java.io.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myparserParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BREAK", "B_L", "B_R", "CALCULATE", 
		"CHAR_TYPE", "COMMENT1", "COMMENT2", "CONTINUE", "DEFAULT", "DO", "DOUBLE_TYPE", 
		"ELSE", "ENUM", "EO1", "EO10", "EO11", "EO12", "EO2", "EO5", "EO6", "EO7", 
		"EO9", "EOF_", "EQ_OP", "EXTRA1", "EXTRA10", "EXTRA11", "EXTRA12", "EXTRA13", 
		"EXTRA8", "EXTRA9", "FLOAT_TYPE", "FOR", "Floating_point_constant", "GE2_OP", 
		"GE_OP", "GOTO", "IF_", "INT_TYPE", "Identifier", "Integer_constant", 
		"LE2_OP", "LETTER", "LE_OP", "LONG_TYPE", "MAIN", "MM_OP", "M_L", "M_R", 
		"NEWLINE_", "NE_OP", "PP_OP", "PRINTF", "RETURN", "SIGNED", "SIZEOF", 
		"STATIC", "STRUCT", "SWITCH", "S_L", "S_R", "TAB_", "TOTALEO", "TYPEDEF", 
		"UNSIGNED", "VOID_TYPE", "WHILE", "WS"
	};
	public static final int EOF=-1;
	public static final int BREAK=4;
	public static final int B_L=5;
	public static final int B_R=6;
	public static final int CALCULATE=7;
	public static final int CHAR_TYPE=8;
	public static final int COMMENT1=9;
	public static final int COMMENT2=10;
	public static final int CONTINUE=11;
	public static final int DEFAULT=12;
	public static final int DO=13;
	public static final int DOUBLE_TYPE=14;
	public static final int ELSE=15;
	public static final int ENUM=16;
	public static final int EO1=17;
	public static final int EO10=18;
	public static final int EO11=19;
	public static final int EO12=20;
	public static final int EO2=21;
	public static final int EO5=22;
	public static final int EO6=23;
	public static final int EO7=24;
	public static final int EO9=25;
	public static final int EOF_=26;
	public static final int EQ_OP=27;
	public static final int EXTRA1=28;
	public static final int EXTRA10=29;
	public static final int EXTRA11=30;
	public static final int EXTRA12=31;
	public static final int EXTRA13=32;
	public static final int EXTRA8=33;
	public static final int EXTRA9=34;
	public static final int FLOAT_TYPE=35;
	public static final int FOR=36;
	public static final int Floating_point_constant=37;
	public static final int GE2_OP=38;
	public static final int GE_OP=39;
	public static final int GOTO=40;
	public static final int IF_=41;
	public static final int INT_TYPE=42;
	public static final int Identifier=43;
	public static final int Integer_constant=44;
	public static final int LE2_OP=45;
	public static final int LETTER=46;
	public static final int LE_OP=47;
	public static final int LONG_TYPE=48;
	public static final int MAIN=49;
	public static final int MM_OP=50;
	public static final int M_L=51;
	public static final int M_R=52;
	public static final int NEWLINE_=53;
	public static final int NE_OP=54;
	public static final int PP_OP=55;
	public static final int PRINTF=56;
	public static final int RETURN=57;
	public static final int SIGNED=58;
	public static final int SIZEOF=59;
	public static final int STATIC=60;
	public static final int STRUCT=61;
	public static final int SWITCH=62;
	public static final int S_L=63;
	public static final int S_R=64;
	public static final int TAB_=65;
	public static final int TOTALEO=66;
	public static final int TYPEDEF=67;
	public static final int UNSIGNED=68;
	public static final int VOID_TYPE=69;
	public static final int WHILE=70;
	public static final int WS=71;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public myparserParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public myparserParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return myparserParser.tokenNames; }
	@Override public String getGrammarFileName() { return "myparser.g"; }


	boolean TRACEON = true;



	// $ANTLR start "program"
	// myparser.g:16:1: program : MAIN S_L S_R B_L declarations statements B_R ;
	public final void program() throws RecognitionException {
		try {
			// myparser.g:16:8: ( MAIN S_L S_R B_L declarations statements B_R )
			// myparser.g:16:11: MAIN S_L S_R B_L declarations statements B_R
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
	// myparser.g:19:1: declarations : ( type Identifier ';' declarations | type Identifier '=' arith_expression ';' declarations |);
	public final void declarations() throws RecognitionException {
		try {
			// myparser.g:19:13: ( type Identifier ';' declarations | type Identifier '=' arith_expression ';' declarations |)
			int alt1=3;
			switch ( input.LA(1) ) {
			case INT_TYPE:
				{
				int LA1_1 = input.LA(2);
				if ( (LA1_1==EO11) ) {
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
				if ( (LA1_3==EO11) ) {
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
					// myparser.g:19:14: type Identifier ';' declarations
					{
					pushFollow(FOLLOW_type_in_declarations65);
					type();
					state._fsp--;

					match(input,Identifier,FOLLOW_Identifier_in_declarations67); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_declarations69); 
					pushFollow(FOLLOW_declarations_in_declarations71);
					declarations();
					state._fsp--;

					 if (TRACEON) System.out.println("declarations: type Identifier : declarations"); 
					}
					break;
				case 2 :
					// myparser.g:21:14: type Identifier '=' arith_expression ';' declarations
					{
					pushFollow(FOLLOW_type_in_declarations101);
					type();
					state._fsp--;

					match(input,Identifier,FOLLOW_Identifier_in_declarations103); 
					match(input,EXTRA8,FOLLOW_EXTRA8_in_declarations105); 
					pushFollow(FOLLOW_arith_expression_in_declarations107);
					arith_expression();
					state._fsp--;

					match(input,EXTRA10,FOLLOW_EXTRA10_in_declarations109); 
					pushFollow(FOLLOW_declarations_in_declarations111);
					declarations();
					state._fsp--;

					}
					break;
				case 3 :
					// myparser.g:25:14: 
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
	// myparser.g:27:1: type : ( INT_TYPE | FLOAT_TYPE | CHAR_TYPE | DOUBLE_TYPE | INT_TYPE '*' | CHAR_TYPE '*' );
	public final void type() throws RecognitionException {
		try {
			// myparser.g:27:5: ( INT_TYPE | FLOAT_TYPE | CHAR_TYPE | DOUBLE_TYPE | INT_TYPE '*' | CHAR_TYPE '*' )
			int alt2=6;
			switch ( input.LA(1) ) {
			case INT_TYPE:
				{
				int LA2_1 = input.LA(2);
				if ( (LA2_1==EO11) ) {
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
				if ( (LA2_3==EO11) ) {
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
					// myparser.g:27:7: INT_TYPE
					{
					match(input,INT_TYPE,FOLLOW_INT_TYPE_in_type165); 
					 if (TRACEON) System.out.println("type: INT");
					}
					break;
				case 2 :
					// myparser.g:28:6: FLOAT_TYPE
					{
					match(input,FLOAT_TYPE,FOLLOW_FLOAT_TYPE_in_type174); 
					if (TRACEON) System.out.println("type: FLOAT");
					}
					break;
				case 3 :
					// myparser.g:29:6: CHAR_TYPE
					{
					match(input,CHAR_TYPE,FOLLOW_CHAR_TYPE_in_type183); 
					if (TRACEON) System.out.println("type: CHAR");
					}
					break;
				case 4 :
					// myparser.g:30:6: DOUBLE_TYPE
					{
					match(input,DOUBLE_TYPE,FOLLOW_DOUBLE_TYPE_in_type191); 
					if (TRACEON) System.out.println("type: DOUBLE");
					}
					break;
				case 5 :
					// myparser.g:31:6: INT_TYPE '*'
					{
					match(input,INT_TYPE,FOLLOW_INT_TYPE_in_type199); 
					match(input,EO11,FOLLOW_EO11_in_type201); 
					if (TRACEON) System.out.println("type: Pointer to int");
					}
					break;
				case 6 :
					// myparser.g:32:6: CHAR_TYPE '*'
					{
					match(input,CHAR_TYPE,FOLLOW_CHAR_TYPE_in_type209); 
					match(input,EO11,FOLLOW_EO11_in_type211); 
					if (TRACEON) System.out.println("type: Pointer to char");
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
	// $ANTLR end "type"



	// $ANTLR start "statements"
	// myparser.g:33:1: statements : ( statement statements |);
	public final void statements() throws RecognitionException {
		try {
			// myparser.g:33:11: ( statement statements |)
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
					// myparser.g:33:12: statement statements
					{
					pushFollow(FOLLOW_statement_in_statements217);
					statement();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statements219);
					statements();
					state._fsp--;

					}
					break;
				case 2 :
					// myparser.g:34:10: 
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
	// myparser.g:36:1: statement : ( Identifier EXTRA8 arith_expression ';' | Identifier TOTALEO Identifier ';' | Identifier TOTALEO Integer_constant ';' | Identifier TOTALEO Identifier | Identifier TOTALEO Integer_constant | Identifier TOTALEO | Identifier TOTALEO ';' | Identifier EXTRA8 Identifier CALCULATE Identifier ';' | Identifier CALCULATE Identifier TOTALEO Integer_constant | BREAK ';' | CONTINUE ';' | FOR S_L statements S_R B_L declarations statements B_R | WHILE S_L statements S_R B_L declarations statements B_R | PRINTF S_L EXTRA13 primary_expression EXTRA13 S_R ';' | IF_ S_L statements S_R B_L declarations statements B_R | ELSE IF_ S_L statements S_R B_L declarations statements B_R | ELSE B_L declarations statements B_R | RETURN Integer_constant ';' );
	public final void statement() throws RecognitionException {
		try {
			// myparser.g:36:10: ( Identifier EXTRA8 arith_expression ';' | Identifier TOTALEO Identifier ';' | Identifier TOTALEO Integer_constant ';' | Identifier TOTALEO Identifier | Identifier TOTALEO Integer_constant | Identifier TOTALEO | Identifier TOTALEO ';' | Identifier EXTRA8 Identifier CALCULATE Identifier ';' | Identifier CALCULATE Identifier TOTALEO Integer_constant | BREAK ';' | CONTINUE ';' | FOR S_L statements S_R B_L declarations statements B_R | WHILE S_L statements S_R B_L declarations statements B_R | PRINTF S_L EXTRA13 primary_expression EXTRA13 S_R ';' | IF_ S_L statements S_R B_L declarations statements B_R | ELSE IF_ S_L statements S_R B_L declarations statements B_R | ELSE B_L declarations statements B_R | RETURN Integer_constant ';' )
			int alt4=18;
			switch ( input.LA(1) ) {
			case Identifier:
				{
				switch ( input.LA(2) ) {
				case EXTRA8:
					{
					int LA4_10 = input.LA(3);
					if ( (LA4_10==Identifier) ) {
						int LA4_15 = input.LA(4);
						if ( (LA4_15==CALCULATE) ) {
							alt4=8;
						}
						else if ( ((LA4_15 >= EO10 && LA4_15 <= EO12)||LA4_15==EO9||LA4_15==EXTRA10||LA4_15==Floating_point_constant||(LA4_15 >= Identifier && LA4_15 <= Integer_constant)) ) {
							alt4=1;
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
					else if ( (LA4_10==EO10||LA4_10==EO9||LA4_10==Floating_point_constant||LA4_10==Integer_constant) ) {
						alt4=1;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 10, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case TOTALEO:
					{
					switch ( input.LA(3) ) {
					case Identifier:
						{
						switch ( input.LA(4) ) {
						case EXTRA10:
							{
							alt4=2;
							}
							break;
						case CALCULATE:
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
									new NoViableAltException("", 4, 17, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
						}
						break;
					case Integer_constant:
						{
						int LA4_18 = input.LA(4);
						if ( (LA4_18==EXTRA10) ) {
							alt4=3;
						}
						else if ( (LA4_18==BREAK||LA4_18==B_R||LA4_18==CONTINUE||LA4_18==ELSE||LA4_18==FOR||LA4_18==IF_||LA4_18==Identifier||(LA4_18 >= PRINTF && LA4_18 <= RETURN)||LA4_18==S_R||LA4_18==WHILE) ) {
							alt4=5;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 18, input);
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
					break;
				case CALCULATE:
					{
					alt4=9;
					}
					break;
				default:
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
				alt4=10;
				}
				break;
			case CONTINUE:
				{
				alt4=11;
				}
				break;
			case FOR:
				{
				alt4=12;
				}
				break;
			case WHILE:
				{
				alt4=13;
				}
				break;
			case PRINTF:
				{
				alt4=14;
				}
				break;
			case IF_:
				{
				alt4=15;
				}
				break;
			case ELSE:
				{
				int LA4_8 = input.LA(2);
				if ( (LA4_8==IF_) ) {
					alt4=16;
				}
				else if ( (LA4_8==B_L) ) {
					alt4=17;
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
				alt4=18;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// myparser.g:36:11: Identifier EXTRA8 arith_expression ';'
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement237); 
					match(input,EXTRA8,FOLLOW_EXTRA8_in_statement239); 
					pushFollow(FOLLOW_arith_expression_in_statement241);
					arith_expression();
					state._fsp--;

					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement243); 
					 if (TRACEON) System.out.println("Assign value");
					}
					break;
				case 2 :
					// myparser.g:39:5: Identifier TOTALEO Identifier ';'
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement258); 
					match(input,TOTALEO,FOLLOW_TOTALEO_in_statement260); 
					match(input,Identifier,FOLLOW_Identifier_in_statement262); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement264); 
					}
					break;
				case 3 :
					// myparser.g:40:5: Identifier TOTALEO Integer_constant ';'
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement270); 
					match(input,TOTALEO,FOLLOW_TOTALEO_in_statement272); 
					match(input,Integer_constant,FOLLOW_Integer_constant_in_statement274); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement276); 
					}
					break;
				case 4 :
					// myparser.g:41:5: Identifier TOTALEO Identifier
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement282); 
					match(input,TOTALEO,FOLLOW_TOTALEO_in_statement284); 
					match(input,Identifier,FOLLOW_Identifier_in_statement286); 
					}
					break;
				case 5 :
					// myparser.g:42:5: Identifier TOTALEO Integer_constant
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement292); 
					match(input,TOTALEO,FOLLOW_TOTALEO_in_statement294); 
					match(input,Integer_constant,FOLLOW_Integer_constant_in_statement296); 
					}
					break;
				case 6 :
					// myparser.g:43:5: Identifier TOTALEO
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement302); 
					match(input,TOTALEO,FOLLOW_TOTALEO_in_statement304); 
					}
					break;
				case 7 :
					// myparser.g:44:5: Identifier TOTALEO ';'
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement310); 
					match(input,TOTALEO,FOLLOW_TOTALEO_in_statement312); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement314); 
					}
					break;
				case 8 :
					// myparser.g:45:5: Identifier EXTRA8 Identifier CALCULATE Identifier ';'
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement320); 
					match(input,EXTRA8,FOLLOW_EXTRA8_in_statement322); 
					match(input,Identifier,FOLLOW_Identifier_in_statement324); 
					match(input,CALCULATE,FOLLOW_CALCULATE_in_statement326); 
					match(input,Identifier,FOLLOW_Identifier_in_statement328); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement330); 
					}
					break;
				case 9 :
					// myparser.g:46:5: Identifier CALCULATE Identifier TOTALEO Integer_constant
					{
					match(input,Identifier,FOLLOW_Identifier_in_statement336); 
					match(input,CALCULATE,FOLLOW_CALCULATE_in_statement338); 
					match(input,Identifier,FOLLOW_Identifier_in_statement340); 
					match(input,TOTALEO,FOLLOW_TOTALEO_in_statement342); 
					match(input,Integer_constant,FOLLOW_Integer_constant_in_statement344); 
					}
					break;
				case 10 :
					// myparser.g:47:5: BREAK ';'
					{
					match(input,BREAK,FOLLOW_BREAK_in_statement351); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement353); 
					if  (TRACEON) System.out.println("Break this for loop");
					}
					break;
				case 11 :
					// myparser.g:49:5: CONTINUE ';'
					{
					match(input,CONTINUE,FOLLOW_CONTINUE_in_statement364); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement366); 
					if  (TRACEON) System.out.println("Continue to next for loop");
					}
					break;
				case 12 :
					// myparser.g:51:5: FOR S_L statements S_R B_L declarations statements B_R
					{
					match(input,FOR,FOLLOW_FOR_in_statement380); 
					match(input,S_L,FOLLOW_S_L_in_statement382); 
					pushFollow(FOLLOW_statements_in_statement384);
					statements();
					state._fsp--;

					match(input,S_R,FOLLOW_S_R_in_statement386); 
					match(input,B_L,FOLLOW_B_L_in_statement388); 
					pushFollow(FOLLOW_declarations_in_statement390);
					declarations();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statement392);
					statements();
					state._fsp--;

					match(input,B_R,FOLLOW_B_R_in_statement394); 
					if  (TRACEON) System.out.println("For loop");
					}
					break;
				case 13 :
					// myparser.g:53:5: WHILE S_L statements S_R B_L declarations statements B_R
					{
					match(input,WHILE,FOLLOW_WHILE_in_statement405); 
					match(input,S_L,FOLLOW_S_L_in_statement407); 
					pushFollow(FOLLOW_statements_in_statement409);
					statements();
					state._fsp--;

					match(input,S_R,FOLLOW_S_R_in_statement411); 
					match(input,B_L,FOLLOW_B_L_in_statement413); 
					pushFollow(FOLLOW_declarations_in_statement415);
					declarations();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statement417);
					statements();
					state._fsp--;

					match(input,B_R,FOLLOW_B_R_in_statement419); 
					if  (TRACEON) System.out.println("While loop");
					}
					break;
				case 14 :
					// myparser.g:55:5: PRINTF S_L EXTRA13 primary_expression EXTRA13 S_R ';'
					{
					match(input,PRINTF,FOLLOW_PRINTF_in_statement430); 
					match(input,S_L,FOLLOW_S_L_in_statement432); 
					match(input,EXTRA13,FOLLOW_EXTRA13_in_statement434); 
					pushFollow(FOLLOW_primary_expression_in_statement436);
					primary_expression();
					state._fsp--;

					match(input,EXTRA13,FOLLOW_EXTRA13_in_statement438); 
					match(input,S_R,FOLLOW_S_R_in_statement440); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement442); 
					if  (TRACEON) System.out.println("Print data");
					}
					break;
				case 15 :
					// myparser.g:57:5: IF_ S_L statements S_R B_L declarations statements B_R
					{
					match(input,IF_,FOLLOW_IF__in_statement456); 
					match(input,S_L,FOLLOW_S_L_in_statement458); 
					pushFollow(FOLLOW_statements_in_statement460);
					statements();
					state._fsp--;

					match(input,S_R,FOLLOW_S_R_in_statement462); 
					match(input,B_L,FOLLOW_B_L_in_statement464); 
					pushFollow(FOLLOW_declarations_in_statement466);
					declarations();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statement468);
					statements();
					state._fsp--;

					match(input,B_R,FOLLOW_B_R_in_statement470); 
					if  (TRACEON) System.out.println("If condition");
					}
					break;
				case 16 :
					// myparser.g:59:5: ELSE IF_ S_L statements S_R B_L declarations statements B_R
					{
					match(input,ELSE,FOLLOW_ELSE_in_statement481); 
					match(input,IF_,FOLLOW_IF__in_statement483); 
					match(input,S_L,FOLLOW_S_L_in_statement485); 
					pushFollow(FOLLOW_statements_in_statement487);
					statements();
					state._fsp--;

					match(input,S_R,FOLLOW_S_R_in_statement489); 
					match(input,B_L,FOLLOW_B_L_in_statement491); 
					pushFollow(FOLLOW_declarations_in_statement493);
					declarations();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statement495);
					statements();
					state._fsp--;

					match(input,B_R,FOLLOW_B_R_in_statement497); 
					if  (TRACEON) System.out.println("Else if condition");
					}
					break;
				case 17 :
					// myparser.g:61:5: ELSE B_L declarations statements B_R
					{
					match(input,ELSE,FOLLOW_ELSE_in_statement511); 
					match(input,B_L,FOLLOW_B_L_in_statement513); 
					pushFollow(FOLLOW_declarations_in_statement515);
					declarations();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statement517);
					statements();
					state._fsp--;

					match(input,B_R,FOLLOW_B_R_in_statement519); 
					if  (TRACEON) System.out.println("Else condition");
					}
					break;
				case 18 :
					// myparser.g:63:5: RETURN Integer_constant ';'
					{
					match(input,RETURN,FOLLOW_RETURN_in_statement530); 
					match(input,Integer_constant,FOLLOW_Integer_constant_in_statement532); 
					match(input,EXTRA10,FOLLOW_EXTRA10_in_statement534); 
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
	}
	// $ANTLR end "statement"



	// $ANTLR start "arith_expression"
	// myparser.g:66:1: arith_expression : arith_term arith_expression1 ;
	public final void arith_expression() throws RecognitionException {
		try {
			// myparser.g:66:17: ( arith_term arith_expression1 )
			// myparser.g:66:18: arith_term arith_expression1
			{
			pushFollow(FOLLOW_arith_term_in_arith_expression547);
			arith_term();
			state._fsp--;

			pushFollow(FOLLOW_arith_expression1_in_arith_expression549);
			arith_expression1();
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
	// $ANTLR end "arith_expression"



	// $ANTLR start "arith_expression1"
	// myparser.g:67:1: arith_expression1 : ( '+' arith_term arith_expression1 | '-' arith_term arith_expression1 |);
	public final void arith_expression1() throws RecognitionException {
		try {
			// myparser.g:67:18: ( '+' arith_term arith_expression1 | '-' arith_term arith_expression1 |)
			int alt5=3;
			switch ( input.LA(1) ) {
			case EO9:
				{
				alt5=1;
				}
				break;
			case EO10:
				{
				alt5=2;
				}
				break;
			case EXTRA10:
				{
				alt5=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// myparser.g:67:19: '+' arith_term arith_expression1
					{
					match(input,EO9,FOLLOW_EO9_in_arith_expression1554); 
					pushFollow(FOLLOW_arith_term_in_arith_expression1556);
					arith_term();
					state._fsp--;

					pushFollow(FOLLOW_arith_expression1_in_arith_expression1558);
					arith_expression1();
					state._fsp--;

					}
					break;
				case 2 :
					// myparser.g:68:19: '-' arith_term arith_expression1
					{
					match(input,EO10,FOLLOW_EO10_in_arith_expression1578); 
					pushFollow(FOLLOW_arith_term_in_arith_expression1580);
					arith_term();
					state._fsp--;

					pushFollow(FOLLOW_arith_expression1_in_arith_expression1582);
					arith_expression1();
					state._fsp--;

					}
					break;
				case 3 :
					// myparser.g:69:18: 
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
	// $ANTLR end "arith_expression1"



	// $ANTLR start "arith_term"
	// myparser.g:71:1: arith_term : arith_factor arith_term1 ;
	public final void arith_term() throws RecognitionException {
		try {
			// myparser.g:71:11: ( arith_factor arith_term1 )
			// myparser.g:71:12: arith_factor arith_term1
			{
			pushFollow(FOLLOW_arith_factor_in_arith_term606);
			arith_factor();
			state._fsp--;

			pushFollow(FOLLOW_arith_term1_in_arith_term608);
			arith_term1();
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
	// $ANTLR end "arith_term"



	// $ANTLR start "arith_term1"
	// myparser.g:72:1: arith_term1 : ( '*' arith_factor arith_term1 | '/' arith_factor arith_term1 |);
	public final void arith_term1() throws RecognitionException {
		try {
			// myparser.g:72:12: ( '*' arith_factor arith_term1 | '/' arith_factor arith_term1 |)
			int alt6=3;
			switch ( input.LA(1) ) {
			case EO11:
				{
				alt6=1;
				}
				break;
			case EO12:
				{
				alt6=2;
				}
				break;
			case EO10:
			case EO9:
			case EXTRA10:
				{
				alt6=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// myparser.g:72:13: '*' arith_factor arith_term1
					{
					match(input,EO11,FOLLOW_EO11_in_arith_term1613); 
					pushFollow(FOLLOW_arith_factor_in_arith_term1615);
					arith_factor();
					state._fsp--;

					pushFollow(FOLLOW_arith_term1_in_arith_term1617);
					arith_term1();
					state._fsp--;

					}
					break;
				case 2 :
					// myparser.g:73:13: '/' arith_factor arith_term1
					{
					match(input,EO12,FOLLOW_EO12_in_arith_term1631); 
					pushFollow(FOLLOW_arith_factor_in_arith_term1633);
					arith_factor();
					state._fsp--;

					pushFollow(FOLLOW_arith_term1_in_arith_term1635);
					arith_term1();
					state._fsp--;

					}
					break;
				case 3 :
					// myparser.g:74:12: 
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
	// $ANTLR end "arith_term1"



	// $ANTLR start "arith_factor"
	// myparser.g:76:1: arith_factor : ( '+' arith_factor | '-' arith_factor | primary_expression );
	public final void arith_factor() throws RecognitionException {
		try {
			// myparser.g:76:13: ( '+' arith_factor | '-' arith_factor | primary_expression )
			int alt7=3;
			switch ( input.LA(1) ) {
			case EO9:
				{
				alt7=1;
				}
				break;
			case EO10:
				{
				alt7=2;
				}
				break;
			case Floating_point_constant:
			case Identifier:
			case Integer_constant:
				{
				alt7=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// myparser.g:76:15: '+' arith_factor
					{
					match(input,EO9,FOLLOW_EO9_in_arith_factor654); 
					pushFollow(FOLLOW_arith_factor_in_arith_factor656);
					arith_factor();
					state._fsp--;

					}
					break;
				case 2 :
					// myparser.g:77:14: '-' arith_factor
					{
					match(input,EO10,FOLLOW_EO10_in_arith_factor671); 
					pushFollow(FOLLOW_arith_factor_in_arith_factor673);
					arith_factor();
					state._fsp--;

					}
					break;
				case 3 :
					// myparser.g:78:14: primary_expression
					{
					pushFollow(FOLLOW_primary_expression_in_arith_factor688);
					primary_expression();
					state._fsp--;

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
	// $ANTLR end "arith_factor"



	// $ANTLR start "primary_expression"
	// myparser.g:80:1: primary_expression : ( Integer_constant primary_expression | Floating_point_constant primary_expression | Identifier primary_expression | Integer_constant | Floating_point_constant | Identifier );
	public final void primary_expression() throws RecognitionException {
		try {
			// myparser.g:80:19: ( Integer_constant primary_expression | Floating_point_constant primary_expression | Identifier primary_expression | Integer_constant | Floating_point_constant | Identifier )
			int alt8=6;
			switch ( input.LA(1) ) {
			case Integer_constant:
				{
				int LA8_1 = input.LA(2);
				if ( (LA8_1==Floating_point_constant||(LA8_1 >= Identifier && LA8_1 <= Integer_constant)) ) {
					alt8=1;
				}
				else if ( ((LA8_1 >= EO10 && LA8_1 <= EO12)||LA8_1==EO9||LA8_1==EXTRA10||LA8_1==EXTRA13) ) {
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
				if ( (LA8_2==Floating_point_constant||(LA8_2 >= Identifier && LA8_2 <= Integer_constant)) ) {
					alt8=2;
				}
				else if ( ((LA8_2 >= EO10 && LA8_2 <= EO12)||LA8_2==EO9||LA8_2==EXTRA10||LA8_2==EXTRA13) ) {
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
				if ( (LA8_3==Floating_point_constant||(LA8_3 >= Identifier && LA8_3 <= Integer_constant)) ) {
					alt8=3;
				}
				else if ( ((LA8_3 >= EO10 && LA8_3 <= EO12)||LA8_3==EO9||LA8_3==EXTRA10||LA8_3==EXTRA13) ) {
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
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// myparser.g:80:20: Integer_constant primary_expression
					{
					match(input,Integer_constant,FOLLOW_Integer_constant_in_primary_expression694); 
					pushFollow(FOLLOW_primary_expression_in_primary_expression696);
					primary_expression();
					state._fsp--;

					}
					break;
				case 2 :
					// myparser.g:81:20: Floating_point_constant primary_expression
					{
					match(input,Floating_point_constant,FOLLOW_Floating_point_constant_in_primary_expression717); 
					pushFollow(FOLLOW_primary_expression_in_primary_expression719);
					primary_expression();
					state._fsp--;

					}
					break;
				case 3 :
					// myparser.g:82:20: Identifier primary_expression
					{
					match(input,Identifier,FOLLOW_Identifier_in_primary_expression740); 
					pushFollow(FOLLOW_primary_expression_in_primary_expression742);
					primary_expression();
					state._fsp--;

					}
					break;
				case 4 :
					// myparser.g:83:20: Integer_constant
					{
					match(input,Integer_constant,FOLLOW_Integer_constant_in_primary_expression763); 
					}
					break;
				case 5 :
					// myparser.g:84:20: Floating_point_constant
					{
					match(input,Floating_point_constant,FOLLOW_Floating_point_constant_in_primary_expression784); 
					}
					break;
				case 6 :
					// myparser.g:85:20: Identifier
					{
					match(input,Identifier,FOLLOW_Identifier_in_primary_expression805); 
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
	// $ANTLR end "primary_expression"

	// Delegated rules



	public static final BitSet FOLLOW_MAIN_in_program37 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_S_L_in_program39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_S_R_in_program41 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_B_L_in_program43 = new BitSet(new long[]{0x03000E180000C950L,0x0000000000000040L});
	public static final BitSet FOLLOW_declarations_in_program45 = new BitSet(new long[]{0x03000A1000008850L,0x0000000000000040L});
	public static final BitSet FOLLOW_statements_in_program47 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_B_R_in_program49 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_declarations65 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_Identifier_in_declarations67 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_EXTRA10_in_declarations69 = new BitSet(new long[]{0x0000040800004100L});
	public static final BitSet FOLLOW_declarations_in_declarations71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_declarations101 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_Identifier_in_declarations103 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_EXTRA8_in_declarations105 = new BitSet(new long[]{0x0000182002040000L});
	public static final BitSet FOLLOW_arith_expression_in_declarations107 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_EXTRA10_in_declarations109 = new BitSet(new long[]{0x0000040800004100L});
	public static final BitSet FOLLOW_declarations_in_declarations111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_TYPE_in_type165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_TYPE_in_type174 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_TYPE_in_type183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_TYPE_in_type191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_TYPE_in_type199 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_EO11_in_type201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_TYPE_in_type209 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_EO11_in_type211 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements217 = new BitSet(new long[]{0x03000A1000008810L,0x0000000000000040L});
	public static final BitSet FOLLOW_statements_in_statements219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement237 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_EXTRA8_in_statement239 = new BitSet(new long[]{0x0000182002040000L});
	public static final BitSet FOLLOW_arith_expression_in_statement241 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement258 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_TOTALEO_in_statement260 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_Identifier_in_statement262 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement264 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement270 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_TOTALEO_in_statement272 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_Integer_constant_in_statement274 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement276 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement282 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_TOTALEO_in_statement284 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_Identifier_in_statement286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement292 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_TOTALEO_in_statement294 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_Integer_constant_in_statement296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement302 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_TOTALEO_in_statement304 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement310 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_TOTALEO_in_statement312 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement320 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_EXTRA8_in_statement322 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_Identifier_in_statement324 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CALCULATE_in_statement326 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_Identifier_in_statement328 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement330 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_statement336 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_CALCULATE_in_statement338 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_Identifier_in_statement340 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_TOTALEO_in_statement342 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_Integer_constant_in_statement344 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_in_statement351 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONTINUE_in_statement364 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement366 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_statement380 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_S_L_in_statement382 = new BitSet(new long[]{0x03000A1000008810L,0x0000000000000041L});
	public static final BitSet FOLLOW_statements_in_statement384 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_S_R_in_statement386 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_B_L_in_statement388 = new BitSet(new long[]{0x03000E180000C950L,0x0000000000000040L});
	public static final BitSet FOLLOW_declarations_in_statement390 = new BitSet(new long[]{0x03000A1000008850L,0x0000000000000040L});
	public static final BitSet FOLLOW_statements_in_statement392 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_B_R_in_statement394 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_statement405 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_S_L_in_statement407 = new BitSet(new long[]{0x03000A1000008810L,0x0000000000000041L});
	public static final BitSet FOLLOW_statements_in_statement409 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_S_R_in_statement411 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_B_L_in_statement413 = new BitSet(new long[]{0x03000E180000C950L,0x0000000000000040L});
	public static final BitSet FOLLOW_declarations_in_statement415 = new BitSet(new long[]{0x03000A1000008850L,0x0000000000000040L});
	public static final BitSet FOLLOW_statements_in_statement417 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_B_R_in_statement419 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINTF_in_statement430 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_S_L_in_statement432 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_EXTRA13_in_statement434 = new BitSet(new long[]{0x0000182000000000L});
	public static final BitSet FOLLOW_primary_expression_in_statement436 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_EXTRA13_in_statement438 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_S_R_in_statement440 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement442 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF__in_statement456 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_S_L_in_statement458 = new BitSet(new long[]{0x03000A1000008810L,0x0000000000000041L});
	public static final BitSet FOLLOW_statements_in_statement460 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_S_R_in_statement462 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_B_L_in_statement464 = new BitSet(new long[]{0x03000E180000C950L,0x0000000000000040L});
	public static final BitSet FOLLOW_declarations_in_statement466 = new BitSet(new long[]{0x03000A1000008850L,0x0000000000000040L});
	public static final BitSet FOLLOW_statements_in_statement468 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_B_R_in_statement470 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_in_statement481 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_IF__in_statement483 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_S_L_in_statement485 = new BitSet(new long[]{0x03000A1000008810L,0x0000000000000041L});
	public static final BitSet FOLLOW_statements_in_statement487 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_S_R_in_statement489 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_B_L_in_statement491 = new BitSet(new long[]{0x03000E180000C950L,0x0000000000000040L});
	public static final BitSet FOLLOW_declarations_in_statement493 = new BitSet(new long[]{0x03000A1000008850L,0x0000000000000040L});
	public static final BitSet FOLLOW_statements_in_statement495 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_B_R_in_statement497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_in_statement511 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_B_L_in_statement513 = new BitSet(new long[]{0x03000E180000C950L,0x0000000000000040L});
	public static final BitSet FOLLOW_declarations_in_statement515 = new BitSet(new long[]{0x03000A1000008850L,0x0000000000000040L});
	public static final BitSet FOLLOW_statements_in_statement517 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_B_R_in_statement519 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_in_statement530 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_Integer_constant_in_statement532 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_EXTRA10_in_statement534 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arith_term_in_arith_expression547 = new BitSet(new long[]{0x0000000002040000L});
	public static final BitSet FOLLOW_arith_expression1_in_arith_expression549 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EO9_in_arith_expression1554 = new BitSet(new long[]{0x0000182002040000L});
	public static final BitSet FOLLOW_arith_term_in_arith_expression1556 = new BitSet(new long[]{0x0000000002040000L});
	public static final BitSet FOLLOW_arith_expression1_in_arith_expression1558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EO10_in_arith_expression1578 = new BitSet(new long[]{0x0000182002040000L});
	public static final BitSet FOLLOW_arith_term_in_arith_expression1580 = new BitSet(new long[]{0x0000000002040000L});
	public static final BitSet FOLLOW_arith_expression1_in_arith_expression1582 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arith_factor_in_arith_term606 = new BitSet(new long[]{0x0000000000180000L});
	public static final BitSet FOLLOW_arith_term1_in_arith_term608 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EO11_in_arith_term1613 = new BitSet(new long[]{0x0000182002040000L});
	public static final BitSet FOLLOW_arith_factor_in_arith_term1615 = new BitSet(new long[]{0x0000000000180000L});
	public static final BitSet FOLLOW_arith_term1_in_arith_term1617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EO12_in_arith_term1631 = new BitSet(new long[]{0x0000182002040000L});
	public static final BitSet FOLLOW_arith_factor_in_arith_term1633 = new BitSet(new long[]{0x0000000000180000L});
	public static final BitSet FOLLOW_arith_term1_in_arith_term1635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EO9_in_arith_factor654 = new BitSet(new long[]{0x0000182002040000L});
	public static final BitSet FOLLOW_arith_factor_in_arith_factor656 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EO10_in_arith_factor671 = new BitSet(new long[]{0x0000182002040000L});
	public static final BitSet FOLLOW_arith_factor_in_arith_factor673 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_expression_in_arith_factor688 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_constant_in_primary_expression694 = new BitSet(new long[]{0x0000182000000000L});
	public static final BitSet FOLLOW_primary_expression_in_primary_expression696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Floating_point_constant_in_primary_expression717 = new BitSet(new long[]{0x0000182000000000L});
	public static final BitSet FOLLOW_primary_expression_in_primary_expression719 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_primary_expression740 = new BitSet(new long[]{0x0000182000000000L});
	public static final BitSet FOLLOW_primary_expression_in_primary_expression742 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_constant_in_primary_expression763 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Floating_point_constant_in_primary_expression784 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_primary_expression805 = new BitSet(new long[]{0x0000000000000002L});
}
