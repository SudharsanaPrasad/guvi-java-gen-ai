package com.guvi.concurrency;

public class ThreadExample6 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");
        };

        Thread thread = new Thread(runnable, "Thread 1");
        thread.start();
    }
}
