package com.guvi;

import java.util.HashMap;
import java.util.Map;

public class GetOrDefaultDemo {
    public static void main(String[] args) {
        String s = "abca";

        // Frequency counting (character -> count)
        Map<Character, Integer> freq = new HashMap<>();

        // Without getOrDefault:
        // WHAT: You must manually handle the "missing key" case.
        // WHY: Because freq.get(c) returns null if c is not present.
        for (char c : s.toCharArray()) {
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
        }
        System.out.println("Without getOrDefault: " + freq);

        // With getOrDefault:
        // WHAT: Provide a default value when the key is missing.
        // WHY: Avoids boilerplate null checks and keeps the update logic in one line.
        Map<Character, Integer> freq2 = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }
        System.out.println("With getOrDefault   : " + freq2);

        // Note:
        // getOrDefault(key, defaultValue) uses the default ONLY when the key is absent.
        // If the key exists but maps to null, it returns null (not the default).
    }
}
