# HashMap performance is conditional, not guaranteed

HashMap operations such as `put()` and `get()` are commonly described as
*O(1)*. This statement is correct in the average case, but it is easy to
misinterpret what that guarantee actually depends on. The performance of
a HashMap is not unconditional; it assumes that keys are distributed
reasonably evenly across the internal buckets.

When this assumption holds, most lookups involve examining only a very
small number of entries, often just one. When it does not, the same
operations begin to require more work, even though the code using the
HashMap looks exactly the same. This distinction matters because the
HashMap API does not enforce good key distribution. The data structure
provides the mechanism for fast access, but the quality of that access
depends on how keys are placed internally.

To understand why collisions matter, we need to look at what happens
when this assumption about distribution breaks down.

------------------------------------------------------------------------

# Collisions, chaining, and the cost of comparisons

A collision occurs when two different keys map to the same bucket. This
is not an error or an edge case; it is an expected outcome of
compressing a large key space into a fixed number of buckets. HashMap is
designed to handle collisions correctly.

When multiple entries land in the same bucket, HashMap stores them
together using chaining. During a lookup, HashMap iterates through the
entries in that bucket and compares the searched key against each stored
key using the `equals()` method. In other words, hashing determines
where to look, and `equals()` determines what matches.

Each additional entry in a bucket introduces additional equality checks.
If a bucket contains only one entry, the lookup is trivial. If it
contains several entries, HashMap must perform multiple comparisons
before it finds the correct one. As the number of entries in a bucket
grows, so does the amount of work required for every lookup involving
that bucket.

Nothing about correctness changes in this situation. HashMap continues
to return the correct values because `equals()` enforces correctness.
What changes is the cost of performing those operations. The real cost
of collisions is therefore not memory usage or incorrect behavior, but
repeated comparisons that quietly add up over time.

------------------------------------------------------------------------

# Distribution and clustering: when collisions become expensive

To understand when collisions turn into a performance issue, we need to
think in terms of distribution rather than collisions alone.

Distribution describes how evenly keys are spread across all buckets.
When distribution is good, most buckets contain very few entries, and
collision chains (aka the LinkedList) remain short. When distribution
is poor, some buckets become heavily loaded while others remain nearly
empty.

Consider a HashMap with 16 buckets and 160 keys. With ideal
distribution, each bucket would contain roughly ten keys. With poor
distribution, a small number of buckets might hold fifty or sixty keys,
while many buckets remain unused. In both cases, the number of keys is
the same and the HashMap is functioning correctly, but the cost of
lookups is very different.

When keys with similar structure repeatedly land in the same buckets,
this pattern is called clustering. Clustering concentrates work. Instead
of spreading comparisons evenly across the map, HashMap ends up
performing many `equals()` checks in the same few buckets. This is why
collisions themselves are not the primary concern. Collisions are
unavoidable. Clustering is what turns collisions into a performance
problem.

The real goal of hashing, therefore, is not to eliminate collisions, but
to avoid clustering by spreading collisions out.

------------------------------------------------------------------------

# How hashing mixes keys to reduce clustering

Hashing is often described as converting a key into an integer, but that
description hides the real objective. The purpose of hashing is not just
conversion; it is mixing.

A good hash function mixes input data so that patterns in the original
keys do not appear in the resulting hash values. This prevents
structurally similar keys from clustering into the same buckets.

Weak hash functions tend to preserve structure. For example, simply
adding character values ignores order and position, allowing many
different strings to collapse into the same result. Keys that look
similar end up behaving similarly, which leads directly to clustering.

Stronger hash functions build the hash value incrementally, combining
the previous result with each new part of the key:

``` java
int hash = 0;
for (char c : key.toCharArray()) {
    hash = hash * 31 + c;
}
```

In this approach, order matters, small changes in the key affect the
final result, and earlier characters influence later computation.
Multiplication helps spread values apart, while addition alone does not.
The specific constant used here is not the focus; its role is to improve
mixing so that similar inputs do not consistently land near each other.
What matters is the process of combining parts of the key in a way that
breaks patterns.

------------------------------------------------------------------------

# Observing distribution through a concrete example

The effect of distribution becomes clearer when we look at a concrete
example.

Consider a custom key type with a deliberately poor hash implementation:

``` java
class BadKey {
    private final String value;

    BadKey(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BadKey)) return false;
        BadKey other = (BadKey) o;
        return value.equals(other.value);
    }
}
```

Every instance of this key maps to the same bucket. All entries collide.
During a lookup, HashMap must walk through the entire chain and
repeatedly call `equals()` until it finds the correct key. The map
behaves correctly, but each operation performs more work than necessary.

Now compare this with a hash implementation that mixes the characters of
the key properly. The same set of keys spreads across many buckets.
Chains remain short, and the number of equality checks per lookup drops
significantly. The HashMap implementation does not change, and the keys
themselves do not change. Only the distribution of hash codes changes,
and with it, the cost of operations.

------------------------------------------------------------------------

# Using HashMap with a clearer mental model

Correctness in HashMap depends on `equals()` and `hashCode()` following
their contract. Performance depends on how well hash codes distribute
keys across buckets. Collisions are expected and handled, but when
collisions become concentrated through clustering, HashMap compensates
by performing more comparisons during lookups.

This distinction becomes especially important when working with custom
key types or keys that share strong structural patterns. In such cases,
hashing is not a formality; it directly affects how much work the data
structure performs. Once this relationship is understood, HashMap stops
being opaque. Its behavior becomes explainable, and its performance
characteristics become something you can reason about and influence
deliberately.
