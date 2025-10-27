package com.guvi.concurrency;

public class ThreadExample8 implements Runnable {
    private boolean stopRequested = false;

    public synchronized void requestStop() {
        this.stopRequested = true;
    }

    public synchronized boolean isStopRequested() {
        return this.stopRequested;
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch(InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void run() {
        System.out.println("ThreadExample8 running...");
        while(!isStopRequested()) {
            sleep(1000);
            System.out.println("...");
        }
        System.out.println("ThreadExample8 stopped");
    }

    public static void main(String[] args) {
        // Create an instance of ThreadExample8, containing the task
        ThreadExample8 tE = new ThreadExample8();

        // Create an instance of thread, with the task and a custom name
        Thread thread = new Thread(tE, "Thread 1");
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Requesting stop...");
        tE.requestStop();
        System.out.println("stop requested");


    }
}
