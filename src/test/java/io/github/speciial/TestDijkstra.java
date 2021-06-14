package io.github.speciial;


import io.github.speciial.graph.Digraph;
import io.github.speciial.graph.shortestpath.Dijkstra;
import org.junit.jupiter.api.Test;

/**
 * WIE FUNKTIONIEREN DIESE TESTS:
 * <p>
 * Die Algorithmen Bibliothek enthält Implementationen für alle
 * geforderten Algorithmen für die Review von Sprint 3. Um die
 * Korrektheit der Lösungen der Studierenden zu testen, wird die
 * Ausgabe / das Resultat für einige Dateien kontrolliert.
 * <p>
 * Die Dateien haben folgendes Namensschema:
 * - d (directed)      : gerichteter Graph
 * - u (undirected)    : ungerichteter Graph
 * - c (connected)     : zusammenhängender Graph
 * <p>
 * - [Zahl]v (vertices): Anzahl der Knoten
 * <p>
 * Jeder Algorithmus wird mit mehreren Dateien getestet. Die Methoden-
 * Namen signalisiern, welche Dateien verwendet werden.
 */
public class TestDijkstra {

    /*
        DIE 5 DATEIEN d[zahl]v.txt SIND NICHT GARANTIERT ZUSAMMENHÄNGEND
     */

    @Test
    void testDijkstra_d10v() {
        System.out.println("Dijkstra: d10v.txt");
        System.out.println("Startknoten: 0");

        Digraph digraph = new Digraph("assignments/d10v.txt");
        Dijkstra dijkstra = new Dijkstra(digraph, 0);
        System.out.println(dijkstra + "\n");
    }

    @Test
    void testDijkstra_d12v() {
        System.out.println("Dijkstra: d12v.txt");
        System.out.println("Startknoten: 0");

        Digraph digraph = new Digraph("assignments/d12v.txt");
        Dijkstra dijkstra = new Dijkstra(digraph, 0);
        System.out.println(dijkstra + "\n");
    }

    @Test
    void testDijkstra_d14v() {
        System.out.println("Dijkstra: d14v.txt");
        System.out.println("Startknoten: 0");

        Digraph digraph = new Digraph("assignments/d14v.txt");
        Dijkstra dijkstra = new Dijkstra(digraph, 0);
        System.out.println(dijkstra + "\n");
    }

    @Test
    void testDijkstra_d16v() {
        System.out.println("Dijkstra: d16v.txt");
        System.out.println("Startknoten: 0");

        Digraph digraph = new Digraph("assignments/d16v.txt");
        Dijkstra dijkstra = new Dijkstra(digraph, 0);
        System.out.println(dijkstra + "\n");
    }

    @Test
    void testDijkstra_d18v() {
        System.out.println("Dijkstra: d18v.txt");
        System.out.println("Startknoten: 0");

        Digraph digraph = new Digraph("assignments/d18v.txt");
        Dijkstra dijkstra = new Dijkstra(digraph, 0);
        System.out.println(dijkstra + "\n");
    }

}
