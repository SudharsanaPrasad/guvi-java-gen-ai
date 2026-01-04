package com.guvi;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        // default: min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(7);
        pq.offer(2);
        pq.offer(5);

        System.out.println(pq.peek());
        while(!pq.isEmpty()) {
            Integer temp = pq.poll();
            System.out.println(temp);
        }

        // PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> a.compareTo(b));
        // max-heap
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.offer(7);
        pq2.offer(2);
        pq2.offer(5);
        System.out.println(pq2.peek());
    }
}
