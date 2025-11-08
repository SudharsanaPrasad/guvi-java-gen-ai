package com.guvi.slidingwindow;

import java.util.Arrays;

// Problem: Print the sum of every k consecutive numbers, k=3
public class InEfficientSubarray {
    // sum: compute the sum of the subarray (k elements)
//    public static int sum(int[] array) {
//        // TODO
//    }

    // subarray: given the first and last index
    // time complexity: O(n * k)
    public static void sum(int[] array, int k) {
        // n - k
        for (var i = 0; i <= array.length - k; i++) {
            int sum = 0;
            // this loop should run k times
            for (var j = i; j < i + k; j++) {
                sum += array[j];
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 4};
        int k = 3;
        // Arrays.copyOfRange()
        sum(nums, k);

    }
}
