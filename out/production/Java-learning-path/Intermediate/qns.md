# 📌 Java Intermediate Level Practice Roadmap (1 Week)

This roadmap contains **80 intermediate-level Java practice problems** across **Strings, Collections, Streams, and Functions/Collectors**. The plan is divided into **7 days** so you can practice consistently and steadily. Each problem is fully detailed.

---

## 📅 **Day 1: Strings (20 Questions)**

1. Reverse each word in a sentence while keeping the word order intact.

    * Input: `"Java is fun"` → Output: `"avaJ si nuf"`
2. Find the longest word in a sentence.

    * Input: `"Java programming language"` → Output: `"programming"`
3. Remove all duplicate characters from a string.

    * Input: `"programming"` → Output: `"progamin"`
4. Check if two strings are rotations of each other.

    * Input: `"abcd", "cdab"` → Output: `true`
5. Count the frequency of each word in a sentence.
6. Find the longest palindromic substring in a string.
7. Implement your own version of `substring()` without using built-in `substring()`.
8. Convert a Roman numeral string to an integer.

    * Input: `"XIV"` → Output: `14`
9. Generate all permutations of a given string.
10. Check if a string is a valid shuffle of two other strings.
11. Find the smallest window in a string containing all characters of another string.
12. Implement string compression (replace consecutive characters with counts).

* Input: `"aaabbc"` → Output: `"a3b2c1"`

13. Group a list of words into anagrams.

* Input: `["eat", "tea", "tan", "ate", "nat", "bat"]`

14. Convert a string into a zigzag pattern with `n` rows.
15. Implement a regex-like matcher supporting `.` and `*`.
16. Remove all non-alphanumeric characters from a string.
17. Find the longest common prefix among an array of strings.
18. Check if a string has all unique characters without using extra data structures.
19. Implement a method to find edit distance (Levenshtein distance) between two strings.
20. Implement word wrap: break a long string into multiple lines of max `k` characters.

---

## 📅 **Day 2: Collections (20 Questions)**

1. Find the second largest element in an `ArrayList<Integer>`.
2. Use a `HashMap` to count word occurrences in a paragraph.
3. Remove duplicates from a `List` without using a `Set`.
4. Sort a list of `Student` objects by marks (create Student class with `name`, `marks`).
5. Implement a custom `Stack` class using `LinkedList`.
6. Find the intersection of two `ArrayList<Integer>`.
7. Implement a `Queue` using two `Stacks`.
8. Find the top `k` most frequent elements in a list.
9. Use a `TreeMap` to store students (roll number → name) and print in descending order.
10. Implement an LRU Cache using `LinkedHashMap`.
11. Detect if a `LinkedList` has a cycle.
12. Implement a `PriorityQueue` for `Task` objects (taskName, priority).
13. Merge overlapping intervals stored in a `List<int[]>`.
14. Design a system to store student records and fetch top scorer efficiently.
15. Build a simple in-memory key-value database using `HashMap` (support insert, delete, search).
16. Implement a phone book using `Map<String, List<String>>` (name → phone numbers).
17. Sort a `List<String>` by the frequency of characters.
18. Convert a `HashMap` into a list of entries sorted by values.
19. Use `Deque` to check if a string is a palindrome.
20. Implement a custom iterator for an array.

---

## 📅 **Day 3: Streams (20 Questions)**

1. Find all unique characters in a string using streams.
2. Given a list of numbers, find the sum of squares of even numbers using streams.
3. Sort a list of strings by their length using streams.
4. Find the first element greater than 50 in a list using streams.
5. Convert a list of integers to a comma-separated string using streams.
6. Find duplicate elements in a list using streams.
7. Group words by their first letter using streams.
8. Partition numbers into primes and non-primes using streams.
9. Find the second highest number in a list using streams.
10. Flatten a list of lists (2D list) into a single list using streams.
11. Count the frequency of characters in a string using streams.
12. Find the longest string in a list using streams.
13. Use parallel streams to calculate the factorial of a number.
14. Read a text file and count word frequency using `Files.lines()` and streams.
15. Implement a leaderboard system: sort players by score and get the top 3 using streams.
16. Find common elements between two lists using streams.
17. Remove all null values from a list using streams.
18. Find all palindromic strings in a list using streams.
19. Sort employees by department and then by salary using streams.
20. Use `reduce()` to calculate the product of all integers in a list.

---

## 📅 **Day 4: Functions & Collectors (20 Questions)**

**Functions / Functional Interfaces:**

1. Write a `Predicate<Integer>` to check if a number is prime.
2. Write a `Function<String, Integer>` to return the length of a string.
3. Chain two functions: convert a string to uppercase, then get its length.
4. Write a `BiFunction<Integer, Integer, Integer>` to calculate the GCD of two numbers.
5. Use a `Consumer<String>` to print strings with their lengths.
6. Write a `Supplier<String>` to generate a random UUID.
7. Implement a `UnaryOperator<Integer>` to calculate factorial.
8. Use a `BinaryOperator<Integer>` to find the maximum of two integers.
9. Implement memoization for Fibonacci using `Function<Integer, Integer>`.
10. Build a small event system where multiple `Consumer<String>` objects act as listeners.

**Collectors:**
11\. Collect even numbers from a list into a `Set` using `Collectors.toSet()`.
12\. Join a list of names into a single string separated by commas using `Collectors.joining()`.
13\. Count how many strings in a list have length > 5 using `Collectors.counting()`.
14\. Find the average salary of employees using `Collectors.averagingInt()`.
15\. Group students by grade using `Collectors.groupingBy()`.
16\. Partition numbers into even and odd using `Collectors.partitioningBy()`.
17\. Create a frequency map of words using `Collectors.groupingBy()`.
18\. Collect integers into a `TreeSet` using `Collectors.toCollection(TreeSet::new)`.
19\. Find the highest-paid employee using `Collectors.maxBy()`.
20\. Write a custom collector to compute the product of integers in a stream.

---

## 📅 **Day 5–7: Mix & Solve (Review + Advanced Intermediate)**

Use the remaining days to:

* Revise all **80 problems**.
* Re-solve tricky ones without looking at answers.
* Mix problems from Strings, Collections, Streams, and Collectors.
* Try to implement **your own data structures** (Stack, Queue, LRU Cache).
* Work on mini-projects combining all concepts (e.g., word frequency analyzer, student grading system, leaderboard).

---

# ✅ Final Note

By the end of this 1-week roadmap, you will:

* Have solved **80 intermediate-level problems**.
* Be comfortable with **String manipulation, Collections, Streams, Functions, and Collectors**.
* Be ready to move into **Advanced Java topics** like Generics, Concurrency, Design Patterns, and JVM internals.
