package com.guvi.warmup;

public class RecursiveBinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // we do not know how many subproblems has to be solved before we find the target?
        while(low <= high) {    // split the problem into two halves. O(log n)
            int mid = (low + high) / 2;
            System.out.println("low " + low + " mid " + mid + " high " + high);
            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                // if target is less than midpoint, update our high
                high = mid - 1;
                //} else if(target > nums[mid]) {
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int recursiveBinSearch(int[] nums, int target, int low, int high) {
        if(low > high) {
            return -1;
        }

        // recalculate our mid
        var mid = 0;

        if(nums[mid] == target) {
            return mid;
        } else if(mid < target) {
            return recursiveBinSearch(nums, target, low, mid - 1);
        } else {
            return recursiveBinSearch(nums, target, mid + 1, high);
        }
    }


}
