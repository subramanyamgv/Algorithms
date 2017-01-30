package com.algo.graphs;

import com.algo.adt.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Shortest paths are computed using BFS.
 *
 * Created by Subramanyam on 15-Dec-2016.
 */
public class ShortestPaths {

    private Set<Integer> visited;
    private int[] parent;
    private final int s;

    public ShortestPaths(Graph G, int s) {
        visited = new HashSet<Integer>();
        parent = new int[G.vertices()];
        this.s = s;

        for (int v = 0 ; v < G.vertices() ; v++) {
            if (!visited.contains(v)) {
                BFS(G, s);
            }
        }
    }

    private void BFS(Graph G, int s) {

        Queue<Integer> Q = new Queue<Integer>();

        Q.offer(s);

        while (!Q.isEmpty()) {

            int v = Q.poll();
            visited.add(v);

            for (int w : G.adj(v)) {
                if (!visited.contains(w)) {
                    Q.offer(w);
                    parent[w] = v;
                    visited.add(w);
                }
            }
        }

    }

    public boolean hasPathTo(int v) {
        return visited.contains(v);
    }

    public Iterable<Integer> pathTo(int v) {

        Stack<Integer> path = new Stack<Integer>();

        for (int x = v ; x != s ; x = parent[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    /**
     * Return sum of lengths of shortest paths between all vertices
     * @return
     */
    public int wienerIndex() {

//        for (int s = parent.length - 1 ; s > 0 ; s--) {
//
//            int pathLen = 0;
//
//            for (int x = s ; )
//        }

        return 0;
    }
}
