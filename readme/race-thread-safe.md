Got it — let’s turn your **race condition + thread safety** code into a clear, structured note so you understand *exactly* what’s going on.

---

# **Java Multithreading – Mutation, Race Conditions & Thread Safety**

---

## **1. The Problem: Mutation with Multiple Threads**

* **Mutation** → Changing the same data from multiple threads at the same time.
* When two or more threads update the same variable **without proper synchronization**, results become unpredictable.
* This is called a **Race Condition**.

---

## **2. Your Code Example**

```java
class Counter {
    int count;
    public synchronized void increment() {
        count++;
    }
}

public class Racea {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Runnable obj1 = () -> {
            for (int i = 0; i < 5000; i++) {
                c.increment();
            }
        };

        Runnable obj2 = () -> {
            for (int i = 0; i < 5000; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

        t1.join(); // Wait until t1 finishes
        t2.join(); // Wait until t2 finishes

        System.out.println(c.count);
    }
}
```

---

## **3. Without Synchronization → Race Condition**

* If `increment()` was **not synchronized**:

  * Both `t1` and `t2` may read the same value of `count` before incrementing.
  * One increment overwrites the other → **loss of updates**.
  * Expected `10000`, but could be **less** (random results).

**Example:**

```
t1 reads count = 5
t2 reads count = 5
t1 increments → count = 6
t2 increments → count = 6  // Lost t1's update
```

---

## **4. How Synchronization Solves It**

* Adding `synchronized` keyword to `increment()` ensures:

  * **Only one thread can execute `increment()` at a time** on the same object.
  * Other threads wait until the lock is released.
* **Thread-safe** → No corruption of shared data.

**Mechanism:**

* Synchronization is implemented via a **lock (monitor)** on the object.
* When `t1` enters `increment()`, it acquires the lock.
* `t2` must wait until `t1` finishes and releases the lock.

---

## **5. `join()` Usage**

* `t1.join()` → Main thread **waits** for `t1` to finish.
* `t2.join()` → Main thread waits for `t2` to finish.
* Without `join()`, `System.out.println(c.count)` might run **before** both threads finish.

---

## **6. Why Not Share Variables Across Threads?**

* Shared mutable state is **error-prone**.
* Safer alternatives:

  * Make variables **local** to each thread.
  * Use **immutable** objects.
  * Use **thread-safe classes** (e.g., `AtomicInteger`, `ConcurrentHashMap`).

---

## **7. Thread Safety Summary**

| Approach        | Thread-Safe? | Performance                    |
| --------------- | ------------ | ------------------------------ |
| No sync         | ❌ No         | ✅ Fast                         |
| `synchronized`  | ✅ Yes        | ❌ Slower (blocking)            |
| `AtomicInteger` | ✅ Yes        | ✅ Faster than sync (lock-free) |

---

## **8. Alternative: AtomicInteger**

```java
import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    AtomicInteger count = new AtomicInteger(0);
    public void increment() {
        count.incrementAndGet();
    }
}
```

* Avoids `synchronized`.
* Lock-free, **better performance** in high-concurrency scenarios.

---

## **Visual Representation of Race Condition**

```
Without Synchronization:
Thread1: count -> read 5 -> increment to 6
Thread2: count -> read 5 -> increment to 6  ❌ Lost update

With Synchronization:
Thread1: [LOCK] count=5 -> increment to 6 -> [UNLOCK]
Thread2: waits until lock is free
```

---

If you want, I can **draw you a visual timeline diagram** showing how `t1` and `t2` interact with the shared `count` variable **with and without synchronization** so you can memorize it faster.

Do you want me to create that diagram?
