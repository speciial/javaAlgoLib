package io.github.speciial.util;

import java.util.Arrays;

public class IndexedMinPriorityQueue {

    private final int maxHeapSize;
    private int heapSize;

    private final double[] keys;
    private final int[] indices;

    public IndexedMinPriorityQueue(int maxHeapSize) {
        this.maxHeapSize = maxHeapSize;
        this.heapSize = 0;

        this.keys = new double[maxHeapSize];
        Arrays.fill(keys, Double.POSITIVE_INFINITY);


        this.indices = new int[maxHeapSize];
        Arrays.fill(indices, -1);
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean containsIndex(int index) {
        return findMapIndex(index) != -1 && indices[findMapIndex(index)] != -1;
    }

    public void insert(int index, double key) {
        if (heapSize == maxHeapSize) {
            throw new RuntimeException("Heap Overflow: Could not insert key");
        }

        heapSize++;
        int insertIndex = heapSize - 1;

        keys[index] = key;
        indices[insertIndex] = index;

        while (insertIndex != 0 && keys[indices[parent(insertIndex)]] > keys[indices[insertIndex]]) {
            swap(insertIndex, parent(insertIndex));
            insertIndex = parent(insertIndex);
        }
    }

    public int extract() {
        if (heapSize <= 0) {
            throw new RuntimeException("Heap Underflow: No elementes in Heap");
        }

        int minIndex = indices[0];
        indices[0] = indices[heapSize - 1];
        indices[heapSize - 1] = -1;

        heapSize--;
        minHeapify(0);

        // double min = keys[minIndex];
        keys[minIndex] = Double.POSITIVE_INFINITY;

        return minIndex;
    }

    public void decreaseKey(int index, double key) {
        int mapIndex = findMapIndex(index);
        if (indices[mapIndex] == -1) {
            throw new RuntimeException("Index does not exist");
        }
        if (keys[index] < key) {
            throw new RuntimeException("New key has to be smaller than existing key");
        }
        keys[index] = key;


        while (index != 0 && keys[indices[parent(mapIndex)]] > keys[indices[mapIndex]]) {
            swap(mapIndex, parent(mapIndex));
            mapIndex = parent(mapIndex);
        }
    }

    private void minHeapify(int index) {
        int l = left(index);
        int r = right(index);
        int smallest = index;
        if (l < heapSize && keys[indices[l]] < keys[indices[index]]) {
            smallest = l;
        }
        if (r < heapSize && keys[indices[r]] < keys[indices[smallest]]) {
            smallest = r;
        }
        if (smallest != index) {
            swap(index, smallest);
            minHeapify(smallest);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return (2 * index + 1);
    }

    private int right(int index) {
        return (2 * index + 2);
    }

    private void swap(int i, int j) {
        int temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;
    }

    private int findMapIndex(int index) {
        int result = -1;
        for (int i = 0; i < heapSize; i++) {
            if(indices[i] == index) { result = i; }
        }
        return result;
    }

}
