# Lecture 4 Problem Set

Problems

## Arrays (1D)

1. First and last sum<br>
Given int[] a = {7, 4, 9, 2}; set int s to a[0] + a[a.length - 1].

2. Replace sentinels<br>
Given int[] a = {3, -1, 5, -1, 8}; replace every -1 with 0. Print the final array on one line as:
3 0 5 0 8

3. Count threshold<br>
Given int[] a = {4, 12, 9, 12, 5, 18}; count how many values are at least 10. Store the count in int c.

4. First match index<br>
Given int[] a = {5, 8, 3, 8, 2}; and int target = 8; set int idx to the first index where target appears, or -1 if not present.

5. Reverse copy<br>
Given int[] a = {1, 2, 3, 4, 5}; create a new array int[] r that contains the elements of a in reverse order. Do not modify a.

6. Adjacent max product<br>
Given int[] a = {3, 6, -2, -5, 7}; compute the maximum product of two adjacent elements and store it in int best.

7. Normalize negatives to zero<br>
Given int[] a = {-3, 0, 9, -8, 4}; create a new array int[] b where each negative value is replaced with 0 and all others are unchanged.

8. Prefix sum crossing<br>
Given int[] steps = {120, 250, 80, 90, 300}; and int limit = 400; find the smallest index i where steps[0] + ... + steps[i] is strictly greater than limit. If never, set i = -1.

9. Strictly increasing check<br>
Given int[] a = {2, 5, 7, 7, 9}; set boolean inc to true only if the array is strictly increasing. If not strictly increasing, set int badAt to the first index where the rule fails; otherwise set badAt = -1.

10. Rotate right by one in place<br>
Given int[] a = {10, 20, 30, 40}; rotate the array to the right by one position in place so it becomes {40, 10, 20, 30}. Use only a small, fixed number of extra variables.

---

## 2D Arrays

1. Row-major print<br>
Given<br>
int[][] g = {
  {1, 2, 3},
  {4, 5, 6}
};<br>
print exactly:<br>
1 2 3
4 5 6

2. Sum of all cells<br>
Using the same g above, compute the sum of all elements into int total.

3. Column count by row<br>
Given<br>
int[][] a = {
  {7, 1},
  {8, 9, 10},
  {}
};<br>
print one line showing the length of each row:<br>
2 3 0

4. First position of target<br>
Given<br>
int[][] a = {
  {5, 2, 5},
  {9, 7},
  {5}
};<br>
and int target = 7;<br>
find the first position and store it in int row and int col, or set both to -1 if not found.

5. Row with largest sum<br>
Given<br>
int[][] a = {
  {2, 2, 9},
  {1, 1, 1, 1, 1},
  {3, 3}
};<br>
find the index of the row with the largest sum. If there is a tie, choose the first such row.

6. Rectangular transpose<br>
Given<br>
int[][] m = {
  {1, 2, 3},
  {4, 5, 6}
};<br>
build a new matrix int[][] t that is the transpose of m:<br>
1 4
2 5
3 6

7. Boundary sum<br>
Given<br>
int[][] b = {
  {8, 1, 2, 9},
  {3, 0, 0, 4},
  {7, 6, 5, 2}
};<br>
sum only the boundary cells (top row, bottom row, leftmost column, rightmost column). Do not double count corners. Store the result in int s.

8. Count positives per row<br>
Given<br>
int[][] a = {
  {-1, 0, 2, 4},
  {5, -3},
  {}
};<br>
print one line with the count of positive numbers for each row:<br>
2 1 0

9. Flatten jagged<br>
Given<br>
int[][] a = {
  {9, 8},
  {7, 6, 5},
  {}
};<br>
create a new int[] flat that contains all elements of a in row-major order:<br>
9 8 7 6 5

10. Find a local peak<br>
Given<br>
int[][] h = {
  {1, 3, 2},
  {4, 9, 5},
  {6, 7, 8}
};<br>
find the first cell in row-major order whose value is strictly greater than each of its existing neighbors up, down, left, and right. Store its row and col, or -1, -1 if none.

---

## Strings and Immutability

1. Basic queries<br>
Given String s = "atlas"; set int n = s.length(); char c = s.charAt(2); and String t = s.substring(1, 4).

2. Case-insensitive check<br>
Given String a = "Hello"; and String b = "hello"; set boolean same to true only if a.equalsIgnoreCase(b) is true.

3. First index of text<br>
Given String s = "abracadabra"; and String p = "cad"; set int pos to the first index of p inside s, or -1 if not found.

4. Extract domain<br>
Given String email = "dev@example.org"; extract the domain "example.org" using indexOf and substring. Store it in String domain.

5. Replace middle with stars<br>
Given String id = "A9Z4K7"; build String masked that shows the first and last characters and replaces all middle characters with *, resulting in A****7. Use substring and simple concatenation.

6. Count vowels<br>
Given String s = "Laboratory"; count the number of vowels a, e, i, o, u (case-insensitive). Store the count in int count.

7. First digit position<br>
Given String s = "Room42B"; set int pos to the index of the first digit character in s, or -1 if there is none. Use charAt and range checks.

8. Palindrome, ignore case<br>
Given String s = "Level"; set boolean pal to true if s reads the same forward and backward ignoring case. Do not use libraries beyond the basic String API.

9. Trim outer pair<br>
Given String s = "[value]"; if the string starts with [ and ends with ] and has length at least 2, set String inner to the content without the brackets; otherwise set inner = s. Use only length, charAt, and substring.

10. Find and cut<br>
Given String s = "key:value:extra"; String key = "key"; and char sep = ':'; if s starts with key + sep, set String value to the text between the first and second separator (value). If there is no second separator, set value to the text after the first separator. Use indexOf and substring.

---

## Wrapper Classes, Autoboxing, Unboxing

1. Box and unbox<br>
Given int a = 15; create Integer A from a, then create int b from A. Set int sum = a + b.

2. Integer equality<br>
Given Integer x1 = 128; and Integer x2 = 128; set boolean r1 = (x1 == x2); and boolean r2 = x1.equals(x2).

3. Primitive to wrapper parameter<br>
Given these methods:
static int twice(int v) { return v * 2; }
static int twiceBoxed(Integer v) { return v * 2; }
Call both with 5 and store the results in int a and int b.

4. Sum ignoring nulls<br>
Given Integer[] a = {3, null, 7, null, 2}; compute int s as the sum of all non-null elements.

5. Safe unbox<br>
Given Integer n = null; set int k to 0 if n is null, otherwise set k to the unboxed value of n. Do not let the code throw an exception.

6. Compare boxed to primitive<br>
Given Integer A = 20; and int b = 20; set boolean same1 = (A == b); and boolean same2 = A.equals(b).

7. Array of wrappers to primitives<br>
Given Integer[] a = {1, 2, 3, 4}; build int[] b with the same values using unboxing.

8. Min of wrappers<br>
Given Integer p = 12; and Integer q = 9; set Integer m to the smaller value using only comparisons on unboxed values and then boxing the result again.

9. Guarded multiply<br>
Given Integer x = null; and Integer y = 7; set Integer prod to x * y when both are non-null; otherwise set prod = null. Avoid unboxing a null.

10. Choose overload<br>
Given these methods:<br>
```java
  static String f(int v) { return "int"; }
  static String f(Integer v) { return "Integer"; }
```
Call String r1 = f(5); and String r2 = f(Integer.valueOf(5));
