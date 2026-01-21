# Additional Session 1 (Jan 7, 6:00 PM)

## Question from Yirou

### Purpose of `getOrDefault` in `HashMap`

`getOrDefault(key, defaultValue)` helps you avoid a manual `null` check when a key might not exist. This keeps code shorter and reduces mistakes.

**Important nuance:** If a key is present but mapped to `null`, `getOrDefault` returns `null` (it only uses the default when there is **no mapping** for the key).

```java
Map<Character, Integer> freq = new HashMap<>();
String s = "abca";

// Without getOrDefault (more boilerplate)
for (char c : s.toCharArray()) {
    if (freq.containsKey(c)) {
        freq.put(c, freq.get(c) + 1);
    } else {
        freq.put(c, 1);
    }
}

// With getOrDefault (clean + common pattern)
for (char c : s.toCharArray()) {
    freq.put(c, freq.getOrDefault(c, 0) + 1);
}
```

In the second loop, if `c` isn’t in the map yet, `getOrDefault(c, 0)` returns `0`, so `0 + 1` works cleanly.

## Questions from Soumyajit

## 1) List vs Set vs Map

### List (interface)

A **List** is like a playlist: items are in a sequence.

* Maintains **insertion order**
* Allows **duplicates**
* Common implementations: `ArrayList`, `LinkedList`
* Typical operations:

  * Create: `new ArrayList<>()`, `List.of("abc", "cde")`
  * Insert: `add(...)`
  * Read: `get(index)`, for-each, `Iterator`
  * Update: `set(index, value)`
  * Delete: `remove(index)` / `remove(value)`

### Set (interface)

A **Set** is like a unique attendee list: duplicates are automatically ignored.

* **No duplicates**
* Order is **not guaranteed** by default
* Common implementations:

  * `HashSet`: uniqueness, no predictable iteration order
  * `LinkedHashSet`: uniqueness + preserves **insertion order**
  * `TreeSet`: uniqueness + keeps elements **sorted**

### Map (interface)

A **Map** is like a phonebook/dictionary.

* Stores **key-value pairs**
* **Keys are unique**, values can repeat
* Great for fast lookup by key
* Common implementations: `HashMap`, `LinkedHashMap`, `TreeMap`

## 2) ArrayList vs LinkedList (concept only)

### ArrayList

ArrayList is like a row of seats in a movie theater (index-based).

* Backed by a **resizable array**
* When it grows, it creates a **bigger array** and copies elements
* Time complexity (typical):

  * `add(element)` at end: **O(1) amortized**
  * `get(index)`: **O(1)**
  * `set(index, element)`: **O(1)**
  * `remove(index)`: **O(n)** (shifting happens)
  * `contains(element)`: **O(n)**

### LinkedList (Java’s `LinkedList` is doubly-linked)

LinkedList is a chain of nodes (each node links to next/prev).

* Good when you add/remove frequently (especially at ends)
* Time complexity (typical for Java `LinkedList`):

  * `addFirst()`: **O(1)**
  * `addLast()`: **O(1)**
  * `add(element)` (adds at end): **O(1)**
  * `get(index)`: **O(n)** (must walk nodes)
  * `set(index, element)`: **O(n)** (walk + replace)
  * `removeFirst()`: **O(1)**
  * `removeLast()`: **O(1)**
  * `remove(index)`: **O(n)**

## 3) HashSet vs TreeSet vs LinkedHashSet

* **HashSet**

  * Uniqueness
  * No guaranteed iteration order

* **LinkedHashSet**

  * Uniqueness
  * Preserves **insertion order**

* **TreeSet**

  * Uniqueness
  * Keeps elements **sorted** (natural order or comparator)
  * Typically does **not allow null** with natural ordering (because comparison breaks)

## 4) HashMap (basics + where to use)

* Stores **key/value**
* Allows **one null key** and **multiple null values**
* **Not thread-safe**
* Very fast for single-threaded use

### ConcurrentHashMap (why it exists)

* Thread-safe Map designed for concurrency
* Iterators are **weakly consistent**: they don’t throw `ConcurrentModificationException`, and they may reflect some updates happening during iteration
* Note: `HashMap` is still usually faster in a purely single-threaded context

### Common use cases

**A) Frequency count**

```text
"abcaaad"
a -> 4
b -> 1
c -> 1
d -> 1
```

**B) Detect duplicates**
One approach: count frequencies; any character with count > 1 is a duplicate.

(Alternate simpler approach is a `Set`, but the Map approach is useful when you also want counts.)

## 5) `equals()` and `hashCode()`

### Two kinds of equality checks

* **Reference equality:** `a == b`

  * Checks if both references point to the **same object**
* **Logical equality:** `a.equals(b)`

  * Checks if two objects should be considered “same by value”

### What `hashCode()` is used for

* Produces an `int` hash for an object
* Hash-based collections (`HashMap`, `HashSet`) use it to decide the “bucket” for storing/finding items

### Core contract to remember

If `a.equals(b)` is true, then `a.hashCode()` must equal `b.hashCode()`.

## 6) Comparable vs Comparator

### Comparable

Use when a class knows its **natural ordering**.

* Implement `Comparable<T>`
* Override `compareTo`

Example idea: `User` naturally sorted by `userId` (or `email`, etc.)

### Comparator

Use when you want **external** sorting rules (multiple sort options).

* Define sorting outside the class
* Great for “sort by price”, “sort by rating”, etc.

Example shape:

```java
Comparator<Product> byPrice = (a, b) -> Integer.compare(a.price, b.price);
Comparator<Product> byRating = (a, b) -> Integer.compare(b.rating, a.rating);
```

## 7) Fail-Fast vs Fail-Safe (and “weakly consistent”)

### Fail-Fast (most common in standard collections)

* Iterator throws `ConcurrentModificationException` if the collection is structurally modified during iteration
* Examples: `ArrayList`, `HashMap`, `HashSet` iterators

### Fail-Safe (snapshot-style)

* Iterator works over a **copy/snapshot**
* Example: `CopyOnWriteArrayList` iterator

### Weakly consistent (common in concurrent collections)

* Doesn’t throw `ConcurrentModificationException`
* May or may not reflect concurrent updates while iterating
* Example: `ConcurrentHashMap` iterators

# Pending Questions (to cover next)

* Internal working of `HashMap` / `Set` / `HashSet`
* Time complexities of collections (quick reference table)
* How to prevent / reduce hash collisions
* In a hash table: during lookup, if multiple keys land in the same bucket, how does it find the right value within that bucket?