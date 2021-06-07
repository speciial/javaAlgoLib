package io.github.speciial.graph.shortestpath;

import io.github.speciial.graph.Digraph;
import io.github.speciial.graph.Edge;
import io.github.speciial.util.IndexedMinPriorityQueue;

public class Dijkstra {

    private final double[] distances;
    private final int[] predecessors;

    public Dijkstra(Digraph graph, int start) {
        distances = new double[graph.V()];
        predecessors = new int[graph.V()];

        initializeSingleSource(graph, start);

        IndexedMinPriorityQueue Q = new IndexedMinPriorityQueue(graph.V());
        for (int i = 0; i < graph.V(); i++) {
            Q.insert(i, distances[i]);
        }

        while (!Q.isEmpty()) {
            int u = Q.extract();
            for(Edge edge : graph.getAjd(u)) {
                relax(Q, edge);
            }
        }

        System.out.println("All Shortest Paths: ");
        for (int i = 0; i < graph.V(); i++) {
            // TODO: display the shortest paths
            System.out.println(start + " to " + i + ": " + distances[i]);
        }
    }

    private void initializeSingleSource(Digraph graph, int start) {
        for(int i = 0; i < graph.V(); i++) {
            distances[i] = Double.POSITIVE_INFINITY;
            predecessors[i] = -1;
        }
        distances[start] = 0.0;
    }

    private void relax(IndexedMinPriorityQueue Q, Edge edge) {
        int u = edge.getNode1().getName();
        int v = edge.getNode2().getName();
        if(distances[v] > (distances[u] + edge.getWeight())) {
            distances[v] = distances[u] + edge.getWeight();
            predecessors[v] = u;

            if(Q.containsIndex(v)) {
                Q.decreaseKey(v, distances[v]);
            } else {
                Q.insert(v, distances[v]);
            }
        }
    }

}
