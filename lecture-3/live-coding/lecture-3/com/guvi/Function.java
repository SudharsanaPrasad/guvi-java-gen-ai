package com.guvi;

public class Function {

    // public - access
    // static - modifier
    // void - return type
    // main - function name
    // String[] args - parameters
    public static void main(String[] args) {
        // caller
        // boolean isNegative = isNumberNegative(-50);
        // System.out.println(isNegative);

        // "Nikhil" and "Nair" --> argument
        greet("Nikhil", "Nair");
        greet("Nikhil Nair");
    }

    // Overloading
    public static void greet(String first, String last) {
        System.out.println("Welcome " + first + " " + last);
    }

    public static void greet(String fullName) {
        System.out.println("Welcome " + fullName);
    }

    public static void greet(int name) {
        System.out.println(name);
    }

    // private - access
    // static - modifier
    // boolean - return type
    // isNumberNegative - function name
    // int n - parameters
    // Signature -> isNumberNegative + (int n)
    protected static boolean isNumberNegative(int n) {
        if(n < 0) { return true; }
        else { return false; }
    }

    // public - access
    // static - modifier
    // int - return type
    // max - function name
    // int a, int b - parameters
    // Signature -> max + (int a, int b)
    public static int max(int a, int b) {
        // ternary operator -> (a > b) ? a : b
        int max = (a > b) ? a : b;
        return max;

//        if(a > b) {
//            return a;
//        } else {
//            return b;
//        }

        /*
        // a = 20, b = 10
        // a > b -> true

        // a = 10, b = 20
        // a < b -> false

        // if a > b -> a is max
        // if a < b -> b is max
         */
    }
}
