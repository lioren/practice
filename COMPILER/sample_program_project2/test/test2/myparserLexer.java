// $ANTLR 3.5.1 myparser.g 2014-05-02 10:55:51

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myparserLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public myparserLexer() {} 
	public myparserLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public myparserLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "myparser.g"; }

	// $ANTLR start "INT_TYPE"
	public final void mINT_TYPE() throws RecognitionException {
		try {
			int _type = INT_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:92:11: ( 'int' )
			// myparser.g:92:13: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT_TYPE"

	// $ANTLR start "MAIN"
	public final void mMAIN() throws RecognitionException {
		try {
			int _type = MAIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:93:6: ( 'main' )
			// myparser.g:93:8: 'main'
			{
			match("main"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAIN"

	// $ANTLR start "CHAR_TYPE"
	public final void mCHAR_TYPE() throws RecognitionException {
		try {
			int _type = CHAR_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:94:11: ( 'char' )
			// myparser.g:94:13: 'char'
			{
			match("char"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR_TYPE"

	// $ANTLR start "VOID_TYPE"
	public final void mVOID_TYPE() throws RecognitionException {
		try {
			int _type = VOID_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:95:11: ( 'void' )
			// myparser.g:95:13: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VOID_TYPE"

	// $ANTLR start "FLOAT_TYPE"
	public final void mFLOAT_TYPE() throws RecognitionException {
		try {
			int _type = FLOAT_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:96:11: ( 'float' )
			// myparser.g:96:13: 'float'
			{
			match("float"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_TYPE"

	// $ANTLR start "DOUBLE_TYPE"
	public final void mDOUBLE_TYPE() throws RecognitionException {
		try {
			int _type = DOUBLE_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:97:12: ( 'double' )
			// myparser.g:97:14: 'double'
			{
			match("double"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLE_TYPE"

	// $ANTLR start "LONG_TYPE"
	public final void mLONG_TYPE() throws RecognitionException {
		try {
			int _type = LONG_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:98:11: ( 'long' )
			// myparser.g:98:13: 'long'
			{
			match("long"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LONG_TYPE"

	// $ANTLR start "STATIC"
	public final void mSTATIC() throws RecognitionException {
		try {
			int _type = STATIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:100:11: ( 'static' )
			// myparser.g:100:13: 'static'
			{
			match("static"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STATIC"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:101:11: ( 'else' )
			// myparser.g:101:13: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "ENUM"
	public final void mENUM() throws RecognitionException {
		try {
			int _type = ENUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:102:11: ( 'enum' )
			// myparser.g:102:13: 'enum'
			{
			match("enum"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENUM"

	// $ANTLR start "GOTO"
	public final void mGOTO() throws RecognitionException {
		try {
			int _type = GOTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:103:11: ( 'goto' )
			// myparser.g:103:13: 'goto'
			{
			match("goto"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GOTO"

	// $ANTLR start "CONTINUE"
	public final void mCONTINUE() throws RecognitionException {
		try {
			int _type = CONTINUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:104:11: ( 'continue' )
			// myparser.g:104:13: 'continue'
			{
			match("continue"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONTINUE"

	// $ANTLR start "BREAK"
	public final void mBREAK() throws RecognitionException {
		try {
			int _type = BREAK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:105:11: ( 'break' )
			// myparser.g:105:13: 'break'
			{
			match("break"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BREAK"

	// $ANTLR start "DO"
	public final void mDO() throws RecognitionException {
		try {
			int _type = DO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:106:11: ( 'do' )
			// myparser.g:106:13: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DO"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:107:11: ( 'for' )
			// myparser.g:107:13: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "DEFAULT"
	public final void mDEFAULT() throws RecognitionException {
		try {
			int _type = DEFAULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:108:11: ( 'default' )
			// myparser.g:108:13: 'default'
			{
			match("default"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULT"

	// $ANTLR start "SIZEOF"
	public final void mSIZEOF() throws RecognitionException {
		try {
			int _type = SIZEOF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:109:11: ( 'sizeof' )
			// myparser.g:109:13: 'sizeof'
			{
			match("sizeof"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SIZEOF"

	// $ANTLR start "STRUCT"
	public final void mSTRUCT() throws RecognitionException {
		try {
			int _type = STRUCT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:110:11: ( 'struct' )
			// myparser.g:110:13: 'struct'
			{
			match("struct"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRUCT"

	// $ANTLR start "TYPEDEF"
	public final void mTYPEDEF() throws RecognitionException {
		try {
			int _type = TYPEDEF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:111:11: ( 'typedef' )
			// myparser.g:111:13: 'typedef'
			{
			match("typedef"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPEDEF"

	// $ANTLR start "SIGNED"
	public final void mSIGNED() throws RecognitionException {
		try {
			int _type = SIGNED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:112:11: ( 'signed' )
			// myparser.g:112:13: 'signed'
			{
			match("signed"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SIGNED"

	// $ANTLR start "UNSIGNED"
	public final void mUNSIGNED() throws RecognitionException {
		try {
			int _type = UNSIGNED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:113:11: ( 'unsigned' )
			// myparser.g:113:13: 'unsigned'
			{
			match("unsigned"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNSIGNED"

	// $ANTLR start "SWITCH"
	public final void mSWITCH() throws RecognitionException {
		try {
			int _type = SWITCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:114:11: ( 'switch' )
			// myparser.g:114:13: 'switch'
			{
			match("switch"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SWITCH"

	// $ANTLR start "PRINTF"
	public final void mPRINTF() throws RecognitionException {
		try {
			int _type = PRINTF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:115:11: ( 'printf' )
			// myparser.g:115:13: 'printf'
			{
			match("printf"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINTF"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:116:11: ( 'return' )
			// myparser.g:116:13: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "EOF_"
	public final void mEOF_() throws RecognitionException {
		try {
			int _type = EOF_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:117:12: ( '\\\\0' )
			// myparser.g:117:14: '\\\\0'
			{
			match("\\0"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EOF_"

	// $ANTLR start "NEWLINE_"
	public final void mNEWLINE_() throws RecognitionException {
		try {
			int _type = NEWLINE_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:118:12: ( '\\\\n' )
			// myparser.g:118:14: '\\\\n'
			{
			match("\\n"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE_"

	// $ANTLR start "TAB_"
	public final void mTAB_() throws RecognitionException {
		try {
			int _type = TAB_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:119:12: ( '\\\\t' )
			// myparser.g:119:14: '\\\\t'
			{
			match("\\t"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TAB_"

	// $ANTLR start "IF_"
	public final void mIF_() throws RecognitionException {
		try {
			int _type = IF_;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:122:6: ( 'if' )
			// myparser.g:122:8: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF_"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:123:10: ( 'while' )
			// myparser.g:123:12: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "TOTALEO"
	public final void mTOTALEO() throws RecognitionException {
		try {
			int _type = TOTALEO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:127:9: ( ( EQ_OP | LE_OP | GE_OP | LE2_OP | GE2_OP | NE_OP | PP_OP | MM_OP | EO1 | EO2 | EO5 | EO6 | EO7 )* )
			// myparser.g:127:11: ( EQ_OP | LE_OP | GE_OP | LE2_OP | GE2_OP | NE_OP | PP_OP | MM_OP | EO1 | EO2 | EO5 | EO6 | EO7 )*
			{
			// myparser.g:127:11: ( EQ_OP | LE_OP | GE_OP | LE2_OP | GE2_OP | NE_OP | PP_OP | MM_OP | EO1 | EO2 | EO5 | EO6 | EO7 )*
			loop1:
			while (true) {
				int alt1=14;
				alt1 = dfa1.predict(input);
				switch (alt1) {
				case 1 :
					// myparser.g:127:12: EQ_OP
					{
					mEQ_OP(); 

					}
					break;
				case 2 :
					// myparser.g:127:18: LE_OP
					{
					mLE_OP(); 

					}
					break;
				case 3 :
					// myparser.g:127:24: GE_OP
					{
					mGE_OP(); 

					}
					break;
				case 4 :
					// myparser.g:127:30: LE2_OP
					{
					mLE2_OP(); 

					}
					break;
				case 5 :
					// myparser.g:127:37: GE2_OP
					{
					mGE2_OP(); 

					}
					break;
				case 6 :
					// myparser.g:127:44: NE_OP
					{
					mNE_OP(); 

					}
					break;
				case 7 :
					// myparser.g:127:50: PP_OP
					{
					mPP_OP(); 

					}
					break;
				case 8 :
					// myparser.g:127:56: MM_OP
					{
					mMM_OP(); 

					}
					break;
				case 9 :
					// myparser.g:127:62: EO1
					{
					mEO1(); 

					}
					break;
				case 10 :
					// myparser.g:127:66: EO2
					{
					mEO2(); 

					}
					break;
				case 11 :
					// myparser.g:127:70: EO5
					{
					mEO5(); 

					}
					break;
				case 12 :
					// myparser.g:127:74: EO6
					{
					mEO6(); 

					}
					break;
				case 13 :
					// myparser.g:127:78: EO7
					{
					mEO7(); 

					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TOTALEO"

	// $ANTLR start "EQ_OP"
	public final void mEQ_OP() throws RecognitionException {
		try {
			// myparser.g:128:16: ( '==' )
			// myparser.g:128:18: '=='
			{
			match("=="); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ_OP"

	// $ANTLR start "LE_OP"
	public final void mLE_OP() throws RecognitionException {
		try {
			// myparser.g:129:16: ( '<=' )
			// myparser.g:129:18: '<='
			{
			match("<="); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LE_OP"

	// $ANTLR start "LE2_OP"
	public final void mLE2_OP() throws RecognitionException {
		try {
			// myparser.g:130:16: ( '<' )
			// myparser.g:130:18: '<'
			{
			match('<'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LE2_OP"

	// $ANTLR start "GE_OP"
	public final void mGE_OP() throws RecognitionException {
		try {
			// myparser.g:131:16: ( '>=' )
			// myparser.g:131:18: '>='
			{
			match(">="); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GE_OP"

	// $ANTLR start "GE2_OP"
	public final void mGE2_OP() throws RecognitionException {
		try {
			// myparser.g:132:16: ( '>' )
			// myparser.g:132:18: '>'
			{
			match('>'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GE2_OP"

	// $ANTLR start "NE_OP"
	public final void mNE_OP() throws RecognitionException {
		try {
			// myparser.g:133:16: ( '!=' )
			// myparser.g:133:18: '!='
			{
			match("!="); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NE_OP"

	// $ANTLR start "PP_OP"
	public final void mPP_OP() throws RecognitionException {
		try {
			// myparser.g:134:16: ( '++' )
			// myparser.g:134:18: '++'
			{
			match("++"); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PP_OP"

	// $ANTLR start "MM_OP"
	public final void mMM_OP() throws RecognitionException {
		try {
			// myparser.g:135:16: ( '--' )
			// myparser.g:135:18: '--'
			{
			match("--"); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MM_OP"

	// $ANTLR start "EO1"
	public final void mEO1() throws RecognitionException {
		try {
			// myparser.g:136:16: ( '&&' )
			// myparser.g:136:18: '&&'
			{
			match("&&"); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO1"

	// $ANTLR start "EO2"
	public final void mEO2() throws RecognitionException {
		try {
			// myparser.g:137:16: ( '||' )
			// myparser.g:137:18: '||'
			{
			match("||"); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO2"

	// $ANTLR start "EO5"
	public final void mEO5() throws RecognitionException {
		try {
			// myparser.g:138:16: ( '!' )
			// myparser.g:138:18: '!'
			{
			match('!'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO5"

	// $ANTLR start "EO6"
	public final void mEO6() throws RecognitionException {
		try {
			// myparser.g:139:16: ( '^' )
			// myparser.g:139:18: '^'
			{
			match('^'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO6"

	// $ANTLR start "EO7"
	public final void mEO7() throws RecognitionException {
		try {
			// myparser.g:140:16: ( '~' )
			// myparser.g:140:18: '~'
			{
			match('~'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO7"

	// $ANTLR start "CALCULATE"
	public final void mCALCULATE() throws RecognitionException {
		try {
			int _type = CALCULATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:141:10: ( ( EO9 | EO10 | EO11 | EO12 )+ )
			// myparser.g:141:12: ( EO9 | EO10 | EO11 | EO12 )+
			{
			// myparser.g:141:12: ( EO9 | EO10 | EO11 | EO12 )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '*' && LA2_0 <= '+')||LA2_0=='-'||LA2_0=='/') ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// myparser.g:
					{
					if ( (input.LA(1) >= '*' && input.LA(1) <= '+')||input.LA(1)=='-'||input.LA(1)=='/' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CALCULATE"

	// $ANTLR start "EO9"
	public final void mEO9() throws RecognitionException {
		try {
			// myparser.g:142:16: ( '+' )
			// myparser.g:142:18: '+'
			{
			match('+'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO9"

	// $ANTLR start "EO10"
	public final void mEO10() throws RecognitionException {
		try {
			// myparser.g:143:16: ( '-' )
			// myparser.g:143:18: '-'
			{
			match('-'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO10"

	// $ANTLR start "EO11"
	public final void mEO11() throws RecognitionException {
		try {
			// myparser.g:144:16: ( '*' )
			// myparser.g:144:18: '*'
			{
			match('*'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO11"

	// $ANTLR start "EO12"
	public final void mEO12() throws RecognitionException {
		try {
			// myparser.g:145:16: ( '/' )
			// myparser.g:145:18: '/'
			{
			match('/'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO12"

	// $ANTLR start "COMMENT1"
	public final void mCOMMENT1() throws RecognitionException {
		try {
			int _type = COMMENT1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:160:10: ( '//' ( . )* '\\n' )
			// myparser.g:160:12: '//' ( . )* '\\n'
			{
			match("//"); 

			// myparser.g:160:16: ( . )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\n') ) {
					alt3=2;
				}
				else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// myparser.g:160:17: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop3;
				}
			}

			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT1"

	// $ANTLR start "COMMENT2"
	public final void mCOMMENT2() throws RecognitionException {
		try {
			int _type = COMMENT2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:161:10: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// myparser.g:161:12: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// myparser.g:161:17: ( options {greedy=false; } : . )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='*') ) {
					int LA4_1 = input.LA(2);
					if ( (LA4_1=='/') ) {
						alt4=2;
					}
					else if ( ((LA4_1 >= '\u0000' && LA4_1 <= '.')||(LA4_1 >= '0' && LA4_1 <= '\uFFFF')) ) {
						alt4=1;
					}

				}
				else if ( ((LA4_0 >= '\u0000' && LA4_0 <= ')')||(LA4_0 >= '+' && LA4_0 <= '\uFFFF')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// myparser.g:161:42: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop4;
				}
			}

			match("*/"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT2"

	// $ANTLR start "Identifier"
	public final void mIdentifier() throws RecognitionException {
		try {
			int _type = Identifier;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:163:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// myparser.g:163:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// myparser.g:163:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// myparser.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop5;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Identifier"

	// $ANTLR start "Integer_constant"
	public final void mInteger_constant() throws RecognitionException {
		try {
			int _type = Integer_constant;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:165:17: ( ( '0' .. '9' )* )
			// myparser.g:165:18: ( '0' .. '9' )*
			{
			// myparser.g:165:18: ( '0' .. '9' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// myparser.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop6;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Integer_constant"

	// $ANTLR start "Floating_point_constant"
	public final void mFloating_point_constant() throws RecognitionException {
		try {
			int _type = Floating_point_constant;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:166:24: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
			// myparser.g:166:25: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
			{
			// myparser.g:166:25: ( '0' .. '9' )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// myparser.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			match('.'); 
			// myparser.g:166:39: ( '0' .. '9' )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// myparser.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Floating_point_constant"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:167:3: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// myparser.g:167:4: ( ' ' | '\\t' | '\\r' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// myparser.g:171:17: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
			// myparser.g:171:19: ( 'a' .. 'z' | 'A' .. 'Z' )+
			{
			// myparser.g:171:19: ( 'a' .. 'z' | 'A' .. 'Z' )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 'A' && LA9_0 <= 'Z')||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// myparser.g:
					{
					if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "EXTRA1"
	public final void mEXTRA1() throws RecognitionException {
		try {
			int _type = EXTRA1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:173:8: ( '#' )
			// myparser.g:173:10: '#'
			{
			match('#'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTRA1"

	// $ANTLR start "S_L"
	public final void mS_L() throws RecognitionException {
		try {
			int _type = S_L;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:174:5: ( '(' )
			// myparser.g:174:7: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "S_L"

	// $ANTLR start "S_R"
	public final void mS_R() throws RecognitionException {
		try {
			int _type = S_R;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:175:5: ( ')' )
			// myparser.g:175:7: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "S_R"

	// $ANTLR start "M_L"
	public final void mM_L() throws RecognitionException {
		try {
			int _type = M_L;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:176:5: ( '[' )
			// myparser.g:176:7: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "M_L"

	// $ANTLR start "M_R"
	public final void mM_R() throws RecognitionException {
		try {
			int _type = M_R;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:177:5: ( ']' )
			// myparser.g:177:7: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "M_R"

	// $ANTLR start "B_L"
	public final void mB_L() throws RecognitionException {
		try {
			int _type = B_L;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:178:5: ( '{' )
			// myparser.g:178:7: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "B_L"

	// $ANTLR start "B_R"
	public final void mB_R() throws RecognitionException {
		try {
			int _type = B_R;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:179:5: ( '}' )
			// myparser.g:179:7: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "B_R"

	// $ANTLR start "EXTRA8"
	public final void mEXTRA8() throws RecognitionException {
		try {
			int _type = EXTRA8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:180:8: ( '=' )
			// myparser.g:180:10: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTRA8"

	// $ANTLR start "EXTRA9"
	public final void mEXTRA9() throws RecognitionException {
		try {
			int _type = EXTRA9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:181:8: ( ',' )
			// myparser.g:181:10: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTRA9"

	// $ANTLR start "EXTRA10"
	public final void mEXTRA10() throws RecognitionException {
		try {
			int _type = EXTRA10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:182:9: ( ';' )
			// myparser.g:182:11: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTRA10"

	// $ANTLR start "EXTRA11"
	public final void mEXTRA11() throws RecognitionException {
		try {
			int _type = EXTRA11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:183:9: ( '\\\\' )
			// myparser.g:183:11: '\\\\'
			{
			match('\\'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTRA11"

	// $ANTLR start "EXTRA12"
	public final void mEXTRA12() throws RecognitionException {
		try {
			int _type = EXTRA12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:184:9: ( '\\'' )
			// myparser.g:184:11: '\\''
			{
			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTRA12"

	// $ANTLR start "EXTRA13"
	public final void mEXTRA13() throws RecognitionException {
		try {
			int _type = EXTRA13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myparser.g:185:9: ( '\"' )
			// myparser.g:185:11: '\"'
			{
			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTRA13"

	@Override
	public void mTokens() throws RecognitionException {
		// myparser.g:1:8: ( INT_TYPE | MAIN | CHAR_TYPE | VOID_TYPE | FLOAT_TYPE | DOUBLE_TYPE | LONG_TYPE | STATIC | ELSE | ENUM | GOTO | CONTINUE | BREAK | DO | FOR | DEFAULT | SIZEOF | STRUCT | TYPEDEF | SIGNED | UNSIGNED | SWITCH | PRINTF | RETURN | EOF_ | NEWLINE_ | TAB_ | IF_ | WHILE | TOTALEO | CALCULATE | COMMENT1 | COMMENT2 | Identifier | Integer_constant | Floating_point_constant | WS | EXTRA1 | S_L | S_R | M_L | M_R | B_L | B_R | EXTRA8 | EXTRA9 | EXTRA10 | EXTRA11 | EXTRA12 | EXTRA13 )
		int alt10=50;
		alt10 = dfa10.predict(input);
		switch (alt10) {
			case 1 :
				// myparser.g:1:10: INT_TYPE
				{
				mINT_TYPE(); 

				}
				break;
			case 2 :
				// myparser.g:1:19: MAIN
				{
				mMAIN(); 

				}
				break;
			case 3 :
				// myparser.g:1:24: CHAR_TYPE
				{
				mCHAR_TYPE(); 

				}
				break;
			case 4 :
				// myparser.g:1:34: VOID_TYPE
				{
				mVOID_TYPE(); 

				}
				break;
			case 5 :
				// myparser.g:1:44: FLOAT_TYPE
				{
				mFLOAT_TYPE(); 

				}
				break;
			case 6 :
				// myparser.g:1:55: DOUBLE_TYPE
				{
				mDOUBLE_TYPE(); 

				}
				break;
			case 7 :
				// myparser.g:1:67: LONG_TYPE
				{
				mLONG_TYPE(); 

				}
				break;
			case 8 :
				// myparser.g:1:77: STATIC
				{
				mSTATIC(); 

				}
				break;
			case 9 :
				// myparser.g:1:84: ELSE
				{
				mELSE(); 

				}
				break;
			case 10 :
				// myparser.g:1:89: ENUM
				{
				mENUM(); 

				}
				break;
			case 11 :
				// myparser.g:1:94: GOTO
				{
				mGOTO(); 

				}
				break;
			case 12 :
				// myparser.g:1:99: CONTINUE
				{
				mCONTINUE(); 

				}
				break;
			case 13 :
				// myparser.g:1:108: BREAK
				{
				mBREAK(); 

				}
				break;
			case 14 :
				// myparser.g:1:114: DO
				{
				mDO(); 

				}
				break;
			case 15 :
				// myparser.g:1:117: FOR
				{
				mFOR(); 

				}
				break;
			case 16 :
				// myparser.g:1:121: DEFAULT
				{
				mDEFAULT(); 

				}
				break;
			case 17 :
				// myparser.g:1:129: SIZEOF
				{
				mSIZEOF(); 

				}
				break;
			case 18 :
				// myparser.g:1:136: STRUCT
				{
				mSTRUCT(); 

				}
				break;
			case 19 :
				// myparser.g:1:143: TYPEDEF
				{
				mTYPEDEF(); 

				}
				break;
			case 20 :
				// myparser.g:1:151: SIGNED
				{
				mSIGNED(); 

				}
				break;
			case 21 :
				// myparser.g:1:158: UNSIGNED
				{
				mUNSIGNED(); 

				}
				break;
			case 22 :
				// myparser.g:1:167: SWITCH
				{
				mSWITCH(); 

				}
				break;
			case 23 :
				// myparser.g:1:174: PRINTF
				{
				mPRINTF(); 

				}
				break;
			case 24 :
				// myparser.g:1:181: RETURN
				{
				mRETURN(); 

				}
				break;
			case 25 :
				// myparser.g:1:188: EOF_
				{
				mEOF_(); 

				}
				break;
			case 26 :
				// myparser.g:1:193: NEWLINE_
				{
				mNEWLINE_(); 

				}
				break;
			case 27 :
				// myparser.g:1:202: TAB_
				{
				mTAB_(); 

				}
				break;
			case 28 :
				// myparser.g:1:207: IF_
				{
				mIF_(); 

				}
				break;
			case 29 :
				// myparser.g:1:211: WHILE
				{
				mWHILE(); 

				}
				break;
			case 30 :
				// myparser.g:1:217: TOTALEO
				{
				mTOTALEO(); 

				}
				break;
			case 31 :
				// myparser.g:1:225: CALCULATE
				{
				mCALCULATE(); 

				}
				break;
			case 32 :
				// myparser.g:1:235: COMMENT1
				{
				mCOMMENT1(); 

				}
				break;
			case 33 :
				// myparser.g:1:244: COMMENT2
				{
				mCOMMENT2(); 

				}
				break;
			case 34 :
				// myparser.g:1:253: Identifier
				{
				mIdentifier(); 

				}
				break;
			case 35 :
				// myparser.g:1:264: Integer_constant
				{
				mInteger_constant(); 

				}
				break;
			case 36 :
				// myparser.g:1:281: Floating_point_constant
				{
				mFloating_point_constant(); 

				}
				break;
			case 37 :
				// myparser.g:1:305: WS
				{
				mWS(); 

				}
				break;
			case 38 :
				// myparser.g:1:308: EXTRA1
				{
				mEXTRA1(); 

				}
				break;
			case 39 :
				// myparser.g:1:315: S_L
				{
				mS_L(); 

				}
				break;
			case 40 :
				// myparser.g:1:319: S_R
				{
				mS_R(); 

				}
				break;
			case 41 :
				// myparser.g:1:323: M_L
				{
				mM_L(); 

				}
				break;
			case 42 :
				// myparser.g:1:327: M_R
				{
				mM_R(); 

				}
				break;
			case 43 :
				// myparser.g:1:331: B_L
				{
				mB_L(); 

				}
				break;
			case 44 :
				// myparser.g:1:335: B_R
				{
				mB_R(); 

				}
				break;
			case 45 :
				// myparser.g:1:339: EXTRA8
				{
				mEXTRA8(); 

				}
				break;
			case 46 :
				// myparser.g:1:346: EXTRA9
				{
				mEXTRA9(); 

				}
				break;
			case 47 :
				// myparser.g:1:353: EXTRA10
				{
				mEXTRA10(); 

				}
				break;
			case 48 :
				// myparser.g:1:361: EXTRA11
				{
				mEXTRA11(); 

				}
				break;
			case 49 :
				// myparser.g:1:369: EXTRA12
				{
				mEXTRA12(); 

				}
				break;
			case 50 :
				// myparser.g:1:377: EXTRA13
				{
				mEXTRA13(); 

				}
				break;

		}
	}


	protected DFA1 dfa1 = new DFA1(this);
	protected DFA10 dfa10 = new DFA10(this);
	static final String DFA1_eotS =
		"\1\1\2\uffff\1\15\1\17\1\21\6\uffff\1\23\1\uffff\1\25\1\uffff\1\27\1\uffff"+
		"\1\15\1\uffff\1\17\1\uffff\1\21\1\uffff\1\23\1\25\1\27";
	static final String DFA1_eofS =
		"\33\uffff";
	static final String DFA1_minS =
		"\1\41\2\uffff\3\75\6\uffff\1\75\1\uffff\1\75\1\uffff\1\75\1\uffff\1\75"+
		"\1\uffff\1\75\1\uffff\1\75\1\uffff\3\75";
	static final String DFA1_maxS =
		"\1\176\2\uffff\3\75\6\uffff\1\75\1\uffff\1\75\1\uffff\1\75\1\uffff\1\75"+
		"\1\uffff\1\75\1\uffff\1\75\1\uffff\3\75";
	static final String DFA1_acceptS =
		"\1\uffff\1\16\1\1\3\uffff\1\7\1\10\1\11\1\12\1\14\1\15\1\uffff\1\4\1\uffff"+
		"\1\5\1\uffff\1\13\1\uffff\1\2\1\uffff\1\3\1\uffff\1\6\3\uffff";
	static final String DFA1_specialS =
		"\33\uffff}>";
	static final String[] DFA1_transitionS = {
			"\1\5\4\uffff\1\10\4\uffff\1\6\1\uffff\1\7\16\uffff\1\3\1\2\1\4\37\uffff"+
			"\1\12\35\uffff\1\11\1\uffff\1\13",
			"",
			"",
			"\1\14",
			"\1\16",
			"\1\20",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\22",
			"",
			"\1\24",
			"",
			"\1\26",
			"",
			"\1\30",
			"",
			"\1\31",
			"",
			"\1\32",
			"",
			"\1\22",
			"\1\24",
			"\1\26"
	};

	static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
	static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
	static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
	static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
	static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
	static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
	static final short[][] DFA1_transition;

	static {
		int numStates = DFA1_transitionS.length;
		DFA1_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
		}
	}

	protected class DFA1 extends DFA {

		public DFA1(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 1;
			this.eot = DFA1_eot;
			this.eof = DFA1_eof;
			this.min = DFA1_min;
			this.max = DFA1_max;
			this.accept = DFA1_accept;
			this.special = DFA1_special;
			this.transition = DFA1_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 127:11: ( EQ_OP | LE_OP | GE_OP | LE2_OP | GE2_OP | NE_OP | PP_OP | MM_OP | EO1 | EO2 | EO5 | EO6 | EO7 )*";
		}
	}

	static final String DFA10_eotS =
		"\1\23\17\30\1\77\1\30\1\101\1\uffff\3\27\2\uffff\1\106\14\uffff\1\30\1"+
		"\111\6\30\1\121\15\30\4\uffff\1\30\1\uffff\2\23\2\27\2\uffff\1\147\1\uffff"+
		"\5\30\1\155\1\30\1\uffff\20\30\1\uffff\3\27\2\uffff\1\u0080\1\u0081\1"+
		"\30\1\u0083\1\30\1\uffff\2\30\1\u0087\5\30\1\u008d\1\u008e\1\u008f\6\30"+
		"\1\27\2\uffff\1\30\1\uffff\1\u0097\2\30\1\uffff\5\30\3\uffff\1\u009f\4"+
		"\30\1\u00a4\1\30\1\uffff\1\u00a6\1\30\1\u00a8\1\u00a9\1\u00aa\1\u00ab"+
		"\1\u00ac\1\uffff\2\30\1\u00af\1\u00b0\1\uffff\1\30\1\uffff\1\u00b2\5\uffff"+
		"\1\u00b3\1\30\2\uffff\1\u00b5\2\uffff\1\u00b6\2\uffff";
	static final String DFA10_eofS =
		"\u00b7\uffff";
	static final String DFA10_minS =
		"\1\11\1\146\1\141\1\150\1\157\1\154\1\145\1\157\1\151\1\154\1\157\1\162"+
		"\1\171\1\156\1\162\1\145\1\60\1\150\1\75\1\uffff\1\53\1\55\1\52\2\uffff"+
		"\1\56\14\uffff\1\164\1\60\1\151\1\141\1\156\1\151\1\157\1\162\1\60\1\146"+
		"\1\156\1\141\1\147\1\151\1\163\1\165\1\164\1\145\1\160\1\163\1\151\1\164"+
		"\4\uffff\1\151\1\uffff\2\52\2\0\2\uffff\1\60\1\uffff\1\156\1\162\1\164"+
		"\1\144\1\141\1\60\1\142\1\uffff\1\141\1\147\1\164\1\165\1\145\1\156\1"+
		"\164\1\145\1\155\1\157\1\141\1\145\1\151\1\156\1\165\1\154\1\uffff\3\0"+
		"\2\uffff\2\60\1\151\1\60\1\164\1\uffff\1\154\1\165\1\60\1\151\1\143\1"+
		"\157\1\145\1\143\3\60\1\153\1\144\1\147\1\164\1\162\1\145\1\0\2\uffff"+
		"\1\156\1\uffff\1\60\1\145\1\154\1\uffff\1\143\1\164\1\146\1\144\1\150"+
		"\3\uffff\1\60\1\145\1\156\1\146\1\156\1\60\1\165\1\uffff\1\60\1\164\5"+
		"\60\1\uffff\1\146\1\145\2\60\1\uffff\1\145\1\uffff\1\60\5\uffff\1\60\1"+
		"\144\2\uffff\1\60\2\uffff\1\60\2\uffff";
	static final String DFA10_maxS =
		"\1\175\1\156\1\141\5\157\1\167\1\156\1\157\1\162\1\171\1\156\1\162\1\145"+
		"\1\164\1\150\1\75\1\uffff\1\53\1\55\1\57\2\uffff\1\71\14\uffff\1\164\1"+
		"\172\1\151\1\141\1\156\1\151\1\157\1\162\1\172\1\146\1\156\1\162\1\172"+
		"\1\151\1\163\1\165\1\164\1\145\1\160\1\163\1\151\1\164\4\uffff\1\151\1"+
		"\uffff\2\57\2\uffff\2\uffff\1\172\1\uffff\1\156\1\162\1\164\1\144\1\141"+
		"\1\172\1\142\1\uffff\1\141\1\147\1\164\1\165\1\145\1\156\1\164\1\145\1"+
		"\155\1\157\1\141\1\145\1\151\1\156\1\165\1\154\1\uffff\3\uffff\2\uffff"+
		"\2\172\1\151\1\172\1\164\1\uffff\1\154\1\165\1\172\1\151\1\143\1\157\1"+
		"\145\1\143\3\172\1\153\1\144\1\147\1\164\1\162\1\145\1\uffff\2\uffff\1"+
		"\156\1\uffff\1\172\1\145\1\154\1\uffff\1\143\1\164\1\146\1\144\1\150\3"+
		"\uffff\1\172\1\145\1\156\1\146\1\156\1\172\1\165\1\uffff\1\172\1\164\5"+
		"\172\1\uffff\1\146\1\145\2\172\1\uffff\1\145\1\uffff\1\172\5\uffff\1\172"+
		"\1\144\2\uffff\1\172\2\uffff\1\172\2\uffff";
	static final String DFA10_acceptS =
		"\23\uffff\1\36\3\uffff\1\37\1\42\1\uffff\1\45\1\46\1\47\1\50\1\51\1\52"+
		"\1\53\1\54\1\56\1\57\1\61\1\62\26\uffff\1\31\1\32\1\33\1\60\1\uffff\1"+
		"\55\4\uffff\1\43\1\44\1\uffff\1\34\7\uffff\1\16\20\uffff\1\40\3\uffff"+
		"\1\41\1\1\5\uffff\1\17\22\uffff\1\2\1\3\1\uffff\1\4\3\uffff\1\7\5\uffff"+
		"\1\11\1\12\1\13\7\uffff\1\5\7\uffff\1\15\4\uffff\1\35\1\uffff\1\6\1\uffff"+
		"\1\10\1\22\1\21\1\24\1\26\2\uffff\1\27\1\30\1\uffff\1\20\1\23\1\uffff"+
		"\1\14\1\25";
	static final String DFA10_specialS =
		"\104\uffff\1\0\1\1\35\uffff\1\4\1\2\1\3\31\uffff\1\5\67\uffff}>";
	static final String[] DFA10_transitionS = {
			"\2\32\2\uffff\1\32\22\uffff\1\32\1\uffff\1\45\1\33\3\uffff\1\44\1\34"+
			"\1\35\1\27\1\24\1\42\1\25\1\uffff\1\26\12\31\1\uffff\1\43\1\uffff\1\22"+
			"\3\uffff\32\30\1\36\1\20\1\37\1\uffff\1\30\1\uffff\1\30\1\13\1\3\1\6"+
			"\1\11\1\5\1\12\1\30\1\1\2\30\1\7\1\2\2\30\1\16\1\30\1\17\1\10\1\14\1"+
			"\15\1\4\1\21\3\30\1\40\1\uffff\1\41",
			"\1\47\7\uffff\1\46",
			"\1\50",
			"\1\51\6\uffff\1\52",
			"\1\53",
			"\1\54\2\uffff\1\55",
			"\1\57\11\uffff\1\56",
			"\1\60",
			"\1\62\12\uffff\1\61\2\uffff\1\63",
			"\1\64\1\uffff\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74\75\uffff\1\75\5\uffff\1\76",
			"\1\100",
			"\1\23",
			"",
			"\1\102",
			"\1\103",
			"\1\105\4\uffff\1\104",
			"",
			"",
			"\1\107\1\uffff\12\31",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\110",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\24\30\1\120\5\30",
			"\1\122",
			"\1\123",
			"\1\124\20\uffff\1\125",
			"\1\127\22\uffff\1\126",
			"\1\130",
			"\1\131",
			"\1\132",
			"\1\133",
			"\1\134",
			"\1\135",
			"\1\136",
			"\1\137",
			"\1\140",
			"",
			"",
			"",
			"",
			"\1\141",
			"",
			"\1\27\1\24\1\uffff\1\25\1\uffff\1\27",
			"\1\27\1\24\1\uffff\1\25\1\uffff\1\27",
			"\52\142\2\143\1\142\1\143\1\142\1\143\uffd0\142",
			"\52\146\1\144\1\145\1\146\1\145\1\146\1\145\uffd0\146",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"\1\150",
			"\1\151",
			"\1\152",
			"\1\153",
			"\1\154",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\156",
			"",
			"\1\157",
			"\1\160",
			"\1\161",
			"\1\162",
			"\1\163",
			"\1\164",
			"\1\165",
			"\1\166",
			"\1\167",
			"\1\170",
			"\1\171",
			"\1\172",
			"\1\173",
			"\1\174",
			"\1\175",
			"\1\176",
			"",
			"\52\142\2\143\1\142\1\143\1\142\1\143\uffd0\142",
			"\52\146\1\144\1\145\1\146\1\145\1\146\1\177\uffd0\146",
			"\52\146\1\144\1\145\1\146\1\145\1\146\1\145\uffd0\146",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u0082",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u0084",
			"",
			"\1\u0085",
			"\1\u0086",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u0088",
			"\1\u0089",
			"\1\u008a",
			"\1\u008b",
			"\1\u008c",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u0090",
			"\1\u0091",
			"\1\u0092",
			"\1\u0093",
			"\1\u0094",
			"\1\u0095",
			"\52\146\1\144\1\145\1\146\1\145\1\146\1\145\uffd0\146",
			"",
			"",
			"\1\u0096",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u0098",
			"\1\u0099",
			"",
			"\1\u009a",
			"\1\u009b",
			"\1\u009c",
			"\1\u009d",
			"\1\u009e",
			"",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u00a0",
			"\1\u00a1",
			"\1\u00a2",
			"\1\u00a3",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u00a5",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u00a7",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"\1\u00ad",
			"\1\u00ae",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"\1\u00b1",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"",
			"",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u00b4",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			""
	};

	static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
	static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
	static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
	static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
	static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
	static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
	static final short[][] DFA10_transition;

	static {
		int numStates = DFA10_transitionS.length;
		DFA10_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
		}
	}

	protected class DFA10 extends DFA {

		public DFA10(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 10;
			this.eot = DFA10_eot;
			this.eof = DFA10_eof;
			this.min = DFA10_min;
			this.max = DFA10_max;
			this.accept = DFA10_accept;
			this.special = DFA10_special;
			this.transition = DFA10_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( INT_TYPE | MAIN | CHAR_TYPE | VOID_TYPE | FLOAT_TYPE | DOUBLE_TYPE | LONG_TYPE | STATIC | ELSE | ENUM | GOTO | CONTINUE | BREAK | DO | FOR | DEFAULT | SIZEOF | STRUCT | TYPEDEF | SIGNED | UNSIGNED | SWITCH | PRINTF | RETURN | EOF_ | NEWLINE_ | TAB_ | IF_ | WHILE | TOTALEO | CALCULATE | COMMENT1 | COMMENT2 | Identifier | Integer_constant | Floating_point_constant | WS | EXTRA1 | S_L | S_R | M_L | M_R | B_L | B_R | EXTRA8 | EXTRA9 | EXTRA10 | EXTRA11 | EXTRA12 | EXTRA13 );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA10_68 = input.LA(1);
						s = -1;
						if ( ((LA10_68 >= '\u0000' && LA10_68 <= ')')||LA10_68==','||LA10_68=='.'||(LA10_68 >= '0' && LA10_68 <= '\uFFFF')) ) {s = 98;}
						else if ( ((LA10_68 >= '*' && LA10_68 <= '+')||LA10_68=='-'||LA10_68=='/') ) {s = 99;}
						else s = 23;
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA10_69 = input.LA(1);
						s = -1;
						if ( (LA10_69=='*') ) {s = 100;}
						else if ( (LA10_69=='+'||LA10_69=='-'||LA10_69=='/') ) {s = 101;}
						else if ( ((LA10_69 >= '\u0000' && LA10_69 <= ')')||LA10_69==','||LA10_69=='.'||(LA10_69 >= '0' && LA10_69 <= '\uFFFF')) ) {s = 102;}
						else s = 23;
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA10_100 = input.LA(1);
						s = -1;
						if ( (LA10_100=='/') ) {s = 127;}
						else if ( (LA10_100=='*') ) {s = 100;}
						else if ( (LA10_100=='+'||LA10_100=='-') ) {s = 101;}
						else if ( ((LA10_100 >= '\u0000' && LA10_100 <= ')')||LA10_100==','||LA10_100=='.'||(LA10_100 >= '0' && LA10_100 <= '\uFFFF')) ) {s = 102;}
						else s = 23;
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA10_101 = input.LA(1);
						s = -1;
						if ( (LA10_101=='*') ) {s = 100;}
						else if ( (LA10_101=='+'||LA10_101=='-'||LA10_101=='/') ) {s = 101;}
						else if ( ((LA10_101 >= '\u0000' && LA10_101 <= ')')||LA10_101==','||LA10_101=='.'||(LA10_101 >= '0' && LA10_101 <= '\uFFFF')) ) {s = 102;}
						else s = 23;
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA10_99 = input.LA(1);
						s = -1;
						if ( ((LA10_99 >= '\u0000' && LA10_99 <= ')')||LA10_99==','||LA10_99=='.'||(LA10_99 >= '0' && LA10_99 <= '\uFFFF')) ) {s = 98;}
						else if ( ((LA10_99 >= '*' && LA10_99 <= '+')||LA10_99=='-'||LA10_99=='/') ) {s = 99;}
						else s = 23;
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA10_127 = input.LA(1);
						s = -1;
						if ( (LA10_127=='*') ) {s = 100;}
						else if ( (LA10_127=='+'||LA10_127=='-'||LA10_127=='/') ) {s = 101;}
						else if ( ((LA10_127 >= '\u0000' && LA10_127 <= ')')||LA10_127==','||LA10_127=='.'||(LA10_127 >= '0' && LA10_127 <= '\uFFFF')) ) {s = 102;}
						else s = 23;
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 10, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
