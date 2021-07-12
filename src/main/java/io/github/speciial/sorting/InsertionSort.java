package io.github.speciial.sorting;

public class InsertionSort {

    /**
     * Runs the Insertion Sort Algorithm on @numbers. Sorting is done in place.
     *
     * @param numbers Array to sort.
     */
    public InsertionSort(double[] numbers) {
        for (int j = 1; j < numbers.length; j++) {
            double key = numbers[j];
            int i = j - 1;
            while ((i >= 0) && (numbers[i] > key)) {
                numbers[i + 1] = numbers[i];
                --i;
            }
            numbers[i + 1] = key;
        }
    }

}
