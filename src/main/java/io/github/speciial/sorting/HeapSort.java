package io.github.speciial.sorting;

public class HeapSort {

    /**
     * Runs the Heap Sort Algorithm on @numbers. Sorting is done in place.
     *
     * @param numbers Array to sort.
     */
    public HeapSort(double[] numbers) {
        int heapSize = numbers.length;
        buildMaxHeap(numbers, heapSize);
        for (int index = (numbers.length - 1); index > 0; index--) {
            swap(numbers, 0, index);

            --heapSize;
            maxHeapify(numbers, heapSize, 0);
        }
    }

    private void buildMaxHeap(double[] numbers, int heapSize) {
        for (int index = (numbers.length / 2); index >= 0; index--) {
            maxHeapify(numbers, heapSize, index);
        }
    }

    private void maxHeapify(double[] numbers, int heapSize, int index) {
        int leftIndex = (2 * index) + 1;
        int rightIndex = (2 * index) + 2;
        int largestIndex = index;

        if ((leftIndex < heapSize) && (numbers[leftIndex] > numbers[index])) {
            largestIndex = leftIndex;
        }
        if ((rightIndex < heapSize) && (numbers[rightIndex] > numbers[largestIndex])) {
            largestIndex = rightIndex;
        }
        if (largestIndex != index) {
            swap(numbers, index, largestIndex);

            maxHeapify(numbers, heapSize, largestIndex);
        }
    }

    private void swap(double[] numbers, int indexA, int indexB) {
        double temp = numbers[indexA];
        numbers[indexA] = numbers[indexB];
        numbers[indexB] = temp;
    }

}
