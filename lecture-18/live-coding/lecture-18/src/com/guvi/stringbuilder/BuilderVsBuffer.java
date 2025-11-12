package com.guvi.stringbuilder;

public class BuilderVsBuffer {
    // static - global variable
    public static StringBuilder sb = new StringBuilder();
    public static StringBuffer sbuf = new StringBuffer();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                sb.append("A");
                sbuf.append("B");
            }
        };
        // simulating the execution of two threads running simultaneously
        // multi-threading
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Builder length: " + sb.length());
        System.out.println("Buffer length: " + sbuf.length());
    }
}

