## Problem Set

### Recursion

#### Problem 1 (Easy): Sum of Digits
Write a recursive method that returns the sum of digits of a given number.

Example:
Input: n = 532
Output: 10
(Explanation: 5 + 3 + 2 = 10)

Hint: Divide the number by 10 to peel off digits recursively.


#### Problem 2: Count Ways to Reach the End
A frog is trying to jump across n steps.
It can jump either 1 or 2 steps at a time.
Write a recursive function to count the total number of distinct ways the frog can reach the last step.

Example:
Input: n = 4
Output: 5
(Explanation: [1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2])

Hint: Think in terms of smaller subproblems — ways(n) = ways(n−1) + ways(n−2).


#### Problem 3: Print All Subsequences of a String
Given a string, print all possible subsequences (not substrings).
Use recursion to decide whether to include or exclude each character.

Example:
Input: "abc"
Output: ["", "a", "b", "c", "ab", "ac", "bc", "abc"]

Hint: At each step, choose to include or skip the current character.


### Memoization

#### Problem 1 (Easy): Count Ways to Climb Steps (Memoized)
Convert the previous “Frog Jump” problem into a memoized solution.
Store already-computed results for each n to avoid recomputation.

Example:
Input: n = 10
Output: 89

Hint: Use an integer array or HashMap to cache previously computed results.


#### Problem 2: Minimum Cost Path
Given a grid of non-negative numbers, find the minimum cost to reach the bottom-right corner from the top-left corner.
You may only move right or down at each step.

Example:
[ [1, 3, 1],
  [1, 5, 1],
  [4, 2, 1] ]
Output: 7
(Explanation: 1 → 3 → 1 → 1 → 1)

Hint:
- [Recurrence](https://opendsa-server.cs.vt.edu/ODSA/Books/Everything/html/RecurrenceIntro.html): cost(i,j) = grid[i][j] + min(cost(i+1,j), cost(i,j+1))
- Use memoization to avoid recomputing overlapping cells.


#### Problem 3: Longest Common Subsequence (LCS)
Given two strings, find the length of their longest common subsequence using recursion with memoization.

Example:
Input: s1 = "abcde", s2 = "ace"
Output: 3
(Explanation: The LCS is "ace".)

Hint:
- If characters match: 1 + LCS(i−1, j−1)
- Else: max(LCS(i−1, j), LCS(i, j−1))
