package com.guvi.lambda;

public class Review {


    public static void main(String[] args) {
        IPrint myPrinter = new IPrint() {
            @Override
            public void print(String input) {
                System.out.println("Item to print: " + input);
            }
        };

        Printer printer = new Printer();
        printer.print("Textbook");

        // effectively final
        String str = "Thirumani";
        String name = "Shalini";
        IPrintTwo myPrinter2 = () -> {
            System.out.println("Item to print: " + str);
        };
        name = "Nikhil";
    }
}
