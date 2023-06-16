package ts;

import ltl.node.NodeAP;

public class Proposition implements Comparable<Proposition> {

    public String name;

    public Proposition(String string) {
        name = string;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NodeAP)
            return name.equals(((NodeAP) obj).name);
        else if (obj instanceof Proposition)
            return name.equals(((Proposition) obj).name);
        else return false;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Proposition other) {
        return this.name.compareTo(other.name);
    }
}
