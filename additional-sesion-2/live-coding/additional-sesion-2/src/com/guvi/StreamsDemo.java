package com.guvi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("malini", "yirou", "Soumyajit", "Shalini");

        // Scenario: create a result list with all names that start with "S"
        // Loop way (imperative)
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("S")) {
                result.add(name);
            }
        }
        // System.out.println(result);

        // Stream way (declarative)
        // What: stream + filter builds a pipeline
        // Why: reads like "what we want" rather than "how to loop"
        List<String> result2 = names
            .stream()
            .filter(name -> name.startsWith("S"))
            .toList();
        // System.out.println(result2);

        // Transform this List<String> to uppercase
        // Loop way
        List<String> upper = new ArrayList<>();
        for (String name : names) {
            upper.add(name.toUpperCase());
        }
        System.out.println(upper);

        // Stream map() = transformation
        List<String> upperStream = names
            .stream()
            // .map(name -> name.toUpperCase())
            .map(String::toUpperCase) // method reference version
            .toList();
        System.out.println(upperStream);

        // Pipeline example:
        // Take names starting with "S" and convert them to uppercase
        List<String> filterPlusTransform = names
            .stream()
            .filter(name -> name.startsWith("S")) // filter stage
            .map(String::toUpperCase)             // map stage
            .toList();                             // terminal stage (collect result)
        System.out.println(filterPlusTransform);

        // Terminal operation example:
        // What: count() consumes the stream and returns a number
        // Why: once a terminal op runs, the stream is "done"
        long count = names
            .stream()
            .filter(name -> name.startsWith("S"))
            .count();
        System.out.println(count);
    }
}