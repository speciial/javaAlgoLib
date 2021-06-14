package io.github.speciial;

import io.github.speciial.graph.Graph;
import io.github.speciial.graph.mst.Prim;
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
public class TestPrim {

    @Test
    void testPrim_uc11v() {
        System.out.println("Prim: uc11v.txt");
        System.out.println("Startknoten: 0");

        Graph graph = new Graph("assignments/uc11v.txt");
        Prim prim = new Prim(graph, 0);
        System.out.println(prim + "\n");
    }

    @Test
    void testPrim_uc13v() {
        System.out.println("Prim: uc13v.txt");
        System.out.println("Startknoten: 0");

        Graph graph = new Graph("assignments/uc13v.txt");
        Prim prim = new Prim(graph, 0);
        System.out.println(prim + "\n");
    }

    @Test
    void testPrim_uc15v() {
        System.out.println("Prim: uc15v.txt");
        System.out.println("Startknoten: 0");

        Graph graph = new Graph("assignments/uc15v.txt");
        Prim prim = new Prim(graph, 0);
        System.out.println(prim + "\n");
    }

    @Test
    void testPrim_uc17v() {
        System.out.println("Prim: uc17v.txt");
        System.out.println("Startknoten: 0");

        Graph graph = new Graph("assignments/uc17v.txt");
        Prim prim = new Prim(graph, 0);
        System.out.println(prim + "\n");
    }

    @Test
    void testPrim_uc19v() {
        System.out.println("Prim: uc19v.txt");
        System.out.println("Startknoten: 0");

        Graph graph = new Graph("assignments/uc19v.txt");
        Prim prim = new Prim(graph, 0);
        System.out.println(prim + "\n");
    }

}
