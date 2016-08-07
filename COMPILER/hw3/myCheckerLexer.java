// $ANTLR 3.5.1 myChecker.g 2014-05-23 19:52:47

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myCheckerLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public myCheckerLexer() {} 
	public myCheckerLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public myCheckerLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "myChecker.g"; }

	// $ANTLR start "T__67"
	public final void mT__67() throws RecognitionException {
		try {
			int _type = T__67;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:7:7: ( '*' )
			// myChecker.g:7:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__67"

	// $ANTLR start "T__68"
	public final void mT__68() throws RecognitionException {
		try {
			int _type = T__68;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:8:7: ( '+' )
			// myChecker.g:8:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__68"

	// $ANTLR start "T__69"
	public final void mT__69() throws RecognitionException {
		try {
			int _type = T__69;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:9:7: ( '-' )
			// myChecker.g:9:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__69"

	// $ANTLR start "T__70"
	public final void mT__70() throws RecognitionException {
		try {
			int _type = T__70;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:10:7: ( '/' )
			// myChecker.g:10:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__70"

	// $ANTLR start "INT_TYPE"
	public final void mINT_TYPE() throws RecognitionException {
		try {
			int _type = INT_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:162:11: ( 'int' )
			// myChecker.g:162:13: 'int'
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
			// myChecker.g:163:6: ( 'main' )
			// myChecker.g:163:8: 'main'
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
			// myChecker.g:164:11: ( 'char' )
			// myChecker.g:164:13: 'char'
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
			// myChecker.g:165:11: ( 'void' )
			// myChecker.g:165:13: 'void'
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
			// myChecker.g:166:11: ( 'float' )
			// myChecker.g:166:13: 'float'
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
			// myChecker.g:167:12: ( 'double' )
			// myChecker.g:167:14: 'double'
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
			// myChecker.g:168:11: ( 'long' )
			// myChecker.g:168:13: 'long'
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
			// myChecker.g:170:11: ( 'static' )
			// myChecker.g:170:13: 'static'
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
			// myChecker.g:171:11: ( 'else' )
			// myChecker.g:171:13: 'else'
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
			// myChecker.g:172:11: ( 'enum' )
			// myChecker.g:172:13: 'enum'
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
			// myChecker.g:173:11: ( 'goto' )
			// myChecker.g:173:13: 'goto'
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
			// myChecker.g:174:11: ( 'continue' )
			// myChecker.g:174:13: 'continue'
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
			// myChecker.g:175:11: ( 'break' )
			// myChecker.g:175:13: 'break'
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
			// myChecker.g:176:11: ( 'do' )
			// myChecker.g:176:13: 'do'
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
			// myChecker.g:177:11: ( 'for' )
			// myChecker.g:177:13: 'for'
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
			// myChecker.g:178:11: ( 'default' )
			// myChecker.g:178:13: 'default'
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
			// myChecker.g:179:11: ( 'sizeof' )
			// myChecker.g:179:13: 'sizeof'
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
			// myChecker.g:180:11: ( 'struct' )
			// myChecker.g:180:13: 'struct'
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
			// myChecker.g:181:11: ( 'typedef' )
			// myChecker.g:181:13: 'typedef'
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
			// myChecker.g:182:11: ( 'signed' )
			// myChecker.g:182:13: 'signed'
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
			// myChecker.g:183:11: ( 'unsigned' )
			// myChecker.g:183:13: 'unsigned'
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
			// myChecker.g:184:11: ( 'switch' )
			// myChecker.g:184:13: 'switch'
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
			// myChecker.g:185:11: ( 'printf' )
			// myChecker.g:185:13: 'printf'
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
			// myChecker.g:186:11: ( 'return' )
			// myChecker.g:186:13: 'return'
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
			// myChecker.g:187:12: ( '\\\\0' )
			// myChecker.g:187:14: '\\\\0'
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
			// myChecker.g:188:12: ( '\\\\n' )
			// myChecker.g:188:14: '\\\\n'
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
			// myChecker.g:189:12: ( '\\\\t' )
			// myChecker.g:189:14: '\\\\t'
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
			// myChecker.g:192:6: ( 'if' )
			// myChecker.g:192:8: 'if'
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
			// myChecker.g:193:10: ( 'while' )
			// myChecker.g:193:12: 'while'
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
			// myChecker.g:197:9: ( ( EQ_OP | LE_OP | GE_OP | LE2_OP | GE2_OP | NE_OP | PP_OP | MM_OP | EO1 | EO2 | EO5 | EO6 | EO7 )* )
			// myChecker.g:197:11: ( EQ_OP | LE_OP | GE_OP | LE2_OP | GE2_OP | NE_OP | PP_OP | MM_OP | EO1 | EO2 | EO5 | EO6 | EO7 )*
			{
			// myChecker.g:197:11: ( EQ_OP | LE_OP | GE_OP | LE2_OP | GE2_OP | NE_OP | PP_OP | MM_OP | EO1 | EO2 | EO5 | EO6 | EO7 )*
			loop1:
			while (true) {
				int alt1=14;
				alt1 = dfa1.predict(input);
				switch (alt1) {
				case 1 :
					// myChecker.g:197:12: EQ_OP
					{
					mEQ_OP(); 

					}
					break;
				case 2 :
					// myChecker.g:197:18: LE_OP
					{
					mLE_OP(); 

					}
					break;
				case 3 :
					// myChecker.g:197:24: GE_OP
					{
					mGE_OP(); 

					}
					break;
				case 4 :
					// myChecker.g:197:30: LE2_OP
					{
					mLE2_OP(); 

					}
					break;
				case 5 :
					// myChecker.g:197:37: GE2_OP
					{
					mGE2_OP(); 

					}
					break;
				case 6 :
					// myChecker.g:197:44: NE_OP
					{
					mNE_OP(); 

					}
					break;
				case 7 :
					// myChecker.g:197:50: PP_OP
					{
					mPP_OP(); 

					}
					break;
				case 8 :
					// myChecker.g:197:56: MM_OP
					{
					mMM_OP(); 

					}
					break;
				case 9 :
					// myChecker.g:197:62: EO1
					{
					mEO1(); 

					}
					break;
				case 10 :
					// myChecker.g:197:66: EO2
					{
					mEO2(); 

					}
					break;
				case 11 :
					// myChecker.g:197:70: EO5
					{
					mEO5(); 

					}
					break;
				case 12 :
					// myChecker.g:197:74: EO6
					{
					mEO6(); 

					}
					break;
				case 13 :
					// myChecker.g:197:78: EO7
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
			// myChecker.g:198:16: ( '==' )
			// myChecker.g:198:18: '=='
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
			// myChecker.g:199:16: ( '<=' )
			// myChecker.g:199:18: '<='
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
			// myChecker.g:200:16: ( '<' )
			// myChecker.g:200:18: '<'
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
			// myChecker.g:201:16: ( '>=' )
			// myChecker.g:201:18: '>='
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
			// myChecker.g:202:16: ( '>' )
			// myChecker.g:202:18: '>'
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
			// myChecker.g:203:16: ( '!=' )
			// myChecker.g:203:18: '!='
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
			// myChecker.g:204:16: ( '++' )
			// myChecker.g:204:18: '++'
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
			// myChecker.g:205:16: ( '--' )
			// myChecker.g:205:18: '--'
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
			// myChecker.g:206:16: ( '&&' )
			// myChecker.g:206:18: '&&'
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
			// myChecker.g:207:16: ( '||' )
			// myChecker.g:207:18: '||'
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
			// myChecker.g:208:16: ( '!' )
			// myChecker.g:208:18: '!'
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
			// myChecker.g:209:16: ( '^' )
			// myChecker.g:209:18: '^'
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
			// myChecker.g:210:16: ( '~' )
			// myChecker.g:210:18: '~'
			{
			match('~'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO7"

	// $ANTLR start "COMMENT1"
	public final void mCOMMENT1() throws RecognitionException {
		try {
			int _type = COMMENT1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:230:10: ( '//' ( . )* '\\n' )
			// myChecker.g:230:12: '//' ( . )* '\\n'
			{
			match("//"); 

			// myChecker.g:230:16: ( . )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='\n') ) {
					alt2=2;
				}
				else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// myChecker.g:230:17: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop2;
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
			// myChecker.g:231:10: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// myChecker.g:231:12: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// myChecker.g:231:17: ( options {greedy=false; } : . )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='*') ) {
					int LA3_1 = input.LA(2);
					if ( (LA3_1=='/') ) {
						alt3=2;
					}
					else if ( ((LA3_1 >= '\u0000' && LA3_1 <= '.')||(LA3_1 >= '0' && LA3_1 <= '\uFFFF')) ) {
						alt3=1;
					}

				}
				else if ( ((LA3_0 >= '\u0000' && LA3_0 <= ')')||(LA3_0 >= '+' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// myChecker.g:231:42: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop3;
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
			// myChecker.g:233:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// myChecker.g:233:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// myChecker.g:233:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// myChecker.g:
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
					break loop4;
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
			// myChecker.g:235:17: ( ( '0' .. '9' )+ )
			// myChecker.g:235:18: ( '0' .. '9' )+
			{
			// myChecker.g:235:18: ( '0' .. '9' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// myChecker.g:
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
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
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
			// myChecker.g:236:24: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
			// myChecker.g:236:25: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
			{
			// myChecker.g:236:25: ( '0' .. '9' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// myChecker.g:
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
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			match('.'); 
			// myChecker.g:236:39: ( '0' .. '9' )+
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
					// myChecker.g:
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
			// myChecker.g:237:3: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// myChecker.g:237:4: ( ' ' | '\\t' | '\\r' | '\\n' )
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
			// myChecker.g:241:17: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
			// myChecker.g:241:19: ( 'a' .. 'z' | 'A' .. 'Z' )+
			{
			// myChecker.g:241:19: ( 'a' .. 'z' | 'A' .. 'Z' )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= 'A' && LA8_0 <= 'Z')||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// myChecker.g:
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
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
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
			// myChecker.g:243:8: ( '#' )
			// myChecker.g:243:10: '#'
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
			// myChecker.g:244:5: ( '(' )
			// myChecker.g:244:7: '('
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
			// myChecker.g:245:5: ( ')' )
			// myChecker.g:245:7: ')'
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
			// myChecker.g:246:5: ( '[' )
			// myChecker.g:246:7: '['
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
			// myChecker.g:247:5: ( ']' )
			// myChecker.g:247:7: ']'
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
			// myChecker.g:248:5: ( '{' )
			// myChecker.g:248:7: '{'
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
			// myChecker.g:249:5: ( '}' )
			// myChecker.g:249:7: '}'
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
			// myChecker.g:250:8: ( '=' )
			// myChecker.g:250:10: '='
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
			// myChecker.g:251:8: ( ',' )
			// myChecker.g:251:10: ','
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
			// myChecker.g:252:9: ( ';' )
			// myChecker.g:252:11: ';'
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
			// myChecker.g:253:9: ( '\\\\' )
			// myChecker.g:253:11: '\\\\'
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
			// myChecker.g:254:9: ( '\\'' )
			// myChecker.g:254:11: '\\''
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
			// myChecker.g:255:9: ( '\"' )
			// myChecker.g:255:11: '\"'
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
		// myChecker.g:1:8: ( T__67 | T__68 | T__69 | T__70 | INT_TYPE | MAIN | CHAR_TYPE | VOID_TYPE | FLOAT_TYPE | DOUBLE_TYPE | LONG_TYPE | STATIC | ELSE | ENUM | GOTO | CONTINUE | BREAK | DO | FOR | DEFAULT | SIZEOF | STRUCT | TYPEDEF | SIGNED | UNSIGNED | SWITCH | PRINTF | RETURN | EOF_ | NEWLINE_ | TAB_ | IF_ | WHILE | TOTALEO | COMMENT1 | COMMENT2 | Identifier | Integer_constant | Floating_point_constant | WS | EXTRA1 | S_L | S_R | M_L | M_R | B_L | B_R | EXTRA8 | EXTRA9 | EXTRA10 | EXTRA11 | EXTRA12 | EXTRA13 )
		int alt9=53;
		alt9 = dfa9.predict(input);
		switch (alt9) {
			case 1 :
				// myChecker.g:1:10: T__67
				{
				mT__67(); 

				}
				break;
			case 2 :
				// myChecker.g:1:16: T__68
				{
				mT__68(); 

				}
				break;
			case 3 :
				// myChecker.g:1:22: T__69
				{
				mT__69(); 

				}
				break;
			case 4 :
				// myChecker.g:1:28: T__70
				{
				mT__70(); 

				}
				break;
			case 5 :
				// myChecker.g:1:34: INT_TYPE
				{
				mINT_TYPE(); 

				}
				break;
			case 6 :
				// myChecker.g:1:43: MAIN
				{
				mMAIN(); 

				}
				break;
			case 7 :
				// myChecker.g:1:48: CHAR_TYPE
				{
				mCHAR_TYPE(); 

				}
				break;
			case 8 :
				// myChecker.g:1:58: VOID_TYPE
				{
				mVOID_TYPE(); 

				}
				break;
			case 9 :
				// myChecker.g:1:68: FLOAT_TYPE
				{
				mFLOAT_TYPE(); 

				}
				break;
			case 10 :
				// myChecker.g:1:79: DOUBLE_TYPE
				{
				mDOUBLE_TYPE(); 

				}
				break;
			case 11 :
				// myChecker.g:1:91: LONG_TYPE
				{
				mLONG_TYPE(); 

				}
				break;
			case 12 :
				// myChecker.g:1:101: STATIC
				{
				mSTATIC(); 

				}
				break;
			case 13 :
				// myChecker.g:1:108: ELSE
				{
				mELSE(); 

				}
				break;
			case 14 :
				// myChecker.g:1:113: ENUM
				{
				mENUM(); 

				}
				break;
			case 15 :
				// myChecker.g:1:118: GOTO
				{
				mGOTO(); 

				}
				break;
			case 16 :
				// myChecker.g:1:123: CONTINUE
				{
				mCONTINUE(); 

				}
				break;
			case 17 :
				// myChecker.g:1:132: BREAK
				{
				mBREAK(); 

				}
				break;
			case 18 :
				// myChecker.g:1:138: DO
				{
				mDO(); 

				}
				break;
			case 19 :
				// myChecker.g:1:141: FOR
				{
				mFOR(); 

				}
				break;
			case 20 :
				// myChecker.g:1:145: DEFAULT
				{
				mDEFAULT(); 

				}
				break;
			case 21 :
				// myChecker.g:1:153: SIZEOF
				{
				mSIZEOF(); 

				}
				break;
			case 22 :
				// myChecker.g:1:160: STRUCT
				{
				mSTRUCT(); 

				}
				break;
			case 23 :
				// myChecker.g:1:167: TYPEDEF
				{
				mTYPEDEF(); 

				}
				break;
			case 24 :
				// myChecker.g:1:175: SIGNED
				{
				mSIGNED(); 

				}
				break;
			case 25 :
				// myChecker.g:1:182: UNSIGNED
				{
				mUNSIGNED(); 

				}
				break;
			case 26 :
				// myChecker.g:1:191: SWITCH
				{
				mSWITCH(); 

				}
				break;
			case 27 :
				// myChecker.g:1:198: PRINTF
				{
				mPRINTF(); 

				}
				break;
			case 28 :
				// myChecker.g:1:205: RETURN
				{
				mRETURN(); 

				}
				break;
			case 29 :
				// myChecker.g:1:212: EOF_
				{
				mEOF_(); 

				}
				break;
			case 30 :
				// myChecker.g:1:217: NEWLINE_
				{
				mNEWLINE_(); 

				}
				break;
			case 31 :
				// myChecker.g:1:226: TAB_
				{
				mTAB_(); 

				}
				break;
			case 32 :
				// myChecker.g:1:231: IF_
				{
				mIF_(); 

				}
				break;
			case 33 :
				// myChecker.g:1:235: WHILE
				{
				mWHILE(); 

				}
				break;
			case 34 :
				// myChecker.g:1:241: TOTALEO
				{
				mTOTALEO(); 

				}
				break;
			case 35 :
				// myChecker.g:1:249: COMMENT1
				{
				mCOMMENT1(); 

				}
				break;
			case 36 :
				// myChecker.g:1:258: COMMENT2
				{
				mCOMMENT2(); 

				}
				break;
			case 37 :
				// myChecker.g:1:267: Identifier
				{
				mIdentifier(); 

				}
				break;
			case 38 :
				// myChecker.g:1:278: Integer_constant
				{
				mInteger_constant(); 

				}
				break;
			case 39 :
				// myChecker.g:1:295: Floating_point_constant
				{
				mFloating_point_constant(); 

				}
				break;
			case 40 :
				// myChecker.g:1:319: WS
				{
				mWS(); 

				}
				break;
			case 41 :
				// myChecker.g:1:322: EXTRA1
				{
				mEXTRA1(); 

				}
				break;
			case 42 :
				// myChecker.g:1:329: S_L
				{
				mS_L(); 

				}
				break;
			case 43 :
				// myChecker.g:1:333: S_R
				{
				mS_R(); 

				}
				break;
			case 44 :
				// myChecker.g:1:337: M_L
				{
				mM_L(); 

				}
				break;
			case 45 :
				// myChecker.g:1:341: M_R
				{
				mM_R(); 

				}
				break;
			case 46 :
				// myChecker.g:1:345: B_L
				{
				mB_L(); 

				}
				break;
			case 47 :
				// myChecker.g:1:349: B_R
				{
				mB_R(); 

				}
				break;
			case 48 :
				// myChecker.g:1:353: EXTRA8
				{
				mEXTRA8(); 

				}
				break;
			case 49 :
				// myChecker.g:1:360: EXTRA9
				{
				mEXTRA9(); 

				}
				break;
			case 50 :
				// myChecker.g:1:367: EXTRA10
				{
				mEXTRA10(); 

				}
				break;
			case 51 :
				// myChecker.g:1:375: EXTRA11
				{
				mEXTRA11(); 

				}
				break;
			case 52 :
				// myChecker.g:1:383: EXTRA12
				{
				mEXTRA12(); 

				}
				break;
			case 53 :
				// myChecker.g:1:391: EXTRA13
				{
				mEXTRA13(); 

				}
				break;

		}
	}


	protected DFA1 dfa1 = new DFA1(this);
	protected DFA9 dfa9 = new DFA9(this);
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
			return "()* loopback of 197:11: ( EQ_OP | LE_OP | GE_OP | LE2_OP | GE2_OP | NE_OP | PP_OP | MM_OP | EO1 | EO2 | EO5 | EO6 | EO7 )*";
		}
	}

	static final String DFA9_eotS =
		"\1\27\1\uffff\1\46\1\47\1\52\17\30\1\104\1\30\1\106\2\uffff\1\107\21\uffff"+
		"\1\30\1\112\6\30\1\122\15\30\4\uffff\1\30\3\uffff\1\143\1\uffff\5\30\1"+
		"\151\1\30\1\uffff\20\30\1\uffff\1\173\1\174\1\30\1\176\1\30\1\uffff\2"+
		"\30\1\u0082\5\30\1\u0088\1\u0089\1\u008a\6\30\2\uffff\1\30\1\uffff\1\u0092"+
		"\2\30\1\uffff\5\30\3\uffff\1\u009a\4\30\1\u009f\1\30\1\uffff\1\u00a1\1"+
		"\30\1\u00a3\1\u00a4\1\u00a5\1\u00a6\1\u00a7\1\uffff\2\30\1\u00aa\1\u00ab"+
		"\1\uffff\1\30\1\uffff\1\u00ad\5\uffff\1\u00ae\1\30\2\uffff\1\u00b0\2\uffff"+
		"\1\u00b1\2\uffff";
	static final String DFA9_eofS =
		"\u00b2\uffff";
	static final String DFA9_minS =
		"\1\11\1\uffff\1\53\1\55\1\52\1\146\1\141\1\150\1\157\1\154\1\145\1\157"+
		"\1\151\1\154\1\157\1\162\1\171\1\156\1\162\1\145\1\60\1\150\1\75\2\uffff"+
		"\1\56\21\uffff\1\164\1\60\1\151\1\141\1\156\1\151\1\157\1\162\1\60\1\146"+
		"\1\156\1\141\1\147\1\151\1\163\1\165\1\164\1\145\1\160\1\163\1\151\1\164"+
		"\4\uffff\1\151\3\uffff\1\60\1\uffff\1\156\1\162\1\164\1\144\1\141\1\60"+
		"\1\142\1\uffff\1\141\1\147\1\164\1\165\1\145\1\156\1\164\1\145\1\155\1"+
		"\157\1\141\1\145\1\151\1\156\1\165\1\154\1\uffff\2\60\1\151\1\60\1\164"+
		"\1\uffff\1\154\1\165\1\60\1\151\1\143\1\157\1\145\1\143\3\60\1\153\1\144"+
		"\1\147\1\164\1\162\1\145\2\uffff\1\156\1\uffff\1\60\1\145\1\154\1\uffff"+
		"\1\143\1\164\1\146\1\144\1\150\3\uffff\1\60\1\145\1\156\1\146\1\156\1"+
		"\60\1\165\1\uffff\1\60\1\164\5\60\1\uffff\1\146\1\145\2\60\1\uffff\1\145"+
		"\1\uffff\1\60\5\uffff\1\60\1\144\2\uffff\1\60\2\uffff\1\60\2\uffff";
	static final String DFA9_maxS =
		"\1\175\1\uffff\1\53\1\55\1\57\1\156\1\141\5\157\1\167\1\156\1\157\1\162"+
		"\1\171\1\156\1\162\1\145\1\164\1\150\1\75\2\uffff\1\71\21\uffff\1\164"+
		"\1\172\1\151\1\141\1\156\1\151\1\157\1\162\1\172\1\146\1\156\1\162\1\172"+
		"\1\151\1\163\1\165\1\164\1\145\1\160\1\163\1\151\1\164\4\uffff\1\151\3"+
		"\uffff\1\172\1\uffff\1\156\1\162\1\164\1\144\1\141\1\172\1\142\1\uffff"+
		"\1\141\1\147\1\164\1\165\1\145\1\156\1\164\1\145\1\155\1\157\1\141\1\145"+
		"\1\151\1\156\1\165\1\154\1\uffff\2\172\1\151\1\172\1\164\1\uffff\1\154"+
		"\1\165\1\172\1\151\1\143\1\157\1\145\1\143\3\172\1\153\1\144\1\147\1\164"+
		"\1\162\1\145\2\uffff\1\156\1\uffff\1\172\1\145\1\154\1\uffff\1\143\1\164"+
		"\1\146\1\144\1\150\3\uffff\1\172\1\145\1\156\1\146\1\156\1\172\1\165\1"+
		"\uffff\1\172\1\164\5\172\1\uffff\1\146\1\145\2\172\1\uffff\1\145\1\uffff"+
		"\1\172\5\uffff\1\172\1\144\2\uffff\1\172\2\uffff\1\172\2\uffff";
	static final String DFA9_acceptS =
		"\1\uffff\1\1\25\uffff\1\42\1\45\1\uffff\1\50\1\51\1\52\1\53\1\54\1\55"+
		"\1\56\1\57\1\61\1\62\1\64\1\65\1\2\1\3\1\43\1\44\1\4\26\uffff\1\35\1\36"+
		"\1\37\1\63\1\uffff\1\60\1\46\1\47\1\uffff\1\40\7\uffff\1\22\20\uffff\1"+
		"\5\5\uffff\1\23\21\uffff\1\6\1\7\1\uffff\1\10\3\uffff\1\13\5\uffff\1\15"+
		"\1\16\1\17\7\uffff\1\11\7\uffff\1\21\4\uffff\1\41\1\uffff\1\12\1\uffff"+
		"\1\14\1\26\1\25\1\30\1\32\2\uffff\1\33\1\34\1\uffff\1\24\1\27\1\uffff"+
		"\1\20\1\31";
	static final String DFA9_specialS =
		"\u00b2\uffff}>";
	static final String[] DFA9_transitionS = {
			"\2\32\2\uffff\1\32\22\uffff\1\32\1\uffff\1\45\1\33\3\uffff\1\44\1\34"+
			"\1\35\1\1\1\2\1\42\1\3\1\uffff\1\4\12\31\1\uffff\1\43\1\uffff\1\26\3"+
			"\uffff\32\30\1\36\1\24\1\37\1\uffff\1\30\1\uffff\1\30\1\17\1\7\1\12\1"+
			"\15\1\11\1\16\1\30\1\5\2\30\1\13\1\6\2\30\1\22\1\30\1\23\1\14\1\20\1"+
			"\21\1\10\1\25\3\30\1\40\1\uffff\1\41",
			"",
			"\1\27",
			"\1\27",
			"\1\51\4\uffff\1\50",
			"\1\54\7\uffff\1\53",
			"\1\55",
			"\1\56\6\uffff\1\57",
			"\1\60",
			"\1\61\2\uffff\1\62",
			"\1\64\11\uffff\1\63",
			"\1\65",
			"\1\67\12\uffff\1\66\2\uffff\1\70",
			"\1\71\1\uffff\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101\75\uffff\1\102\5\uffff\1\103",
			"\1\105",
			"\1\27",
			"",
			"",
			"\1\110\1\uffff\12\31",
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
			"",
			"",
			"",
			"",
			"",
			"\1\111",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\1\120",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\24\30\1\121\5\30",
			"\1\123",
			"\1\124",
			"\1\125\20\uffff\1\126",
			"\1\130\22\uffff\1\127",
			"\1\131",
			"\1\132",
			"\1\133",
			"\1\134",
			"\1\135",
			"\1\136",
			"\1\137",
			"\1\140",
			"\1\141",
			"",
			"",
			"",
			"",
			"\1\142",
			"",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"\1\144",
			"\1\145",
			"\1\146",
			"\1\147",
			"\1\150",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\152",
			"",
			"\1\153",
			"\1\154",
			"\1\155",
			"\1\156",
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
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\175",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\177",
			"",
			"\1\u0080",
			"\1\u0081",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u0083",
			"\1\u0084",
			"\1\u0085",
			"\1\u0086",
			"\1\u0087",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u008b",
			"\1\u008c",
			"\1\u008d",
			"\1\u008e",
			"\1\u008f",
			"\1\u0090",
			"",
			"",
			"\1\u0091",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u0093",
			"\1\u0094",
			"",
			"\1\u0095",
			"\1\u0096",
			"\1\u0097",
			"\1\u0098",
			"\1\u0099",
			"",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u009b",
			"\1\u009c",
			"\1\u009d",
			"\1\u009e",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u00a0",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u00a2",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"\1\u00a8",
			"\1\u00a9",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"\1\u00ac",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"",
			"",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\u00af",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			""
	};

	static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
	static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
	static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
	static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
	static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
	static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
	static final short[][] DFA9_transition;

	static {
		int numStates = DFA9_transitionS.length;
		DFA9_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
		}
	}

	protected class DFA9 extends DFA {

		public DFA9(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 9;
			this.eot = DFA9_eot;
			this.eof = DFA9_eof;
			this.min = DFA9_min;
			this.max = DFA9_max;
			this.accept = DFA9_accept;
			this.special = DFA9_special;
			this.transition = DFA9_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__67 | T__68 | T__69 | T__70 | INT_TYPE | MAIN | CHAR_TYPE | VOID_TYPE | FLOAT_TYPE | DOUBLE_TYPE | LONG_TYPE | STATIC | ELSE | ENUM | GOTO | CONTINUE | BREAK | DO | FOR | DEFAULT | SIZEOF | STRUCT | TYPEDEF | SIGNED | UNSIGNED | SWITCH | PRINTF | RETURN | EOF_ | NEWLINE_ | TAB_ | IF_ | WHILE | TOTALEO | COMMENT1 | COMMENT2 | Identifier | Integer_constant | Floating_point_constant | WS | EXTRA1 | S_L | S_R | M_L | M_R | B_L | B_R | EXTRA8 | EXTRA9 | EXTRA10 | EXTRA11 | EXTRA12 | EXTRA13 );";
		}
	}

}
