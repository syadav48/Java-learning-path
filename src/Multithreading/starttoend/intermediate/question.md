Good—now we move from “syntax” to **real coordination + design problems**.
At this level, questions start mixing concepts (locks + executors + futures, etc.).

I’ll give you **intermediate-level problems**, still 2 per topic, but now:

* more realistic
* slightly tricky
* closer to interviews

---

# 🔒 1. Synchronization (beyond simple counter)

### Q1 — Thread-safe Singleton Counter

Create a class:

* `increment()` method
* `getCount()` method
  Ensure:
* Thread-safe
* No race condition
* Lazy initialization of object

👉 Hint: combine **Singleton + synchronized**

---

### Q2 — Print Numbers in Order (1 → N)

3 threads:

* T1 prints numbers divisible by 3
* T2 prints numbers divisible by 5
* T3 prints remaining numbers

👉 Output must be **in sequence (1 → N)**
👉 Requires coordination + synchronization

---

# ⏳ 2. wait() / notify() (coordination problems)

### Q1 — Bounded Buffer (Advanced Producer-Consumer)

Extend your previous solution:

* Multiple producers (2)
* Multiple consumers (2)
* Capacity = 5
  Ensure:
* No data loss
* No deadlock

---

### Q2 — Print 1–100 with 3 Threads

3 threads:

* Thread A → prints 1–33
* Thread B → prints 34–66
* Thread C → prints 67–100

👉 Must print in order (1 → 100)
👉 Use wait/notify (not join)

---

# 🔐 3. ReentrantLock (more control)

### Q1 — Fair Lock Simulation

Use `ReentrantLock(true)` (fair lock):

* 3 threads trying to access resource
* Print order of execution

👉 Observe fairness vs non-fair lock

---

### Q2 — TryLock with Timeout

Two threads:

* Both try to access same resource
* Use `tryLock(2 sec)`

👉 If lock not acquired:

* Print `"Skipping execution"`

---

# 🧰 4. Executor Framework (real-world usage)

### Q1 — Fixed Thread Pool Task Processing

* Create pool of size 3
* Submit 10 tasks
* Each task prints:

    * Task ID
    * Thread name

👉 Observe thread reuse

---

### Q2 — Task Dependency

* Task A → returns result after 2 sec
* Task B → depends on A

👉 Use ExecutorService + Future
👉 Ensure B starts only after A completes

---

# 🔮 5. Future (intermediate usage)

### Q1 — Parallel Sum

* Split array into 2 halves
* Use 2 threads (Callable)
* Combine results using `Future.get()`

---

### Q2 — Timeout Handling

* Submit long-running task (5 sec)
* Try to get result with timeout (2 sec)

👉 Handle `TimeoutException`

---

# ⚡ 6. CompletableFuture (important 🔥)

### Q1 — Async Pipeline

* Step 1 → fetch number
* Step 2 → multiply by 2
* Step 3 → convert to string

👉 Use:

```id="wq4s3y"
thenApply()
thenAccept()
```

---

### Q2 — Combine Multiple Services (Real-world)

Simulate:

* API 1 → returns user info
* API 2 → returns order info

👉 Run both in parallel
👉 Combine results using `thenCombine()`

---

# 🔄 7. Thread Coordination (classic interview patterns)

### Q1 — FizzBuzz Multithreaded 🔥

4 threads:

* fizz → prints "Fizz"
* buzz → prints "Buzz"
* fizzbuzz → prints "FizzBuzz"
* number → prints numbers

👉 Print from 1–100 correctly

---

### Q2 — Alternating Sequence (Odd/Even Advanced)

2 threads:

* Print numbers 1–100
* Must strictly alternate
* Add delay to simulate real work

---

# 🔥 8. Deadlock & Avoidance (VERY important)

### Q1 — Create Deadlock

* Two resources (Lock A, Lock B)
* Thread 1 → A → B
* Thread 2 → B → A

👉 Demonstrate deadlock

---

### Q2 — Fix Deadlock

Solve above using:

* Lock ordering OR
* tryLock()

---

# 🧠 9. Thread-safe Collections

### Q1

Use:

* `Collections.synchronizedList()`

Multiple threads:

* Add + remove elements

---

### Q2

Use:

* `ConcurrentHashMap`

Threads:

* Insert key-value pairs concurrently
* Read safely

---

# ⚠️ Mentor Guidance (Important)

Now rules change:

👉 Don’t just “make it work”
Start asking:

* Can this deadlock?
* Can this starve?
* Is it scalable?
* Can I replace this with Executor?

---

# 🧭 Suggested Order

Do in this order:

1. Executor + Future
2. CompletableFuture
3. ReentrantLock
4. wait/notify advanced
5. Deadlock
6. FizzBuzz (hard coordination)

---

# 💬 Next Step

Pick **one problem**, implement it, and send me code.

I’ll:

* Review like interviewer
* Point hidden bugs
* Suggest better design (not just fix)

Which one are you starting with?
