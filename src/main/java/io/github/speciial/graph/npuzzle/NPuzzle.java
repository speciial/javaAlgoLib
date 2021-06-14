package io.github.speciial.graph.npuzzle;

import io.github.speciial.graph.npuzzle.NGrid.Heuristics;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static io.github.speciial.graph.npuzzle.NGrid.Heuristics.MISPLACED_TILES;
import static io.github.speciial.graph.npuzzle.NGrid.Heuristics.SUM_OF_DISTANCES;

public class NPuzzle {

    public enum GridSize {
        STATIC_G3x3,
        G3x3
    }

    private final NGrid goal;

    /**
     * Implmentation des NPuzzle Problem (8Puzzle Problem). Die folgenden Gößen /
     * Konfigurationen sind möglich.
     * <p>
     * - STATIC_G3x3    : Das vorgegebene Beispiel aus Prof. Morisses Video zum N Puzzle Problem.
     * - G3x3           : Ein zufällig generiertes 3x3 Grid
     * <p>
     * Für die Heuristik kann entweder die Methode MISPLACED_TILES (Anzahl der
     * falsch-plazierten Teile, oder die Methode SUM_OF_DISTANCES (Summe der
     * Distanzen der Teile zur finalen Position) ausgewählt werden.
     */
    public NPuzzle(GridSize size, boolean printPath) {
        int[][] solutionArr = new int[][]{
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        goal = new NGrid(solutionArr, 0, 0);

        NGrid start = genGrids(size);
        System.out.println("INITIAL GIRD\n");
        System.out.println(start);

        Heuristics heuristic = MISPLACED_TILES;

        ArrayList<Node> closed = new ArrayList<>();
        ArrayList<Node> open = new ArrayList<>();

        open.add(new Node(start, 0, start.heuristic(goal, heuristic)));

        Node currentNode = null;
        while (!open.isEmpty()) {
            // Finden von Node mit kleinstem f Score
            int fScore = Integer.MAX_VALUE;
            for (Node node : open) {
                if (node.f <= fScore) {
                    fScore = node.f;
                    currentNode = node;
                }
            }

            // Testen, ob die richtig Konfiguration gefunden wurde
            if (currentNode.grid.equals(goal)) {
                break;
            }

            // Derzeitige Node als bearbeitet markieren
            open.remove(currentNode);
            closed.add(currentNode);

            // Berechnen der möglichen Nachfolger
            ArrayList<NGrid> children = generatePossibleConfigurations(currentNode.grid);

            for (NGrid grid : children) {
                int h = grid.heuristic(goal, heuristic);
                int g = currentNode.d + 1;
                Node temp = new Node(grid, g, h);

                // ignorieren wenn der Knoten bereits bearbeitet wurde
                if (closed.contains(temp)) continue;

                // ignorieren wenn
                if (open.contains(temp) && g >= open.get(open.indexOf(temp)).d) continue;

                temp.parent = currentNode;
                temp.d = g;
                temp.f = temp.h + g;

                open.remove(temp);
                open.add(temp);
            }
        }

        System.out.println("Fertiges Grid erreicht in " + currentNode.d + ": ");
        System.out.println(currentNode.grid);

        if (printPath) {
            Node printNode = currentNode;
            ArrayList<String> path = new ArrayList<>();
            while (printNode != null) {
                path.add(printNode.grid.toString());
                printNode = printNode.parent;
            }
            for (int i = (path.size() - 1); i > 0; i--) {
                System.out.println(path.get(i));
            }
        }
    }

    private static ArrayList<NGrid> generatePossibleConfigurations(NGrid grid) {
        ArrayList<NGrid> result = new ArrayList<>();

        NGrid up = grid.moveUp();
        if (up != null) result.add(up);

        NGrid down = grid.moveDown();
        if (down != null) result.add(down);

        NGrid left = grid.moveLeft();
        if (left != null) result.add(left);

        NGrid right = grid.moveRight();
        if (right != null) result.add(right);

        return result;
    }

    private NGrid genGrids(GridSize gridSize) {
        NGrid result = null;
        switch (gridSize) {
            case STATIC_G3x3 -> {
                int emptyX = 1;
                int emptyY = 1;
                int[][] startGrid = new int[][]{
                        {5, 3, 8},
                        {2, 0, 6},
                        {4, 7, 1}
                };
                result = new NGrid(startGrid, emptyX, emptyY);
            }
            case G3x3 -> {
                result = new NGrid(goal.getGrid(), 0, 0);
                for (int i = 0; i < 50; i++) {
                    NGrid temp = execRandomMove(result);
                    if (temp == null) {
                        // Bei ungültigem Move nochmal versuchen
                        i--;
                    } else {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }

    private NGrid execRandomMove(NGrid grid) {
        NGrid result;
        int move = ThreadLocalRandom.current().nextInt(4);
        switch (move) {
            case 0 -> result = grid.moveUp();
            case 1 -> result = grid.moveDown();
            case 2 -> result = grid.moveLeft();
            case 3 -> result = grid.moveRight();
            default -> {
                System.out.println("Ungültiger Move");
                result = null;
            }
        }
        return result;
    }

    private static class Node {
        int d;
        int h;
        int f;
        NGrid grid;

        Node parent;

        public Node(NGrid grid, int d, int h) {
            this.grid = grid;
            this.d = d;
            this.h = h;
            this.f = d + h;

            this.parent = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(grid, node.grid);
        }

        @Override
        public int hashCode() {
            return Objects.hash(grid);
        }
    }


}
