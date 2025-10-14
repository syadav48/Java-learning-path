Perfect — you’re asking for the **core of modern Java (Iterable → Stream API)** in a **single concise yet complete reference**.
Let’s go step by step 👇 — from `Iterable` to `Stream`, covering all functional interfaces, primitive streams, and operations.

---

# ☕ **Modern Java Functional & Stream Concepts — Complete Notes**

---

## 🧩 **1️⃣ Iterable Interface**

### ✅ Definition:

`Iterable` is the **root interface** for all collection types that can be iterated using `for-each`.

```java
for (String s : list) {
    System.out.println(s);
}
```

### 📘 Key Points:

* Declares one abstract method:

  ```java
  Iterator<T> iterator();
  ```
* Collections like `List`, `Set` implement `Iterable`.
* Introduced **default** methods in Java 8:

  ```java
  default void forEach(Consumer<? super T> action)
  default Spliterator<T> spliterator()
  ```

🧠 **Remember:**
`Iterable` allows iteration, while `Stream` allows **functional-style data processing**.

---

## ⚡ **2️⃣ Lambda Expression**

### ✅ Definition:

A **Lambda** is an **anonymous function** (no name, no modifier) that can be passed as a **method argument**.

```java
(a, b) -> a + b
```

### 🧩 Example:

```java
List<String> names = List.of("A", "B", "C");
names.forEach(n -> System.out.println(n));
```

### 📘 Syntax:

```
(parameters) -> expression
(parameters) -> { statements }
```

🧠 **Use:** To implement functional interfaces concisely.

---

## 🧩 **3️⃣ Functional Interfaces**

An interface with **only one abstract method** (SAM — Single Abstract Method).
Marked with `@FunctionalInterface`.

Common ones in `java.util.function` package:

| Interface      | Input | Output  | Method        | Example               |
| -------------- | ----- | ------- | ------------- | --------------------- |
| Predicate      | T     | boolean | `test(T t)`   | `x -> x > 10`         |
| Function       | T     | R       | `apply(T t)`  | `x -> x * 2`          |
| Consumer       | T     | void    | `accept(T t)` | `System.out::println` |
| Supplier       | none  | T       | `get()`       | `() -> new Date()`    |
| BiFunction     | T,U   | R       | `apply(T,U)`  | `(a,b) -> a+b`        |
| UnaryOperator  | T     | T       | `apply(T)`    | `x -> x * x`          |
| BinaryOperator | T,T   | T       | `apply(T,T)`  | `(a,b) -> a*b`        |

---

## 🧩 **4️⃣ Predicate**

Used for **conditional checks (boolean results)**.

```java
Predicate<Integer> isEven = x -> x % 2 == 0;
System.out.println(isEven.test(4)); // true
```

🧠 **Chaining:**

```java
isEven.and(x -> x > 10).test(12);
```

---

## 🧩 **5️⃣ Function**

Used to **transform data**.

```java
Function<Integer, Integer> square = x -> x * x;
System.out.println(square.apply(5)); // 25
```

🧠 **Compose/Chain Functions:**

```java
Function<Integer, Integer> doubleIt = x -> x * 2;
square.andThen(doubleIt).apply(3); // (3*3)*2 = 18
```

---

## 🧩 **6️⃣ Consumer**

Used to **consume data (no return)**.

```java
Consumer<String> printer = s -> System.out.println("Hello " + s);
printer.accept("Java");
```

🧠 Often used with:

```java
list.forEach(System.out::println);
```

---

## 🧩 **7️⃣ Supplier**

Used to **supply data (no input)**.

```java
Supplier<Double> randomValue = () -> Math.random();
System.out.println(randomValue.get());
```

🧠 Useful for **lazy initialization** or **generating values**.

---

# 🌊 **8️⃣ Stream API**

### ✅ Definition:

Introduced in Java 8 — a **pipeline of operations** on data (functional style).

```java
List<Integer> list = List.of(1, 2, 3, 4, 5);
list.stream()
    .filter(n -> n % 2 == 0)
    .map(n -> n * n)
    .forEach(System.out::println);
```

📘 **Stream Characteristics:**

* Doesn’t modify source data.
* Processes elements **lazily**.
* Can be sequential or parallel.
* Each element processed only once.

🧩 **Think of it as:**

```
Data Source → Stream → Intermediate Ops → Terminal Op
```

---

## 🧱 **Stream Creation Methods**

```java
Stream.of(1, 2, 3)
list.stream()
list.parallelStream()
Arrays.stream(array)
Stream.generate(() -> Math.random())
Stream.iterate(0, n -> n + 2)
```

---

## ⚙️ **Intermediate Operations**

