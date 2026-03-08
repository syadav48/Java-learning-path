Here is a **clean README-style continuation** of your notes. I kept the same structure so it fits nicely with your previous **Concurrency Basics** document.

---

# Creating Threads in Java

Java provides **two primary ways to create a thread**.

## 1. Extending the `Thread` Class

You can create a thread by **extending the `Thread` class** and overriding its `run()` method.

### Example

```java
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread is running...");
    }

}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
```

### Explanation

* `run()` → contains the logic executed by the thread
* `start()` → creates a new thread and internally calls `run()`

⚠️ Important: Calling `run()` directly **does not start a new thread**.

```java
thread.run(); // runs in main thread (not concurrent)
```

---

# 2. Implementing the `Runnable` Interface

Another way to create a thread is by **implementing the `Runnable` interface**.

The `Runnable` interface contains only **one method**:

```java
void run();
```

### Example

```java
class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Task is running in a thread");
    }

}

public class Main {
    public static void main(String[] args) {

        Runnable task = new MyTask();

        Thread thread = new Thread(task);
        thread.start();
    }
}
```

### Execution Flow

```
Runnable → passed to Thread → Thread executes run()
```

---

# Runnable vs Extending Thread

Although both approaches work, **implementing Runnable is preferred**.

Let's understand why.

---

# Problem with Extending `Thread`

If you extend `Thread`, your class **cannot extend any other class**.

Java does **not support multiple inheritance**.

### Example

```java
class DatabaseConnection {
    void connect() {}
}

// This will NOT work
class MyThread extends DatabaseConnection, Thread {
}
```

This is illegal in Java.

Therefore, extending `Thread` **restricts your class design**.

---

# Runnable Solves This Problem

Using `Runnable`, your class is **free to extend another class**.

### Example

```java
class DatabaseConnection {
    void connect() {
        System.out.println("Connected to DB");
    }
}

class DataProcessor extends DatabaseConnection implements Runnable {

    @Override
    public void run() {
        connect();
        System.out.println("Processing data...");
    }

}

public class Main {

    public static void main(String[] args) {

        DataProcessor processor = new DataProcessor();

        Thread thread = new Thread(processor);
        thread.start();
    }

}
```

Now the class:

```
extends DatabaseConnection
implements Runnable
```

This gives **much better flexibility**.

---

# Design Principle Behind Runnable

Using `Runnable` follows a **better object-oriented design**.

When you extend `Thread`, your class becomes a **Thread itself**.

But in most cases:

> Your class represents a **task**, not a thread.

Example tasks:

* Upload a file
* Process data
* Send an email
* Handle a request

These are **tasks**, not threads.

Threads are simply **workers executing tasks**.

So a better design is:

```
Task (Runnable) → executed by → Thread
```

This separation makes the system **cleaner and reusable**.

---

# Runnable with Anonymous Class

You can write Runnable using an **anonymous class**.

```java
Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("Anonymous runnable thread");
    }
});

thread.start();
```

---

# Runnable with Java 8 Lambda

Since `Runnable` is a **Functional Interface**, it can use **Lambda Expressions**.

### Example

```java
Thread thread = new Thread(() -> {
    System.out.println("Thread using lambda");
});

thread.start();
```

This is the **most concise way**.

---

# Summary

| Approach             | Description                         | Limitation                  |
| -------------------- | ----------------------------------- | --------------------------- |
| Extend `Thread`      | Create a subclass of Thread         | Cannot extend another class |
| Implement `Runnable` | Define a task and pass it to Thread | More flexible               |

---

# Key Takeaways

* Prefer **Runnable over extending Thread**
* Runnable separates **task from thread**
* Runnable allows **better class design**
* Runnable works with **anonymous classes and lambdas**

Recommended pattern:

```
Task (Runnable) → executed by → Thread
```

---

# In Real Applications

Modern Java rarely uses raw `Thread`.

Instead we use:

* **ExecutorService**
* **ThreadPool**
* **CompletableFuture**
* **ForkJoinPool**

These provide **better thread management and scalability**.

---

If you want, I can also show you the **next logical notes for your series**:

```
Thread Lifecycle (Very important for interviews)
NEW
RUNNABLE
BLOCKED
WAITING
TIMED_WAITING
TERMINATED
```

That topic connects **directly after Runnable vs Thread** and is often asked in **Java backend interviews**.
