Here is a **comprehensive Markdown document** on **Type Conversion and Casting in Java**, combining your notes with deeper explanations, examples, and edge cases for better future reference:

---

````markdown
# Java: Type Conversion, Casting, and Type Promotion

Understanding how Java handles different data types during assignments and operations is crucial. This guide covers:

- Implicit Type Conversion (Widening)
- Explicit Type Casting (Narrowing)
- Type Promotion in Expressions
- Edge Cases and Important Notes

---

## 1. Implicit Type Conversion (Widening Conversion)

Java automatically converts smaller data types into larger data types when needed. This is called **implicit conversion** or **widening**.

### Valid Implicit Conversions:
- `byte` → `short` → `int` → `long` → `float` → `double`

### Example:
```java
byte b = 127;
int a = b;  // Implicit conversion from byte to int
System.out.println(a); // Output: 127
````

* No loss of data
* Safe and automatic

---

## 2. Explicit Type Casting (Narrowing Conversion)

When converting from a larger data type to a smaller one, Java **requires explicit casting**. This is called **narrowing conversion**.

### Syntax:

```java
smallType variable = (smallType) largeTypeValue;
```

### Example:

```java
int a = 256;
byte b = (byte) a;  // b = 256 % 256 = 0
System.out.println(b); // Output: 0
```

### More Examples:

```java
int a = 257;
byte b = (byte) a;
System.out.println(b); // Output: 1 (257 % 256 = 1)

float f = 5.6f;
int x = (int) f;
System.out.println(x); // Output: 5 (decimal part truncated)
```

### Important Note:

* Casting can lead to **data loss**.
* Byte range is **-128 to 127**, so values outside this wrap around using modulo 256.

---

## 3. Type Promotion in Expressions

Java automatically promotes byte, short, and char to int **when used in expressions**, even if the result can be safely stored in the original type.

### Example:

```java
byte a = 10;
byte b = 20;
// byte result = a * b; // ❌ Compile-time error
int result = a * b;     // ✅ a and b are promoted to int
```

> To store it back in a byte, you must cast it:

```java
byte result = (byte)(a * b);
```

---

## 4. Conversion Between Floating and Integer Types

### Float/Double to Integer:

* Decimal portion is **truncated**, not rounded.

```java
float f = 9.9f;
int i = (int) f; // i = 9
```

### Integer to Float/Double:

* Automatically widened

```java
int i = 100;
float f = i; // f = 100.0
```

---

## 5. Conversion and Casting Rules Summary

| From \ To | byte | short | char | int | long | float | double |
| --------- | ---- | ----- | ---- | --- | ---- | ----- | ------ |
| byte      | ✔️   | ✔️    | ❌    | ✔️  | ✔️   | ✔️    | ✔️     |
| short     | ❌    | ✔️    | ❌    | ✔️  | ✔️   | ✔️    | ✔️     |
| char      | ❌    | ❌     | ✔️   | ✔️  | ✔️   | ✔️    | ✔️     |
| int       | ❌    | ❌     | ❌    | ✔️  | ✔️   | ✔️    | ✔️     |
| long      | ❌    | ❌     | ❌    | ❌   | ✔️   | ✔️    | ✔️     |
| float     | ❌    | ❌     | ❌    | ❌   | ❌    | ✔️    | ✔️     |
| double    | ❌    | ❌     | ❌    | ❌   | ❌    | ❌     | ✔️     |

* ✔️ = Implicit conversion
* ❌ = Requires explicit cast

---

## 6. Edge Case: Overflow and Underflow

Casting a large number into a smaller type causes overflow or underflow.

### Example:

```java
int a = 130;
byte b = (byte) a;
System.out.println(b); // Output: -126
```

* Because byte range is -128 to 127 → 130 overflows

---

## 7. Special Case: char and int

### Example:

```java
char c = 'A';
int code = c; // Implicitly promoted to int
System.out.println(code); // Output: 65

int n = 66;
char ch = (char) n; // Explicit cast needed
System.out.println(ch); // Output: B
```

* `char` is an unsigned 16-bit type (range: 0 to 65535)

---

## 8. Tips for Avoiding Errors

* Use explicit casting when narrowing.
* Remember that expressions with `byte`, `short`, and `char` promote to `int`.
* Be careful with overflow when casting large numbers.
* Truncation happens when casting from float/double to int.

---

## 9. Practice Problems

1. What will be the output?

```java
int a = 300;
byte b = (byte) a;
System.out.println(b);
```

2. Can the following work without casting?

```java
byte a = 50;
byte b = 50;
byte c = a + b; // ?
```

3. What happens here?

```java
double d = 12.99;
int x = (int) d;
System.out.println(x);
```

---

## 10. References

* [Java Language Specification - Type Conversion](https://docs.oracle.com/javase/specs/)
* [Oracle Docs on Primitive Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)

```

---

Would you like me to export this `.md` file for you to download or keep in your system?
```
