package com.guvi.twoDimArrays;

/*
Problem: Given a 2D grid of integers, find the largest row sum and the largest column sum
- Rows and columns may differ in length; handle safely
Task:
- Write a method findMaxSums(int[][] grid) that prints both results.
- Use separate passes for rows and columns, and discuss complexity.
- Predict the total time complexity before running the code

 */
public class GridSums {
    public static void main(String[] args) {
        // 3x3 matrix, r = 3, c = 3
        // if the 2D array has 4 rows and 6 columns... how do we tackle it?
        int[][] grid = {
            {5, 2, 3,7},  // 17
            {1, 4, 6,0},  // 11
            {7, 8, 2,23}   // 40
          // 13,14,11
        };
        findMaxSums(grid);
    }

    /*
        Big O notation
            Time complexity: O(n^3)
                for rows            // O(n)
                    for columns     // O(n)
                        for rows    // O(n)
        Time complexity: O(n * n) -> O(n^2)
        // multiplication >>>> addition or subtraction
                for rows            // O(n)
                    for columns     // O(n)
                    for rows        // O(n)
     */
    public static void findMaxSums(int[][] grid) {
        // track the max for rows/columns
        int maxRow = Integer.MIN_VALUE;    // -2^31
        int maxColumn = Integer.MIN_VALUE;    // -2^31
        for(var i = 0; i < grid.length; i++) {
            int sum = 0;
            // for ith row, compute sum across the column
            for(var j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }
            // if -2^31 < 10
            if(maxRow < sum) {
                maxRow = sum;
            }

            int sumColumn = 0;
            // another loop with var k
            // start at 0, go till the length of the grid
            for(var k = 0; k < grid.length; k++) {
                sumColumn += grid[k][i];
            }
            if(maxColumn < sumColumn) {
                maxColumn = sumColumn;
            }



            // maxRow = Math.max(maxRow, sum);
        }
        System.out.println(maxRow);
        System.out.println(maxColumn);

        // n x n 2D array
//        for(var i = 0; grid.length; i++) {
//            for(var i = 0; grid.length; i++) {
//
//            }
//        }
        // n x m 2D array

    }



}
