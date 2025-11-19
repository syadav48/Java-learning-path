Here’s a **clear and practical explanation of `Collectors.mapping` and other important collectors**, with **simple examples** you will actually use in real code.

---

# 🎯 1. **Collectors.mapping**

### 👉 Purpose: Transform each element before collecting it

It's like doing a **map() inside a collector**.

### Example

Group employees by city **but collect only their names**:

```java
Map<String, List<String>> result =
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCity,
                        Collectors.mapping(
                                Employee::getName,
                                Collectors.toList()
                        )
                ));
```

### What it does internally

* Takes each `Employee`
* Converts to `String` (name)
* Stores in a list grouped by city

---

# 🎯 2. **Collectors.toList()**

Collect all elements into a **List**.

### Example

```java
List<String> names = employees.stream()
        .map(Employee::getName)
        .collect(Collectors.toList());
```

---

# 🎯 3. **Collectors.toSet()**

Collect elements into a **Set** (no duplicates).

### Example

```java
Set<String> cities = employees.stream()
        .map(Employee::getCity)
        .collect(Collectors.toSet());
```

---

# 🎯 4. **Collectors.joining()**

Join strings with optional delimiter.

### Example

```java
String allNames = employees.stream()
        .map(Employee::getName)
        .collect(Collectors.joining(", "));
```

---

# 🎯 5. **Collectors.groupingBy()**

Group elements into a **Map<Key, List<Value>>**.

### Example: group by city

```java
Map<String, List<Employee>> grouped =
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity));
```

---

# 🎯 6. **Collectors.partitioningBy()**

Split elements into **two groups** (boolean condition).

### Example: salary > 50,000

```java
Map<Boolean, List<Employee>> partitioned =
        employees.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.getSalary() > 50000
                ));
```

Result:

* `true` → high salary employees
* `false` → others

---

# 🎯 7. **Collectors.counting()**

Count elements.

```java
Map<String, Long> countByCity =
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCity,
                        Collectors.counting()
                ));
```

---

# 🎯 8. **Collectors.maxBy() / minBy()**

Find max or min element by comparator.

### Example: highest salary employee

```java
Optional<Employee> maxSalary =
        employees.stream()
                .collect(Collectors.maxBy(
                        Comparator.comparing(Employee::getSalary)
                ));
```

---

# 🎯 9. **Collectors.summingInt(), summingDouble()**

Sum values.

### Total salary:

```java
Double totalSalary = employees.stream()
        .collect(Collectors.summingDouble(Employee::getSalary));
```

---

# 🎯 10. **Collectors.averagingInt(), averagingDouble()**

Compute average.

```java
Double avgSalary = employees.stream()
        .collect(Collectors.averagingDouble(Employee::getSalary));
```

---

# 🎯 11. **Collectors.collectingAndThen()**

"Finish up" the collected result (post-processing).

### Example: group by city and sort names

```java
Map<String, List<String>> sorted =
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCity,
                        Collectors.collectingAndThen(
                                Collectors.mapping(Employee::getName, Collectors.toList()),
                                list -> list.stream().sorted().toList()
                        )
                ));
```

---

# 🎯 12. **Collectors.reducing()**

Manual reduction inside collector.

### Example: sum salaries using reducing

```java
Double total = employees.stream()
        .collect(Collectors.reducing(
                0.0,
                Employee::getSalary,
                Double::sum
        ));
```

---

# 🔥 Summary Table

| Collector                    | Purpose                          |
| ---------------------------- | -------------------------------- |
| **mapping**                  | Transform value before storing   |
| **toList / toSet / joining** | Collect into list / set / string |
| **groupingBy**               | Group by key                     |
| **partitioningBy**           | True/false split                 |
| **counting**                 | Count items                      |
| **maxBy / minBy**            | Max/min by comparator            |
| **summing / averaging**      | Numbers operations               |
| **collectingAndThen**        | Post-process result              |
| **reducing**                 | Custom reduction                 |

---

If you want, I can create a **visual diagram**, **cheat sheet**, or **real project-like examples** (based on Employee model) to make all collectors crystal clear.
