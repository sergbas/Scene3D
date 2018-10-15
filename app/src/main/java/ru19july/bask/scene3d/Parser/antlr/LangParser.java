package ru19july.bask.scene3d.parser.antlr;
// Generated from C:/Projects/Scene3D/app/src/g4\LangParser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SCENE=1, ID=2, OBJECT3D=3, EQUAL=4, DIGITS=5, L_CURLY_BRACE=6, R_CURLY_BRACE=7, 
		COMMENT=8, LINE_COMMENT=9, GREATER=10, LESS=11, EXCLAMATION=12, PLUS_ASSIGN=13, 
		MINUS_ASSIGN=14, MULT_ASSIGN=15, DIV_ASSIGN=16, MOD_ASSIGN=17, AND_ASSIGN=18, 
		XOR_ASSIGN=19, OR_ASSIGN=20, DOUBLE_BAR=21, DOT=22, UNDERLINE=23, AT=24, 
		SHARP=25, DOLLAR=26, LR_BRACKET=27, RR_BRACKET=28, COMMA=29, SEMI=30, 
		COLON=31, STAR=32, DIVIDE=33, MODULE=34, PLUS=35, MINUS=36, BIT_NOT=37, 
		BIT_OR=38, BIT_AND=39, BIT_XOR=40, WS=41;
	public static final int
		RULE_sceneDeclaration = 0, RULE_sceneName = 1, RULE_method = 2, RULE_methodName = 3, 
		RULE_instruction = 4, RULE_parameters = 5, RULE_any_value = 6, RULE_digits = 7, 
		RULE_object3d = 8;
	public static final String[] ruleNames = {
		"sceneDeclaration", "sceneName", "method", "methodName", "instruction", 
		"parameters", "any_value", "digits", "object3d"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'scene'", null, null, "'='", null, "'{'", "'}'", null, null, "'>'", 
		"'<'", "'!'", "'+='", "'-='", "'*='", "'/='", "'%='", "'&='", "'^='", 
		"'|='", "'||'", "'.'", "'_'", "'@'", "'#'", "'$'", "'('", "')'", "','", 
		"';'", "':'", "'*'", "'/'", "'%'", "'+'", "'-'", "'~'", "'|'", "'&'", 
		"'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SCENE", "ID", "OBJECT3D", "EQUAL", "DIGITS", "L_CURLY_BRACE", "R_CURLY_BRACE", 
		"COMMENT", "LINE_COMMENT", "GREATER", "LESS", "EXCLAMATION", "PLUS_ASSIGN", 
		"MINUS_ASSIGN", "MULT_ASSIGN", "DIV_ASSIGN", "MOD_ASSIGN", "AND_ASSIGN", 
		"XOR_ASSIGN", "OR_ASSIGN", "DOUBLE_BAR", "DOT", "UNDERLINE", "AT", "SHARP", 
		"DOLLAR", "LR_BRACKET", "RR_BRACKET", "COMMA", "SEMI", "COLON", "STAR", 
		"DIVIDE", "MODULE", "PLUS", "MINUS", "BIT_NOT", "BIT_OR", "BIT_AND", "BIT_XOR", 
		"WS"
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

	@Override
	public String getGrammarFileName() { return "LangParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SceneDeclarationContext extends ParserRuleContext {
		public TerminalNode SCENE() { return getToken(LangParser.SCENE, 0); }
		public SceneNameContext sceneName() {
			return getRuleContext(SceneNameContext.class,0);
		}
		public TerminalNode L_CURLY_BRACE() { return getToken(LangParser.L_CURLY_BRACE, 0); }
		public TerminalNode R_CURLY_BRACE() { return getToken(LangParser.R_CURLY_BRACE, 0); }
		public List<Object3dContext> object3d() {
			return getRuleContexts(Object3dContext.class);
		}
		public Object3dContext object3d(int i) {
			return getRuleContext(Object3dContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public SceneDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sceneDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterSceneDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitSceneDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangParserVisitor ) return ((LangParserVisitor<? extends T>)visitor).visitSceneDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SceneDeclarationContext sceneDeclaration() throws RecognitionException {
		SceneDeclarationContext _localctx = new SceneDeclarationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sceneDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(SCENE);
			setState(19);
			sceneName();
			setState(20);
			match(L_CURLY_BRACE);
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID || _la==OBJECT3D) {
				{
				setState(23);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OBJECT3D:
					{
					setState(21);
					object3d();
					}
					break;
				case ID:
					{
					setState(22);
					method();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			match(R_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SceneNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public SceneNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sceneName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterSceneName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitSceneName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangParserVisitor ) return ((LangParserVisitor<? extends T>)visitor).visitSceneName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SceneNameContext sceneName() throws RecognitionException {
		SceneNameContext _localctx = new SceneNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sceneName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContext extends ParserRuleContext {
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public TerminalNode L_CURLY_BRACE() { return getToken(LangParser.L_CURLY_BRACE, 0); }
		public TerminalNode R_CURLY_BRACE() { return getToken(LangParser.R_CURLY_BRACE, 0); }
		public TerminalNode LR_BRACKET() { return getToken(LangParser.LR_BRACKET, 0); }
		public TerminalNode RR_BRACKET() { return getToken(LangParser.RR_BRACKET, 0); }
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangParserVisitor ) return ((LangParserVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			methodName();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LR_BRACKET) {
				{
				setState(33);
				match(LR_BRACKET);
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID || _la==DIGITS) {
					{
					setState(34);
					parameters();
					}
				}

				setState(37);
				match(RR_BRACKET);
				}
			}

			setState(40);
			match(L_CURLY_BRACE);
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(41);
				instruction();
				}
				}
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(46);
			match(R_CURLY_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public MethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterMethodName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitMethodName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangParserVisitor ) return ((LangParserVisitor<? extends T>)visitor).visitMethodName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodNameContext methodName() throws RecognitionException {
		MethodNameContext _localctx = new MethodNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_methodName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(48);
			match(ID);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangParserVisitor ) return ((LangParserVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<Any_valueContext> any_value() {
			return getRuleContexts(Any_valueContext.class);
		}
		public Any_valueContext any_value(int i) {
			return getRuleContext(Any_valueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LangParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangParserVisitor ) return ((LangParserVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameters);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(52);
					any_value();
					setState(53);
					match(COMMA);
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(60);
			any_value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Any_valueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LangParser.ID, 0); }
		public DigitsContext digits() {
			return getRuleContext(DigitsContext.class,0);
		}
		public Any_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterAny_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitAny_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangParserVisitor ) return ((LangParserVisitor<? extends T>)visitor).visitAny_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Any_valueContext any_value() throws RecognitionException {
		Any_valueContext _localctx = new Any_valueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_any_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(62);
				match(ID);
				}
				break;
			case DIGITS:
				{
				setState(63);
				digits();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DigitsContext extends ParserRuleContext {
		public TerminalNode DIGITS() { return getToken(LangParser.DIGITS, 0); }
		public DigitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digits; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterDigits(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitDigits(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangParserVisitor ) return ((LangParserVisitor<? extends T>)visitor).visitDigits(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DigitsContext digits() throws RecognitionException {
		DigitsContext _localctx = new DigitsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_digits);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(DIGITS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Object3dContext extends ParserRuleContext {
		public TerminalNode OBJECT3D() { return getToken(LangParser.OBJECT3D, 0); }
		public TerminalNode SEMI() { return getToken(LangParser.SEMI, 0); }
		public TerminalNode LR_BRACKET() { return getToken(LangParser.LR_BRACKET, 0); }
		public TerminalNode RR_BRACKET() { return getToken(LangParser.RR_BRACKET, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Object3dContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object3d; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).enterObject3d(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangParserListener ) ((LangParserListener)listener).exitObject3d(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangParserVisitor ) return ((LangParserVisitor<? extends T>)visitor).visitObject3d(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Object3dContext object3d() throws RecognitionException {
		Object3dContext _localctx = new Object3dContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_object3d);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(OBJECT3D);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LR_BRACKET) {
				{
				setState(69);
				match(LR_BRACKET);
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID || _la==DIGITS) {
					{
					setState(70);
					parameters();
					}
				}

				setState(73);
				match(RR_BRACKET);
				}
			}

			setState(76);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+Q\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2\3"+
		"\2\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\5\4&\n"+
		"\4\3\4\5\4)\n\4\3\4\3\4\6\4-\n\4\r\4\16\4.\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\7\7\7:\n\7\f\7\16\7=\13\7\3\7\3\7\3\b\3\b\5\bC\n\b\3\t\3\t\3\n"+
		"\3\n\3\n\5\nJ\n\n\3\n\5\nM\n\n\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22"+
		"\2\2\2P\2\24\3\2\2\2\4 \3\2\2\2\6\"\3\2\2\2\b\62\3\2\2\2\n\64\3\2\2\2"+
		"\f;\3\2\2\2\16B\3\2\2\2\20D\3\2\2\2\22F\3\2\2\2\24\25\7\3\2\2\25\26\5"+
		"\4\3\2\26\33\7\b\2\2\27\32\5\22\n\2\30\32\5\6\4\2\31\27\3\2\2\2\31\30"+
		"\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35\33"+
		"\3\2\2\2\36\37\7\t\2\2\37\3\3\2\2\2 !\7\4\2\2!\5\3\2\2\2\"(\5\b\5\2#%"+
		"\7\35\2\2$&\5\f\7\2%$\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\')\7\36\2\2(#\3\2\2"+
		"\2()\3\2\2\2)*\3\2\2\2*,\7\b\2\2+-\5\n\6\2,+\3\2\2\2-.\3\2\2\2.,\3\2\2"+
		"\2./\3\2\2\2/\60\3\2\2\2\60\61\7\t\2\2\61\7\3\2\2\2\62\63\7\4\2\2\63\t"+
		"\3\2\2\2\64\65\7\4\2\2\65\13\3\2\2\2\66\67\5\16\b\2\678\7\37\2\28:\3\2"+
		"\2\29\66\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\5"+
		"\16\b\2?\r\3\2\2\2@C\7\4\2\2AC\5\20\t\2B@\3\2\2\2BA\3\2\2\2C\17\3\2\2"+
		"\2DE\7\7\2\2E\21\3\2\2\2FL\7\5\2\2GI\7\35\2\2HJ\5\f\7\2IH\3\2\2\2IJ\3"+
		"\2\2\2JK\3\2\2\2KM\7\36\2\2LG\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7 \2\2O\23"+
		"\3\2\2\2\13\31\33%(.;BIL";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}