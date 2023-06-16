package ba;

import ltl.Elementary;
import ltl.node.FormulaNode;
import ltl.node.NodeBinary;
import ltl.node.NodeUnary;

import java.util.*;

public class GNBA extends BA {
    private final ArrayList<Set<State>> F = new ArrayList<>();
    private final Map<Elementary, State> stateMap = new HashMap<>();
    private final Map<APSubset, Symbol> symbolMap = new HashMap<>();
    private final Set<FormulaNode> APSet;

    public GNBA(FormulaNode node) {
        Set<Elementary> elementarySet = node.getElementarySet();
        Set<FormulaNode> closure = node.getClosure();
        APSet = node.getAPSet();
        // States Q
        int num = 0;
        for (Elementary elementary : elementarySet) {
            State state = new State(String.format("GS%d:%s", num, elementary));
            num++;
            if (elementary.contains(node)) state.set_initial();
            states.add(state);
            stateMap.put(elementary, state);
        }
        // Accepting Condition F
        for (var formula : closure) {
            if ((formula instanceof NodeBinary)
                    && (((NodeBinary) formula).op == NodeBinary.Genre.UNTIL)) {
                var fFormula = new HashSet<State>();
                for (var elementary : elementarySet) {
                    if (!(elementary.contains(formula) && (!elementary.contains(((NodeBinary) formula).nodeR))))
                        fFormula.add(stateMap.get(elementary));
                }
                F.add(fFormula);
            }
        }
        if (F.isEmpty()) {
            var fFormula = new HashSet<State>();
            for (var elementary : elementarySet)
                fFormula.add(stateMap.get(elementary));
            F.add(fFormula);
        }
        // Alphabet σ
        int max = 1 << APSet.size();
        Set<APSubset> powerAP = new HashSet<>();
        for (int i = 0; i < max; i++) {
            int mask = i;
            APSubset A = new APSubset(new HashSet<>());
            for (FormulaNode ap : APSet) {
                if (mask % 2 == 1) {
                    A.add(ap);
                }
                mask /= 2;
            }
            powerAP.add(A);
            Symbol symbol = new Symbol(A);
            symbolMap.put(A, symbol);
            alphabet.add(symbol);   // Add Symbol
        }
        // Delta
        for (var B : elementarySet) {
            State start = stateMap.get(B);
            var A = new APSubset(B.elementarySet);
            A.retainAll(APSet);
            var symbol = symbolMap.get(A);
            for (var BPrime : elementarySet) {
                boolean flag = true;
                State end = stateMap.get(BPrime);
                for (var formula : closure) {
                    if ((formula instanceof NodeUnary)
                            && ((NodeUnary) formula).op == NodeUnary.Genre.NEXT) {
                        if ((B.contains(formula) && !BPrime.contains(((NodeUnary) formula).node))
                                || (BPrime.contains(((NodeUnary) formula).node) && !B.contains(formula))) {
                            flag = false;
                            break;
                        }
                    } else if ((formula instanceof NodeBinary)
                            && ((NodeBinary) formula).op == NodeBinary.Genre.UNTIL) {
                        if (
                                (B.contains(formula) &&
                                        !(B.contains(((NodeBinary) formula).nodeR)
                                                || (B.contains(((NodeBinary) formula).nodeL) && BPrime.contains(formula)))
                                )
                                        ||
                                        (!B.contains(formula) &&
                                                (B.contains(((NodeBinary) formula).nodeR)
                                                        || (B.contains(((NodeBinary) formula).nodeL) && BPrime.contains(formula)))
                                        )
                        ) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    addDelta(start, end, symbol);
                }
            }
        }
        // Evaluate
//        System.out.println("--------------------------");
//        System.out.println(F);
//        System.out.println(stateMap);
//        System.out.println(symbolMap);
//        System.out.println(APSet);
//        System.out.println(states);
//        System.out.println(alphabet);
//        System.out.println(delta);
//        System.out.println("==========================");
    }
}
