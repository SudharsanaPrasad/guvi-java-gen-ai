# Lecture 5 Problem Set

Problems

## Classes and Objects

1. **Counter set and get**  
Complete the method bodies so the field is updated and read only through methods.
```java
class Counter {
  private int value;
  public void set(int v) { /* complete */ }
  public int get() { /* complete */ }
}
```
In main, create Counter c = new Counter(); call c.set(42); then store int x = c.get().

2. **Toggle state with one field**  
Implement a boolean toggle and a query method. The goal is to update state through methods, not by exposing fields.
```java
class Light {
  private boolean on = false;
  public void toggle() { /* complete */ }
  public boolean isOn() { /* complete */ }
}
```
In main, create Light l = new Light(); call l.toggle(); exactly three times, then store boolean s = l.isOn().

3. **Running minimum**  
Keep track of the smallest value ever added. Implement additive updates and a query method.
```java
class MinTracker {
  private int current = Integer.MAX_VALUE;
  public void add(int v) { /* set current if v is smaller */ }
  public int min() { /* return current */ }
}
``]
In main, create MinTracker mt = new MinTracker(); add 9, then 5, then 7; store int m = mt.min().

4. **Badge label formatting**  
Build a label from a stored name via an instance method. Purpose: string composition through object state.
```java
class Badge {
  private String name;
  public Badge(String name) { this.name = name; }
  public String label() { /* return "[" + name + "]" */ }
}
```
In main, create Badge b = new Badge("ALPHA"); then store String s = b.label().

5. **Monotonic id generator**  
Issue a new id on every call and advance internal state. Implement read, modify, write in one method.
```java
class IdGen {
  private int next = 1000;
  public int issue() { /* return current next, then increment it */ }
}
```
In main, create IdGen g = new IdGen(); call g.issue() four times and store results in int a, b, c, d.

6. **Two independent objects**  
Use your Counter from problem 1 to show each instance keeps its own state.  
Create Counter x = new Counter(); and Counter y = new Counter(); call x.set(10); and y.set(99); store int gx = x.get(); int gy = y.get().

7. **Bounded counter with clamp**  
Implement a counter that never drops below 0 nor rises above 5. Encapsulate all changes behind methods.
```java
class BoundedCounter {
  private int v = 0;
  public void inc() { /* v = Math.min(5, v + 1) */ }
  public void dec() { /* v = Math.max(0, v - 1) */ }
  public int get() { /* return v */ }
}
```
In main, create BoundedCounter bc = new BoundedCounter(); call bc.inc() seven times, then bc.dec() three times; store int r = bc.get().

8. **Distance accumulator**  
Accumulate distance by adding segments and expose the total through a method only.
```java
class Distance {
  private int meters = 0;
  public void add(int m) { /* ignore non-positive; otherwise meters += m */ }
  public int total() { /* return meters */ }
}
```
In main, create Distance d = new Distance(); call d.add(3000); d.add(0); d.add(1500); store int t = d.total().

---

## Constructors

1. **Default to zero**  
Initialize via the constructor, not via a field initializer.
```java
class Score {
  private int value;
  public Score() { /* set value to 0 */ }
  public int get() { /* return value */ }
}
```
In main, create Score s = new Score(); then store int v = s.get().

2. **Rectangle area from constructor**  
Bind width and height at construction and compute derived data through a method.
```java
class Box {
  private int w, h;
  public Box(int w, int h) { /* assign using this.w and this.h */ }
  public int area() { /* return w * h */ }
}
```
In main, create Box b = new Box(3, 5); store int a = b.area().

3. **Trim and null-to-empty**  
Normalize constructor input so objects start valid.
```java
class Profile {
  private String name;
  public Profile(String name) { /* null -> "", else trim */ }
  public String name() { /* return normalized name */ }
}
```
In main, create Profile p1 = new Profile("  Ada  "); store String s1 = p1.name(); then create Profile p2 = new Profile(null); store String s2 = p2.name().

4. **Non-negative wallet**  
Enforce a non-negative invariant at construction time.
```java
class Wallet {
  private int cents;
  public Wallet(int cents) { /* if cents < 0, set to 0; else keep */ }
  public int cents() { /* return cents */ }
}
```
In main, create Wallet wA = new Wallet(-250); store int w1 = wA.cents(); then Wallet wB = new Wallet(375); store int w2 = wB.cents().

5. **Capacity with guarded add**  
Combine constructor validation with method preconditions.
```java
class Capacity {
  private int limit;
  private int used;
  public Capacity(int limit) { /* limit = Math.max(0, limit) */ }
  public boolean add(int k) { /* k > 0 and used + k <= limit; update used on success */ }
  public int used() { /* return used */ }
}
```
In main, create Capacity cap = new Capacity(10); call cap.add(6); then cap.add(5); store int u = cap.used().

6. **Constructor chaining**  
Delegate from the no-arg constructor to the full constructor to avoid duplication.
```java
class Point {
  private int x, y;
  public Point() { /* call this(0, 0) */ }
  public Point(int x, int y) { /* assign fields */ }
  public int manhattan() { /* Math.abs(x) + Math.abs(y) */ }
}
```
In main, create Point p0 = new Point(); and Point p1 = new Point(3, -4); store int m0 = p0.manhattan(); int m1 = p1.manhattan().

7. **Mutator with validation after construction**  
Allow updates only inside an allowed range and report success via return.
```java
class TempC {
  private int c;
  public TempC(int c) { /* set initial value */ }
  public boolean set(int c) { /* valid only for -100..200 inclusive */ }
  public int get() { /* return c */ }
}
```
In main, create TempC t = new TempC(0); call t.set(250); then t.set(25); store int v = t.get().

8. **Defensive early return in constructor**  
Handle invalid parameter relations at construction time.
```java
class Range {
  private int lo, hi;
  public Range(int lo, int hi) {
    /* if hi < lo, set lo = 0 and hi = 0 and return; else set normally */
  }
  public int size() { /* return hi - lo + 1 */ }
}
```
In main, create Range r1 = new Range(5, 2); and Range r2 = new Range(2, 5); store int s1 = r1.size(); int s2 = r2.size().

---

## Encapsulation

1. **Getter only**  
Expose read access without exposing the field.
```java
class Tag {
  private String value = "X";
  public String get() { /* return value */ }
}
```
In main, create Tag t = new Tag(); store String s = t.get().

2. **Setter that trims and normalizes**  
Accept a possibly null input and normalize internally.
```java
class Label {
  private String text = "";
  public void set(String t) { /* null -> "", else trim */ }
  public String get() { /* return text */ }
}
```
In main, create Label l = new Label(); call l.set("  hello  "); then store String s = l.get().

3. **Non-negative setter with result**  
Refuse invalid updates and report via return.
```java
class Gauge {
  private int v = 0;
  public boolean set(int x) { /* x < 0 -> false; else set and true */ }
  public int get() { /* return v */ }
}
```
In main, create Gauge g = new Gauge(); call g.set(-1); then g.set(9); store int h = g.get().

4. **Deposit and spend with guards**  
Maintain a valid balance under all method calls.
```java
class Purse {
  private int cents = 0;
  public boolean add(int c) { /* c > 0, then add and true; else false */ }
  public boolean spend(int c) { /* c > 0 and c <= cents; update and true; else false */ }
  public int balance() { /* return cents */ }
}
```
In main, create Purse p = new Purse(); call p.add(500); p.spend(120); p.spend(400); store int b = p.balance().

5. **Replace only when different**  
Avoid unnecessary writes by comparing old and new values.
```java
class Mode {
  private String current = "IDLE";
  public boolean set(String m) { /* null -> "IDLE"; trim; change only if different; return true if changed */ }
  public String get() { /* return current */ }
}
```
In main, create Mode md = new Mode(); call md.set("IDLE"); then md.set("RUN"); store String s = md.get().

6. **Two fields remain consistent**  
Reject invalid inputs that would break the invariant.
```java
class Ratio {
  private int num = 0;
  private int den = 1;
  public boolean set(int n, int d) { /* d == 0 -> false; else set both and true */ }
  public int num() { /* return num */ }
  public int den() { /* return den */ }
}
```
In main, create Ratio r = new Ratio(); call r.set(3, 0); then r.set(6, 4); store int n = r.num(); int d = r.den().

7. **Bounded meter**  
Keep value within limits via the setter.
```java
class Meter {
  private int value = 0;
  private int min = 0;
  private int max = 10;
  public boolean set(int v) { /* return false if v outside [min, max], else set and true */ }
  public int get() { /* return value */ }
}
```
In main, create Meter m = new Meter(); call m.set(12); then m.set(7); store int v = m.get().

8. **Immutable copy getter**  
Protect internal arrays by returning copies.
```java
class Note {
  private char[] data;
  public Note(char[] src) { /* clone src or use empty array if null */ }
  public char[] copy() { /* return clone of data */ }
}
```
In main, create char[] src = {'A','B'}; Note n = new Note(src); then set src[0] = 'Z'; then store char[] got = n.copy().

---

## Inheritance

1. **Override a method in a child**  
Practice overriding by supplying different behavior for a child class.
```java
class Vehicle {
  public int wheels() { /* return 0 */ }
}
class Bike extends Vehicle {
  public int wheels() { /* return 2 */ }
}
```
In main, create Bike b = new Bike(); store int w = b.wheels().

2. **Use super constructor and inherited state**  
Pass required data to the parent and use inherited members in child methods.
```java
class Device {
  protected int id;
  public Device(int id) { this.id = id; }
}
class Sensor extends Device {
  public Sensor(int id) { /* call super(id) */ }
  public int code() { /* return id + 100 */ }
}
```
In main, create Sensor s = new Sensor(25); store int c = s.code().

3. **Reuse base behavior instead of duplicating**  
Design a counter that advances by a step but still respects base increment logic by delegating. Implement the override using super.inc() in a loop to show reuse.
```java
class CounterBase {
  private int v;
  public CounterBase(int start) { v = start; }
  public void inc() { v++; }
  public int get() { return v; }
}
class CounterStep extends CounterBase {
  private int step;
  public CounterStep(int start, int step) { /* call super and set step */ }
  public void inc() { /* call super.inc() step times */ }
}
```
In main, create CounterStep cs = new CounterStep(10, 3); call cs.inc(); then store int r = cs.get().

4. **Extend a parent result**  
Override by composing on top of the parent return value.
```java
class Person {
  private String name;
  public Person(String name) { this.name = name; }
  public String label() { return "Person:" + name; }
}
class Student extends Person {
  private int year;
  public Student(String name, int year) { /* call super; set year */ }
  public String label() { /* return super.label() + ":" + year */ }
}
```
In main, create Student st = new Student("Ava", 2); store String s = st.label().

5. **Access a protected field in the child**  
Confirm that protected members are visible to subclasses.
```java
class Base {
  protected int code = 7;
}
class Child extends Base {
  public int getTwice() { /* return code * 2 */ }
}
```
In main, create Child c = new Child(); store int t = c.getTwice().

6. **Two shapes with a common parent**  
Override a method differently in two subclasses and compare results.
```java
class Shape {
  public int area() { /* return 0 */ }
}
class Rect extends Shape {
  private int w, h;
  public Rect(int w, int h) { /* set fields */ }
  public int area() { /* return w * h */ }
}
class Square extends Shape {
  private int s;
  public Square(int s) { /* set field */ }
  public int area() { /* return s * s */ }
}
```
In main, create Rect r = new Rect(3, 5); and Square q = new Square(4); store int a1 = r.area(); int a2 = q.area().

7. **Respect validation from a parent**  
Validate limits in the parent, then enforce them in the child’s behavior.
```java
class Limit {
  protected int max;
  public Limit(int max) { this.max = Math.max(0, max); }
}
class Bounded extends Limit {
  private int v = 0;
  public Bounded(int max) { /* call super(max) */ }
  public boolean set(int x) { /* valid only when 0 <= x <= max */ }
  public int get() { /* return v */ }
}
```
In main, create Bounded b = new Bounded(5); call b.set(7); then b.set(3); store int g = b.get().

8. **Override with partial reuse**  
Call the parent method and add extra behavior on success to illustrate extension instead of replacement.
```java
class Acc {
  private int cents;
  public Acc(int start) { cents = Math.max(0, start); }
  public boolean add(int c) { if (c <= 0) return false; cents += c; return true; }
  public int bal() { return cents; }
}
class BonusAcc extends Acc {
  public BonusAcc(int start) { /* call super(start) */ }
  public boolean add(int c) {
    /* call super.add(c); if true, call super.add(10); return whether the first call succeeded */
  }
}
```
In main, create BonusAcc ba = new BonusAcc(0); call ba.add(100); then store int b = ba.bal().
