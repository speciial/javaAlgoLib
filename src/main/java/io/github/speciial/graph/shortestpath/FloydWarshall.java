package io.github.speciial.graph.shortestpath;

import io.github.speciial.graph.AdjMatrixDigraph;

public class FloydWarshall {

    public FloydWarshall(AdjMatrixDigraph graph) {
        int n = graph.V();
        double[][] distances = new double[n][n];
        int[][] predecessors = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = Double.POSITIVE_INFINITY;
                predecessors[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double[] nAdj = graph.getAjd(i);
                if(nAdj[j] != Double.NEGATIVE_INFINITY) {
                    distances[i][j] = nAdj[j];
                    predecessors[i][j] = i;
                }
                if(i == j) {
                    distances[i][j] = 0;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                // if(predecessors[i][k] == Integer.MAX_VALUE) continue;
                for (int j = 0; j < n; j++) {
                    double distanceSum = sumDistance(distances[i][k], distances[k][j]);
                    if(distanceSum < distances[i][j]) {
                        distances[i][j] = distanceSum;
                        predecessors[i][j] = predecessors[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + " to " + j + ": " + distances[i][j]);
            }
        }

    }

    private double sumDistance(double d1, double d2) {
        if(d1 == Double.POSITIVE_INFINITY || d2 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return d1 + d2;
    }

}
