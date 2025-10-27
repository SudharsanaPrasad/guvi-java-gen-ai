package com.guvi.concurrency.threads;

public class ReusableTask implements Runnable {
    private String label;

    public ReusableTask(String label) {
        this.label = label;
    }

    @Override
    public void run() {
        System.out.println(label + "is running");
    }
}
