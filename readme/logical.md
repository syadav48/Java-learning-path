Here's a **well-structured and interview-ready Markdown document** covering **Logical Operators in Java**, just like the previous ones:

---

````markdown
# Java: Logical Operators

Logical operators are used to combine two or more conditions (boolean expressions) and return a boolean result (`true` or `false`).

---

## 1. Types of Logical Operators

| Operator | Name               | Description                                                                 |
|----------|--------------------|-----------------------------------------------------------------------------|
| `&&`     | Logical AND         | Returns `true` if **both** conditions are true                              |
| `||`     | Logical OR          | Returns `true` if **at least one** condition is true                        |
| `!`      | Logical NOT         | Reverses the logical state of its operand (`true` becomes `false`, and vice versa) |

---

## 2. Logical AND (`&&`)

### Syntax:
```java
condition1 && condition2
````

### Truth Table:

| A     | B     | A && B |
| ----- | ----- | ------ |
| true  | true  | true   |
| true  | false | false  |
| false | true  | false  |
| false | false | false  |

### Example:

```java
int age = 25;
boolean citizen = true;

if (age > 18 && citizen) {
  System.out.println("Eligible to vote.");
}
```

---

## 3. Logical OR (`||`)

### Syntax:

```java
condition1 || condition2
```

### Truth Table:

\| A     | B     | A || B |
\|-------|-------|--------|
\| true  | true  | true   |
\| true  | false | true   |
\| false | true  | true   |
\| false | false | false  |

### Example:

```java
int marks = 40;

if (marks >= 33 || marks >= 90) {
  System.out.println("Passed or Excellent");
}
```

---

## 4. Logical NOT (`!`)

### Syntax:

```java
!condition
```

### Truth Table:

| A     | !A    |
| ----- | ----- |
| true  | false |
| false | true  |

### Example:

```java
boolean isRaining = false;

if (!isRaining) {
  System.out.println("Let's go outside.");
}
```

---

## 5. Short-Circuit Behavior

* `&&` (AND) **short-circuits**: if the first condition is false, the second is **not evaluated**.
* `||` (OR) **short-circuits**: if the first condition is true, the second is **not evaluated**.

### Example:

```java
int a = 5;

if (a < 10 || ++a > 10) {
  // ++a will not be evaluated because a < 10 is true
}
System.out.println(a); // Output: 5
```

---

## 6. Logical vs Bitwise Operators

| Operator | Type          | Used For |                                  |                    |
| -------- | ------------- | -------- | -------------------------------- | ------------------ |
| `&&`, \` |               | `, `!\`  | Logical                          | Boolean conditions |
| `&`, \`  | `, `^`, `\~\` | Bitwise  | Bit-level operations on integers |                    |

---

## 7. Combining Logical Operators

You can nest or chain multiple logical operators:

```java
if ((age > 18 && age < 60) || isSeniorCitizen) {
  System.out.println("Allowed entry");
}
```

> Use parentheses `()` for better readability and to avoid ambiguity.

---

## 8. Interview / Practice Questions

### Q1. What will be printed?

```java
int x = 5;

if (x > 2 && x < 10) {
  System.out.println("Valid range");
}
```

<details><summary>Answer</summary>
`x > 2` → true, `x < 10` → true → Output: **Valid range**
</details>

---

### Q2. Predict the result:

```java
boolean a = true;
boolean b = false;

System.out.println(a && b);
System.out.println(a || b);
System.out.println(!b);
```

<details><summary>Answer</summary>
- `a && b` → false  
- `a || b` → true  
- `!b` → true
</details>

---

### Q3. Will this compile?

```java
int x = 10;
if (x && 5) {
  // ...
}
```

<details><summary>Answer</summary>
❌ Compile-time error. `&&` expects **boolean**, but `x && 5` uses integers.
</details>

---

### Q4. What is the output?

```java
int a = 5;
if (a < 10 || ++a > 10) {
  System.out.println(a);
}
```

<details><summary>Answer</summary>
Short-circuit: `a < 10` is true, so `++a` is **not evaluated** → Output: `5`
</details>

---

### Q5. What will this print?

```java
boolean x = true;
boolean y = false;

if (!(x && y)) {
  System.out.println("It worked!");
}
```

<details><summary>Answer</summary>
`x && y` → false, `!(false)` → true  
So: **"It worked!"**
</details>

---

## 9. Summary

* Use `&&` when **both** conditions must be true.
* Use `||` when **at least one** condition must be true.
* Use `!` to **invert** a boolean condition.
* Short-circuiting improves performance and prevents unnecessary evaluation.

---

```

---

Let me know if you'd like all these operator notes (Type Conversion, Assignment, Relational, Logical) compiled into one `.md` file for easy download or further study.
```
