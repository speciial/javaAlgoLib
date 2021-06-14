package io.github.speciial;

import io.github.speciial.graph.AdjMatrixDigraph;
import io.github.speciial.graph.shortestpath.FloydWarshall;
import org.junit.jupiter.api.Test;

public class TestFloydWarshall {

    @Test
    void testFloydWarshall_d10v() {
        System.out.println("FloydWarshall: d10v.txt");
        System.out.println("Startknoten: 0");

        AdjMatrixDigraph digraph = new AdjMatrixDigraph("assignments/d10v.txt");
        FloydWarshall floydWarshall = new FloydWarshall(digraph, 0);
        System.out.println(floydWarshall + "\n");
    }

    @Test
    void testFloydWarshall_d12v() {
        System.out.println("FloydWarshall: d12v.txt");
        System.out.println("Startknoten: 0");

        AdjMatrixDigraph digraph = new AdjMatrixDigraph("assignments/d12v.txt");
        FloydWarshall floydWarshall = new FloydWarshall(digraph, 0);
        System.out.println(floydWarshall + "\n");
    }

    @Test
    void testFloydWarshall_d14v() {
        System.out.println("FloydWarshall: d14v.txt");
        System.out.println("Startknoten: 0");

        AdjMatrixDigraph digraph = new AdjMatrixDigraph("assignments/d14v.txt");
        FloydWarshall floydWarshall = new FloydWarshall(digraph, 0);
        System.out.println(floydWarshall + "\n");
    }

    @Test
    void testFloydWarshall_d16v() {
        System.out.println("FloydWarshall: d16v.txt");
        System.out.println("Startknoten: 0");

        AdjMatrixDigraph digraph = new AdjMatrixDigraph("assignments/d16v.txt");
        FloydWarshall floydWarshall = new FloydWarshall(digraph, 0);
        System.out.println(floydWarshall + "\n");
    }

    @Test
    void testFloydWarshall_d18v() {
        System.out.println("FloydWarshall: d18v.txt");
        System.out.println("Startknoten: 0");

        AdjMatrixDigraph digraph = new AdjMatrixDigraph("assignments/d18v.txt");
        FloydWarshall floydWarshall = new FloydWarshall(digraph, 0);
        System.out.println(floydWarshall + "\n");
    }

}
