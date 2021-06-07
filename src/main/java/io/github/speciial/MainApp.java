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

    /*
        [x] Minimaler Spannbaum
            [-] Generischer Algorithmus von Tarjan -> generischer algorithmus, trotzdem implementieren?
            [x] Algorithmus von Kruskal
            [x] Algorithmus von Prim
        [x] Kürzester Weg
            [x] Kürzeste Wege nach Dijkstra
            [-] Label Correction Algorithmus -> generischer algorithmus, hier vielleicht Bellman-Ford
            [x] Floyd Warshall Algorithmus
            [-] Kürzeste Wege mit dem A*-Algorithmus -> jezt in einem anderen Projekt
                                                        https://gitlab.hs-osnabrueck.de/cheidema/npuzzle
        [ ] Netzwerk-Fluss
            [x] MaxFlow nach Ford-Fulkserson
            [ ] MaxFlow nach Preflow-Push
        [x] Utils
            [x] Union Find
            [x] Indexed Priority Queue
    */

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
        System.out.println("\n\n");

        weightedConnectedGraph = new Graph("graph/connected_10_vertices_weighted.txt");
        Prim prim = new Prim(weightedConnectedGraph, 0);
        System.out.println("\n\n");

        Digraph weightedDirectedGraph = new Digraph("graph/directed_10_vertices_weighted.txt");
        Dijkstra dijkstra = new Dijkstra(weightedDirectedGraph, 2);
        System.out.println("\n\n");

        AdjMatrixDigraph adjMatrixDigraph = new AdjMatrixDigraph("graph/directed_10_vertices_weighted.txt");
        FloydWarshall floydWarshall = new FloydWarshall(adjMatrixDigraph);
        System.out.println("\n\n");

        Digraph flowNet = new Digraph("graph/directed_100_vertices_weighted.txt");
        FordFulkerson fordFulkerson = new FordFulkerson(flowNet, 0, 9);
        System.out.println("\n\n");

        Digraph flowNet2 = new Digraph(10);
        flowNet2.addEdge(0, 4, 59.0);
        flowNet2.addEdge(1, 6, 8.0);
        flowNet2.addEdge(1, 6, 46.0);
        flowNet2.addEdge(2, 7, 52.0);
        flowNet2.addEdge(2, 9, 64.0);
        flowNet2.addEdge(3, 9, 62.0);
        flowNet2.addEdge(4, 7, 19.0);
        flowNet2.addEdge(4, 2, 26.0);
        flowNet2.addEdge(5, 2, 9.0);
        flowNet2.addEdge(6, 5, 7.0);
        flowNet2.addEdge(7, 0, 51.0);
        flowNet2.addEdge(7, 1, 7.0);
        flowNet2.addEdge(8, 1, 51.0);
        flowNet2.addEdge(9, 1, 11.0);
        PreflowPush preflowPush = new PreflowPush(flowNet2, 0, 9);
    }

    /*
    public static Graph createSimpleGraph(int V, int E) {
        if (E > (long) V * (V - 1) / 2) throw new IllegalArgumentException("Too many edges");
        if (E < 0) throw new IllegalArgumentException("Too few edges");

        Graph graph = new Graph(V, E);

        Random random = new Random();

        int index = 0;
        while (index < E) {
            int v = random.nextInt(V);
            int w = random.nextInt(V);

            double value = random.nextDouble() * 50.0;
            value = Math.round(value * 100.0) / 100.0;

            Edge edge = new Edge(new Node(v), new Node(w), value);
            if (v != w && !graph.edges.contains(edge)) {
                graph.edges.add(edge);
                index++;
            }
        }

        System.out.println(graph);

        return graph;
    }

    public static Graph createConnectedGraph(int V, int E) {
        if (E > (long) V * (V - 1) / 2) throw new IllegalArgumentException("Too many edges");
        if (E < 0) throw new IllegalArgumentException("Too few edges");

        Graph graph = new Graph(V, E);

        Random random = new Random();

        Node initialNode = new Node(random.nextInt(V));
        graph.nodes.add(initialNode);

        int index = 0;
        while (index < E) {
            Node v;
            if ((graph.nodes.size() - 1) == 0) {
                v = initialNode;
            } else {
                v = graph.nodes.get(random.nextInt(graph.nodes.size() - 1));
            }
            Node w = new Node(random.nextInt(V));

            if (!graph.nodes.contains(w)) {
                graph.nodes.add(w);
            } else {
                w = graph.nodes.get(graph.nodes.indexOf(w));
            }

            double value = random.nextDouble() * 50.0;
            value = Math.round(value * 100.0) / 100.0;

            Edge edge = new Edge(v, w, value);
            if (v != w && !graph.edges.contains(edge)) {
                graph.edges.add(edge);
                index++;
            }
        }

        System.out.println(graph);

        return graph;
    }

    public void writeToFile(String fileName) {
        try {
            Path path = Paths.get(fileName);
            BufferedWriter writer = Files.newBufferedWriter(path, CREATE);

            writer.write(this.V + "\n");
            writer.write(this.E + "\n");

            for (Edge edge : edges) {
                writer.write(edge.toString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Graph{ nodeCount= " + V + ", edgeCount=" + E + ", edges=\n" + edges + '}';
    }

    */

}
