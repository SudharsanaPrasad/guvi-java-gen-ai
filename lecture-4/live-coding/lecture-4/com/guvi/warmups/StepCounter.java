package com.guvi.warmups;

public class StepCounter {
    public static void main(String[] args) {
        int d1 = 4200;
        int d2 = 8300;
        int d3 = 9100;
        int d4 = 7800;
        int d5 = 12000;
        int d6 = 3000;
        int d7 = 10050;

        int count = 0;
        if(d1 >= 8000) count++;
        if(d2 >= 8000) count++;
        if(d3 >= 8000) count++;
        if(d4 >= 8000) count++;
        if(d5 >= 8000) count++;
        if(d6 >= 8000) count++;
        if(d7 >= 8000) count++;
        System.out.println("Goal days: " + count);

//        int d8 = 5300;
//        switch(d8) {
//            case 2000:
//                System.out.println("Met my goal");
//                break;
//            case 8000:
//                System.out.println("Met my goal");
//                break;
//            default:
//                System.out.println("Didn't meet my goal");
//        }

        // day of the week -> 1-7
        // switch (day) { 1: "Monday" }
    }
}
