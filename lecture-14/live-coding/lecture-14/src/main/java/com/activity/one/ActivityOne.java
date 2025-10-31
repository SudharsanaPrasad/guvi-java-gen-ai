package com.activity.one;


import java.util.ArrayList;
import java.util.List;

/*
Context: you are designing a simple developer profile card for an internal dashboard.
 The goal is to make the code cleaner and more expressive using modern Java features
Tasks
 - Replace the Developer class with a record that models name, id, and note.
 - Store the developer’s note as a text block with two lines: greeting and reminder.
 - Use var wherever the initializer makes the type obvious.
 - Redesign Badge as a sealed interface with exactly two permitted types: GoldBadge and SilverBadge.
 - Identify one feature that improves readability but could limit flexibility, and explain why.

 */
public class ActivityOne {
    public static void main(String[] args) {
        var note = """
            Welcome to the project!
            Remember to push your code daily.
            """;
        var dev = new Developer("Ada", 7, note);
        var badge = new GoldBadge();
        System.out.println(dev.name() + " - " + badge.type());
        System.out.println(dev.note());

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        System.out.println(list.toString());

        int[] array = new int[2];
        array[0] = 5;
        array[1] = 6;
        System.out.println(array);
    }

}
