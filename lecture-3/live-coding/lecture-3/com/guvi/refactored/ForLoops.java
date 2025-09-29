package com.guvi.refactored;

public class ForLoops {
    public static void main(String[] args) {
        // for(int i = 0; i < 10; i++) { System.out.println(i); }
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // int n = 10; for(int i = 0; i < n; i++) { System.out.println(i); }
        {
            int n = 10;
            for (int i = 0; i < n; i++) {
                System.out.println(i);
            }
        }

        // int n = 10; for(int i = n; i >= 0; i--) { System.out.println(i); }
        {
            int n = 10;
            // i-- -> decrementing the value of i by 1
            for (int i = n; i >= 0; i--) {
                System.out.println(i);
            }
        }

        // int n = 100; for(int i = 0; i <= n; i = i + 10) { System.out.println(i); }
        {
            int n = 100;
            for (int i = 0; i <= n; i = i + 10) {
                System.out.println(i);
            }
        }
    }
}
