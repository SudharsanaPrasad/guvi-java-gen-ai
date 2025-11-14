package com.guvi.backtracking;

/*

Problem: Given a string, generate all possible subsequences.
A subsequence is a new string formed from the original by deleting zero or more characters without changing the relative order of the remaining ones.

Input: "abc"

All subsequences - backtracking:
Output:
""
"a"
"b"
"c"
"ab"
"ac"
"bc"
"abc"
 */
public class StringSubsequences {
    /*
    "abc" -> "a" (remaining: "bc")- explore
            "b" -  explore
            "c" - explore


      Input: "" -> ""
     */
    public static void findSubsequences(String input, String current) {
        // base case
        // has my input reached the smallest possible representation?
            // string -> empty string as the smallest representation
        if(input.isEmpty()) {
            System.out.println("' " + current + "'");
            return;
        }

        // recursive step
        // get the character at the 0th position - CHOOSE
        char ch = input.charAt(0);
        String rest = input.substring(1);

        // Explore: we explore this path by adding to that current substring
        // rest = "bc", current = "a"
        findSubsequences(rest, current + ch);

        // unchoose & explore: unchoose the previously chosen character
        // we explore another decision tree but NOT adding "ch" to "current"
        findSubsequences(rest, current);

    }

    public static void main(String[] args) {
        String str = "abc";
        findSubsequences(str, "");
    }
}
