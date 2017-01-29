package com.algo.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Subramanyam on 15-Dec-2016.
 */
public class AcyclicGraph {

    private boolean hasCycle = false;
    private Set<Integer> visited;

    public AcyclicGraph(Graph G) {
        visited = new HashSet<Integer>();

        for (int s = 0 ; s < G.vertices() ; s++) {
            if (!visited.contains(s))
                DFS(G, s, s);
        }
    }

    private void DFS(Graph G, int v, int u) {

        visited.add(v);

        for (int w : G.adj(v)) {

            if (!visited.contains(w)) {
                DFS(G, w, v);
            } else {
                if (w != u) hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

}
