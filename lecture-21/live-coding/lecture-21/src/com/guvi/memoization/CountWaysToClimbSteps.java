package com.guvi.memoization;

import java.util.Arrays;

/*

Problem: This is the exact same problem as the "Frog Jump"
(Count Ways to Reach the End). However, the naive recursive solution
is O(2^n) because it re-calculates the same values (e.g., Ways(2)) multiple times.
Task: Fix the slow recursive solution by using a "cache" (an array) to store and
reuse the results of subproblems.
Input: n = 30
Output: 1346269 (This should be computed instantly, not after a long delay).

 */
public class CountWaysToClimbSteps {
    public static int countWays(int n) {
        if(n < 0) return 0;
//        if(n <= 1) return 1;
        if(n == 0) return 1;
        if(n == 1) return 1;
        return countWays(n - 1) + countWays(n - 2);
    }

    /**
     * countWaysMemo - find the number of ways to reach step 'n'
     * Frog can take 1 or 2 steps at a time
     * @param n
     * @param cache
     * @return
     */
    public static int countWaysMemo(int n, int[] cache) {
        // Base cases
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(n == 1) return 1;

        // 1. check the cache
        // if this subproblem is NOT -1, we've solved it before
        if(cache[n] != -1) {
            // returning the memoized solution!
            return cache[n];
        }

        // 2. compute
        // we haven't solved it. Compute it recursively
         // n = 4
        // countWaysMemo(3...) + countWaysMemo(2...)
        int result = countWaysMemo(n - 1, cache) + countWaysMemo(n - 2, cache);

        // 3. update the cache
        cache[n] = result;

        return result;
    }


    public static void main(String[] args) {
        int n = 80;
        // number of ways to get to n steps -> cache
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        int result = countWaysMemo(n, cache);
        int oldResult = countWays(n);
        System.out.println(oldResult);
        System.out.println("Number of ways to reach " + n + " steps: " + result);
    }
}
