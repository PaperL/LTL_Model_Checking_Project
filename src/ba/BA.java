package ba;

import java.util.*;

abstract public class BA {
    protected final ArrayList<State> states = new ArrayList<>();
    protected final ArrayList<Symbol> alphabet = new ArrayList<>();
    protected final Map<State, Map<Symbol, Set<State>>> delta = new HashMap<>();

    public void addDelta(State start, State end, Symbol symbol) {
        if (delta.containsKey(start)) {
            Map<Symbol, Set<State>> map = delta.get(start);
            if (map.containsKey(symbol))
                map.get(symbol).add(end);
            else {
                var stateList = new HashSet<State>();
                stateList.add(end);
                map.put(symbol, stateList);
            }
        } else {
            var stateList = new HashSet<State>();
            stateList.add(end);
            var map = new HashMap<Symbol, Set<State>>();
            map.put(symbol, stateList);
            delta.put(start, map);
        }
    }
}
