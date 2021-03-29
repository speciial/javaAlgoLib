package io.github.speciial;

public class SelectionSortAlgorithm implements SortingAlgorithm {

    int[] data;

    public SelectionSortAlgorithm() {
        data = new int[0];
    }

    @Override
    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public void sort() {
        for (int sortingIndex = 0; sortingIndex < (data.length - 1); sortingIndex++) {
            int minIndex = sortingIndex;
            for (int moveIndex = sortingIndex + 1; moveIndex < data.length; moveIndex++) {
                if(data[moveIndex] < data[minIndex]) {
                    minIndex = moveIndex;
                }
            }
            if(minIndex != sortingIndex) {
                int temp = data[sortingIndex];
                data[sortingIndex] = data[minIndex];
                data[minIndex] = temp;
            }
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
