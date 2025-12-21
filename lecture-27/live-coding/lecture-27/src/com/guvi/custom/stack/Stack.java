package com.guvi.custom.stack;

public class Stack {
    private int[] elements;
    private int top;

    public Stack(int capacity) {
        elements = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        // capacity will exceed
        if(top == elements.length -1) {
            throw new IllegalStateException("Stack is full");
        }
        //top = top + 1;
        /*
            // Approach 1
            top++;
            elements[top] = value;
        */
        // Prefix
        elements[++top] = value;
    }

    public int pop() {
        if(top == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        /*
            // Approach 1
            int value = elements[top];
            top--;
            return value;
         */

        return elements[top--];
    }

    // Implement: Peek in a Stack
    public int peek() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[top];
    }

    public boolean isEmpty() {
        /*
            // Approach 1
            if(top == -1) {     // top == -1 -> true or false
                return true;
            }
            return false;
         */
        // will equal true if top equals -1
        return top == -1;
    }

    // the size of a stack -> the number of elements in the stack (counting from 1)
    public int size() {
        return top + 1;
    }

    /*
        pop all elements
        pop -> peek -- handle the exception
        pop -> size -- until the size equals 0
        pop -> isEmpty -- already returns true/false
     */
    public void popAll() {
        while (!isEmpty()) {
            System.out.println("Popped: " + pop());
        }
    }

    // toString -> iterate over each element,
    // and print the value at each index

}
