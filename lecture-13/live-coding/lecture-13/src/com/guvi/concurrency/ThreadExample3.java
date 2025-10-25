package com.guvi.concurrency;

public class ThreadExample3 implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable running...");
        System.out.println("Runnable finished");
    }

    public static void main(String[] args) {
        // Option 1: create an instance of ThreadExample3
        // Impact: a new thread will not be created
        // when using Runnable
        ThreadExample3 thread = new ThreadExample3();
        thread.run();

        // Option 2: create a thread and pass the instance of
        // ThreadExample3
        Thread thread2 = new Thread(new ThreadExample3());
        thread2.start();
    }
}
