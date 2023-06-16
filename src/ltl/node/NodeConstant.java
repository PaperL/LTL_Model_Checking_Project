package ltl.node;

import java.util.HashSet;
import java.util.Set;

public class NodeConstant extends FormulaNode{

    private boolean constant = true;

    public NodeConstant(boolean constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return Boolean.toString(constant);
    }

    @Override
    public Set<FormulaNode> getChildren() {
        return new HashSet<>();
    }
}
