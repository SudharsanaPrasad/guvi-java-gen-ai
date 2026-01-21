package com.guvi;

class Test {
    // Plain inner class. Kept from the session.
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {

        // HasEmployeeId is a @FunctionalInterface (via HasId.getid()).
        // So we can implement it using a lambda.
        HasEmployeeId empId = () -> 50; // returns employee id

        // Static methods in an interface are called on the interface name (not on an instance).
        System.out.println(HasEmployeeId.convertIDToString(50));
        System.out.println(HasEmployeeId.convertIDToDouble(50));

        // Calling the single abstract method defined in HasId (implemented by the lambda).
        System.out.println(empId.getid());

        // Anonymous class way (pre-lambda style) for functional interfaces like Runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // What: code that runs when a thread calls run()
                // Why: shows the older style before lambdas
            }
        };

        // Lambda way (cleaner) for Runnable (because it has exactly one abstract method: run())
        Runnable runnable2 = () -> {
            // What: same Runnable logic, written as a lambda
            // Why: less boilerplate than anonymous classes
        };
    }
}