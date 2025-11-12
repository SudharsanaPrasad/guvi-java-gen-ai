package com.guvi.recursion;

public class FibonacciSeq {
    public static void main(String[] args) {
        // memoization
        System.out.println(fibonacci(3));
    }

    // n = 3
    public static long fibonacci(int n) {
        // Base Cases (handles 0 and 1)
        if (n <= 1) {
            return n;
        }

        // Recursive Step (two calls, creating a tree)
        // return fibonacci(3 - 1) + fibonacci(3 - 2);
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
// Fib sequence - is a sequence of numbers where each number is the sum of two preceding numbers
// 0, 1, 1, 2, 3, 5, 8......
// 3rd -> 0 + 1 => 1
// 4th -> 1 + 1
// nth number is 6 =>


