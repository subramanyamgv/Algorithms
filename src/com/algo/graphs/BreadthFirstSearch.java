package com.algo.graphs;

import com.algo.ADT;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Subramanyam on 15-Dec-2016.
 */
public class BreadthFirstSearch {

    private Set<Integer> visited;

    public BreadthFirstSearch(Graph G, int s) {
        visited = new HashSet<Integer>();
    }

    /**
     * Breadth First Traversal of graph - based on Queue
     * @param G
     * @param s
     */
    private void BFS(Graph G, int s) {

        ADT.Queue<Integer> Q = new ADT.Queue<Integer>();
        Q.offer(s);

        while (!Q.isEmpty()) {

            int v = Q.poll();

            for (int w : G.adj(v)) {
                if (!visited.contains(w)) {
                    Q.offer(w);
                    visited.add(w);
                }
            }
        }
    }

}
