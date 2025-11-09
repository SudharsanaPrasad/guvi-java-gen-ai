package com.guvi.strings;

/*
Problem: You receive a compact tag like "A3C2Z5"
    Each letter is followed by a digit telling how many times to repeat it.
    Expected output: "AAACCZZZZZ".
Task
    Write a method decodeTag(String input) to expand the tag.
    Use charAt() to read letters and digits one by one.
    Use substring() or concat() to build the new string progressively.
    Call .intern() on the final string to store it in the String pool.
 */
public class TagDecoder {
    public static void main(String[] args) {
        decodeTag("A3C2Z5");
        decodeTag("B1D4");
        //decodeTag("A1B12");  // invalid example
    }

    /*
        // pseudocode
        // consider input: A1B8
        // even/odd indices -> even is the letter, odd is the index
        // hashmap -> string array + int array
        // for loop
            // i % 2 = 0 -> even -> we've found a letter
            // i % 2 = 1 -> odd -> we've found a number
                // validation: 1-9, inclusive
        // another for loop to create the result; (i+2)
            // for ith character -> you'll concat to a string result


        Input: A3C2Z5
               012345
        String result
        for 0 -> 5; i + 2: A, C, Z
            letter  -> A
            countLetter -> 3
            // validation
            for 0 -> countLetter; j++
                create a result
         print
         // <C><N>
            // C -> a letter in the alphabet
            // N -> is a integer between 1-9
         // A1B, A2B9D
     */
    /*public static void decodeTag(String input) {
        // validation, if input == null
        if(input == null || input.length() % 2 != 0) {
            System.out.println("Invalid input: " + input);
            return;
        }

        String result = "";
        // i += 2
        for(var i = 0; i < input.length(); i = i + 2) {
            char letter = input.charAt(i);
            char countChar = input.charAt(i + 1);

            // validations
            boolean isLetter = Character.isLetter(letter);
            boolean isDigit = Character.isDigit(countChar);
            // (int) letter -> ASCII; 1 -> 48
            if(!isDigit && !isLetter) {
                System.out.println("Invalid pair at position " + i);
                return;
            }

            int count = Character.getNumericValue(countChar);
            for(int j = 0; j < count; j++) {
                result = result.concat(String.valueOf(letter));
            }
        }
        System.out.println(result);
    }*/

    public static void decodeTag(String input) {
        // validation
        if (input == null || input.length() < 2) {
            System.out.println("Invalid tag: " + input);
            return;
        }

        String result = "";

        // Process two characters at a time: letter + digit
        for (int i = 0; i < input.length(); i += 2) {
            if (i + 1 >= input.length()) {
                System.out.println("Invalid tag (missing count): " + input);
                return;
            }

            char letter = input.charAt(i);
            char digitChar = input.charAt(i + 1);

            // Validate digit
            if (!Character.isDigit(digitChar)) {
                System.out.println("Invalid tag (expected digit after letter): " + input);
                return;
            }

            // digitChar is a character: has a ASCII value
            // subtracting '0' from digitChar -> will subtract the ASCII value of digitCharacter
            // Eg: digitChar - 6; ASCII: 54
            //
            int count = digitChar - '0';

            for (int j = 0; j < count; j++) {
                result = result.concat(String.valueOf(letter));
            }
        }

        // Store decoded string in String pool
        result = result.intern();

        System.out.println("Decoded Tag: " + result);
    }
}

/*
public static void decodeTag(String input) {
        if (input == null || input.length() < 2) {
            System.out.println("Invalid tag: " + input);
            return;
        }

        String result = "";

        // Process two characters at a time: letter + digit
        for (int i = 0; i < input.length(); i += 2) {
            if (i + 1 >= input.length()) {
                System.out.println("Invalid tag (missing count): " + input);
                return;
            }

            char letter = input.charAt(i);
            char digitChar = input.charAt(i + 1);

            // Validate digit
            if (!Character.isDigit(digitChar)) {
                System.out.println("Invalid tag (expected digit after letter): " + input);
                return;
            }

            int count = digitChar - '0';

            for (int j = 0; j < count; j++) {
                result = result.concat(String.valueOf(letter));
            }
        }

        // Store decoded string in String pool
        result = result.intern();

        System.out.println("Decoded Tag: " + result);
    }
}
 */