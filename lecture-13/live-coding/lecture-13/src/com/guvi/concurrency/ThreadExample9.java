package com.guvi.concurrency;

public class ThreadExample9 {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch(InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            while(true) {
                sleep(1000);
                System.out.println("Running...");
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        sleep(3000);
        // Even though the main method has terminated,
        // the JVM will keep the thread active & it'll
        // keep running
        // How do we stop it?
        // Make thread a daemon thread using setDaemon(true)
    }
}
