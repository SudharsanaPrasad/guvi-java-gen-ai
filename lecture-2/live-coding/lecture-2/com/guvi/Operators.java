package com.guvi;

/**
 * Comparison and logical operator demos.
 */
public class Operators {
    public static void main(String[] args) {
        char letter = 'B';
        double temperature = 30.5;
        boolean isOpen = true;

        int score = 60;
        System.out.println(score >= 60);         // true
        System.out.println(letter != 'C');       // true
        System.out.println(temperature == 30.5); // true
        System.out.println(!isOpen);             // false

        double attendance = 80.75;
        // if the score is >= 60 AND attendance is >= 75 THEN pass
        boolean pass = (score >= 60) && (attendance >= 75);
        System.out.println(pass);                // true

        // is the user eligible for a discount? member OR cart total >= 250
        boolean isMember = false;
        double cartTotal = 250.5;
        boolean isUserEligible = isMember || (cartTotal >= 250);
        System.out.println(isUserEligible);      // true
    }
}
