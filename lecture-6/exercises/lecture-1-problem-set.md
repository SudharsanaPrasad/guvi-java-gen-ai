# Lecture 1 Problem Set

Problems

## Variables, Primitive Types, Literals

1. Literal legality  
Decide for each literal whether Java accepts it as written. If accepted, state its primitive type; if not, give one reason and a corrected form.  
(a) 09  
(b) 1_00_0  
(c) 3.14f  
(d) 3.14d  
(e) 1_  
(f) 0b1010  
(g) 0xFF  
(h) 1e3

2. Smallest safe type  
Choose the smallest primitive that safely fits each quantity and briefly justify your choice.  
(a) number of floors in a building  
(b) seconds in one day  
(c) population of a mid-sized city  
(d) a single Unicode code point

3. Suffix requirements  
Identify which lines fail to compile and rewrite only what is necessary.  
(a) long big = 3_000_000_000;  
(b) float radius = 2.5;  
(c) double exact = 5;

4. Underscore readability  
Rewrite these numeric literals with underscores for readability and state the grouping logic you chose.  
(a) 10000000  
(b) 0b1111000011110000  
(c) 0xFF00ABCD  
(d) 1234567890

5. Type with headroom  
Pick a primitive for "milliseconds since app start" that must work up to 3 days; declare the variable and show with a quick bound check that overflow cannot occur within that window.

6. Boolean assignments  
Classify each assignment as legal or illegal; for illegal ones, rewrite the right-hand side so it compiles.  
(a) boolean b1 = 1;  
(b) boolean b2 = true;  
(c) boolean b3 = (5 > 3);  
(d) boolean b4 = 0 == false;

7. Char storage limits  
Declare three char variables intended to store: (a) 'A', (b) 'Ω', (c) '😊'. Mark which declarations compile and add a one-sentence note explaining why or why not (BMP vs surrogate pairs).

8. Scaled integers for measurement  
Declare variables (no computation) using integers to store:  
(a) price in the smallest currency unit  
(b) height in millimeters  
(c) temperature in tenths of a degree  
Add a brief comment for each on why scaling with integers can be preferable to floating point.

9. Data footprint choices  
Choose primitive types for a prototype:  
(a) trips per user per day in [0, 500]  
(b) total amount collected per day up to 100,000,000 smallest currency units  
(c) station category encoded as a single letter  
Provide a one-line bound check for each choice showing it is safe.

10. Literal edge audit  
Review and propose safer replacements where needed; explain each risk in one sentence.  
(a) long l = 012;  
(b) int id = 1_2__3;  
(c) double d = 1_.0;  
(d) int k = 1 << 31;

---

## Expressions, Precedence, Casting, Integer Division

1. Precedence quick check  
Given int a = 5;, compute each value and name the rule that explains it.  
(a) 5 + 2 * 10  
(b) 10 / 4  
(c) 10 / 4.0  
(d) 3 + 'A'  
(e) 7 * (2 + 3)

2. Integer vs floating division  
With int x = 7;, determine the results of:  
(a) x / 2  
(b) (double) x / 2  
Add a one-line note on numeric promotion.

3. Single-cast fix  
Change exactly one token so this yields 0.5.
```java
int x = 1;
double y = x / 2;
```

4. Minutes to hours and remainder  
Given int totalMinutes = 135;, write assignments that compute:  
(a) int hours using integer division  
(b) int minutesLeft using integer remainder

5. Floor and nearest average  
Given three int scores, compute:  
(a) the floor average using integer arithmetic only  
(b) the average rounded to the nearest integer using an integer-only technique

6. Avoid overflow in (a*b)/c  
Assume int a, b, c with c != 0, and a*b might overflow. Provide two safe implementations:  
(a) by casting at the correct time  
(b) by algebraic reordering when exact divisibility is guaranteed

7. Unit conversion chain  
Given int centimeters, compute using integer arithmetic only:  
(a) whole meters and remaining centimeters  
(b) whole kilometers and remaining meters and centimeters

8. Percentage fee in minor units  
Given int priceCents and int feePercent, compute:  
(a) int feeCents  
(b) int totalCents  
Use integer math only; store results in variables.

9. Target values with parentheses  
Let int a = 4, b = 3, c = 2;. Form three different expressions using these variables, standard operators, parentheses, and at most one cast to double, to produce exactly:  
(a) 20  
(b) 3.5  
(c) 2  
Add a short note on the rule each example demonstrates.

10. Overflow forensics
```java
int n = 50_000;
int m = 50_000;
int area = n * m;
```
(a) Predict the value stored in area.  
(b) Rewrite the minimal amount of code so area stores the exact mathematical product.  
(c) Explain the overflow in one or two sentences, referencing Java rules.

---

## Console Output (print/println/escapes)

1. Exact two-line output  
Produce exactly:
```
Hello,
World!
```
First using exactly two statements, then using exactly three statements. Use only print/println and string literals.

2. Quoted text  
Print the following using a single string literal with correct escaping:  
He said, "public static void main".

3. Trace the final layout  
Write the exact final output produced by this sequence, marking newlines precisely.
```java
System.out.print("Line");
System.out.print("1");
System.out.println();
System.out.println("Line 2");
System.out.print("End");
```

4. Escape review  
Write the exact text each of these prints (show the resulting lines).  
(a) "\tStart"  
(b) "C:\\temp\\file"  
(c) "\nNext"  
(d) "Quote: \"X\""

5. Minimal calls, fixed output  
Reproduce the following exactly (including the blank line and the tab) using the fewest print/println calls. Use only string literals and escape sequences.
```
Report
	Version: 1

Status: OK
```
