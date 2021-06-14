package io.github.speciial.graph.npuzzle;

import java.util.Arrays;
import java.util.Objects;

public class NGrid {

    public enum Heuristics {
        MISPLACED_TILES,
        SUM_OF_DISTANCES
    }

    private int emptyX;
    private int emptyY;

    private final int[][] grid;

    public NGrid(int[][] grid, int emptyX, int emptyY) {
        this.emptyX = emptyX;
        this.emptyY = emptyY;

        // Deep Copy von grid
        this.grid = new int[grid.length][grid.length];
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid.length; x++) {
                this.grid[y][x] = grid[y][x];
            }
        }
    }

    public NGrid moveUp() {
        NGrid newNGrid = new NGrid(this.grid, this.emptyX, this.emptyY);
        if ((this.emptyY - 1) < 0) {
            newNGrid = null;
        } else {
            // Ausführen von moveUp
            newNGrid.grid[this.emptyY][this.emptyX] = newNGrid.grid[this.emptyY - 1][this.emptyX];
            newNGrid.grid[this.emptyY - 1][this.emptyX] = 0;

            newNGrid.emptyX = this.emptyX;
            newNGrid.emptyY = this.emptyY - 1;
        }
        return newNGrid;
    }

    public NGrid moveDown() {
        NGrid newNGrid = new NGrid(this.grid, this.emptyX, this.emptyY);
        if ((this.emptyY + 1) > (this.grid.length - 1)) {
            newNGrid = null;
        } else {
            // Ausführen von moveDown
            newNGrid.grid[this.emptyY][this.emptyX] = newNGrid.grid[this.emptyY + 1][this.emptyX];
            newNGrid.grid[this.emptyY + 1][this.emptyX] = 0;

            newNGrid.emptyX = this.emptyX;
            newNGrid.emptyY = this.emptyY + 1;
        }
        return newNGrid;
    }

    public NGrid moveLeft() {
        NGrid newNGrid = new NGrid(this.grid, this.emptyX, this.emptyY);
        if ((this.emptyX - 1) < 0) {
            newNGrid = null;
        } else {
            // Ausführen von moveDown
            newNGrid.grid[this.emptyY][this.emptyX] = newNGrid.grid[this.emptyY][this.emptyX - 1];
            newNGrid.grid[this.emptyY][this.emptyX - 1] = 0;

            newNGrid.emptyX = this.emptyX - 1;
            newNGrid.emptyY = this.emptyY;
        }
        return newNGrid;
    }

    public NGrid moveRight() {
        NGrid newNGrid = new NGrid(this.grid, this.emptyX, this.emptyY);
        if ((this.emptyX + 1) > (this.grid.length - 1)) {
            newNGrid = null;
        } else {
            // Ausführen von moveDown
            newNGrid.grid[this.emptyY][this.emptyX] = newNGrid.grid[this.emptyY][this.emptyX + 1];
            newNGrid.grid[this.emptyY][this.emptyX + 1] = 0;

            newNGrid.emptyX = this.emptyX + 1;
            newNGrid.emptyY = this.emptyY;
        }
        return newNGrid;
    }

    public int heuristic(NGrid goal, Heuristics heuristic) {
        int result = -1;
        switch (heuristic) {
            case MISPLACED_TILES -> result = misplacedTiles(goal);
            case SUM_OF_DISTANCES -> result = sumOfDistances(goal);
            default -> System.out.println("Unknown Heuristic");
        }
        return result;
    }

    private int misplacedTiles(NGrid goal) {
        int result = 0;
        for (int y = 0; y < goal.grid.length; y++) {
            for (int x = 0; x < goal.grid.length; x++) {
                // TODO: Muss das leere Feld ausgeschlossen werden?
                if (goal.grid[y][x] != this.grid[y][x]) {
                    result++;
                }
            }
        }
        return result;
    }

    private int sumOfDistances(NGrid goal) {
        int result = 0;

        for (int y = 0; y < goal.grid.length; y++) {
            for (int x = 0; x < goal.grid.length; x++) {
                // TODO: Muss das leere Feld ausgeschlossen werden?
                // Bestimmen der Zielposition des Tiles
                xyPair xy = findPositionInGrid(goal, this.grid[y][x]);

                // Berechnen des Abstandes zur Zielposition
                int xDistance = Math.abs(x - xy.x);
                int yDistance = Math.abs(y - xy.y);
                int totalDistance = xDistance + yDistance;
                result += totalDistance;
            }
        }

        return result;
    }

    private static class xyPair {
        int x;
        int y;
    }

    private xyPair findPositionInGrid(NGrid grid, int toSearch) {
        xyPair result = new xyPair();
        result.x = -1;
        result.y = -1;
        for (int y = 0; y < grid.grid.length; y++) {
            for (int x = 0; x < grid.grid.length; x++) {
                if (grid.grid[y][x] == toSearch) {
                    result.x = x;
                    result.y = y;
                    break;
                }
            }
        }
        return result;
    }

    public int getEmptyX() {
        return emptyX;
    }

    public int getEmptyY() {
        return emptyY;
    }

    public int[][] getGrid() {
        return grid;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < grid.length; y++) {
            builder.append("-------------").append("\n");
            for (int x = 0; x < grid.length; x++) {
                if (grid[y][x] == 0) {
                    builder.append("| _ ");
                } else {
                    builder.append("| ").append(grid[y][x]).append(" ");
                }
            }
            builder.append("|\n");
        }
        builder.append("-------------\n\n");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NGrid nGrid = (NGrid) o;

        boolean eq = true;
        for (int y = 0; y < nGrid.grid.length; y++) {
            for (int x = 0; x < nGrid.grid.length; x++) {
                if (this.grid[y][x] != nGrid.grid[y][x]) {
                    eq = false;
                    break;
                }
            }
        }

        return eq &&
                emptyX == nGrid.emptyX &&
                emptyY == nGrid.emptyY;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(emptyX, emptyY);
        result = 31 * result + Arrays.hashCode(grid);
        return result;
    }
}
