package io.github.speciial.sorting;

import io.github.speciial.sorting.SortingAlgorithm;

public class MergeSortAlgorithm implements SortingAlgorithm {

    private int[] data;

    public MergeSortAlgorithm() {
        data = new int[0];
    }

    @Override
    public void sort() {

    }

    @Override
    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public int getItem(int index) {
        return data[index];
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
}
