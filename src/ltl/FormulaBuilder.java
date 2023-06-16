package ltl;

import ltl.node.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.LTLFormulaBaseVisitor;
import parser.LTLFormulaLexer;
import parser.LTLFormulaParser;

import java.util.HashMap;

public class FormulaBuilder extends LTLFormulaBaseVisitor<FormulaNode> {

    private HashMap<String, NodeAP> apMap = new HashMap<>();

    public FormulaNode buildFormula(String str) {
//        System.out.println(str);
        var lexer = new LTLFormulaLexer(CharStreams.fromString(str));
        var tokens = new CommonTokenStream(lexer);
        var parser = new LTLFormulaParser(tokens);
        var formula = parser.formula();
//        System.out.println(formula.toStringTree(parser));
//        System.out.println(ret);
        return visit(formula);
    }

    @Override
    public FormulaNode visitParentheses(LTLFormulaParser.ParenthesesContext ctx) {
        return visit(ctx.formula());
    }

    @Override
    public FormulaNode visitAtomic_Proposition(LTLFormulaParser.Atomic_PropositionContext ctx) {
//        System.out.println('<'+ctx.Atomic().getText()+'>');
        var c = ctx.Atomic().getText();
        NodeAP node = apMap.get(c);    // Single lowercase English letter ([a-z])
        if (node == null) {
            node = new NodeAP(c);
            apMap.put(c, node);
        }
        return node;
    }

    @Override
    public FormulaNode visitConstant(LTLFormulaParser.ConstantContext ctx) {
        return new NodeConstant(ctx.logicConstant().True() != null);
    }

    @Override
    public FormulaNode visitAnd_Or_Formula(LTLFormulaParser.And_Or_FormulaContext ctx) {
        return ctx.AndOp() != null
                ? new NodeBinary(NodeBinary.Genre.CONJUNCTION, visit(ctx.lFormula), visit(ctx.rFormula))
                : (new NodeBinary(NodeBinary.Genre.CONJUNCTION,
                visit(ctx.lFormula).negation(), visit(ctx.rFormula).negation())).negation();
    }

    @Override
    public FormulaNode visitImplication_Formula(LTLFormulaParser.Implication_FormulaContext ctx) {
//        return new NodeBinary(
//                NodeBinary.Genre.IMPLICATION,
//                visit(ctx.lFormula), visit(ctx.rFormula)
//        );
        return new NodeBinary(NodeBinary.Genre.CONJUNCTION,
                visit(ctx.lFormula),
                visit(ctx.rFormula).negation()
        ).negation();
    }

    @Override
    public FormulaNode visitU_Formula(LTLFormulaParser.U_FormulaContext ctx) {
        return new NodeBinary(
                NodeBinary.Genre.UNTIL,
                visit(ctx.lFormula), visit(ctx.rFormula)
        );
    }

    @Override
    public FormulaNode visitNot_Formula(LTLFormulaParser.Not_FormulaContext ctx) {
        return new NodeUnary(NodeUnary.Genre.NEGATION, visit(ctx.formula()));
    }

    @Override
    public FormulaNode visitG_Formula(LTLFormulaParser.G_FormulaContext ctx) {
//        return new NodeUnary(NodeUnary.Genre.ALWAYS, visit(ctx.formula()));
        return new NodeBinary(NodeBinary.Genre.UNTIL,
                new NodeConstant(true),
                visit(ctx.formula()).negation()
        ).negation();
    }

    @Override
    public FormulaNode visitF_Formula(LTLFormulaParser.F_FormulaContext ctx) {
//        return new NodeUnary(NodeUnary.Genre.EVENTUALLY, visit(ctx.formula()));
        return new NodeBinary(NodeBinary.Genre.UNTIL,
                new NodeConstant(true),
                visit(ctx.formula())
        );
    }

    @Override
    public FormulaNode visitX_Formula(LTLFormulaParser.X_FormulaContext ctx) {
        return new NodeUnary(NodeUnary.Genre.NEXT, visit(ctx.formula()));
    }
}
