package com.algo.applications;

/**
 * Created by Subramanyam on 09-Dec-2016.
 */
public class UnionFind {

    public int []id;
    public int count;

    public UnionFind(int N) {
        id = new int[N];
        count = N;
        for (int i = 0 ; i < N ; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {

        int pId = id[p];
        int qId = id[q];

        if (pId == qId) return;

        for (int i = 0 ; i < id.length ; i++) {
            if (id[i] == pId)
                id[i] = qId;
        }

    }

    /**
     * Return id of the component where p is in.
     * @param p
     * @return
     */
    public int find(int p) {
       return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    int count() {
        return count;
    }
}
