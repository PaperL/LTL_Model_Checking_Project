package ltl;

import ltl.node.FormulaNode;
import ltl.node.NodeBinary;
import ltl.node.NodeConstant;

import java.util.HashSet;
import java.util.Set;

public class Elementary {
    public final Set<FormulaNode> elementarySet = new HashSet<>();

    public boolean add(FormulaNode formula) {
        return elementarySet.add(formula);
    }

    public boolean contains(FormulaNode formula) {
        return elementarySet.contains(formula);
    }

    @Override
    public boolean equals(Object rhs) {
        if (rhs instanceof Elementary) {
            return elementarySet.toString().equals(elementarySet.toString());
        } else
            return false;
    }

    @Override
    public int hashCode() {
        return elementarySet.toString().hashCode();
    }

    @Override
    public String toString() {
        return elementarySet.toString();
    }


    public boolean check(Set<FormulaNode> closure, boolean containConstant) {
        if (containConstant && !elementarySet.contains(new NodeConstant(true)))
            return false;
        for (var formula : elementarySet) {
            if ((formula instanceof NodeBinary)
                    && ((NodeBinary) formula).op == NodeBinary.Genre.CONJUNCTION) {
                if ((!elementarySet.contains(((NodeBinary) formula).nodeL))
                        || (!elementarySet.contains(((NodeBinary) formula).nodeR)))
                    return false;
            } else if ((formula.negation() instanceof NodeBinary)
                    && ((NodeBinary) formula.negation()).op == NodeBinary.Genre.CONJUNCTION) {
                if (elementarySet.contains(((NodeBinary) formula.negation()).nodeL)
                        && elementarySet.contains(((NodeBinary) formula.negation()).nodeR))
                    return false;
            } else if (elementarySet.contains(formula.negation()))
                return false;
        }
        for (var formula : closure) {
            if ((formula instanceof NodeBinary)
                    && ((NodeBinary) formula).op == NodeBinary.Genre.UNTIL) {
                if (elementarySet.contains(((NodeBinary) formula).nodeR)) {
                    if (!elementarySet.contains(formula))
                        return false;
                } else if (elementarySet.contains(formula)) {
                    if (!elementarySet.contains(((NodeBinary) formula).nodeL))
                        return false;
                }
            }
            if ((!elementarySet.contains(formula)) && (!elementarySet.contains(formula.negation()))) {
                return false;
            }
        }
        return true;
    }
}
