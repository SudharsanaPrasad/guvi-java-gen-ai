package com.guvi.arrays;

import java.util.HashMap;
import java.util.Map;

public class SmallLargeFrequency {
    public static void main(String[] args) {
        // max, min and frequency of each number
        int[] orders = { 31, 28, 35, 29, 35, 32, 28 };
        max(orders);
        min(orders);
        int[] freq = frequency(orders);
//        for(int i = 0; i < freq.length; i++) {
//            System.out.println(i + " " + freq[i]);
//        }
        System.out.println(frequency2(orders));
    }

    // assumption: the range of the input will be between 0-100 -> 101
    // [_,1,1,1,2,_,_,_, 1 ]
    //  0 1 2 3 4 5....  35
    // Input: 1, 2, 3, 4, 4
    public static int[] frequency(int[] input) {
        int[] freq = new int[101];
        for(int t : input) {
            // track the frequency for t
            freq[t]++;
        }
        return freq;
    }
    public static Map<Integer, Integer> frequency2(int[] input) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : input) {
            Integer val = map.get(t);
            if(val == null) {
                map.put(t, 1);
            } else {
                //val++;
                map.put(t, ++val);
            }
        }
        return map;
    }

    public static void min(int[] input) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < input.length; i++) {
            if(min > input[i]) {
                min = input[i];
            }
        }
        System.out.println("Min: " + min);
    }

    public static void max(int[] input) {
        // int max = Integer.MIN_VALUE;
        int max = input[0];
        for(int i = 1; i < input.length; i++) {
            if(max < input[i]) {
                max = input[i];
            }
        }
        System.out.println("Max: " + max);
    }
}
