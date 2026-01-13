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

5. Merge Two Sorted Lists

## Approach 1 (iterative)

- Goal: Create a LinkedList with the merged nodes. Then, how can we reconnect the links between nodes?
- Pointers! 
   - A brand new LinkedList that'll be returned, variable temp
   - Track the head and the tail of this LinkedList
      - Eg: head -> [1 -> 1] <-- tail
   - Pointers for both lists: list1, list2
- loop over the lists (uncertain when to stop - while-loop)
   - when do we stop? if list1 is null or list2 is null
   - Compare list1.value & list2.value. which one is smaller?
      - if list1 is smaller, pick from list1
      - if list2 is smaller, pick from list2
- post-loop: pick any remaining elements from list1 or list2
- return temp

## Approach 2 (recursive)
- Goal: recursive approach
- Consider if list1 == null
   -  assume: list2 is valid -> return list2
- Consider if list2 == null
   -  assume: list1
- Compare list1.value & list2.value. which one is smaller?
   - if list1 is smaller
      - recursion, move list1 to next node
      - return list1
   - if list2 is smaller
      - recursion, move list2 to next node
      - return list2

## Implementation 1 - iterative
list1 = 1 -> 2 -> 4
list2 = 1 -> 3 -> 4

tail.next = list1;
list1 = list1.next;
tail = tail.next;

-> -1 -> why?
   - without -1, we'd need to add the first node to linkedlist

- create temp as a new ListNode
   - using the paramterized constructor, set the first node's value to -1
- create tail, which will simply point to temp
- loop: list1 is NOT null AND list2 is NOT null
   - list1.val (1) < list2.val(1) -> false
      - else:
         - tail.next points to list2 (1 -> 3 -> 4)
         - move the head of list2 down a node
         - move the tail to the next node
   - list1.val (1) < list2.val(3) -> true
   - list1.val (2) < list2.val(3) -> true
tail.next = (list1 == null) ? list2 : list1;
ternary operator -> if-condition
if(list1 == null){
   tail.next = list2
}else
   tail.next = list1
}

if (map1[c1] != map2[c2]) {



6. Remove Duplicates from Sorted Array

## Approach 1 (in progress)
Core idea: when we compare any two numbers, how do we determine whether they're duplicates or not?
   - check whether they're not equals
Input: nums = [1,1,2]
   - a variable that'll track the result, counter variable
      - initial: 0
      - unique set of numbers
      - question: at what point do we add to this array?
   - iterate through array -> for, i=0 -> i < nums.length
      - at index 0
         - Compare index 0 and index 1
            - (1,1) equal to each other
               - index 0 < index 1
               - add 1 to the result array
            - (1,2) does not equal each other
               - add 2 to new array

## Approach 2 (Two Pointer Approach)
Input: nums = [1,1,2]
- validation:
   - if condition: nums.length == 0 -> return 0
- variable: k = 1 // position for the next unique element
   - why 1? the first element will be unique
- iterate through the array: for loop
   - i = 1; iterate till the last element; i++
      - if condition: current number is different from the previous ones
         - compare: nums[i] & nums[i-1]
         - we've a unique element!
         - move the unique element from kth position
         - increment k by 1 to move the pointer down
- return k


## Implementation

7. Remove Element
8. Search Insert Position
9. Binary Search
10. Squares of a Sorted Array