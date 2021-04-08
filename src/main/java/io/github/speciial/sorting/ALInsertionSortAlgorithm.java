package io.github.speciial.sorting;

import java.util.ArrayList;

public class ALInsertionSortAlgorithm implements SortingAlgorithm {

    private ArrayList<Integer> data;

    public ALInsertionSortAlgorithm() {
        data = new ArrayList<>();
    }

    @Override
    public void sort() {
        for (int sortingIndex = 1; sortingIndex < data.size(); sortingIndex++) {
            int key = data.get(sortingIndex);
            int moveIndex = sortingIndex - 1;
            while ((moveIndex >= 0) && (data.get(moveIndex) > key)) {
                data.set((moveIndex + 1), data.get(moveIndex));
                --moveIndex;
            }
            data.set((moveIndex + 1), key);
        }
    }

    @Override
    public void setData(int[] data) {
        this.data = arrayToArrayList(data);
    }

    @Override
    public int getItem(int index) {
        return data.get(index);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private ArrayList<Integer> arrayToArrayList(int[] data) {
        ArrayList<Integer> result = new ArrayList<>(data.length);
        for (int number : data) {
            result.add(number);
        }
        return result;
    }

}
