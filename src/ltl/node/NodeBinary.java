package ltl.node;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NodeBinary extends FormulaNode {

    public enum Genre {
        CONJUNCTION("/\\"),
        DISJUNCTION("\\/"),
        UNTIL("U"),
        IMPLICATION("->");

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
    public FormulaNode nodeL;
    public FormulaNode nodeR;

    public NodeBinary(Genre op, FormulaNode nodeL, FormulaNode nodeR) {
        this.op = op;
        this.nodeL = nodeL;
        this.nodeR = nodeR;
    }

    @Override
    public String toString() {
        return String.format("(%s %s %s)", nodeL, op, nodeR);
    }

    @Override
    public Set<FormulaNode> getChildren() {
        return new HashSet<>(Arrays.asList(nodeL, nodeR));
    }
}
