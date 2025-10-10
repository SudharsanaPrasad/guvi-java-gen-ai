package com.guvi.absclass;

public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println("My doggo says hi!");
    }

    @Override
    public void consumeFood() {
        System.out.println("My doggo is consuming food");
    }

    public void consumeFood(String foodName) {
        System.out.println("My doggo is consuming " + foodName);
    }
}
