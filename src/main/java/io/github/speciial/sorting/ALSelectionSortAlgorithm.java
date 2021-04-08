package io.github.speciial.sorting;

import java.util.ArrayList;

public class ALSelectionSortAlgorithm implements SortingAlgorithm{

    private ArrayList<Integer> data;

    public ALSelectionSortAlgorithm() {
        data = new ArrayList<>();
    }

    @Override
    public void sort() {
        for (int sortingIndex = 0; sortingIndex < (data.size() - 1); sortingIndex++) {
            int minIndex = sortingIndex;
            for (int moveIndex = sortingIndex + 1; moveIndex < data.size(); moveIndex++) {
                if(data.get(moveIndex) < data.get(minIndex)) {
                    minIndex = moveIndex;
                }
            }
            if(minIndex != sortingIndex) {
                swap(sortingIndex, minIndex);
            }
        }
    }

    private void swap(int indexA, int indexB) {
        int temp = data.get(indexA);
        data.set(indexA, data.get(indexB));
        data.set(indexB, temp);
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
