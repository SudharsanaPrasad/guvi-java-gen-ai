package com.guvi.comparable;

import java.util.Arrays;

public class CustomSorting {

    public static void main(String[] args) {
        Student[] students = {
            new Student(3, "Pamu"),
            new Student(1, "Tuvesh"),
            new Student(2, "Thirumalini"),
        };

        // uncomment to see how compareTo method in Student class performs the sort
        // Arrays.sort algorithm will call compareTo in the Student class
        // anytime it needs to compare two Students
        // Arrays.sort(students);
        // System.out.println("Sorting by ID: " + Arrays.toString(students));

        // uncomment to see how NameComparator's compare method performs the sort
        // Arrays.sort algorithm will call compare in NameComparator
        // anytime it needs to compare two Students
        // Arrays.sort(students, new NameComparator());
        // System.out.println("Sorting by name: " + Arrays.toString(students));
    }
}
