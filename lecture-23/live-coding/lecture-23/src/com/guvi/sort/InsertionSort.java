package com.guvi.sort;

public class InsertionSort {
    // we want to start from the ith position where i = 1
    // because the first element by itself is sorted
    // j  walk left side of the sorted subarray
    public static void insertionSort(int[] arr) {
        for(var i = 1; i < arr.length; i++) {   // O(n)
            int key = arr[i];
            // allows us to identify the border of the sorted subarray
            int j = i - 1;

            /*
                Array: [5, 7, 4, 2].
                Subarray: [5,7,4]
                i = 2
                j = 1
                7 > 4??
                5,7,4 -> 5,7,7
                j = 0
                5 > 4?
                5,7,7 -> 5,5,7
                j = -1
             */
            while (j >= 0 && arr[j] > key) {     // O(n) -> the shifting will impact every single element
                arr[j + 1] = arr[j];
                j--;
            }
            // 5,5,7; j = -1; i = 2; key = 4
            // updated: 4,5,7
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] input = {9, 4, 7, 1, 3};
        //int[] input = {20, 8, 5, 10, 7};
        SelectionSort.printArray(input);
        insertionSort(input);
        SelectionSort.printArray(input);
    }
}
