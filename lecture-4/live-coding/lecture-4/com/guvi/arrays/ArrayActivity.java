package com.guvi.arrays;

public class ArrayActivity {

    // [1,2,3] OR null OR []
    public static int max(int[] arr) {
        if(arr.length == 0 || arr == null) {
            return -1;
        }
        int maxValue = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    public static int[] readFile(String filePath) {
        // if the file doesn't exist
         return null;
    }

    // parameters: array of integers
    // return type: integer
    public static int min(int[] arr) {
        int minValue = 0;
        for(int i =  0; i < arr.length - 1; i++) {
            if(arr[i] < arr[i + 1]) {
                minValue = arr[i];
            } else {
                minValue = arr[i + 1];
            }
        }
        return minValue;
    }

    public static int minValue(int[] arr) {
        // validation
        int min = arr[0];
        for(int i = 1;i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        // max in an array
        int[] array = new int[3];
        array[0] = -25;
        array[1] = 76;
        array[2] = 12;

//        int max = max(array);
//        System.out.println(max);
//
//        max(null);
        System.out.println(Integer.MIN_VALUE);
        // min in an array
//        int min = min(array);
//        System.out.println(min);
    }
}
