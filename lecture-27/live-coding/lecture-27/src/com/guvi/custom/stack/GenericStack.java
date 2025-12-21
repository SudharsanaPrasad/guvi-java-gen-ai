package com.guvi.custom.stack;

import java.util.EmptyStackException;

// GenericStack<Integer> stack = new GenericStack<>();

public class GenericStack<T> {
    private final Object[] elements; // we store as Object[] and cast to T
    private int top;

    public GenericStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        elements = new Object[capacity];
        top = -1;
    }

    // Push a new value onto the stack
    public void push(T value) {
        // capacity will exceed
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        elements[++top] = value;
    }

    // Pop the top value and return it
    public T pop() {
        if (isEmpty()) {
            //Valid Exception: throw new EmptyStackException();
            throw new IllegalStateException("Stack is empty");
        }
        T value = (T) elements[top];
        elements[top] = null; // avoid memory leak
        top--;
        return value;
    }

    // Look at the top value without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T value = (T) elements[top];
        return value;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == elements.length - 1;
    }

    // Current number of elements in the stack
    public int size() {
        return top + 1;
    }

    /*
     * Pop all elements and print them.
     * This is just a utility method you already had.
     */
    public void popAll() {
        while (!isEmpty()) {
            System.out.println("Popped: " + pop());
        }
    }

    // toString -> iterate over each element and print the value at each index
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack[");
        for (int i = 0; i <= top; i++) {
            sb.append(elements[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
