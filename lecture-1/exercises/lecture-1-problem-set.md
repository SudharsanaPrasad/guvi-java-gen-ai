# Lecture 1 Problem Set

Problems

## Variables, Primitive Types, Literals

1. Literal legality  
Decide for each literal whether Java accepts it as written. If accepted, state its primitive type; if not, give one reason and a corrected form.  
(a) 09  - not accepted (0 is for octal and 0-7 are the valid digits)
(b) 1_00_0  - accepted int
(c) 3.14f  - accepted float
(d) 3.14d  - accepted double
(e) 1_  - not accpeted (_ should be within the digits)
(f) 0b1010  - accepted binary
(g) 0xFF  - accepted int (Hexadecimal)
(h) 1e3 - accepted double (Exponential)

2. Smallest safe type  
Choose the smallest primitive that safely fits each quantity and briefly justify your choice.  
(a) number of floors in a building  short (Burj Khalifa has 163 floors)
(b) seconds in one day  int (86400 seconds in a day)
(c) population of a mid-sized city  int (avg mid size city population 200,000 to 500,000)
(d) a single Unicode code point char

3. Suffix requirements  
Identify which lines fail to compile and rewrite only what is necessary.  
(a) long big = 3_000_000_000L; int to long -add L at the end
(b) float radius = 2.5f; double to float -add f at the end
(c) double exact = 5; compiles int to double

4. Underscore readability  
Rewrite these numeric literals with underscores for readability and state the grouping logic you chose.  
(a) 10_000_000  
(b) 0b_111_100_001_111_000  
(c) 0x_FF_00A_BCD  
(d) 1_234_567_890

5. Type with headroom  
Pick a primitive for "milliseconds since app start" that must work up to 3 days; declare the variable and show with a quick bound check that overflow cannot occur within that window. 
int works since the positive limit is 2 Billion and the maximum number of milliseconds is 259_200_000

6. Boolean assignments  
Classify each assignment as legal or illegal; for illegal ones, rewrite the right-hand side so it compiles.  
(a) boolean b1 = 1;  illegal - boolean b1 = true;
(b) boolean b2 = true;  legal
(c) boolean b3 = (5 > 3);  legal
(d) boolean b4 = 0 == false; illegal - boolean b4 = flase;

7. Char storage limits  
Declare three char variables intended to store: (a) 'A', (b) 'Ω', (c) '😊'. Mark which declarations compile and add a one-sentence note explaining why or why not (BMP vs surrogate pairs).
a compiles, b compiles but c doesn't compile. The smilie is a surrogate pair.

8. Scaled integers for measurement  
Declare variables (no computation) using integers to store:  
(a) price in the smallest currency unit  int price_paises
(b) height in millimeters  int height_mm
(c) temperature in tenths of a degree  int temp_10th
Add a brief comment for each on why scaling with integers can be preferable to floating point. When performing calculations, the floating point values may lose precession and accuracy.

9. Data footprint choices  
Choose primitive types for a prototype:  
(a) trips per user per day in [0, 500] *short*
(b) total amount collected per day up to 100,000,000 smallest currency units *int*
(c) station category encoded as a single letter  *char*
Provide a one-line bound check for each choice showing it is safe.

10. Literal edge audit  
Review and propose safer replacements where needed; explain each risk in one sentence.  
(a) long l = 012;  int l = 012; or long l = 012L; Legal definition
(b) int id = 1_2__3; int id = 123; Readability
(c) double d = 1_.0; double d = 1.0; Invalid literal
(d) int k = 1 << 31; boolean k = 1 < 31; or int k = 31 << 1;
The bit wise operator will give a unintended value
---

## Expressions, Precedence, Casting, Integer Division

1. Precedence quick check  
Given int a = 5;, compute each value and name the rule that explains it.  
(a) 5 + 2 * 10  = 25 BODMAS
(b) 10 / 4  = 2
(c) 10 / 4.0  = 2.5
(d) 3 + 'A'  = 68 Converts to ASCII
(e) 7 * (2 + 3) = 35

