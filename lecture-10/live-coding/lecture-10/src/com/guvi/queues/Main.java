package com.guvi.queues;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(3);
        pq.add(10);
        pq.add(7);
        pq.add(2);

        System.out.println("Head of the queue " + pq.peek());
        Integer obj = (Integer) pq.poll();
        System.out.println(obj);
    }
}
