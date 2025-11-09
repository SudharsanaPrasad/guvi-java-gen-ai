package com.guvi.strings;

public class Main {
    public static void main(String[] args) {
        // heap
        // Integer -> int
        Integer test = 5;
        Integer test2 = 5;
        if(test == test2) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }
        // is a string a wrapper class? String
        // Character -> char
        // String

        char test3 = '0';
        char test4 = '5';
        int test3Int = (int)test3;
        int test4Int = (int)test4;

        System.out.println(test4Int - test3Int);
    }
}
