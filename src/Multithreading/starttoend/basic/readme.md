
---

# Concurrency Basics

## What is Concurrency?
**Concurrency** is the ability to do more than one thing at the same time:

**Concurrency** is the ability of a system to make progress on **multiple tasks during the same period of time**.

Examples:

* You can **chat and join a video call** simultaneously in a messaging app.
* You can **browse the web while editing code in an online editor**.
* You can **play music in the background while using other applications**.

Concurrency does **not necessarily mean multiple applications**.
Even a **single application can execute multiple tasks concurrently**.

Example:

* In **Microsoft Teams**, you can:

    * chat with multiple people
    * attend meetings
    * make video calls

This makes Teams a **concurrent software system**.

---

# Concurrency vs Parallelism

These two concepts are often confused.

| Concept         | Meaning                                                  |
| --------------- | -------------------------------------------------------- |
| **Concurrency** | Multiple tasks make progress during the same time period |
| **Parallelism** | Multiple tasks execute **literally at the same time**    |

### Single CPU System

With a **single CPU**, tasks are not truly executed simultaneously.

Instead:

* The **Operating System rapidly switches between tasks**
* Tasks run in an **interleaved manner**
* This switching happens so fast that it **appears simultaneous to users**

Therefore:

> Concurrency does **not imply parallelism**.

Parallelism requires **multiple processors or cores**.

---

# Units of Concurrency

Concurrency can exist at multiple levels.

## 1. Multiprocessing

Multiple **CPUs or cores** execute tasks simultaneously.

Example:

* Multi-core processors
* Distributed systems

**Unit of concurrency:** CPU/Core

This enables **true parallelism**.

---

## 2. Multitasking

Multiple **processes** run concurrently on a single CPU.

The OS scheduler switches between processes frequently.

Example:

* Browser
* Music player
* IDE running simultaneously

**Unit of concurrency:** Process

---

## 3. Multithreading

A **single program** can split work into multiple threads.

These threads execute concurrently within the same process.

Example:

* Web servers handling multiple requests
* Background file uploads
* UI thread + worker threads

**Unit of concurrency:** Thread

---

# Process vs Thread

## Process

A **Process** is a program that is currently executing.

Characteristics:

* Has its own **memory space (address space)**
* Own **call stack**
* Own **resources** (files, sockets, etc.)

The operating system manages multiple processes and shares CPU time among them.

Examples:

* Browser process
* Database process
* IDE process

---

## Thread

A **Thread** is a path of execution inside a process.

Every process contains at least **one thread** called the **main thread**.

Additional threads can be created for concurrent tasks.

Characteristics:

* Threads **share process memory**
* Each thread has its own **call stack**
* Threads are **lighter than processes**

Example:

* UI thread
* Worker thread
* Background task thread

---

# Relationship Between Program, Process, and Thread

Your understanding was close, but the correct relationship is:

```
Program → Process → Thread
```

Explanation:

**Program**

* A static set of instructions stored on disk
* Example: `chrome.exe`, `java`, `node`

**Process**

* A running instance of a program

**Thread**

* The smallest unit of execution inside a process

Example:

```
Chrome (Program)
    ↓
Chrome Process
    ↓
Multiple Threads
   - UI Thread
   - Network Thread
   - Renderer Thread
```

---

# Common Challenges in Concurrency

Concurrent systems introduce several problems.

### 1. Race Conditions

Occurs when multiple threads access and modify **shared data simultaneously**, leading to unpredictable results.

Example:

```
Thread A: count++
Thread B: count++
```

Expected result:

```
count = 2
```

Actual result may become:

```
count = 1
```

---

### 2. Memory Consistency Issues

Threads may see **different values of shared variables** due to caching or CPU optimizations.

Example:

* One thread updates a variable
* Another thread may not immediately see the updated value

This is why concepts like **volatile, synchronization, and memory models** exist.

---

# Summary

Concurrency allows systems to **handle multiple tasks efficiently** by structuring programs into smaller units such as processes and threads.

Key ideas:

* Concurrency ≠ Parallelism
* Single CPU → **concurrent execution via scheduling**
* Multi-core CPU → **true parallel execution**
* Concurrency units:

    * CPU
    * Process
    * Thread

---

In the next section we can cover:

* Thread Lifecycle
* Synchronization
* Locks & Monitors
* Deadlocks
* Java Thread Model
* Executor Framework
* CompletableFuture
* ForkJoinPool

---

If you want, I can also show you a **very interview-friendly diagram version of this (Process vs Thread vs CPU)** that makes this topic **extremely easy to explain in interviews**.
