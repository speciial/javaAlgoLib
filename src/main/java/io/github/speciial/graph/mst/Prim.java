package io.github.speciial.graph.mst;

import io.github.speciial.graph.Edge;
import io.github.speciial.graph.Graph;
import io.github.speciial.util.IndexedMinPriorityQueue;

public class Prim {

    public Prim(Graph graph, int startNode) {
        double[] keys = new double[graph.V()];
        int[] parents = new int[graph.V()];

        for(int i = 0; i < graph.V(); i++) {
            keys[i] = Double.POSITIVE_INFINITY;
            parents[i] = -1;
        }

        keys[startNode] = 0;
        IndexedMinPriorityQueue Q = new IndexedMinPriorityQueue(graph.V());
        for (int i = 0; i < graph.V(); i++) {
            Q.insert(i, keys[i]);
        }

        while (!Q.isEmpty()) {
            int u = Q.extract();
            for(Edge edge : graph.getAjd(u)) {
                int v = edge.getNode2().getName();
                if(Q.containsIndex(v) && edge.getWeight() < keys[v]) {
                    parents[v] = u;
                    keys[v] = edge.getWeight();

                    Q.decreaseKey(v, keys[v]);
                }
            }
        }

        double weight = 0;
        for (int i = 0; i < graph.V(); i++) {
            if(keys[i] != Double.POSITIVE_INFINITY) {
                weight += keys[i];
            }
        }
        System.out.println("Weight: " + weight);
    }

}
