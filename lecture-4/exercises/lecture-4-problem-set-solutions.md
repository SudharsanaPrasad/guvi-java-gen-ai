# Lecture 4 Solutions

## Arrays (1D)

1. First and last sum
```java
int[] a = {7, 4, 9, 2};
int s = a[0] + a[a.length - 1]; // 7 + 2 = 9
```

2. Replace sentinels
```java
int[] a = {3, -1, 5, -1, 8};
for (int i = 0; i < a.length; i++) {
    if (a[i] == -1) a[i] = 0;
}
// print result
for (int i = 0; i < a.length; i++) {
    if (i > 0) System.out.print(" ");
    System.out.print(a[i]);
}
System.out.println(); // 3 0 5 0 8
```

3. Count threshold
```java
int[] a = {4, 12, 9, 12, 5, 18};
int c = 0;
for (int i = 0; i < a.length; i++) {
    if (a[i] >= 10) c++;
}
// c = 3
```

4. First match index
```java
int[] a = {5, 8, 3, 8, 2};
int target = 8;
int idx = -1;
for (int i = 0; i < a.length; i++) {
    if (a[i] == target) { idx = i; break; }
}
// idx = 1
```

5. Reverse copy
```java
int[] a = {1, 2, 3, 4, 5};
int[] r = new int[a.length];
for (int i = 0; i < a.length; i++) {
    r[i] = a[a.length - 1 - i];
}
// r = {5, 4, 3, 2, 1}
```

6. Adjacent max product
```java
int[] a = {3, 6, -2, -5, 7};
int best = a[0] * a[1];
for (int i = 1; i < a.length - 1; i++) {
    int p = a[i] * a[i + 1];
    if (p > best) best = p;
}
// best = 18 from 3 * 6
```

7. Normalize negatives to zero
```java
int[] a = {-3, 0, 9, -8, 4};
int[] b = new int[a.length];
for (int i = 0; i < a.length; i++) {
    b[i] = (a[i] < 0) ? 0 : a[i];
}
// b = {0, 0, 9, 0, 4}
```

8. Prefix sum crossing
```java
int[] steps = {120, 250, 80, 90, 300};
int limit = 400;
int s = 0;
int i = -1;
for (int k = 0; k < steps.length; k++) {
    s += steps[k];
    if (s > limit) { i = k; break; }
}
// i = 2
```

9. Strictly increasing check
```java
int[] a = {2, 5, 7, 7, 9};
boolean inc = true;
int badAt = -1;
for (int k = 1; k < a.length; k++) {
    if (!(a[k] > a[k - 1])) { inc = false; badAt = k; break; }
}
// inc = false, badAt = 3
```

10. Rotate right by one in place
```java
int[] a = {10, 20, 30, 40};
int last = a[a.length - 1];
for (int k = a.length - 1; k > 0; k--) {
    a[k] = a[k - 1];
}
a[0] = last;
// a = {40, 10, 20, 30}
```


## 2D Arrays

1. Row-major print
```java
int[][] g = {
    {1, 2, 3},
    {4, 5, 6}
};
for (int r = 0; r < g.length; r++) {
    for (int c = 0; c < g[r].length; c++) {
        if (c > 0) System.out.print(" ");
        System.out.print(g[r][c]);
    }
    System.out.println();
}
```

2. Sum of all cells
```java
int total = 0;
for (int r = 0; r < g.length; r++) {
    for (int c = 0; c < g[r].length; c++) {
        total += g[r][c];
    }
}
// total = 21
```

3. Column count by row
```java
int[][] a = {
    {7, 1},
    {8, 9, 10},
    {}
};
for (int r = 0; r < a.length; r++) {
    if (r > 0) System.out.print(" ");
    System.out.print(a[r].length);
}
System.out.println(); // 2 3 0
```

