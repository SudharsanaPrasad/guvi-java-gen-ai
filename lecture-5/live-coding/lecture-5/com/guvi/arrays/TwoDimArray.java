package com.guvi.arrays;

public class TwoDimArray {
    public static void main(String[] args) {
        int[][] arr = {
            { 12, 45, 77 },
            { 190, 343, 291 },
            { 180, 873 }
        };

        int first = arr[0][0];

        int lastRow = arr.length - 1;
        int lastColumn = arr[arr.length - 1].length - 1;
        int last = arr[lastRow][lastColumn];

//        System.out.println(first);
//        System.out.println(last);

        arr[1][0] = 89;
//        System.out.println(arr[1][0]);

        String str = "";
        for(int row = 0; row < arr.length; row++) {
            // inner for loop
            for(int col = 0; col < arr[row].length; col++) {
                //arr[row][col] = arr[row][col] / 2;
                //System.out.println(arr[row][col]);
                str = str + arr[row][col] + "\t";
            }
            System.out.print(str);
            str = "";
        }

    }
}
