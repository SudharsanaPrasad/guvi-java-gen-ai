package com.guvi.lambda;

public class Printer implements IPrint {
    @Override
    public void print(String input) {
        System.out.println("Item to print: " + input);
    }
}
