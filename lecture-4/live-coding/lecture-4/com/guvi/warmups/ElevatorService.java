package com.guvi.warmups;

public class ElevatorService {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i < 7) {
                System.out.println("Stop at floor " + i);
            } else if (i % 2 == 0) {
                System.out.println("Stop at floor " + i);
            }
        }
    }
}
