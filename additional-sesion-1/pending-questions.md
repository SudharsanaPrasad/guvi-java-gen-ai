# Pending Questions

## 1) Internal Working of `HashMap`

### What a `HashMap` really is

A `HashMap<K, V>`, where K & V represents the key and value in Generics, is basically:

* An **array of buckets**
* Each bucket stores:

  * **nothing** (empty)
  * a **linked list** of nodes (collision chain)

### How `put(key, value)` decides where to store

1. Compute the key’s hash:

   * It calls `key.hashCode()`
   * Then mixes bits (to reduce collisions from bad low bits)
2. Convert hash to bucket index:

   * For a table size `n` (usually power of 2), index is:

     * `index = (n - 1) & hash`

**Why this matters:** if two different keys land in the same index, you get a collision.

### What happens on collision

If bucket already has nodes:

* It checks nodes in the bucket:

  * If it finds same key (hash matches AND `equals` matches), it **updates value**
  * Else it **adds a new node** in that bucket
* If too many nodes pile up in one bucket:

  * Newer versions of Java can convert the bucket from a linked list into a tree (called **treeify**)
  * This is a safety net for worst-case collisions

### Rehashing / Resizing

HashMap grows when it crosses a threshold:

* threshold = `capacity * loadFactor` (default loadFactor is 0.75)
* On resize:

  * capacity doubles
  * keys get redistributed into new buckets because index depends on `n`
    * What does index depend on `n`? Because the bucket index is computed using the table size n. So if n changes (e.g., 16 to 32), and the same key’s hash can map to a different index

### Null rules

* `HashMap` allows:

  * one `null` key
  * multiple `null` values

## 2) Internal Working of `Set` and `HashSet`

### What is `Set`?

* `Set` is just an interface (uniqueness rule).
* Different implementations enforce uniqueness differently.

### How `HashSet` works internally

A `HashSet<E>` is basically a wrapper around a `HashMap<E, Object>`:

* Element becomes the **key**
* Value is a dummy constant (often named `PRESENT`)

So:

* `set.add(x)` is basically:

  * `map.put(x, PRESENT)`

**Why this is important:**

* Uniqueness comes from `HashMap`’s rule: keys must be unique.
* That’s why **HashSet depends on `hashCode()` + `equals()`**.

### Common related implementations

* `HashSet` uses `HashMap`
* `LinkedHashSet` uses `LinkedHashMap` (keeps insertion order)
* `TreeSet` uses `TreeMap` (keeps sorted order) - since we didn't cover it, you're not required to understand TreeSet.

## 3) Hash Collisions

### Collision scenario 1: “Bad hashCode” creates a pile-up (easy to understand)

If your `hashCode()` returns the same value for all objects, everything goes to the same bucket.

#### Failure code (intentional bad hashing)

```java
import java.util.HashMap;
import java.util.Map;

class BadKey {
    int id;
    BadKey(int id) { this.id = id; }

    @Override
    public int hashCode() {
        return 1; // BAD: all keys collide
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BadKey)) return false;
        return this.id == ((BadKey) o).id;
    }
}

public class CollisionBadHashDemo {
    public static void main(String[] args) {
        Map<BadKey, String> map = new HashMap<>();
        for (int i = 1; i <= 8; i++) {
            map.put(new BadKey(i), "val" + i);
        }

        // Works, but internally many keys collided into the same bucket.
        System.out.println(map.get(new BadKey(7)));
    }
}
```

**Key point to should understand here:**

* HashMap still works logically.
* But performance can degrade badly because it has to scan a long chain (or treeify later).

#### Fix: “Good hashCode distribution”

Use fields that identify the object, and produce a hash that spreads well.

```java
import java.util.Objects;

class GoodKey {
    int id;
    GoodKey(int id) { this.id = id; }

    @Override
    public int hashCode() {
        return Objects.hash(id); // simple and correct for this case
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GoodKey)) return false;
        return this.id == ((GoodKey) o).id;
    }
}
```

### Collision scenario 2: Different hashes, same bucket

Even with decent hashing, collisions can happen because bucket index uses the table size.

Assume:

* capacity `n = 16`
* mask `n - 1 = 15` (binary `1111`)
* index = `(n - 1) & hash`

Example:

* `hash1 = 26` -> binary `11010`

  * `26 & 15 = 10` ('&' here is called a bitwise AND operator; [reference](https://www.baeldung.com/java-bitwise-operators))
* `hash2 = 42` -> binary `101010`

  * `42 & 15 = 10`

Both land in bucket 10, collision.

**How Java reduces this problem:**

* HashMap mixes bits of the hash so low bits are not the only source of truth.
* Also resizing changes the mask and spreads entries more.

### Collision scenario 3: “Mutable key” makes retrieval fail

If you mutate a key after inserting it, you may never be able to find it again.

#### Failure code

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class UserKey {
    String email;
    UserKey(String email) { this.email = email; }

    @Override
    public int hashCode() { return Objects.hash(email); }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserKey)) return false;
        return Objects.equals(this.email, ((UserKey) o).email);
    }
}

public class MutableKeyFailureDemo {
    public static void main(String[] args) {
        Map<UserKey, String> map = new HashMap<>();
        UserKey k = new UserKey("test@gmail.com");
        map.put(k, "present");

        // Mutating the key changes its hashCode -> it now "belongs" in another bucket.
        k.email = "test.new@gmail.com";

        System.out.println(map.get(k)); // often prints null (unexpected!)
    }
}
```

#### Fix

* Use **immutable keys** (records are great for this)
* Or never mutate fields that participate in `hashCode()`/`equals()`

## 4) How to prevent collisions

You can’t eliminate collisions entirely, but you can avoid “bad collisions”.

### Do these

* Write `hashCode()` using stable identity fields
* Ensure `equals()` and `hashCode()` follow the contract:

  * if `a.equals(b)` is true, `a.hashCode()` must equal `b.hashCode()`
* Keep keys immutable (or treat them as immutable once used as a key)
* Use reasonable initial capacity when you know size upfront (reduces rehashing)

### Avoid these

* `hashCode()` returning constant values
* Using mutable objects as keys (or mutating them after insertion)
* Implementing `equals()` but forgetting `hashCode()` (common bug)

## 5) High-level overview of `Hashtable` (important points)

### What is a `Hashtable`?

* Legacy class from older Java days (before modern collections matured)
* Also an array of buckets + collision chains, like HashMap
* But with different rules and tradeoffs

### Key differences vs `HashMap`

* Thread safety:

  * `Hashtable` is synchronized (coarse-grained locking is enabled)
  * `HashMap` is not thread-safe
  * `ConcurrentHashMap` is the modern choice for concurrency
* Null handling:

  * `Hashtable` does **not** allow `null` key or `null` value
  * `HashMap` allows one null key and many null values

### When learners should care

* Mostly for legacy codebases and interview discussions
* In real modern systems:

  * Prefer `HashMap` for single-threaded
  * Prefer `ConcurrentHashMap` for multi-threaded

## 6) Retrieval logic: “How does it fetch the value if multiple keys are in the same bucket?”

When you do:

```java
map.get(key)
```

HashMap does this (conceptually):

1. Compute `hash` for the key
2. Compute `index = (n - 1) & hash`
3. Go to bucket `table[index]`
4. If bucket is:

   * empty -> return null
   * list -> walk nodes:

     * check if node.hash == hash AND node.key.equals(key)
   * tree -> do tree lookup using comparisons (still guided by hash and equals)

So if multiple entries are in the same bucket:

* It does a controlled search inside that bucket using:

  * hash match as a quick filter
  * equals match as the final “same key” confirmation
