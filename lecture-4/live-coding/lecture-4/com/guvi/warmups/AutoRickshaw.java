package com.guvi.warmups;

public class AutoRickshaw {

    public static int calculateFare(int km) {
        int fare;
        // 2km or less
        if(km <= 2) {
            fare = 30;
        } else if(km <= 10) {
            // 10 km or less
            fare = 30 + (km - 2) * 13;
        } else {
            // > 10
            // fare = 30 + (15 - 2) * 13 + (15 - 10) * 15
            fare = 30 + 8 * 13 + (km - 10) * 15;
        }
        return fare;
    }

    public static void main(String[] args) {
        // input
        int km = 15;

        // 30 + (13 * 8) = 134 --- covers 10kms
        // 5 * 15 = 75
        // 209
        System.out.println(calculateFare(km));

    }
}
