
# Java 21 + IntelliJ Setup (Quick Start)

> Goal: Be ready to **run a Java file in IntelliJ** (and try `jshell`) before the next session.

---

## 1) Install JDK **21** (Long-Term Support)

Choose **one** vendor (both are fine):

- **Eclipse Adoptium Temurin 21 (LTS)** – cross‑platform builds.  
  Download: https://adoptium.net/temurin/releases/?version=21

- **Oracle JDK 21 (LTS)** – official Oracle builds.  
  Download: https://www.oracle.com/java/technologies/downloads/#jdk21

### Verify your install (all platforms)
Open a terminal / command prompt and run:
```bash
java -version
javac -version
jshell --version
```
Expected: all three commands print **21.x**

> If you see “command not found”, re-open the terminal after install. On Windows, ensure the installer added Java to PATH.

---

## 2) Install **IntelliJ IDEA**

- Official download page: https://www.jetbrains.com/idea/download/
- Starting with **IntelliJ IDEA 2025.3**, JetBrains is moving to a **unified installer** (single distribution). The free core is enough for this course.

### First run (create a plain Java project)
1. **New Project → Java**, set **SDK = JDK 21**, Finish.
2. In `src`, create class **App** and paste:
   ```java
   public class App {
     public static void main(String[] args) {
       System.out.println("First run OK");
     }
   }
   ```
3. Click the green **▶** next to `main` or in the gutter.

> If IntelliJ can’t find the JDK: **File → Project Structure → SDKs → Add JDK** and point it to your JDK 21 folder.

---

## 3) JShell

Try quick experiments without a project:
```bash
jshell
jshell> System.out.println("Hi");
jshell> int a = 10; long b = 20L; a + b
```