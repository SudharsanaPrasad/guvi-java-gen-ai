package com.guvi.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CollectionsDemo {
    public static void main(String[] args) {

        // Map.of(...) creates an immutable map.
        // Useful for constants like status codes, labels, config lookups, etc.
        final Map<Integer, String> LABELS = Map.of(
            200, "OK",
            400, "BAD_REQUEST",
            404, "NOT_FOUND"
        );

        // List.of(...) is immutable, so we create a mutable copy using ArrayList.
        List<Integer> nums = new ArrayList<>(List.of(5, 2, 9));

        /*
            List.of(5, 2, 9) replaces the need to use nums.add() method
            nums.add(5);
            nums.add(2);
            nums.add(9);
        */
        // The state of the list will change from (5,2,9) to (15,2,9)
        nums.set(0, 15);

        // Collections is a utility class with helpers like sort/reverse.
        Collections.sort(nums);
        Collections.reverse(nums);

        // This is an unmodifiable *view* of nums (not a deep copy).
        // You can't modify through this view, but if nums changes, this view reflects it.
        List<Integer> unmodifiableList = Collections.unmodifiableList(nums);

        // unmodifiableList.add(10); // UnsupportedOperationException

        nums.add(10); // modifying the original list is allowed
        System.out.println("nums: " + nums);
        System.out.println("unmodifiableList: " + unmodifiableList);

        // Truly immutable list (cannot change structure or values).
        List<Integer> immutableList = List.of(5, 5, 1);
        // immutableList.add(5); // UnsupportedOperationException

        // For multithreaded access: synchronized wrappers exist, but have limitations.
        // In modern code, prefer concurrency-friendly collections when needed.
        List<String> unsafeList = new ArrayList<>();
        List<String> threadSafeView = Collections.synchronizedList(unsafeList);
    }
}
