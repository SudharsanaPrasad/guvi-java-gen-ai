package com.guvi.warmups;

public class PhoneBattery {
    public static void main(String[] args) {
        int battery = 17;
        while(battery > 0) {
            System.out.println(battery + "%");
            if(battery <= 5) {
                System.out.println("Low Power Mode");
                break;
            }
            battery = battery - 2;
        }
    }
}
