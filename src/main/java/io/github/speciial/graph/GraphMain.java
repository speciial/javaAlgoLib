package io.github.speciial.graph;

import io.github.speciial.graph.maxflow.FordFulkerson;
import io.github.speciial.graph.maxflow.PreflowPush;
import io.github.speciial.graph.mst.Kruskal;
import io.github.speciial.graph.mst.Prim;
import io.github.speciial.graph.shortestpath.Dijkstra;
import io.github.speciial.graph.shortestpath.FloydWarshall;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class GraphMain {

    static void convertFileToIPFormat(String inFilepath, String outFilepath) throws URISyntaxException, IOException {
        Path path = Paths.get(Objects.requireNonNull(GraphMain.class.getClassLoader().getResource(inFilepath)).toURI());

        List<String> fileContent = Files.readAllLines(path);
        StringBuilder firstLineBuilder = new StringBuilder().append("# ");
        StringBuilder fileBuilder = new StringBuilder();
        String ipPrefix = "196.168.0.";
        for (String line : fileContent) {
            String[] lineTokens = line.split(" ");
            if (lineTokens.length == 1) {
                firstLineBuilder.append(lineTokens[0]).append(" ");
            } else if (lineTokens.length == 3) {
                String index0 = ipPrefix + lineTokens[0];
                String index1 = ipPrefix + lineTokens[1];
                int weight = (int) (Double.parseDouble(lineTokens[2]));

                fileBuilder.append(index0).append(" ").append(index1).append(" ").append(weight).append("\n");
            }
        }

        byte[] settingsAsByteData = firstLineBuilder.append("\n").append(fileBuilder).toString().getBytes();

        Path outputPath = Paths.get(outFilepath);
        Files.write(outputPath, settingsAsByteData);
    }

    static void convertFileToInt(String inFilepath, String outFilepath) throws URISyntaxException, IOException {
        Path path = Paths.get(Objects.requireNonNull(GraphMain.class.getClassLoader().getResource(inFilepath)).toURI());

        List<String> fileContent = Files.readAllLines(path);
        StringBuilder fileBuilder = new StringBuilder();
        for (String line : fileContent) {
            String[] lineTokens = line.split(" ");
            if (lineTokens.length == 1) {
                fileBuilder.append(lineTokens[0]).append("\n");
            } else if (lineTokens.length == 3) {
                String index0 = lineTokens[0];
                String index1 = lineTokens[1];
                int weight = (int) (Double.parseDouble(lineTokens[2]));

                fileBuilder.append(index0).append(" ").append(index1).append(" ").append(weight).append("\n");
            }
        }

        byte[] settingsAsByteData = fileBuilder.toString().getBytes();

        Path outputPath = Paths.get(outFilepath);
        Files.write(outputPath, settingsAsByteData);
    }

    public static void main(String[] args) {
        String filepath = "graph/1000_vertices_weighted_int.txt";

        Graph graph = new Graph(filepath);
        Digraph digraph = new Digraph(filepath);
        AdjMatrixDigraph adjMatrixDigraph = new AdjMatrixDigraph(filepath);

//        Prim prim = new Prim(graph, 678);
//        System.out.println(prim);
//
//        Kruskal kruskal = new Kruskal(graph);
//        System.out.println(kruskal);

//        FordFulkerson fordFulkerson = new FordFulkerson(digraph, 212, 678);
//        System.out.println(fordFulkerson);
//
//        PreflowPush preflowPush = new PreflowPush(digraph, 212, 678);
//        System.out.println(preflowPush);

        Dijkstra dijkstra = new Dijkstra(digraph, 390);
        System.out.println(dijkstra);

        FloydWarshall floydWarshall = new FloydWarshall(adjMatrixDigraph, 390);
        System.out.println(floydWarshall);

//        try {
//            convertFileToInt("graph/1000_vertices_weighted.txt", "data/1000_vertices_weighted_int.txt");
//            convertFileToIPFormat("graph/1000_vertices_weighted.txt", "data/1000_ip.txt");
//        } catch (URISyntaxException | IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
