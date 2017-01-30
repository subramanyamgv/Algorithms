package com.algo.graphs;

import com.algo.adt.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Subramanyam on 15-Dec-2016.
 */
public class DepthFirstSearch {

    private Set<Integer> visited;

    /**
     * @param G
     * @param s
     */
    public DepthFirstSearch(Graph G, int s) {
        visited = new HashSet<Integer>();

//        DFS(G, s);
        DFSIterative(G, s);
    }

    private void DFS(Graph G, int s) {

        visited.add(s);

        for (int v : G.adj(s)) {
            if (!visited.contains(v))
                DFS(G, v);
        }
    }

    /**
     * Depth First Search Iterative, using stack
     * @param G
     * @param s
     */
    private void DFSIterative(Graph G, int s) {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(s);

        while (!stack.isEmpty()) {

            int v = stack.pop();
            visited.add(v);

            for (int w : G.adj(v)) {
                if (!visited.contains(w))
                    stack.push(w);
            }
        }

    }

    public Set<Integer> visited() {
        return visited;
    }

    public int count() {
        return visited.size();
    }
}
