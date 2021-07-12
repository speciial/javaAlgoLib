package io.github.speciial.sorting;

import java.util.ArrayList;

public class SelectionSortAL {

    /**
     * Runs the Selection Sort Algorithm on @numbers. Sorting is done in place.
     *
     * @param numbers ArrayList to sort.
     */
    public SelectionSortAL(ArrayList<Double> numbers) {
        for (int j = 0; j < (numbers.size() - 1); j++) {
            int minIndex = j;
            for (int i = j + 1; i < numbers.size(); i++) {
                if(numbers.get(i) < numbers.get(minIndex)) {
                    minIndex = i;
                }
            }
            if(minIndex != j) {
                swap(numbers, j, minIndex);
            }
        }
    }

    private void swap(ArrayList<Double> numbers, int indexA, int indexB) {
        double temp = numbers.get(indexA);
        numbers.set(indexA, numbers.get(indexB));
        numbers.set(indexB, temp);
    }

}
