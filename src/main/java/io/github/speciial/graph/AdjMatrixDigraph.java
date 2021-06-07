package io.github.speciial.graph;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

public class AdjMatrixDigraph {

    private int V;
    private int E;

    private double[][] adjMatrix;

    public AdjMatrixDigraph(int V) {
        this.V = V;
        this.E = 0;

        this.adjMatrix = new double[V][V];

        // TODO: make this work differently
        initMatrix();
    }

    public AdjMatrixDigraph(String fileName) {
        this.V = 0;
        this.E = 0;

        this.adjMatrix = null;

        Path path;
        Scanner scanner = null;
        try {
            path = Paths.get(Objects.requireNonNull(this.getClass().getClassLoader().getResource(fileName)).toURI());
            scanner = new Scanner(path, StandardCharsets.UTF_8);

            int vertCount = scanner.nextInt();
            int edgeCount = scanner.nextInt();
            scanner.nextLine();

            this.V = vertCount;

            this.adjMatrix = new double[V][V];
            initMatrix();

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

    public void addEdge(int from, int to, double edgeWeight) {
        if(adjMatrix[from][to] == Double.NEGATIVE_INFINITY) {
            E++;
            adjMatrix[from][to] = edgeWeight;
        }
    }

    public double[] getAjd(int node) {
        if(isInRange(node)) {
            return adjMatrix[node];
        }
        return null;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void initMatrix() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = Double.NEGATIVE_INFINITY;
            }
        }
    }

    private boolean isInRange(int node) {
        boolean result = true;
        if (node < 0 || node >= V) {
            result = false;
        }
        return result;
    }

}
