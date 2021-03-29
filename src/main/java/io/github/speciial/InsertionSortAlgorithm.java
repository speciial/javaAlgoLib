package io.github.speciial;

public class InsertionSortAlgorithm implements SortingAlgorithm{

    private int[] data;

    InsertionSortAlgorithm() {
        data = new int[0];
    }

    @Override
    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public void sort() {
        for (int sortingIndex = 1; sortingIndex < data.length; sortingIndex++) {
            int key = data[sortingIndex];
            int moveIndex = sortingIndex - 1;
            while ((moveIndex >= 0) && (data[moveIndex] > key)) {
                data[moveIndex + 1] = data[moveIndex];
                --moveIndex;
            }
            data[moveIndex + 1] = key;
        }
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
