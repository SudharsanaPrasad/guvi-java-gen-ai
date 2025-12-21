package com.guvi;

public class Student {
    private String name;
    private String id;
    private String[] courses;
    private Double[] grades;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }


    // equals method
    // compares values versus reference
    // compare two students: student1 (thirumani), student2 (yiroo)
    // student1.equals(student2)
    @Override
    public boolean equals(Object obj) {
        // what if obj is null?
        // what if obj has the same reference as the current object?
        if(obj == this) return true;

        Student student2 = (Student) obj;

        String student2Name = student2.getName();
        String student2Id = student2.getId();

        return student2Name.equals(this.name) &&
            student2Id.equals(this.id);
    }

    @Override
    public int hashCode() {
        // name, id
        int hash = 31;
        hash = 31 * hash + name.hashCode();
        hash = 31 * hash + id.hashCode();
        return hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}
