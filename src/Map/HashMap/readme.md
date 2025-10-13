Perfect 👏
Let’s now do a **deep dive into `HashMap`** — one of the most powerful and frequently used data structures in Java.
We’ll cover:
→ Concepts, internal working, hashing, time complexity, iteration, and real-world insights.

---

## 🧩 **What is `HashMap`?**

`HashMap<K,V>` is a **key–value based data structure** in Java’s `java.util` package.
It implements the **Map interface** and stores data in the form of:

```java
{ key1=value1, key2=value2, key3=value3 }
```

✅ **Key Features**

* Stores **unique keys**
* Allows **one null key** and multiple **null values**
* **Unordered** (no guarantee of insertion order)
* **Not thread-safe**
* **Fast** for insertions, deletions, and lookups (O(1) average)

---

## ⚙️ **How `HashMap` Works Internally**

Internally, a HashMap uses:

```java
Array + LinkedList (and later Tree)
```

Each element is stored as a **Node (or Entry)** object:

```java
class Node<K, V> {
    final int hash;
    final K key;
    V value;
    Node<K, V> next; // for collision handling
}
```

---

## 🧠 **Internal Steps When You Call `put(K key, V value)`**

Let’s say:

```java
map.put("Java", 10);
```

Here’s what happens:

1. **Hashing**

    * HashMap calls `hashCode()` on the key (`"Java".hashCode()`).
    * Hash value is then processed (using bitwise operations) to find an **index** in the array (called a **bucket**):

      ```java
      index = (hash & (n - 1))
      ```

      where `n` = number of buckets (default 16).

2. **Bucket Location**

    * The key-value pair is placed into that bucket.

3. **Collision Handling**

    * If another key has the same index (collision), they are linked in a **LinkedList** or **TreeNode** (if collisions are high).

4. **Replacement**

    * If the key already exists, its value is **replaced**.

5. **Rehashing**

    * When load factor > 0.75, HashMap **doubles** its capacity and rehashes entries.

---

## 🧩 **Hashing Function**

```java
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```

This ensures:

* Better distribution of hash codes (reduces collisions)
* Fast calculation of bucket index

---

## 🧮 **Time Complexity**

| Operation       | Average Case | Worst Case (many collisions)                        | Explanation                |
| --------------- | ------------ | --------------------------------------------------- | -------------------------- |
| `put()`         | O(1)         | O(log n) (after treeification) or O(n) (LinkedList) | Direct index via hash      |
| `get()`         | O(1)         | O(log n)                                            | Hash lookup                |
| `remove()`      | O(1)         | O(log n)                                            | Locate bucket, remove node |
| `containsKey()` | O(1)         | O(log n)                                            | Same as get                |
| Iteration       | O(n)         | O(n)                                                | Must traverse all entries  |

🔸 Since Java 8, **LinkedList of collisions → TreeMap (balanced BST)** when >8 entries, so worst case improves from O(n) to O(log n).

---

## 🧰 **Common Methods**

| Method                                | Description                    |
| ------------------------------------- | ------------------------------ |
| `put(K key, V value)`                 | Adds or updates key-value pair |
| `get(Object key)`                     | Returns value for key          |
| `remove(Object key)`                  | Removes entry                  |
| `containsKey(Object key)`             | Checks if key exists           |
| `containsValue(Object value)`         | Checks if value exists         |
| `keySet()`                            | Returns all keys               |
| `values()`                            | Returns all values             |
| `entrySet()`                          | Returns all key-value pairs    |
| `size()`                              | Returns number of entries      |
| `isEmpty()`                           | Checks if empty                |
| `clear()`                             | Removes all entries            |
| `getOrDefault(K key, V defaultValue)` | Returns value or default       |
| `putIfAbsent(K key, V value)`         | Adds only if absent            |
| `replace(K key, V newValue)`          | Replaces if exists             |
| `forEach(BiConsumer action)`          | Performs action for each entry |

---

## 🧩 **Example: Basic Usage**

