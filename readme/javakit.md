# Complete Core Java Course – Summary

Welcome to the Complete Core Java course by **Naveen Reddy**. This course is a full-length, beginner-to-advanced guide to Core Java. Below is a structured summary of the key points discussed in the introductory video.

---

## 📌 Course Overview

- Learn **Core Java** from scratch to advanced level.
- Course is comprehensive (~12-13 hours) and designed for **gradual learning**.
- Updated version of previous Java courses by the instructor.
- Includes **detailed explanations**, **code examples**, and **GitHub code links** in the video descriptions.

---

## 👨‍🏫 About the Instructor

- **Naveen Reddy** – Corporate trainer and software developer.
- 12+ years of experience with Java and other programming languages.
- Passionate about teaching Java and simplifying complex concepts.

---

## 🧠 Why Learn Java?

- Java is consistently in the **Top 5 programming languages** (TIOBE index).
- Widely used in:
  - Web development
  - Mobile apps
  - Enterprise applications
- Java is:
  - **Readable**
  - **Maintainable**
  - **Cross-platform (WORA: Write Once, Run Anywhere)**

---

## 🖥️ Technologies & Tools Required

### 1. Java Development Kit (JDK)
- Download [Oracle JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) – LTS (Long-Term Support) version.
- Verify installation using:
  ```bash
  java --version
  javac --version

### 2. Jshell 

**JShell** is an interactive command-line tool introduced in **Java 9** that allows you to **write and evaluate Java code snippets** in real-time, similar to a REPL (Read-Eval-Print Loop) found in languages like Python or JavaScript.

---

### 🔹 Key Features of JShell:

* ✅ **Instant feedback**: You can write code and see the result immediately.
* ✅ **No need to write full classes/methods**: You can run statements, expressions, and method definitions directly.
* ✅ **Great for learning and prototyping**: Quickly test small pieces of code without setting up an entire project.

---

### 🛠 Example Usage:

```sh
$ jshell
jshell> int x = 10
x ==> 10

jshell> System.out.println(x * 2)
20

jshell> String greet(String name) {
   ...> return "Hello " + name;
   ...> }
|  created method greet(String)

jshell> greet("Alice")
$4 ==> "Hello Alice"
```

---
