## Additional Session 3: Pending questions

### 1) Practical

* **Which newer Java features are most commonly used in real projects?**
- Record, var, switch expression

1) Date/Time

- Instant: machine readble timestamps (logs)
- LocalDate  / LocalTime / LocalDateTime - human readable date/time representation
- ZonedDateTime - when timezone matters

Reference: https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html

### 2) Collections / Core Java

* **`Collection` vs `Collections`**
    - Collection: an interface for most of the collection types we use day-to-day
        - Iterator -> iterate over a collection
        - Collection -> add, remove, contains, etc
        - List, Set, etc
    - Collections: a utility class
        - Collections.sort(??)
        - Collections.reverse(??)
        - unmodifiableList / unmodifiableSet / unmodifiableMap
            - It creates a read-only view wrapper of an existing collection
* **`Comparable` vs `Comparator`**
    - Comparable
        - int compareTo(T other)
        - natural sorting order - defined the class
    - Comparator
        - int compare(T a, T b)
        - Custom comparator
            - Comparator -> Lambda Expression
* **Polymorphism: compile-time vs runtime**
    - Compile-time polymorphism
        - overloading - the compiler decides which method to call
            - based on the method signature
    - Runtime-time polymorphism
        - overrding - JVM deciding which method impl to run based on the actual object type at runtime
            - child class is providing its own implementation of the interface

### 3) OOP

* **Abstract class vs interface**
    - Class
        - instance variables, contructors
        - concrete methods
    - Abstract class: partially implemented class
        - instance variables, contructors
        - contains abtract methods
            - move
        - concrete methods
        - cannot be instantiated
            - Animal anmial1 = new Animal();
            - animal1.move()
    - interface - contract; tells the implementing class which behavior must be provided
* **Abstract class, abstract method**
* **`super()` vs `this()`**
    - super() -> call parent constructors
    - super().pay() -> parent class's pay method
    - this 
        - default and parameterized constructors
        - public Account() { this(0); }
        - public Account(int initialBalance) { this.balance = initialBalance; }
        - public void authoize() { ... }
        - public void pay() { this.authoize(); }

### 4) Concurrency

* **`Runnable` vs `Callable`**
    - implements Runnable OR new Thread()
    - Why 'Runnable' exists?
        - Run some code in the background
        - We've a unit of work and we need to run this
        - @FunctionalInterface
            - void run()
        - Runnable r1 = new Runnable(() -> { ... });
        - 
    - Callable
        - Just running some code in the background wasn't enough
        - We receive a result for the background work
        - Uses Generics
        - T call() throws Exception
    

### 5) Pending: Newer Features (follow-up deep dive)

* **Pattern Matching:** readability improvements
* **Module Import Declarations (Java 25)**

* **Virtual Threads (Project Loom):** what problem they solve, current status, structured concurrency
* **Flexible Constructor Bodies (Java 25)**
* **Scoped Values vs ThreadLocal**
* **Compact Object Headers (Project Lilliput)**
* **Stream Gatherers API:** what is it and why it exists
* **Implicitly Declared Classes (simplifying Java for beginners)**
