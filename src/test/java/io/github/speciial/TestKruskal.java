package io.github.speciial;

import io.github.speciial.graph.Graph;
import io.github.speciial.graph.mst.Kruskal;
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
public class TestKruskal {

    @Test
    void testKruskal_uc11v() {
        System.out.println("Kruskal: uc11v.txt");

        Graph graph = new Graph("assignments/uc11v.txt");
        Kruskal kruskal = new Kruskal(graph);
        System.out.println(kruskal + "\n");
    }

    @Test
    void testKruskal_uc13v() {
        System.out.println("Kruskal: uc13v.txt");

        Graph graph = new Graph("assignments/uc13v.txt");
        Kruskal kruskal = new Kruskal(graph);
        System.out.println(kruskal + "\n");
    }

    @Test
    void testKruskal_uc15v() {
        System.out.println("Kruskal: uc15v.txt");

        Graph graph = new Graph("assignments/uc15v.txt");
        Kruskal kruskal = new Kruskal(graph);
        System.out.println(kruskal + "\n");
    }

    @Test
    void testKruskal_uc17v() {
        System.out.println("Kruskal: uc17v.txt");

        Graph graph = new Graph("assignments/uc17v.txt");
        Kruskal kruskal = new Kruskal(graph);
        System.out.println(kruskal + "\n");
    }

    @Test
    void testKruskal_uc19v() {
        System.out.println("Kruskal: uc19v.txt");

        Graph graph = new Graph("assignments/uc19v.txt");
        Kruskal kruskal = new Kruskal(graph);
        System.out.println(kruskal + "\n");
    }

}
