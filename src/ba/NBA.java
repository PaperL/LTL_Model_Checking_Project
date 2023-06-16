package ba;

import ltl.node.FormulaNode;
import org.antlr.v4.runtime.misc.Pair;
import ts.Proposition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NBA extends BA {
    public final Set<State> F = new HashSet<>();
    private final Map<Pair<State, Integer>, State> stateMap = new HashMap<>();
    private final Set<FormulaNode> APSet;

    public NBA(GNBA gnba) {
        APSet = gnba.APSet;
        int k = gnba.F.size();
        alphabet.addAll(gnba.alphabet);
        for (var gnbaState : gnba.states)
            for (var i = 0; i < k; i++) {
                var pair = new Pair<>(gnbaState, i);
                var state = new State(String.format("(%s, %d)", gnbaState, i));
                if (i == 0 && gnbaState.initial) state.set_initial();
                stateMap.put(pair, state);
                states.add(state);
            }
        // Accept Condition
        for (State gnbaState : gnba.F.get(0)) {
            var pair = new Pair<>(gnbaState, 0);
            F.add(stateMap.get(pair));
        }
        // Delta
        for (var gnbaState : gnba.states) {
            Map<Symbol, Set<State>> QDelta = gnba.delta.get(gnbaState);
            for (var i = 0; i < k; i++) {
                var start = stateMap.get(new Pair<>(gnbaState, i));
                for (var symbol : QDelta.keySet())
                    for (State qPrime : QDelta.get(symbol)) {
                        var end = stateMap.get(
                                new Pair<>(qPrime,
                                        !gnba.F.get(i).contains(gnbaState) ? i : (i + 1) % k));
                        addDelta(start, end, symbol);
                    }
            }
        }
        // Evaluate
//        System.out.println("--------------------------");
//        System.out.println(F);
//        System.out.println(stateMap);
//        System.out.println(APSet);
//        System.out.println(states);
//        System.out.println(alphabet);
//        System.out.println(delta);
//        System.out.println("==========================");
    }

    public Set<State> getTargets(State start, Set<Proposition> L) {
        Map<Symbol, Set<State>> deltaMap = delta.get(start);
        var symbol = new Symbol(L);
        symbol.apSubset.retainAll(APSet);
        var tmp = symbol;
        for (var s : alphabet)
            if (s.equals(symbol)) {
                tmp = s;
                break;
            }
        return deltaMap.get(tmp);
    }
}
