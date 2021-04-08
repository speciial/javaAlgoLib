package io.github.speciial;

import io.github.speciial.sorting.SortingAlgorithm;
import io.github.speciial.sorting.HeapSortAlgorithm;
import io.github.speciial.sorting.InsertionSortAlgorithm;
import io.github.speciial.sorting.QuickSortAlgorithm;
import io.github.speciial.sorting.SelectionSortAlgorithm;
import io.github.speciial.util.FileLoader;
import io.github.speciial.util.TimeLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleArraySortingTest {

    int[] largeArray;

    @BeforeEach
    void setup() {
        // largeArray = FileLoader.loadNumbersFromFile("data_1000");
        largeArray = FileLoader.loadNumbersToArray("data_100k");
        // largeArray = FileLoader.loadNumbersFromFile("data_1000k");
    }

    @Test
    void testInsertionSort() {
        SortingAlgorithm insertionSort = new InsertionSortAlgorithm();
        testSorting(insertionSort, new int[]{0}, false);
        testSorting(insertionSort, new int[]{0, 0, 0}, false);
        testSorting(insertionSort, new int[]{1, 2, 3}, false);
        testSorting(insertionSort, new int[]{3, 2, 1}, false);
        testSorting(insertionSort, new int[]{-17, 30, 2, 5, -13, 9, 9, 10}, false);
        testSorting(insertionSort, largeArray, true);
    }

    @Test
    void testSelectionSort() {
        SortingAlgorithm selectionSort = new SelectionSortAlgorithm();
        testSorting(selectionSort, new int[]{0}, false);
        testSorting(selectionSort, new int[]{0, 0, 0}, false);
        testSorting(selectionSort, new int[]{1, 2, 3}, false);
        testSorting(selectionSort, new int[]{3, 2, 1}, false);
        testSorting(selectionSort, new int[]{-17, 30, 2, 5, -13, 9, 9, 10}, false);
        testSorting(selectionSort, largeArray, true);
    }

    @Test
    void testHeapSort() {
        SortingAlgorithm heapSort = new HeapSortAlgorithm();
        testSorting(heapSort, new int[]{0}, false);
        testSorting(heapSort, new int[]{0, 0, 0}, false);
        testSorting(heapSort, new int[]{1, 2, 3}, false);
        testSorting(heapSort, new int[]{3, 2, 1}, false);
        testSorting(heapSort, new int[]{-17, 30, 2, 5, -13, 9, 9, 10}, false);
        testSorting(heapSort, largeArray, true);
    }

    @Test
    void testQuickSort() {
        SortingAlgorithm quickSort = new QuickSortAlgorithm();
        testSorting(quickSort, new int[]{0}, false);
        testSorting(quickSort, new int[]{0, 0, 0}, false);
        testSorting(quickSort, new int[]{1, 2, 3}, false);
        testSorting(quickSort, new int[]{3, 2, 1}, false);
        testSorting(quickSort, new int[]{-17, 30, 2, 5, -13, 9, 9, 10}, false);
        testSorting(quickSort, largeArray, true);
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