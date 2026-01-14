package com.guvi;

import java.util.Optional;

class UserService {

    // What: returns a name if found, otherwise returns null
    // Why: this is the "old style" that can lead to NullPointerException if not handled carefully
    String findName(String email) {
        if ("soumyajit@gmail.com".equals(email)) {
            return "Soumyajit";
        }
        return null;
    }

    // What: wraps the possible null into Optional
    // Why: makes "missing value" explicit, so callers are forced to handle it consciously
    Optional<String> findNameSafe(String email) {
        return Optional.ofNullable(findName(email));
    }
}

public class OptionalDemo {
    public static void main(String[] args) {
        UserService service = new UserService();

        // findNameSafe returns Optional<String> instead of String
        Optional<String> nameOpt = service.findNameSafe("malini@gmail.com");

        // Approach 1: isPresent() + get()
        // What: explicitly checks if value exists before reading it
        // Why: avoids NullPointerException
        if (nameOpt.isPresent()) {
            System.out.println("Found: " + nameOpt.get());
        } else {
            System.out.println("Not found");
        }

        // Approach 2: orElse(defaultValue)
        // What: provide a fallback if the value is missing
        // Why: keeps code simple when you have a sensible default
        String finalName = service.findNameSafe("malini@gmail.com")
            .orElse("GUEST");

        System.out.println(finalName);
    }
}