4. First position of target
```java
int[][] a = {
    {5, 2, 5},
    {9, 7},
    {5}
};
int target = 7;
int row = -1, col = -1;
outer:
for (int r = 0; r < a.length; r++) {
    for (int c = 0; c < a[r].length; c++) {
        if (a[r][c] == target) { row = r; col = c; break outer; }
    }
}
// row = 1, col = 1
```

5. Row with largest sum
```java
int[][] a = {
    {2, 2, 9},
    {1, 1, 1, 1, 1},
    {3, 3}
};
int bestRow = 0;
int bestSum = Integer.MIN_VALUE;
for (int r = 0; r < a.length; r++) {
    int sum = 0;
    for (int c = 0; c < a[r].length; c++) sum += a[r][c];
    if (sum > bestSum) { bestSum = sum; bestRow = r; }
}
// bestRow = 0
```

6. Rectangular transpose
```java
int[][] m = {
    {1, 2, 3},
    {4, 5, 6}
};
int[][] t = new int[m[0].length][m.length];
for (int r = 0; r < m.length; r++) {
    for (int c = 0; c < m[r].length; c++) {
        t[c][r] = m[r][c];
    }
}
// t = { {1,4}, {2,5}, {3,6} }
```

7. Boundary sum
```java
int[][] b = {
    {8, 1, 2, 9},
    {3, 0, 0, 4},
    {7, 6, 5, 2}
};
int s = 0;
for (int r = 0; r < b.length; r++) {
    for (int c = 0; c < b[r].length; c++) {
        boolean boundary = (r == 0) || (r == b.length - 1) || (c == 0) || (c == b[r].length - 1);
        if (boundary) s += b[r][c];
    }
}
// s = 47
```

8. Count positives per row
```java
int[][] a = {
    {-1, 0, 2, 4},
    {5, -3},
    {}
};
for (int r = 0; r < a.length; r++) {
    int cnt = 0;
    for (int c = 0; c < a[r].length; c++) {
        if (a[r][c] > 0) cnt++;
    }
    if (r > 0) System.out.print(" ");
    System.out.print(cnt);
}
System.out.println(); // 2 1 0
```

9. Flatten jagged
```java
int[][] a = {
    {9, 8},
    {7, 6, 5},
    {}
};
int len = 0;
for (int r = 0; r < a.length; r++) len += a[r].length;
int[] flat = new int[len];
int p = 0;
for (int r = 0; r < a.length; r++) {
    for (int c = 0; c < a[r].length; c++) {
        flat[p++] = a[r][c];
    }
}
// flat = {9, 8, 7, 6, 5}
```

10. Find a local peak
```java
int[][] h = {
    {1, 3, 2},
    {4, 9, 5},
    {6, 7, 8}
};
int pr = -1, pc = -1;
for (int r = 0; r < h.length && pr == -1; r++) {
    for (int c = 0; c < h[r].length; c++) {
        int v = h[r][c];
        boolean up    = (r == 0) || v > h[r - 1][c];
        boolean down  = (r == h.length - 1) || v > h[r + 1][c];
        boolean left  = (c == 0) || v > h[r][c - 1];
        boolean right = (c == h[r].length - 1) || v > h[r][c + 1];
        if (up && down && left && right) { pr = r; pc = c; break; }
    }
}
// pr = 1, pc = 1
```


## Strings and Immutability

1. Basic queries
```java
String s = "atlas";
int n = s.length();           // 5
char c = s.charAt(2);         // 'l'
String t = s.substring(1, 4); // "tla"
```

2. Case-insensitive check
```java
String a = "Hello";
String b = "hello";
boolean same = a.equalsIgnoreCase(b); // true
```

3. First index of text
```java
String s = "abracadabra";
String p = "cad";
int pos = s.indexOf(p); // 4
```

4. Extract domain
```java
String email = "dev@example.org";
int at = email.indexOf('@');
String domain = (at >= 0) ? email.substring(at + 1) : "";
// "example.org"
```

