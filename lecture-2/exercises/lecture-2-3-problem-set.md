# Lecture 2 & 3 Problem Set

## A) Conditionals (if / else-if / else, short-circuit)

1. Store hours flag  
A store is open on a 24-hour clock from 09:00 to 17:00 inclusive. Given:
```java
int hour = 14;
```
Write a single if with a compound condition that sets boolean isOpen to true when the store is open; otherwise set it to false.
```java
if (hour > 9 || hour < 17){
    isOpen = true;
}
else{
    isOpen = false;
}
```

2. Water state by temperature  
Given:
```java
int tempC = 105;
```
Write an if / else if / else ladder that sets char state to:  
a) 'S' when tempC <= 0  
b) 'L' when 1 <= tempC && tempC <= 99  
c) 'G' when tempC >= 100

```java
if (temC <= 0){
    state = 'S';
}
else if (tempC >= 1 && tempC <= 99){
    state = 'L';
}
else if(tempC >= 100){
    state ='G';
}
```

3. Safe processing guard  
A system should call process() only when it is ready and the input is within limits. Use these stubs and values:
```java
static boolean ready = false;
static boolean withinLimit(int x) { return x <= 100; }
static void process() { /* provided */ }
int value = 120;
```
Write a single if that calls process() only when both conditions are satisfied.
```java
if (ready == true && withinLimit(int x)){
    process();
}

```

4. Exam grading ladder  
Given:
```java
int score = 73;
```
Assign char grade using these bands:  
a) 'A' for 90..100  
b) 'B' for 80..89  
c) 'C' for 70..79  
d) 'D' for 60..69  
e) 'F' for 0..59

```java
if (score <= 100 && score >= 90){
    grade = 'A';
}else if(score <= 89 && score => 80){
    grade = 'B';
}else if ...
```

5. Candidate eligibility rule  
A candidate is eligible if they have at least 2 years of experience and either hold a certification or have at least 3 portfolio items. Given:
```java
int years = 3;
boolean hasCert = false;
int portfolio = 4;
if ((hascert == true||portfolio >= 3) && years >= 2){

}
```
Set boolean eligible accordingly.

6. Utility billing with slabs (cumulative)  
Cumulative pricing:  
a) first 50 units cost 12 each  
b) next 150 units (51..200) cost 10 each  
c) remaining units (201 and above) cost 8 each  
Given:
```java
int units = 201;
int price = 0;
if (units > 50){
    price = 50*12;
    if (units > 200){
        price += 150*10;
        price += (units-200)*8;
        }else {
            price += (units-50)*10;
        }
}else{
    price = units*12;
}

```
Compute total int price using an if / else if / else ladder.

7. Speed label  
Given:
```java
int speed = 88;
```
Set String label to "slow" for 0..39, "cruise" for 40..89, and "fast" for 90..200 using exactly one if / else if / else block.

8. Division only when safe  
Given:
```java
int a = 35;
int b = 0;
```
Set int ratio to a / b only when b != 0; otherwise set ratio = 0.

9. Fix overlapping ranges  
Start from this incorrect logic:
```java
int x = 60; String band;
if (x < 60) { band = "low"; }
else if (x >= 60 || x <= 80) { band = "mid"; }
else if (x > 80) { band = "high"; }
```
Rewrite it with precise, non-overlapping ranges and assign the correct band for x = 60.

10. Access gate rule  
Access is granted when the person has an ID, is an adult, is not banned, and has either paid or is under the limit. Given:
```java
boolean hasID = true, adult = true, underLimit = false, paid = true, notBanned = true;
if(hasID == true && adult == true && notBanned == true &&(paid == true || underLimit == true)){
    canProceed = true;
}
```
Set boolean canProceed accordingly.


## B) switch (classic only)

1. Weekday short name  
Given:
```java
int day = 3;
String shortName =  "";
switch(day){
    case 1: shortName = "Mon";
    break;
    case 2: shortName = "Tue";
    break;
    case 3: shortName = "Wed";
    break;
    case 4: shortName = "Thu";
    break;
    case 5: shortName = "Fri";
    break;
    case 6: shortName = "Sat";
    break;
    case 7: shortName = "Sun";
    break;
}
```
Set String shortName to one of "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" using a classic switch with a break in every case.

2. Direction to code  
Map a compass direction to a code. Given:
```java
char dir = 'W';
```
Set int code as:  
a) N maps to 1  
b) S maps to -1  
c) E maps to 2  
d) W maps to -2  
e) any other character maps to 0  
Use a classic switch.

3. Quarter of year  
Given:
```java
int month = 11;
```
Set int quarter using a classic switch:  
a) months 1,2,3 map to 1  
b) months 4,5,6 map to 2  
c) months 7,8,9 map to 3  
d) months 10,11,12 map to 4  
e) any other value maps to 0

