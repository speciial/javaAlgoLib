package io.github.speciial;

import io.github.speciial.graph.Digraph;
import io.github.speciial.graph.maxflow.PreflowPush;
import org.junit.jupiter.api.Test;

public class TestPreflowPush {

    @Test
    void testPreflowPush_dc11v() {
        int source = 0;
        int sink = 10;

        System.out.println("PreflowPush: dc11v.txt");
        System.out.println("Quelle: " + source + ", Senke: " + sink);

        Digraph digraph = new Digraph("assignments/dc11v.txt");
        PreflowPush preflowPush = new PreflowPush(digraph, source, sink);
        System.out.println(preflowPush + "\n");
    }

    @Test
    void testPreflowPush_dc13v() {
        int source = 0;
        int sink = 12;

        System.out.println("PreflowPush: dc13v.txt");
        System.out.println("Quelle: " + source + ", Senke: " + sink);

        Digraph digraph = new Digraph("assignments/dc13v.txt");
        PreflowPush preflowPush = new PreflowPush(digraph, source, sink);
        System.out.println(preflowPush + "\n");
    }

    @Test
    void testPreflowPush_dc15v() {
        int source = 0;
        int sink = 14;

        System.out.println("PreflowPush: dc15v.txt");
        System.out.println("Quelle: " + source + ", Senke: " + sink);

        Digraph digraph = new Digraph("assignments/dc15v.txt");
        PreflowPush preflowPush = new PreflowPush(digraph, source, sink);
        System.out.println(preflowPush + "\n");
    }

    @Test
    void testPreflowPush_dc17v() {
        int source = 0;
        int sink = 16;

        System.out.println("PreflowPush: dc17v.txt");
        System.out.println("Quelle: " + source + ", Senke: " + sink);

        Digraph digraph = new Digraph("assignments/dc17v.txt");
        PreflowPush preflowPush = new PreflowPush(digraph, source, sink);
        System.out.println(preflowPush + "\n");
    }

    @Test
    void testPreflowPush_dc19v() {
        int source = 0;
        int sink = 18;

        System.out.println("PreflowPush: dc19v.txt");
        System.out.println("Quelle: " + source + ", Senke: " + sink);

        Digraph digraph = new Digraph("assignments/dc19v.txt");
        PreflowPush preflowPush = new PreflowPush(digraph, source, sink);
        System.out.println(preflowPush + "\n");
    }

}
