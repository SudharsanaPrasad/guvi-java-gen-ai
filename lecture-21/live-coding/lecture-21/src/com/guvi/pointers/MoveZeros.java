package com.guvi.pointers;

/**
 *
 Problem: Given an array of integers, write a function to move all 0s to the end of it.
 Constraints:
 1.  You must do this **in-place** (you cannot create a new array)
 2.  You must **maintain the relative order** of all the non-zero elements.

 Input: [0, 1, 0, 3, 12]


 Ignoring the constraints:
 swap 0 and 12
 swap 0 and 3
 Output: [12, 1, 3, 0, 0]
 Another output: [3, 1, 12, 0, 0]

 Consider the 2nd constraint:
 Output: [1, 3, 12, 0, 0]

 Approach: pointer
 Input: [0, 1, 0, 3, 12]
 next step:
 [1, 0, 3, 12, 0]
 compare: 1,0


 */
public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        // slow pointer: tracks where the next non-zero element should be placed
        int slowPointer = 0;

        // fast pointer -> loop over the nums
        for(int i = 0; i < nums.length; i++) {
            // based on nums[i] -> if we've reached a non-zero number
            if(nums[i] != 0) {
                // we "write" the nums[i] to the slow pointer's location
                nums[slowPointer] = nums[i];
                // then, we increment the slow pointer
                slowPointer++;
            }
        }

        // at this point, all non-zero elements are placed before the slowPointer
        for(var i = slowPointer; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 3, 12 };
        moveZeroes(arr);
    }
}
