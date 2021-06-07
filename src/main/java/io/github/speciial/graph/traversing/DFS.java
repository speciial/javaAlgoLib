package io.github.speciial.graph.traversing;

import io.github.speciial.graph.Edge;
import io.github.speciial.graph.IGraph;
import io.github.speciial.graph.NodeColor;

import static io.github.speciial.graph.NodeColor.*;

public class DFS {

    private final NodeColor[] colors;
    private final int[] predecessors;
    private final int[] distances;
    private final int[] times;

    private int time;

    public DFS(IGraph graph) {
        colors = new NodeColor[graph.V()];
        predecessors = new int[graph.V()];
        distances = new int[graph.V()];
        times = new int[graph.V()];

        time = 0;

        for (int i = 0; i < graph.V(); i++) {
            colors[i] = WHITE;
            predecessors[i] = -1;
        }

        for (int i = 0; i < graph.V(); i++) {
            if (colors[i] == WHITE) {
                dfsVisit(graph, i);
            }
        }

        System.out.println("Global Time: " + time);
        for(int i = 0; i < graph.V(); i++) {
            System.out.println("Node " + i + ": Color(" + colors[i] + "), Predecessor(" + predecessors[i] + "), Distance(" + distances[i] + "), Time(" + times[i] + ")");
        }
    }

    private void dfsVisit(IGraph graph, int node) {
        time += 1;
        distances[node] = time;
        colors[node] = GRAY;
        if (graph.getAjd(node) != null) {
            for (Edge edge : graph.getAjd(node)) {
                int v = edge.getNode2().getName();
                if (colors[v] == WHITE) {
                    predecessors[v] = node;
                    dfsVisit(graph, v);
                }
            }
        }
        colors[node] = BLACK;
        time += 1;
        times[node] = time;
    }

}
