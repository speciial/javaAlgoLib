package io.github.speciial.sorting;

import java.util.ArrayList;

public class QuickSortAL {

    /**
     * Runs the Quick Sort Algorithm on @numbers. Sorting is done in place.
     *
     * @param numbers ArrayList to sort.
     */
    public QuickSortAL(ArrayList<Double> numbers) {
        sort(numbers, 0, (numbers.size() - 1));
    }

    private void sort(ArrayList<Double> numbers, int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int partitionIndex = partition(numbers, leftBound, rightBound);
            sort(numbers, leftBound, (partitionIndex - 1));
            sort(numbers, (partitionIndex + 1), rightBound);
        }
    }

    private int partition(ArrayList<Double> numbers, int leftBound, int rightBound) {
        // double pivot = numbers.get(rightBound);
        double pivot = medianOfThree(numbers, leftBound, rightBound);
        int i = leftBound;
        for (int j = leftBound; j < rightBound; j++) {
            if (numbers.get(j) < pivot) {
                swap(numbers, i, j);
                ++i;
            }
        }
        swap(numbers, i, rightBound);
        return i;
    }

    private double medianOfThree(ArrayList<Double> numbers, int leftBound, int rightBound) {
        int mid = (leftBound + rightBound) / 2;
        if (numbers.get(mid) < numbers.get(leftBound)) {
            swap(numbers, leftBound, mid);
        }
        if (numbers.get(rightBound) < numbers.get(leftBound)) {
            swap(numbers, leftBound, rightBound);
        }
        if (numbers.get(mid) < numbers.get(rightBound)) {
            swap(numbers, mid, rightBound);
        }
        return numbers.get(rightBound);
    }

    private void swap(ArrayList<Double> numbers, int indexA, int indexB) {
        double temp = numbers.get(indexA);
        numbers.set(indexA, numbers.get(indexB));
        numbers.set(indexB, temp);
    }

}
