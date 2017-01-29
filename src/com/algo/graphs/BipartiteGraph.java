package com.algo.graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Verify if the graph is Bipartite
 * Solution: Is graph two-colorable? Use DFS to color alternate nodes
 *
 * Created by Subramanyam on 15-Dec-2016.
 */
public class BipartiteGraph {

    private Set<Integer> visited;
    private boolean []color;
    private boolean isBipartite = true;

    public BipartiteGraph(Graph G) {
        visited = new HashSet<Integer>();
        color = new boolean[G.vertices()];

        for (int v = 0; v < G.vertices() ; v++) {
            if (!visited.contains(v))
                DFS(G, v);
        }
    }

    private void DFS(Graph G, int v) {

        visited.add(v);

        for (int w : G.adj(v)) {

            if (!visited.contains(w)) {
                color[w] = !color[v];
                DFS(G, w);
            } else {
                if (color[w] == color[v])
                    isBipartite = false;
            }
        }
    }

    public boolean isBipartite() {
        return isBipartite;
    }

    public Iterable<Integer> visited() {
        return visited;
    }
}
