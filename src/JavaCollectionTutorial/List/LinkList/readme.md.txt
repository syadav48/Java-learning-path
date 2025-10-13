Perfect 👍 — here’s your **complete, interview-friendly, easy-to-revise note** on **`LinkedList` in Java**, covering methods, concepts, and when to use it.

---

# 🧩 LinkedList in Java (Full Notes)

## 🧠 1️⃣ What is LinkedList?

**`LinkedList<E>`** is a **doubly linked list** implementation of the `List` and `Deque` interfaces in Java.
It allows:

* Dynamic memory allocation (no fixed size)
* Fast insertion/deletion (especially at head/tail)
* Sequential traversal (no random access like arrays)

**Package:** `java.util.LinkedList`
**Implements:** `List`, `Deque`, `Queue`, `Cloneable`, `Serializable`

---

## ⚙️ 2️⃣ Internal Structure

Each element (called a **Node**) has:

```java
class Node<E> {
    E data;
    Node<E> next;
    Node<E> prev;
}
```

✅ **Doubly Linked** → each node has references to previous and next nodes
✅ **No continuous memory block** → elements are scattered in memory

---

## 🧮 3️⃣ Key Characteristics

| Feature           | Description                                                       |
| ----------------- | ----------------------------------------------------------------- |
| **Order**         | Maintains insertion order                                         |
| **Duplicates**    | Allowed                                                           |
| **Null elements** | Allowed                                                           |
| **Thread safety** | Not synchronized (use `Collections.synchronizedList()` if needed) |
| **Traversal**     | Forward & backward using iterator or `ListIterator`               |
| **Access time**   | Slower than ArrayList (O(n)) for random access                    |
| **Insert/Delete** | Faster at head/tail (O(1))                                        |

---

## 🧩 4️⃣ Common Constructors

```java
LinkedList<Integer> list = new LinkedList<>();
LinkedList<String> names = new LinkedList<>(Arrays.asList("A", "B", "C"));
```

---

## 🛠️ 5️⃣ Important Methods (Categorized)

### 🔹 Basic List Methods (from `List` interface)

| Method                  | Description                        |
| ----------------------- | ---------------------------------- |
| `add(E e)`              | Add element at the end             |
| `add(int index, E e)`   | Add element at a specific index    |
| `get(int index)`        | Get element at index               |
| `set(int index, E e)`   | Replace element at index           |
| `remove(int index)`     | Remove element at index            |
| `remove(Object o)`      | Remove first occurrence of object  |
| `clear()`               | Remove all elements                |
| `size()`                | Returns number of elements         |
| `isEmpty()`             | Checks if list is empty            |
| `contains(Object o)`    | Checks if list contains an element |
| `indexOf(Object o)`     | Returns first index of object      |
| `lastIndexOf(Object o)` | Returns last index of object       |

---

### 🔹 Queue / Deque Specific Methods

| Method                 | Description                                              |
| ---------------------- | -------------------------------------------------------- |
| `addFirst(E e)`        | Add element at beginning                                 |
| `addLast(E e)`         | Add element at end                                       |
| `offer(E e)`           | Add element (return `true`/`false` instead of exception) |
| `offerFirst(E e)`      | Offer element at front                                   |
| `offerLast(E e)`       | Offer element at end                                     |
| `peek()`               | Get head (returns `null` if empty)                       |
| `peekFirst()`          | Get first element                                        |
| `peekLast()`           | Get last element                                         |
| `poll()`               | Retrieve and remove head                                 |
| `pollFirst()`          | Retrieve and remove first element                        |
| `pollLast()`           | Retrieve and remove last element                         |
| `removeFirst()`        | Remove first element                                     |
| `removeLast()`         | Remove last element                                      |
| `getFirst()`           | Get first element (throws exception if empty)            |
| `getLast()`            | Get last element (throws exception if empty)             |
| `push(E e)`            | Push element at head (like stack)                        |
| `pop()`                | Pop element from head                                    |
| `descendingIterator()` | Iterator in reverse order                                |

---

### 🔹 Iteration Methods

| Method                     | Description                        |
| -------------------------- | ---------------------------------- |
| `iterator()`               | Returns iterator from head to tail |
| `listIterator()`           | Returns bidirectional iterator     |
| `descendingIterator()`     | Returns reverse iterator           |
| `forEach(Consumer action)` | Applies action to each element     |

---

## 💡 6️⃣ When to Use LinkedList

| Scenario                                                 | Why LinkedList?                                              |
| -------------------------------------------------------- | ------------------------------------------------------------ |
| Frequent insertion/deletion (especially at start/middle) | O(1) insertion/deletion                                      |
| Queue or Stack implementation                            | Implements `Deque`, easy to use `addFirst()`, `removeLast()` |
| Need bidirectional traversal                             | `ListIterator` supports forward/backward                     |
| You don’t need random access                             | Access is O(n), so better for sequential access              |
| You want dynamic memory usage                            | No fixed size like arrays                                    |

---

## ⚠️ 7️⃣ When **NOT** to Use LinkedList

❌ When you need **random access** (use `ArrayList` instead)
❌ When memory is tight — LinkedList uses extra memory per node
❌ When you often sort/search large data — traversal is slower

---

## 🧠 8️⃣ Performance Comparison

| Operation         | ArrayList | LinkedList             |
| ----------------- | --------- | ---------------------- |
| **get(i)**        | O(1)      | O(n)                   |
| **add(E)**        | O(1)*     | O(1)                   |
| **add(index, E)** | O(n)      | O(n)                   |
| **remove(index)** | O(n)      | O(n), but O(1) at ends |
| **Memory**        | Compact   | Extra node overhead    |

(*Amortized)

---

## 🧰 9️⃣ Example Usages

### ➤ As a List

```java
LinkedList<String> list = new LinkedList<>();
list.add("A");
list.add("B");
list.add(1, "C");
System.out.println(list); // [A, C, B]
```

### ➤ As a Queue

```java
Queue<Integer> q = new LinkedList<>();
q.add(10);
q.add(20);
System.out.println(q.poll()); // 10
```

### ➤ As a Stack

```java
LinkedList<Integer> stack = new LinkedList<>();
stack.push(5);
stack.push(10);
System.out.println(stack.pop()); // 10
```

---

## 🧩 10️⃣ Key Points to Remember

* ✅ Doubly linked list — two pointers (`prev`, `next`)
* ✅ Implements both `List` and `Deque`
* ✅ Allows `null` and duplicates
* ✅ No capacity restriction
* ✅ Not synchronized
* ✅ Excellent for sequential access, bad for random access
* ✅ Common use cases: **Queue**, **Deque**, **Stack**

---

## 🚀 11️⃣ Summary Table

| Concept              | LinkedList                           |
| -------------------- | ------------------------------------ |
| Type                 | Doubly Linked                        |
| Implements           | List, Deque                          |
| Allows null          | Yes                                  |
| Thread-safe          | No                                   |
| Duplicate allowed    | Yes                                  |
| Access time          | O(n)                                 |
| Insert/Delete (ends) | O(1)                                 |
| Memory               | Higher                               |
| Use case             | Queue, Deque, frequent insert/delete |

---

Would you like me to give a **short 10-line revision sheet** (for exam/interview quick notes)?
It summarizes only the most important facts in a compact way.
