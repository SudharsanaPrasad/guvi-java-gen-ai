package com.guvi.arrays;

public class ArrayBasics {
    public static void main(String[] args) {
        // array declaration
        //int[] array;
        // array declaration and initialization
        int randomInt = 5;
        int[] array = { 10, 20, 30, 40 };
        array[0] = 50;
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);

        System.out.println(array.length / 2.5);
        System.out.println("========================");

        int array2[] = new int[3];
        array2[0] = 10;
        array2[1] = 20;
        array2[2] = 30;
        // Note: these will throw an error, aka, Exception
        //array2[3] = 50;
        //System.out.println(array2[3]);

        // accessing an index from the end of the array
        System.out.println(array2[array2.length - 3]);

        if(array2.length / 2 > 0) {
            System.out.println("In the if");
        }
    }
}
