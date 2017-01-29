package com.algo.graphs;

import com.algo.ADT;

import java.util.HashSet;
import java.util.Set;

/**
 * All paths are computed using DFS
 *
 * Created by Subramanyam on 15-Dec-2016.
 */
public class Paths {

    private final int s;
    private Set<Integer> visited;
    private int[] parent;   //Parent Links, based on visted order of nodes
    
    public Paths(Graph G, int s) {
        visited = new HashSet<Integer>();
        parent = new int[G.vertices()];
        this.s = s;
        DFS(G, s);
    }

    private void DFS(Graph G, int s) {

        visited.add(s);

        for (int w : G.adj(s)) {
            if(!visited.contains(w)) {
                parent[w] = s;
                DFS(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return visited.contains(v);
    }

    public Iterable<Integer> pathTo(int v) {

        ADT.Stack<Integer> path = new ADT.Stack<Integer>();

        for (int x = v ; x != s ; x = parent[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
