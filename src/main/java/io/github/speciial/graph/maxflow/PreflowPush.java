package io.github.speciial.graph.maxflow;

import io.github.speciial.graph.Digraph;
import io.github.speciial.graph.Edge;

public class PreflowPush {

    private int edgeIndex = 0;

    private Edge[] edges;
    private double[] edgeFlow;

    private int[] h;
    private double[] excess;

    public PreflowPush(Digraph digraph, int source, int sink) {
        // Initialisieren
        edges = new Edge[digraph.E() * 2];
        edgeFlow = new double[digraph.E() * 2];
        h = new int[digraph.V()];
        excess = new double[digraph.V()];
        for (Edge edge : digraph.getAllEdges()) {
            edges[edgeIndex] = edge;
            edgeIndex++;
        }

        // Preflow
        preflow(source);

        // Loop bis kein Überschuss vorhanden
        while (vertexOverflow(source, sink) != -1) {
            int vertex = vertexOverflow(source, sink);

            if (!push(vertex)) {
                relabel(vertex);
            }
        }

        System.out.println("MAX FLOW: " + excess[sink]);
    }

    private void preflow(int source) {
        h[source] = h.length;

        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != null) {
                int u = edges[i].getNode1().getName();
                int v = edges[i].getNode2().getName();

                if (u == source) {
                    // Fluten der Kanten vom startknoten
                    edgeFlow[i] = edges[i].getWeight();

                    // Überschuss auf den Knoten addieren
                    excess[v] += edgeFlow[i];

                    // Rückwärtskante einfügen
                    edges[edgeIndex] = new Edge(edges[i].getNode2(), edges[i].getNode1(), 0);
                    edgeFlow[edgeIndex] = -edgeFlow[i];
                    edgeIndex++;
                }
            }
        }
    }

    private int vertexOverflow(int source, int sink) {
        int result = -1;
        for (int i = 0; i < excess.length; i++) {
            if (i != sink && i != source && excess[i] > 0) {
                result = i;
            }
        }
        return result;
    }

    private boolean push(int vertex) {
        boolean result = false;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != null) {
                int u = edges[i].getNode1().getName();
                int v = edges[i].getNode2().getName();

                if (u == vertex) {
                    if (edgeFlow[i] == edges[i].getWeight()) {
                        continue;
                    }

                    if (h[vertex] > h[v]) {
                        double flow = Math.min((edges[i].getWeight() - edgeFlow[i]), excess[u]);

                        excess[u] -= flow;
                        excess[v] += flow;

                        edgeFlow[i] += flow;

                        updateReverseEdgeFlow(i, flow);

                        result = true;
                    }
                }
            }
        }
        return result;
    }

    private void relabel(int vertex) {
        int minHeight = Integer.MAX_VALUE;

        for(int i = 0; i < edges.length; i++) {
            if(edges[i] != null) {
                int u = edges[i].getNode1().getName();
                int v = edges[i].getNode2().getName();

                if(u == vertex) {
                    if(edgeFlow[i] == edges[i].getWeight()) {
                        continue;
                    }

                    if(h[v] < minHeight) {
                        minHeight = h[v];
                        h[u] = minHeight + 1;
                    }
                }
            }
        }
    }

    private void updateReverseEdgeFlow(int edge, double flow) {
        int u = edges[edge].getNode2().getName();
        int v = edges[edge].getNode1().getName();

        boolean hasReverse = false;
        for (int i = 0; i < edges.length; i++) {
            if(edges[i] != null
                    && edges[i].getNode1().getName() == u
                    && edges[i].getNode2().getName() == v) {
                hasReverse = true;
                edgeFlow[i] -= flow;
            }
        }

        if(!hasReverse) {
            edges[edgeIndex] = new Edge(edges[edge].getNode2(), edges[edge].getNode1(), flow);
            edgeFlow[edgeIndex] = 0;
            edgeIndex++;
        }
    }

}
