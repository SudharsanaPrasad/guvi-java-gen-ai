package com.guvi.sort;

public class SelectionSort {
    // i to move from left to right within arr
    // i denotes the spot we're about to fill
    // the inner loop will look through the rest and
    // track the min value in the unsorted subarray
    // [5, 3, 6],i = 2
    public static void selectionSort(int[] arr) {
        for(var i = 0; i < arr.length; i++) {   // O(n)
            int minIndex = i;
            // arr[i + 1] -> arr[3]
            for(int j = i + 1; j < arr.length; j++) { // O(n*n)
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // place the min value at the ith position
            if(minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    // pass by reference -> side effect
    public static void main(String[] args) {
        int[] input = {9, 4, 7, 1, 3};
        //int[] input = {20, 8, 5, 10, 7};
        printArray(input);
        selectionSort(input);
        printArray(input);

    }

    public static void printArray(int[] arr) {
        for(int elem: arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
