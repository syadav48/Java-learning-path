Let's break down the concept of **literals in Java**, along with your examples.

---

### 🔹 What Are **Literals** in Java?

A **literal** is a **fixed value** that you assign directly to a variable in your code. It represents the actual value in memory.

Example:

```java
int a = 10; // Here, 10 is an integer literal
```

Literals exist for all **primitive types** in Java: `int`, `byte`, `short`, `long`, `float`, `double`, `char`, and `boolean`.

---

### 🔸 Types of Literals:

#### 1. **Integer Literals** (`byte`, `short`, `int`, `long`)

* **Decimal** (Base 10): `int a = 100;`
* **Binary** (Base 2): Prefix with `0b` → `int a = 0b101;` ➝ 5
* **Octal** (Base 8): Prefix with `0` → `int a = 012;` ➝ 10
* **Hexadecimal** (Base 16): Prefix with `0x` → `int a = 0xA;` ➝ 10

✅ Use underscores (`_`) for readability:

```java
int num = 1_00_00_000; // 1 crore (India-style counting)
```

---

#### 2. **Floating-Point Literals** (`float`, `double`)

* Default is `double` in Java:

  ```java
  double d = 12.34;
  ```

* To define a `float`, you **must suffix** it with `f` or `F`:

  ```java
  float f = 12.34f;
  ```

* **Scientific notation (Exponential form)**:

  ```java
  double num = 12e10; // 12 × 10^10 = 120000000000.0
  ```

---

#### 3. **Character Literals** (`char`)

* Single character in single quotes:

  ```java
  char c = 'A';
  ```
* Unicode representation:

  ```java
  char unicodeChar = '\u0041'; // 'A'
  ```

---

#### 4. **Boolean Literals**

```java
boolean flag = true;
boolean test = false;
```

---

### 🔸 Why Is `double` Default for Floating-Point?

* **Precision**: `double` has 64-bit precision, whereas `float` has 32-bit.
* Double is more accurate and preferred for most calculations.
* Compiler assumes decimals like `12.5` as `double` unless you use `f`.

---

### 🔹 Size and Range of Primitive Types:

| Type      | Size    | Range                           |
| --------- | ------- | ------------------------------- |
| `byte`    | 1 byte  | -128 to 127                     |
| `short`   | 2 bytes | -32,768 to 32,767               |
| `int`     | 4 bytes | -2,147,483,648 to 2,147,483,647 |
| `long`    | 8 bytes | -2⁶³ to 2⁶³-1                   |
| `float`   | 4 bytes | \~±3.4e38 (7 decimal digits)    |
| `double`  | 8 bytes | \~±1.8e308 (15 decimal digits)  |
| `char`    | 2 bytes | 0 to 65,535 (UNICODE chars)     |
| `boolean` | 1 bit   | `true` or `false`               |

---

### 🔸 What Does 1 Byte Mean?

* **1 byte = 8 bits**
* A bit is the smallest unit: 0 or 1
* So, 1 byte can store 2⁸ = **256 values**
* Signed values (like `byte`) use 1 bit for the sign (positive/negative), so range is:

  * `-128 to 127` for `byte`

---

Let me know if you'd like a downloadable table or diagram for this!
