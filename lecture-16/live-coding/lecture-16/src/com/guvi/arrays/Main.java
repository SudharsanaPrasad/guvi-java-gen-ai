package com.guvi.arrays;

public class Main {
    public static void main(String[] args) {
        int[] scores = { 85, 40, 23 };
        System.out.println(scores.length);  // 3
        // System.out.println(scores[5]);  // error!
        for(int n : scores) {
            System.out.println("Value: " + n);
        }
    }
}
