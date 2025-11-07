package com.guvi.activity;

import java.util.HashMap;

/*
Problem Statement
    - You are to counts all occupied seats in a library.
    - Occupied seat will have a value of 1.
    - Unoccupied will have a value of 0.
    - Handle irregular row lengths without errors
    - Display total occupied count and discuss its time complexity
Tasks
    - Create a method countOccupied(int[][] seats) that loops through each element and returns the total count of seats marked with 1

 */
public class SeatCounter {
    public static void main(String[] args) {
        // single dimen array -> O(n)
        // 2D array -> O(n * m)
        int[][] seats = {
            {1, 0, 1},
            {0, 1},
            {1, 1, 0, 8}
        };
        int result = countOccupied(seats);
        System.out.println("Occupied Seats: " + result);
        // Occupied Seats: 5
    }

    public static int countOccupied(int[][] seats) {
        // int -> 8 bytes
        int occupied = 0;
        // n * m
        // int i - 8 bytes
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == null) continue;
            // int j - 8 bytes
            for(int j = 0; j < seats[i].length; j++) {
                // is occupied?
                if(seats[i][j] == 1) {
                    // occupied++;
                    occupied += 1;
                }
            }
        }
        return occupied;
    }
    // Time: O(n^2), where n equals the number of rows and m equals the number of columns
    // Space: O(n^2)
}
