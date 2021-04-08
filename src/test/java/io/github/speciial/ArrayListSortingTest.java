package io.github.speciial;

import io.github.speciial.sorting.ALInsertionSortAlgorithm;
import io.github.speciial.sorting.ALSelectionSortAlgorithm;
import io.github.speciial.sorting.SortingAlgorithm;
import io.github.speciial.util.FileLoader;
import io.github.speciial.util.TimeLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayListSortingTest {

    int[] largeArrayList;

    @BeforeEach
    void setup() {
        // largeArray = FileLoader.loadNumbersFromFile("data_1000");
        largeArrayList = FileLoader.loadNumbersToArray("data_100k");
        // largeArray = FileLoader.loadNumbersFromFile("data_1000k");

    }

    @Test
    void testInsertionSort() {
        SortingAlgorithm insertionSort = new ALInsertionSortAlgorithm();
        testSorting(insertionSort, new int[]{0}, false);
        testSorting(insertionSort, new int[]{0, 0, 0}, false);
        testSorting(insertionSort, new int[]{1, 2, 3}, false);
        testSorting(insertionSort, new int[]{3, 2, 1}, false);
        testSorting(insertionSort, new int[]{-17, 30, 2, 5, -13, 9, 9, 10}, false);
        testSorting(insertionSort, largeArrayList, true);
    }

    @Test
    void testSelectionSort() {
        SortingAlgorithm selectionSort = new ALSelectionSortAlgorithm();
        testSorting(selectionSort, new int[]{0}, false);
        testSorting(selectionSort, new int[]{0, 0, 0}, false);
        testSorting(selectionSort, new int[]{1, 2, 3}, false);
        testSorting(selectionSort, new int[]{3, 2, 1}, false);
        testSorting(selectionSort, new int[]{-17, 30, 2, 5, -13, 9, 9, 10}, false);
        testSorting(selectionSort, largeArrayList, true);
    }

    private void testSorting(SortingAlgorithm algorithm, int[] data, boolean shouldTime) {
        algorithm.setData(data);

        if (shouldTime) {
            TimeLogger timer = new TimeLogger(algorithm.getClass().getCanonicalName());
            algorithm.sort();
            timer.stopTiming();
        } else {
            algorithm.sort();
        }

        assertEquals(data.length, algorithm.getItemCount());
        for (int index = 0; index < (algorithm.getItemCount() - 1); index++) {
            assertTrue((algorithm.getItem(index) <= algorithm.getItem(index + 1)), "Failed at Index: " + index + ", Value: " + algorithm.getItem(index));
        }
    }

}
