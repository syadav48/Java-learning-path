Absolutely 🔥 — this is one of the **most useful cheat sheets** you can have for mastering Java Streams.
Let’s go over **all the major `Collectors` methods**, grouped by what they do, their **arguments**, and **typical scenarios** — with short code snippets for clarity.

---

# 🧠 `Collectors` — Complete Guide (with arguments + use cases)

---

## 🗂️ 1. **Collecting Elements into Containers**

| Method                      | Arguments           | Returns         | When to Use                                                                |
| --------------------------- | ------------------- | --------------- | -------------------------------------------------------------------------- |
| `toList()`                  | —                   | `List<T>`       | Collect stream elements into a `List`                                      |
| `toSet()`                   | —                   | `Set<T>`        | Collect unique elements                                                    |
| `toCollection(Supplier<C>)` | Collection supplier | `Collection<T>` | To collect into a specific collection type (e.g., `LinkedList`, `TreeSet`) |

### 🧩 Example:

```java
List<String> names = list.stream()
    .map(Employee::getName)
    .collect(Collectors.toList());
```

```java
Set<String> dept = list.stream()
    .map(Employee::getDepartment)
    .collect(Collectors.toSet());
```

```java
LinkedList<String> linkedNames = list.stream()
    .map(Employee::getName)
    .collect(Collectors.toCollection(LinkedList::new));
```

---

## 🔢 2. **Counting and Summing**

| Method                               | Arguments                        | Returns   | When to Use              |
| ------------------------------------ | -------------------------------- | --------- | ------------------------ |
| `counting()`                         | —                                | `Long`    | Count number of elements |
| `summingInt(ToIntFunction<T>)`       | Function to extract int value    | `Integer` | Sum of integer fields    |
| `summingLong(ToLongFunction<T>)`     | Function to extract long value   | `Long`    | Sum of long fields       |
| `summingDouble(ToDoubleFunction<T>)` | Function to extract double value | `Double`  | Sum of double fields     |

### 🧩 Example:

```java
long count = list.stream().collect(Collectors.counting());
int totalSalary = list.stream().collect(Collectors.summingInt(Employee::getSalary));
```

---

## 📊 3. **Averaging**

| Method                                 | Arguments | Returns  | When to Use               |
| -------------------------------------- | --------- | -------- | ------------------------- |
| `averagingInt(ToIntFunction<T>)`       | Extractor | `Double` | Average of integer fields |
| `averagingLong(ToLongFunction<T>)`     | Extractor | `Double` | Average of long fields    |
| `averagingDouble(ToDoubleFunction<T>)` | Extractor | `Double` | Average of double fields  |

### 🧩 Example:

```java
double avgSalary = list.stream().collect(Collectors.averagingInt(Employee::getSalary));
```

---

## 🧮 4. **Summarizing Statistics**

| Method                                   | Arguments | Returns                   | When to Use                               |
| ---------------------------------------- | --------- | ------------------------- | ----------------------------------------- |
| `summarizingInt(ToIntFunction<T>)`       | Extractor | `IntSummaryStatistics`    | Get count, sum, min, average, max at once |
| `summarizingLong(ToLongFunction<T>)`     | Extractor | `LongSummaryStatistics`   | —                                         |
| `summarizingDouble(ToDoubleFunction<T>)` | Extractor | `DoubleSummaryStatistics` | —                                         |

### 🧩 Example:

```java
IntSummaryStatistics stats = list.stream()
    .collect(Collectors.summarizingInt(Employee::getSalary));

System.out.println(stats.getAverage());
System.out.println(stats.getMax());
```

---

## 🧍 5. **Finding Min / Max**

| Method                 | Arguments  | Returns       | When to Use                       |
| ---------------------- | ---------- | ------------- | --------------------------------- |
| `maxBy(Comparator<T>)` | Comparator | `Optional<T>` | Get element with maximum property |
| `minBy(Comparator<T>)` | Comparator | `Optional<T>` | Get element with minimum property |

### 🧩 Example:

```java
Employee maxEmp = list.stream()
    .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)))
    .orElse(null);
```

---

## 🧩 6. **Mapping (Transforming Values)**

| Method                                        | Arguments                              | Returns                 | When to Use                                 |
| --------------------------------------------- | -------------------------------------- | ----------------------- | ------------------------------------------- |
| `mapping(Function<T, U>, Collector<U, A, R>)` | Mapper function + downstream collector | Custom collected result | When you want to transform and then collect |

### 🧩 Example:

```java
Map<String, List<String>> map = list.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment,
        Collectors.mapping(Employee::getName, Collectors.toList())));
```

➡️ Groups employees by department but only collects names.

---

## 🪣 7. **Grouping Elements**

| Method                                                        | Arguments                                        | Returns           | When to Use                                   |
| ------------------------------------------------------------- | ------------------------------------------------ | ----------------- | --------------------------------------------- |
| `groupingBy(Function<T, K>)`                                  | Key mapper                                       | `Map<K, List<T>>` | Simple grouping                               |
| `groupingBy(Function<T, K>, Collector<T, A, D>)`              | Key mapper + downstream collector                | `Map<K, D>`       | Group and apply aggregation (like sum or max) |
| `groupingBy(Function<T, K>, Supplier<M>, Collector<T, A, D>)` | Key mapper + map supplier + downstream collector | Custom Map        | Custom grouping result map type               |

