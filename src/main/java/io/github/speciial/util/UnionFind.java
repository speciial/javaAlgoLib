package io.github.speciial.util;

public class UnionFind {

    private final int[] parent;
    private final int[] rank;

    public UnionFind(int count) {
        parent = new int[count];
        rank = new int[count];

        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (rank[x] < rank[y]) {
                parent[x] = y;
            } else if (rank[x] > rank[y]) {
                parent[y] = x;
            } else {
                parent[x] = y;
                rank[y] += 1;
            }
        }
    }

}
