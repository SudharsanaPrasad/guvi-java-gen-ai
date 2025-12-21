package com.guvi.custom.queue;

public class Main {
    public static void main(String[] args) {
        // Type of Object -> accept int, String, and all types
        LinkedQueue<Object> queue = new LinkedQueue<>();
        queue.enqueue(15);
        queue.enqueue("test");

        LinkedQueue<Integer> queue2 = new LinkedQueue<>();
        queue2.enqueue(15);
        queue2.enqueue(30);

        // dequeueAll
    }
}
