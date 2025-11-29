package com.guvi.custom.queue;

public class LinkedQueue<T> {

    private static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T value) {
            data = value;
            next = null;
        }
    }

    // first element
    private Node<T> front;
    // last element
    private Node<T> rear;
    // # of elements in the queue
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);

        // if the queue is empty
        if(isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // remove the first node and return
    public T dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        // capture the data to return
        T value = front.data;

        // move front up by one
        front = front.next;

        // check if the queue is empty; if so, rear should also equal null
        if(front == null) {
            rear = null;
        }

        size--;
        return value;
    }

}
