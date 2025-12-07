package com.guvi;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        Integer temp = new Integer(25);
//        System.out.println(temp.hashCode());
//
//        String key = "cat";
//        System.out.println(key.hashCode());

//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("cat", 5);


        Student s1 = new Student("Gourav", "1");
        Student s2 = new Student("Shalini", "2");
        Student s3 = new Student("Yashvanth", "3");
        Student s4 = new Student("Yashvanth", "3");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s4.equals(s3));

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());

        System.out.println(s4.hashCode() == s3.hashCode()); // true
        System.out.println(s4.hashCode() == s1.hashCode()); // false

        HashMap<Student, Integer> studentMap = new HashMap<>();
        studentMap.put(s1, 123);
        System.out.println("Student 1: " + studentMap.get(s1));
        // "Yashvanth", "3" -> hashcode is 302814296
        // s3 & s4 has the same hashcode
        studentMap.put(s3, 1234);
        System.out.println("Student 4" + studentMap.get(s4));

    }
}
