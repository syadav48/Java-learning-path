Below is a **clean README-style continuation** of your Java concurrency notes. It follows the same structure as your previous sections (Runnable → Executors → Callable/Future).

---

# Callable and Future in Java

In earlier sections, we used **Runnable** to define tasks executed by a thread.

Example:

```java
Runnable task = () -> {
    System.out.println("Running task");
};
```

While `Runnable` is simple and convenient, it has an important limitation.

### Limitation of Runnable

Tasks defined using `Runnable` **cannot return a result**.

The `run()` method has the following signature:

```java
void run();
```

This means:

* No return value
* Cannot throw checked exceptions

But many real-world tasks need to **return results**.

Example scenarios:

* Fetch data from a remote API
* Perform a calculation
* Query a database
* Process a file

To support this, Java provides the **Callable interface**.

---

# Callable Interface

The **Callable interface** is similar to `Runnable`, but it allows tasks to:

* **Return a result**
* **Throw checked exceptions**

Method signature:

```java
V call() throws Exception
```

Where `V` is the type of result returned.

---

# Example: Callable Task

```java
Callable<String> callable = new Callable<String>() {

    @Override
    public String call() throws Exception {

        // Simulate computation
        Thread.sleep(2000);

        return "Return some result";
    }

};
```

In this example:

* The task sleeps for 2 seconds
* Then returns a string result

---

# Executing Callable Tasks

`Callable` tasks are typically executed using **ExecutorService**.

Example:

```java
ExecutorService executor = Executors.newSingleThreadExecutor();

Callable<String> task = () -> {
    Thread.sleep(2000);
    return "Task Completed";
};

Future<String> future = executor.submit(task);
```

Notice:

```text
submit() → returns a Future object
```

---

# What is Future?

A **Future** represents the **result of an asynchronous computation**.

When a task is submitted:

```text
Task submitted → executed in another thread
```

The `Future` object acts as a **placeholder for the result**.

Example:

```java
String result = future.get();
```

`get()` waits until the task finishes and returns the result.

---

# Example: Callable with Future

```java
ExecutorService executor = Executors.newSingleThreadExecutor();

Callable<Integer> task = () -> {

    Thread.sleep(2000);

    return 10 + 20;

};

Future<Integer> future = executor.submit(task);

System.out.println("Task submitted...");

Integer result = future.get();

System.out.println("Result = " + result);

executor.shutdown();
```

Possible output:

```
Task submitted...
Result = 30
```

---

# Important Methods of Future

The `Future` interface provides several useful methods.

---

# 1. `get()`

Returns the result of the computation.

```java
future.get();
```

Behavior:

```text
If task completed → return result
If task running → block until completed
```

Example:

```java
Integer result = future.get();
```

---

# 2. `isDone()`

Checks whether the task has finished execution.

Example:

```java
if (future.isDone()) {
    System.out.println("Task completed");
}
```

Returns:

```text
true  → task finished
false → task still running
```

---

# 3. `cancel()`

Attempts to cancel execution of the task.

Example:

```java
future.cancel(true);
```

Parameter meaning:

| Value   | Behavior                           |
| ------- | ---------------------------------- |
| `true`  | Interrupt thread if running        |
| `false` | Cancel only if task hasn't started |

Example:

```java
boolean cancelled = future.cancel(true);
```

---

# 4. `isCancelled()`

Checks whether the task was cancelled.

Example:

```java
future.isCancelled();
```

Returns:

```text
true → task cancelled
false → task executed normally
```

---

# `invokeAll()` Method

`invokeAll()` executes **multiple Callable tasks simultaneously**.

It returns a **list of Future objects**.

Example:

```java
ExecutorService executor = Executors.newFixedThreadPool(3);

List<Callable<Integer>> tasks = Arrays.asList(
        () -> 10,
        () -> 20,
        () -> 30
);

List<Future<Integer>> futures = executor.invokeAll(tasks);

for (Future<Integer> future : futures) {
    System.out.println(future.get());
}

executor.shutdown();
```

Output:

```
10
20
30
```

Important behavior:

```text
invokeAll()
→ waits for all tasks to complete
```

---

# `invokeAny()` Method

`invokeAny()` executes multiple tasks but returns **the result of the first task that completes successfully**.

Example:

```java
ExecutorService executor = Executors.newFixedThreadPool(3);

List<Callable<String>> tasks = Arrays.asList(
        () -> {
            Thread.sleep(3000);
            return "Task 1";
        },
        () -> {
            Thread.sleep(1000);
            return "Task 2";
        },
        () -> {
            Thread.sleep(2000);
            return "Task 3";
        }
);

String result = executor.invokeAny(tasks);

System.out.println(result);

executor.shutdown();
```

Output:

```
Task 2
```

Because **Task 2 finished first**.

---

# Runnable vs Callable

| Feature                  | Runnable          | Callable        |
| ------------------------ | ----------------- | --------------- |
| Method                   | `run()`           | `call()`        |
| Return value             | ❌ No              | ✅ Yes           |
| Throws checked exception | ❌ No              | ✅ Yes           |
| Used with                | Thread / Executor | ExecutorService |

---

# Execution Flow with Callable

```text
Callable Task
      ↓
ExecutorService.submit()
      ↓
Future Object
      ↓
future.get()
      ↓
Result Returned
```

---

# Real World Usage

Callable and Future are used in many real applications.

Examples:

* Parallel API calls
* Aggregating microservice responses
* Batch processing
* Background computations
* File processing
* Data aggregation

Example scenario:

```text
Fetch user profile
Fetch order history
Fetch notifications
```

Run all tasks concurrently using **Callable + ExecutorService**.

---

# Summary

`Callable` is used when tasks need to **return results**.

Key concepts:

* `Callable` → defines a task that returns a result
* `Future` → represents the result of an asynchronous computation
* `ExecutorService.submit()` → executes Callable tasks
* `invokeAll()` → runs multiple tasks and waits for all
* `invokeAny()` → returns the result of the fastest task

---

If you'd like, the **next logical note** in your series would be extremely valuable:

**Complete Thread Pool Types in Java**

```
FixedThreadPool
CachedThreadPool
SingleThreadExecutor
ScheduledThreadPool
ForkJoinPool
```

This topic connects **directly with Executors and is very important for system design interviews.**
