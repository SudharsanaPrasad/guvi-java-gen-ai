package com.guvi.stringbuilder;

public class Main {
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 500000; i++) {
            s += "x";
        }
        System.out.println("Concat time: " + (System.currentTimeMillis() - start1) + "ms");

        long start2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 500000; i++) {
            sb.append("x");
        }
        System.out.println("Builder time: " + (System.currentTimeMillis() - start2) + "ms");


    }
}
