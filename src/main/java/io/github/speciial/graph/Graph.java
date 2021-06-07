package io.github.speciial.graph;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Graph implements IGraph {

    private int V;
    private int E;

    private Node[] GV;
    private LinkedList<Edge>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;

        this.GV = new Node[V];
        this.adj = new LinkedList[V];
    }

    public Graph(String fileName) {
        this.V = 0;
        this.E = 0;

        this.GV = null;
        this.adj = null;

        Path path;
        Scanner scanner = null;
        try {
            path = Paths.get(Objects.requireNonNull(this.getClass().getClassLoader().getResource(fileName)).toURI());
            scanner = new Scanner(path, StandardCharsets.UTF_8);

            int vertCount = scanner.nextInt();
            int edgeCount = scanner.nextInt();
            scanner.nextLine();

            this.V = vertCount;

            this.GV = new Node[V];
            this.adj = new LinkedList[V];

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineElements = line.split(" ");

                String nodeA = lineElements[0];                             // Name des ersten Knotens
                String nodeB = lineElements[1];                             // Name des zweiten Knotens
                double edgeWeight = Double.parseDouble(lineElements[2]);    // Gewicht der Kante

                this.addEdge(Integer.parseInt(nodeA), Integer.parseInt(nodeB), edgeWeight);
            }

        } catch (NullPointerException e) {
            System.err.println("Der angegebene Dateiname konnte nicht gefunden werden.");
            System.err.println("Error: " + e);
        } catch (IOException e) {
            System.err.println("Der Scanner konnte die angegebene Datei nicht laden.");
            System.err.println("Error: " + e);
        } catch (URISyntaxException e) {
            System.err.println("Der Name der Datei konnte nicht richtig übersetzt werden.");
            System.err.println("Error: " + e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    @Override
    public void addEdge(int node1, int node2, double value) {
        if (isInRange(node1) && isInRange(node2)) {
            if (GV[node1] == null) {
                GV[node1] = new Node(node1);
                adj[node1] = new LinkedList<>();
            }
            if (GV[node2] == null) {
                GV[node2] = new Node(node2);
                adj[node2] = new LinkedList<>();
            }
            adj[node1].add(new Edge(GV[node1], GV[node2], value));
            adj[node2].add(new Edge(GV[node2], GV[node1], value));

            E++;
        }
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public LinkedList<Edge> getAjd(int node) {
        if (isInRange(node)) {
            return adj[node];
        }
        return null;
    }

    public Edge[] getAllEdges() {
        Edge[] edges = new Edge[E];
        int edgeIndex = 0;
        for (int v = 0; v < V; v++) {
            for (Edge edge: adj[v]) {
                if (edge.getNode2().getName() > v) {
                    edges[edgeIndex] = edge;
                    edgeIndex++;
                }
            }
        }
        return edges;
    }

    private boolean isInRange(int node) {
        boolean result = true;
        if (node < 0 || node >= V) {
            result = false;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Knoten: ").append(V).append(", Kanten: ").append(E).append("\n");
        for (int i = 0; i < V; i++) {
            if (adj[i] != null) {
                builder.append(adj[i].getFirst().getNode1()).append(": ");
                for (Edge edge : adj[i]) {
                    builder.append(edge.getNode2()).append("(").append(edge.getWeight()).append("), ");
                }
                builder.append("\n");
            } else {
                builder.append(i).append(": \n");
            }
        }
        return builder.toString();
    }
}
