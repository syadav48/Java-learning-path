Here’s a full, clear explanation of the **double string trick**, plus **all the other similar string tricks**, **when to use them**, and **what problems they help you solve**.

---

# ⭐ 1. **Double String Trick (s + s)**

This is one of the most powerful and elegant string tricks.

## ✅ **What is it?**

If a string `s` is formed by repeating a substring, then:

### **s will always appear inside (s + s) after removing the first and last character.**

Example:
`s = "abab"`
`s + s = "abababab"`
Remove first and last → `"bababa"`
This contains `"abab"`.

But `"aba"` won’t.

---

## 🔥 Problems solved by this trick

### **1. Repeated Substring Pattern**

(LeetCode 459)

Check if `s` is made from repeating a substring.

### **2. Check if a string is a rotation of another**

Given `s1` and `s2`, check if `s2` is a rotation of `s1`.

Example:

```
s1 = "abcde"
s2 = "cdeab"
```

Just check:

```
(s1 + s1).contains(s2)
```

### **3. Find rotation index difference**

If you need how many steps to rotate:

Example:

```
s1 = "waterbottle"
s2 = "erbottlewat"
```

Find index of s2 in (s1+s1).

### **4. Circular string matching**

When strings wrap around like a ring (common in DP or sliding window).

Example:
Clockwise circular pattern matching.

---

## 🧠 Why does this trick work?

Any repeated pattern or rotation means the string naturally aligns with itself inside the doubled version.

---

# ⭐ 2. **Prefix Function / KMP LPS Trick**

Very powerful for repetition, patterns, borders.

## Problems solved:

### **1. Longest prefix which is also suffix** (border)

### **2. Repeated substring pattern (alternate solution)**

### **3. Find pattern P in text T in O(n)**

### **4. Count number of pattern occurrences**

### **5. String compression problems**

### **6. Detect periodicity of strings**

Basically any problem asking:

* “period”
* “repetition”
* “borders”
* “prefix = suffix(?)”
  uses this trick.

---

# ⭐ 3. **Z-Function Trick**

Another must-know for string algorithms.

## What it solves:

### **1. Pattern search**

Similar to KMP but simpler to implement.

### **2. Find longest substring starting at i that matches prefix**

Used in:

* DNA sequence problems
* Substring matching
* Multiple pattern checks

### **3. Count unique substrings**

Used in suffix-like problems.

### **4. Find number of times prefix appears inside string**

---

# ⭐ 4. Sliding Window + Hashing (Rabin-Karp trick)

Useful for substring comparison in O(1) average time.

## Problems solved:

### **1. Find duplicate substring**

### **2. Longest repeating substring**

### **3. Find all anagram substrings**

### **4. Plagiarism detection**

### **5. Substring search in big strings**

### **6. Rolling hash for shifting window**

---

# ⭐ 5. Two-pointer Palindrome Tricks

### Solves:

* Longest palindromic substring
* Palindrome partitioning
* Check if string can be palindrome after 1 removal
* Palindrome expansions (center expansion)

---

# ⭐ 6. Manacher’s Algorithm Trick

Only for palindromes.

### Solves:

* Longest palindromic substring in O(n)

---

# ⭐ 7. Character Frequency Tricks

Counting with arrays/maps for:

* Anagram check
* Isomorphic strings
* Frequency window problems
* Permutation in string (LC 567)

---

# ⭐ 8. Bitmask Tricks

Used when string contains only lowercase letters (26 chars).

### Solves:

* Unique substring
* Maximum product of non-overlapping strings
* Check if string has duplicate characters
* Palindromic substring when order doesn't matter

---

# ⭐ 9. Reverse + Concatenation Trick

### Solves:

* Check if string is palindrome with K edits
* Form shortest palindrome by adding chars in front
* Use with KMP:
  Build: `s + "#" + reverse(s)` → gives LPS for palindrome check.

---

# ⭐ 10. Subsequence DP Tricks

Solves:

* LCS
* Edit distance
* Wildcard matching
* Regex DP
* Interleaving string DP

---

# 📌 **Summary Table of All Main String Tricks**

| Trick                                  | What it solves                            |
| -------------------------------------- | ----------------------------------------- |
| **Double string trick (s+s)**          | rotation, repetition                      |
| **KMP / LPS**                          | prefix/suffix, repetition, pattern search |
| **Z-function**                         | pattern search, prefix counts             |
| **Rabin-Karp hashing**                 | fast substring compare                    |
| **Sliding window**                     | anagrams, frequency checks                |
| **Two pointers**                       | palindromes                               |
| **Manacher**                           | longest palindrome                        |
| **Bitmask**                            | uniqueness, combinations                  |
| **Reverse + concat (s + # + reverse)** | shortest palindrome                       |
| **DP tricks**                          | LCS, edit distance, wildcard              |

---

# 💬 If you want

I can also give:

📌 All tricks with **example problems (with links)**
📌 A **cheat-sheet PDF**
📌 A **mind-map with visuals**
📌 Java templates for all tricks

Just tell me what you want!
