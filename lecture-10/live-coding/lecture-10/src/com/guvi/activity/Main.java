package com.guvi.activity;

public class Main {
    public static void main(String[] args) {
        Cart<String> cart = new Cart<>();
        System.out.println(cart.first());
        cart.add("First");
        cart.add("Second");
//        cart.add(10.5);
        System.out.println(cart.first());
    }
}
