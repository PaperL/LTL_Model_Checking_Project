package ltl.node;

import java.util.HashSet;
import java.util.Set;

public class NodeAP extends FormulaNode {
    private String name;

    public NodeAP(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Set<FormulaNode> getChildren() {
        return new HashSet<>();
    }
}
