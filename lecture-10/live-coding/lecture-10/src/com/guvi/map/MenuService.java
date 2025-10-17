package com.guvi.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

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
public class MenuService {
    private HashMap h = new HashMap();
    private LinkedHashMap lH = new LinkedHashMap();

    public void updatePrice(String item, Integer price) {
        if(price == null || price < 0) {
            throw new IllegalArgumentException("Price is invalid");
        } else {
            h.put(item, price);
            lH.put(item, price);
        }
    }

    /*
    key ->              value
    tea ->              25 - Integers (Object)
    coffee ->           30 (Object) -> integer
    "masala chai" ->    30
    "black coffee" ->   "random string"

    h.values() -- collection of values -> 25, 30, 30, "random string"
    for(Object ob = 25) ... hValue =+ 25
    for(Object ob = 30) ... hValue =+ 30
    for(Object ob = 30) ... hValue =+ 30
     */
    // lH.values() => access each value as an Object
    // get us the sum of ALL prices for menu items
    public int sumPrice() {
        int hValue = 0;
        for(Object obj: h.values()) {
            // type casting -> from an Object to an Integer
            hValue += (Integer) obj;
        }
        return hValue;
    }

    public HashMap getHashMap() { return h; }
    public LinkedHashMap getLinkedHashMap() { return lH; }

}
