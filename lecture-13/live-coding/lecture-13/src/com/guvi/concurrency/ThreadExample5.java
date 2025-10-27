package com.guvi.concurrency;

public class ThreadExample5 {
    public static void main(String[] args) {
        // Lambda expression
        Runnable runnable = () -> {
            System.out.println("Lambda running...");
            System.out.println("Lambda finished");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
