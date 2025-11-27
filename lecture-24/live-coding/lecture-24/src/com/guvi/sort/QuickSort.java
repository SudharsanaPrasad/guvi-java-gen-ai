package com.guvi.sort;

public class QuickSort {

    public static void swap(int[] arr, int a, int b) {
        if(a == b) return;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        // pick a pivot
        int pivot = arr[high];
        // end of region that's less than the pivot
        int i = low - 1;

        // move all the elements that's less than the pivot to the first partition
        // loop, var j, from the low to the high
            // compare(pivot, arr[j])
                // if pivot > arr[j] ->
                    // extend the "small elements" boundary
                    // swap an element in the ith region w/ the jth region
        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // place the pivot in the right position
        swap(arr, i + 1, high);

        // return the pivot's final index
        return i + 1;
    }

    // Recursive quick sort on the range [low...high]
    public static void quickSort(int[] arr, int low, int high) {
        // Base case: subarray of size 0 or 1 is already sorted
        if(low >= high) {
            return;
        }

        // partition the array and get the pivot's index
        int pivotIndex = partition(arr, low, high);

        // recursively sort the elements before the pivot
        quickSort(arr, low, pivotIndex - 1);

        // recursively sort the elements after the pivot
        quickSort(arr, pivotIndex + 1, high);

    }

    public static void quickSort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 7, 3, 9, 1, 5 };
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for(int elem: arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
