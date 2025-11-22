package com.guvi.comparable;

public class Student implements Comparable<Student> {

    public int id;
    public String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Natural Sort -> sort by ID
    @Override
    public int compareTo(Student other) {
        // If the current student has id=5
        // and other student has i=3
        // return 5-3 (Positive -> the current student should
        // come after the other student)

        // If the current student has id=3
        // and other student has i=5
        // return 3-5 (Negative -> the current student should
        // come before the other student)
        return this.id - other.id;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