5. Replace middle with stars
```java
String id = "A9Z4K7";
String masked;
if (id.length() <= 2) {
    masked = id;
} else {
    String stars = "";
    for (int i = 0; i < id.length() - 2; i++) stars += "*";
    masked = id.substring(0, 1) + stars + id.substring(id.length() - 1);
}
// "A****7"
```

6. Count vowels
```java
String s = "Laboratory";
int count = 0;
for (int i = 0; i < s.length(); i++) {
    char ch = s.charAt(i);
    if (ch >= 'A' && ch <= 'Z') ch = (char)(ch - 'A' + 'a');
    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') count++;
}
// count = 4
```

7. First digit position
```java
String s = "Room42B";
int pos = -1;
for (int i = 0; i < s.length(); i++) {
    char ch = s.charAt(i);
    if (ch >= '0' && ch <= '9') { pos = i; break; }
}
// pos = 4
```

8. Palindrome, ignore case
```java
String s = "Level";
boolean pal = true;
int i = 0, j = s.length() - 1;
while (i < j) {
    char a = s.charAt(i), b = s.charAt(j);
    // to lower (ASCII safe for letters used here)
    if (a >= 'A' && a <= 'Z') a = (char)(a - 'A' + 'a');
    if (b >= 'A' && b <= 'Z') b = (char)(b - 'A' + 'a');
    if (a != b) { pal = false; break; }
    i++; j--;
}
// pal = true
```

9. Trim outer pair
```java
String s = "[value]";
String inner;
if (s.length() >= 2 && s.charAt(0) == '[' && s.charAt(s.length() - 1) == ']') {
    inner = s.substring(1, s.length() - 1);
} else {
    inner = s;
}
// "value"
```

10. Find and cut
```java
String s = "key:value:extra";
String key = "key";
char sep = ':';
String value = "";
String prefix = key + sep;
if (s.startsWith(prefix)) {
    int first = s.indexOf(sep);
    int second = s.indexOf(sep, first + 1);
    if (second == -1) value = s.substring(first + 1);
    else value = s.substring(first + 1, second);
}
// "value"
```


## Wrapper Classes, Autoboxing, Unboxing

1. Box and unbox
```java
int a = 15;
Integer A = a;   // boxing
int b = A;       // unboxing
int sum = a + b; // 30
```

2. Integer equality
```java
Integer x1 = 128;
Integer x2 = 128;
boolean r1 = (x1 == x2);    // false
boolean r2 = x1.equals(x2); // true
```

3. Primitive to wrapper parameter
```java
static int twice(int v) { return v * 2; }
static int twiceBoxed(Integer v) { return v * 2; }

int a1 = twice(5);       // 10
int b1 = twiceBoxed(5);  // 10 (autobox to Integer)
```

4. Sum ignoring nulls
```java
Integer[] a = {3, null, 7, null, 2};
int s = 0;
for (int i = 0; i < a.length; i++) {
    if (a[i] != null) s += a[i];
}
// s = 12
```

5. Safe unbox
```java
Integer n = null;
int k = (n == null) ? 0 : n.intValue(); // 0
```

6. Compare boxed to primitive
```java
Integer A = 20;
int b = 20;
boolean same1 = (A == b);    // true
boolean same2 = A.equals(b); // true
```

7. Array of wrappers to primitives
```java
Integer[] a = {1, 2, 3, 4};
int[] b = new int[a.length];
for (int i = 0; i < a.length; i++) b[i] = a[i];
// b = {1, 2, 3, 4}
```

8. Min of wrappers
```java
Integer p = 12;
Integer q = 9;
int tmp = (p <= q) ? p : q;
Integer m = Integer.valueOf(tmp); // 9
```

9. Guarded multiply
```java
Integer x = null;
Integer y = 7;
Integer prod = (x != null && y != null) ? Integer.valueOf(x * y) : null; // null
```

10. Choose overload
```java
static String f(int v) { return "int"; }
static String f(Integer v) { return "Integer"; }

String r1 = f(5);                  // "int"
String r2 = f(Integer.valueOf(5)); // "Integer"
```
