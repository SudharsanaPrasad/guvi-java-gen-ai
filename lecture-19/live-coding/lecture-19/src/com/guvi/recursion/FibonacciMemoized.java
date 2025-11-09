package com.guvi.recursion;

import java.util.Arrays;

public class FibonacciMemoized {
    // static -> global
    // Index:   0,  1, 2,  3, 4,...
    // Initial: -1,-1,-1, -1, -1...
    //          0,  1, 1,  2, 3,...
    // Space complexity: Big O(n)
    static long[] cache;

    public static void main(String[] args) {
        // initialize the cache to -1
        int n = 3;
        // total elements in cache: 61 (including index 0)
        cache = new long[n + 1];
        Arrays.fill(cache, -1);
        System.out.println(fib(n));
    }

    /*
        cache = [-1, -1, 1, 2]
        n = 3
        n = 2
        n = 1 -> return 1
        1. Create a "cache" (an array or Map) to store results.
        1.1. Handle the base case
        2. At the start of the function, check the cache.
            If the answer is there, return it immediately.
        3. If the answer is not in the cache, compute it recursively.
        4. Before you return the new answer, save it in the cache
     */
    public static long fib(int n) {
        // base case
        // if(n <= 1) return n;
        if(n == 0) return 0;
        if(n == 1) return 1;

        // check the cache at position n
        if(cache[n] != -1) {
            // return the value
            return cache[n];        // = fib(n-1) + fib(n-2);
        }
        // n=3 -> fib(2)=1 + fib(1)=1 -- 1 + 1 -> 2
        // n=2 -> fib(1)=1 + fib(0)=0 -- 1 + 0 -> 1
        cache[n] = fib(n-1) + fib(n-2);
        // check if cache[n] == -1

        return cache[n];
    }
}
