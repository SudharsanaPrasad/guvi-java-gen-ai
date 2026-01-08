package com.guvi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastVsFailSafeDemo {
    public static void main(String[] args) {
        // FAIL-FAST example (ArrayList):
        // WHAT: Many standard collection iterators are fail-fast.
        // WHY: If the collection is structurally modified while iterating, Java throws
        //      ConcurrentModificationException to prevent unpredictable behavior.
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4));

        try {
            for (Integer n : nums) {
                if (n == 1) {
                    // Modifying the list while a foreach loop is iterating -> usually crashes
                    nums.remove(n);
                }
            }
        } catch (Exception e) {
            System.out.println("Fail-fast triggered on ArrayList: " + e);
        }

        // FAIL-SAFE (snapshot-style) example (CopyOnWriteArrayList):
        // WHAT: Iteration happens over a copy (snapshot) of the underlying array.
        // WHY: The iterator doesn't see concurrent modifications, so it doesn't throw CME.
        // NOTE: Great for many-reads/few-writes. Writes are expensive because they copy the array.
        List<Integer> nums2 = new CopyOnWriteArrayList<>(List.of(1, 2, 3, 4));
        for (Integer n : nums2) {
            if (n == 1) {
                nums2.remove(n); // does not crash
            }
        }
        System.out.println("CopyOnWriteArrayList after removal: " + nums2);

        // SAFE removal during iteration using Iterator.remove():
        // WHAT: Iterator has a remove() method tied to the iteration state.
        // WHY: It updates internal bookkeeping (like modCount), so it remains consistent and safe.
        List<Integer> nums3 = new ArrayList<>(List.of(1, 2, 3, 4));
        Iterator<Integer> it = nums3.iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (n == 1) {
                it.remove(); // safe way to remove the "current" element
            }
        }
        System.out.println("ArrayList after Iterator.remove(): " + nums3);
    }
}
