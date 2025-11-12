package com.guvi.slidingwindow;

public class EfficientSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 4};
        int k = 3;

        int windowSum = 0;
        // run a loop k times
        // find the sum of the first window
        //1, 3, 2 -> 6
        for(var i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        System.out.println(windowSum);

        for(var i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            System.out.println(windowSum);
        }
    }
}