They return **another Stream** (lazy operations).

| Operation           | Description            | Example                      |
| ------------------- | ---------------------- | ---------------------------- |
| `filter(Predicate)` | Filter elements        | `.filter(x -> x > 10)`       |
| `map(Function)`     | Transform elements     | `.map(x -> x * 2)`           |
| `flatMap(Function)` | Flatten nested streams | `.flatMap(List::stream)`     |
| `distinct()`        | Remove duplicates      | `.distinct()`                |
| `sorted()`          | Sort elements          | `.sorted()`                  |
| `limit(n)`          | Take first n           | `.limit(5)`                  |
| `skip(n)`           | Skip first n           | `.skip(2)`                   |
| `peek(Consumer)`    | Debug view             | `.peek(System.out::println)` |

🧠 **Key Point:**
Intermediate ops are **lazy**; they run only when a **terminal operation** is invoked.

---

## 🏁 **Terminal Operations**

They produce a **result** (end the stream).

| Operation                   | Type             | Example                         |
| --------------------------- | ---------------- | ------------------------------- |
| `forEach(Consumer)`         | Void             | `.forEach(System.out::println)` |
| `collect(Collector)`        | Collection       | `.collect(Collectors.toList())` |
| `toArray()`                 | Array            | `.toArray(Integer[]::new)`      |
| `reduce()`                  | Combine elements | `.reduce(0, Integer::sum)`      |
| `count()`                   | Count elements   | `.count()`                      |
| `min()` / `max()`           | Find             | `.max(Integer::compare)`        |
| `anyMatch()`                | Boolean          | `.anyMatch(x -> x > 10)`        |
| `allMatch()`                | Boolean          | `.allMatch(x -> x > 0)`         |
| `noneMatch()`               | Boolean          | `.noneMatch(x -> x < 0)`        |
| `findFirst()` / `findAny()` | Optional         | `.findFirst().get()`            |

---

## 🧮 **Example – Combined Stream Pipeline**

```java
int sum = List.of(1,2,3,4,5,6)
    .stream()
    .filter(x -> x % 2 == 0)   // [2,4,6]
    .map(x -> x * x)           // [4,16,36]
    .reduce(0, Integer::sum);  // 56
System.out.println(sum);
```

---

# ⚡ **9️⃣ Parallel Stream**

### ✅ Definition:

Processes stream elements **in multiple threads** (splits workload).

```java
list.parallelStream()
    .filter(x -> x % 2 == 0)
    .forEach(System.out::println);
```

📘 **Internally uses:**
**ForkJoinPool** (CommonPool) for parallel execution.

🧠 **Use When:**

* Heavy CPU-bound operations.
* Large datasets.
* Thread-safe operations.

⚠️ **Avoid When:**

* Dependent or order-sensitive tasks.
* I/O-bound processes.

---

# 🔢 **🔟 Primitive Streams**

Java provides specialized streams for primitives to avoid boxing overhead:

| Type   | Interface      | Example                     |
| ------ | -------------- | --------------------------- |
| int    | `IntStream`    | `IntStream.of(1,2,3)`       |
| long   | `LongStream`   | `LongStream.range(1,5)`     |
| double | `DoubleStream` | `DoubleStream.of(1.2, 3.4)` |

### 🔹 Example:

```java
IntStream.range(1, 6)
    .filter(x -> x % 2 == 0)
    .forEach(System.out::println); // 2, 4
```

📘 **Extra Methods:**

* `sum()`, `average()`, `max()`, `min()`
* `boxed()` → convert to Stream<Integer>

---

# 🧾 **Key Points to Remember**

| Concept          | Key Idea                 | Example                          |
| ---------------- | ------------------------ | -------------------------------- |
| Iterable         | Supports iteration       | `forEach()`                      |
| Lambda           | Anonymous function       | `(x) -> x + 1`                   |
| Predicate        | Boolean condition        | `x -> x > 5`                     |
| Function         | Transform data           | `x -> x * 2`                     |
| Consumer         | Consume data             | `System.out::println`            |
| Supplier         | Supply data              | `() -> Math.random()`            |
| Stream           | Functional data pipeline | `.filter().map().collect()`      |
| ParallelStream   | Multi-threaded stream    | `.parallelStream()`              |
| Primitive Stream | For int, long, double    | `IntStream.range()`              |
| Intermediate Ops | Return new Stream        | `filter(), map(), sorted()`      |
| Terminal Ops     | End Stream               | `collect(), forEach(), reduce()` |

---

Would you like me to create a **visual flow chart (Functional Interface + Stream pipeline)** PDF/PNG next — it’s excellent for interview revision (fits in one A4 sheet)?
