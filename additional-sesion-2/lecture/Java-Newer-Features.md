## Additional Session 2: Newer Features in Java

### Session focus

This session was a discussion-style overview of **modern Java features** and how they show up in real codebases.
Some topics were covered, some are pending for follow-up.

## Pending: Practical

### Which newer Java features are most commonly used in real projects?

## Pending: Collections / Core Java

* `Collection` vs `Collections`
* `Comparable` vs `Comparator`
* Polymorphism: compile-time vs runtime

## Pending: OOP

* Abstract class vs interface
* Abstract class, abstract method
* `super()` vs `this()`

### Notes on `super` and `this`

* `super()`:

  * Used by a child class to call the parent class constructor (first line of the constructor).
* `this`:

  * Refers to the current object (instance).
  * Used to access current class fields/methods, or to call another constructor in the same class via `this(...)`.

Example mental model:

* `this.name = "Nikhil"` assigns to the current object’s field.
* `this.getName()` calls the current object’s method.

Special case (interface default methods):

* `InterfaceName.super.defaultMethodName()`

  * Used when a class implements multiple interfaces and you want a specific interface’s default method.

## Pending: Concurrency

* `Runnable` vs `Callable`

## Covered: Newer Features

## 1) Functional Interfaces

### What is it?

A **functional interface** is an interface with **exactly one abstract method**.
This makes it compatible with lambda expressions.

Examples (standard Java library):

* `Runnable` -> `void run()`
* `Callable<T>` -> `T call()`
* `Comparator<T>` -> `int compare(T a, T b)`
* `Predicate<T>` -> `boolean test(T t)`

## 2) Can a functional interface extend another interface?

Yes, **as long as it still has only one abstract method** after inheritance.

* Extending is allowed if:

  * the parent interface has no abstract methods, OR
  * the parent interface’s abstract method is the same one (compatible signature)

## 3) Lambda Expressions and their connection to functional interfaces

### Why do lambdas exist?

A lambda is a compact way to pass **behavior** when Java expects a functional interface.

### What does it replace?

Before lambdas, we used **anonymous classes** to pass behavior.

Mental model:

* “Java expects an interface object with one method.”
* “A lambda is just the implementation of that one method.”

## 4) Default and Static Methods in Interfaces

* **Default methods**

  * Allow interfaces to provide a method implementation.
  * Useful when adding new methods to an interface without breaking old implementations.
* **Static methods**

  * Utility methods that belong to the interface itself.
  * Called like: `InterfaceName.someStaticMethod()`

## 5) Optional

### What is it?

`Optional<T>` is a wrapper that means: **“a value may or may not exist.”**

### Why does it exist?

* Encourages you to handle “missing value” cases explicitly
* Reduces `null`-based bugs

Basic mental model:

* Instead of returning `null`, return `Optional.empty()`
* Consumer code checks presence or uses safe fallback methods

## 6) Records and Sealed Types in data modeling

## Records

### What is it?

A **record** is a concise way to define an **immutable data carrier**.

### Java generates for you

* constructor
* accessors
* `equals()`, `hashCode()`, `toString()`

### Why is it useful?

Reduces boilerplate for “data-only” classes.

## Sealed Classes / Interfaces

### What is it?

A sealed type restricts which classes/interfaces are allowed to extend/implement it.

### Why is it useful?

* Controls your type hierarchy (useful for modeling “fixed sets” of outcomes)
* Helps maintain correctness as systems grow

### Data modeling scenario

* `UserService` owns full `User` information: `id, name, age, email, address, username, password, ...`
* `AuthService` manages complete authentication flows (eg: log in, log out, etc)
* `AuthService` may only need partial user details

  * Example: a record containing only `name, username, email`
  * This keeps data usage minimal and clearer

## 7) Switch expressions vs traditional switch statements

* Traditional `switch` is statement-based and often needs `break`
* Switch expressions can return a value directly (cleaner for mapping/decision logic)

## 8) Streams

### What is a Stream?

A Stream is a way to process a collection **step-by-step** (pipeline style).

### Use cases discussed

* Filter people by condition

  * Example: `List<Person>` -> “age > 25”
  * Traditional approach: loop + if condition
* Transform values

  * Example: `List<Grade>`

    * marks originally 1-10
    * convert to 1-100 by multiplying by 10
  * Without streams: loop and update

## Pending: Newer Features

* Virtual Threads (Project Loom): what problem they solve, current status, structured concurrency
* Pattern Matching: readability improvements
* Flexible Constructor Bodies (Java 25)
* Module Import Declarations (Java 25)
* Scoped Values vs ThreadLocal
* Compact Object Headers (Project Lilliput)
* Stream Gatherers API: what is it and why does it exists
* Implicitly Declared Classes (simplifying Java for beginners)

## TODO / Planning

* Tasks on individual topics in the Java module
* One more session on Java new features:

  * 19th Jan, Mon at 5 PM

## For everyone

### LeetCode (Jan 31st)

* Aim for 50 kinds of problems × 2 = **100 problems**

### Databases

* Tasks:

  * MySQL. Due Date: Friday, 16th January 2026
  * MongoDB. Due Date: Monday, 19th January 2026

### Java

* Individual topic-based practice tasks in the Java module