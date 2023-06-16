package ts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Transition System
 */
public class TS {
    public final ArrayList<State> states = new ArrayList<>();
    private final ArrayList<Act> acts = new ArrayList<>();
    private final Map<State, Map<State, Set<Act>>> transitions = new HashMap<>();
    private final ArrayList<Proposition> propositions = new ArrayList<>();
    private final Map<State, Set<Proposition>> L = new HashMap<>();

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
}
