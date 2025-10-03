package com.guvi.warmups;

public class CricketOver {
    public static void main(String[] args) {
        for(int balls = 6; balls >= 1; balls--) {
            System.out.println("Balls Left " + balls);
            if(balls == 3) {
                System.out.println("Strategic Talk");
            }
        }
    }
}
