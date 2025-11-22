package com.guvi.sort;

import java.util.Arrays;

public class BubbleSort {

    /*
        [], [5], null

        [7,6,4,3]
     */
    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return;
        }

        boolean swapped = true; // a boolean flag
        while(swapped) { // n - ??; n = 1 billion; 1 billion - 1000 -> O(n)
            // Assumption: no swaps required
            swapped = false;

            // i -> i + 1
            //  0, 1, 2, 3, 4
            // [5, 1, 4, 2, 8] -> i = 4
            for(var i = 0; i < arr.length - 1; i++) { // n - 1; O(n)
                // swap condition -- compare i, i+1
                if(arr[i] > arr[i + 1]) {   // arr[4] > arr[5] -> IndexOutOfBoundsException; Fix: i < arr.length -> i < arr.length-1
                    swapped = true;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 5, 1, 4, 2, 8 };
        // array size 10^6
        // Random random = new Random();
        System.out.println("Unsorted array " + Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println("Sorted array " + Arrays.toString(nums));
    }
}
