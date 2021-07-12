package io.github.speciial.sorting;

public class SelectionSort {

    /**
     * Runs the Selection Sort Algorithm on @numbers. Sorting is done in place.
     *
     * @param numbers Array to sort.
     */
    public SelectionSort(double[] numbers) {
        for (int j = 0; j < (numbers.length - 1); j++) {
            int minIndex = j;
            for (int i = j + 1; i < numbers.length; i++) {
                if(numbers[i] < numbers[minIndex]) {
                    minIndex = i;
                }
            }
            if(minIndex != j) {
                swap(numbers, j, minIndex);
            }
        }
    }

    private void swap(double[] numbers, int indexA, int indexB) {
        double temp = numbers[indexA];
        numbers[indexA] = numbers[indexB];
        numbers[indexB] = temp;
    }

}
