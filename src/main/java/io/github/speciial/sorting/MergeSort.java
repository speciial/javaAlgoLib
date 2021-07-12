package io.github.speciial.sorting;

public class MergeSort {

    /**
     * Runs the Merge Sort Algorithm on @numbers. Sorting is done in place.
     *
     * @param numbers Array to sort.
     */
    public MergeSort(double[] numbers) {
        sort(numbers, 0, (numbers.length - 1));
    }

    private void sort(double[] numbers, int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int mid = (leftBound + rightBound) / 2;

            sort(numbers, leftBound, mid);
            sort(numbers, (mid + 1), rightBound);

            merge(numbers, leftBound, mid, rightBound);
        }
    }

    private void merge(double[] numbers, int leftBound, int mid, int rightBound) {
        int n = mid - leftBound + 1;
        int m = rightBound - mid;

        double[] L = new double[n + 1];
        double[] R = new double[m + 1];
        for (int i = 0; i < n; i++) {
            L[i] = numbers[leftBound + i];
        }
        for (int j = 0; j < m; j++) {
            R[j] = numbers[mid + j + 1];
        }
        L[n] = Double.POSITIVE_INFINITY;
        R[m] = Double.POSITIVE_INFINITY;

        int i = 0;
        int j = 0;
        for (int k = leftBound; k <= rightBound; k++) {
            if(L[i] <= R[j]) {
                numbers[k] = L[i];
                ++i;
            } else {
                numbers[k] = R[j];
                ++j;
            }
        }
    }

}
