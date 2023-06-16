package ltl.node;

import ltl.Elementary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

abstract public class FormulaNode {
    private Set<FormulaNode> closure = null;
    private Set<Elementary> elementarySet;

    @Override
    abstract public String toString();

    abstract public Set<FormulaNode> getChildren();

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FormulaNode && toString().equals(obj.toString());
    }

    public FormulaNode negation() {
        return (this instanceof NodeUnary && ((NodeUnary) this).op == NodeUnary.Genre.NEGATION)
                ? ((NodeUnary) this).node
                : new NodeUnary(NodeUnary.Genre.NEGATION, this);
    }

    public Set<FormulaNode> getClosure() {
        if (closure == null) {
            closure = new HashSet<>();
            closure.add(this);
            closure.add(this.negation());
            for (var child : getChildren())
                closure.addAll(child.getClosure());
        }
        return closure;
    }

    public Set<Elementary> getElementarySet() {
        if (this.elementarySet == null) {
            elementarySet = new HashSet<>();
            var containConstant = false;
            var closure = getClosure();
            final var trueNode = new NodeConstant(true);
            final var falseNode = new NodeConstant(false);
            if (closure.contains(trueNode)) {
                containConstant = true;
                closure.remove(trueNode);
                closure.remove(falseNode);
            }

            var formulas = new ArrayList<>(closure);
            int max = 1 << formulas.size();
            for (int i = 0; i < max; i++) {
                int mask = i;
                var B = new Elementary();
                for (var formula : formulas) {
                    if (mask % 2 == 1) B.add(formula);
                    mask >>= 1;
                }
                if (containConstant)
                    B.add(trueNode);
                if (B.check(closure, containConstant)) {
                    elementarySet.add(B);
                }
            }
        }
        return elementarySet;
    }

    public Set<FormulaNode> getAPSet() {
        var apSet = new HashSet<FormulaNode>();
        var closure = getClosure();
        for (var formula : closure)
            if (formula instanceof NodeAP)
                apSet.add(formula);
        return apSet;
    }
}
