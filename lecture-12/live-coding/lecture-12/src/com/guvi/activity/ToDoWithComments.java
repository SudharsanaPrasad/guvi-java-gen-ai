package com.guvi.activity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public class ToDoWithComments {
    /*
    Clean and persist a todo.txt into a data folder
        - Input may contain duplicates, blanks, and leading or trailing spaces
        - The data folder may not exist yet; create it before writing
    Enforce output invariants that make the file dependable
        - Trim whitespace, drop empty lines, preserve first seen order
        - Remove exact duplicates after trimming, do not append
    Use the APIs introduced so far
        - Read with readString if present, write back with writeString
        - Ensure folders exist using createDirectories before any write
    Make the operation idempotent across runs
        - Running the program twice produces identical file content

    Update todo.txt with the cleaned up version
     */

    public static void main(String[] args) throws IOException {
        Path file = Path.of("data", "todo.txt");
        String fileContents = Files.readString(file);
        //        System.out.println(fileContents);

        LinkedList<String> output = new LinkedList<>();
        // List -> LinkedList, ArrayList, Set -> HashSet, LinkedHashSet , Map -> HashMap, Queue
        // processing
        for(String line: fileContents.split("\\r")) {
            String str = line.trim();
            //if(str.isEmpty() == false && output.contains(str) == false) {
            // is the string NOT empty?
            // does the output LinkedList NOT contain the string?
            // add it to the output

            /*
                todo.txt:
                    Prepare for lecture
                    Review slides
                    Prepare for lecture
                String we're considering: Prepare for lecture
                output: "Prepare for lecture", "Review slides"
             */

            if(!str.isEmpty() && !output.contains(str)) {
                output.add(str);
            }

            //            if(str.isEmpty() && output.contains(str)) {
            //                continue;
            //            } else {
            //                output.add(str);
            //            }
        }

        // write to the todo.txt
        String updatedFileContents = String.join(System.lineSeparator(), output);
        Files.writeString(file, updatedFileContents);
    }
}
