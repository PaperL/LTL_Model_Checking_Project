package ts;

import ba.NBA;
import org.antlr.v4.runtime.misc.Pair;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Transition System
 */
public class TS {
    public final ArrayList<State> states = new ArrayList<>();
    public final ArrayList<Act> acts = new ArrayList<>();
    public final Map<State, Map<State, Set<Act>>> transitions = new HashMap<>();
    public final ArrayList<Proposition> propositions = new ArrayList<>();
    public final Map<State, Set<Proposition>> L = new HashMap<>();

    public final Set<State> acceptingStateSet = new HashSet<>();

    /**
     * Read data from file in given format
     *
     * @param inputFilePath
     */
    public TS(String inputFilePath) {
        Scanner scn = null;
        try {
            scn = new Scanner(new FileInputStream(inputFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert scn != null;
        // * Line 1
        var NS = scn.nextInt();     // Number of States
        IntStream.range(0, NS).mapToObj(i ->
                new State("s" + i)).forEach(states::add);
        var NT = scn.nextInt();     // Number of Transitions
        scn.nextLine();
        // * Line 2
        String[] initStateStrs = scn.nextLine().split(" ");
        for (var initStatStr : initStateStrs)
            states.get(Integer.parseInt(initStatStr)).set_initial();
        // * Line 3
        String[] actStrs = scn.nextLine().split(" ");
        for (var actStr : actStrs)
            acts.add(new Act("alpha" + actStr));
        // * Line 4
        String[] propositionStrs = scn.nextLine().split(" ");
        for (var propositionStr : propositionStrs)
            propositions.add(new Proposition(propositionStr));
        // * NT Lines
//        System.out.println(states);
//        System.out.println(acts);
        for (var i = 0; i < NT; i++) {
            int start = scn.nextInt(),
                    act = scn.nextInt(),
                    end = scn.nextInt();
            this.addTransition(
                    states.get(start),
                    states.get(end),
                    acts.get(act));
        }
        scn.nextLine();
        // * NS Lines
        for (var i = 0; i < NS; i++) {
            propositionStrs = scn.nextLine().split(" ");
            var propositionSet = new HashSet<Proposition>();
            for (var propositionStr : propositionStrs)
                propositionSet.add(
                        propositions.get(Integer.parseInt(propositionStr)));
            L.put(states.get(i), propositionSet);
//            System.out.println("<<"+L+">>");
        }

    }

    private void addTransition(State start, State end, Act act) {
        if (transitions.containsKey(start)) {
            var map = transitions.get(start);
            if (map.containsKey(end))
                map.get(end).add(act);
            else {
                var actSet = new HashSet<Act>();
                actSet.add(act);
                map.put(end, actSet);
            }
        } else {
            var acts = new HashSet<Act>();
            acts.add(act);
            var transition = new HashMap<State, Set<Act>>();
            transition.put(end, acts);
            transitions.put(start, transition);
        }
    }


    // Product and Persistence Check
    Set<State> R = new HashSet<>(), T = new HashSet<>();
    Stack<State> U = new Stack<>(), V = new Stack<>();
    boolean cycleFound = false;


    public TS(TS ts, NBA nba) { //Construct by Product
        var stateMap = new HashMap<Pair<State, ba.State>, State>();
        //AP
        var propositionMap = new HashMap<ba.State, Proposition>();
        for (var q : nba.states) {
            var prop = new Proposition(q.name + "_AP'");
            propositionMap.put(q, prop);
            propositions.add(prop);
        }
        //States and initial states and L
        for (var s : ts.states) {
            for (var q : nba.states) {
                var state = new State(String.format("<%s, %s>", s, q));
                states.add(state);
                stateMap.put(new Pair<>(s, q), state);
                var l = new HashSet<Proposition>();
                l.add(propositionMap.get(q));
                L.put(state, l);
                if (s.initial) {
                    for (var q0 : nba.states)
                        if (q0.initial) {
                            var targetSet = nba.getTargets(q0, ts.L.get(s));
                            if (targetSet != null && targetSet.contains(q)) {
                                state.set_initial();
                                break;
                            }
                        }
                }
                if (nba.F.contains(q)) acceptingStateSet.add(state);
            }
        }
        //Acts
        acts.addAll(ts.acts);
        //Transition
        for (var state : ts.states) {
            Map<State, Set<Act>> targetMap = ts.transitions.get(state);
            if (targetMap != null) {
                for (State t : targetMap.keySet()) {
                    Set<Act> acts = targetMap.get(t);
                    for (var q : nba.states) {
                        var start = stateMap.get(new Pair<>(state, q));
                        var targets = nba.getTargets(q, ts.L.get(t));
                        if (targets != null) {
                            for (var p : targets) {
                                State end = stateMap.get(new Pair<>(t, p));
                                for (var act : acts) addTransition(start, end, act);
                            }
                        }
                    }
                }
            }
        }
//        System.out.println("++++++++++++++++++++++");
//        System.out.println(states);
//        System.out.println(acts);
//        System.out.println(new TreeMap<>(transitions));
//        System.out.println(propositions);
//        System.out.println(new TreeMap<>(L));
//        System.out.println(new TreeSet<>(acceptingStateSet));
//        System.out.println("^^^^^^^^^^^^^^^^^^^^^^");
    }

    public void cycleCheck(State s) {
        V.push(s);
        T.add(s);
        do {
            State s1 = V.peek();
            if (transitions.get(s1) != null && transitions.get(s1).containsKey(s)) {
                cycleFound = true;
                V.push(s);
            } else {
                if (transitions.get(s1) == null) {
                    V.pop();
                } else {
                    Set<State> post = new HashSet<>(transitions.get(s1).keySet());
                    post.removeAll(T);
                    if (!post.isEmpty()) {
                        for (State s2 : post) {
                            V.push(s2);
                            T.add(s2);
                            break;
                        }
                    } else {
                        V.pop();
                    }
                }
            }
        } while (!(V.empty() || cycleFound));
    }

    public void reachableCycle(State s) {
        U.push(s);
        R.add(s);
        do {
            var s1 = U.peek();
            if (transitions.get(s1) == null) {
                U.pop();
                if (acceptingStateSet.contains(s1)) cycleCheck(s1);
            } else {
                var post = new HashSet<>(transitions.get(s1).keySet());
                post.removeAll(R);
                if (!post.isEmpty()) {
                    for (State s2 : post) {
                        U.push(s2);
                        R.add(s2);
                        break;
                    }
                } else {
                    U.pop();
                    if (acceptingStateSet.contains(s1)) cycleCheck(s1);
                }
            }
        } while (!(U.empty() || cycleFound));
    }

    public boolean persistenceCheck() {
        var initialSet = new HashSet<State>();
        for (State s : states)
            if (s.initial) initialSet.add(s);
        var delta = new HashSet<>(initialSet);
        delta.removeAll(R);
        while ((!delta.isEmpty()) && (!cycleFound)) {
            for (var s : delta) {
                reachableCycle(s);
                break;
            }
            delta.removeAll(R);
        }
        return !cycleFound;
    }

}
