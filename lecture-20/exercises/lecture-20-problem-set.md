## Backtracking Problem Set

### Problem 1 (Easy): Generate Binary Strings of Length N
Write a recursive function to generate all binary strings of length n. Each position can be either 0 or 1.

Example:
Input: n = 3
Output:
000
001
010
011
100
101
110
111

### Problem 2 (Medium): Unique Paths with Obstacles
You are given a 2D grid where 0 represents an open cell and 1 represents an obstacle.
Find all possible paths from the top-left corner (0, 0) to the bottom-right (m-1, n-1) moving only down or right, avoiding obstacles.

Example:
Input:
[ [0, 0, 0],
  [0, 1, 0],
  [0, 0, 0] ]

Output Paths (as list of coordinates):
[
  [(0,0),(0,1),(0,2),(1,2),(2,2)],
  [(0,0),(1,0),(2,0),(2,1),(2,2)]
]

### Problem 3 (Medium): Letter Case Permutation
Given a string s containing letters and digits, return all possible strings by toggling the case of each alphabetic character.

Example:
Input: "a1b2"
Output: ["a1b2", "A1b2", "a1B2", "A1B2"]