4. Odd or even using grouped cases  
Given:
```java
int d = 7;
```
Use a classic switch with grouped cases to set String parity to "odd" or "even".  
a) cases 1,3,5,7,9 set "odd"  
b) cases 2,4,6,8,10 set "even"  
c) default sets "even" for any other integer in 1..10 not listed

5. HTTP status category  
HTTP status codes are grouped by hundreds. Given:
```java
int statusCode = 404;
```
Switch on statusCode / 100 and set int category as follows:  
a) 1 maps to 1  
b) 2 maps to 2  
c) 3 maps to 3  
d) 4 maps to 4  
e) 5 maps to 5  
f) any other value maps to 0

6. Workflow routing  
Use these stubs and value:
```java
static void recover() { /* provided */ }
static void proceed(int bucket) { /* provided */ }
String status = "ARCHIVED";
```
First compute int bucket using a classic switch with this mapping:  
a) "NEW" maps to 1  
b) "IN_PROGRESS" maps to 2  
c) "DONE" maps to 3  
d) "CANCELLED" maps to 4  
e) any other value maps to 0  
Then write an if that calls recover() when bucket == 0, otherwise calls proceed(bucket).


## C) Loops (for / while / do-while, break/continue, off-by-one)

1. Count to fifteen  
Print exactly:
```
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
```
Use a for loop and single spaces between numbers.
```java
for (int i = 1; i <=15; i++){
    System.out.print(i);
    System.out.print(" ");
}
```
2. Countdown fixed range  
Print exactly:
```
9 8 7 6 5 4 3 2 1 0
```
Use a for loop that starts at 9 and ends at 0, inclusive.
```java
for (int i = 9; i >=0; i--){
    System.out.print(i);
    System.out.print(" ");
}
```

3. Tens inclusive  
Print exactly:
```
0 10 20 30 40 50 60 70 80 90 100
```
Use a single for header. Include 100 exactly once.
```java
for (int i = 0; i <=100; i+=10){
    System.out.print(i);
    System.out.print(" ");
}
```
4. Skip with continue  
From 1 to 60, print one line containing all numbers that are not divisible by 4 and not divisible by 6, separated by single spaces. Use continue to skip disallowed numbers.
```java
for (int i = 1; i <=60; i++){
    if(i%4 == 0 || i%6 == 0){
        continue;
    }else{
        System.out.print(i);
        System.out.print(" ");
    }
}
```

5. First square above threshold  
Find the smallest integer k such that k * k > 1000 using a while loop and break. After the loop, print k on its own line.
```java
int k = 1;
        while (k*k<1000){
            k++;
        }
        System.out.println(k);
```

6. Frame pattern  
Print this 4x6 frame using nested loops:
```
######
#....#
#....#
######
```
```java
for (int i = 0; i<4; i++){
            if(i == 0 || i == 3){
                for(int j = 0; j<6; j++){
                    System.out.print("#");
                }
                System.out.println("");
            }
            if(i == 1 || i == 2){
                System.out.print("#");
                for(int j = 0; j<4; j++){
                    System.out.print(".");
                }
                System.out.print("#");
                System.out.println("");
            }
        }
```

## D) Functions (method basics, signature, params, overloading)

1. max  
Implement static int max(int a, int b) that returns the larger of a and b.

2. Method headers: access, static, return type, name, parameters  
Write only the method headers (no bodies) that show each part clearly in the same class:  
a) a public static method named sumPublic that returns an int and takes (int a, int b)  
b) a private static method named checkNonNegative that returns a boolean and takes (int x)

3. withinInclusive and sample calls  
Implement this method:
```java
static boolean withinInclusive(int x, int lo, int hi){
    if(x >= lo && x <= hi){
        return true;
    }
}
```
It returns true when lo <= x && x <= hi.  
In main, create three boolean variables and assign:  
a) r1 = withinInclusive(10, 10, 20);  
b) r2 = withinInclusive(20, 10, 20);  
c) r3 = withinInclusive(9, 10, 20);

4. Percentage scaling with overloads  
Scaling means applying a percentage to a value. Implement two overloads:  
a) static int scale(int x, int pct) returns the scaled result using integer arithmetic (truncate toward zero)  
b) static double scale(double x, int pct) returns the scaled result as a double  
In main, store the results of:  
a) scale(160, 75)  
b) scale(2.0, 125)

5. Clamp to non-negative  
Implement static int clampToNonNegative(int v) that returns v if v >= 0; otherwise returns 0.  
In main, store the result of clampToNonNegative(-12) into an int variable named c1.

6. Overload resolution calls  
Provide both methods in the same class:
```java
static void f(long v) { /* provided */ }
static void f(Integer v) { /* provided */ }
```
In main, make these calls:  
a) f(5);  
b) f(Integer.valueOf(5));