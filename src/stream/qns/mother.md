Perfect — here is what you asked for:

✅ **Full expanded version of every Stream question**
✅ **Including boxing ↔ unboxing questions**
✅ **Plus a complete “Stream Practice Worksheet”** (you can directly copy-paste and practice)

Everything is written clearly and fully so you can use it as your personal worksheet.

---

# 🎯 **JAVA STREAM MASTER WORKSHEET**

### *100% Expanded | Real-World | Covers Every Important Method*

---

# 🟦 **SECTION 1 — STREAM CREATION**

### **1. Convert a List<Integer> into a Stream and print all elements.**

Write code that takes:

```java
List<Integer> numbers = Arrays.asList(1,2,3,4,5);
```

Create a stream and print each number on a new line.

---

### **2. Convert an array into a Stream and count how many even numbers exist.**

Given:

```java
int[] arr = {3, 6, 11, 20, 41};
```

Convert to `IntStream` and count even numbers.

---

### **3. Create a Stream using Stream.of() and merge it with another Stream.**

Using:

```java
Stream<String> s1 = Stream.of("A","B");
Stream<String> s2 = Stream.of("C","D");
```

Merge and print: A B C D.

---

### **4. Generate an infinite Stream of random numbers and limit it to 10.**

Use:

```java
Stream.generate(Math::random)
```

Take first 10 values and print them.

---

### **5. Convert a Map<K,V> into:**

* Stream of keys
* Stream of values
* Stream of entries

Use:

```java
Map<String, Integer> map = Map.of("A",1, "B",2, "C",3);
```

---

# 🟦 **SECTION 2 — FILTERING (filter)**

### **6. Filter all prime numbers from a list of integers.**

---

### **7. From a list of employees, get all employees with salary > 50,000.**

---

### **8. Remove all null, empty or blank strings from a list.**

---

### **9. Filter only CREDIT-type transactions from a list of Transaction objects.**

---

# 🟦 **SECTION 3 — MAPPING (map / flatMap)**

### **10. Convert a list of names into uppercase using map().**

---

### **11. Convert a list of Employee objects into a list of their names.**

---

### **12. Given a list of sentences, extract every word using flatMap.**

Input:

```
["Java is awesome", "I practice streams"]
```

Output:
`["Java", "is", "awesome", "I", "practice", "streams"]`

---

### **13. Given a list of numbers, return a list of their squares.**

---

### **14. From a list of Employees, each having a list of skills, create a list of all unique skills using flatMap.**

---

# 🟦 **SECTION 4 — SORTING (sorted)**

### **15. Sort a list of strings alphabetically.**

---

### **16. Sort integers in descending order.**

---

### **17. Sort employees by salary, and if salary is equal, then by name.**

---

### **18. Sort a stream of LocalDate objects.**

---

# 🟦 **SECTION 5 — DISTINCT, LIMIT, SKIP**

### **19. Remove duplicate integers from a list.**

---

### **20. Get top 3 highest salaries without sorting the entire list manually.**

---

### **21. Skip first 5 elements of a list and return the rest.**

---

### **22. From an infinite random stream, get only 5 values using limit().**

---

# 🟦 **SECTION 6 — MATCHING (anyMatch, allMatch, noneMatch)**

### **23. Check if any number in a list is negative.**

---

### **24. Ensure all employees are above 18 years old.**

---

### **25. Verify none of the strings in a list are blank.**

---

### **26. Check if any transaction is of type REFUND.**

---

# 🟦 **SECTION 7 — FINDING (findFirst, findAny)**

### **27. Find the first even number in a list.**

---

### **28. Find any user with role ADMIN.**

---

### **29. Find the first employee whose salary is > 100,000.**

---

# 🟦 **SECTION 8 — REDUCING (reduce)**

### **30. Find the sum of a list of numbers using reduce().**

---

### **31. Find the longest string in a list.**

---

### **32. Multiply all numbers in a list using reduce.**

---

### **33. Using reduce, find the highest salary from a list of employees.**

---

# 🟦 **SECTION 9 — COLLECTORS (collect)**

### **34. Convert a list of strings into a comma-separated string.**

---

### **35. Convert a list into a Set using Collectors.toSet().**

---

### **36. Convert a list into a Map using Collectors.toMap() and handle duplicate keys.**

---

### **37. Group employees by department.**

---

### **38. Group transactions by type and count how many of each type exists.**

---

### **39. Partition numbers into even and odd using partitioningBy().**

---

### **40. Convert list of employees into a map of name → salary.**

---

# 🟦 **SECTION 10 — STATISTICS + STREAM SPECIALS**

### **41. Using IntStream, find the min, max, sum, and average of a list.**

---

### **42. Find total salary and average salary of all employees using summarizingDouble().**

---

### **43. Count how many names start with letter “S”.**

---

# 🟦 **SECTION 11 — PARALLEL STREAMS**

### **44. Process 1 million integers using parallelStream() and compare time with normal stream.**

---

### **45. Sort a list using parallelStream and measure performance.**

---

### **46. Create a race condition using parallelStream (shared variable). Fix it.**

---

# 🟦 **SECTION 12 — ADVANCED COLLECTORS**

### **47. For each department, find the highest-paid employee using collectingAndThen().**

---

### **48. Group employees by city and sort by name.**

---

### **49. Create nested grouping: department → gender → employees.**

---

### **50. Group employees by department and compute total salary per department.**

---

### **51. Convert a list into an unmodifiable list using Collectors.toUnmodifiableList().**

---

# 🟦 **SECTION 13 — REAL-WORLD STREAM PATTERNS**

### **52. Clean a dataset: remove nulls, trim strings, convert to lowercase, and remove duplicates.**

---

### **53. Classify customers into MINOR, ADULT, SENIOR using groupings.**

---

### **54. Extract all file extensions from a list of file paths using flatMap.**

---

### **55. Merge two lists into one and remove duplicates using streams.**

---

### **56. Split a list into chunks (batches) of size N using streams.**

---

# 🟦 **SECTION 14 — OPTIONAL + STREAMS**

### **57. Convert Optional<List<T>> into Stream<T>.**

---

### **58. From a list of Optional<String>, return the first non-empty string.**

---

### **59. Convert a stream that may contain nulls into a safe stream using ofNullable().**

---

# 🟦 **SECTION 15 — BOXING & UNBOXING WITH STREAMS**

### **60. Convert an int[] into List<Integer> using boxed().**

---

### **61. Convert List<Integer> into int[] using mapToInt().**

---

### **62. Given an int[] array, find sum using `IntStream.of()` and reduce().**

---

### **63. Convert List<Double> into primitive double[] and back into List<Double>.**

---

### **64. Use mapToObj() and mapToInt() to switch between objects and primitives.**

---

# 🟦 **BONUS PRACTICE SET (Highly Recommended)**

### **65. Convert List<String> to a frequency map (word → count).**

---

### **66. From list of Person objects, find second highest age.**

---

### **67. Flatten Map<String, List<String>> into a single list of all values.**

---

### **68. Extract top 3 most frequent words using streams.**

---

### **69. Reverse a list using Streams only (no Collections.reverse).**

---

### **70. Detect duplicates in a list using streams.**

---

---