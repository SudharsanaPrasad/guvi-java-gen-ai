package com.guvi.warmups;

public class ChaiStall {
    public static void main(String[] args) {
        int paidCups = 23;
        // 23 / 6 => 3.83
        int freeCups = paidCups / 6;
        int totalCups = paidCups + freeCups;
        System.out.println("Free: " + freeCups);
        System.out.println("Total: " + totalCups);

        // invoking the static method, calculateFare, in AutoRickshaw class
        // and providing an argument, 15 (data type: int)
        AutoRickshaw.calculateFare(15);
    }
}
