Excellent — now you’re diving into **SortedMap**, **TreeMap**, and **NavigableMap**, which form the backbone of **sorted collections** in Java’s `java.util` package.
Let’s break this down step-by-step with complete clarity 👇

---

## 🔹 1. What is a SortedMap?

**Definition:**
`SortedMap<K,V>` is an interface that extends `Map<K,V>` and **maintains keys in sorted order**.

**Implemented by:** `TreeMap` (most common), and `ConcurrentSkipListMap` (thread-safe version).

### ➤ Declaration:

```java
SortedMap<Integer, String> map = new TreeMap<>();
```

### ➤ Key Properties:

* Keys are sorted **according to their natural ordering** (if keys are Comparable).
* Or, you can provide a **custom Comparator** at TreeMap creation.
* Duplicate keys are **not allowed**.
* Null keys are **not allowed** (throws `NullPointerException`).

---

## 🔹 2. Methods in `SortedMap`

| Method                                      | Description                                                                       |
| ------------------------------------------- | --------------------------------------------------------------------------------- |
| `Comparator<? super K> comparator()`        | Returns the comparator used for ordering keys, or `null` if natural order.        |
| `K firstKey()`                              | Returns the **lowest key**.                                                       |
| `K lastKey()`                               | Returns the **highest key**.                                                      |
| `SortedMap<K,V> headMap(K toKey)`           | Returns a view of keys **less than toKey**.                                       |
| `SortedMap<K,V> tailMap(K fromKey)`         | Returns a view of keys **greater than or equal to fromKey**.                      |
| `SortedMap<K,V> subMap(K fromKey, K toKey)` | Returns a view of keys **between fromKey (inclusive)** and **toKey (exclusive)**. |

---

### 🧠 Example:

```java
import java.util.*;

public class SortedMapExample {
    public static void main(String[] args) {
        SortedMap<Integer, String> map = new TreeMap<>();

        map.put(3, "C");
        map.put(1, "A");
        map.put(4, "D");
        map.put(2, "B");

        System.out.println("SortedMap: " + map);
        System.out.println("First Key: " + map.firstKey());
        System.out.println("Last Key: " + map.lastKey());
        System.out.println("Head Map (<3): " + map.headMap(3));
        System.out.println("Tail Map (>=3): " + map.tailMap(3));
        System.out.println("Sub Map (2 to 4): " + map.subMap(2, 4));
    }
}
```

### ➤ Output:

```
SortedMap: {1=A, 2=B, 3=C, 4=D}
First Key: 1
Last Key: 4
Head Map (<3): {1=A, 2=B}
Tail Map (>=3): {3=C, 4=D}
Sub Map (2 to 4): {2=B, 3=C}
```

---

## 🔹 3. TreeMap and Sorting with Comparable & Comparator

### ✅ Using Comparable (Natural Ordering)

If keys implement `Comparable` (like Integer, String):

```java
TreeMap<Integer, String> map = new TreeMap<>();
// Keys will be sorted in ascending order automatically
```

### ✅ Using Comparator (Custom Ordering)

You can define **descending order** or **custom logic**:

```java
TreeMap<Integer, String> map = new TreeMap<>((a, b) -> b - a); // descending order
map.put(3, "C");
map.put(1, "A");
map.put(2, "B");

System.out.println(map); // {3=C, 2=B, 1=A}
```

---

## 🔹 4. Time Complexity in TreeMap (and SortedMap)

TreeMap is based on a **Red-Black Tree (self-balancing BST)**.

| Operation                 | Time Complexity |
| ------------------------- | --------------- |
| `put()`                   | O(log n)        |
| `get()`                   | O(log n)        |
| `remove()`                | O(log n)        |
| `containsKey()`           | O(log n)        |
| `firstKey()`, `lastKey()` | O(log n)        |
| `headMap()`, `tailMap()`  | O(log n)        |
| Iteration over keys       | O(n)            |

---

## 🔹 5. NavigableMap (Enhanced SortedMap)

**NavigableMap<K,V>** extends `SortedMap<K,V>`
and provides **navigation methods** (to find nearest keys).

**Implemented by:** `TreeMap`

### ➤ Methods:

| Method                               | Description                           |
| ------------------------------------ | ------------------------------------- |
| `K lowerKey(K key)`                  | Greatest key < given key              |
| `K floorKey(K key)`                  | Greatest key ≤ given key              |
| `K ceilingKey(K key)`                | Smallest key ≥ given key              |
| `K higherKey(K key)`                 | Smallest key > given key              |
| `Map.Entry<K,V> pollFirstEntry()`    | Removes and returns the lowest entry  |
| `Map.Entry<K,V> pollLastEntry()`     | Removes and returns the highest entry |
| `NavigableSet<K> descendingKeySet()` | Returns keys in reverse order         |
| `NavigableMap<K,V> descendingMap()`  | Returns reversed order map            |

---

### 🧠 Example:

```java
import java.util.*;

public class NavigableMapExample {
    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();

        map.put(10, "A");
        map.put(20, "B");
        map.put(30, "C");
        map.put(40, "D");
        map.put(50, "E");

        System.out.println("Map: " + map);
        System.out.println("Lower Key (30): " + map.lowerKey(30));
        System.out.println("Floor Key (30): " + map.floorKey(30));
        System.out.println("Ceiling Key (35): " + map.ceilingKey(35));
        System.out.println("Higher Key (30): " + map.higherKey(30));

        System.out.println("Descending Map: " + map.descendingMap());
        System.out.println("Poll First Entry: " + map.pollFirstEntry());
        System.out.println("After pollFirstEntry: " + map);
    }
}
```

### ➤ Output:

```
Map: {10=A, 20=B, 30=C, 40=D, 50=E}
Lower Key (30): 20
Floor Key (30): 30
Ceiling Key (35): 40
Higher Key (30): 40
Descending Map: {50=E, 40=D, 30=C, 20=B, 10=A}
Poll First Entry: 10=A
After pollFirstEntry: {20=B, 30=C, 40=D, 50=E}
```

---

## 🔹 6. When to Use TreeMap / SortedMap / NavigableMap in Applications

✅ Use **TreeMap / SortedMap** when:

* You need **keys in sorted order** (e.g., alphabetical, numerical).
* You need **range queries** (`subMap`, `headMap`, `tailMap`).
* You need **nearest key lookups** (`floorKey`, `ceilingKey`).

✅ **Real-World Example (Caching / Leaderboard / Scheduling)**:

* Leaderboard: Store player scores → get top N players using `descendingMap()`.
* Time-based scheduler: Store timestamps → use `ceilingKey()` for next task.
* Cache eviction: Combine with `LinkedHashMap` or `TreeMap` for ordering by time.

---

## 🔹 7. Summary Table

| Feature         | SortedMap                                             | NavigableMap                            | TreeMap         |
| --------------- | ----------------------------------------------------- | --------------------------------------- | --------------- |
| Interface       | ✅                                                     | ✅ (extends SortedMap)                   | Implementation  |
| Maintains Order | Yes                                                   | Yes                                     | Yes             |
| Allows Null Key | ❌                                                     | ❌                                       | ❌               |
| Methods         | `firstKey`, `lastKey`, `headMap`, `tailMap`, `subMap` | All from SortedMap + navigation methods | Implements both |
| Time Complexity | O(log n)                                              | O(log n)                                | O(log n)        |
| Backed by       | Red-Black Tree                                        | Red-Black Tree                          | Red-Black Tree  |

---

Would you like me to add an example of **using TreeMap as a cache eviction (LRU)** using `LinkedHashMap` + `TreeMap` hybrid logic (common interview question)?
