package io.github.speciial;

import io.github.speciial.graph.AdjMatrixDigraph;
import io.github.speciial.graph.Digraph;
import io.github.speciial.graph.Graph;
import io.github.speciial.graph.maxflow.FordFulkerson;
import io.github.speciial.graph.maxflow.PreflowPush;
import io.github.speciial.graph.mst.Kruskal;
import io.github.speciial.graph.mst.Prim;
import io.github.speciial.graph.shortestpath.Dijkstra;
import io.github.speciial.graph.shortestpath.FloydWarshall;
import io.github.speciial.graph.traversing.BFS;
import io.github.speciial.graph.traversing.DFS;

public class MainApp{

    public static void main(String[] args) {
        Graph graph = new Graph("graph/connected_10_vertices.txt");
        System.out.println(graph);
        BFS bfs = new BFS(graph, 0);
        DFS dfs = new DFS(graph);
        System.out.println("\n\n");

        Digraph digraph = new Digraph("graph/directed_10_vertices.txt");
        System.out.println(digraph);
        bfs = new BFS(digraph, 4);
        dfs = new DFS(digraph);
        System.out.println("\n\n");

        Graph weightedConnectedGraph = new Graph("graph/connected_10_vertices_weighted.txt");
        Kruskal kruskal = new Kruskal(weightedConnectedGraph);
        System.out.println(kruskal);
        System.out.println("\n\n");

        weightedConnectedGraph = new Graph("graph/connected_10_vertices_weighted.txt");
        Prim prim = new Prim(weightedConnectedGraph, 0);
        System.out.println(prim);
        System.out.println("\n\n");

        Digraph weightedDirectedGraph = new Digraph("graph/directed_10_vertices_weighted.txt");
        Dijkstra dijkstra = new Dijkstra(weightedDirectedGraph, 2);
        System.out.println(dijkstra);
        System.out.println("\n\n");

        AdjMatrixDigraph adjMatrixDigraph = new AdjMatrixDigraph("graph/directed_10_vertices_weighted.txt");
        FloydWarshall floydWarshall = new FloydWarshall(adjMatrixDigraph, 0);
        System.out.println(floydWarshall);
        System.out.println("\n\n");

        Digraph flowNet = new Digraph("exercises/directed_13v.txt");
        FordFulkerson fordFulkerson = new FordFulkerson(flowNet, 0, 9);
        System.out.println(fordFulkerson);
        System.out.println("\n\n");

        Digraph flowNet2 = new Digraph("exercises/directed_13v.txt");
        PreflowPush preflowPush = new PreflowPush(flowNet2, 0, 9);
        System.out.println(preflowPush);
        System.out.println("\n\n");
    }

}
