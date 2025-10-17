package com.guvi.generics;

public class Main {
    public static void main(String[] args) {
        Box<String> box = new Box<>("Square");
        String str = box.get();
        System.out.println(str);
    }
}
