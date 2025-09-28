package com.guvi;

/**
 * Variables demo: primitive declarations, casting, and simple prints.
 */
public class Variables {
    public static void main(String[] args) {
        // byte, short, int, long, float, decimal, char, boolean
        // To declare a variable: dataType identifier;

        // hold -128 to +127 (range of byte)
        byte demo;
        // 130 cast into byte range (wraparound)
        byte placeholder = (byte) 130;
        System.out.println(placeholder);

        // ~-32,000 to ~+32,000
        short test = 10000;

        int distanceToMoon = 384_400;

        char maleOrFemale = 'M';
        System.out.println(maleOrFemale);

        boolean matchOver = true;
        System.out.println(matchOver);

        System.out.println(distanceToMoon);
        System.out.println(test);
        System.out.println("Hello World!");
    }
}
