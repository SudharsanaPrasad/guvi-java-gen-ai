package com.guvi;

@FunctionalInterface
public interface HasEmployeeId extends HasId {

    // Important:
    // HasEmployeeId extends HasId, but DOES NOT add a new abstract method.
    // So it still has exactly 1 abstract method overall -> still a Functional Interface.

    // If we add another abstract method like this, it breaks @FunctionalInterface:
    // String convertIDToString(int id);

    // default method:
    // What: a method with implementation inside an interface
    // Why: lets you add behavior without breaking existing implementations
    default boolean doesIdEqual(int id1, int id2) {
        return id1 == id2;
    }

    // static methods in interfaces:
    // What: utility/helper functions related to this interface
    // Why: keeps common helper logic near the interface, without needing an object
    static String convertIDToString(int id) {
        return String.valueOf(id);
    }

    static double convertIDToDouble(int id) {
        return (double) id;
    }
}