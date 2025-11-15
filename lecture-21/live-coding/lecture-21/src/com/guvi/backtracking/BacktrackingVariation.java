package com.guvi.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Problem:
You have numbers [2, 3, 5] and a limit K = 5.
Generate all subsequences whose sum is ≤ 5.
(Assume all numbers are non-negative.)
 */
public class BacktrackingVariation {

    /**
     * Recursive approach to backtracking an input array
     * @param nums      the input array
     * @param index     the position in nums we're currently considering
     * @param current   the subsequence we have chosen so far
     * @param currentSum   the sum of the subsequence, current
     * @param K
     * index++ - dicsus
     */
    private static void backtrack(int[] nums, int index,
                                  List<Integer> current, int currentSum, int K) {
        // Pruning condition
        // if the currentSum > K -> no further exploration required; return

        // Base case
        // if the index == nums.length - 1 --> we've reached the end of the array
            // at this point, currentSum <= K
            // print current
            // return

        // decision 1: TAKE nums[index]
        // choosing to include the current element in the subsequence
        // add nums[index] to current
        // new current sum -> currentSum + nums[index]
        // backtrack(nums, index + 1, current, newCurrentSum, K )

        // decision 2: SKIP nums[index]
        // remove the last element we added from current
        // backtrack(nums,index + 1, current, currentSum, K)

    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 5 };
        int K = 5;
        backtrack(nums, 0, new ArrayList<>(), 0, K);

    }
}
