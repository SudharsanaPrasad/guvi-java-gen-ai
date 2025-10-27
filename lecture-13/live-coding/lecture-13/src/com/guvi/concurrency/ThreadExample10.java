package com.guvi.concurrency;

public class ThreadExample10 {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch(InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for(int i = 0; i < 5; i++) {
                sleep(1000);
                System.out.println("Running...");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        thread.setDaemon(true);

        // Since we've set the thread as a daemon thread,
        // it'll terminate as soon as the main thread terminates

        // How do we prevent such termination?
        // use join() method on thread

//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
