package io.github.speciial;

import io.github.speciial.graph.npuzzle.NPuzzle;
import org.junit.jupiter.api.Test;

import static io.github.speciial.graph.npuzzle.NPuzzle.GridSize.G3x3;
import static io.github.speciial.graph.npuzzle.NPuzzle.GridSize.STATIC_G3x3;

public class TestNPuzzle {

    @Test
    void testStaticGrid() {
        NPuzzle puzzle = new NPuzzle(STATIC_G3x3, true);
    }

    @Test
    void testRandomGrid() {
        NPuzzle puzzle = new NPuzzle(G3x3, true);
    }

}
