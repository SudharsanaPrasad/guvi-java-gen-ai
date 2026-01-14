package com.guvi;

class ValidationResultClass {
    boolean ok;
    String message;
    // Traditional class requires:
    // - constructor
    // - getters/setters
    // - hashCode, equals, toString
    // Record solves this boilerplate for "data carrier" objects.
}

public class RecordDemo {

    // record:
    // What: a compact data carrier type (immutable by default)
    // Why: auto-generates constructor, accessors, equals, hashCode, toString
    record ValidationResult(boolean ok, String message) {
        // You can still add methods here if needed.
    }

    static ValidationResult validateLogin(String username, String password) {
        // What: returns a ValidationResult instead of throwing errors immediately
        // Why: lets the caller decide how to handle failure vs success
        if (username == null) {
            return new ValidationResult(false, "Username is required");
            // Alternative approach: throw new IllegalArgumentException("Username is required");
        }

        if (password == null) {
            return new ValidationResult(false, "Password is required");
            // Alternative approach: throw new IllegalArgumentException("Password is required");
        }

        return new ValidationResult(true, "Login is successful!");
    }

    public static void main(String[] args) {
        // Scenario: validate login inputs and return a consistent result object
        ValidationResult vR1 = validateLogin("shalini", null);
        ValidationResult vR2 = validateLogin("yirou", "1234");
        ValidationResult vR3 = validateLogin(null, "1234");

        // record gives a nice default toString() output (easy for debugging/logging)
        System.out.println(vR1);
        System.out.println(vR2);
        System.out.println(vR3);
    }
}