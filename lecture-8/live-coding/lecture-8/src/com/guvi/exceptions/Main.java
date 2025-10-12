package com.guvi.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.InflaterOutputStream;

public class Main {
    public static void requireNonNegative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("negative not allowed");
        }
        System.out.println("Positive number");
    }

    public static void main(String[] args) {
        //requireNonNegative(10);
        //requireNonNegative(-10);
//        Integer num1 = Integer.parseInt("abc");
        //System.out.println(num1);
        //validateString("");
        int res = g("abc");
        System.out.println(res);
    }

    public static int g(String s) {
        try {
            System.out.println("try");
            Integer.parseInt(s);
            return 10;
        } catch (NumberFormatException e) {
            System.out.println("catch");
            return 20;
        } finally {
            System.out.println("finally");
        }
    }


    public static boolean validateString(String str) {
        if(str == null || str.isEmpty()) {
            // an instance of IllegalArgumentException is created
            // customization of the error message is possible
            throw new IllegalArgumentException("string cannot be null or empty");
        }
        return true;
    }
}
