Perfect ✅ — this is the **final and most important piece** of the Stream API puzzle:
👉 **`Collectors`** — how Streams collect, group, partition, and transform data after processing.

Let’s make this your **complete, interview-ready summary + examples + key notes** 👇

---

# ☕ **Collectors in Java — Complete & Concise Notes**

---

## 🧩 **1️⃣ What is a Collector?**

`Collector` is a utility class (in `java.util.stream.Collectors`) used to **accumulate elements from a Stream into a result container**
(like a `List`, `Set`, `Map`, or even a single value).

It’s used inside **`collect()`**, which is a **terminal operation** in streams.

```java
List<Integer> list = Stream.of(1, 2, 3)
    .collect(Collectors.toList());
```

---

## ⚙️ **2️⃣ Syntax**

```java
<R, A> R collect(Collector<? super T, A, R> collector)
```

✅ You don’t create Collectors manually —
You use **predefined static factory methods** from the `Collectors` class.

---

## 📦 **3️⃣ Basic Collectors**

| Collector                | Description                    | Example                                              |
| ------------------------ | ------------------------------ | ---------------------------------------------------- |
| `toList()`               | Collect into a `List`          | `.collect(Collectors.toList())`                      |
| `toSet()`                | Collect into a `Set`           | `.collect(Collectors.toSet())`                       |
| `toCollection(Supplier)` | Collect into custom collection | `.collect(Collectors.toCollection(LinkedList::new))` |
| `joining()`              | Concatenate strings            | `.collect(Collectors.joining(", "))`                 |

### Example:

```java
List<String> names = List.of("Alice", "Bob", "Charlie");

String joined = names.stream()
    .collect(Collectors.joining(", "));

System.out.println(joined); // Alice, Bob, Charlie
```

---

## 🧮 **4️⃣ Counting, Summing, Averaging**

| Collector                       | Description                             | Example                                                    |
| ------------------------------- | --------------------------------------- | ---------------------------------------------------------- |
| `counting()`                    | Count elements                          | `.collect(Collectors.counting())`                          |
| `summingInt(ToIntFunction)`     | Sum of int values                       | `.collect(Collectors.summingInt(Employee::getSalary))`     |
| `averagingInt(ToIntFunction)`   | Average of int values                   | `.collect(Collectors.averagingInt(Employee::getAge))`      |
| `summarizingInt(ToIntFunction)` | Get summary (count, min, avg, max, sum) | `.collect(Collectors.summarizingInt(Employee::getSalary))` |

### Example:

```java
List<Integer> numbers = List.of(1, 2, 3, 4);

int sum = numbers.stream()
    .collect(Collectors.summingInt(x -> x));

Double avg = numbers.stream()
    .collect(Collectors.averagingInt(x -> x));

System.out.println(sum); // 10
System.out.println(avg); // 2.5
```

---

## 🗂️ **5️⃣ Grouping Data — `groupingBy()`**

### ✅ Definition:

Used to **group elements** by a classifier function (like SQL’s `GROUP BY`).

```java
Map<String, List<Employee>> map =
    employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment));
```

🧩 Result:
Each key → department,
Each value → list of employees in that department.

---

### 🔹 Grouping + Counting

```java
Map<String, Long> countByDept = employees.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment,
                                  Collectors.counting()));
```

### 🔹 Grouping + Summing

```java
Map<String, Integer> totalSalaryByDept = employees.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment,
                                  Collectors.summingInt(Employee::getSalary)));
```

---

## 🧱 **6️⃣ Multi-level Grouping**

You can **nest** grouping to create hierarchical maps.

```java
Map<String, Map<String, List<Employee>>> map = employees.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment,
        Collectors.groupingBy(Employee::getDesignation)));
```

🧠 **Result:**
`Department → Designation → List<Employee>`

---

## 🧲 **7️⃣ Partitioning Data — `partitioningBy()`**

### ✅ Definition:

Splits data into **two groups** based on a **Predicate** — true/false.

```java
Map<Boolean, List<Employee>> partitioned = employees.stream()
    .collect(Collectors.partitioningBy(e -> e.getSalary() > 50000));
```

🧩 Result:

* Key `true` → Employees with salary > 50000
* Key `false` → Employees with salary ≤ 50000

📘 **Difference between groupingBy & partitioningBy:**

* `groupingBy` → multiple groups (based on key)
* `partitioningBy` → only two groups (boolean condition)

