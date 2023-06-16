package ba;

import ltl.node.FormulaNode;
import ltl.node.NodeAP;
import ts.Proposition;

import java.util.HashSet;
import java.util.Set;

public class Symbol {
    public final APSubset apSubset;

    public Symbol(Set<Proposition> ap) {
        Set<FormulaNode> apNodes = new HashSet<>();
        for (var p : ap)
            apNodes.add(new NodeAP(p.name));
        apSubset = new APSubset(apNodes);
    }

    public Symbol(APSubset subset) {
        apSubset = subset;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Symbol) {
            return apSubset.equals(((Symbol) obj).apSubset);
        } else return false;
    }

    @Override
    public String toString() {
        return apSubset.toString();
    }
}
