Absolutely! Here's a detailed and well-structured **Markdown note** on **Relational Operators** in Java — with explanations, examples, edge cases, and interview-style questions:

---

````markdown
# Java: Relational Operators

Relational operators in Java are used to **compare two values or expressions**. They return a boolean value: `true` or `false`.

---

## 1. List of Relational Operators

| Operator | Meaning                     | Example           | Result        |
|----------|-----------------------------|-------------------|----------------|
| `>`      | Greater than                | `5 > 3`           | `true`         |
| `<`      | Less than                   | `2 < 1`           | `false`        |
| `>=`     | Greater than or equal to    | `5 >= 5`          | `true`         |
| `<=`     | Less than or equal to       | `4 <= 2`          | `false`        |
| `==`     | Equal to                    | `10 == 10`        | `true`         |
| `!=`     | Not equal to                | `6 != 7`          | `true`         |

---

## 2. Key Characteristics

- These operators **compare primitive values** like `int`, `float`, `char`, etc.
- The result is always a **boolean** (`true` or `false`).
- Do **not confuse `=` (assignment)** with `==` (equality comparison).

---

## 3. Examples

### Integer Comparison
```java
int a = 10, b = 20;
System.out.println(a > b);  // false
System.out.println(a != b); // true
````

### Character Comparison

```java
char c1 = 'A'; // ASCII 65
char c2 = 'a'; // ASCII 97

System.out.println(c1 < c2);  // true
System.out.println(c1 == 65); // true
```

### Float and Double Comparison

```java
float x = 5.5f;
double y = 5.5;

System.out.println(x == y);  // true, due to numeric promotion
```

### Boolean Comparison ❌

Relational operators like `<`, `>`, `<=`, `>=` **cannot be used with boolean values**.

```java
boolean b1 = true;
boolean b2 = false;

// System.out.println(b1 > b2); // ❌ Compile-time error
System.out.println(b1 != b2); // ✅ true
```

---

## 4. Common Mistakes

### ❌ Using `=` instead of `==`:

```java
int x = 10;
if (x = 5) { } // ❌ Compile error: incompatible types
```

### ✅ Correct usage:

```java
if (x == 5) { }
```

### ⚠️ Floating-point equality:

Be careful when comparing floating-point numbers due to precision issues.

```java
double d1 = 0.1 + 0.2;
System.out.println(d1 == 0.3); // false!
```

---

## 5. Relational Operators with `if`, `while`, etc.

Relational operators are mostly used in control flow:

### Example:

```java
int age = 18;

if (age >= 18) {
  System.out.println("You can vote!");
}
```

---

## 6. Practice / Interview Questions

### Q1. What will be printed?

```java
int a = 5, b = 10;
System.out.println(a > b || a == 5);
```

<details><summary>Answer</summary>
`a > b` → false, `a == 5` → true  
Result: `false || true` → **true**
</details>

---

### Q2. What is the result of:

```java
char c = 'B';
System.out.println(c > 'A' && c < 'Z');
```

<details><summary>Answer</summary>
ASCII of B is 66  
ASCII of A is 65  
ASCII of Z is 90  
→ true && true → **true**
</details>

---

### Q3. Predict output:

```java
int x = 100;
int y = 100;

System.out.println(x == y);      // ?
System.out.println(x != y);      // ?
```

<details><summary>Answer</summary>
Both values are equal →  
`x == y` → true  
`x != y` → false
</details>

---

### Q4. Which one will fail at compile time?

```java
boolean b1 = true;
boolean b2 = false;
System.out.println(b1 > b2);
```

<details><summary>Answer</summary>
❌ Relational operators can't be used with boolean types.  
**Compile-time error**
</details>

---

### Q5. What is the result?

```java
System.out.println('A' == 65);
System.out.println('A' > 66);
```

<details><summary>Answer</summary>
- `'A' == 65` → true  
- `'A' > 66` → false  
</details>

---

## 7. Summary

* Relational operators are used to **compare values**.
* They return `true` or `false`.
* Useful in conditions (`if`, `while`, `for`, etc.)
* Avoid using them with non-compatible types (like boolean for `<`, `>`).

---

```

---

Would you like me to export this and the previous notes (`Type Conversion`, `Assignment`, and this one) into a single `.md` file?
```
