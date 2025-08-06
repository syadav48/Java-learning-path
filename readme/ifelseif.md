Perfect! Below is a complete and **well-structured Markdown document** on **`if`, `else if`, and `else` statements in Java**, with clear explanations, standard examples, and intermediate-level interview/practice questions.

---

````markdown
# Java: if, else if, else Statement

Control flow in Java is managed using conditional statements like `if`, `else if`, and `else`. These allow your program to make decisions based on certain conditions.

---

## 1. Basic Syntax

```java
if (condition) {
    // block executes if condition is true
} else if (anotherCondition) {
    // executes if previous condition is false and this one is true
} else {
    // executes if none of the above conditions are true
}
````

---

## 2. Simple if Statement

```java
int age = 18;

if (age >= 18) {
    System.out.println("Eligible to vote");
}
```

---

## 3. if...else Statement

```java
int number = 10;

if (number % 2 == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");
}
```

---

## 4. if...else if...else Statement

```java
int marks = 85;

if (marks >= 90) {
    System.out.println("Grade A");
} else if (marks >= 75) {
    System.out.println("Grade B");
} else if (marks >= 60) {
    System.out.println("Grade C");
} else {
    System.out.println("Fail");
}
```

---

## 5. Nested if Statement

```java
int age = 25;
boolean hasVoterID = true;

if (age >= 18) {
    if (hasVoterID) {
        System.out.println("Allowed to vote");
    } else {
        System.out.println("Apply for voter ID");
    }
} else {
    System.out.println("Not eligible to vote");
}
```

---

## 6. Using Logical Operators in if

```java
int num = 15;

if (num > 10 && num < 20) {
    System.out.println("Number is between 10 and 20");
}
```

---

## 7. Ternary Operator (Short form of if-else)

```java
int number = 9;
String result = (number % 2 == 0) ? "Even" : "Odd";
System.out.println(result); // Output: Odd
```

---

## 8. Practice / Interview-Level Questions

### Q1. Find the largest of three numbers

```java
int a = 10, b = 25, c = 15;

if (a > b && a > c) {
    System.out.println("A is largest");
} else if (b > c) {
    System.out.println("B is largest");
} else {
    System.out.println("C is largest");
}
```

---

### Q2. Check if a number is positive, negative, or zero

```java
int num = 0;

if (num > 0) {
    System.out.println("Positive");
} else if (num < 0) {
    System.out.println("Negative");
} else {
    System.out.println("Zero");
}
```

---

### Q3. Determine if a year is a leap year

```java
int year = 2024;

if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
    System.out.println("Leap year");
} else {
    System.out.println("Not a leap year");
}
```

---

### Q4. Calculate income tax based on salary

```java
double income = 550000;
double tax;

if (income <= 250000) {
    tax = 0;
} else if (income <= 500000) {
    tax = (income - 250000) * 0.05;
} else if (income <= 1000000) {
    tax = (250000 * 0.05) + (income - 500000) * 0.2;
} else {
    tax = (250000 * 0.05) + (500000 * 0.2) + (income - 1000000) * 0.3;
}
System.out.println("Tax payable: " + tax);
```

---

### Q5. Grading System (Nested if and range-based logic)

```java
int marks = 88;

if (marks >= 0 && marks <= 100) {
    if (marks >= 90) {
        System.out.println("Grade A");
    } else if (marks >= 75) {
        System.out.println("Grade B");
    } else if (marks >= 60) {
        System.out.println("Grade C");
    } else if (marks >= 40) {
        System.out.println("Grade D");
    } else {
        System.out.println("Fail");
    }
} else {
    System.out.println("Invalid marks");
}
```

---

## 9. Intermediate Practice Questions

1. **Write a program to check whether a character is a vowel or consonant.**
2. **Check whether a given year is a century year or not.**
3. **Take 3 subject marks and determine pass/fail if average is above 40 and each subject is above 33.**
4. **Find the smallest of three numbers using if-else.**
5. **Check whether the number is divisible by both 3 and 5.**
6. **Take input for day number (1-7) and print weekday name using if-else-if.**
7. **Take user input for age, and determine if eligible for driving license (>=18), learner (16-17), or underage (<16).**
8. \**Write a calculator using `if-else`: take two numbers and an operator (+, -, *, /) and compute result.**

---

## 10. Summary

* Use `if` for checking a single condition.
* Use `else if` when multiple exclusive conditions exist.
* Use `else` for fallback/default logic.
* Nest `if` blocks when one condition depends on another.
* Avoid deep nesting — use logical operators or separate methods.

---

```

Would you like me to export this and previous notes into a single downloadable `.md` file?
```
Here’s a concise and complete section on the **`switch` statement** in Java, written in **Markdown** format, to append to your notes.

---

````markdown
# Switch Statement in Java

The `switch` statement is a multi-way branch statement that allows a variable to be tested for equality against multiple values.

## Syntax

```java
switch (expression) {
    case value1:
        // Code to execute
        break;
    case value2:
        // Code to execute
        break;
    // More cases...
    default:
        // Default code if no case matches
}
````

## Important Points

* The expression must evaluate to **byte, short, char, int, String**, or **enum**.
* `break` is used to terminate a case block, else control falls through to the next case.
* `default` is optional, and it runs when none of the `case` values match.

## Example 1: Basic Integer Switch

```java
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Invalid day");
}
```

**Output:**

```
Wednesday
```

## Example 2: String Switch (Java 7+)

```java
String fruit = "Mango";
switch (fruit) {
    case "Apple":
        System.out.println("Red Fruit");
        break;
    case "Mango":
        System.out.println("Yellow Fruit");
        break;
    default:
        System.out.println("Unknown Fruit");
}
```

**Output:**

```
Yellow Fruit
```

## Example 3: Fall-through (No `break`)

```java
int num = 2;
switch (num) {
    case 1:
    case 2:
    case 3:
        System.out.println("Number is between 1 and 3");
        break;
    default:
        System.out.println("Number is not between 1 and 3");
}
```

**Output:**

```
Number is between 1 and 3
```

## Good to Know

* **Nested switch** is possible, but avoid it for better readability.
* Use `switch` instead of `if-else` when comparing the same variable against multiple constants for better performance and clarity.

---

```

Let me know if you'd like this appended into the full `.md` document that includes:
- Type Conversion & Casting  
- Assignment Operators  
- Relational Operators  
- Logical Operators  
- `if`, `else if`, `else`  
- `switch` statement  

I can generate the full downloadable file if needed.
```
