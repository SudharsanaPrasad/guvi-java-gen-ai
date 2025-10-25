package com.guvi.concurrency.threads;

public class JoinVsSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {}

            System.out.println("A");
        }, "A");

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {}
            System.out.println("B");
        }, "B");

        t1.start();
        t2.start();

        t2.join();
        System.out.println("after B");
    }

}
