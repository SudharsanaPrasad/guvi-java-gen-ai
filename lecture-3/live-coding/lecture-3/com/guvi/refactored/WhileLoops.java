package com.guvi.refactored;

public class WhileLoops {
    public static void main(String[] args) {
        // Validation loop pattern (left commented to avoid an infinite loop)
        // boolean hasUserEnteredDate = false;
        // while(!hasUserEnteredDate) {
        //     // ask user to enter a valid date
        // }

        boolean hasUserEnteredDate = false; // from your notes (not used below)
        int score = 30;
        while (score >= 30) {
            if (score > 40) {
                System.out.println("continue");
                score = score + 1;
                break;
            }
            System.out.println(score);
            score = score + 1;
        }
    }
}

