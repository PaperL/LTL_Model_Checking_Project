// Generated from //wsl$/Ubuntu_20_04/home/paperlane/workspace/temp/MC/LTL_Model_Checking_Project/src/parser\LTLFormula.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LTLFormulaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, AndOp=9, 
		OrOp=10, True=11, False=12, Atomic=13, WHITE_SPACE=14;
	public static final int
		RULE_formula = 0, RULE_logicConstant = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"formula", "logicConstant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'->'", "'U'", "'!'", "'G'", "'F'", "'X'", "'/\\'", 
			"'\\/'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "AndOp", "OrOp", 
			"True", "False", "Atomic", "WHITE_SPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "LTLFormula.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LTLFormulaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormulaContext extends ParserRuleContext {
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class F_FormulaContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public F_FormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).enterF_Formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).exitF_Formula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLFormulaVisitor ) return ((LTLFormulaVisitor<? extends T>)visitor).visitF_Formula(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class X_FormulaContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public X_FormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).enterX_Formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).exitX_Formula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLFormulaVisitor ) return ((LTLFormulaVisitor<? extends T>)visitor).visitX_Formula(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends FormulaContext {
		public LogicConstantContext logicConstant() {
			return getRuleContext(LogicConstantContext.class,0);
		}
		public ConstantContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLFormulaVisitor ) return ((LTLFormulaVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class And_Or_FormulaContext extends FormulaContext {
		public FormulaContext lFormula;
		public Token op;
		public FormulaContext rFormula;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode AndOp() { return getToken(LTLFormulaParser.AndOp, 0); }
		public TerminalNode OrOp() { return getToken(LTLFormulaParser.OrOp, 0); }
		public And_Or_FormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).enterAnd_Or_Formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).exitAnd_Or_Formula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLFormulaVisitor ) return ((LTLFormulaVisitor<? extends T>)visitor).visitAnd_Or_Formula(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Implication_FormulaContext extends FormulaContext {
		public FormulaContext lFormula;
		public FormulaContext rFormula;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public Implication_FormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).enterImplication_Formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).exitImplication_Formula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLFormulaVisitor ) return ((LTLFormulaVisitor<? extends T>)visitor).visitImplication_Formula(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Atomic_PropositionContext extends FormulaContext {
		public TerminalNode Atomic() { return getToken(LTLFormulaParser.Atomic, 0); }
		public Atomic_PropositionContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).enterAtomic_Proposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).exitAtomic_Proposition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLFormulaVisitor ) return ((LTLFormulaVisitor<? extends T>)visitor).visitAtomic_Proposition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Not_FormulaContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public Not_FormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).enterNot_Formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).exitNot_Formula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLFormulaVisitor ) return ((LTLFormulaVisitor<? extends T>)visitor).visitNot_Formula(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class G_FormulaContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public G_FormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).enterG_Formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).exitG_Formula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLFormulaVisitor ) return ((LTLFormulaVisitor<? extends T>)visitor).visitG_Formula(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class U_FormulaContext extends FormulaContext {
		public FormulaContext lFormula;
		public FormulaContext rFormula;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public U_FormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).enterU_Formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).exitU_Formula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLFormulaVisitor ) return ((LTLFormulaVisitor<? extends T>)visitor).visitU_Formula(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesesContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ParenthesesContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).enterParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).exitParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLFormulaVisitor ) return ((LTLFormulaVisitor<? extends T>)visitor).visitParentheses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				_localctx = new ParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(5);
				match(T__0);
				setState(6);
				formula(0);
				setState(7);
				match(T__1);
				}
				break;
			case Atomic:
				{
				_localctx = new Atomic_PropositionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(9);
				match(Atomic);
				}
				break;
			case True:
			case False:
				{
				_localctx = new ConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(10);
				logicConstant();
				}
				break;
			case T__4:
				{
				_localctx = new Not_FormulaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(11);
				match(T__4);
				setState(12);
				formula(4);
				}
				break;
			case T__5:
				{
				_localctx = new G_FormulaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(13);
				match(T__5);
				setState(14);
				formula(3);
				}
				break;
			case T__6:
				{
				_localctx = new F_FormulaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(15);
				match(T__6);
				setState(16);
				formula(2);
				}
				break;
			case T__7:
				{
				_localctx = new X_FormulaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(17);
				match(T__7);
				setState(18);
				formula(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(32);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(30);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new And_Or_FormulaContext(new FormulaContext(_parentctx, _parentState));
						((And_Or_FormulaContext)_localctx).lFormula = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(21);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(22);
						((And_Or_FormulaContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AndOp || _la==OrOp) ) {
							((And_Or_FormulaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(23);
						((And_Or_FormulaContext)_localctx).rFormula = formula(8);
						}
						break;
					case 2:
						{
						_localctx = new Implication_FormulaContext(new FormulaContext(_parentctx, _parentState));
						((Implication_FormulaContext)_localctx).lFormula = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(24);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(25);
						match(T__2);
						setState(26);
						((Implication_FormulaContext)_localctx).rFormula = formula(7);
						}
						break;
					case 3:
						{
						_localctx = new U_FormulaContext(new FormulaContext(_parentctx, _parentState));
						((U_FormulaContext)_localctx).lFormula = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(27);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(28);
						match(T__3);
						setState(29);
						((U_FormulaContext)_localctx).rFormula = formula(6);
						}
						break;
					}
					} 
				}
				setState(34);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicConstantContext extends ParserRuleContext {
		public TerminalNode True() { return getToken(LTLFormulaParser.True, 0); }
		public TerminalNode False() { return getToken(LTLFormulaParser.False, 0); }
		public LogicConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).enterLogicConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTLFormulaListener ) ((LTLFormulaListener)listener).exitLogicConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LTLFormulaVisitor ) return ((LTLFormulaVisitor<? extends T>)visitor).visitLogicConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicConstantContext logicConstant() throws RecognitionException {
		LogicConstantContext _localctx = new LogicConstantContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_logicConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_la = _input.LA(1);
			if ( !(_la==True || _la==False) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000e&\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0003\u0000\u0014\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0005\u0000\u001f\b\u0000\n\u0000\f\u0000\"\t\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0002\u0000\u0002"+
		"\u0000\u0002\u0001\u0000\t\n\u0001\u0000\u000b\f,\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0002#\u0001\u0000\u0000\u0000\u0004\u0005\u0006\u0000\uffff"+
		"\uffff\u0000\u0005\u0006\u0005\u0001\u0000\u0000\u0006\u0007\u0003\u0000"+
		"\u0000\u0000\u0007\b\u0005\u0002\u0000\u0000\b\u0014\u0001\u0000\u0000"+
		"\u0000\t\u0014\u0005\r\u0000\u0000\n\u0014\u0003\u0002\u0001\u0000\u000b"+
		"\f\u0005\u0005\u0000\u0000\f\u0014\u0003\u0000\u0000\u0004\r\u000e\u0005"+
		"\u0006\u0000\u0000\u000e\u0014\u0003\u0000\u0000\u0003\u000f\u0010\u0005"+
		"\u0007\u0000\u0000\u0010\u0014\u0003\u0000\u0000\u0002\u0011\u0012\u0005"+
		"\b\u0000\u0000\u0012\u0014\u0003\u0000\u0000\u0001\u0013\u0004\u0001\u0000"+
		"\u0000\u0000\u0013\t\u0001\u0000\u0000\u0000\u0013\n\u0001\u0000\u0000"+
		"\u0000\u0013\u000b\u0001\u0000\u0000\u0000\u0013\r\u0001\u0000\u0000\u0000"+
		"\u0013\u000f\u0001\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000"+
		"\u0014 \u0001\u0000\u0000\u0000\u0015\u0016\n\u0007\u0000\u0000\u0016"+
		"\u0017\u0007\u0000\u0000\u0000\u0017\u001f\u0003\u0000\u0000\b\u0018\u0019"+
		"\n\u0006\u0000\u0000\u0019\u001a\u0005\u0003\u0000\u0000\u001a\u001f\u0003"+
		"\u0000\u0000\u0007\u001b\u001c\n\u0005\u0000\u0000\u001c\u001d\u0005\u0004"+
		"\u0000\u0000\u001d\u001f\u0003\u0000\u0000\u0006\u001e\u0015\u0001\u0000"+
		"\u0000\u0000\u001e\u0018\u0001\u0000\u0000\u0000\u001e\u001b\u0001\u0000"+
		"\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000"+
		"\u0000 !\u0001\u0000\u0000\u0000!\u0001\u0001\u0000\u0000\u0000\" \u0001"+
		"\u0000\u0000\u0000#$\u0007\u0001\u0000\u0000$\u0003\u0001\u0000\u0000"+
		"\u0000\u0003\u0013\u001e ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}