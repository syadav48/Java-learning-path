Perfect 👍
Here’s the **updated table** — I’ve added a **“Sample Input / Example Data”** column so you can directly start coding each problem without thinking up test data.
Each question now has:
✅ Clear problem statement
✅ Recommended methods/concepts
✅ Sample string or dataset to test

---

## 🧩 **15 Intermediate HashMap Practice Questions (with Methods + Sample Inputs)**

| #      | Question                                                                                               | Recommended HashMap Methods / Concepts                      | 🧪 Sample Input / Example Data                                |
| ------ | ------------------------------------------------------------------------------------------------------ | ----------------------------------------------------------- | ------------------------------------------------------------- |
| **1**  | Write a program to count the frequency of each character in a given string.                            | `containsKey()`, `get()`, `put()`, `forEach()`              | `"programming"` → `{p=1, r=2, o=1, g=2, a=1, m=2, i=1, n=1}`  |
| **2**  | Given a list of names, count how many times each name appears and print only the names with count > 1. | `putIfAbsent()`, `getOrDefault()`, `entrySet()`             | `["John", "Mary", "John", "Alex", "Mary", "Steve"]`           |
| **3**  | Merge two HashMaps representing item prices — if a key exists in both, keep the higher price.          | `merge()`, `forEach()`, `put()`                             | Map1: `{Apple=80, Banana=40}`, Map2: `{Banana=45, Orange=60}` |
| **4**  | Create a HashMap of students and marks. Remove entries where marks < 40.                               | `entrySet()`, `removeIf()`                                  | `{Amit=78, Rohit=35, Neha=90, Tina=39}`                       |
| **5**  | Find the key with the maximum value in a HashMap of product → sales.                                   | `entrySet()`, `Collections.max()`, `getValue()`             | `{Shoes=120, Watch=150, Belt=80, Bag=200}`                    |
| **6**  | Sort a HashMap by its keys and print it.                                                               | `TreeMap`, `keySet()`, `entrySet()`                         | `{Zebra=1, Apple=3, Mango=2, Banana=5}`                       |
| **7**  | Sort a HashMap by values (ascending or descending).                                                    | `entrySet()`, `Comparator.comparing()`, `stream().sorted()` | `{India=7, Japan=4, USA=10, China=6}`                         |
| **8**  | Check if two HashMaps are equal (contain same key-value pairs).                                        | `equals()`, `keySet()`, `values()`                          | Map1: `{A=1, B=2, C=3}`, Map2: `{B=2, C=3, A=1}`              |
| **9**  | Create a HashMap and print all keys, values, and key-value pairs in different ways.                    | `keySet()`, `values()`, `entrySet()`, `forEach()`           | `{101=Raj, 102=Simran, 103=Aman}`                             |
| **10** | Demonstrate difference between `put()` and `putIfAbsent()`.                                            | `put()`, `putIfAbsent()`                                    | Insert `key=1, value="A"`, then again `key=1, value="B"`      |
| **11** | Use `computeIfPresent()` to update values and `computeIfAbsent()` to initialize new ones.              | `computeIfPresent()`, `computeIfAbsent()`                   | `{a=2, b=3}`, compute `a * 10`, add key `c` with value `5`    |
| **12** | Remove a mapping only if key-value pair matches a specific value.                                      | `remove(key, value)`                                        | `{Red=1, Blue=2, Green=3}` → remove `"Blue", 2`               |
| **13** | Replace all values in a HashMap with their squares.                                                    | `replaceAll()`                                              | `{1=2, 2=3, 3=4}` → `{1=4, 2=9, 3=16}`                        |
| **14** | Demonstrate difference between `get()` and `getOrDefault()` when a key is missing.                     | `get()`, `getOrDefault()`                                   | `{101=Apple, 102=Banana}` → search for key `103`              |
| **15** | Group words in a list by their length (e.g., `{3=[cat, dog], 4=[lion]}`).                              | `computeIfAbsent()`, `List::add`, `forEach()`               | `["cat", "dog", "lion", "tiger", "bat"]`                      |

---

Would you like me to take these same 15 and turn them into **Java skeletons (method templates)** so you can practice writing the logic in each one systematically?
