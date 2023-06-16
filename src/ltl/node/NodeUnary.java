package ltl.node;

import java.util.HashSet;
import java.util.Set;

public class NodeUnary extends FormulaNode {

    public enum Genre {
        NEGATION("!"),
        NEXT("X"),
        EVENTUALLY("F"),
        ALWAYS("G");

        private final String str;

        Genre(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return str;
        }
    }

    public Genre op;
    public FormulaNode node;

    public NodeUnary(Genre op, FormulaNode node) {
        this.op = op;
        this.node = node;
    }

    @Override
    public String toString() {
        return String.format("(%s%s)", op, node);
    }

    @Override
    public Set<FormulaNode> getChildren() {
        var ret = new HashSet<FormulaNode>();
        ret.add(node);
        return ret;
    }
}
