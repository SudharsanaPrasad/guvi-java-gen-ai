package com.guvi.concurrency;

public class ThreadExample7 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");

            try {
                Thread.sleep(2000);
            } catch(InterruptedException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }

            System.out.println(threadName + " finished");
        };

        Thread thread = new Thread(runnable, "Thread 1");
        thread.start();
    }
}
