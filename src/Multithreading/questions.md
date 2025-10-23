Perfect 🎯 — since you’ve covered **Threading, Synchronization, Locks, Executors, Futures, CompletableFuture, and Async Programming**,
here’s a **complete 50-question list** from **Basic → Intermediate → Hard**,
each aligned with **industry-level interviews** (TCS, Infosys, Product companies, Spring backend, etc.).

---

## 🧠 Java Multithreading & Concurrency — Interview Practice Set

| Level     | #  | Question                                                                 | Sample Input / Scenario | Key Methods / Concepts to Use    |
| --------- | -- | ------------------------------------------------------------------------ | ----------------------- | -------------------------------- |
| **Basic** | 1  | Create a thread that prints “Hello from thread” five times.              | —                       | `Thread`, `run()`, `start()`     |
|           | 2  | Create two threads printing numbers 1–5 and A–E simultaneously.          | —                       | `Thread`, `Runnable`             |
|           | 3  | Demonstrate thread creation using `Runnable` vs extending `Thread`.      | —                       | `Thread`, `Runnable`             |
|           | 4  | Set thread name and priority for multiple threads.                       | —                       | `setName()`, `setPriority()`     |
|           | 5  | Write a program to show `sleep()` and `join()` behavior.                 | —                       | `Thread.sleep()`, `join()`       |
|           | 6  | Create a thread that stops when interrupted.                             | —                       | `interrupt()`, `isInterrupted()` |
|           | 7  | Demonstrate `yield()` and observe scheduling difference.                 | —                       | `Thread.yield()`                 |
|           | 8  | Show `setDaemon(true)` effect — background thread cleanup.               | —                       | `setDaemon()`                    |
|           | 9  | Explain thread lifecycle using print logs (New → Runnable → Terminated). | —                       | `start()`, `run()`, `sleep()`    |
|           | 10 | Synchronize a counter incremented by two threads.                        | `counter=0`             | `synchronized`, critical section |
|           | 11 | Print table of 2 using thread synchronization.                           | `2 x 1..10`             | `synchronized` method            |
|           | 12 | Create and manage a thread pool using `ExecutorService`.                 | —                       | `Executors.newFixedThreadPool()` |
|           | 13 | Demonstrate difference between `run()` and `start()`.                    | —                       | `Thread.start()`                 |
|           | 14 | Simulate a race condition without synchronization.                       | Shared variable = 0     | `Thread`, `Runnable`             |
|           | 15 | Create multiple worker threads executing same Runnable task.             | —                       | `ExecutorService.submit()`       |
|           | 16 | Stop thread gracefully after N iterations.                               | N = 5                   | `volatile`, `isInterrupted()`    |
|           | 17 | Write program to count total active threads.                             | —                       | `Thread.activeCount()`           |
|           | 18 | Show dead thread cannot be restarted.                                    | —                       | `IllegalThreadStateException`    |
|           | 19 | Demonstrate `Thread.currentThread().getName()`.                          | —                       | `Thread.currentThread()`         |
|           | 20 | Explain `sleep()` vs `wait()`.                                           | —                       | `sleep`, `wait`, synchronized    |

---

| Level            | #  | Question                                                            | Sample Input / Scenario | Key Methods / Concepts to Use        |
| ---------------- | -- | ------------------------------------------------------------------- | ----------------------- | ------------------------------------ |
| **Intermediate** | 1  | Simulate producer-consumer problem.                                 | Queue size = 3          | `wait()`, `notify()`, `synchronized` |
|                  | 2  | Create 3 threads printing numbers in sequence (1,2,3 → repeat).     | Threads A,B,C           | `wait()`, `notifyAll()`              |
|                  | 3  | Implement Deadlock and resolve it using `tryLock()`.                | 2 shared locks          | `ReentrantLock.tryLock()`            |
|                  | 4  | Demonstrate fairness in threads using ReentrantLock(fair:true).     | 3 threads               | `ReentrantLock(fair)`                |
|                  | 5  | Show starvation and resolve it using fairness.                      | 3 threads               | Thread priority vs fair lock         |
|                  | 6  | Use `CountDownLatch` to start a main task after 3 sub-tasks finish. | count=3                 | `CountDownLatch.await()`             |
|                  | 7  | Use `CyclicBarrier` for 3 threads to meet and then continue.        | 3 threads               | `CyclicBarrier.await()`              |
|                  | 8  | Use `Semaphore` to allow 3 threads to access a limited resource.    | limit=3                 | `Semaphore.acquire()`, `release()`   |
|                  | 9  | Demonstrate `ReentrantLock` reentrancy concept.                     | nested locks            | `lock.lock()`, recursive call        |
|                  | 10 | Implement ReadWriteLock for shared read, exclusive write.           | 3 readers, 1 writer     | `ReentrantReadWriteLock`             |
|                  | 11 | Submit multiple tasks and get results using `Future.get()`.         | 5 tasks                 | `ExecutorService.submit()`           |
|                  | 12 | Use `invokeAll()` to execute multiple Callables.                    | tasks returning data    | `invokeAll`, `Future`                |
|                  | 13 | Demonstrate `invokeAny()` to get first completed task.              | 3 API calls             | `invokeAny`                          |
|                  | 14 | Handle exceptions in CompletableFuture using `exceptionally()`.     | Throw error             | `CompletableFuture.exceptionally()`  |
|                  | 15 | Combine two futures using `thenCombine()`.                          | Future1=10, Future2=20  | `CompletableFuture.thenCombine()`    |

