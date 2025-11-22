package com.guvi.sort;

public class MergeSort {

    // perform the merging in both halves: arr[left..mid] and arr[mid..right]
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int k = 0;

        // starting point of left half
        int i = left;
        // starting point of right half
        int j = mid + 1;

        // merge two halves in a sorted manner
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        // Edge cases
        // copy the remaining elements from left half, if any
        while(i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        // copy the remaining elements from right half, if any
        while(j <= right) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        // copy the merged result (temp array) back into
        // the original array (arr)
        for(var t = 0; t < temp.length; t++) {
            // temp[t] has to be copied over to
            // some part of the original array
            arr[left + t] = temp[t];
        }
    }

    // Recursive merge sort on the subarray arr[left...right]
    public static void mergeSort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        // sort left half
        mergeSort(arr, left, mid);

        // sort right half
        mergeSort(arr, mid + 1, right);

        // merge
        merge(arr, left, mid ,right);
    }

    public static void mergeSort(int[] arr) {
        // arr.length <= 1
        if(arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);

    }

    public static void main(String[] args) {
        int[] arr =  { 5, 2, 4, 6, 1, 3 };
        SelectionSort.printArray(arr);
        mergeSort(arr);
        SelectionSort.printArray(arr);
    }
}
