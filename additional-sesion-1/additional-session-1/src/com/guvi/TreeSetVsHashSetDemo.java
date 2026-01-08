package com.guvi;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetVsHashSetDemo {
    public static void main(String[] args) {
        // Same inputs for both sets (including duplicates)
        String[] fruits = {"strawberry", "banana", "apple", "mango", "mango", "strawberry"};

        // HashSet:
        // WHAT: Stores unique elements using hashing.
        // WHY: Fast add/contains on average, but iteration order is NOT guaranteed.
        Set<String> hashSet = new HashSet<>();
        for (String f : fruits) hashSet.add(f);

        // TreeSet:
        // WHAT: Stores unique elements in sorted order (natural order by default).
        // WHY: Useful when you want uniqueness + sorted iteration (but operations are typically slower than HashSet).
        Set<String> treeSet = new TreeSet<>();
        for (String f : fruits) treeSet.add(f);

        System.out.println("HashSet  (unique, no guaranteed order): " + hashSet);
        System.out.println("TreeSet  (unique + sorted order)     : " + treeSet);

        // Key takeaway:
        // - Both remove duplicates.
        // - HashSet: order may look random.
        // - TreeSet: always sorted.
    }
}
