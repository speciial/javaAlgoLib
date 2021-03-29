package io.github.speciial;

public class HeapSortAlgorithm implements SortingAlgorithm {

    /*
        heap functions parent, left and right can be optimized by
        bit-shifting instead of multiplying or dividing.
     */

    private int[] data;

    private int heapSize;

    public HeapSortAlgorithm() {
        data = new int[0];
    }

    @Override
    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public void sort() {
        buildMaxHeap();
        for (int index = (data.length - 1); index > 0; index--) {
            int temp = data[0];
            data[0] = data[index];
            data[index] = temp;

            --heapSize;
            maxHeapify(0);
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

    private void buildMaxHeap() {
        heapSize = data.length;
        for (int index = (data.length / 2); index >= 0; index--) {
            maxHeapify(index);
        }
    }

    private void maxHeapify(int index) {
        int leftIndex = left(index);
        int rightIndex = right(index);
        int largestIndex = index;

        if ((leftIndex < heapSize) && (data[leftIndex] > data[index])) {
            largestIndex = leftIndex;
        }
        if ((rightIndex < heapSize) && (data[rightIndex] > data[largestIndex])) {
            largestIndex = rightIndex;
        }
        if (largestIndex != index) {
            int temp = data[index];
            data[index] = data[largestIndex];
            data[largestIndex] = temp;

            maxHeapify(largestIndex);
        }
    }

    private int left(int index) {
        return ((2 * index) + 1);
    }

    private int right(int index) {
        return ((2 * index) + 2);
    }
}
