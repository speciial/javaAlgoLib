package io.github.speciial.sorting;

import java.util.ArrayList;

public class InsertionSortAL {

    /**
     * Runs the Insertion Sort Algorithm on @numbers. Sorting is done in place.
     *
     * @param numbers ArrayList to sort.
     */
    public InsertionSortAL(ArrayList<Double> numbers) {
        for (int j = 1; j < numbers.size(); j++) {
            double key = numbers.get(j);
            int i = j - 1;
            while ((i >= 0) && (numbers.get(i) > key)) {
                numbers.set((i + 1), numbers.get(i));
                --i;
            }
            numbers.set((i + 1), key);
        }
    }


}
