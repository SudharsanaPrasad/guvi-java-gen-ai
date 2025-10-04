package com.guvi.strings;

public class StringBasics {
    public static void main(String[] args) {
        String name = null;
        System.out.println(name);
        name = "Soumyajit";

        String city = new String("Bangalore");

        String greet = "Hello, " + name + "!";
        System.out.println(greet);

        String empty = "";
        System.out.println("Empty string length: " + empty.length());

        char first = name.charAt(0);
        char last = name.charAt(name.length() - 1);
        System.out.println("First character: " + first);
        System.out.println("Last character: " + last);

        System.out.println(city.length());
        System.out.println(city.substring(5));
        System.out.println(city.substring(0, 5));

        int index = city.indexOf("z");
        int indexOfGalore = city.indexOf("galore");
        System.out.println(index);
        System.out.println(indexOfGalore);

    }
}
