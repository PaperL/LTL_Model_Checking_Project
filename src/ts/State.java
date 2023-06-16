package ts;

public class State {
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
}
