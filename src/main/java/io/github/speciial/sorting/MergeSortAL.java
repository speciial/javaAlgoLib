package io.github.speciial.sorting;

import java.util.ArrayList;

public class MergeSortAL {

    /**
     * Runs the Merge Sort Algorithm on @numbers. Sorting is done in place.
     *
     * @param numbers ArrayList to sort.
     */
    public MergeSortAL(ArrayList<Double> numbers) {
        sort(numbers, 0, (numbers.size() - 1));

    }

    private void sort(ArrayList<Double> numbers, int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int mid = (leftBound + rightBound) / 2;

            sort(numbers, leftBound, mid);
            sort(numbers, (mid + 1), rightBound);

            merge(numbers, leftBound, mid, rightBound);
        }
    }

    private void merge(ArrayList<Double> numbers, int leftBound, int mid, int rightBound) {
        int n = mid - leftBound + 1;
        int m = rightBound - mid;

        double[] L = new double[n + 1];
        double[] R = new double[m + 1];
        for (int i = 0; i < n; i++) {
            L[i] = numbers.get(leftBound + i);
        }
        for (int j = 0; j < m; j++) {
            R[j] = numbers.get(mid + j + 1);
        }
        L[n] = Double.POSITIVE_INFINITY;
        R[m] = Double.POSITIVE_INFINITY;

        int i = 0;
        int j = 0;
        for (int k = leftBound; k <= rightBound; k++) {
            if(L[i] <= R[j]) {
                numbers.set(k, L[i]);
                ++i;
            } else {
                numbers.set(k, R[j]);
                ++j;
            }
        }
    }

}