---

## 🔁 **8️⃣ Mapping + Reducing in Collectors**

### 🔹 `mapping()`

Used inside other collectors to **transform** before collecting.

```java
Map<String, List<String>> namesByDept = employees.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment,
        Collectors.mapping(Employee::getName, Collectors.toList())));
```

---

### 🔹 `reducing()`

Used to **combine results manually**.

```java
int total = Stream.of(1, 2, 3, 4)
    .collect(Collectors.reducing(0, (a, b) -> a + b));

System.out.println(total); // 10
```

Or with mapping:

```java
int totalSalary = employees.stream()
    .collect(Collectors.reducing(0,
        Employee::getSalary, Integer::sum));
```

---

## 🧮 **9️⃣ toMap() and toConcurrentMap()**

### ✅ Collect elements into a `Map<Key, Value>`

```java
Map<Integer, String> map = employees.stream()
    .collect(Collectors.toMap(Employee::getId, Employee::getName));
```

🧠 **If duplicate keys occur, handle with merge function:**

```java
Map<String, Integer> salaryMap = employees.stream()
    .collect(Collectors.toMap(Employee::getDepartment,
        Employee::getSalary,
        Integer::sum));
```

### 🔹 `toConcurrentMap()`

Same as above but **thread-safe** — for parallel streams.

---

## 🧰 **🔟 Collectors.collectingAndThen()**

Used to **post-process** the collected result.

```java
List<String> unmodifiable = names.stream()
    .collect(Collectors.collectingAndThen(
        Collectors.toList(),
        Collections::unmodifiableList));
```

🧩 Collects → converts → returns final type.

---

## 🧾 **11️⃣ Example: Combined Use**

```java
Map<String, Double> avgSalaryByDept = employees.stream()
    .collect(Collectors.groupingBy(
        Employee::getDepartment,
        Collectors.averagingInt(Employee::getSalary)
    ));
```

🧠 **Meaning:**
Group employees by department → calculate average salary per dept.

---

# 🧩 **12️⃣ Summary Chart**

| Collector             | Purpose                     | Returns               | Example                                |
| --------------------- | --------------------------- | --------------------- | -------------------------------------- |
| `toList()`            | Collect into List           | List                  | `.collect(toList())`                   |
| `toSet()`             | Collect into Set            | Set                   | `.collect(toSet())`                    |
| `toMap()`             | Key-Value map               | Map                   | `.collect(toMap(...))`                 |
| `joining()`           | Join Strings                | String                | `.collect(joining(", "))`              |
| `counting()`          | Count items                 | Long                  | `.collect(counting())`                 |
| `summingInt()`        | Sum values                  | int                   | `.collect(summingInt(...))`            |
| `averagingInt()`      | Average                     | Double                | `.collect(averagingInt(...))`          |
| `summarizingInt()`    | Count, sum, avg, min, max   | SummaryStats          | `.collect(summarizingInt(...))`        |
| `groupingBy()`        | Group by key                | Map<K, List<V>>       | `.collect(groupingBy(...))`            |
| `partitioningBy()`    | Boolean split               | Map<Boolean, List<V>> | `.collect(partitioningBy(...))`        |
| `mapping()`           | Transform before collect    | Nested                | `.mapping(..., toList())`              |
| `reducing()`          | Custom reduction            | Any                   | `.reducing(identity, op)`              |
| `collectingAndThen()` | Post-process collected data | Any                   | `.collectingAndThen(..., transformer)` |

---

# 🧠 **Key Points to Remember**

1. `collect()` is the **terminal operation** that triggers stream processing.
2. `Collectors` = **predefined strategies** for gathering results.
3. `groupingBy()` behaves like SQL **GROUP BY**.
4. `partitioningBy()` → divides into **true/false** buckets.
5. `mapping()` is used to transform data **before** collecting.
6. `reducing()` allows **custom accumulation logic**.
7. Use `collectingAndThen()` for **final transformations** (e.g., unmodifiable list).
8. For **thread-safe parallel streams**, use `toConcurrentMap()`.
9. Avoid modifying the collected result inside the pipeline (immutability preferred).

---

Would you like me to create a **one-page “Stream Collectors Cheat Sheet” PDF** (visually summarizing grouping, mapping, reducing, partitioning, etc. with arrows and examples)?
It’s perfect for revision and interviews — fits on one A4 page neatly.
