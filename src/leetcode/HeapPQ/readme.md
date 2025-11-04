Perfect 👍 You’re asking for one of the most powerful DSA tools — **Min Heap / Priority Queue** — used in countless LeetCode and interview problems (like Kth Largest, Top K Elements, Merge K Lists, Dijkstra, etc.).

Here’s a complete, well-structured **Markdown (`.md`) notes file** — formatted so you can directly save it as `Heap_Notes.md` for quick revision and LeetCode prep 👇

---

# 🧠 **Heap (Priority Queue) — Complete Notes for DSA & LeetCode**

---

## 🔹 What is a Heap?

A **Heap** is a **complete binary tree** (all levels filled except possibly the last, which is filled left to right) that satisfies the **Heap Property**.

### Types:

* **Min Heap** → The parent node is **smaller than or equal** to its children.
* **Max Heap** → The parent node is **greater than or equal** to its children.

---

## 🔹 Example:

### Min Heap:

```
       2
     /   \
    5     8
   / \
  10  9
```

Property: Every parent ≤ children.

### Max Heap:

```
       10
     /    \
    9      5
   / \
  2   8
```

Property: Every parent ≥ children.

---

## 🔹 PriorityQueue in Java

In Java, `PriorityQueue<E>` implements a **Min Heap** by default.

### Import:

```java
import java.util.PriorityQueue;
```

### Declaration:

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```

---

## 🔹 Basic Operations (All O(log n))

| Operation          | Description                      | Code            | Time Complexity |
| ------------------ | -------------------------------- | --------------- | --------------- |
| Insert (add/offer) | Add element to heap              | `pq.offer(x);`  | O(log n)        |
| Remove min/max     | Remove top element               | `pq.poll();`    | O(log n)        |
| Peek               | Get top element without removing | `pq.peek();`    | O(1)            |
| Size               | Get size                         | `pq.size();`    | O(1)            |
| Is empty           | Check emptiness                  | `pq.isEmpty();` | O(1)            |

---

## 🔹 Internal Working

✅ **Heap is backed by an array**.
For index `i`:

* Left child → `2*i + 1`
* Right child → `2*i + 2`
* Parent → `(i - 1)/2`

Heap property maintained by:

* **Heapify-up (sift-up)** after insertion
* **Heapify-down (sift-down)** after deletion

---

## 🔹 Min Heap vs Max Heap

| Operation       | Min Heap                | Max Heap                                          |
| --------------- | ----------------------- | ------------------------------------------------- |
| `peek()`        | Smallest element        | Largest element                                   |
| Default in Java | ✅ Yes                   | ❌ No                                              |
| Create          | `new PriorityQueue<>()` | `new PriorityQueue<>(Collections.reverseOrder())` |

---

## 🔹 Common Patterns in Problems

### 🧩 1. **Kth Largest Element**

Keep a **Min Heap** of size `k`.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

for (int num : nums) {
    pq.offer(num);
    if (pq.size() > k)
        pq.poll();
}
return pq.peek();
```

→ Heap always contains k largest numbers; top = kth largest.

---

### 🧩 2. **Kth Smallest Element**

Keep a **Max Heap** of size `k`.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

for (int num : nums) {
    pq.offer(num);
    if (pq.size() > k)
        pq.poll();
}
return pq.peek();
```

---

### 🧩 3. **Top K Frequent Elements**

Use Min Heap + HashMap.

```java
Map<Integer, Integer> freq = new HashMap<>();
for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

