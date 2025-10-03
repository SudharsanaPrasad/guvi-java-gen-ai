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
        // return null
    }

    public static void main(String[] args) {
        // max in an array
        int[] array = new int[3];
        array[0] = 20;
        array[1] = 40;
        array[2] = 50;

        int max = max(array);
        System.out.println(max);

        max(null);

        // min in an array
    }
}
