package com.guvi.exceptions.checked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInput {
    /*
          The method signature tells us that main can throw an IOException
          No customization of the message
     */
    public static void main(String[] args) throws IOException {
        // creating an instance of BufferedReader
        // to create an instance of BufferedReader, we are using the parameterized constructor
        // the parameterized constructor of BufferedReader required an InputStreamReader
        // the parameterized constructor of InputStreamReader required an InputStream
        // System.in -> an InputStream
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name: ");
        String name = reader.readLine();
        System.out.println("Hello, "+ name);
    }
}
