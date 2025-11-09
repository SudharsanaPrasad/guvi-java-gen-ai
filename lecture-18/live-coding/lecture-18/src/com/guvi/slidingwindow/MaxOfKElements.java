package com.guvi.slidingwindow;

// Find the maximum sum of any k consecutive elements, where k = 3
public class MaxOfKElements {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 4};
        // 6
        // 11
        // 12
        int k = 3;

        // sum of the first window
        int sum = 0;
        for(var i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        for(var i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println("Max sum " + maxSum);
    }
}
