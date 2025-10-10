package com.guvi.absclass;

public abstract class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // validation
        this.name = name;
    }

    public void consumeFood() {
        System.out.println(name + " is consuming food!");
    }
}
