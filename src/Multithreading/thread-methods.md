Perfect 👍 — this is where **Java Threading** becomes practical — understanding the **core thread methods** that control *execution, scheduling, and behavior*.

Let’s go one-by-one, clearly and deeply 👇

---

# 🧵 Java Thread Methods — Complete Breakdown

All of these methods belong to the **`java.lang.Thread`** class
(✅ automatically available, no import needed).

---

## ⚙️ 1. `start()`

### 🔹 Purpose:

Used to **start** a new thread — it tells the **JVM and OS** to schedule this thread for execution.

### 🔹 What Happens Internally:

* A **new call stack** is created for that thread.
* JVM calls the thread’s `run()` method **asynchronously**.
* Returns **immediately** (doesn’t wait for thread to finish).

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

public class Demo {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();  // ✅ starts a new thread
        System.out.println("Main thread finished");
    }
}
```

🧠 If you call `t.run()` directly → it runs **in the same thread**, not a new one.

---

## 🧩 2. `run()`

### 🔹 Purpose:

Defines the **task or code** that the thread will execute.

### 🔹 Automatically called by:

`start()` → JVM → calls `run()` internally.

```java
@Override
public void run() {
    // Thread logic goes here
}
```

💡 You never call `run()` manually — otherwise, it won’t start a new thread, it’ll just act as a normal method call.

---

## ⏸️ 3. `sleep(long millis)`

### 🔹 Purpose:

Temporarily **pauses the execution** of the current thread for the given time.

### 🔹 Characteristics:

* Keeps the thread **in TIMED_WAITING** state.
* Doesn’t release locks.
* Throws **`InterruptedException`** if interrupted.

```java
try {
    Thread.sleep(2000); // sleep for 2 seconds
} catch (InterruptedException e) {
    System.out.println("Thread interrupted!");
}
```

💡 Used for simulating delay, throttling API calls, or pacing animations.

---

## ⏱️ 4. `join()`

### 🔹 Purpose:

Makes the **current thread wait** until the target thread finishes.

### 🔹 Usage:

Used when you want to ensure that one thread completes **before** another starts.

```java
Thread t1 = new Thread(() -> {
    for (int i = 1; i <= 3; i++)
        System.out.println("Task A: " + i);
});

Thread t2 = new Thread(() -> {
    for (int i = 1; i <= 3; i++)
        System.out.println("Task B: " + i);
});

t1.start();
t2.start();
try {
    t1.join();  // main waits for t1 to finish
    t2.join();  // then waits for t2
} catch (InterruptedException e) {}

System.out.println("All tasks done!");
```

🧠 Without `join()`, threads run concurrently;
with `join()`, we enforce order or dependency.

---

## ⚖️ 5. `setPriority(int priority)`

### 🔹 Purpose:

Sets the **priority** (importance level) of a thread for CPU scheduling.

### 🔹 Range:

| Constant               | Value       |
| ---------------------- | ----------- |
| `Thread.MIN_PRIORITY`  | 1           |
| `Thread.NORM_PRIORITY` | 5 (default) |
| `Thread.MAX_PRIORITY`  | 10          |

```java
Thread t1 = new Thread(() -> System.out.println("Low Priority"));
Thread t2 = new Thread(() -> System.out.println("High Priority"));

t1.setPriority(Thread.MIN_PRIORITY);
t2.setPriority(Thread.MAX_PRIORITY);

t1.start();
t2.start();
```

⚠️ **Note:** Priority is **only a hint** — actual scheduling depends on OS and JVM implementation.
So, *not guaranteed* that higher priority always runs first.

---

## 🚫 6. `interrupt()`

### 🔹 Purpose:

Used to **interrupt** a thread that is sleeping, waiting, or blocked.

### 🔹 Behavior:

* Sets an internal **interrupted flag**.
* If thread is in **sleep() / wait()**, it throws **`InterruptedException`**.
* If running normally, the flag can be checked via `isInterrupted()`.

```java
Thread t = new Thread(() -> {
    try {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Working...");
            Thread.sleep(1000);
        }
    } catch (InterruptedException e) {
        System.out.println("Thread interrupted!");
    }
});

t.start();

try { Thread.sleep(2500); } catch (InterruptedException e) {}
t.interrupt(); // interrupt after 2.5 sec
```

🧠 Used in **graceful shutdowns** or to cancel long-running tasks.

---

## ⚖️ 7. `yield()`

### 🔹 Purpose:

Hints to the **thread scheduler** that the current thread is **willing to pause** to let other threads of the same priority execute.

```java
Thread t = new Thread(() -> {
    for (int i = 0; i < 5; i++) {
        System.out.println(Thread.currentThread().getName() + " - iteration " + i);
        Thread.yield();
    }
});
t.start();
```

💡 Effect:

* Not guaranteed — it *depends on the OS and JVM*.
* Sometimes used to improve CPU fairness in multi-threaded loops.

🧠 Real-world analogy: “I’m okay to let someone else go first.”

---

## 👻 8. `setDaemon(boolean on)`

### 🔹 Purpose:

Marks a thread as a **daemon thread** (background helper thread).

### 🔹 Characteristics:

* Daemon threads run **in the background**.
* JVM **terminates automatically** once all non-daemon (user) threads finish.
* Must be set **before** calling `start()`.

```java
Thread t = new Thread(() -> {
    while (true) {
        System.out.println("Daemon working...");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    }
});
t.setDaemon(true);
t.start();

System.out.println("Main thread finished");
```

Output:

```
Daemon working...
Main thread finished
```

💡 JVM exits immediately because only daemon threads remain.

---

## 🧭 Summary Table

| Method               | Description                        | Key Points                        |
| -------------------- | ---------------------------------- | --------------------------------- |
| `start()`            | Starts a new thread                | Calls `run()` in a new call stack |
| `run()`              | Defines thread logic               | Executed by JVM                   |
| `sleep(ms)`          | Pause execution                    | Throws `InterruptedException`     |
| `join()`             | Wait for another thread to finish  | Used for synchronization          |
| `setPriority(int)`   | Sets CPU scheduling hint           | 1–10 range (default 5)            |
| `interrupt()`        | Interrupts sleeping/waiting thread | Can be caught or ignored          |
| `yield()`            | Gives up CPU voluntarily           | Just a hint to scheduler          |
| `setDaemon(boolean)` | Marks thread as background         | Ends when all user threads finish |

---

## ⚙️ Bonus Methods Worth Knowing

| Method                    | Description                                          |
| ------------------------- | ---------------------------------------------------- |
| `isAlive()`               | Returns `true` if thread is still running            |
| `getName()` / `setName()` | Get or set thread name                               |
| `currentThread()`         | Returns currently executing thread                   |
| `isDaemon()`              | Checks if thread is daemon                           |
| `getState()`              | Returns thread’s current state (NEW, RUNNABLE, etc.) |

---

## 🧠 Quick Example Covering All

```java
class Worker extends Thread {
    public void run() {
        System.out.println(getName() + " started.");
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + " working...");
                Thread.sleep(1000);
                Thread.yield();
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted!");
        }
        System.out.println(getName() + " finished.");
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws Exception {
        Worker t1 = new Worker();
        Worker t2 = new Worker();
        t1.setName("Alpha");
        t2.setName("Beta");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.setDaemon(true);

        t1.start();
        t2.start();
        t1.join();
        System.out.println("Main thread exiting");
    }
}
```

---

Would you like me to make a **Thread Methods Summary Diagram** — showing visually how `start()`, `sleep()`, `join()`, `interrupt()` affect the **thread state transitions** (like a lifecycle map with method arrows)?
