package com.guvi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * NOT a generic implementation
 * Adj. List based graph
 * Nodes are Integers 0...(n-1)
 *
 * Directed vs undirected?
 *  - instance variable, directed, to set the type of Graph
 *      - boolean -> true = directed, false = undirected
 */
public class Graph {
    private int n;
    // controlling whether an insertion adds one direction or two
    private boolean directed;
    // adj[u] hold u's neighbors (outgoing degrees)
    private List<List<Integer>> adj;
    // Alternative:
    // private HashMap<Integer, List<Integer>> adj;

    public Graph(int n, boolean directed) {
        // Exception: n is negative?

        this.n = n;
        this.directed = directed;

        this.adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            this.adj.add(new ArrayList<>());
        }
    }

    /**
     * Add an edge u -> v
     * For undirected graphs, we need to store both u -> v and v -> u
     */
    public void addEdge(int u, int v) {
        validateNode(u);
        validateNode(v);

        // Default: directed graph - outdegree
        adj.get(u).add(v);
        // Undirected graph scenario
        if(!directed) {
            adj.get(v).add(u);
        }
    }

    private void validateNode(int u) {
        // u >= n ->
        if(u < 0 || u >= n) {
            throw new IllegalArgumentException("Invalid node " + u);
        }
    }

    /**
     * Return the list of neighbors given a node, u
     * @param u
     * @return
     */
    public List<Integer> neighbors(int u) {
        validateNode(u);
        return adj.get(u);
    }

    public int size() {
        return n;
    }

    /**
     * DFS traversal given a starting node
     * What're we doing below?
     *  - commit to the next available neighbors immediately
     *  - when we hit a node with no unvisited neighbors, we need to backtrack
     *
     *  Since we'll perform backtracking to explore the graph -> we'll be using recursion
     */
    // public method - so instances of Graph class can call that method
    public List<Integer> dfsTraversal(int start) {
        validateNode(start);

        // an initial representation of the visited array
        boolean[] visited = new boolean[n];
        List<Integer> output = new ArrayList<>();

        dfsVisit(start, visited, output);

        return output;
    }

    // private method - the recursion will happen here

    /**
     * Explore nodes that're reachable and track nodes at first discovery
     *
     * @param start
     * @param visited
     * @param output
     */
    private void dfsVisit(int node, boolean[] visited, List<Integer> output) {
        // track the node as visited first given the node index
        visited[node] = true;
        // add it to the output
        output.add(node);

        // adj.get(node) -> List<Integer> (neighbors)
        for(int neighbor : adj.get(node)) {
            // visit the first neighbor that wasn't visited previously
            if(!visited[neighbor]) {
                dfsVisit(neighbor, visited, output);
            }
        }
    }
}
