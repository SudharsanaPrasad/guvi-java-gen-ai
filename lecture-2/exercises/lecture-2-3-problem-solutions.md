# Lecture 2 & 3 Solutions

## A) Conditionals (if / else-if / else, short-circuit)

1. Store hours flag
```java
int hour = 14;
boolean isOpen;
if (hour >= 9 && hour <= 17) {
    isOpen = true;
} else {
    isOpen = false;
}
```

2. Water state by temperature
```java
int tempC = 105;
char state;
if (tempC <= 0) {
    state = 'S';
} else if (tempC <= 99) {
    state = 'L';
} else {
    state = 'G';
}
```

3. Safe processing guard
```java
static boolean ready = false;
static boolean withinLimit(int x) { return x <= 100; }
static void process() { /* provided */ }

int value = 120;
if (ready && withinLimit(value)) {
    process();
}
```

4. Exam grading ladder
```java
int score = 73;
char grade;
if (score >= 90 && score <= 100) {
    grade = 'A';
} else if (score >= 80) {
    grade = 'B';
} else if (score >= 70) {
    grade = 'C';
} else if (score >= 60) {
    grade = 'D';
} else {
    grade = 'F';
}
```

5. Candidate eligibility rule
```java
int years = 3;
boolean hasCert = false;
int portfolio = 4;
boolean eligible = (years >= 2) && (hasCert || portfolio >= 3);
```

6. Utility billing with slabs (cumulative)
```java
int units = 205;
int price;
if (units <= 50) {
    price = units * 12;
} else if (units <= 200) {
    price = 50 * 12 + (units - 50) * 10;
} else {
    price = 50 * 12 + 150 * 10 + (units - 200) * 8;
}
```

7. Speed label
```java
int speed = 88;
String label;
if (speed >= 0 && speed <= 39) {
    label = "slow";
} else if (speed <= 89) {
    label = "cruise";
} else if (speed <= 200) {
    label = "fast";
} else {
    label = "fast"; // outside stated ranges, keep last band
}
```

8. Division only when safe
```java
int a = 35;
int b = 0;
int ratio;
if (b != 0) {
    ratio = a / b;
} else {
    ratio = 0;
}
```

9. Fix overlapping ranges
```java
int x = 60;
String band;
if (x <= 60) {
    band = "low";
} else if (x <= 80) {
    band = "mid";
} else {
    band = "high";
}
// for x = 60, band = "low"
```

10. Access gate rule
```java
boolean hasID = true, adult = true, underLimit = false, paid = true, notBanned = true;
boolean canProceed = hasID && adult && notBanned && (paid || underLimit);
```


## B) switch (classic only)

1. Weekday short name
```java
int day = 3;
String shortName;
switch (day) {
    case 1: shortName = "Mon"; break;
    case 2: shortName = "Tue"; break;
    case 3: shortName = "Wed"; break;
    case 4: shortName = "Thu"; break;
    case 5: shortName = "Fri"; break;
    case 6: shortName = "Sat"; break;
    case 7: shortName = "Sun"; break;
    default: shortName = "Invalid";
}
```

2. Direction to code
```java
char dir = 'W';
int code;
switch (dir) {
    case 'N': code = 1; break;
    case 'S': code = -1; break;
    case 'E': code = 2; break;
    case 'W': code = -2; break;
    default: code = 0;
}
```

3. Quarter of year
```java
int month = 11;
int quarter;
switch (month) {
    case 1: case 2: case 3:  quarter = 1; break;
    case 4: case 5: case 6:  quarter = 2; break;
    case 7: case 8: case 9:  quarter = 3; break;
    case 10: case 11: case 12: quarter = 4; break;
    default: quarter = 0;
}
```

4. Odd or even using grouped cases
```java
int d = 7;
String parity;
switch (d) {
    case 1: case 3: case 5: case 7: case 9:
        parity = "odd"; break;
    case 2: case 4: case 6: case 8: case 10:
        parity = "even"; break;
    default:
        parity = "even";
}
```

5. HTTP status category
```java
int statusCode = 404;
int category;
switch (statusCode / 100) {
    case 1: category = 1; break;
    case 2: category = 2; break;
    case 3: category = 3; break;
    case 4: category = 4; break;
    case 5: category = 5; break;
    default: category = 0;
}
```

6. Workflow routing
```java
static void recover() { /* provided */ }
static void proceed(int bucket) { /* provided */ }

String status = "ARCHIVED";
int bucket;
switch (status) {
    case "NEW":         bucket = 1; break;
    case "IN_PROGRESS": bucket = 2; break;
    case "DONE":        bucket = 3; break;
    case "CANCELLED":   bucket = 4; break;
    default:            bucket = 0;
}

if (bucket == 0) {
    recover();
} else {
    proceed(bucket);
}
```


## C) Loops (for / while / do-while, break/continue, off-by-one)

1. Count to fifteen
```java
for (int i = 1; i <= 15; i++) {
    System.out.print(i);
    if (i < 15) System.out.print(" ");
}
System.out.println();
```

2. Countdown fixed range
```java
for (int i = 9; i >= 0; i--) {
    System.out.print(i);
    if (i > 0) System.out.print(" ");
}
System.out.println();
```

3. Tens inclusive
```java
for (int i = 0; i <= 100; i += 10) {
    System.out.print(i);
    if (i < 100) System.out.print(" ");
}
System.out.println();
```

4. Skip with continue
```java
boolean first = true;
for (int i = 1; i <= 60; i++) {
    if (i % 4 == 0 || i % 6 == 0) continue;
    if (!first) System.out.print(" ");
    System.out.print(i);
    first = false;
}
System.out.println();
```

5. First square above threshold
```java
int k = 1;
while (true) {
    if (k * k > 1000) {
        System.out.println(k);
        break;
    }
    k++;
}
```

6. Frame pattern
```java
int rows = 4, cols = 6;
for (int r = 0; r < rows; r++) {
    for (int c = 0; c < cols; c++) {
        boolean border = (r == 0) || (r == rows - 1) || (c == 0) || (c == cols - 1);
        if (border) System.out.print("#");
        else System.out.print(".");
    }
    System.out.println();
}
```


## D) Functions (method basics, signature, params, overloading)

1. max
```java
static int max(int a, int b) {
    return (a >= b) ? a : b;
}
```

2. Method headers: access, static, return type, name, parameters
```java
public static int sumPublic(int a, int b);
private static boolean checkNonNegative(int x);
```

3. withinInclusive and sample calls
```java
static boolean withinInclusive(int x, int lo, int hi) {
    return lo <= x && x <= hi;
}

// sample calls in main
boolean r1 = withinInclusive(10, 10, 20);
boolean r2 = withinInclusive(20, 10, 20);
boolean r3 = withinInclusive(9, 10, 20);
```

4. Percentage scaling with overloads
```java
static int scale(int x, int pct) {
    // integer arithmetic, truncates toward zero
    return (x * pct) / 100;
}

static double scale(double x, int pct) {
    return x * (pct / 100.0);
}

// sample calls in main
int scaledA = scale(160, 75);     // 120
double scaledB = scale(2.0, 125); // 2.5
```

5. Clamp to non-negative
```java
static int clampToNonNegative(int v) {
    return (v >= 0) ? v : 0;
}

// sample call in main
int c1 = clampToNonNegative(-12); // 0
```

6. Overload resolution calls
```java
static void f(long v)    { /* provided */ }
static void f(Integer v) { /* provided */ }

// sample calls in main
f(5);
f(Integer.valueOf(5));
```
