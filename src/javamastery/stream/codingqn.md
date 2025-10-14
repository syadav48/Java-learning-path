Perfect 👍 — here are **10 Java Stream API questions** ranging from **basic to intermediate**, designed to test both **concepts and hands-on understanding** 👇

---

## 🧩 **10 Java Stream Questions (Basic ➜ Intermediate)**

### **1️⃣ Basic Stream Creation**

**Q1.**
Write code to create a `Stream` from a list of integers and print only even numbers.

```java
List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
```

🧠 *Concept Tested:*
Stream creation + filter + forEach.

---

### **2️⃣ Mapping Transformation**

**Q2.**
Given a list of strings, convert each string to uppercase using Streams.

```java
List<String> names = Arrays.asList("ram", "shyam", "mohan");
```

🧠 *Concept Tested:*
`map()` + lambda expression.

---

### **3️⃣ Collecting Results**

**Q3.**
Convert a list of integers to a list of their squares using Stream API and collect into a new list.

🧠 *Concept Tested:*
`map()` + `collect(Collectors.toList())`.

---

### **4️⃣ Filtering + Counting**

**Q4.**
Given a list of words, count how many words start with the letter “A”.

🧠 *Concept Tested:*
`filter()` + `count()` (terminal operation).

---

### **5️⃣ Reduce Operation**

**Q5.**
Use Stream’s `reduce()` method to find the product of all numbers in a list.

```java
List<Integer> nums = Arrays.asList(2, 3, 4);
```

🧠 *Concept Tested:*
Reduction and lambda accumulator `(a, b) -> a * b`.

---

### **6️⃣ Stream Sorting**

**Q6.**
Sort a list of employee names in **reverse alphabetical order** using Streams.

```java
List<String> employees = Arrays.asList("John", "Amit", "Ravi", "Deepak");
```

🧠 *Concept Tested:*
`sorted(Comparator.reverseOrder())`.

---

### **7️⃣ Distinct and Limit**

**Q7.**
From a list of integers with duplicates, print the **first 3 distinct even numbers**.

🧠 *Concept Tested:*
`distinct()` + `filter()` + `limit()`.

---

### **8️⃣ Collectors Grouping**

**Q8.**
Given a list of employees with department names, group them by department using `Collectors.groupingBy()`.

```java
class Employee {
   String name; String dept;
   // constructor, getters
}
```

🧠 *Concept Tested:*
`Collectors.groupingBy(Employee::getDept)`.

---

### **9️⃣ FlatMap**

**Q9.**
You have a list of lists of integers:

```java
List<List<Integer>> numbers = Arrays.asList(Arrays.asList(1,2), Arrays.asList(3,4), Arrays.asList(5));
```

Flatten it into a single list using Stream API.

🧠 *Concept Tested:*
`flatMap(Collection::stream)`.

---

### **🔟 Parallel Stream**

**Q10.**
Given a list of large integers, demonstrate how to calculate their sum using `parallelStream()` instead of a normal stream.

🧠 *Concept Tested:*
Difference between `stream()` and `parallelStream()` — parallel execution.

---

## 🏁 Bonus Challenge:

**Q11 (Optional):**
Use `Collectors.partitioningBy()` to separate even and odd numbers from a list.

---

Would you like me to give you the **answers + expected output** for each of these (so you can make it a mini practice sheet)?
