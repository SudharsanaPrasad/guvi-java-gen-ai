package com.guvi.absclass;

public class Main {
    public static void main(String[] args) {
        Dog myDoggo = new Dog("Max");
        myDoggo.makeSound();
        myDoggo.consumeFood("Pizza");

        // declaration is of type Pet
        // instance of it's children -> Dog
        Pet myDoggo2 = new Dog("Charlie");
        myDoggo2.makeSound();
        myDoggo2.consumeFood();

//        final int number = 42;
//        // number = 43;
//        System.out.println(number);
//        int sum = number = 50;
    }
}
