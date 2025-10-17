package com.guvi.map;

/*
Goal: Represent a cafe menu in Java using a HashMap and a LinkedHashMap
Build
- Create a class, MenuService, with two instance variables (type HashMap & LinkedHashMap)
- Implement two methods: updatePrice(String item, Integer price) and total()
Rules
- updatePrice throws IllegalArgumentException if price is null or negative; if item is valid, use put to insert/update both maps
- total sums all Integer values in the given map
Task
- Initialize both maps with products: Tea (price: 80) and Latte (140); update Latte’s price to 150 and add Mocha (110)
- Attempt an invalid update for Tea with a negative price and handle the exception at the call site with a one line message
- Print both maps and the total from the LinkedHashMap
 */
public class Main {
    // updatePrice("chai", "random ");  ->
    public static void main(String[] args) {
        MenuService menu = new MenuService();
        menu.updatePrice("Tea", 80);
        menu.updatePrice("Latte", 140);

        menu.updatePrice("Latte", 150);

        try {
            menu.updatePrice("Tea", -50);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
//            ex.printStackTrace();
        }

        System.out.println(menu.getHashMap());
        System.out.println(menu.getLinkedHashMap());
        System.out.println(menu.sumPrice());
    }
}