```java
import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Java", 10);
        map.put("Python", 20);
        map.put("C++", 30);
        map.put("JavaScript", 40);

        System.out.println(map.get("Python")); // 20
        System.out.println(map.containsKey("C++")); // true
        System.out.println(map.size()); // 4
    }
}
```

---

## 🔁 **Iteration Examples**

### 1️⃣ For-Each using `entrySet()`

```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " => " + entry.getValue());
}
```

### 2️⃣ Using `keySet()`

```java
for (String key : map.keySet()) {
    System.out.println(key + " -> " + map.get(key));
}
```

### 3️⃣ Using `forEach()` with Lambda

```java
map.forEach((key, value) -> System.out.println(key + " : " + value));
```

### 4️⃣ Using Iterator

```java
Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
while (it.hasNext()) {
    Map.Entry<String, Integer> e = it.next();
    System.out.println(e.getKey() + " -> " + e.getValue());
}
```

---

## ⚔️ **HashMap vs Other Maps**

| Feature     | `HashMap`       | `LinkedHashMap`          | `TreeMap`     |
| ----------- | --------------- | ------------------------ | ------------- |
| Order       | Unordered       | Insertion order          | Sorted by key |
| Null keys   | ✅ 1 null key    | ✅ 1 null key             | ❌             |
| Thread-safe | ❌               | ❌                        | ❌             |
| Speed       | Fastest (O(1))  | Slightly slower          | O(log n)      |
| Use case    | General-purpose | Preserve insertion order | Sorted data   |

---

## 💡 **When to Use HashMap**

✅ Use when:

* You need fast lookup based on a unique key.
* You don’t care about ordering.
* You have frequent insertions/deletions.

❌ Avoid when:

* You need order (use `LinkedHashMap`).
* You need sorting (use `TreeMap`).
* Multiple threads modify (use `ConcurrentHashMap`).

---

## 🔐 **HashMap in Multi-threading**

`HashMap` is **not thread-safe**.
If multiple threads access and modify it simultaneously → data inconsistency.

✅ Use instead:

* `Collections.synchronizedMap(new HashMap<>())`
* `ConcurrentHashMap` (preferred for concurrency)

---

## 🧠 **Key Points to Remember**

1. Uses **hashing** to store & retrieve values quickly.
2. Allows **one null key** and **multiple null values**.
3. **Load factor** (default 0.75) controls rehashing frequency.
4. In Java 8+, buckets convert to **tree nodes** for fewer collisions.
5. **Fail-fast iterators** — modifying map during iteration throws `ConcurrentModificationException`.
6. Not synchronized — use **ConcurrentHashMap** in multi-threaded apps.

---

## 🧩 **Quick Example Showing Collision Handling**

```java
class Key {
    int id;
    Key(int id) { this.id = id; }

    @Override
    public int hashCode() {
        return 1; // Force collision!
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Key && ((Key) obj).id == this.id;
    }
}

public class CollisionExample {
    public static void main(String[] args) {
        HashMap<Key, String> map = new HashMap<>();
        map.put(new Key(1), "A");
        map.put(new Key(2), "B");
        map.put(new Key(3), "C");

        System.out.println(map); // Collisions handled via linked list / tree
    }
}
```

---

## 🧩 **Real-World Use Cases**

* Caching data (key: id, value: object)
* Counting frequency of words, items, etc.
  * Mapping usernames → user profiles
* Lookup tables in configuration
* Implementing memoization in dynamic programming

---

## 🧠 **Practice Questions**

1. Write a program to count the frequency of each word in a sentence using `HashMap`.
2. Given an array of integers, find duplicates using a `HashMap`.
3. Write a function that returns the first non-repeating character in a string using a `HashMap`.
4. Implement a simple **LRU cache** using `LinkedHashMap`.
5. Demonstrate a **collision scenario** and how HashMap handles it.

---

Would you like me to show a **visual diagram of HashMap internal working (bucket + hashing + collision)** to better understand the flow?
