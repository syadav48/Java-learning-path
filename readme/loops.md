Here’s a concise **brief** and **intermediate-level questions** on `while`, `do-while`, and `for` loops in Java — written in **Markdown** format, just like your earlier notes.

---

````markdown
# Loops in Java: while, do-while, and for

Java provides three primary types of loops to execute a block of code multiple times.

---

## 🔁 while Loop

### Syntax:
```java
while (condition) {
    // code block
}
````

### Characteristics:

* Entry-controlled loop
* Condition is checked **before** executing the block
* Useful when **number of iterations is not known beforehand**

### Example:

```java
int i = 1;
while (i <= 5) {
    System.out.println("Count: " + i);
    i++;
}
```

---

## 🔂 do-while Loop

### Syntax:

```java
do {
    // code block
} while (condition);
```

### Characteristics:

* Exit-controlled loop
* Executes **at least once** regardless of the condition
* Useful when **you need to run the loop at least once**, e.g., menu-driven programs

### Example:

```java
int i = 1;
do {
    System.out.println("Count: " + i);
    i++;
} while (i <= 5);
```

---

## 🔁 for Loop

### Syntax:

```java
for (initialization; condition; update) {
    // code block
}
```

### Characteristics:

* Entry-controlled loop
* Best suited when the **number of iterations is known**
* Compact and readable for counter-based loops

### Example:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Count: " + i);
}
```

---

## 🔍 Which Loop to Use?

| Use Case                                 | Recommended Loop |
| ---------------------------------------- | ---------------- |
| Known number of iterations               | `for`            |
| Unknown iterations, check before running | `while`          |
| Ensure loop runs at least once           | `do-while`       |

---

## 💡 Intermediate-Level Practice Questions

1. **Sum of Digits (using `while`)**
   Input a number and print the sum of its digits.

2. **Reverse a Number (using `while`)**
   Input a number and reverse it using a `while` loop.

3. **Menu-Driven Program (using `do-while`)**
   Create a simple calculator using a `do-while` loop that shows a menu and performs operations until the user exits.

4. **Check Prime (using `for`)**
   Input a number and check whether it is a prime.

5. **Fibonacci Series (using `for`)**
   Print first N Fibonacci numbers using a `for` loop.

6. **Find the GCD (using `while`)**
   Input two numbers and find their GCD using the Euclidean algorithm.

7. **Find Armstrong Numbers between 100–999 (using `for`)**
   Find and print all 3-digit Armstrong numbers.

8. **Count number of digits in a number (using `while`)**

9. **Check Palindrome (using `while`)**
   Input a number and check if it's a palindrome.

10. **Pattern Printing**

* Print star triangle using `for` loop

  ```
  *
  **
  ***
  ****
  ```

---

```

Let me know if you'd like this added to your **full `.md` document**, and I’ll generate the combined file for download.
```
