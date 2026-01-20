package com.guvi.concurrency;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<Integer> {

    public static void main(String[] args) {
        CallableDemo demo = new CallableDemo();

        // Calling call() directly is fine for a demo.
        // In real concurrency code, you normally submit a Callable to an
        // ExecutorService (reference: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html).
        try {
            System.out.println(demo.call());
        } catch (Exception ex) {
            System.out.println("Callable failed: " + ex.getMessage());
        }
    }

    @Override
    public Integer call() throws Exception {
        // Callable can return a value and can throw checked exceptions.
        // throw new IllegalArgumentException("Message");
        return 34;
    }
}
