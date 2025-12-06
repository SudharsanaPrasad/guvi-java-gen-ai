package com.guvi.custom.stack;

public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack(100);
        System.out.println(myStack.isEmpty());

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        System.out.println(myStack.isEmpty());
        System.out.println("Peeked: " + myStack.peek());

        System.out.println("Popped: " + myStack.pop());

        // myStack.popAll();


    }
}
