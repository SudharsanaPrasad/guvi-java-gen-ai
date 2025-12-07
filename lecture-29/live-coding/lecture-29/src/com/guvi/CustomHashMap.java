package com.guvi;

// Generics
// Example
// Key: Student, Value: String
// Key: String, Value: Integer
public class CustomHashMap<K, V> {
    // put, get, size, isEmpty, containsKey
    // Nodes

    // A node in a HashMap has a key/value pair
    // in its chain
    public static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> next;

        public Node(K key, V value, Node<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node<K, V>[] buckets;
    // # of entries in the hash map
    private int size;
    // constant
    private final int INITIAL_CAPACITY = 16;

    public CustomHashMap() {
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    public CustomHashMap(int capacity) {
        buckets = new Node[capacity];
        size = 0;
    }

    // Turn any key into a valid bucket index
    private int getIndex(K key) {
        if(key == null) {
            throw new IllegalArgumentException("null keys aren't allowed.");
        }

        // hash can be negative!
        int hash = key.hashCode();

        // remainder can be negative too
        // EG: -10 % -3 => 1
        int index = hash % buckets.length;

        // if(index < 0) {
            //index = index + buckets.length;
        //}

        return index;

    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> bucket = buckets[index];

        while(bucket != null) {
            if(key.equals(bucket.key)) {
                return bucket.value;
            }

            bucket = bucket.next;
        }

        return null;
    }

    // insertion: PUT -> key, value
    public V put(K key, V value) {
        // check if load factor has reached 0.75?
            // double the size of the buckets
                // creating an array of Node<K, V>[] that's double the size
                // "copying" over is different

        int bucketIndex = getIndex(key);
        Node<K, V> current = buckets[bucketIndex];

        // Case 1: bucket is empty
        if(current == null) {
            buckets[bucketIndex] = new Node<>(key, value, null);
            size++;
            return buckets[bucketIndex].value;
        }

        // Case 2: bucket has at least a single node
        Node<K, V> prev = null;
        while(current != null) {
            if(key.equals(current.key)) {
                current.value = value;
                return current.value;
            }
            prev = current;
            current = current.next;
        }

        // Case 3: once we exit the loop, we want to simply append
        // the new key/value pair to the end of the chain
        prev.next = new Node<>(key, value, null);
        size++;
        return prev.next.value;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public boolean containsKey(K key) {
        // call get with the key
        V node = get(key);
        if(node == null) return false;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (Node<K, V> node : buckets) {
            while (node != null) {
                sb.append(node.key).append("=").append(node.value).append(", ");
                node = node.next;
            }
        }
        if (size > 0) sb.setLength(sb.length() - 2);   // remove last ", "
        sb.append(" }");
        return sb.toString();
    }
}
