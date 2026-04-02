Good—that’s actually the right move. But I’ll tighten this: for a **senior round**, they won’t give you LeetCode-style randoms—they’ll give **business-style problems disguised as coding**.

So here’s a **focused coding drill list**. No fluff. Solve these and you’ll be in a strong position.

---

# 🔥 🔹 CORE JAVA (Coding-Oriented)

### 🧪 Must Solve

1. Implement an **Immutable Class**

    * Fields: `id`, `name`, `List<String> roles`
    * Ensure deep copy

2. Implement **Singleton**:

    * Lazy
    * Thread-safe (Double Checked Locking)

3. Write a **custom class** and:

    * Override `equals()` and `hashCode()`
    * Use it as key in `HashMap`

4. Deep copy vs shallow copy:

    * Create object with nested object
    * Show difference via mutation

5. Create a **custom annotation** and process it using reflection

---

# 🔥 🔹 COLLECTIONS (High Impact)

### 🧪 Must Solve

1. Implement **LRU Cache**
   👉 (Hint: `LinkedHashMap` OR custom Doubly Linked List + HashMap)

2. Sort list of objects:

    * By 1 field
    * By multiple fields (salary desc, name asc)

3. Given list of employees:

    * Group by department
    * Find highest paid per department

4. Merge two maps:

   ```java
   Map<String, Integer>
   ```

   Handle duplicate keys (sum values)

5. Find **top K frequent elements**

6. Detect duplicate elements in list (efficient way)

7. Convert:

   ```java
   List<Employee> → Map<Department, List<Employee>>
   ```

8. Implement your own **HashMap (basic version)**
   👉 This is a senior-level differentiator

---

# 🔥 🔹 STREAMS (VERY IMPORTANT)

### 🧪 Must Solve (write in pure streams)

1. Find **second highest number**

2. Find **first non-repeating character**

3. Find **duplicate elements**

4. Flatten:

   ```java
   List<List<Integer>> → List<Integer>
   ```

5. Group employees:

    * By department
    * By salary range

6. Partition numbers:

    * Even vs odd

7. Convert list to map:

    * Handle duplicate keys

8. Find **frequency of each element**

9. Sort map by values

10. Find:

* Max salary employee
* Average salary per department

---

# 🔥 🔹 MULTITHREADING (CRITICAL)

### 🧪 Must Solve

1. Print:

   ```
   1 2 3 4 5...
   ```

   using **2 threads (odd/even)**

---

2. Implement **Producer-Consumer**

    * Using `wait()` / `notify()`
    * Then using `BlockingQueue`

---

3. Solve **Deadlock**

    * Create one
    * Then fix it

---

4. Create **Thread-safe counter**

    * Using:

        * `synchronized`
        * `AtomicInteger`

---

5. Implement **Custom Thread Pool (basic)**

---

6. Use:

    * `CountDownLatch`
    * `CyclicBarrier`

---

7. Parallel processing:

    * Process list using `ExecutorService`

---

8. Print in order using 3 threads:

   ```
   A B C A B C...
   ```

---

# 🔥 🔹 MIXED (REAL INTERVIEW STYLE)

These are GOLD. Don’t skip.

---

### 🧪 1. Transaction Log Problem

Input:

```java
List<String> logs = List.of(
  "user1 100",
  "user2 200",
  "user1 300"
);
```

Output:

```java
user1 → 400
user2 → 200
```

---

### 🧪 2. API Rate Limiter (Basic)

* Allow max N requests per user
* Use Map + timestamp logic

---

### 🧪 3. Sliding Window (Business style)

Find longest substring with **at most K distinct chars**

---

### 🧪 4. Data Aggregation

Given:

```java
List<Employee>
```

Find:

* Department → total salary
* Department → average salary

---

### 🧪 5. Log Processing (Streams + Map)

Find:

* Most active user
* Top 3 users

---

# ⚠️ How to Practice (This Matters More)

For each question:

👉 First write brute force
👉 Then optimize
👉 Then explain time/space complexity

---

# 🚀 Final Filter (Be Honest)

If you can do these **without Google + without IDE autocomplete**:

* LRU Cache
* Producer-Consumer
* Streams grouping + aggregation
* HashMap internals

👉 You are **interview-ready**

If not → focus there.

---

If you want next:
I can give you:

* **Top 10 questions Deloitte almost always asks (with traps)**
* OR we do a **live mock interview where I interrupt you like real panel**

Your call.
