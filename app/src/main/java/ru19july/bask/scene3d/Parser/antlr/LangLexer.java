package ru19july.bask.scene3d.parser.antlr;
// Generated from C:/Projects/Scene3D/app/src/g4\LangLexer.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASS=1, ID=2, EQUAL=3, DIGITS=4, L_CURLY_BRACE=5, R_CURLY_BRACE=6, GREATER=7, 
		LESS=8, EXCLAMATION=9, PLUS_ASSIGN=10, MINUS_ASSIGN=11, MULT_ASSIGN=12, 
		DIV_ASSIGN=13, MOD_ASSIGN=14, AND_ASSIGN=15, XOR_ASSIGN=16, OR_ASSIGN=17, 
		DOUBLE_BAR=18, DOT=19, UNDERLINE=20, AT=21, SHARP=22, DOLLAR=23, LR_BRACKET=24, 
		RR_BRACKET=25, COMMA=26, SEMI=27, COLON=28, STAR=29, DIVIDE=30, MODULE=31, 
		PLUS=32, MINUS=33, BIT_NOT=34, BIT_OR=35, BIT_AND=36, BIT_XOR=37, WS=38;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"CLASS", "ID", "EQUAL", "DIGITS", "L_CURLY_BRACE", "R_CURLY_BRACE", "GREATER", 
		"LESS", "EXCLAMATION", "PLUS_ASSIGN", "MINUS_ASSIGN", "MULT_ASSIGN", "DIV_ASSIGN", 
		"MOD_ASSIGN", "AND_ASSIGN", "XOR_ASSIGN", "OR_ASSIGN", "DOUBLE_BAR", "DOT", 
		"UNDERLINE", "AT", "SHARP", "DOLLAR", "LR_BRACKET", "RR_BRACKET", "COMMA", 
		"SEMI", "COLON", "STAR", "DIVIDE", "MODULE", "PLUS", "MINUS", "BIT_NOT", 
		"BIT_OR", "BIT_AND", "BIT_XOR", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", null, "'='", null, "'{'", "'}'", "'>'", "'<'", "'!'", 
		"'+='", "'-='", "'*='", "'/='", "'%='", "'&='", "'^='", "'|='", "'||'", 
		"'.'", "'_'", "'@'", "'#'", "'$'", "'('", "')'", "','", "';'", "':'", 
		"'*'", "'/'", "'%'", "'+'", "'-'", "'~'", "'|'", "'&'", "'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CLASS", "ID", "EQUAL", "DIGITS", "L_CURLY_BRACE", "R_CURLY_BRACE", 
		"GREATER", "LESS", "EXCLAMATION", "PLUS_ASSIGN", "MINUS_ASSIGN", "MULT_ASSIGN", 
		"DIV_ASSIGN", "MOD_ASSIGN", "AND_ASSIGN", "XOR_ASSIGN", "OR_ASSIGN", "DOUBLE_BAR", 
		"DOT", "UNDERLINE", "AT", "SHARP", "DOLLAR", "LR_BRACKET", "RR_BRACKET", 
		"COMMA", "SEMI", "COLON", "STAR", "DIVIDE", "MODULE", "PLUS", "MINUS", 
		"BIT_NOT", "BIT_OR", "BIT_AND", "BIT_XOR", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LangLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u00b3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\6\3W\n\3\r\3\16\3X\3\4\3\4\3\5\6\5^\n\5\r\5\16\5_\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!"+
		"\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\6\'\u00ae\n\'\r\'\16\'\u00af\3"+
		"\'\3\'\2\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(\3\2\5\5\2\62;C\\c|\3\2\62;\5\2\13\f\17"+
		"\17\"\"\2\u00b5\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5V\3\2\2"+
		"\2\7Z\3\2\2\2\t]\3\2\2\2\13a\3\2\2\2\rc\3\2\2\2\17e\3\2\2\2\21g\3\2\2"+
		"\2\23i\3\2\2\2\25k\3\2\2\2\27n\3\2\2\2\31q\3\2\2\2\33t\3\2\2\2\35w\3\2"+
		"\2\2\37z\3\2\2\2!}\3\2\2\2#\u0080\3\2\2\2%\u0083\3\2\2\2\'\u0086\3\2\2"+
		"\2)\u0088\3\2\2\2+\u008a\3\2\2\2-\u008c\3\2\2\2/\u008e\3\2\2\2\61\u0090"+
		"\3\2\2\2\63\u0092\3\2\2\2\65\u0094\3\2\2\2\67\u0096\3\2\2\29\u0098\3\2"+
		"\2\2;\u009a\3\2\2\2=\u009c\3\2\2\2?\u009e\3\2\2\2A\u00a0\3\2\2\2C\u00a2"+
		"\3\2\2\2E\u00a4\3\2\2\2G\u00a6\3\2\2\2I\u00a8\3\2\2\2K\u00aa\3\2\2\2M"+
		"\u00ad\3\2\2\2OP\7e\2\2PQ\7n\2\2QR\7c\2\2RS\7u\2\2ST\7u\2\2T\4\3\2\2\2"+
		"UW\t\2\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\6\3\2\2\2Z[\7?\2\2"+
		"[\b\3\2\2\2\\^\t\3\2\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\n\3\2"+
		"\2\2ab\7}\2\2b\f\3\2\2\2cd\7\177\2\2d\16\3\2\2\2ef\7@\2\2f\20\3\2\2\2"+
		"gh\7>\2\2h\22\3\2\2\2ij\7#\2\2j\24\3\2\2\2kl\7-\2\2lm\7?\2\2m\26\3\2\2"+
		"\2no\7/\2\2op\7?\2\2p\30\3\2\2\2qr\7,\2\2rs\7?\2\2s\32\3\2\2\2tu\7\61"+
		"\2\2uv\7?\2\2v\34\3\2\2\2wx\7\'\2\2xy\7?\2\2y\36\3\2\2\2z{\7(\2\2{|\7"+
		"?\2\2| \3\2\2\2}~\7`\2\2~\177\7?\2\2\177\"\3\2\2\2\u0080\u0081\7~\2\2"+
		"\u0081\u0082\7?\2\2\u0082$\3\2\2\2\u0083\u0084\7~\2\2\u0084\u0085\7~\2"+
		"\2\u0085&\3\2\2\2\u0086\u0087\7\60\2\2\u0087(\3\2\2\2\u0088\u0089\7a\2"+
		"\2\u0089*\3\2\2\2\u008a\u008b\7B\2\2\u008b,\3\2\2\2\u008c\u008d\7%\2\2"+
		"\u008d.\3\2\2\2\u008e\u008f\7&\2\2\u008f\60\3\2\2\2\u0090\u0091\7*\2\2"+
		"\u0091\62\3\2\2\2\u0092\u0093\7+\2\2\u0093\64\3\2\2\2\u0094\u0095\7.\2"+
		"\2\u0095\66\3\2\2\2\u0096\u0097\7=\2\2\u00978\3\2\2\2\u0098\u0099\7<\2"+
		"\2\u0099:\3\2\2\2\u009a\u009b\7,\2\2\u009b<\3\2\2\2\u009c\u009d\7\61\2"+
		"\2\u009d>\3\2\2\2\u009e\u009f\7\'\2\2\u009f@\3\2\2\2\u00a0\u00a1\7-\2"+
		"\2\u00a1B\3\2\2\2\u00a2\u00a3\7/\2\2\u00a3D\3\2\2\2\u00a4\u00a5\7\u0080"+
		"\2\2\u00a5F\3\2\2\2\u00a6\u00a7\7~\2\2\u00a7H\3\2\2\2\u00a8\u00a9\7(\2"+
		"\2\u00a9J\3\2\2\2\u00aa\u00ab\7`\2\2\u00abL\3\2\2\2\u00ac\u00ae\t\4\2"+
		"\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\b\'\2\2\u00b2N\3\2\2\2\6\2X_"+
		"\u00af\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}