Excellent — you’ve now reached the **heart of multithreading**:
➡️ **Thread Communication (Inter-thread Communication)**
This is where threads don’t just run *independently*, but actually *cooperate* with each other.

Let’s break it down from **concept → working → methods → use cases → examples → best practices** 👇

---

## 🧠 1. Why Thread Communication?

Imagine you have two threads:

* **Producer thread:** Produces data (e.g., adds an item to a queue)
* **Consumer thread:** Consumes data (e.g., removes an item from that queue)

👉 If the producer is too fast — it may overflow the queue.
👉 If the consumer is too fast — it may try to read when the queue is empty.

So they must **communicate and coordinate**.

That’s where Java’s **Object class methods** come in:

* `wait()`
* `notify()`
* `notifyAll()`

---

## ⚙️ 2. What Is Thread Communication?

Thread communication is a mechanism where threads **signal each other** about **state changes** in shared resources, so that one can pause (using `wait()`) and another can wake it up (using `notify()`).

> It’s part of **Object class**, not Thread class —
> meaning **every object** in Java can be used as a **monitor lock** for coordination.

---

## 🔄 3. The Core Methods

| Method        | Defined In | Description                                                                                                 |
| ------------- | ---------- | ----------------------------------------------------------------------------------------------------------- |
| `wait()`      | Object     | Causes the current thread to wait until another thread calls `notify()` or `notifyAll()` on the same object |
| `notify()`    | Object     | Wakes up **one** thread waiting on that object’s monitor                                                    |
| `notifyAll()` | Object     | Wakes up **all** threads waiting on that object’s monitor                                                   |

---

## 🚦 4. Basic Rule — The “Monitor”

All three methods must be called **inside a synchronized block or method**.
Why? Because a thread must **own the object’s monitor lock** before it can call `wait()` or `notify()`.

### Example:

```java
synchronized (sharedObject) {
    sharedObject.wait();  // Thread goes into waiting state
}

synchronized (sharedObject) {
    sharedObject.notify();  // Wakes up one waiting thread
}
```

If called outside a synchronized context →
❌ `IllegalMonitorStateException`

---

## 🧩 5. How It Works Internally

Here’s what happens when a thread calls `wait()`:

1. The thread **releases the lock** on the object.
2. It moves to the **WAITING** state.
3. Another thread (holding the same lock) calls `notify()` or `notifyAll()`.
4. The waiting thread is moved to **BLOCKED (ready)** queue.
5. When it re-acquires the lock, it continues execution.

---

## 🧵 6. Example — Producer-Consumer Problem

Let’s see a real example 👇

```java
class SharedBuffer {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (available) { // buffer is full
            wait(); // wait for consumer
        }
        data = value;
        System.out.println("Produced: " + data);
        available = true;
        notify(); // notify waiting consumer
    }

    public synchronized void consume() throws InterruptedException {
        while (!available) { // buffer is empty
            wait(); // wait for producer
        }
        System.out.println("Consumed: " + data);
        available = false;
        notify(); // notify waiting producer
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    buffer.produce(i);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    buffer.consume();
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        });

        producer.start();
        consumer.start();
    }
}
```

🧩 Output:

```
Produced: 1
Consumed: 1
Produced: 2
Consumed: 2
...
```

✅ Both threads coordinate safely without race conditions.

---

## ⚖️ 7. `notify()` vs `notifyAll()`

| Method        | Behavior                                              | Use When                                   |
| ------------- | ----------------------------------------------------- | ------------------------------------------ |
| `notify()`    | Wakes up **one random** thread waiting on that object | You have **one producer and one consumer** |
| `notifyAll()` | Wakes up **all** waiting threads on that object       | You have **multiple consumers/producers**  |

---

## 🧭 8. Thread States Involved

```
RUNNING → WAITING (via wait())
WAITING → BLOCKED (via notify()/notifyAll())
BLOCKED → RUNNING (after acquiring lock again)
```

---

## ⚠️ 9. Common Mistakes Developers Make

| Mistake                                                     | Explanation                                                             |
| ----------------------------------------------------------- | ----------------------------------------------------------------------- |
| Calling `wait()` or `notify()` outside `synchronized` block | Causes `IllegalMonitorStateException`                                   |
| Forgetting to use `while` instead of `if`                   | Can cause **spurious wakeups** — thread wakes up without being notified |
| Not handling `InterruptedException`                         | Thread might stay waiting forever                                       |
| Not calling `notify()` after changing shared state          | Consumer thread may starve                                              |

✅ Always use a **while** loop to recheck condition:

```java
while (!condition) {
    wait();
}
```

---

## 🧩 10. Purpose of Thread Communication

Thread communication helps:

* Coordinate producer-consumer workflows
* Avoid busy waiting (wasting CPU cycles)
* Ensure proper ordering of tasks
* Achieve inter-thread synchronization without polling

---

## 🧰 11. Modern Alternatives (High-Level APIs)

Since Java 5, you can use higher-level concurrency utilities instead of low-level `wait/notify`.

| Class                             | Package                      | Description                                                   |
| --------------------------------- | ---------------------------- | ------------------------------------------------------------- |
| `BlockingQueue`                   | `java.util.concurrent`       | Automatically handles thread waiting/notifying                |
| `Semaphore`                       | `java.util.concurrent`       | Limits access to shared resources                             |
| `CountDownLatch`, `CyclicBarrier` | `java.util.concurrent`       | Thread coordination tools                                     |
| `Condition`                       | `java.util.concurrent.locks` | Advanced replacement of `wait/notify` with multiple wait sets |

Example using **BlockingQueue**:

```java
BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

Thread producer = new Thread(() -> {
    try {
        for (int i = 1; i <= 5; i++) {
            queue.put(i); // waits automatically if full
            System.out.println("Produced: " + i);
        }
    } catch (InterruptedException e) { e.printStackTrace(); }
});

Thread consumer = new Thread(() -> {
    try {
        for (int i = 1; i <= 5; i++) {
            int val = queue.take(); // waits automatically if empty
            System.out.println("Consumed: " + val);
        }
    } catch (InterruptedException e) { e.printStackTrace(); }
});

producer.start();
consumer.start();
```

✅ No manual `wait()` or `notify()` needed — handled internally by Java.

---

## 🧩 12. Summary Table

| Concept                | Meaning                            | Example           |
| ---------------------- | ---------------------------------- | ----------------- |
| `wait()`               | Thread waits, releases lock        | `obj.wait()`      |
| `notify()`             | Wakes up one waiting thread        | `obj.notify()`    |
| `notifyAll()`          | Wakes up all waiting threads       | `obj.notifyAll()` |
| **Purpose**            | Allow coordination between threads | Producer-Consumer |
| **Must Be Used In**    | `synchronized` block/method        | Yes               |
| **Modern Replacement** | `BlockingQueue`, `Condition`       | Easier, safer     |

---

## 🧭 Developer Tips (Must Know)

1. Always call `wait()` inside a **loop**, not `if`.
2. Always call `notify()` or `notifyAll()` **after** changing shared state.
3. Always call `wait()` and `notify()` on the **same monitor object**.
4. Always use `try-finally` to release locks.
5. Avoid `Thread.sleep()` for coordination — use `wait()`/`notify()` instead.
6. Prefer high-level constructs like **`BlockingQueue`** in production.

---

Would you like me to make a **visual diagram (PDF)** showing:

* Threads moving between WAITING → BLOCKED → RUNNING
* Producer-Consumer cycle with wait/notify arrows
* Comparison table (wait/notify vs BlockingQueue)?

That would visually tie all the concepts together for quick recall and interview prep.
