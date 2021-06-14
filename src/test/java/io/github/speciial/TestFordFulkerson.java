package io.github.speciial;

import io.github.speciial.graph.Digraph;
import io.github.speciial.graph.maxflow.FordFulkerson;
import org.junit.jupiter.api.Test;

public class TestFordFulkerson {

    @Test
    void testFordFulkerson_dc11v() {
        int source = 0;
        int sink = 10;

        System.out.println("FordFulkerson: dc11v.txt");
        System.out.println("Quelle: " + source + ", Senke: " + sink);

        Digraph digraph = new Digraph("assignments/dc11v.txt");
        FordFulkerson fordFulkerson = new FordFulkerson(digraph, source, sink);
        System.out.println(fordFulkerson + "\n");
    }

    @Test
    void testFordFulkerson_dc13v() {
        int source = 0;
        int sink = 12;

        System.out.println("FordFulkerson: dc13v.txt");
        System.out.println("Quelle: " + source + ", Senke: " + sink);

        Digraph digraph = new Digraph("assignments/dc13v.txt");
        FordFulkerson fordFulkerson = new FordFulkerson(digraph, source, sink);
        System.out.println(fordFulkerson + "\n");
    }

    @Test
    void testFordFulkerson_dc15v() {
        int source = 0;
        int sink = 14;

        System.out.println("FordFulkerson: dc15v.txt");
        System.out.println("Quelle: " + source + ", Senke: " + sink);

        Digraph digraph = new Digraph("assignments/dc15v.txt");
        FordFulkerson fordFulkerson = new FordFulkerson(digraph, source, sink);
        System.out.println(fordFulkerson + "\n");
    }

    @Test
    void testFordFulkerson_dc17v() {
        int source = 0;
        int sink = 16;

        System.out.println("FordFulkerson: dc17v.txt");
        System.out.println("Quelle: " + source + ", Senke: " + sink);

        Digraph digraph = new Digraph("assignments/dc17v.txt");
        FordFulkerson fordFulkerson = new FordFulkerson(digraph, source, sink);
        System.out.println(fordFulkerson + "\n");
    }

    @Test
    void testFordFulkerson_dc19v() {
        int source = 0;
        int sink = 18;

        System.out.println("FordFulkerson: dc19v.txt");
        System.out.println("Quelle: " + source + ", Senke: " + sink);

        Digraph digraph = new Digraph("assignments/dc19v.txt");
        FordFulkerson fordFulkerson = new FordFulkerson(digraph, source, sink);
        System.out.println(fordFulkerson + "\n");
    }

}
