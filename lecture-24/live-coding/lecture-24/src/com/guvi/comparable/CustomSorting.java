package com.guvi.comparable;

import java.util.Arrays;

public class CustomSorting {

    public static void main(String[] args) {
        Student[] students = {
            new Student(3, "Pamu"),
            new Student(1, "Tuvesh"),
            new Student(2, "Thirumalini"),
        };

        //Arrays.sort(students);
        //System.out.println("Sorting by ID: " + Arrays.toString(students));

        Arrays.sort(students, new NameComparator());
        System.out.println("Sorting by name: " + Arrays.toString(students));
    }
}
