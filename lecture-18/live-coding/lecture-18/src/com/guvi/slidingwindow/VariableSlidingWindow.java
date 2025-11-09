package com.guvi.slidingwindow;

import java.util.HashSet;
import java.util.Set;

//Problem: Find length of longest substring without repeating characters
// Two issues pending fix
public class VariableSlidingWindow {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int left = 0;
        int maxLen = 0;
        Set<Character> trackedChars = new HashSet<>();
        for(var right = 0; right < s.length(); right++) {
            // is the ith character a repeating char?
            if(trackedChars.contains(s.charAt(right))) {
                trackedChars.remove(s.charAt(left));
                left++;
            }

            // add the ith character to the substring
             trackedChars.add(s.charAt(right));

            // update maxLen
            // variation: right - left
            maxLen = Math.max(maxLen, trackedChars.size());
        }
        System.out.println("Max length " + maxLen);
    }
}