for (int key : freq.keySet()) {
    pq.offer(new int[]{key, freq.get(key)});
    if (pq.size() > k)
        pq.poll();
}
```

---

### 🧩 4. **Merge K Sorted Lists / Arrays**

Use Min Heap to track smallest current element among lists.

```java
PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
```

---

### 🧩 5. **Find Median from Data Stream**

Use **Two Heaps**:

* Max Heap (lower half)
* Min Heap (upper half)

Keep sizes balanced so median is easy to extract.

---

## 🔹 When to Use a Heap

| Situation                         | Use Heap Type   |
| --------------------------------- | --------------- |
| Need smallest/largest quickly     | Min/Max Heap    |
| Maintain running order statistics | Two Heaps       |
| Merge sorted streams              | Min Heap        |
| Scheduling tasks / shortest path  | Min Heap        |
| Kth largest / smallest problems   | Min or Max Heap |
| Priority-based queueing           | Min Heap        |

---

## 🔹 Complexity Summary

| Operation             | Time     | Space |
| --------------------- | -------- | ----- |
| Insertion             | O(log n) | O(n)  |
| Deletion              | O(log n) | O(n)  |
| Get min/max           | O(1)     | O(1)  |
| Build heap from array | O(n)     | O(n)  |

---

## 🔹 Tricks and Gotchas 💡

1. **Default = Min Heap**

    * Use `Collections.reverseOrder()` for Max Heap.

2. **Custom Object?**

    * Implement comparator manually:

      ```java
      PriorityQueue<Person> pq = new PriorityQueue<>(
          (a, b) -> a.age - b.age
      );
      ```

3. **Never modify elements inside heap directly.**

    * Remove and reinsert instead.

4. **Heapify** an existing list:

   ```java
   PriorityQueue<Integer> pq = new PriorityQueue<>(list);
   ```

5. **Iterating a heap** does *not* return elements in sorted order.

6. **Build heap from array in O(n)**:

    * Using Floyd’s algorithm (bottom-up heapify).

---

## 🔹 Visualization of Min Heap (Insertion)

Suppose inserting `[5, 3, 8, 1]` one by one:

| Step     | Heap Array   | Tree       |
| -------- | ------------ | ---------- |
| Insert 5 | [5]          | (5)        |
| Insert 3 | [3, 5]       | 3→5 (swap) |
| Insert 8 | [3, 5, 8]    | balanced   |
| Insert 1 | [1, 3, 8, 5] | 1→root     |

---

## 🔹 Real-World Uses

* Dijkstra’s shortest path
* Prim’s MST
* Huffman encoding
* Job scheduling
* Event simulation
* Load balancing systems

---

## 🔹 Java PriorityQueue Cheat Sheet

```java
// Create
PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap
PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder()); // max-heap

// Insert
pq.offer(10);
pq.add(20);

// Access
int top = pq.peek(); // min element

// Remove
pq.poll(); // removes min element

// Size
pq.size();

// Custom Comparator
PriorityQueue<int[]> pqArr = new PriorityQueue<>((a, b) -> a[1] - b[1]);
```

---

## 🧩 Quick LeetCode Problems to Practice

| Problem                              | Type               | Difficulty |
| ------------------------------------ | ------------------ | ---------- |
| 703. Kth Largest Element in a Stream | Min Heap           | Easy       |
| 215. Kth Largest Element in an Array | Min Heap           | Medium     |
| 347. Top K Frequent Elements         | Min Heap + HashMap | Medium     |
| 973. K Closest Points to Origin      | Max Heap           | Medium     |
| 23. Merge k Sorted Lists             | Min Heap           | Hard       |
| 295. Find Median from Data Stream    | Two Heaps          | Hard       |
| 451. Sort Characters by Frequency    | Max Heap           | Medium     |
| 1046. Last Stone Weight              | Max Heap           | Easy       |

---

## 🧩 Interview Insight

* Heaps are about **"getting something quickly but maintaining order implicitly"**.
* Think of it as **“sorted but lazy”** → you don’t keep entire data sorted, just enough to get the smallest/largest when needed.
* **Common question trigger words:**

    * "Kth largest/smallest"
    * "Top K"
    * "Stream of numbers"
    * "Merge sorted"
    * "Running median"

---

## 🏁 Summary

| Concept                 | Key Point                            |
| ----------------------- | ------------------------------------ |
| Heap Type               | Min / Max                            |
| Default in Java         | Min Heap                             |
| Data Structure          | Complete Binary Tree                 |
| Internal Representation | Array                                |
| Most Common Operation   | Insert, Poll, Peek                   |
| Best Use Case           | Kth largest/smallest, Top K problems |
| Time Complexity         | O(log n) per insert/remove           |
| Space Complexity        | O(n)                                 |

---

## 📘 References

* [Java PriorityQueue Docs](https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html)
* [LeetCode Heap Tag](https://leetcode.com/tag/heap/)
* [CP Handbook — Heaps](https://cp-algorithms.com/data_structures/heap.html)

---

Would you like me to extend this Markdown file with a **“Custom Object Heap Examples” section** (like sorting by age, frequency, or distance)?
It’s super helpful for advanced LeetCode problems (like K closest points, or frequency-based problems).
