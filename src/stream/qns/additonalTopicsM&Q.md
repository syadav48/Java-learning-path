Here’s a **complete, industry-focused notebook-style guide** on **Java Streams and all important built-in stream classes** (*Stream, IntStream, LongStream, DoubleStream*) with **usage, best practices, and high-quality practice questions used in real interviews**.
Clear, structured, and perfect for revision.

---

# 🚀 **Java Streams – Inbuilt Stream Classes & Their Usage**

Java Streams provide a **functional, declarative** way to process collections and data pipelines.

There are **4 main stream types**:

1. **Stream<T>** → for objects
2. **IntStream** → for primitives `int`
3. **LongStream** → for primitives `long`
4. **DoubleStream** → for primitives `double`

Primitive streams avoid *autoboxing* → **faster + memory-efficient**.

---

# ✅ **1. Stream<T>**

Used for **any Java object** like Employee, String, Product, etc.

### Common Operations

| Category         | Methods                                                                                       |
| ---------------- | --------------------------------------------------------------------------------------------- |
| Creation         | `stream()`, `of()`, `generate()`, `iterate()`, `builder()`                                    |
| Intermediate Ops | `filter()`, `map()`, `flatMap()`, `sorted()`, `distinct()`, `peek()`                          |
| Terminal Ops     | `collect()`, `reduce()`, `count()`, `min()`, `max()`, `findFirst()`, `findAny()`, `forEach()` |

### Example

```java
List<String> names = List.of("Ram", "Shyam", "Ram");

List<String> uniqueSorted =
        names.stream()
             .distinct()
             .sorted()
             .toList();
```

---

# ✅ **2. IntStream**

Used for primitive integers → avoids `Integer` boxing.

### Creation

```java
IntStream.range(1, 10);      // 1 to 9
IntStream.rangeClosed(1, 10); // 1 to 10
IntStream.of(2, 4, 8);
new Random().ints(5); // 5 random ints
```

### Important Methods

| Operation            | Usage              |
| -------------------- | ------------------ |
| Sum                  | `sum()`            |
| Average              | `average()`        |
| Max/Min              | `max(), min()`     |
| Convert to Stream<T> | `mapToObj()`       |
| Convert to List      | `boxed().toList()` |

### Example

```java
List<Integer> squares =
        IntStream.rangeClosed(1, 5)
                 .map(x -> x * x)
                 .boxed()
                 .toList();
```

---

# ✅ **3. LongStream**

Used when working with large counters, timestamps, IDs.

Example:

```java
long total = LongStream.rangeClosed(1, 1_000_000).sum();
```

---

# ✅ **4. DoubleStream**

Useful for percentage, price, rating, currency, etc.

Example:

```java
double avg = DoubleStream.of(10.5, 20.6, 30.7).average().getAsDouble();
```

---

# 🎯 **Common Stream Conversions**

| Convert From → To        | Method             |
| ------------------------ | ------------------ |
| Stream → IntStream       | `mapToInt()`       |
| IntStream → Stream       | `boxed()`          |
| IntStream → DoubleStream | `asDoubleStream()` |
| Collection → Stream      | `list.stream()`    |

Example:

```java
List<String> nums = List.of("1", "2", "3");

int sum =
        nums.stream()
            .mapToInt(Integer::parseInt)
            .sum();
```

---

### **IntStream / LongStream / DoubleStream**

1. Generate first 20 even numbers using `IntStream.iterate`.
2. Calculate factorial using `LongStream.rangeClosed`.
3. Given list of prices, compute GST and grand total using `DoubleStream`.
4. Generate 10 random numbers and return average using `IntStream`.
5. Convert IntStream to Stream<String> and join using comma.

---