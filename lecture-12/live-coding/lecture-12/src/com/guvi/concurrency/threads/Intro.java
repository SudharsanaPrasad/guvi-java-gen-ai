package com.guvi.concurrency.threads;

import java.util.ResourceBundle;

public class Intro {
    /**
     * Activity:
     * Create two workers that print their task names and then exit
     * Implement one as a Thread subclass and the other as a Runnable
     */
    public static void main(String[] args) {
        // functional interface
        Runnable taskA = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task A");
            }
        };

        Runnable taskB = () -> System.out.println("Task B");

        Thread threadA = new Thread(taskA, "worker-A");
        Thread threadB = new Thread(taskB, "worker-B");

        threadA.start();
        threadB.start();

        ReusableTask rT = new ReusableTask("reusable-task-0");
        new Thread(new ReusableTask("reusable-task")).start();

        ThreadExample tE = new ThreadExample("thread-example");
        tE.start();
    }
}
