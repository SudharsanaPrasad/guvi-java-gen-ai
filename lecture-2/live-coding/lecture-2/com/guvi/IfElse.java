package com.guvi;

public class IfElse {
    public static void main(String[] args) {
        // Is there time to make chai?
        int minutes = 8;
        // if I've greater than 7 minutes, then make chai
        if(minutes > 7) {
            System.out.println("Make Chai");
        } else {
            // else, make coffee
            System.out.println("Make Coffee");
        }

        //=================EXAMPLE SEPARATOR=================

        // Grade ladder using if/else-if/else
        int score = 60;
        String grade;
        // score >= 90 -> A
        // score >= 80 -> B
        // score >= 70 -> C
        // everything else is a D
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else {
            grade = "D";
        }
        System.out.println(grade);
    }
}
