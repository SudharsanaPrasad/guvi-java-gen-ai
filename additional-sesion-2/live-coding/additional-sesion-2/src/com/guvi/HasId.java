package com.guvi;

@FunctionalInterface
public interface HasId {

    // Abstract Method
    // What: this makes it eligible for lambda usage.
    // Why: lambdas can implement functional interfaces.
    int getid();
}