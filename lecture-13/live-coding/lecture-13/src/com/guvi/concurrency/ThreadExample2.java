package com.guvi.concurrency;

public class ThreadExample2 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running...");
        System.out.println("Thread finished");
    }

    public static void main(String[] args) {
        ThreadExample2 threadEx = new ThreadExample2();
        threadEx.start();
    }
}
