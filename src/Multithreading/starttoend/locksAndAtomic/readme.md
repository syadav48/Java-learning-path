Below is a **clean README-style continuation** of your Java Concurrency notes based on the points you provided. I refined the explanations, added proper examples, and kept it **consistent with the previous sections (Synchronization → Volatile → Locks)**.

---

# Locks in Java Concurrency

In previous sections, we saw how the `synchronized` keyword helps prevent:

* **Thread interference**
* **Memory consistency errors**

While `synchronized` is simple and powerful, Java also provides **more flexible locking mechanisms** through the **Locks API** available in:

```text
java.util.concurrent.locks
```

Locks provide **greater control over thread synchronization** compared to the `synchronized` keyword.

Some commonly used lock mechanisms are:

* `ReentrantLock`
* `ReadWriteLock`

---

# ReentrantLock

`ReentrantLock` is a **mutually exclusive lock** that behaves similarly to the **intrinsic lock used by the `synchronized` keyword**.

However, `ReentrantLock` offers **more advanced features and better control**.

The term **Reentrant** means:

```text
A thread that currently holds the lock can acquire it again without blocking.
```

This behavior is similar to **reentrant synchronization in synchronized blocks**.

---

# Example: Thread-Safe Counter using ReentrantLock

Consider a simple counter class where multiple threads increment a shared variable.

```java
import java.util.concurrent.locks.ReentrantLock;

class Counter {

    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {

        lock.lock();   // acquire lock

        try {
            count++;
        } finally {
            lock.unlock();  // release lock
        }

    }

    public int getCount() {
        return count;
    }
}
```

### How it works

1. A thread calling `increment()` first **acquires the lock**
2. Only one thread can hold the lock at a time
3. Other threads must **wait until the lock is released**
4. After completing the task, the thread **releases the lock**

---

# Why Use try-finally?

The lock release is placed in a **finally block**.

Example:

```java
try {
    lock.lock();
    // critical section
} finally {
    lock.unlock();
}
```

This ensures that the lock is **always released**, even if an exception occurs.

Failing to release a lock can cause **deadlocks**.

---

# Advantages of ReentrantLock

Compared to `synchronized`, `ReentrantLock` provides additional capabilities:

| Feature               | Description                                   |
| --------------------- | --------------------------------------------- |
| `tryLock()`           | Attempts to acquire the lock without blocking |
| `lockInterruptibly()` | Allows thread interruption while waiting      |
| Fairness policy       | Ensures lock acquisition order                |
| Condition variables   | Supports advanced thread communication        |

Example using `tryLock()`:

```java
if(lock.tryLock()){
    try{
        // critical section
    } finally{
        lock.unlock();
    }
}
```

---

# ReadWriteLock

In many applications:

```text
Read operations >> Write operations
```

For example:

* Fetching data from cache
* Reading configuration values
* Accessing shared resources

Using a normal lock blocks **both reads and writes**, reducing performance.

To improve concurrency, Java provides **ReadWriteLock**.

---

# What is ReadWriteLock?

`ReadWriteLock` provides **two separate locks**:

* **Read Lock**
* **Write Lock**

Rules:

```text
Multiple threads can hold the READ lock simultaneously.
Only one thread can hold the WRITE lock.
No read locks allowed when write lock is active.
```

This allows **higher concurrency in read-heavy applications**.

---

# Example: ReadWriteLock

```java
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedData {

    private int value = 0;

    private final ReentrantReadWriteLock lock =
            new ReentrantReadWriteLock();

    public int readValue() {

        lock.readLock().lock();

        try {
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeValue(int newValue) {

        lock.writeLock().lock();

        try {
            value = newValue;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
```

### Benefits

```text
Multiple threads → read simultaneously
Only one thread → allowed to write
```

This significantly improves performance in **read-heavy systems**.

Example use cases:

* Caching systems
* Configuration management
* Data sharing in microservices

---

# Atomic Variables

Java also provides **Atomic classes** for thread-safe operations without using locks.

These classes are available in:

```text
java.util.concurrent.atomic
```

Examples include:

* `AtomicInteger`
* `AtomicLong`
* `AtomicBoolean`
* `AtomicReference`

---

# How Atomic Classes Work

Atomic classes internally use **Compare-And-Swap (CAS)** operations supported by modern CPUs.

CAS works like this:

```text
1. Read current value
2. Compare with expected value
3. Update only if values match
```

This operation is **atomic**, meaning it cannot be interrupted by other threads.

CAS is typically **faster than locks** because it avoids thread blocking.

---

# Example: AtomicInteger

Consider a counter increment operation.

### Without synchronization

```java
count++;
```

This is **not thread-safe**.

---

### Using AtomicInteger

```java
import java.util.concurrent.atomic.AtomicInteger;

class Counter {

    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
```

Here:

```text
incrementAndGet()
```

performs the increment **atomically**.

Multiple threads can safely update the variable.

---

# Advantages of Atomic Variables

| Feature                  | Benefit                   |
| ------------------------ | ------------------------- |
| Lock-free                | No thread blocking        |
| Faster than synchronized | Uses CPU instructions     |
| Thread-safe              | Ensures atomic operations |
| High performance         | Ideal for counters        |

---

# Locks vs Atomic Variables

| Feature     | Locks                     | Atomic Variables        |
| ----------- | ------------------------- | ----------------------- |
| Mechanism   | Thread blocking           | CAS operations          |
| Performance | Slower under contention   | Faster                  |
| Use case    | Complex critical sections | Single variable updates |
| Example     | ReentrantLock             | AtomicInteger           |

---

# Summary

Java provides several mechanisms to manage thread synchronization.

| Mechanism          | Purpose                                   |
| ------------------ | ----------------------------------------- |
| `synchronized`     | Basic thread safety                       |
| `ReentrantLock`    | Advanced lock control                     |
| `ReadWriteLock`    | High concurrency for read-heavy workloads |
| `Atomic Variables` | Lock-free atomic operations               |

Choosing the right tool depends on the **type of concurrency problem being solved**.

---

# Key Takeaways

```text
ReentrantLock → flexible alternative to synchronized
ReadWriteLock → improves performance for read-heavy systems
Atomic classes → fast lock-free thread-safe operations
CAS → hardware-level atomic instruction
```

---

If you'd like, I can also help you write the **next part of this series**, which logically comes next in Java concurrency:

**Deadlocks, Livelocks, and Thread Starvation**

These are **very important for senior Java interviews and system design discussions.**
