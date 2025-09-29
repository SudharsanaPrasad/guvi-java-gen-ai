package com.guvi.refactored;

public class Operators {
    public static void main(String[] args) {
        int number = 2;
        number = number * 2;
        System.out.println(number);
        number = number / 2;
        System.out.println(number);
        number = number + 100;
        System.out.println(number);
        number = number - 50;
        System.out.println(number);

        number = 100;

        // modulo - %
        System.out.println(number % 10);
        System.out.println(number % 11);

        // post-increment operator
        number++;
        // pre-increment operator
        ++number;
        System.out.println(number);
    }
}

