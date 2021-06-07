package io.github.speciial.graph;

import java.util.Objects;

public class Edge implements Comparable<Edge>{

    private final Node node1;
    private final Node node2;

    private final double weight;

    public Edge(Node node1, Node node2, double weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Double.compare(edge.weight, weight) == 0 && Objects.equals(node1, edge.node1) && Objects.equals(node2, edge.node2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node1, node2, weight);
    }

    @Override
    public String toString() {
        return node1 + " " + node2 + " " + weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.weight, other.weight);
    }
}
