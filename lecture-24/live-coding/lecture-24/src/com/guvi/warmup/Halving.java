package com.guvi.warmup;

public class Halving {
    public static void main(String[] args) {
        int n = 128;

        findRounds(n);
    }

    private static void findRounds(int n) {
        int rounds = 0;
        while(n > 1){
            n = n /2 ;
            rounds ++;
        }
        System.out.println(rounds);
    }
}