2. Integer vs floating division  
With int x = 7;, determine the results of:  
(a) x / 2  = 3
(b) (double) x / 2  = 3.5
Add a one-line note on numeric promotion.
The int is type casted into double

3. Single-cast fix  
Change exactly one token so this yields 0.5.
```java
int x = 1;
double y = x / 2.0;
```

4. Minutes to hours and remainder  
Given int totalMinutes = 135;, write assignments that compute:  
(a) int hours using integer division  int hours = totalMinutes/60
(b) int minutesLeft using integer remainder int minutesLeft = totalMinutes%60

5. Floor and nearest average  
Given three int scores, compute:  
(a) the floor average using integer arithmetic only 
	int average = Math.floor(3.6) -> average = 3
(b) the average rounded to the nearest integer using an integer-only technique	int average = Math.round(3.6) -> average = 4

6. Avoid overflow in (a*b)/c  
Assume int a, b, c with c != 0, and a*b might overflow. Provide two safe implementations:  
(a) by casting at the correct time  
	if (a*b > Integer.MAX_VALUE || a*b < Integer.MIN_VALUE>){
		long result = ((long)a*b)/c;
	}

(b) by algebraic reordering when exact divisibility is guaranteed
	if (a%c == 0 ){
		int result = (a/c)*b;
	}else if (b%c == 0){
		int result = (b/c)*a;
	}

7. Unit conversion chain  
Given int centimeters, compute using integer arithmetic only:  
(a) whole meters and remaining centimeters 
	int meters = centimeters/100;
	int remain_m = centimeters%100;
(b) whole kilometers and remaining meters and centimeters
	int kilometers = centimeters/100000;
	int remain_km = centimeters%100000;

8. Percentage fee in minor units  
Given int priceCents and int feePercent, compute:  
(a) int feeCents = 
(b) int totalCents  
Use integer math only; store results in variables.

9. Target values with parentheses  
Let int a = 4, b = 3, c = 2;. Form three different expressions using these variables, standard operators, parentheses, and at most one cast to double, to produce exactly:  
(a) 20  4 * (3+2)
(b) 3.5  (4+3)/2
(c) 2  (4+2)/3
Add a short note on the rule each example demonstrates.
BODMAS

10. Overflow forensics
```java
int n = 50_000;
int m = 50_000;
int area = n * m;
```
(a) Predict the value stored in area.  
	area = -1794967296;
(b) Rewrite the minimal amount of code so area stores the exact mathematical product.  long area = (long)n*m;
(c) Explain the overflow in one or two sentences, referencing Java rules.
The sign bit in the two's complement on the product result gets flipped so the wraps around and becomes negative. 
---

## Console Output (print/println/escapes)

1. Exact two-line output  
Produce exactly:
```
Hello,
World!
```
First using exactly two statements, then using exactly three statements. Use only print/println and string literals.
System.out.println("Hello,");
System.out.println("World!");

System.out.print("Hello,");
System.out.println();
System.out.println("World!");

2. Quoted text  
Print the following using a single string literal with correct escaping:  
He said, "public static void main".

System.out.println("He said, \"public static void main\".");

3. Trace the final layout  
Write the exact final output produced by this sequence, marking newlines precisely.
```java
System.out.print("Line");
System.out.print("1");
System.out.println();
System.out.println("Line 2");
System.out.print("End");
```
Line1
Line 2
End

4. Escape review  
Write the exact text each of these prints (show the resulting lines).  
(a) "\tStart"  	Start
(b) "C:\\temp\\file"  C:\temp\file
(c) "\nNext"  
	Next
(d) "Quote: \"X\"" Quote: "x"

5. Minimal calls, fixed output  
Reproduce the following exactly (including the blank line and the tab) using the fewest print/println calls. Use only string literals and escape sequences.
```
Report
	Version: 1

Status: OK
```
System.out.println("Report\n\tVersion: 1\n\nStatus: OK");
