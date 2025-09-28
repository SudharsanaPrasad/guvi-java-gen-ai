package com.guvi;

public class Switch {
    public static void main(String[] args) {
        // 1-7 => day name
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

        //=================EXAMPLE SEPARATOR=================

        // Switch expression (score => grade)
        int score = 85;
        // score / 10 -> 85 / 10 => 8.5 (integer division → 8)
        String grade = switch (score / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            default -> "D";
        };
        System.out.println(grade);

        //=================EXAMPLE SEPARATOR=================

        // If/else grading variant with input checks
        String finalGrade;
        if (score <= 100 && score >= 90) {
            finalGrade = "A";
        } else if (score < 90 && score >= 80) {
            finalGrade = "B";
        } else if (score < 80 && score >= 70) {
            finalGrade = "C";
        } else if (score > 100 || score < 0) {
            finalGrade = "Bad Input";
        } else {
            finalGrade = "F";
        }
        System.out.println(finalGrade);
    }
}
