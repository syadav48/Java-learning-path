Excellent — let’s break down **Immutable Maps** in Java, including `Map.of()` and `Map.ofEntries()` methods 👇

---

## 🧩 **What is an Immutable Map?**

An **immutable map** is a map whose **entries cannot be modified** after creation.

That means:
✅ You can **read** from it.
❌ But you **cannot add**, **remove**, or **update** any key-value pairs.

In Java, immutable maps were introduced in **Java 9** using:

* `Map.of(...)`
* `Map.ofEntries(...)`

---

## ⚙️ **Why Immutable Maps?**

They are:

* **Thread-safe** (no synchronization needed since no modification possible)
* **Lightweight and memory-efficient**
* **Safe for constants/configurations**

---

## 🧠 **Example: Creating Immutable Map**

### ✅ Using `Map.of()`

```java
import java.util.Map;

public class ImmutableMapExample {
    public static void main(String[] args) {
        Map<String, Integer> marks = Map.of(
            "Math", 90,
            "Science", 85,
            "English", 80
        );

        System.out.println(marks);

        // marks.put("History", 70); // ❌ Throws UnsupportedOperationException
    }
}
```

**Output:**

```
{Math=90, Science=85, English=80}
```

---

## 🧩 **Using `Map.ofEntries()`**

When you have **more than 10 entries** or want **flexibility**, use `Map.ofEntries()`.

```java
import java.util.Map;
import java.util.Map.Entry;

public class ImmutableMapEntries {
    public static void main(String[] args) {
        Map<String, String> countries = Map.ofEntries(
            Map.entry("IN", "India"),
            Map.entry("US", "United States"),
            Map.entry("JP", "Japan")
        );

        System.out.println(countries);
    }
}
```

**Output:**

```
{IN=India, US=United States, JP=Japan}
```

---

## 🔐 **Limitations of Immutable Maps**

| Limitation                      | Description                                                           |
| ------------------------------- | --------------------------------------------------------------------- |
| ❌ **No modification**           | Cannot add, remove, or replace elements                               |
| ❌ **No null keys or values**    | Throws `NullPointerException`                                         |
| ❌ **Fixed size**                | Once created, can’t change                                            |
| ⚠️ **Shallow immutability**     | Only the map itself is immutable; objects inside may still be mutable |
| ⚠️ **No custom implementation** | Can’t change internal ordering or hashing                             |
| ⚠️ **Java 9+ only**             | Older Java versions don’t support `Map.of()`                          |

---

## 🧩 **Differences: `Map.of()` vs `Map.ofEntries()`**

| Feature     | `Map.of()`                   | `Map.ofEntries()`                                   |
| ----------- | ---------------------------- | --------------------------------------------------- |
| Syntax      | `Map.of(k1,v1,k2,v2,...)`    | `Map.ofEntries(Map.entry(k1,v1), Map.entry(k2,v2))` |
| Max entries | Up to **10** key-value pairs | **Unlimited**                                       |
| Use case    | Small, quick maps            | Larger or dynamic maps                              |
| Readability | Compact                      | More flexible                                       |

---

## ⚙️ **Under the Hood**

Internally, these maps are implemented using **compact, immutable data structures** (via `ImmutableCollections`) — no hashing table like in `HashMap`.
Because they are fixed, the runtime can optimize storage and access.

---

## ⚡ **Time Complexity**

| Operation          | Complexity |
| ------------------ | ---------- |
| `get(key)`         | **O(1)**   |
| `containsKey(key)` | **O(1)**   |
| `iteration`        | **O(n)**   |

---

## 🧩 **Practical Use Cases**

✅ Configuration constants
✅ Default lookup tables
✅ Caching fixed data
✅ Thread-safe shared read-only data

### Example:

```java
public class Config {
    public static final Map<String, String> SETTINGS = Map.of(
        "ENV", "PROD",
        "VERSION", "1.0.2",
        "TIMEZONE", "UTC"
    );
}
```

---

## 🧠 **Key Points to Remember**

* Immutable maps are **read-only and thread-safe**.
* Created via **`Map.of()`** or **`Map.ofEntries()`** (Java 9+).
* **Nulls are not allowed**.
* **Cannot modify** after creation.
* Great for **constants/configs**, not for dynamic data.
* For older JDKs: use `Collections.unmodifiableMap()`.

---

Would you like me to also include a short comparison between
👉 `Collections.unmodifiableMap()` **vs** `Map.of()` (since both give immutability but in different ways)?
