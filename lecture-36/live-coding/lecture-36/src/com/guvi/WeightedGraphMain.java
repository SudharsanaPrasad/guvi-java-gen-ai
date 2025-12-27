package com.guvi;

public class WeightedGraphMain {
    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph(6, false);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 20);

        g.addEdge(1, 3, 40);
        g.addEdge(2, 3, 15);

        g.addEdge(2, 4, 25);
        g.addEdge(4, 5, 35);

        g.addEdge(5, 2, 56);

        System.out.println(g.neighbors(0));
    }
}
