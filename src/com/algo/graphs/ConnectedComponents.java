package com.algo.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Subramanyam on 15-Dec-2016.
 */
public class ConnectedComponents {

    private Set<Integer> visited = new HashSet<Integer>();
    private int []id;
    private int count; //Number of components

    public ConnectedComponents(Graph G) {

        visited = new HashSet<Integer>();
        id = new int[G.vertices()];

        for (int v = 0 ; v < G.vertices() ; v++) {

            if (!visited.contains(v)) {
                DFS(G, v);
                count++;
            }
        }

    }

    private void DFS(Graph G, int v) {

        visited.add(v);
        id[v] = count;  //assign component id

        for (int w : G.adj(v)) {

            if (!visited.contains(w)) {
                DFS(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * Return component id of a vertex v
     * @param v
     * @return
     */
    public int id(int v) {
        return id[v];
    }

    /**
     * Returns number of components;
     * @return
     */
    public int count() {
        return count;
    }
}
