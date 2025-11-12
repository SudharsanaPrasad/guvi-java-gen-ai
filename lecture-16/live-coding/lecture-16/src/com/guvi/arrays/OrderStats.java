package com.guvi.arrays;

/*
- Problem: Given an array of integers representing daily order totals, compute and print the sum and average
- Ensure no invalid index access occurs.
- Test with small and empty arrays.
*/
public class OrderStats {
    public static void main(String[] args) {
        // space complexity
        int[] orders = { 10, 5, 5 };
        printSumAndAverage(orders);
    }

    // helper static method
    public static void printSumAndAverage(int[] arr) {
        // space complexity
        // 8 bytes in memory
        int sum = 0;
        // 32 bytes in memory
        double average = 0;

        for(int elem: arr) {
            // Shorthand: sum += elem;
            sum = sum + elem;
        }
        // 50 / 3 -> int, double, float, etc
        average = (double) sum / arr.length;
        System.out.println("Sum: " + sum + " Average: " + average);
    }
    // Time complexity: O(n)
    // Space complexity: O(n)
}
