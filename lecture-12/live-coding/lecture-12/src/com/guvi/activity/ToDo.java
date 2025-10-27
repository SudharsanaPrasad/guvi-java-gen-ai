package com.guvi.activity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public class ToDo {
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

        // write to the todo.txt
        String updatedFileContents = normalize(fileContents);
        Files.writeString(file, updatedFileContents);
    }

    /**
     * normalize -- accepts the fileContents of todo.txt
     *          -- processes the fileContents: removes whitespace, empty lines, and duplicates
     * @param fileContents
     * @return  -- a String representing the processed fileContents
     */
    public static String normalize(String fileContents) {
        LinkedList<String> output = new LinkedList<>();
        // processing
        String[] lines = fileContents.split("\\R");
        for(String line: lines) {
            String str = line.trim();
            if(!str.isEmpty() && !output.contains(str)) {
                output.add(str);
            }
        }
        return String.join(System.lineSeparator(), output);
    }
}
