package comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import lambda.Item;

public class Main {
    interface Monitor { void display(String s); }

    public static void main(String[] args) {
        Monitor p = System.out::print;
        p.display("Hi");


//        Item item = new Item("Tea", 25);
//        Item item2 = new Item("Momo", 80);
//        Item item3 = new Item("Pizza", 100);
//
//        List<Item> menu = new ArrayList<>(List.of(item3, item2, item));
//        // tea -> 25 -> a
//        // momo -> 80 -> b
//        // compare -> 25 - 80 -> -55
////        menu.sort((a, b) -> Integer.compare(b.price, a.price));
////        for(Item i : menu) {
////            System.out.println(i.price);
////        }
//
//        Comparator<Item> byLen = (a, b) -> Integer.compare(b.name.length(), a.name.length());
//        menu.sort(byLen);
//        for(Item i : menu) {
//            System.out.println(i.name);
//        }

    }
}
