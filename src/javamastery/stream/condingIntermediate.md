Excellent 🔥 — since you’ve mastered the basics, let’s level up!
Here are **20 Intermediate-Level Java Stream & Collectors Questions** that cover **mapping, grouping, reduction, custom collectors, flatMapping, primitive streams, and advanced use-cases** 👇

---

## ⚙️ **20 Intermediate Java Stream & Collector Questions**

### **1️⃣ Group by + Count**

Given a list of strings, group them by their first letter and count how many start with each letter.

```java
List<String> names = Arrays.asList("Ram", "Ravi", "Ramesh", "Sita", "Sunil");
```

👉 *Concepts:* `Collectors.groupingBy()`, `Collectors.counting()`.

---

### **2️⃣ Find Max using Collectors**

Find the employee with the **maximum salary** using `Collectors.maxBy()`.

```java
class Employee { String name; double salary; }
```

👉 *Concepts:* `Collectors.maxBy()`, `Comparator.comparing()`.

---

### **3️⃣ Summarizing Statistics**

Given a list of integers, produce statistics (count, min, max, avg, sum).
👉 *Concepts:* `Collectors.summarizingInt()`.

---

### **4️⃣ Joining Strings**

Join a list of strings into a single comma-separated string.

```java
List<String> cities = Arrays.asList("Delhi", "Mumbai", "Pune");
```

👉 *Concepts:* `Collectors.joining(", ")`.

---

### **5️⃣ Custom Reduce**

Use `reduce()` to concatenate all strings in uppercase separated by a “-”.
👉 *Concepts:* Reduction + accumulator.

---

### **6️⃣ Map of Department ➜ Avg Salary**

Group employees by department and calculate the average salary per department.
👉 *Concepts:* `groupingBy()` + `averagingDouble()`.

---

### **7️⃣ Multi-Level Grouping**

Group employees by department, and within each department, by job title.
👉 *Concepts:* Nested `Collectors.groupingBy()`.

---

### **8️⃣ FlatMap with Nested Collections**

Given a list of `Employee` objects, where each has a list of `skills`, create a list of all unique skills.
👉 *Concepts:* `flatMap()` + `distinct()`.

---

### **9️⃣ Collectors.mapping()**

Group employees by department and collect only their names (not the whole object).
👉 *Concepts:* `groupingBy()` + `mapping()`.

---

### **🔟 Custom Collector (toSet or toMap)**

Collect a stream of `Person` objects into a `Map<id, name>`.
👉 *Concepts:* `Collectors.toMap()` + merge handling.

---

### **11️⃣ PartitioningBy**

Partition numbers into even and odd using `Collectors.partitioningBy()`.
👉 *Concepts:* Boolean predicate-based partitioning.

---

### **12️⃣ Collectors.collectingAndThen**

Get the employee with the highest salary and extract only the name (post-processing).
👉 *Concepts:* `collectingAndThen()` with `maxBy()`.

---

### **13️⃣ Using Optional in Collectors**

Find the oldest person in a list, handle the case where the list might be empty.
👉 *Concepts:* `Optional` with `max()`.

---

### **14️⃣ Stream Reuse Issue**

Explain why the following code fails and how to fix it:

```java
Stream<String> s = Stream.of("A", "B", "C");
s.forEach(System.out::println);
s.count(); // Error
```

👉 *Concepts:* Single-use nature of streams.

---

### **15️⃣ Parallel Stream Performance**

Use `parallelStream()` on a large dataset and compare its speed vs sequential.
👉 *Concepts:* Parallel processing.

---

### **16️⃣ Using `peek()`**

Print intermediate results while transforming a list of integers into their squares.
👉 *Concepts:* `peek()` for debugging streams.

---

### **17️⃣ Collect to Immutable List**

Collect stream results into an **unmodifiable list**.
👉 *Concepts:* `Collectors.toUnmodifiableList()` (Java 10+).

---

### **18️⃣ Filter + MinBy**

From a list of students, find the student with the lowest marks in “Maths”.
👉 *Concepts:* `filter()` + `min()` or `minBy()`.

---

### **19️⃣ FlatMap + Collectors.groupingBy()**

Given a list of departments (each having a list of employees), group all employees (across departments) by designation.
👉 *Concepts:* `flatMap()` + `groupingBy()`.

---

### **20️⃣ Reduce + Complex Object**

Compute the **total salary expense** of all employees using `reduce()` on a stream of `Employee`.
👉 *Concepts:* Custom reduction with accumulator and combiner.

---

## 🧠 **Bonus (Advanced Collector Combinations)**

**21️⃣ Combining Collectors:**
Group students by class and then count how many scored above 75 in each class using

```java
groupingBy(Student::getClass, filtering(s -> s.getMarks() > 75, counting()))
```

👉 *Concepts:* `Collectors.filtering()` (Java 9+).

---

## 💡 **Key Points to Remember**

| Concept               | Collector/Stream API            | Use                        |
| --------------------- | ------------------------------- | -------------------------- |
| `groupingBy()`        | Groups data based on classifier | Aggregation                |
| `mapping()`           | Transforms grouped data         | Nested mapping             |
| `counting()`          | Counts elements per group       | Frequency                  |
| `averagingInt/Double` | Averages numeric values         | Analytics                  |
| `joining()`           | Concatenate strings             | String output              |
| `partitioningBy()`    | Boolean split (true/false)      | Categorization             |
| `collectingAndThen()` | Post-process collected result   | Transformation             |
| `flatMap()`           | Flatten nested collections      | List of lists              |
| `reduce()`            | Custom aggregation              | Non-collector-based reduce |

---

Would you like me to make this list into a **practice worksheet (with answer templates)** — like function signatures and expected output hints for each?
That format helps when preparing for interviews or self-practice.
