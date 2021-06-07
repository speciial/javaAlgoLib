package io.github.speciial.sorting;

public class SortingLib {

    public static final int INSERTION_SORT  = 0;
    public static final int SELECTION_SORT  = 1;
    public static final int MERGE_SORT      = 2;
    public static final int QUICK_SORT      = 3;
    public static final int HEAP_SORT       = 4;

    public static void sort(int method, int[] numbers) {
        switch (method) {
            case INSERTION_SORT     -> insertion_sort(numbers);
            case SELECTION_SORT     -> selection_sort(numbers);
            case MERGE_SORT         -> merge_sort(numbers);
            case QUICK_SORT         -> quick_sort(numbers, 0, (numbers.length - 1));
            case HEAP_SORT          -> heap_sort(numbers);
        }
    }

    private static void insertion_sort(int[] numbers) {
        for (int sortingIndex = 1; sortingIndex < numbers.length; sortingIndex++) {
            int key = numbers[sortingIndex];
            int moveIndex = sortingIndex - 1;
            while ((moveIndex >= 0) && (numbers[moveIndex] > key)) {
                numbers[moveIndex + 1] = numbers[moveIndex];
                --moveIndex;
            }
            numbers[moveIndex + 1] = key;
        }
    }

    private static void selection_sort(int[] numbers) {
        for (int sortingIndex = 0; sortingIndex < (numbers.length - 1); sortingIndex++) {
            int minIndex = sortingIndex;
            for (int moveIndex = sortingIndex + 1; moveIndex < numbers.length; moveIndex++) {
                if(numbers[moveIndex] < numbers[minIndex]) {
                    minIndex = moveIndex;
                }
            }
            if(minIndex != sortingIndex) {
                swap(numbers, sortingIndex, minIndex);
            }
        }
    }

    private static void merge_sort(int[] numbers) {

    }

    private static void quick_sort(int[] numbers, int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int partitionIndex = partition(numbers, leftBound, rightBound);
            quick_sort(numbers, leftBound, (partitionIndex - 1));
            quick_sort(numbers, (partitionIndex + 1), rightBound);
        }
    }

    private static void heap_sort(int[] numbers) {
        int heapSize = numbers.length;
        buildMaxHeap(numbers, heapSize);
        for (int index = (numbers.length - 1); index > 0; index--) {
            swap(numbers, 0, index);

            --heapSize;
            maxHeapify(numbers, heapSize, 0);
        }
    }

    private static int partition(int[] numbers, int leftBound, int rightBound) {
        int pivot = numbers[rightBound];
        int sortIndex = leftBound;
        for(int swapIndex = leftBound; swapIndex < rightBound; swapIndex++) {
            if(numbers[swapIndex] < pivot) {
                swap(numbers, sortIndex, swapIndex);

                ++sortIndex;
            }
        }
        swap(numbers, sortIndex, rightBound);
        return sortIndex;
    }

    private static void buildMaxHeap(int[] numbers, int heapSize) {
        for (int index = (numbers.length / 2); index >= 0; index--) {
            maxHeapify(numbers, heapSize, index);
        }
    }

    private static void maxHeapify(int[] numbers, int heapSize, int index) {
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

    private static void swap(int[] numbers, int indexA, int indexB) {
        int temp = numbers[indexA];
        numbers[indexA] = numbers[indexB];
        numbers[indexB] = temp;
    }

}
