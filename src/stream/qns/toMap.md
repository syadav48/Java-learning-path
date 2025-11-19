Here is the **cleanest, complete, all-pattern guide** for
`Collectors.toMap(keyMapper, valueMapper, mergeFunction, mapSupplier)`
with examples for every part:

---

# 🧩 **1. keyMapper Examples**

The function that extracts **key** from each stream element.

### Example A — Identity key

```java
x -> x
```

### Example B — Key from object field

```java
emp -> emp.getId()
```

### Example C — Key as string length

```java
word -> word.length()
```

---

# 🧩 **2. valueMapper Examples**

Defines **value** mapped to each key.

### Example A — Identity value

```java
x -> x
```

### Example B — Convert to uppercase

```java
str -> str.toUpperCase()
```

### Example C — Map object field

```java
emp -> emp.getName()
```

---

# 🧩 **3. mergeFunction Examples**

Executed on **duplicate keys** → defines conflict resolution.

Let `oldValue` = existing value
Let `newValue` = value from duplicate key

### A — Keep the first value

```java
(oldValue, newValue) -> oldValue
```

### B — Keep the last value

```java
(oldValue, newValue) -> newValue
```

### C — Sum values

```java
(oldValue, newValue) -> oldValue + newValue
```

### D — Combine duplicate values into list

```java
(oldList, newValue) -> { oldList.add(newValue); return oldList; }
```

---

# 🧩 **4. mapSupplier Examples**

Defines which **Map implementation** you want.

### A — HashMap

```java
HashMap::new
```

### B — LinkedHashMap (keeps insertion order)

```java
LinkedHashMap::new
```

### C — TreeMap (sorted keys)

```java
TreeMap::new
```

### D — ConcurrentHashMap (thread-safe)

```java
ConcurrentHashMap::new
```

---

# 🎯 **Putting Everything Together**

Below are **5 complete toMap() examples**, each using all 4 arguments.

---

# ✅ **Example 1 — Sum duplicate integers, HashMap**

```java
Map<Integer, Integer> result = DataFactory.numbers()
        .stream()
        .collect(Collectors.toMap(
                x -> x,              // keyMapper
                x -> x,              // valueMapper
                (oldV, newV) -> oldV + newV, // mergeFunction
                HashMap::new         // mapSupplier
        ));
```

---

# ✅ **Example 2 — Word → uppercase, keep last, LinkedHashMap**

```java
Map<String, String> map = DataFactory.words()
        .stream()
        .collect(Collectors.toMap(
                w -> w,                     // keyMapper
                w -> w.toUpperCase(),        // valueMapper
                (oldV, newV) -> newV,        // keep last
                LinkedHashMap::new
        ));
```

---

# ✅ **Example 3 — Word length → count of words, summing, TreeMap**

```java
Map<Integer, Integer> lengthCount = DataFactory.words()
        .stream()
        .collect(Collectors.toMap(
                word -> word.length(),   // key is length
                word -> 1,               // each word is 1 occurrence
                (a, b) -> a + b,         // merge by summing
                TreeMap::new             // sorted map
        ));
```

---

# ✅ **Example 4 — EmployeeID → EmployeeName, keep first, HashMap**

```java
Map<Integer, String> empMap = DataFactory.employees()
        .stream()
        .collect(Collectors.toMap(
                emp -> emp.getId(),
                emp -> emp.getName(),
                (oldV, newV) -> oldV,   // keep first name
                HashMap::new
        ));
```

---

# ✅ **Example 5 — Key to list of duplicates (List merging), LinkedHashMap**

```java
Map<Integer, List<Integer>> map = DataFactory.numbers()
        .stream()
        .collect(Collectors.toMap(
                x -> x,                          // key
                x -> new ArrayList<>(List.of(x)), // value = new list
                (oldList, newList) -> {           // merge lists
                    oldList.addAll(newList);
                    return oldList;
                },
                LinkedHashMap::new
        ));
```

---

# ⭐ If you want, I can create:

✅ a worksheet
✅ 20 practice questions
✅ visual diagrams of toMap() merging
✅ real-world examples (employees, orders, products)

Just say the word.
