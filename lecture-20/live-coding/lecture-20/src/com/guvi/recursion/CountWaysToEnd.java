package com.guvi.recursion;

/**
 Problem: Count Ways to Reach the End (Frog Jump)

 Problem: A frog is at step 0 and wants to reach step n.
 The frog can only jump 1 step or 2 steps at a time.
 Find the total number of distinct ways the frog can reach the n-th step.
 Input: n = 4
 Output: 5
 Reasoning:
 The 5 ways to reach step 4 are: [1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2].

 How many different ways does this frog have to reach the nth step?
 4


 */
public class CountWaysToEnd {

    public static int countWays(int n) {
        // if it's a negative number, return 0
        if(n < 0) {
            return 0;
        }

        // Base case 1: if n is 0, there's 1 way (the "empty" way to start)
//        if(n == 0) {
//            return 1;
//        }

        // base case 2: if n is 1, there's 1 way (jump 1)
        if(n <= 1) {
            return 1;
        }

        // recurrence: ways(n) = ways(n-1) + ways(n-2)
        // countWays(n-1) + countWays(n-2)
        return countWays(n - 1) + countWays(n - 2);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Ways to reach step " + n + ": " + countWays(n));
    }
}
