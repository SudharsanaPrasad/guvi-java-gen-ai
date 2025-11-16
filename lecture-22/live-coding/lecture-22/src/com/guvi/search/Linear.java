package com.guvi.search;

public class Linear {
    // find target in array and return the index
    // if not found, return -1
    // Time complexity: O(n)
    // Space complexity: O(1) 1000 elements vs 1 billion elements
    public static int linearSearch(int[] array, int target) {
        // brute force
        for(var i = 0; i < array.length; i++) {
            if(array[i] == target) {
                return i + 1;
            }
        }
        return -1;
    }
    // Variation using for-each
    //        var j = 0;
    //        for(int elem: array) {
    //            if(array[j] == target) {
    //                return j + 1;
    //            }
    //            j++;
    //        }

    public static void main(String[] args) {
        int[] unsorted = { 9, 5, 12, 2, 6};
        int index = linearSearch(unsorted, 9);
        System.out.println("Found 9 at " + index);
    }
}
