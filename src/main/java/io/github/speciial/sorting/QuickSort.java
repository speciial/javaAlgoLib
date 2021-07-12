package io.github.speciial.sorting;

public class QuickSort {

    /**
     * Runs the Quick Sort Algorithm on @numbers. Sorting is done in place.
     *
     * @param numbers Array to sort.
     */
    public QuickSort(double[] numbers) {
        sort(numbers, 0, (numbers.length - 1));
    }

    private void sort(double[] numbers, int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int partitionIndex = partition(numbers, leftBound, rightBound);
            sort(numbers, leftBound, (partitionIndex - 1));
            sort(numbers, (partitionIndex + 1), rightBound);
        }
    }

    private int partition(double[] numbers, int leftBound, int rightBound) {
        // double pivot = numbers[rightBound];
        double pivot = medianOfThree(numbers, leftBound, rightBound);
        int i = leftBound;
        for (int j = leftBound; j < rightBound; j++) {
            if (numbers[j] < pivot) {
                swap(numbers, i, j);
                ++i;
            }
        }
        swap(numbers, i, rightBound);
        return i;
    }

    private double medianOfThree(double[] numbers, int leftBound, int rightBound) {
        int mid = (leftBound + rightBound) / 2;
        if (numbers[mid] < numbers[leftBound]) {
            swap(numbers, leftBound, mid);
        }
        if (numbers[rightBound] < numbers[leftBound]) {
            swap(numbers, leftBound, rightBound);
        }
        if (numbers[mid] < numbers[rightBound]) {
            swap(numbers, mid, rightBound);
        }
        return numbers[rightBound];
    }

    private void swap(double[] numbers, int indexA, int indexB) {
        double temp = numbers[indexA];
        numbers[indexA] = numbers[indexB];
        numbers[indexB] = temp;
    }

}
