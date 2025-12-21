package com.guvi;

import java.util.Comparator;

/**
 * MinHeap:
 *  Complete BT
 *  Min-Heap Property: parent <= children
 *      - min value in the entire heap must be at the root
 */
public class MinHeap<T> {

    private Object[] heap;
    private int size;

    private static final int DEFAULT_CAPACITY = 16;

    private Comparator<T> comparator;

    // MinHeap<Integer> heap = new MinHeap<>();
    public MinHeap() {
        this(null, DEFAULT_CAPACITY);
    }

    public MinHeap(Comparator<T> comparator) {
        this(comparator, DEFAULT_CAPACITY);
    }

    // MinHeap<Integer> heap = new MinHeap<>(comparator, 32);
    public MinHeap(Comparator<T> comparator, int initialCapacity) {
        if(initialCapacity < 1) {
            throw new IllegalArgumentException("Initial capacity must be greater than 1");
        }
        this.comparator = comparator;
        this.size = 0;
        this.heap = new Object[initialCapacity];

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if(size == 0) {
            return null;
        }
        // return (T) heap[0];
        return elementAt(0);
    }

    /**
     * Insertion into our heap
     *
     * @param index
     * @return
     */
    public void add(T value) {
        // validation: value == null

        // [TODO] ensure the capacity exists for the new addition
        ensureCapacity(size + 1);
        // add the value
        heap[size] = value;

        // sift up
        siftUp(size);
        // increment the size
        size++;
    }

    /**
     * Repairs heap order by moving the element at the given index upwards until:
     *  - it reaches the root
     *  - its parent is <= it (min-heap property holds)
     * @param index
     */
    private void siftUp(int index) {
        int currentIndex = index;

        // iterate till we get to the root
        while(currentIndex > 0) {
            // find the parent
            int parentIndex = parentIndex(index);
            // compare(current, parent) >= 0
                // return
            T currentEl = elementAt(currentIndex);
            T parentEl = elementAt(parentIndex);
            if(compare(currentEl, parentEl) >= 0) {
                return;
            }

            // swap
            swap(currentIndex, parentIndex);
            // update current
            currentIndex = parentIndex;
        }
    }

    public T poll() {
        // validation: what if the heap is empty?
        if(size == 0) return null;

        T min = elementAt(0);
        int lastIndex = size - 1;

        heap[0] = heap[lastIndex];
        heap[lastIndex] = null;
        size--;

        if(size > 0) {
            siftDown(0);
        }

        return min;
    }

    /**
     * Repairs heap order by moving the element at the given index downward until:
     *  - the element has no children
     *  - the element is <= both children
     * @param index
     */
    private void siftDown(int index) {
        int currentIndex = index;

        // boolean isLeaf = false;

        while(true) {
            int leftChildIndex = leftChildIndex(currentIndex);
            if(leftChildIndex >= size) {
                // no left children
                return;
            }

            int rightChildIndex = rightChildIndex(currentIndex);

            // default: left child is smaller
            int smallerChildIndex = leftChildIndex;

            // if right is smaller, switch it
            if(rightChildIndex < size &&
                compare(elementAt(rightChildIndex), elementAt(leftChildIndex)) < 0) {
                smallerChildIndex = rightChildIndex;
            }

            // what if the current index is less than smaller child index?
            if(compare(elementAt(currentIndex), elementAt(smallerChildIndex)) <= 0 ) {
                // the heap property is satisfied
                return;
            }

            swap(currentIndex, smallerChildIndex);
            currentIndex = smallerChildIndex;
        }
    }

    // ============ HELPER METHODS ============

    private int parentIndex(int i) {
        return (i - 1) / 2;
    }

    private int leftChildIndex(int i) {
        return 2 * i + 1;
    }

    private int rightChildIndex(int i) {
        return 2 * i + 2;
    }

    @SuppressWarnings("unchecked")
    private T elementAt(int index) {
        // heap -> Object[], heap[0] -> Object
        return (T) heap[index];
    }

    /**
     * Centralizing the ordering:
     *  - Comparator takes priority, if exists
     *  - Otherwise, the element must be Comparable<T>
     * @param a
     * @param b
     * @return
     */
    private int compare(T a, T b) {
        if(comparator != null) {
            return comparator.compare(a, b);
        }
        return ((Comparable<T>) a).compareTo(b);
    }

    /**
     * Heap order is restored by swapping values at positions
     */
    private void swap(int i , int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void ensureCapacity(int required) {
        // If there's sufficient space, do nothing
        if (required <= heap.length) return;

        // Grow the array by about 1.5x (multiply by 3/2)
        int newCap = heap.length * 3 / 2;

        // If that's still not enough, make it exactly the required size
        if (newCap < required) {
            newCap = required;
        }

        // Create a new array with the larger capacity
        Object[] newArr = new Object[newCap];

        // Copy old elements into the new array
        for (int i = 0; i < size; i++) {
            newArr[i] = heap[i];
        }

        // Replace the old heap with the new one
        heap = newArr;
    }

}
