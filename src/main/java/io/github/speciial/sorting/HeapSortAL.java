package io.github.speciial.sorting;

import java.util.ArrayList;

public class HeapSortAL {

    /**
     * Runs the Heap Sort Algorithm on @numbers. Sorting is done in place.
     *
     * @param numbers ArrayList to sort.
     */
    public HeapSortAL(ArrayList<Double> numbers) {
        int heapSize = numbers.size();
        buildMaxHeap(numbers, heapSize);
        for (int i = (numbers.size() - 1); i > 0; i--) {
            swap(numbers, 0, i);

            --heapSize;
            maxHeapify(numbers, heapSize, 0);
        }
    }

    private void buildMaxHeap(ArrayList<Double> numbers, int heapSize) {
        for (int i = (numbers.size() / 2); i >= 0; i--) {
            maxHeapify(numbers, heapSize, i);
        }
    }

    private void maxHeapify(ArrayList<Double> numbers, int heapSize, int index) {
        int leftIndex = (2 * index) + 1;
        int rightIndex = (2 * index) + 2;
        int largestIndex = index;

        if ((leftIndex < heapSize) && (numbers.get(leftIndex) > numbers.get(index))) {
            largestIndex = leftIndex;
        }
        if ((rightIndex < heapSize) && (numbers.get(rightIndex) > numbers.get(largestIndex))) {
            largestIndex = rightIndex;
        }
        if (largestIndex != index) {
            swap(numbers, index, largestIndex);

            maxHeapify(numbers, heapSize, largestIndex);
        }
    }

    private void swap(ArrayList<Double> numbers, int indexA, int indexB) {
        double temp = numbers.get(indexA);
        numbers.set(indexA, numbers.get(indexB));
        numbers.set(indexB, temp);
    }

}
