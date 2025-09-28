package com.guvi;

/**
 * com.guvi.Main - this is a demo for lecture 2
 */
public class Main {
    /**
     * main - entry point to my project
     * @param args
     */
    public static void main(String[] args) {
        /* COMPARISON OPERATOR */
        char letter = 'B';
        double temperature = 30.5;
        boolean isOpen = true;

//        System.out.println(score >= 60);
//        System.out.println(letter != 'C');
//        System.out.println(temperature == 30.5);
//        System.out.println(!isOpen);

        double attendance = 80.75;
        // if the score is greater than or equal to 60
        // AND
        // attendance is greater than or equal to 75
        // THEN, the learner is passing
        // boolean pass = (score >= 60) && (attendance >= 75);

        // is the user eligible for a discount? YES/NO
        // is the user a prime member OR cart total greater than or equal to 250
//        boolean isMember = false;
//        double cartTotal = 250.5;
//        boolean isUserEligible = isMember || (cartTotal >= 250);
//        System.out.println(isUserEligible);

//        System.out.println(pass);

//        char grade;
//        int score = 60;
//        String grade;
//
//        // score >= 90 -> A
//        // score >= 80 -> B
//        // score >= 70 -> C
//        // everything else is a D
//        if(score >= 90) {
//            grade = "A";
//        } else if(score >= 80) {
//            grade = "B";
//        } else if(score >= 70) {
//            grade = "C";
//        } else {
//            grade = "D";
//        }
//
//        System.out.println(grade);

        // 1-7
        int day = 4;
        String name;

        switch (day) {
            case 1:
                name = "Mon"; break;
            case 2:
                name = "Tue"; break;
            case 3:
                name = "Wed"; break;
            case 4:
                name = "Thu"; break;
            case 5:
                name = "Fri"; break;
            case 6:
                name = "Sat"; break;
            case 7:
                name = "Sun"; break;
            default:
                name = "Unknown";
        }
        System.out.println(name);

        int score = 85;
//        score / 10 -> 85 / 10 -> 8.5
        String grade = switch(score / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            default -> "D";
        };
        System.out.println(grade);

//        int score = 85;
        String finalGrade;
        if(score <= 100 && score >= 90) {
            finalGrade = "A";
        } else if(score < 90 && score >= 80) {
            finalGrade = "B";
        } else if(score < 80 && score >= 70) {
            finalGrade = "C";
        } else if(score > 100 || score < 0) {
            finalGrade = "Bad Input";
        } else {
            finalGrade = "F";
        }


    }
}
/*
// this is a comment
        // byte, short, int, long, float, decimal, char, boolean
        // To declare a variable: dataType identifier;

        // hold -128 to +128
        byte demo;
        // 128 -> -128
        // 129 -> -128 + 1 -> -127
        byte placeholder = (byte) 130;
        System.out.println(placeholder);


        // 2^16; ~-32,000 to ~+32,000
        short test = 10000;

        int distanceToMoon = 384_400;

        char maleOrFemale = 'M';
        System.out.println(maleOrFemale);

        boolean matchOver = true;
        System.out.println(matchOver);

        // System.out.println(distanceToMoon);
        // System.out.println(test);
        // System.out.println("Hello World!");

 */