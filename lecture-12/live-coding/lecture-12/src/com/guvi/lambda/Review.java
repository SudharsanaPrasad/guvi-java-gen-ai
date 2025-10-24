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

        final String str = "Thirumani";
        IPrintTwo myPrinter2 = () -> {
            System.out.println("Item to print: " + str);
        };
//        str = "Nikhil";
    }
}
