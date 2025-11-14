# Lecture 18 Problem Set: Solutions

## Fixed-Size Sliding Window Problems

### Problem 1: Rolling Even Count
```java
/**
 * Counts how many windows of size k contain exactly two even numbers.
 *
 * Approach:
 * 1. Initialize a counter for the number of even numbers in the first window.
 * 2. As the window slides, subtract the element that leaves and add the one that enters.
 * 3. Each time the count of evens equals 2, increment the result.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public static int countWindowsWithTwoEvens(int[] nums, int k) {
    if (nums == null || nums.length < k) return 0;

    int evenCount = 0;
    int result = 0;

    for (int i = 0; i < k; i++) {
        if (nums[i] % 2 == 0) evenCount++;
    }
    if (evenCount == 2) result++;

    for (int i = k; i < nums.length; i++) {
        if (nums[i - k] % 2 == 0) evenCount--;
        if (nums[i] % 2 == 0) evenCount++;
        if (evenCount == 2) result++;
    }

    return result;
}
```

---

### Problem 2: Rolling Average Alert
```java
/**
 * Returns all starting indices of windows whose average exceeds the threshold t.
 *
 * Approach:
 * 1. Maintain a running sum of the current window.
 * 2. For each window, calculate the average and check if it's above t.
 * 3. Add valid window start indices to a result list.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) ignoring result list
 */
public static List<Integer> rollingAverageAlert(int[] nums, int k, double t) {
    List<Integer> indices = new ArrayList<>();
    if (nums == null || nums.length < k) return indices;

    double sum = 0;

    // First window
    for (int i = 0; i < k; i++) {
        sum += nums[i];
    }
    if (sum / k > t) indices.add(0);

    // Slide window
    for (int i = k; i < nums.length; i++) {
        sum += nums[i] - nums[i - k];
        if (sum / k > t) indices.add(i - k + 1);
    }

    return indices;
}
```

---

### Problem 3: Max-Min Difference
```java
/**
 * Finds the maximum difference (max - min) across all windows of size k.
 *
 * Approach:
 * 1. For each window, track max and min elements.
 * 2. Optionally optimize using deques (for now use O(k) per window for simplicity).
 * 3. Keep updating the global maximum difference.
 *
 * Time Complexity: O(n * k)
 * Space Complexity: O(1)
 */
public static int maxDifferenceInWindows(int[] nums, int k) {
    if (nums == null || nums.length < k) return 0;

    int maxDiff = Integer.MIN_VALUE;

    for (int i = 0; i <= nums.length - k; i++) {
        int maxVal = nums[i];
        int minVal = nums[i];

        for (int j = i; j < i + k; j++) {
            maxVal = Math.max(maxVal, nums[j]);
            minVal = Math.min(minVal, nums[j]);
        }

        maxDiff = Math.max(maxDiff, maxVal - minVal);
    }

    return maxDiff;
}
```

---

## Variable-Size Sliding Window Problems

### Problem 4: Shortest Subarray with Sum ≥ Target
```java
/**
 * Finds the length of the smallest contiguous subarray whose sum is at least target.
 *
 * Approach:
 * 1. Expand the window to reach or exceed target.
 * 2. Once reached, shrink from the left while keeping the sum ≥ target.
 * 3. Track the minimum window length found.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public static int minSubArrayLen(int target, int[] nums) {
    int left = 0, sum = 0, minLen = Integer.MAX_VALUE;

    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];

        while (sum >= target) {
            minLen = Math.min(minLen, right - left + 1);
            sum -= nums[left];
            left++;
        }
    }

    return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
}
```

---

### Problem 5: Longest Subarray with Sum ≤ Limit
```java
/**
 * Finds the length of the longest subarray whose sum is less than or equal to a given limit.
 *
 * Approach:
 * 1. Expand window by adding nums[right].
 * 2. If sum exceeds limit, shrink window from left until within limit.
 * 3. Keep track of the longest valid window seen.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public static int longestSubarrayUnderLimit(int[] nums, int limit) {
    int left = 0, sum = 0, maxLen = 0;

    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];

        while (sum > limit && left <= right) {
            sum -= nums[left];
            left++;
        }

        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
```

---

### Problem 6: Longest Substring with At Most Two Distinct Characters
```java
/**
 * Returns the length of the longest substring that contains at most two distinct characters.
 *
 * Approach:
 * 1. Use a HashMap to track character counts in the current window.
 * 2. Expand window by adding characters and shrink from left if >2 distinct chars appear.
 * 3. Update the maximum length each time the window is valid.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) or O(Alphabet size)
 */
public static int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s == null || s.isEmpty()) return 0;

    Map<Character, Integer> freq = new HashMap<>();
    int left = 0, maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        freq.put(c, freq.getOrDefault(c, 0) + 1);

        while (freq.size() > 2) {
            char leftChar = s.charAt(left);
            freq.put(leftChar, freq.get(leftChar) - 1);
            if (freq.get(leftChar) == 0) freq.remove(leftChar);
            left++;
        }

        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
```

---