---

| Level               | #  | Question                                                          | Sample Input / Scenario  | Key Methods / Concepts to Use     |
| ------------------- | -- | ----------------------------------------------------------------- | ------------------------ | --------------------------------- |
| **Advanced / Hard** | 1  | Build a custom thread pool using `BlockingQueue`.                 | Queue of Runnables       | `Thread`, `wait()`, `notify()`    |
|                     | 2  | Implement matrix multiplication using multiple threads.           | 3x3 matrix               | `CyclicBarrier`                   |
|                     | 3  | Parallel sum of large array using ForkJoinPool.                   | int[10^6]                | `RecursiveTask`, `ForkJoinPool`   |
|                     | 4  | Build async API simulator using CompletableFuture.                | API1, API2, API3         | `supplyAsync()`, `allOf()`        |
|                     | 5  | Demonstrate cancellation using `Future.cancel()`.                 | long-running task        | `cancel()`, `isCancelled()`       |
|                     | 6  | Design producer-consumer with `BlockingQueue`.                    | 3 producers, 2 consumers | `ArrayBlockingQueue`              |
|                     | 7  | Implement thread-safe Singleton using `Double-checked Locking`.   | —                        | `volatile`, `synchronized`        |
|                     | 8  | Simulate race condition and fix using `AtomicInteger`.            | Shared counter           | `AtomicInteger.incrementAndGet()` |
|                     | 9  | Use `Phaser` for multistage synchronization.                      | 3 phases                 | `Phaser.arriveAndAwaitAdvance()`  |
|                     | 10 | Create periodic task using `ScheduledExecutorService`.            | Print every 2s           | `scheduleAtFixedRate()`           |
|                     | 11 | Build async pipeline with `thenApplyAsync` and `thenAcceptAsync`. | API data                 | `CompletableFuture`               |
|                     | 12 | Handle timeout of Future task gracefully.                         | delay 5s                 | `Future.get(timeout)`             |
|                     | 13 | Simulate deadlock and resolve with lock ordering.                 | 2 locks                  | `ReentrantLock.tryLock()`         |
|                     | 14 | Parallel web scraper simulation (fetch multiple URLs).            | List<URL>                | `CompletableFuture.allOf()`       |
|                     | 15 | Chain multiple dependent async tasks.                             | API1→API2→API3           | `thenCompose()`                   |

---

## 🧩 ✅ Summary by Category

| Category                 | Key Focus                                                                 |
| ------------------------ | ------------------------------------------------------------------------- |
| **Basic (1–20)**         | Thread creation, lifecycle, basic synchronization                         |
| **Intermediate (21–35)** | Locks, Executors, Latches, Barriers, Futures                              |
| **Advanced (36–50)**     | CompletableFuture, ForkJoinPool, Parallelism, Atomic, Custom Thread Pools |

---

## 💡 Pro Tip for Interview Practice:

* Run your examples in an IDE (e.g. IntelliJ / VSCode).
* Add `Thread.sleep()` in prints to visualize concurrency.
* Use `Thread.currentThread().getName()` in every output — helps debug and explain behavior.
* Explain *why* a lock or future is used — not just the syntax.

---

Would you like me to prepare this entire **table as a printable PDF cheatsheet** (well-formatted, colored by difficulty, with spaces to write answers)?
It’s excellent for last-day revision before an interview.
