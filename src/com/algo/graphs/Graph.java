package com.algo.graphs;

import com.algo.LinkedList;

/**
 * Created by Subramanyam on 15-Dec-2016.
 */
public class Graph {

    private LinkedList<Integer> []adj;
    private int V;
    private int E;

    /**
     * Creates an V-vertex graph with no edges
     * @param V
     */
    public Graph(int V) {
        this.V = V; this.E = 0;
        adj = new LinkedList[V];
        for (int i = 0 ; i < V ; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    /**
     * Return number of vertices
     * @return
     */
    public int vertices() {
        return V;
    }

    /**
     * Return number of edges
     * @return
     */
    public int edges() {
        return E;
    }

    /**
     * Add edge v-w to the graph
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    /**
     * Return vertices adjacent to v
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * Get degree of vertices
     * @param v
     * @return
     */
    public int degree(int v) {
        int degree = 0;
        for (int w : adj(v)) {
            degree++;
        }
        return degree;
    }

    /**
     * Count number of self-loops
     * @return
     */
    public int nSelfLoops() {
        int count = 0;
        for (int v = 0 ; v < V ; v++) {
            for (int w : adj(v)) {
                if (v == w) count++;
            }
        }
        return count;
    }

    /**
     * String representation of graph
     * @return
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(this.V + " vertices, " + this.E + " edges\n");
        for (int i = 0 ; i < V ; i++) {
            sb.append(i + ": ");
            for (int e : adj(i)) {
                sb.append(e + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
