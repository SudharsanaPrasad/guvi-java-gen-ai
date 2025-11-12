package com.guvi.pointers;

// Problem: Check if an array has a pair that sums to a target
/*
            pseudocode
            left & right pointers
            loop through the array -- which loop do we need? for, while, do-while
                sum of nums[left] & nums[right]
                does the sum equal the target {
                    print out the pair
                    continue the search for other pairs
                }
                is the sum < target {
                    move left up
                }
                is the sum > target {
                    right left up
           }
*/
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 7, 10};
        int target = 11;

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                System.out.println("Target found! Pair: " + nums[left] + " " + nums[right]);
                left++;
                right--;
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
