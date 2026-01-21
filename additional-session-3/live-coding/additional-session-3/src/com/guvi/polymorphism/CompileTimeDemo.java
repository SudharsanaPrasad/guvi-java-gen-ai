package com.guvi.polymorphism;

import java.util.List;

public class CompileTimeDemo {

    // Overloading: same method name, different parameter list.
    // The compiler chooses the correct method based on the argument types.
    static class Notifier {

        public void send(String phoneNumber, String message) {
            System.out.println("Sending message \"" + message + "\" to number " + phoneNumber);
        }

        public void send(List<String> phoneNumbers, String message) {
            System.out.println("Sending message \"" + message + "\" to numbers " + phoneNumbers);
        }
    }

    public static void main(String[] args) {
        Notifier notifier = new Notifier();

        notifier.send("123-123", "Your OTP is 1234");
        notifier.send(List.of("123-123", "555-555"), "Your OTP is 1234");
    }
}