package com.guvi;

public class SwitchDemo {
    public static void main(String[] args) {
        // int representation of a day of a week:
        // 1 - Monday, 2 - Tuesday, ...
        int day = 2;
        String name;

        // If-else way (commented during session)
        // if(day == 1) {
        //     name = "Monday";
        // } else if (day == 2) {
        //     name = "Tuesday";
        // }

        // Switch statement (traditional)
        // What: assign a variable using cases + break
        // Why: readable alternative to long if-else ladders
        switch (day) {
            case 1:
                name = "Monday";
                break;
            case 2:
                name = "Tuesday";
                break;
            // 1-7 using case
            default:
                name = "Unknown!";
        };
        System.out.println(name);

        // Switch expression (newer style)
        // What: switch returns a value directly
        // Why: avoids boilerplate (no breaks, cleaner mapping)
        int day2 = 2; // Note: day2 is currently unused; we are switching on 'day' below (as written in session).
        String name2 = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            // ...
            default -> "Unknown";
        };
        System.out.println(name2);
    }
}