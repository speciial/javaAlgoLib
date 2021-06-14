package io.github.speciial.graph.mst;

import io.github.speciial.graph.Edge;
import io.github.speciial.graph.Graph;
import io.github.speciial.util.UnionFind;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kruskal {

    private double totalWeight;

    public Kruskal(Graph graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Arrays.asList(graph.getAllEdges()));
        Queue<Edge> edges = new LinkedList<>();
        totalWeight = 0.0;

        UnionFind uf = new UnionFind(graph.V());
        while (!pq.isEmpty() && edges.size() < (graph.V() - 1)) {
            Edge e = pq.poll();
            int v = e.getNode1().getName();
            int w = e.getNode2().getName();
            if (uf.find(v) != uf.find(w)) {
                uf.union(v, w);
                edges.add(e);
                totalWeight += e.getWeight();
            }
        }
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Kruskal -> Total Weight: " + totalWeight;
    }
}
