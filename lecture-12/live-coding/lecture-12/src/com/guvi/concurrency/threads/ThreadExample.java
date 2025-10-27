package com.guvi.concurrency.threads;

public class ThreadExample extends Thread {

    public ThreadExample(String name) {
        super(name);
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " Executing a thread");
    }
}
