// $ANTLR 3.5.1 mylexer.g 2014-03-21 15:44:59

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class mylexer extends Lexer {
	public static final int EOF=-1;
	public static final int BREAK=4;
	public static final int CHAR_TYPE=5;
	public static final int COMMENT1=6;
	public static final int COMMENT2=7;
	public static final int CONTINUE=8;
	public static final int DEC_NUM=9;
	public static final int DEFAULT=10;
	public static final int DIGIT=11;
	public static final int DO=12;
	public static final int DOUBLE_TYPE=13;
	public static final int ELSE=14;
	public static final int ENUM=15;
	public static final int EO1=16;
	public static final int EO10=17;
	public static final int EO11=18;
	public static final int EO12=19;
	public static final int EO2=20;
	public static final int EO3=21;
	public static final int EO4=22;
	public static final int EO5=23;
	public static final int EO6=24;
	public static final int EO7=25;
	public static final int EO8=26;
	public static final int EO9=27;
	public static final int EOF_=28;
	public static final int EQ_OP=29;
	public static final int EXTRA1=30;
	public static final int EXTRA10=31;
	public static final int EXTRA11=32;
	public static final int EXTRA12=33;
	public static final int EXTRA13=34;
	public static final int EXTRA2=35;
	public static final int EXTRA3=36;
	public static final int EXTRA4=37;
	public static final int EXTRA5=38;
	public static final int EXTRA6=39;
	public static final int EXTRA7=40;
	public static final int EXTRA8=41;
	public static final int EXTRA9=42;
	public static final int FLOAT_NUM=43;
	public static final int FLOAT_NUM1=44;
	public static final int FLOAT_NUM2=45;
	public static final int FLOAT_NUM3=46;
	public static final int FLOAT_TYPE=47;
	public static final int GE_OP=48;
	public static final int GOTO=49;
	public static final int ID=50;
	public static final int IF_=51;
	public static final int INT_TYPE=52;
	public static final int LETTER=53;
	public static final int LE_OP=54;
	public static final int LONG_TYPE=55;
	public static final int LSHIFT_OP=56;
	public static final int MM_OP=57;
	public static final int NEWLINE_=58;
	public static final int NEW_LINE=59;
	public static final int NE_OP=60;
	public static final int PP_OP=61;
	public static final int RETURN=62;
	public static final int RSHIFT_OP=63;
	public static final int SIGNED=64;
	public static final int SIZEOF=65;
	public static final int STATIC=66;
	public static final int STRUCT=67;
	public static final int SWITCH=68;
	public static final int TAB_=69;
	public static final int TYPEDEF=70;
	public static final int UNSIGNED=71;
	public static final int VOID_TYPE=72;
	public static final int WHILE=73;
	public static final int WS=74;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public mylexer() {} 
	public mylexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public mylexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "mylexer.g"; }

	// $ANTLR start "INT_TYPE"
	public final void mINT_TYPE() throws RecognitionException {
		try {
			int _type = INT_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:10:11: ( 'int' )
			// mylexer.g:10:13: 'int'
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

	// $ANTLR start "CHAR_TYPE"
	public final void mCHAR_TYPE() throws RecognitionException {
		try {
			int _type = CHAR_TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:11:11: ( 'char' )
			// mylexer.g:11:13: 'char'
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
			// mylexer.g:12:11: ( 'void' )
			// mylexer.g:12:13: 'void'
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
			// mylexer.g:13:11: ( 'float' )
			// mylexer.g:13:13: 'float'
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
			// mylexer.g:14:12: ( 'double' )
			// mylexer.g:14:14: 'double'
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
			// mylexer.g:15:11: ( 'long' )
			// mylexer.g:15:13: 'long'
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
			// mylexer.g:17:11: ( 'static' )
			// mylexer.g:17:13: 'static'
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
			// mylexer.g:18:11: ( 'else' )
			// mylexer.g:18:13: 'else'
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
			// mylexer.g:19:11: ( 'enum' )
			// mylexer.g:19:13: 'enum'
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
			// mylexer.g:20:11: ( 'goto' )
			// mylexer.g:20:13: 'goto'
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
			// mylexer.g:21:11: ( 'continue' )
			// mylexer.g:21:13: 'continue'
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
			// mylexer.g:22:11: ( 'break' )
			// mylexer.g:22:13: 'break'
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
			// mylexer.g:23:11: ( 'do' )
			// mylexer.g:23:13: 'do'
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

	// $ANTLR start "DEFAULT"
	public final void mDEFAULT() throws RecognitionException {
		try {
			int _type = DEFAULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:24:11: ( 'default' )
			// mylexer.g:24:13: 'default'
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
			// mylexer.g:25:11: ( 'sizeof' )
			// mylexer.g:25:13: 'sizeof'
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
			// mylexer.g:26:11: ( 'struct' )
			// mylexer.g:26:13: 'struct'
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
			// mylexer.g:27:11: ( 'typedef' )
			// mylexer.g:27:13: 'typedef'
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
			// mylexer.g:28:11: ( 'signed' )
			// mylexer.g:28:13: 'signed'
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
			// mylexer.g:29:11: ( 'unsigned' )
			// mylexer.g:29:13: 'unsigned'
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
			// mylexer.g:30:11: ( 'switch' )
			// mylexer.g:30:13: 'switch'
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

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:31:11: ( 'return' )
			// mylexer.g:31:13: 'return'
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
			// mylexer.g:32:12: ( '\\\\0' )
			// mylexer.g:32:14: '\\\\0'
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
			// mylexer.g:33:12: ( '\\\\n' )
			// mylexer.g:33:14: '\\\\n'
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
			// mylexer.g:34:12: ( '\\\\t' )
			// mylexer.g:34:14: '\\\\t'
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
			// mylexer.g:37:6: ( 'if' )
			// mylexer.g:37:8: 'if'
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
			// mylexer.g:38:10: ( 'while' )
			// mylexer.g:38:12: 'while'
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

	// $ANTLR start "EQ_OP"
	public final void mEQ_OP() throws RecognitionException {
		try {
			int _type = EQ_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:43:7: ( '==' )
			// mylexer.g:43:9: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ_OP"

	// $ANTLR start "LE_OP"
	public final void mLE_OP() throws RecognitionException {
		try {
			int _type = LE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:44:7: ( '<=' )
			// mylexer.g:44:9: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LE_OP"

	// $ANTLR start "GE_OP"
	public final void mGE_OP() throws RecognitionException {
		try {
			int _type = GE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:45:7: ( '>=' )
			// mylexer.g:45:9: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GE_OP"

	// $ANTLR start "NE_OP"
	public final void mNE_OP() throws RecognitionException {
		try {
			int _type = NE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:46:7: ( '!=' )
			// mylexer.g:46:9: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NE_OP"

	// $ANTLR start "PP_OP"
	public final void mPP_OP() throws RecognitionException {
		try {
			int _type = PP_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:47:7: ( '++' )
			// mylexer.g:47:9: '++'
			{
			match("++"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PP_OP"

	// $ANTLR start "MM_OP"
	public final void mMM_OP() throws RecognitionException {
		try {
			int _type = MM_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:48:7: ( '--' )
			// mylexer.g:48:9: '--'
			{
			match("--"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MM_OP"

	// $ANTLR start "EO1"
	public final void mEO1() throws RecognitionException {
		try {
			int _type = EO1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:49:7: ( '&&' )
			// mylexer.g:49:9: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO1"

	// $ANTLR start "EO2"
	public final void mEO2() throws RecognitionException {
		try {
			int _type = EO2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:50:7: ( '||' )
			// mylexer.g:50:9: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO2"

	// $ANTLR start "EO3"
	public final void mEO3() throws RecognitionException {
		try {
			int _type = EO3;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:51:7: ( '&' )
			// mylexer.g:51:9: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO3"

	// $ANTLR start "EO4"
	public final void mEO4() throws RecognitionException {
		try {
			int _type = EO4;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:52:7: ( '|' )
			// mylexer.g:52:9: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO4"

	// $ANTLR start "EO5"
	public final void mEO5() throws RecognitionException {
		try {
			int _type = EO5;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:53:7: ( '!' )
			// mylexer.g:53:9: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO5"

	// $ANTLR start "EO6"
	public final void mEO6() throws RecognitionException {
		try {
			int _type = EO6;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:54:7: ( '^' )
			// mylexer.g:54:9: '^'
			{
			match('^'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO6"

	// $ANTLR start "EO7"
	public final void mEO7() throws RecognitionException {
		try {
			int _type = EO7;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:55:7: ( '~' )
			// mylexer.g:55:9: '~'
			{
			match('~'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO7"

	// $ANTLR start "EO8"
	public final void mEO8() throws RecognitionException {
		try {
			int _type = EO8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:56:7: ( '%' )
			// mylexer.g:56:9: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EO8"

	// $ANTLR start "EO9"
	public final void mEO9() throws RecognitionException {
		try {
			int _type = EO9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:57:7: ( '+' )
			// mylexer.g:57:9: '+'
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
	// $ANTLR end "EO9"

	// $ANTLR start "EO10"
	public final void mEO10() throws RecognitionException {
		try {
			int _type = EO10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:58:7: ( '-' )
			// mylexer.g:58:9: '-'
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
	// $ANTLR end "EO10"

	// $ANTLR start "EO11"
	public final void mEO11() throws RecognitionException {
		try {
			int _type = EO11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:59:7: ( '*' )
			// mylexer.g:59:9: '*'
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
	// $ANTLR end "EO11"

	// $ANTLR start "EO12"
	public final void mEO12() throws RecognitionException {
		try {
			int _type = EO12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:60:7: ( '/' )
			// mylexer.g:60:9: '/'
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
	// $ANTLR end "EO12"

	// $ANTLR start "RSHIFT_OP"
	public final void mRSHIFT_OP() throws RecognitionException {
		try {
			int _type = RSHIFT_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:63:11: ( '<<' )
			// mylexer.g:63:13: '<<'
			{
			match("<<"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RSHIFT_OP"

	// $ANTLR start "LSHIFT_OP"
	public final void mLSHIFT_OP() throws RecognitionException {
		try {
			int _type = LSHIFT_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:64:11: ( '>>' )
			// mylexer.g:64:13: '>>'
			{
			match(">>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LSHIFT_OP"

	// $ANTLR start "DEC_NUM"
	public final void mDEC_NUM() throws RecognitionException {
		try {
			int _type = DEC_NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:67:9: ( ( '0' | ( '1' .. '9' ) ( DIGIT )* ) )
			// mylexer.g:67:11: ( '0' | ( '1' .. '9' ) ( DIGIT )* )
			{
			// mylexer.g:67:11: ( '0' | ( '1' .. '9' ) ( DIGIT )* )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='0') ) {
				alt2=1;
			}
			else if ( ((LA2_0 >= '1' && LA2_0 <= '9')) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// mylexer.g:67:12: '0'
					{
					match('0'); 
					}
					break;
				case 2 :
					// mylexer.g:67:18: ( '1' .. '9' ) ( DIGIT )*
					{
					if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// mylexer.g:67:28: ( DIGIT )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// mylexer.g:
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
							break loop1;
						}
					}

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEC_NUM"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:69:4: ( ( LETTER ) ( LETTER | DIGIT )* )
			// mylexer.g:69:6: ( LETTER ) ( LETTER | DIGIT )*
			{
			if ( input.LA(1)=='.'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// mylexer.g:69:14: ( LETTER | DIGIT )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='.'||(LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// mylexer.g:
					{
					if ( input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
					break loop3;
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
	// $ANTLR end "ID"

	// $ANTLR start "FLOAT_NUM"
	public final void mFLOAT_NUM() throws RecognitionException {
		try {
			int _type = FLOAT_NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:71:10: ( FLOAT_NUM1 | FLOAT_NUM2 | FLOAT_NUM3 )
			int alt4=3;
			alt4 = dfa4.predict(input);
			switch (alt4) {
				case 1 :
					// mylexer.g:71:12: FLOAT_NUM1
					{
					mFLOAT_NUM1(); 

					}
					break;
				case 2 :
					// mylexer.g:71:25: FLOAT_NUM2
					{
					mFLOAT_NUM2(); 

					}
					break;
				case 3 :
					// mylexer.g:71:38: FLOAT_NUM3
					{
					mFLOAT_NUM3(); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_NUM"

	// $ANTLR start "FLOAT_NUM1"
	public final void mFLOAT_NUM1() throws RecognitionException {
		try {
			// mylexer.g:72:20: ( ( DIGIT )+ '.' ( DIGIT )* )
			// mylexer.g:72:22: ( DIGIT )+ '.' ( DIGIT )*
			{
			// mylexer.g:72:22: ( DIGIT )+
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
					// mylexer.g:
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

			match('.'); 
			// mylexer.g:72:33: ( DIGIT )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// mylexer.g:
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

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_NUM1"

	// $ANTLR start "FLOAT_NUM2"
	public final void mFLOAT_NUM2() throws RecognitionException {
		try {
			// mylexer.g:73:20: ( '.' ( DIGIT )+ )
			// mylexer.g:73:22: '.' ( DIGIT )+
			{
			match('.'); 
			// mylexer.g:73:25: ( DIGIT )+
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
					// mylexer.g:
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

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_NUM2"

	// $ANTLR start "FLOAT_NUM3"
	public final void mFLOAT_NUM3() throws RecognitionException {
		try {
			// mylexer.g:74:20: ( ( DIGIT )+ )
			// mylexer.g:74:22: ( DIGIT )+
			{
			// mylexer.g:74:22: ( DIGIT )+
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
					// mylexer.g:
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

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT_NUM3"

	// $ANTLR start "COMMENT1"
	public final void mCOMMENT1() throws RecognitionException {
		try {
			int _type = COMMENT1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:78:10: ( '//' ( . )* '\\n' )
			// mylexer.g:78:12: '//' ( . )* '\\n'
			{
			match("//"); 

			// mylexer.g:78:16: ( . )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0=='\n') ) {
					alt9=2;
				}
				else if ( ((LA9_0 >= '\u0000' && LA9_0 <= '\t')||(LA9_0 >= '\u000B' && LA9_0 <= '\uFFFF')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// mylexer.g:78:17: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop9;
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
			// mylexer.g:79:10: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// mylexer.g:79:12: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// mylexer.g:79:17: ( options {greedy=false; } : . )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0=='*') ) {
					int LA10_1 = input.LA(2);
					if ( (LA10_1=='/') ) {
						alt10=2;
					}
					else if ( ((LA10_1 >= '\u0000' && LA10_1 <= '.')||(LA10_1 >= '0' && LA10_1 <= '\uFFFF')) ) {
						alt10=1;
					}

				}
				else if ( ((LA10_0 >= '\u0000' && LA10_0 <= ')')||(LA10_0 >= '+' && LA10_0 <= '\uFFFF')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// mylexer.g:79:42: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop10;
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

	// $ANTLR start "NEW_LINE"
	public final void mNEW_LINE() throws RecognitionException {
		try {
			int _type = NEW_LINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:82:9: ( '\\n' )
			// mylexer.g:82:11: '\\n'
			{
			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEW_LINE"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// mylexer.g:83:17: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '.' )
			// mylexer.g:
			{
			if ( input.LA(1)=='.'||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// mylexer.g:84:16: ( '0' .. '9' )
			// mylexer.g:
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

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "EXTRA1"
	public final void mEXTRA1() throws RecognitionException {
		try {
			int _type = EXTRA1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:85:8: ( '#' )
			// mylexer.g:85:10: '#'
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

	// $ANTLR start "EXTRA2"
	public final void mEXTRA2() throws RecognitionException {
		try {
			int _type = EXTRA2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:86:8: ( '<' )
			// mylexer.g:86:10: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTRA2"

	// $ANTLR start "EXTRA3"
	public final void mEXTRA3() throws RecognitionException {
		try {
			int _type = EXTRA3;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:87:8: ( '>' )
			// mylexer.g:87:10: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTRA3"

	// $ANTLR start "EXTRA4"
	public final void mEXTRA4() throws RecognitionException {
		try {
			int _type = EXTRA4;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:88:8: ( '(' )
			// mylexer.g:88:10: '('
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
	// $ANTLR end "EXTRA4"

	// $ANTLR start "EXTRA5"
	public final void mEXTRA5() throws RecognitionException {
		try {
			int _type = EXTRA5;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:89:8: ( ')' )
			// mylexer.g:89:10: ')'
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
	// $ANTLR end "EXTRA5"

	// $ANTLR start "EXTRA6"
	public final void mEXTRA6() throws RecognitionException {
		try {
			int _type = EXTRA6;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:90:8: ( '{' )
			// mylexer.g:90:10: '{'
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
	// $ANTLR end "EXTRA6"

	// $ANTLR start "EXTRA7"
	public final void mEXTRA7() throws RecognitionException {
		try {
			int _type = EXTRA7;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:91:8: ( '}' )
			// mylexer.g:91:10: '}'
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
	// $ANTLR end "EXTRA7"

	// $ANTLR start "EXTRA8"
	public final void mEXTRA8() throws RecognitionException {
		try {
			int _type = EXTRA8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:92:8: ( '=' )
			// mylexer.g:92:10: '='
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
			// mylexer.g:93:8: ( ',' )
			// mylexer.g:93:10: ','
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
			// mylexer.g:94:9: ( ';' )
			// mylexer.g:94:11: ';'
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
			// mylexer.g:95:9: ( '\\\\' )
			// mylexer.g:95:11: '\\\\'
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
			// mylexer.g:96:9: ( '\\'' )
			// mylexer.g:96:11: '\\''
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
			// mylexer.g:97:9: ( '\"' )
			// mylexer.g:97:11: '\"'
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

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// mylexer.g:99:5: ( ( ' ' | '\\r' | '\\t' )+ )
			// mylexer.g:99:7: ( ' ' | '\\r' | '\\t' )+
			{
			// mylexer.g:99:7: ( ' ' | '\\r' | '\\t' )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0=='\t'||LA11_0=='\r'||LA11_0==' ') ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// mylexer.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// mylexer.g:1:8: ( INT_TYPE | CHAR_TYPE | VOID_TYPE | FLOAT_TYPE | DOUBLE_TYPE | LONG_TYPE | STATIC | ELSE | ENUM | GOTO | CONTINUE | BREAK | DO | DEFAULT | SIZEOF | STRUCT | TYPEDEF | SIGNED | UNSIGNED | SWITCH | RETURN | EOF_ | NEWLINE_ | TAB_ | IF_ | WHILE | EQ_OP | LE_OP | GE_OP | NE_OP | PP_OP | MM_OP | EO1 | EO2 | EO3 | EO4 | EO5 | EO6 | EO7 | EO8 | EO9 | EO10 | EO11 | EO12 | RSHIFT_OP | LSHIFT_OP | DEC_NUM | ID | FLOAT_NUM | COMMENT1 | COMMENT2 | NEW_LINE | EXTRA1 | EXTRA2 | EXTRA3 | EXTRA4 | EXTRA5 | EXTRA6 | EXTRA7 | EXTRA8 | EXTRA9 | EXTRA10 | EXTRA11 | EXTRA12 | EXTRA13 | WS )
		int alt12=66;
		alt12 = dfa12.predict(input);
		switch (alt12) {
			case 1 :
				// mylexer.g:1:10: INT_TYPE
				{
				mINT_TYPE(); 

				}
				break;
			case 2 :
				// mylexer.g:1:19: CHAR_TYPE
				{
				mCHAR_TYPE(); 

				}
				break;
			case 3 :
				// mylexer.g:1:29: VOID_TYPE
				{
				mVOID_TYPE(); 

				}
				break;
			case 4 :
				// mylexer.g:1:39: FLOAT_TYPE
				{
				mFLOAT_TYPE(); 

				}
				break;
			case 5 :
				// mylexer.g:1:50: DOUBLE_TYPE
				{
				mDOUBLE_TYPE(); 

				}
				break;
			case 6 :
				// mylexer.g:1:62: LONG_TYPE
				{
				mLONG_TYPE(); 

				}
				break;
			case 7 :
				// mylexer.g:1:72: STATIC
				{
				mSTATIC(); 

				}
				break;
			case 8 :
				// mylexer.g:1:79: ELSE
				{
				mELSE(); 

				}
				break;
			case 9 :
				// mylexer.g:1:84: ENUM
				{
				mENUM(); 

				}
				break;
			case 10 :
				// mylexer.g:1:89: GOTO
				{
				mGOTO(); 

				}
				break;
			case 11 :
				// mylexer.g:1:94: CONTINUE
				{
				mCONTINUE(); 

				}
				break;
			case 12 :
				// mylexer.g:1:103: BREAK
				{
				mBREAK(); 

				}
				break;
			case 13 :
				// mylexer.g:1:109: DO
				{
				mDO(); 

				}
				break;
			case 14 :
				// mylexer.g:1:112: DEFAULT
				{
				mDEFAULT(); 

				}
				break;
			case 15 :
				// mylexer.g:1:120: SIZEOF
				{
				mSIZEOF(); 

				}
				break;
			case 16 :
				// mylexer.g:1:127: STRUCT
				{
				mSTRUCT(); 

				}
				break;
			case 17 :
				// mylexer.g:1:134: TYPEDEF
				{
				mTYPEDEF(); 

				}
				break;
			case 18 :
				// mylexer.g:1:142: SIGNED
				{
				mSIGNED(); 

				}
				break;
			case 19 :
				// mylexer.g:1:149: UNSIGNED
				{
				mUNSIGNED(); 

				}
				break;
			case 20 :
				// mylexer.g:1:158: SWITCH
				{
				mSWITCH(); 

				}
				break;
			case 21 :
				// mylexer.g:1:165: RETURN
				{
				mRETURN(); 

				}
				break;
			case 22 :
				// mylexer.g:1:172: EOF_
				{
				mEOF_(); 

				}
				break;
			case 23 :
				// mylexer.g:1:177: NEWLINE_
				{
				mNEWLINE_(); 

				}
				break;
			case 24 :
				// mylexer.g:1:186: TAB_
				{
				mTAB_(); 

				}
				break;
			case 25 :
				// mylexer.g:1:191: IF_
				{
				mIF_(); 

				}
				break;
			case 26 :
				// mylexer.g:1:195: WHILE
				{
				mWHILE(); 

				}
				break;
			case 27 :
				// mylexer.g:1:201: EQ_OP
				{
				mEQ_OP(); 

				}
				break;
			case 28 :
				// mylexer.g:1:207: LE_OP
				{
				mLE_OP(); 

				}
				break;
			case 29 :
				// mylexer.g:1:213: GE_OP
				{
				mGE_OP(); 

				}
				break;
			case 30 :
				// mylexer.g:1:219: NE_OP
				{
				mNE_OP(); 

				}
				break;
			case 31 :
				// mylexer.g:1:225: PP_OP
				{
				mPP_OP(); 

				}
				break;
			case 32 :
				// mylexer.g:1:231: MM_OP
				{
				mMM_OP(); 

				}
				break;
			case 33 :
				// mylexer.g:1:237: EO1
				{
				mEO1(); 

				}
				break;
			case 34 :
				// mylexer.g:1:241: EO2
				{
				mEO2(); 

				}
				break;
			case 35 :
				// mylexer.g:1:245: EO3
				{
				mEO3(); 

				}
				break;
			case 36 :
				// mylexer.g:1:249: EO4
				{
				mEO4(); 

				}
				break;
			case 37 :
				// mylexer.g:1:253: EO5
				{
				mEO5(); 

				}
				break;
			case 38 :
				// mylexer.g:1:257: EO6
				{
				mEO6(); 

				}
				break;
			case 39 :
				// mylexer.g:1:261: EO7
				{
				mEO7(); 

				}
				break;
			case 40 :
				// mylexer.g:1:265: EO8
				{
				mEO8(); 

				}
				break;
			case 41 :
				// mylexer.g:1:269: EO9
				{
				mEO9(); 

				}
				break;
			case 42 :
				// mylexer.g:1:273: EO10
				{
				mEO10(); 

				}
				break;
			case 43 :
				// mylexer.g:1:278: EO11
				{
				mEO11(); 

				}
				break;
			case 44 :
				// mylexer.g:1:283: EO12
				{
				mEO12(); 

				}
				break;
			case 45 :
				// mylexer.g:1:288: RSHIFT_OP
				{
				mRSHIFT_OP(); 

				}
				break;
			case 46 :
				// mylexer.g:1:298: LSHIFT_OP
				{
				mLSHIFT_OP(); 

				}
				break;
			case 47 :
				// mylexer.g:1:308: DEC_NUM
				{
				mDEC_NUM(); 

				}
				break;
			case 48 :
				// mylexer.g:1:316: ID
				{
				mID(); 

				}
				break;
			case 49 :
				// mylexer.g:1:319: FLOAT_NUM
				{
				mFLOAT_NUM(); 

				}
				break;
			case 50 :
				// mylexer.g:1:329: COMMENT1
				{
				mCOMMENT1(); 

				}
				break;
			case 51 :
				// mylexer.g:1:338: COMMENT2
				{
				mCOMMENT2(); 

				}
				break;
			case 52 :
				// mylexer.g:1:347: NEW_LINE
				{
				mNEW_LINE(); 

				}
				break;
			case 53 :
				// mylexer.g:1:356: EXTRA1
				{
				mEXTRA1(); 

				}
				break;
			case 54 :
				// mylexer.g:1:363: EXTRA2
				{
				mEXTRA2(); 

				}
				break;
			case 55 :
				// mylexer.g:1:370: EXTRA3
				{
				mEXTRA3(); 

				}
				break;
			case 56 :
				// mylexer.g:1:377: EXTRA4
				{
				mEXTRA4(); 

				}
				break;
			case 57 :
				// mylexer.g:1:384: EXTRA5
				{
				mEXTRA5(); 

				}
				break;
			case 58 :
				// mylexer.g:1:391: EXTRA6
				{
				mEXTRA6(); 

				}
				break;
			case 59 :
				// mylexer.g:1:398: EXTRA7
				{
				mEXTRA7(); 

				}
				break;
			case 60 :
				// mylexer.g:1:405: EXTRA8
				{
				mEXTRA8(); 

				}
				break;
			case 61 :
				// mylexer.g:1:412: EXTRA9
				{
				mEXTRA9(); 

				}
				break;
			case 62 :
				// mylexer.g:1:419: EXTRA10
				{
				mEXTRA10(); 

				}
				break;
			case 63 :
				// mylexer.g:1:427: EXTRA11
				{
				mEXTRA11(); 

				}
				break;
			case 64 :
				// mylexer.g:1:435: EXTRA12
				{
				mEXTRA12(); 

				}
				break;
			case 65 :
				// mylexer.g:1:443: EXTRA13
				{
				mEXTRA13(); 

				}
				break;
			case 66 :
				// mylexer.g:1:451: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA4 dfa4 = new DFA4(this);
	protected DFA12 dfa12 = new DFA12(this);
	static final String DFA4_eotS =
		"\1\uffff\1\4\3\uffff";
	static final String DFA4_eofS =
		"\5\uffff";
	static final String DFA4_minS =
		"\2\56\3\uffff";
	static final String DFA4_maxS =
		"\2\71\3\uffff";
	static final String DFA4_acceptS =
		"\2\uffff\1\2\1\1\1\3";
	static final String DFA4_specialS =
		"\5\uffff}>";
	static final String[] DFA4_transitionS = {
			"\1\2\1\uffff\12\1",
			"\1\3\1\uffff\12\1",
			"",
			"",
			""
	};

	static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
	static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
	static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
	static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
	static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
	static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
	static final short[][] DFA4_transition;

	static {
		int numStates = DFA4_transitionS.length;
		DFA4_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
		}
	}

	protected class DFA4 extends DFA {

		public DFA4(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 4;
			this.eot = DFA4_eot;
			this.eof = DFA4_eof;
			this.min = DFA4_min;
			this.max = DFA4_max;
			this.accept = DFA4_accept;
			this.special = DFA4_special;
			this.transition = DFA4_transition;
		}
		@Override
		public String getDescription() {
			return "71:1: FLOAT_NUM : ( FLOAT_NUM1 | FLOAT_NUM2 | FLOAT_NUM3 );";
		}
	}

	static final String DFA12_eotS =
		"\1\uffff\15\40\1\102\1\40\1\105\1\110\1\113\1\115\1\117\1\121\1\123\1"+
		"\125\4\uffff\1\130\2\131\1\40\14\uffff\1\40\1\136\4\40\1\144\14\40\4\uffff"+
		"\1\40\27\uffff\1\131\1\40\1\164\1\uffff\5\40\1\uffff\17\40\1\uffff\1\u0089"+
		"\1\40\1\u008b\3\40\1\u008f\5\40\1\u0095\1\u0096\1\u0097\5\40\1\uffff\1"+
		"\40\1\uffff\1\u009e\2\40\1\uffff\5\40\3\uffff\1\u00a6\3\40\1\u00aa\1\40"+
		"\1\uffff\1\u00ac\1\40\1\u00ae\1\u00af\1\u00b0\1\u00b1\1\u00b2\1\uffff"+
		"\2\40\1\u00b5\1\uffff\1\40\1\uffff\1\u00b7\5\uffff\1\u00b8\1\40\1\uffff"+
		"\1\u00ba\2\uffff\1\u00bb\2\uffff";
	static final String DFA12_eofS =
		"\u00bc\uffff";
	static final String DFA12_minS =
		"\1\11\1\146\1\150\1\157\1\154\1\145\1\157\1\151\1\154\1\157\1\162\1\171"+
		"\1\156\1\145\1\60\1\150\1\75\1\74\2\75\1\53\1\55\1\46\1\174\4\uffff\1"+
		"\52\2\56\1\60\14\uffff\1\164\1\56\1\141\1\156\1\151\1\157\1\56\1\146\1"+
		"\156\1\141\1\147\1\151\1\163\1\165\1\164\1\145\1\160\1\163\1\164\4\uffff"+
		"\1\151\27\uffff\1\56\1\60\1\56\1\uffff\1\162\1\164\1\144\1\141\1\142\1"+
		"\uffff\1\141\1\147\1\164\1\165\1\145\1\156\1\164\1\145\1\155\1\157\1\141"+
		"\1\145\1\151\1\165\1\154\1\uffff\1\56\1\151\1\56\1\164\1\154\1\165\1\56"+
		"\1\151\1\143\1\157\1\145\1\143\3\56\1\153\1\144\1\147\1\162\1\145\1\uffff"+
		"\1\156\1\uffff\1\56\1\145\1\154\1\uffff\1\143\1\164\1\146\1\144\1\150"+
		"\3\uffff\1\56\1\145\2\156\1\56\1\165\1\uffff\1\56\1\164\5\56\1\uffff\1"+
		"\146\1\145\1\56\1\uffff\1\145\1\uffff\1\56\5\uffff\1\56\1\144\1\uffff"+
		"\1\56\2\uffff\1\56\2\uffff";
	static final String DFA12_maxS =
		"\1\176\1\156\2\157\1\154\2\157\1\167\1\156\1\157\1\162\1\171\1\156\1\145"+
		"\1\164\1\150\2\75\1\76\1\75\1\53\1\55\1\46\1\174\4\uffff\1\57\3\71\14"+
		"\uffff\1\164\1\172\1\141\1\156\1\151\1\157\1\172\1\146\1\156\1\162\1\172"+
		"\1\151\1\163\1\165\1\164\1\145\1\160\1\163\1\164\4\uffff\1\151\27\uffff"+
		"\2\71\1\172\1\uffff\1\162\1\164\1\144\1\141\1\142\1\uffff\1\141\1\147"+
		"\1\164\1\165\1\145\1\156\1\164\1\145\1\155\1\157\1\141\1\145\1\151\1\165"+
		"\1\154\1\uffff\1\172\1\151\1\172\1\164\1\154\1\165\1\172\1\151\1\143\1"+
		"\157\1\145\1\143\3\172\1\153\1\144\1\147\1\162\1\145\1\uffff\1\156\1\uffff"+
		"\1\172\1\145\1\154\1\uffff\1\143\1\164\1\146\1\144\1\150\3\uffff\1\172"+
		"\1\145\2\156\1\172\1\165\1\uffff\1\172\1\164\5\172\1\uffff\1\146\1\145"+
		"\1\172\1\uffff\1\145\1\uffff\1\172\5\uffff\1\172\1\144\1\uffff\1\172\2"+
		"\uffff\1\172\2\uffff";
	static final String DFA12_acceptS =
		"\30\uffff\1\46\1\47\1\50\1\53\4\uffff\1\60\1\64\1\65\1\70\1\71\1\72\1"+
		"\73\1\75\1\76\1\100\1\101\1\102\23\uffff\1\26\1\27\1\30\1\77\1\uffff\1"+
		"\33\1\74\1\34\1\55\1\66\1\35\1\56\1\67\1\36\1\45\1\37\1\51\1\40\1\52\1"+
		"\41\1\43\1\42\1\44\1\62\1\63\1\54\1\57\1\61\3\uffff\1\31\5\uffff\1\15"+
		"\17\uffff\1\1\24\uffff\1\2\1\uffff\1\3\3\uffff\1\6\5\uffff\1\10\1\11\1"+
		"\12\6\uffff\1\4\7\uffff\1\14\3\uffff\1\32\1\uffff\1\5\1\uffff\1\7\1\20"+
		"\1\17\1\22\1\24\2\uffff\1\25\1\uffff\1\16\1\21\1\uffff\1\13\1\23";
	static final String DFA12_specialS =
		"\u00bc\uffff}>";
	static final String[] DFA12_transitionS = {
			"\1\53\1\41\2\uffff\1\53\22\uffff\1\53\1\23\1\52\1\42\1\uffff\1\32\1\26"+
			"\1\51\1\43\1\44\1\33\1\24\1\47\1\25\1\37\1\34\1\35\11\36\1\uffff\1\50"+
			"\1\21\1\20\1\22\2\uffff\32\40\1\uffff\1\16\1\uffff\1\30\1\40\1\uffff"+
			"\1\40\1\12\1\2\1\5\1\10\1\4\1\11\1\40\1\1\2\40\1\6\5\40\1\15\1\7\1\13"+
			"\1\14\1\3\1\17\3\40\1\45\1\27\1\46\1\31",
			"\1\55\7\uffff\1\54",
			"\1\56\6\uffff\1\57",
			"\1\60",
			"\1\61",
			"\1\63\11\uffff\1\62",
			"\1\64",
			"\1\66\12\uffff\1\65\2\uffff\1\67",
			"\1\70\1\uffff\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77\75\uffff\1\100\5\uffff\1\101",
			"\1\103",
			"\1\104",
			"\1\107\1\106",
			"\1\111\1\112",
			"\1\114",
			"\1\116",
			"\1\120",
			"\1\122",
			"\1\124",
			"",
			"",
			"",
			"",
			"\1\127\4\uffff\1\126",
			"\1\132\1\uffff\12\132",
			"\1\132\1\uffff\12\133",
			"\12\134",
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
			"\1\135",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\137",
			"\1\140",
			"\1\141",
			"\1\142",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\24\40\1\143\5"+
			"\40",
			"\1\145",
			"\1\146",
			"\1\147\20\uffff\1\150",
			"\1\152\22\uffff\1\151",
			"\1\153",
			"\1\154",
			"\1\155",
			"\1\156",
			"\1\157",
			"\1\160",
			"\1\161",
			"\1\162",
			"",
			"",
			"",
			"",
			"\1\163",
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
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\132\1\uffff\12\133",
			"\12\134",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"",
			"\1\165",
			"\1\166",
			"\1\167",
			"\1\170",
			"\1\171",
			"",
			"\1\172",
			"\1\173",
			"\1\174",
			"\1\175",
			"\1\176",
			"\1\177",
			"\1\u0080",
			"\1\u0081",
			"\1\u0082",
			"\1\u0083",
			"\1\u0084",
			"\1\u0085",
			"\1\u0086",
			"\1\u0087",
			"\1\u0088",
			"",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\u008a",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\u008c",
			"\1\u008d",
			"\1\u008e",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\u0090",
			"\1\u0091",
			"\1\u0092",
			"\1\u0093",
			"\1\u0094",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\u0098",
			"\1\u0099",
			"\1\u009a",
			"\1\u009b",
			"\1\u009c",
			"",
			"\1\u009d",
			"",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\u009f",
			"\1\u00a0",
			"",
			"\1\u00a1",
			"\1\u00a2",
			"\1\u00a3",
			"\1\u00a4",
			"\1\u00a5",
			"",
			"",
			"",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\u00a7",
			"\1\u00a8",
			"\1\u00a9",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\u00ab",
			"",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\u00ad",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"",
			"\1\u00b3",
			"\1\u00b4",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"",
			"\1\u00b6",
			"",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"",
			"",
			"",
			"",
			"",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\u00b9",
			"",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"",
			"",
			"\1\40\1\uffff\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"",
			""
	};

	static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
	static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
	static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
	static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
	static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
	static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
	static final short[][] DFA12_transition;

	static {
		int numStates = DFA12_transitionS.length;
		DFA12_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
		}
	}

	protected class DFA12 extends DFA {

		public DFA12(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 12;
			this.eot = DFA12_eot;
			this.eof = DFA12_eof;
			this.min = DFA12_min;
			this.max = DFA12_max;
			this.accept = DFA12_accept;
			this.special = DFA12_special;
			this.transition = DFA12_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( INT_TYPE | CHAR_TYPE | VOID_TYPE | FLOAT_TYPE | DOUBLE_TYPE | LONG_TYPE | STATIC | ELSE | ENUM | GOTO | CONTINUE | BREAK | DO | DEFAULT | SIZEOF | STRUCT | TYPEDEF | SIGNED | UNSIGNED | SWITCH | RETURN | EOF_ | NEWLINE_ | TAB_ | IF_ | WHILE | EQ_OP | LE_OP | GE_OP | NE_OP | PP_OP | MM_OP | EO1 | EO2 | EO3 | EO4 | EO5 | EO6 | EO7 | EO8 | EO9 | EO10 | EO11 | EO12 | RSHIFT_OP | LSHIFT_OP | DEC_NUM | ID | FLOAT_NUM | COMMENT1 | COMMENT2 | NEW_LINE | EXTRA1 | EXTRA2 | EXTRA3 | EXTRA4 | EXTRA5 | EXTRA6 | EXTRA7 | EXTRA8 | EXTRA9 | EXTRA10 | EXTRA11 | EXTRA12 | EXTRA13 | WS );";
		}
	}

}
