package com.guvi.sort;

public class CountingSort {
    public static void countingSort(int[] arr) {
        // Edge cases
        if(arr == null || arr.length <= 1) {
            return;
        }

        // 1) Find the maximum value
        int max = arr[0];
        for(var i = 1; i < arr.length; i++) {
            // what if arr[i] is a negative number?
                // throw an exception: IllegalArgumentException
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        // 2) Create and fill the count bucket
        int[] count = new int[max + 1];
        // count how many times each value appears
        // update count[index] appropriately
        for(var i = 0; i < arr.length; i++) {
            int currentCount = count[arr[i]];
            currentCount++;
            count[arr[i]] = currentCount;
            // if i = 0: arr[i] -> 2
            // count[i]
        }

        // 3) Rebuilding the original array
        // position where we'll write the next element
        int index = 0;

        for(var value = 0; value <= max; value++) {
            // how many times did I see this value?
            int freq = count[value];
            while(freq > 0) {
                arr[index] = value;
                index++;
                freq--;
            }

//            for(int j = 0; j < freq; j++) {
//
//            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 2, 3, 0, 3, 0, 3, 156 };
        QuickSort.printArray(arr);
        countingSort(arr);
        QuickSort.printArray(arr);
    }
}
