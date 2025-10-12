package activity.one;

import java.util.Iterator;

/*
Goal: build a small Cart that stores item names in insertion order and ignores exact duplicates
Rules
    addItem rules: reject null or blank strings; ignore duplicates; return boolean for success.
    Remove during iteration: delete every item that starts with B in a safe manner
Items to start: Start with: Apples, Bread, Banana, Milk, Bread
Expected final cart: Apples, Milk

// List -> ArrayList or LinkedList
 */
public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        // string array => Apples, Bread, Banana, Milk, Bread
        cart.addItems("Apples");    //
        cart.addItems("Bread");     //
        cart.addItems("Banana");    // remove
        cart.addItems("Milk");
        cart.addItems("Bread");

        Iterator cartIterator = cart.getFruits().iterator();
        while(cartIterator.hasNext()) {
            String str = (String) cartIterator.next();   // Object -> String
            if(str.startsWith("B")) {
                cartIterator.remove();
            }
        }
        System.out.println(cart.getFruits());
    }
}
