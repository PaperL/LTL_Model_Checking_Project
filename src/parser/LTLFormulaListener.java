// Generated from //wsl$/Ubuntu_20_04/home/paperlane/workspace/temp/MC/LTL_Model_Checking_Project/src/parser\LTLFormula.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LTLFormulaParser}.
 */
public interface LTLFormulaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code F_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterF_Formula(LTLFormulaParser.F_FormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code F_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitF_Formula(LTLFormulaParser.F_FormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code X_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterX_Formula(LTLFormulaParser.X_FormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code X_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitX_Formula(LTLFormulaParser.X_FormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterConstant(LTLFormulaParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitConstant(LTLFormulaParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And_Or_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAnd_Or_Formula(LTLFormulaParser.And_Or_FormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And_Or_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAnd_Or_Formula(LTLFormulaParser.And_Or_FormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Implication_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterImplication_Formula(LTLFormulaParser.Implication_FormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Implication_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitImplication_Formula(LTLFormulaParser.Implication_FormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atomic_Proposition}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAtomic_Proposition(LTLFormulaParser.Atomic_PropositionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atomic_Proposition}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAtomic_Proposition(LTLFormulaParser.Atomic_PropositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNot_Formula(LTLFormulaParser.Not_FormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNot_Formula(LTLFormulaParser.Not_FormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code G_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterG_Formula(LTLFormulaParser.G_FormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code G_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitG_Formula(LTLFormulaParser.G_FormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code U_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterU_Formula(LTLFormulaParser.U_FormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code U_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitU_Formula(LTLFormulaParser.U_FormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(LTLFormulaParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(LTLFormulaParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LTLFormulaParser#logicConstant}.
	 * @param ctx the parse tree
	 */
	void enterLogicConstant(LTLFormulaParser.LogicConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link LTLFormulaParser#logicConstant}.
	 * @param ctx the parse tree
	 */
	void exitLogicConstant(LTLFormulaParser.LogicConstantContext ctx);
}