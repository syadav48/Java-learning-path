Here’s a **well-structured note** on Java Strings based on what you gave plus some important extra details so it becomes a **complete reference**.

---

## **Java Strings – Complete Notes**

### 1. **Character & String Representation**

* **`char`** in Java → Enclosed in **single quotes (`'`)**
  Example:

  ```java
  char c = 'A';
  ```
* **String** in Java → Enclosed in **double quotes (`"`)**
  Example:

  ```java
  String str = "Hello";
  ```

---

### 2. **String as a Class**

* `String` is a **final class** in `java.lang` package.
* Strings in Java are **immutable** (cannot be changed once created).
* Two ways to create a String:

  1. **String literal**:

     ```java
     String s1 = "Surya"; // stored in String Constant Pool (SCP)
     ```
  2. **Using `new` keyword**:

     ```java
     String s2 = new String("Surya"); // stored in Heap memory (outside SCP)
     ```

---

### 3. **String Pool, Stack, and Heap Memory**

* **String Constant Pool (SCP)** is a special part of the Heap where string literals are stored.
* When you write:

  ```java
  String s1 = "Surya";
  String s2 = "Surya";
  ```

  → `s1` and `s2` both point to the **same object** in SCP.
  → `s1 == s2` → **true** (same reference in SCP).
* But:

  ```java
  String s3 = new String("Surya");
  ```

  → Creates a **new object** in Heap, so `s1 == s3` → **false**.

---

### 4. **String Immutability & Memory Justification**

* Example:

  ```java
  String name = "Surya"; // name → address A in SCP
  name = "Surya Yadav";  // name → new address B in SCP
  ```

  * Original `"Surya"` still exists in SCP (if no variable references it, eligible for GC).
  * Java **avoids multiple objects with same content** by reusing existing strings from SCP (memory optimization).

---

### 5. **String Concatenation & Operators**

* **`+` operator**:

  ```java
  String s = "Hello" + " World"; // Compiler optimizes and creates single object
  ```
* **Other operators**: `+=` can be used.
* When concatenating inside loops → **inefficient**, because each change creates a **new object** (use `StringBuilder` or `StringBuffer`).

---

### 6. **Mutable Strings**

Immutable strings cannot be modified → use mutable classes:

1. **StringBuffer** (Thread-safe, synchronized)
2. **StringBuilder** (Not thread-safe, faster)

---

### 7. **StringBuffer**

* **Thread-safe** (methods synchronized).
* **Capacity**:

  ```java
  StringBuffer sb = new StringBuffer();
  System.out.println(sb.capacity()); // 16 by default
  ```

  → Extra 16 spaces are allocated initially to **reduce reallocation cost**.
* **Common methods**:

  * `append(String s)`
  * `insert(int offset, String s)`
  * `replace(int start, int end, String s)`
  * `delete(int start, int end)`
  * `reverse()`
  * `capacity()`
  * `length()`

**Example**:

```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");
System.out.println(sb); // Hello World
```

---

### 8. **StringBuilder**

* Same as `StringBuffer` but **not synchronized** → **faster** in single-threaded operations.
* Same methods as `StringBuffer`.
* **Example**:

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" Java");
System.out.println(sb); // Hello Java
```

---

### 9. **String vs StringBuffer vs StringBuilder**

| Feature           | String                      | StringBuffer                        | StringBuilder                  |
| ----------------- | --------------------------- | ----------------------------------- | ------------------------------ |
| **Mutability**    | Immutable                   | Mutable                             | Mutable                        |
| **Thread Safety** | Yes                         | Yes                                 | No                             |
| **Performance**   | Slow (new object each time) | Slower than Builder (sync overhead) | Fastest                        |
| **Use case**      | Fixed data                  | Multi-threaded mutable string       | Single-threaded mutable string |

---

### 10. **Important String Methods**

| Method                            | Description                  |
| --------------------------------- | ---------------------------- |
| `length()`                        | Returns string length        |
| `charAt(int index)`               | Returns character at index   |
| `substring(int start)`            | Returns substring from index |
| `substring(int start, int end)`   | Returns substring in range   |
| `indexOf(String str)`             | First occurrence index       |
| `lastIndexOf(String str)`         | Last occurrence index        |
| `equals(Object o)`                | Compares content             |
| `equalsIgnoreCase(String s)`      | Compares ignoring case       |
| `compareTo(String s)`             | Lexicographic comparison     |
| `toLowerCase()` / `toUpperCase()` | Changes case                 |
| `trim()`                          | Removes spaces at both ends  |
| `replace(char old, char new)`     | Replaces character           |
| `split(String regex)`             | Splits string                |
| `contains(CharSequence s)`        | Checks substring presence    |
| `isEmpty()`                       | Checks if empty              |

---

### 11. **Key Points to Remember**

* Strings are **immutable** → safer in multi-threading.
* Use **StringBuilder** for heavy string operations in single-threaded code.
* Use **StringBuffer** for multi-threaded environments.
* SCP ensures **memory optimization** by avoiding duplicate string literals.

---

If you want, I can **add a memory diagram** showing how String literal, `new` keyword, and heap/SCP references work. That would make these notes **visually clear**.
