Perfect — let’s master **`Vector` in Java** 🚀

This is one of the **most asked topics in Java collections**, especially when interviewers test your understanding of **legacy collections** vs **modern ones (ArrayList, LinkedList, etc.)**.

---

# 🧩 Vector in Java — Full Concept, Comparison, and Practice

---

## 🧠 1️⃣ What is `Vector`?

**`Vector<E>`** is a **dynamic array** that can grow or shrink in size.
It is **synchronized**, meaning it is **thread-safe** (only one thread can access it at a time).

* Belongs to **Legacy Collection Framework** (introduced in JDK 1.0)
* Later retrofitted to implement **`List`** interface in Java 2 (JDK 1.2)
* Stores elements in **contiguous memory**, like an `ArrayList`
* Slower than `ArrayList` in single-threaded programs (because of synchronization)

---

## ⚙️ 2️⃣ Basic Syntax

```java
Vector<Integer> vec = new Vector<>();
vec.add(10);
vec.add(20);
System.out.println(vec); // [10, 20]
```

✅ **Import required:**

```java
import java.util.Vector;
```

---

## 🧮 3️⃣ Key Characteristics

| Feature              | Description                                 |
| -------------------- | ------------------------------------------- |
| **Order**            | Maintains insertion order                   |
| **Duplicates**       | Allowed                                     |
| **Null elements**    | Allowed                                     |
| **Thread-safe**      | ✅ Yes (synchronized methods)                |
| **Dynamic capacity** | Doubles capacity automatically              |
| **Implements**       | List, RandomAccess, Cloneable, Serializable |

---

## 🧩 4️⃣ Vector Constructors

```java
Vector()                       // default capacity 10
Vector(int initialCapacity)
Vector(int initialCapacity, int capacityIncrement)
Vector(Collection<? extends E> c)
```

Example:

```java
Vector<String> names = new Vector<>(3, 2); // capacity 3, increases by 2 when full
```

---

## 🧰 5️⃣ Important Methods

| Method                            | Description                |
| --------------------------------- | -------------------------- |
| `add(E e)`                        | Add element at end         |
| `add(int index, E e)`             | Add at specific position   |
| `get(int index)`                  | Get element                |
| `set(int index, E e)`             | Replace element            |
| `remove(int index)`               | Remove element             |
| `remove(Object o)`                | Remove first occurrence    |
| `size()`                          | Number of elements         |
| `capacity()`                      | Returns current capacity   |
| `firstElement()`                  | Get first element          |
| `lastElement()`                   | Get last element           |
| `clear()`                         | Remove all                 |
| `contains(Object o)`              | Check if element exists    |
| `ensureCapacity(int minCapacity)` | Manually increase capacity |
| `trimToSize()`                    | Reduce capacity to size    |

---

## ⚖️ 6️⃣ Vector vs ArrayList — Key Differences

| Feature             | **Vector**                                | **ArrayList**              |
| ------------------- | ----------------------------------------- | -------------------------- |
| **Synchronization** | ✅ Synchronized (thread-safe)              | ❌ Not synchronized         |
| **Performance**     | Slower (because of locks)                 | Faster                     |
| **Growth Rate**     | Doubles (100%)                            | Increases by 50%           |
| **Legacy?**         | ✅ Yes (pre-Java 2)                        | ❌ No                       |
| **Use Case**        | Multithreaded apps                        | Single-threaded apps       |
| **Iteration**       | `Enumeration`, `Iterator`, `ListIterator` | `Iterator`, `ListIterator` |

---

## 💡 7️⃣ When to Use What?

| Situation                           | Use                                                                     |
| ----------------------------------- | ----------------------------------------------------------------------- |
| Single-threaded program             | ✅ Use `ArrayList` (faster)                                              |
| Multi-threaded (need thread safety) | ✅ Use `Vector`                                                          |
| Want controlled synchronization     | Use `Collections.synchronizedList(new ArrayList<>())` instead of Vector |
| Need legacy system compatibility    | Use `Vector`                                                            |

---

## 🧩 8️⃣ Example to Differentiate

```java
import java.util.*;

public class VectorVsArrayList {
    public static void main(String[] args) {
        // ArrayList (not thread-safe)
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        // Vector (thread-safe)
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);

        // Checking capacity
        System.out.println("ArrayList size: " + arrayList.size());
        System.out.println("Vector size: " + vector.size());
        System.out.println("Vector capacity: " + vector.capacity());

        // Access elements
        System.out.println("Vector first element: " + vector.firstElement());

        // Remove example
        vector.remove(1);
        System.out.println("Vector after remove: " + vector);

        // Synchronization demonstration
        synchronized (vector) {
            for (int i : vector) {
                System.out.println("Iterating safely: " + i);
            }
        }
    }
}
```

🧾 Output:

```
ArrayList size: 3
Vector size: 3
Vector capacity: 10
Vector first element: 1
Vector after remove: [1, 3]
Iterating safely: 1
Iterating safely: 3
```

---

## 🧠 9️⃣ Key Points to Remember

* Vector is **thread-safe**, but **slower**.
* Grows dynamically by **doubling capacity**.
* Use `Enumeration` for old-style traversal.
* In modern Java, prefer **ArrayList** or **CopyOnWriteArrayList** instead.
* You can synchronize an `ArrayList` manually using:

  ```java
  List<Integer> list = Collections.synchronizedList(new ArrayList<>());
  ```

---

## 🧩 🔟 5 Intermediate Practice Problems (Vector Only)

### 🧮 1️⃣ Reverse a Vector

Write a program to reverse elements of a vector **without using Collections.reverse()**.

> Input: [10, 20, 30, 40, 50]
> Output: [50, 40, 30, 20, 10]

---

### 🧮 2️⃣ Remove Duplicates from a Vector

Given a vector, remove all duplicate elements.

> Input: [1, 2, 3, 2, 4, 1]
> Output: [1, 2, 3, 4]

---

### 🧮 3️⃣ Find Maximum and Minimum Element in a Vector

Without using Collections.max(), Collections.min().

> Input: [12, 5, 7, 9, 1]
> Output: Max = 12, Min = 1

---

### 🧮 4️⃣ Merge Two Vectors

Combine two vectors into one **without duplicates**.

> Input: [1, 2, 3] and [3, 4, 5]
> Output: [1, 2, 3, 4, 5]

---

### 🧮 5️⃣ Implement Stack Using Vector

Use Vector’s `push()`, `pop()`, and `peek()` to create a simple stack structure.

> Push elements, pop last, and print the current stack.

---

Would you like me to give **code solutions** for the 5 problems (each concise and commented)?
It’ll help you practice Vector manipulation deeply and prepare for coding interviews.
