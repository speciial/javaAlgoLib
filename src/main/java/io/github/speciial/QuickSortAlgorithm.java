package io.github.speciial;

public class QuickSortAlgorithm implements SortingAlgorithm {

    /*
        Use a better method of determining the pivot element.
     */

    private int[] data;

    public QuickSortAlgorithm() {
        data = new int[0];
    }

    @Override
    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public void sort() {
        quickSort(0, (data.length - 1));
    }

    @Override
    public int getItem(int index) {
        return data[index];
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    private void quickSort(int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int partitionIndex = partition(leftBound, rightBound);
            quickSort(leftBound, (partitionIndex - 1));
            quickSort((partitionIndex + 1), rightBound);
        }
    }

    private int partition(int leftBound, int rightBound) {
        int pivot = data[rightBound];
        int sortIndex = leftBound;
        for(int swapIndex = leftBound; swapIndex < rightBound; swapIndex++) {
            if(data[swapIndex] < pivot) {
                swap(sortIndex, swapIndex);

                ++sortIndex;
            }
        }
        swap(sortIndex, rightBound);
        return sortIndex;
    }

    private void swap(int indexA, int indexB) {
        int temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }
}
