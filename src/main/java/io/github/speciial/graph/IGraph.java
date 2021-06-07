package io.github.speciial.graph;

import java.util.LinkedList;

public interface IGraph {

    int V();
    int E();

    void addEdge(int node1, int node2, double value);
    LinkedList<Edge> getAjd(int node);

}
