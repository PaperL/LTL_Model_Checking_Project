// Generated from //wsl$/Ubuntu_20_04/home/paperlane/workspace/temp/MC/LTL_Model_Checking_Project/src/parser\LTLFormula.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LTLFormulaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LTLFormulaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code F_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF_Formula(LTLFormulaParser.F_FormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code X_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX_Formula(LTLFormulaParser.X_FormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Constant}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(LTLFormulaParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And_Or_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_Or_Formula(LTLFormulaParser.And_Or_FormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Implication_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplication_Formula(LTLFormulaParser.Implication_FormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Atomic_Proposition}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomic_Proposition(LTLFormulaParser.Atomic_PropositionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_Formula(LTLFormulaParser.Not_FormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code G_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG_Formula(LTLFormulaParser.G_FormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code U_Formula}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitU_Formula(LTLFormulaParser.U_FormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link LTLFormulaParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(LTLFormulaParser.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LTLFormulaParser#logicConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicConstant(LTLFormulaParser.LogicConstantContext ctx);
}