Ah yes! Let’s fix that. For **HashSet practice**, I’ll provide **all 20 questions with sample inputs** so you can directly use them in code for practice.

---

# **HashSet Practice Questions with Sample Input**

| #  | Question                                                                    | Sample Input                                            | Recommended Methods                                                     |
| -- | --------------------------------------------------------------------------- | ------------------------------------------------------- | ----------------------------------------------------------------------- |
| 1  | Remove duplicate elements from a list of integers and return a HashSet.     | `List<Integer> nums = Arrays.asList(1,2,2,3,4,4,5)`     | `addAll()`, `add()`                                                     |
| 2  | Check if a HashSet contains all elements of another HashSet.                | `set1={1,2,3}`, `set2={2,3}`                            | `containsAll()`                                                         |
| 3  | Find the union of two HashSets.                                             | `set1={1,2,3}`, `set2={3,4,5}`                          | `addAll()`, `forEach()`                                                 |
| 4  | Find the intersection of two HashSets.                                      | `set1={1,2,3,4}`, `set2={3,4,5,6}`                      | `retainAll()`                                                           |
| 5  | Find the difference (elements present in first set but not in second).      | `set1={1,2,3,4}`, `set2={3,4,5,6}`                      | `removeAll()`                                                           |
| 6  | Iterate through a HashSet and print only even numbers.                      | `set={1,2,3,4,5,6}`                                     | `forEach()`, `iterator()`                                               |
| 7  | Convert a HashSet of strings to uppercase using Streams.                    | `set={"apple","banana","orange"}`                       | `stream()`, `map()`, `collect()`                                        |
| 8  | Count the number of elements that start with a given character.             | `set={"apple","banana","apricot","mango"}`, char='a'    | `stream()`, `filter()`, `count()`                                       |
| 9  | Remove elements from a HashSet that satisfy a condition (e.g., length > 5). | `set={"apple","banana","orange"}`                       | `removeIf()`, `iterator()`                                              |
| 10 | Check if two HashSets are equal (same elements).                            | `set1={"a","b","c"}`, `set2={"b","a","c"}`              | `equals()`, `containsAll()`                                             |
| 11 | Find the maximum and minimum element in a HashSet of integers.              | `set={10, 5, 20, 15}`                                   | `Collections.max()`, `Collections.min()`, `stream()`                    |
| 12 | Convert a HashSet to an array or list.                                      | `set={1,2,3,4}`                                         | `toArray()`, `stream().collect(Collectors.toList())`                    |
| 13 | Find elements present in only one HashSet (symmetric difference).           | `set1={1,2,3}`, `set2={3,4,5}`                          | `removeAll()`, `addAll()`                                               |
| 14 | Partition a HashSet into two sets based on a predicate (odd vs even).       | `set={1,2,3,4,5,6}`                                     | `stream()`, `filter()`, `Collectors.partitioningBy()`                   |
| 15 | Remove all null elements from a HashSet.                                    | `set={1,null,2,null,3}`                                 | `removeIf()`, `iterator()`                                              |
| 16 | Check if a HashSet is empty or not.                                         | `set={}`                                                | `isEmpty()`                                                             |
| 17 | Iterate and sort a HashSet of integers in ascending order.                  | `set={5,3,8,1}`                                         | `stream()`, `sorted()`, `collect()`                                     |
| 18 | Find duplicates in a List using HashSet.                                    | `list={1,2,3,2,4,5,3}`                                  | `add()`, `contains()`                                                   |
| 19 | Merge multiple HashSets into a single HashSet without duplicates.           | `set1={1,2,3}`, `set2={3,4}`, `set3={5,1}`              | `addAll()`, `forEach()`                                                 |
| 20 | Count frequency of first characters of strings in a HashSet.                | `set={"apple","apricot","banana","blueberry","cherry"}` | `stream()`, `map()`, `Collectors.groupingBy()`, `Collectors.counting()` |

---

✅ These sample inputs allow you to **practice each question directly in Java** using either **classic HashSet methods** or **Streams**.

If you want, I can **write a complete working code file** with **all 20 questions solved**, including both **traditional and Streams approaches** — ready to run and test.

Do you want me to do that next?
