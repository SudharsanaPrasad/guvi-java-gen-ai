package com.guvi.benchmarking;

public class StringBuilderBenchmarking {
        public static void main(String[] args) {
            int N = 100_000;

            // Using String
            long startString = System.nanoTime();
            String s = "";
            for (int i = 0; i < N; i++) {
                s += i;
            }
            long endString = System.nanoTime();
            System.out.println("String time: " + (endString - startString) / 1_000_000 + " ms");

            // Using StringBuilder
            long startBuilder = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(i);
            }
            String result = sb.toString();
            long endBuilder = System.nanoTime();
            System.out.println("StringBuilder time: " + (endBuilder - startBuilder) / 1_000_000 + " ms");
        }
}
