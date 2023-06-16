package ts;

public class State implements Comparable<State> {
    private final String name;
    public boolean initial = false;

    public State(String string) {
        name = string;
    }

    public void set_initial() {
        this.initial = true;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(State other) {
        return this.name.compareTo(other.name);
    }
}
