package io.github.speciial.graph.traversing;

import io.github.speciial.graph.*;

import java.util.LinkedList;
import java.util.Queue;

import static io.github.speciial.graph.NodeColor.*;

public class BFS {

    public BFS(IGraph graph, int start) {
        NodeColor[] colors = new NodeColor[graph.V()];
        int[] predecessors = new int[graph.V()];
        int[] distances = new int[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            colors[i] = WHITE;
            distances[i] = Integer.MAX_VALUE;
            predecessors[i] = -1;
        }

        colors[start] = GRAY;
        distances[start] = 0;
        predecessors[start] = -1;

        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        while (!Q.isEmpty()) {
            int u = Q.poll();
            for (Edge edge : graph.getAjd(u)) {
                Node v = edge.getNode2();
                if(colors[v.getName()] == WHITE) {
                    colors[v.getName()] = GRAY;
                    distances[v.getName()] = distances[u] + 1;
                    predecessors[v.getName()] = u;
                    Q.add(v.getName());
                }
            }
            colors[u] = BLACK;
        }

        for(int i = 0; i < graph.V(); i++) {
            System.out.println("Node " + i + ": Color(" + colors[i] + "), Predecessor(" + predecessors[i] + "), Distance(" + distances[i] + ")");
        }
    }

}