### 🧩 Example:

```java
Map<String, List<Employee>> byDept = list.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment));

Map<String, Double> avgSalaryByDept = list.stream()
    .collect(Collectors.groupingBy(Employee::getDepartment,
        Collectors.averagingInt(Employee::getSalary)));
```

---

## ⚖️ 8. **Partitioning (Boolean-based Grouping)**

| Method                                             | Arguments                        | Returns                 | When to Use                              |
| -------------------------------------------------- | -------------------------------- | ----------------------- | ---------------------------------------- |
| `partitioningBy(Predicate<T>)`                     | Predicate                        | `Map<Boolean, List<T>>` | Split data into two groups (true/false)  |
| `partitioningBy(Predicate<T>, Collector<T, A, D>)` | Predicate + downstream collector | `Map<Boolean, D>`       | Partition and process groups differently |

### 🧩 Example:

```java
Map<Boolean, List<Employee>> partition = list.stream()
    .collect(Collectors.partitioningBy(e -> e.getSalary() > 60000));
```

---

## 🧱 9. **Joining Strings**

| Method                                                                      | Arguments                 | Returns  | When to Use                              |
| --------------------------------------------------------------------------- | ------------------------- | -------- | ---------------------------------------- |
| `joining()`                                                                 | —                         | `String` | Join stream of strings without delimiter |
| `joining(CharSequence delimiter)`                                           | Delimiter                 | `String` | Join with a delimiter                    |
| `joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)` | Delimiter, prefix, suffix | `String` | Join with extra formatting               |

### 🧩 Example:

```java
String names = list.stream()
    .map(Employee::getName)
    .collect(Collectors.joining(", ", "[", "]"));
```

➡️ Output: `[Suresh, Ramesh, Mahesh]`

---

## 🧠 10. **Reducing**

| Method                                                          | Arguments                    | Returns       | When to Use                 |
| --------------------------------------------------------------- | ---------------------------- | ------------- | --------------------------- |
| `reducing(BinaryOperator<T>)`                                   | Binary operator              | `Optional<T>` | Custom reduction            |
| `reducing(T identity, BinaryOperator<T>)`                       | Identity + operator          | `T`           | Reduce with starting value  |
| `reducing(U identity, Function<T,U> mapper, BinaryOperator<U>)` | Identity + mapper + operator | `U`           | Reduce after transformation |

### 🧩 Example:

```java
int totalSalary = list.stream()
    .collect(Collectors.reducing(0, Employee::getSalary, Integer::sum));
```

---

## 🎯 11. **collectingAndThen**

| Method                                                   | Arguments            | Returns | When to Use                                                                 |
| -------------------------------------------------------- | -------------------- | ------- | --------------------------------------------------------------------------- |
| `collectingAndThen(Collector<T, A, R>, Function<R, RR>)` | Collector + finisher | `RR`    | Post-process collected result (e.g., extract field, wrap in immutable list) |

### 🧩 Example:

```java
String name = list.stream()
    .collect(Collectors.collectingAndThen(
        Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
        emp -> emp.map(Employee::getName).orElse("No Employee")
    ));
```

---

## ⚙️ 12. **toMap() Variants**

| Method                                                                  | Arguments           | Returns     | When to Use           |
| ----------------------------------------------------------------------- | ------------------- | ----------- | --------------------- |
| `toMap(Function<T, K>, Function<T, V>)`                                 | Key & value mappers | `Map<K, V>` | Convert to map        |
| `toMap(Function<T, K>, Function<T, V>, BinaryOperator<V>)`              | + merge function    | `Map<K, V>` | Handle duplicate keys |
| `toMap(Function<T, K>, Function<T, V>, BinaryOperator<V>, Supplier<M>)` | + map supplier      | Custom map  | Control map type      |

### 🧩 Example:

```java
Map<String, Integer> map = list.stream()
    .collect(Collectors.toMap(Employee::getName, Employee::getSalary));

Map<String, Integer> merged = list.stream()
    .collect(Collectors.toMap(Employee::getDepartment, Employee::getSalary, Integer::sum));
```

---

# 🧾 Summary Table

| Category         | Common Collectors                                          | Typical Use                    |
| ---------------- | ---------------------------------------------------------- | ------------------------------ |
| Basic Collection | `toList`, `toSet`, `toCollection`                          | Gather elements                |
| Math             | `counting`, `summingInt`, `averagingInt`, `summarizingInt` | Compute totals or averages     |
| Aggregation      | `maxBy`, `minBy`, `reducing`, `collectingAndThen`          | Find extremes, reduce          |
| Grouping         | `groupingBy`, `partitioningBy`, `mapping`                  | Classify and aggregate         |
| Mapping          | `toMap`, `mapping`                                         | Build maps or transform values |
| String           | `joining`                                                  | Concatenate strings            |

---

Would you like me to make a **concise PDF cheat sheet** of all `Collectors` methods (with syntax + example for each)? It’s super handy for quick Java reference.
