## How we’ll tackle LeetCode problems today

* **1–2 min:** read the problem
* **Chosen pair:** explain the problem in their own words
* **3–5 min:** think quietly (if needed)
* **Share approach:** high level
* **5–10 min:** implement
* **Share implementations**
* **Move to the next one**

## Status signals

* **RED:** I’m lost
* **YELLOW:** I have an idea
* **GREEN:** I’m all good

## LeetCode Problems

### 1) Valid Anagram

#### Approach 1: Sort + Compare

If two strings are anagrams, they contain the same characters with the same frequency.
Convert both strings to `char[]`, sort them, then compare element-by-element.

**Steps**

1. If lengths differ -> return `false`
2. `char[] a = s.toCharArray()`, `char[] b = t.toCharArray()`
3. Sort both arrays
4. Loop through arrays and compare each index
5. If all match -> return `true`

**Example**

* `s = "anagram"`, `t = "nagaram"`
* After sorting:

  * `s -> a a a g m n r`
  * `t -> a a a g m n r`
* Same -> `true`

### 2) Ransom Note

#### Problem (quick examples)

* `ransomNote = "a"`, `magazine = "b"` -> `false`
* `ransomNote = "aa"`, `magazine = "ab"` -> `false` (need 2 a’s)
* `ransomNote = "aa"`, `magazine = "aab"` -> `true`

#### Approach: Frequency array (26 letters)

Same idea as anagram/frequency counting.

**Steps**

1. Create `int[] count = new int[26]` (all zeros)
2. Count all characters in `magazine`:

   * `count[c - 'a']++`
3. Try building `ransomNote`:

   * for each char `c` in `ransomNote`:

     * if `count[c - 'a'] == 0` -> not available -> return `false`
     * else `count[c - 'a']--`
4. If we finish -> return `true`

**Mental model**
Coins in your pocket (`magazine`) and a bill to pay (`ransomNote`). Each time you use a coin, the count decreases.

### 3) First Unique Character in a String

#### Examples

* `s = "loveleetcode"`

  * `l` repeats, `o` repeats, `v` is unique -> index `2`
  * Output: `2`
* `s = "aabb"` -> no unique char -> `-1`

#### Approach 1: 2-pass frequency array

We don’t need nested loops.

**Steps**

1. Build frequency counts:

   * `int[] freq = new int[26]`
   * loop over string -> `freq[c - 'a']++`
2. Find the first index where freq is 1:

   * loop again over string by index `i`
   * if `freq[s.charAt(i) - 'a'] == 1` -> return `i`
3. Else return `-1`

#### Approach 2: LinkedHashMap

* Use `LinkedHashMap<Character, Integer>` to count while preserving insertion order
* Then scan entries to find the first with value `1`
* Return `s.indexOf(char)`

### 4) Isomorphic Strings

#### Examples

* `s = "egg"`, `t = "add"` -> `true`

  * `e <-> a`, `g <-> d`
* `s = "foo"`, `t = "bar"` -> `false`

  * `o` would need to map to both `a` and `r` -> not allowed
* `s = "paper"`, `t = "title"` -> `true`

#### Approach (discussed): Two HashMaps to enforce “both directions”

We need a one-to-one mapping:

* One char in `s` maps to exactly one char in `t`
* One char in `t` maps to exactly one char in `s`

So we use:

* `sT`: map from `s` char -> `t` char
* `tS`: map from `t` char -> `s` char

**Steps**

1. Loop `i` from `0` to `n - 1`
2. `c1 = s.charAt(i)`, `c2 = t.charAt(i)`
3. If `c1` already mapped in `sT`:

   * if `sT.get(c1) != c2` -> return `false`
   * else ok
4. Else map it: `sT.put(c1, c2)`
5. Do the same check in reverse for `tS`:

   * if `tS` already has `c2` but maps to a different `c1` -> `false`
   * else `tS.put(c2, c1)`
6. End -> return `true`

**How the “connection” is made (example)**
`s = "egg"`, `t = "add"`

* `i = 0`: `e -> a` and `a -> e`
* `i = 1`: `g -> d` and `d -> g`
* `i = 2`: `g -> d` check passes (consistent)

So it’s valid.

## Not covered yet (untouched)

5. Merge Two Sorted Lists
6. Remove Duplicates from Sorted Array
7. Remove Element
8. Search Insert Position
9. Binary Search
10. Squares of a Sorted Array