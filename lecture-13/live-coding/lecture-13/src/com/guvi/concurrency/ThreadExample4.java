package com.guvi.concurrency;

public class ThreadExample4 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable running...");
                System.out.println("Runnable finished");
            }
        };

        Thread thread = new Thread(runnable);
        // Option 1: call start on a thread instance
        // Impact: JVM tells the operating system (OS)
        // to create a new thread, including allocating memory.
        // The JVM then automatically calls the run method inside
        // the new thread, which executes our custom Runnable
        // implementation
        thread.start();

        // Option 2: call run on a thread instance
        // Impact: the task is executed on the current thread
        // It's just like calling a normal method on an object
        thread.run();
    }
}
