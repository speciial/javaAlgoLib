package io.github.speciial.graph.maxflow;

import io.github.speciial.graph.Digraph;
import io.github.speciial.graph.Edge;
import io.github.speciial.graph.NodeColor;

import java.util.LinkedList;
import java.util.Queue;

import static io.github.speciial.graph.NodeColor.BLACK;
import static io.github.speciial.graph.NodeColor.WHITE;

public class FordFulkerson {

    private double maxFlow;

    private final int V;
    private int[] predecessors;

    public FordFulkerson(Digraph digraph, int source, int sink) {
        V = digraph.V();
        double flow = 0.0;

        // default value of the array is 0.0
        double[][] residualNetwork = new double[digraph.V()][digraph.V()];
        for (Edge edge : digraph.getAllEdges()) {
            residualNetwork[edge.getNode1().getName()][edge.getNode2().getName()] = edge.getWeight();
        }

        while (findAugmentingPath(residualNetwork, source, sink)) {

            double pathCapacity = Double.POSITIVE_INFINITY;
            for(int v = sink; v != source; v = predecessors[v]) {
                pathCapacity = Math.min(pathCapacity, residualNetwork[predecessors[v]][v]);
            }

            for(int v = sink; v != source; v = predecessors[v]) {
                residualNetwork[predecessors[v]][v] -= pathCapacity;
                residualNetwork[v][predecessors[v]] += pathCapacity;
            }

            flow += pathCapacity;
        }

        maxFlow = flow;
    }

    private boolean findAugmentingPath(double[][] resNet, int start, int end) {
        NodeColor[] colors = new NodeColor[resNet.length];
        predecessors = new int[resNet.length];

        for (int i = 0; i < resNet.length; i++) {
            colors[i] = WHITE;
            predecessors[i] = -1;
        }

        colors[start] = BLACK;

        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);

        boolean found = false;
        while (!Q.isEmpty() && !found) {
            int u = Q.poll();

            for (int v = 0; v < V; v++) {
                if (colors[v] == WHITE
                        && resNet[u][v] > 0.0) {

                    colors[v] = BLACK;
                    predecessors[v] = u;
                    Q.add(v);

                    if (v == end) {
                        found = true;
                        break;
                    }
                }
            }
        }

        return found;
    }

    @Override
    public String toString() {
        return "FordFulkerson -> Max Flow: " + maxFlow;
    }
}

