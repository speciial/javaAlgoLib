package io.github.speciial.graph;

import java.util.Objects;

public class Node {

    private final int name;

    public Node(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return name == node.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + "";
    }
}
