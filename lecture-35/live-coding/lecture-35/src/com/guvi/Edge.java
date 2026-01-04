package com.guvi;

public class Edge {
    public int to;
    public int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
            "to=" + to +
            ", weight=" + weight +
            '}';
    }
}
