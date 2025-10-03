package com.guvi.warmups;

public class GymCircuit {
    public static void main(String[] args) {
//        int count = 0;
//        for (int i = 1; i <= 10; i++) {
//            if (i != 5) {
//                System.out.println("Set " + i + " done");
//                count++;
//            }
//        }
//        System.out.println("Total printed count:  " + count);

        // checking only for 5
//        for (int i = 1; i <= 10; i++) {
//            if (i == 5) {
//               continue;
//            }
//            System.out.println("Set " + i + " done");
//            count++;
//        }
//        System.out.println("Total printed count:  " + count);

        int i = 0;
        int count = 0;
        while(i <= 9) {
            i++;
            if(i == 5) {
                continue;
            }
            System.out.println("Set " + i + " done");
            count++;
        }
        System.out.println("Total printed count:  " + count);
    }
}
