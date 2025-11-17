package com.guvi.search;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // we do not know how many subproblems has to be solved before we find the target?
        while(low <= high) {
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

    public static void main(String[] args) {
        //BinarySearch<Integer> binSearch = new BinarySearch<Integer>();
        // "a", "b", "d" --- ASCII
        // int[] sorted = { 2, 5, 6, 9 , 12 };
        int[] sorted = { 3,7,12,19,25,37,42 };
        int targetOnLeft = 12;
        int targetOnRight = 37;
        int targetNotFound = 13;
        System.out.println("Index of target " + targetOnLeft + " is: " + binarySearch(sorted, targetOnLeft));
        System.out.println("Index of target " + targetOnRight + " is: " + binarySearch(sorted, targetOnRight));
        System.out.println("Index of target " + targetNotFound + " is: " + binarySearch(sorted, targetNotFound));
    }
}
