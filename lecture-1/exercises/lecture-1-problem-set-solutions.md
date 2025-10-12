# Solutions — Lecture 1 Problem Set (Sections 4–6)

## Variables, Primitive Types, Literals

1. Literal legality  
(a) invalid; leading zero makes it octal and 9 is not an octal digit; use 9  
(b) valid; type int (value 1000)  
(c) valid; type float  
(d) valid; type double  
(e) invalid; underscore cannot be last; use 1  
(f) valid; type int (binary 1010 = 10)  
(g) valid; type int (hex FF = 255)  
(h) valid; type double (1000.0)

2. Smallest safe type  
(a) byte or short depending on building; safe generic choice: byte (−128..127) if the building has at most 127 floors; otherwise short  
(b) int (86,400 fits in int; short max 32,767 is too small)  
(c) int (fits typical mid-sized city populations; long unnecessary)  
(d) int for code points, or char for BMP only; safest general choice: int

3. Suffix requirements  
(a) fails: int literal overflow; fix: long big = 3_000_000_000L;  
(b) fails: 2.5 is a double; fix: float radius = 2.5f;  
(c) compiles: int 5 converts to double

4. Underscore readability  
(a) 10_000_000 (thousands)  
(b) 0b1111_0000_1111_0000 (nibbles)  
(c) 0xFF00_ABCD (bytes/words)  
(d) 1_234_567_890 (thousands)

5. Type with headroom  
3 days = 3 * 24 * 60 * 60 * 1000 = 259_200_000 ms.  
int millisSinceStart; is safe because 259_200_000 is less than Integer.MAX_VALUE.

6. Boolean assignments  
(a) illegal; fix: boolean b1 = true; or boolean b1 = (1 == 1);  
(b) legal  
(c) legal  
(d) illegal; fix: boolean b4 = false; or boolean b4 = (0 == 0);

7. Char storage limits  
(a) char a = 'A'; compiles (BMP U+0041)  
(b) char omega = 'Ω'; compiles (BMP U+03A9)  
(c) char smile = '😊'; does not compile as a single char (U+1F60A is outside BMP; needs surrogate pair or a String/int code point)

8. Scaled integers for measurement  
(a) int priceMinor; — smallest currency unit avoids rounding errors  
(b) int heightMm; — millimeters keep integer arithmetic exact  
(c) int tempTenths; — tenths store one decimal place without floating error

9. Data footprint choices  
(a) short trips; — 0..500 fits within short (max 32,767)  
(b) int totalMinor; — up to 100,000,000 fits in int  
(c) char stationCategory; — single letter fits in char

10. Literal edge audit  
(a) compiles but 012 is octal (value 10); safer: long l = 12L if decimal 12 is intended  
(b) does not compile (adjacent underscores); fix: int id = 1_2_3; or int id = 123;  
(c) does not compile (underscore near dot); fix: double d = 1.0;  
(d) compiles but sets sign bit (−2,147,483,648); if positive is intended, use long k = 1L << 31;

---

## Expressions, Precedence, Casting, Integer Division

1. Precedence quick check  
(a) 25 (multiplication before addition)  
(b) 2 (integer division truncates)  
(c) 2.5 (double division)  
(d) 68 ('A' is 65; int + char gives int)  
(e) 35 (parentheses force addition first)

2. Integer vs floating division  
(a) 3 (integer division truncates)  
(b) 3.5 (left operand promoted to double)

3. Single-cast fix  
```java
int x = 1;
double y = x / 2.0;
```

4. Minutes to hours and remainder  
```java
int hours = totalMinutes / 60;
int minutesLeft = totalMinutes % 60;
```

5. Floor and nearest average  
```java
int sum = a + b + c;
int floorAvg = sum / 3;           // floor division
int nearestAvg = (sum + 1) / 3;   // correct for non-negative sums: r=0,1 -> q; r=2 -> q+1
```

6. Avoid overflow in (a*b)/c  
Cast early:  
```java
int result = (int) (((long) a * (long) b) / c);
```
Reorder when divisible (e.g., a % c == 0):  
```java
int result2 = (a / c) * b;   // or if b % c == 0: a * (b / c)
```

7. Unit conversion chain  
```java
int meters = centimeters / 100;
int cmRemainder = centimeters % 100;

int kilometers = meters / 1000;
int metersRemainder = meters % 1000;
```

8. Percentage fee in minor units  
```java
int feeCents = (priceCents * feePercent) / 100;
int totalCents = priceCents + feeCents;
```

9. Target values with parentheses  
- a * (b + c) gives 4 * (3 + 2) = 20 (parentheses)  
- (double) (a + b) / 2 gives (4 + 3) / 2 = 3.5 (casting for floating division)  
- a / (b - 1) gives 4 / (3 - 1) = 2 (parentheses and integer division)

10. Overflow forensics  
Stored value: -1_794_967_296 (overflow wraps modulo 2^32)  
Minimal fix:  
```java
long area = (long) n * (long) m;
```
Explanation: n * m is computed in 32-bit int, exceeding Integer.MAX_VALUE; Java int arithmetic wraps modulo 2^32, producing a negative value.

---

## Console Output (print/println/escapes)

1. Exact two-line output  
Two statements:
```java
System.out.println("Hello,");
System.out.println("World!");
```
Three statements:
```java
System.out.print("Hello,");
System.out.println();
System.out.println("World!");
```

2. Quoted text  
```java
System.out.println("He said, "public static void main".");
```

3. Trace the final layout  
Output:
```
Line1
Line 2
End
```

4. Escape review  
(a) prints a tab then Start  
```
	Start
```
(b) prints  
```
C:	empile
```
(c) prints a newline then Next  
```

Next
```
(d) prints  
```
Quote: "X"
```

5. Minimal calls, fixed output  
```java
System.out.print("Report
	Version: 1

Status: OK");
```
