package com.guvi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    /**
     * BFS traversal: require a graph and a starting node
     * Queue (FIFO) process nodes in order once they're discovered
     * visited[] to track the visited nodes
     */
    public static List<Integer> bfsTraversal(Graph g, int start) {
        // graph is null?
        // start is negative? if the start is greater than size()?

        List<Integer> output = new ArrayList<>();
        // visited -> [0 -> visited or not?, 1 -> visited or not?, .. 6th index -> visited or not?]
        boolean[] visited = new boolean[g.size()];
        // queue
        Queue<Integer> queue = new LinkedList<>();

        // Begin the discovery process
        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()) {
            // dequeue
            int current = queue.poll();
            output.add(current);

            // scan for neighbors
            for(int neighbor : g.neighbors(current)) {
                if(visited[neighbor]) {
                    continue;
                }
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        // Create an instance of the graph
        // add edges
        Graph g = new Graph(6, false);
        g.addEdge(0, 1);
        g.addEdge(0, 2);

        g.addEdge(1, 3);
        g.addEdge(2, 3);

        g.addEdge(2, 4);
        g.addEdge(4, 5);

        g.addEdge(5, 2);

        System.out.println(g.dfsTraversal(0));;

        // System.out.println(g.dfsTraversal(0,));;

        // System.out.println(bfsTraversal(g, 0));;

    }
}
