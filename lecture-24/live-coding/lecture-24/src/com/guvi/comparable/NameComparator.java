package com.guvi.comparable;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {
    // Compare two students and order them by their name (String)
    // pamu, Tuvesh, Thirumalini -> pamu,Thirumalini,Tuvesh
    @Override
    public int compare(Student s1, Student s2) {
        //s1.name
        //s2.name
        return s1.name.compareTo(s2.name);
    }



}
