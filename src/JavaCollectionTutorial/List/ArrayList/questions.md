Perfect 💪 — now we’re leveling up!
Since you already find ArrayList basics easy, let’s move into **enhanced intermediate + advanced questions** — the type that tests **problem solving, algorithmic thinking, and mastery of the Collection API.**

Below is a **table of 20 questions** — covering sorting, filtering, transformation, searching, merging, grouping, custom objects, and Java 8 stream-based challenges.
Each row includes:
✅ Question Title
📜 Description / Task
🧠 Focus Concept

---

### 🧩 **20 Enhanced Intermediate + Advanced ArrayList Questions**

| No. | Question Title                                         | Description / Task                                                                         | Focus Concept                         |
| --- | ------------------------------------------------------ | ------------------------------------------------------------------------------------------ | ------------------------------------- |
| 1   | **Remove Duplicates Without Using Set**                | Remove duplicates from an ArrayList *without converting it to a Set*.                      | Nested iteration / `contains()` logic |
| 2   | **Find Second Highest Element**                        | Find the **second largest** number from an ArrayList of integers.                          | Sorting / max logic                   |
| 3   | **Rotate ArrayList by K Positions**                    | Rotate list elements `k` times to the right. Example: `[1,2,3,4,5] → [4,5,1,2,3]` when k=2 | Modulo indexing / sublist             |
| 4   | **Find Common Elements Between Two Lists**             | Given two lists, find their intersection (common elements).                                | RetainAll / Stream filter             |
| 5   | **Remove Elements Greater Than X**                     | Remove all numbers greater than a given value `X` from the list.                           | `removeIf()` / Predicate              |
| 6   | **Find Frequency Map of Elements**                     | Count how many times each number appears in an ArrayList. Output: `{2=3, 5=1, 7=2}`        | Map counting / Stream groupingBy      |
| 7   | **Sort Strings by Length (then Alphabetically)**       | Sort a list of strings first by length, then alphabetically if lengths are same.           | Custom Comparator chaining            |
| 8   | **Find All Pairs with Given Sum**                      | From a list of integers, print all pairs whose sum equals a target value.                  | Nested loops / HashSet                |
| 9   | **Partition Even and Odd Numbers**                     | Separate a mixed list into two — even and odd — using Streams or loops.                    | Filtering / Collectors.partitioningBy |
| 10  | **Find All Duplicates**                                | Print only those elements that appear more than once.                                      | Frequency counting / Streams          |
| 11  | **Merge Two Sorted Lists**                             | Merge two *already sorted* lists into a single sorted list (like merge sort step).         | Two-pointer technique                 |
| 12  | **Remove Null or Empty Strings**                       | Clean a String list by removing `null`, `""`, or whitespace-only elements.                 | `removeIf()` / `Objects::nonNull`     |
| 13  | **Custom Object Sorting (Multiple Fields)**            | Sort `List<Employee>` by department, then salary descending, then name.                    | Comparator + thenComparing            |
| 14  | **Group by First Character of Name**                   | Group names like `["Alice","Aaron","Bob"]` → `{A=[Alice, Aaron], B=[Bob]}`                 | Streams + Collectors.groupingBy       |
| 15  | **Reverse Words in a Sentence**                        | Convert `"Java is awesome"` → `"awesome is Java"` using ArrayList.                         | String split, Collections.reverse     |
| 16  | **Find Sublist of Unique Elements**                    | Return a new list containing only the first occurrence of each element (preserve order).   | LinkedHashSet logic / stream distinct |
| 17  | **Compare Two Lists for Equality (Order Independent)** | Return `true` if two lists have the same elements ignoring order.                          | Sort both or use frequency map        |
| 18  | **Flatten List of Lists**                              | Convert `List<List<Integer>>` → single `List<Integer>` (flat list).                        | `flatMap()` / nested loops            |
| 19  | **Find Missing Numbers Between Range**                 | Given list `[1,3,4,7]` → missing `[2,5,6]`. Range based on min/max.                        | Range iteration / contains check      |
| 20  | **Top 3 Highest Salaries per Department**              | Given `List<Employee>`, find top 3 salaries for each department.                           | Streams + grouping + sorting + limit  |

---

### 💡 Example Sample Data to Use

You can reuse across problems:

```java
List<Integer> numbers = Arrays.asList(5, 1, 3, 3, 9, 7, 5, 9, 2);
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Aaron", "Bella", "Anna", "Alex");

List<Employee> employees = Arrays.asList(
    new Employee(101, "Alice", 28, 70000, "IT"),
    new Employee(102, "Bob", 35, 85000, "Finance"),
    new Employee(103, "Charlie", 25, 55000, "IT"),
    new Employee(104, "David", 40, 95000, "HR"),
    new Employee(105, "Eve", 30, 80000, "Finance"),
    new Employee(106, "Frank", 29, 70000, "HR"),
    new Employee(107, "Grace", 32, 90000, "IT"),
    new Employee(108, "Hank", 45, 120000, "Management"),
    new Employee(109, "Ivy", 27, 68000, "IT"),
    new Employee(110, "Jack", 33, 87000, "Finance")
);
```

---

### ⚙️ Suggested Practice Order:

* **Q1–Q5** → Algorithmic manipulation
* **Q6–Q10** → Counting, grouping, filtering
* **Q11–Q15** → Sorting & transforming
* **Q16–Q20** → Stream API + real-world analytics

---

Would you like me to make a **“Practice Workbook” Java file** (`ArrayListChallenges.java`) that includes method stubs for all 20 questions (so you can implement and test one by one)?
