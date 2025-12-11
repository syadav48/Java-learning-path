Below is **the cleanest, most structured list of ALL important string patterns** you must know —
**with examples, solutions, and tricks to remember each pattern**.

This is a **master sheet** for string questions.

---

# ✅ **STRING PATTERNS (COMPLETE LIST)**

(Each pattern → explanation → example → solution → memory trick)

---

# **1. Frequency Count / Character Count**

Use when you see words like:
✔ “anagram”, ✔ “frequency”, ✔ “equal characters”, ✔ “similar strings”.

### **Example**

```
s = "banana"
Count frequency of each character.
```

### **Solution**

```java
Map<Character, Integer> map = new HashMap<>();
for(char c : s.toCharArray()){
    map.put(c, map.getOrDefault(c, 0) + 1);
}
```

### **Trick to Remember**

> **If the question talks about similarity or anagrams → always think frequency.**

---

# **2. Sliding Window**

Use for:
✔ Longest substring
✔ K distinct characters
✔ Substring constraints
✔ Pattern matching inside string

### **Example**

Find longest substring without repeating characters.

### **Solution**

```java
int i = 0;
int max = 0;
Set<Character> set = new HashSet<>();

for (int j = 0; j < s.length(); j++) {
    while (set.contains(s.charAt(j))) {
        set.remove(s.charAt(i));
        i++;
    }
    set.add(s.charAt(j));
    max = Math.max(max, j - i + 1);
}
```

### **Trick to Remember**

> **Window grows → condition breaks → shrink the window.**

---

# **3. Two Pointers**

Used on:
✔ Sorted strings
✔ Palindrome check
✔ Removing characters
✔ Comparing two strings

### **Example**

Check if a string is palindrome.

### **Solution**

```java
int i = 0, j = s.length() - 1;
while(i < j){
    if(s.charAt(i) != s.charAt(j)) return false;
    i++; j--;
}
return true;
```

### **Trick**

> **Two pointers = meeting in the middle.**

---

# **4. Double String Trick (s + s)**

Used for rotation/circular matching.

### **Example**

Check if `s2` is a rotation of `s1`.

```
s1 = "waterbottle"
s2 = "erbottlewat"
```

### **Solution**

```java
boolean isRotation = (s1.length() == s2.length()) &&
                      (s1 + s1).contains(s2);
```

### **Trick**

> **Rotation? → Immediately think “double string”.**
> (Because every rotated version appears inside `s + s`)

---

# **5. Prefix Sum on Strings**

Used for:
✔ character sum ranges
✔ vowel count in subranges
✔ fast substring comparisons

### **Example**

Count vowels in every substring of length 3.

### **Solution**

```java
int[] prefix = new int[s.length()+1];
String vowels = "aeiou";

for(int i = 0; i < s.length(); i++){
    prefix[i+1] = prefix[i] + (vowels.indexOf(s.charAt(i)) != -1 ? 1 : 0);
}
```

### **Trick**

> **Prefix sum = store accumulated knowledge so future queries are O(1).**

---

# **6. HashMap Window (Anagram Pattern)**

Used for:
✔ find smallest window
✔ minimum substring
✔ anagram positions

### **Example**

Find all anagram indices of `p` in `s`.

### **Solution (core idea)**

```java
int[] count = new int[26];
for(char c : p.toCharArray()) count[c - 'a']++;

int left = 0, right = 0, needed = p.length();

while(right < s.length()){
    if(count[s.charAt(right)-'a']-- > 0) needed--;
    right++;

    if(needed == 0) result.add(left);
    
    if(count[s.charAt(left)-'a']++ >= 0) needed++;
    left++;
}
```

### **Trick**

> **Anagrams = sliding window + frequency count.**

---

# **7. Expand Around Center**

Used for:
✔ longest palindrome substring
✔ symmetric patterns

### **Example**

Find longest palindromic substring.

### **Solution (core)**

```java
String expand(String s, int l, int r){
    while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
        l--; r++;
    }
    return s.substring(l+1, r);
}
```

### **Trick**

> **Every palindrome expands outward.**

---

# **8. Stack-Based String Pattern**

Used for:
✔ remove duplicates
✔ decode patterns
✔ validate parentheses
✔ simplify paths

### **Example**

Remove adjacent duplicates: “abbaca” → “ca”.

### **Solution**

```java
Stack<Character> st = new Stack<>();
for(char c: s.toCharArray()){
    if(!st.isEmpty() && st.peek() == c) st.pop();
    else st.push(c);
}
```

### **Trick**

> **Whenever you need to cancel/remove pairs → use a stack.**

---

# **9. KMP (Substring Search)**

Used for:
✔ finding a pattern inside a large string
✔ faster than `.contains()`
✔ mismatch → jump using LPS table

### **Example**

Find `needle` inside `haystack`.

### **Solution (core: LPS creation)**

```java
int[] lps = new int[pat.length()];
int i = 1, len = 0;

while(i < pat.length()){
    if(pat.charAt(i) == pat.charAt(len)){
        len++; lps[i] = len; i++;
    } else {
        if(len != 0) len = lps[len - 1];
        else i++;
    }
}
```

### **Trick**

> **KMP = “don’t restart from zero”—reuse previous matches.**

---

# **10. Rabin-Karp (Rolling Hash)**

Used for:
✔ multiple substring search
✔ detect duplicates
✔ hashing long strings

### **Example**

Search substring using rolling hash.

### **Remembering Trick**

> **Think hash → sliding window on steroids.**

---

# **11. Trie (Prefix Tree)**

Used for:
✔ autocomplete
✔ prefix search
✔ word dictionary
✔ longest common prefix sets

### **Example**

Insert words and search prefix.

### **Trick**

> **If the problem says “prefix” → think Trie.**

---

# **12. Count & Compare (Character Transformations)**

Used for:
✔ isomorphic strings
✔ bijection mapping
✔ transform strings

### **Example**

Check if two strings are isomorphic.

### **Solution**

```java
int[] map1 = new int[256];
int[] map2 = new int[256];

for(int i = 0; i < s.length(); i++){
    if(map1[s.charAt(i)] != map2[t.charAt(i)]) return false;
    map1[s.charAt(i)] = i + 1;
    map2[t.charAt(i)] = i + 1;
}
```

### **Trick**

> **Pattern match = two arrays storing last seen index.**

---

# **13. Manacher’s Algorithm (Advanced)**

Used for:
✔ longest palindrome in O(n)

(Mentioning because it exists; not required for intermediate level.)

### **Trick**

> **Only remember it exists.**

---

# 🎯 Want a PERFECT MEMORY TRICK?

Here is one:

# ⭐ “4 Golden Groups”

Everything above fits these:

### **Group 1 — Counting Based**

* Frequency count
* Anagrams
* Transformations
* HashMap patterns

### **Group 2 — Window Based**

* Sliding window
* Two pointers
* Prefix sum
* Rolling hash

### **Group 3 — Palindrome Based**

* Expand around center
* Manacher
* Two pointers

### **Group 4 — Search Based**

* KMP
* Rabin-Karp
* Trie

If you remember these **4 groups**, you’ll instantly know which pattern to pick.

---

# ⭐ If you want, I can create a **problem list for each pattern**, based on LeetCode difficulty:

* 5 easy
* 5 medium
* 2 hard
  per pattern.

Here is the **perfectly structured, pattern-wise STRING DSA Problem Set**
✔ Covers all important patterns
✔ LeetCode-friendly
✔ Ordered from easiest → intermediate → harder
✔ Exactly what you need to build pattern recognition

---

# ⭐ **STRING MASTER PROBLEM SET (Pattern-wise)**

Use this as your official roadmap.

![Image](https://dotnettrickscloud.blob.core.windows.net/article/data%20structures/4920250613180911.png?utm_source=chatgpt.com)

![Image](https://media.geeksforgeeks.org/wp-content/uploads/20200823120442/PlagDetection2.jpg?utm_source=chatgpt.com)

![Image](https://javaconceptoftheday.com/wp-content/uploads/2023/06/Java_Strings_Cheat_Sheet.png?utm_source=chatgpt.com)

---

# **1. Frequency Count / Character Count**

Used for: anagrams, comparing strings, equality.

### Easy

1. Valid Anagram (LC 242)
2. First Unique Character (LC 387)

### Medium

3. Group Anagrams (LC 49)
4. Longest Palindrome by Constructing (LC 409)
5. Reorganize String (LC 767)

### Hard

6. Minimum Window Substring (LC 76)
7. Alien Dictionary (LC 269)

---

# **2. Sliding Window**

Used for: longest/shortest substring, constraints in a window.

### Easy

1. Maximum Number of Vowels in a Substring of Given Length (LC 1456)
2. Permutation in String (LC 567)

### Medium

3. Longest Substring Without Repeating Characters (LC 3)
4. Longest Repeating Character Replacement (LC 424)
5. Substring with K Distinct Characters (LC 992)

### Hard

6. Subarrays with Exactly K Distinct (LC 992 hard version)

---

# **3. Two Pointers**

Used for: palindrome, comparing ends, merging.

### Easy

1. Valid Palindrome (LC 125)
2. Reverse String (LC 344)

### Medium

3. Valid Palindrome II (LC 680)
4. Reverse Words in a String (LC 151)
5. Minimum Time to Make Rope Colorful (LC 1578)

### Hard

6. Palindromic Subsequences (LC 1312)

---

# **4. Double String Trick (Circular / Rotation)**

Used for: rotation, cyclic matching, circular strings.

### Easy

1. Rotate String (LC 796)

### Medium

2. Detect Cyclic Rotation (GFG)
3. Repeated String Match (LC 686)

### Hard

4. Repeated Substring Pattern (LC 459)

---

# **5. Prefix Sum on Strings**

Used for: fast substring queries, vowel counts.

### Easy

1. Number of Substrings with Only 1s (LC 1513)
2. Count Vowel Substrings (GFG)

### Medium

3. Vowel Spellchecker (LC 966)
4. Substring with Equal 0s, 1s, 2s (GFG)

### Hard

5. Count Palindromic Substrings (LC 647)

---

# **6. HashMap Window (Anagram Pattern)**

Used for: minimum window, find substring with pattern.

### Easy

1. Find All Anagrams in a String (LC 438)

### Medium

2. Minimum Window Subsequence (LC 727)
3. Custom Sort String (LC 791)
4. Longest Substring with At Most K Distinct Characters (LC 340)

### Hard

5. Minimum Window Substring (LC 76)

---

# **7. Expand Around Center (Palindrome Pattern)**

Used for: palindromic substrings, symmetric strings.

### Easy

1. Palindrome Substrings (LC 647)

### Medium

2. Longest Palindromic Substring (LC 5)
3. Palindrome Partitioning (LC 131)
4. Palindromic Subsequences Count (LC 516)

### Hard

5. Palindrome Pairs (LC 336)

---

# **8. Stack-Based String Pattern**

Used for: removing adjacent duplicates, parentheses, decoding.

### Easy

1. Remove All Adjacent Duplicates in String (LC 1047)
2. Valid Parentheses (LC 20)

### Medium

3. Decode String (LC 394)
4. Remove K Digits (LC 402)
5. Basic Calculator II (LC 227)

### Hard

6. Basic Calculator (LC 224)

---

# **9. KMP (Pattern Search)**

Used for: fast substring search.

### Easy

1. Implement strStr() (LC 28)

### Medium

2. Repeated Substring Pattern (LC 459)
3. Shortest Palindrome (LC 214)

### Hard

4. Longest Happy Prefix (LC 1392)

---

# **10. Rabin–Karp (Rolling Hash)**

Used for: duplicate substring, multi-pattern search.

### Easy

1. Rotate String (LC 796 alternative solution)

### Medium

2. Longest Duplicate Substring (LC 1044)
3. Find All Anagrams (LC 438 using hash)

### Hard

4. Detect Pattern of Length M Repeated K Times (LC 1566)

---

# **11. Trie (Prefix Tree)**

Used for: dictionary, prefix search, autocomplete.

### Easy

1. Implement Trie (LC 208)

### Medium

2. Word Search II (LC 212)
3. Replace Words (LC 648)
4. Longest Word in Dictionary (LC 720)

### Hard

5. Concatenated Words (LC 472)

---

# **12. Isomorphic / Character Mapping**

Used for: comparing patterns between two strings.

### Easy

1. Isomorphic Strings (LC 205)
2. Word Pattern (LC 290)

### Medium

3. Minimum Number of Steps to Make Two Strings Anagram (LC 1347)
4. Determine if Two Strings Are Close (LC 1657)

### Hard

5. Strange Printer (LC 664)

---

# **13. DP on Strings (extra but important)**

Used for: LCS, edit distance, subsequences.

### Easy

1. Longest Common Subsequence (LC 1143)

### Medium

2. Edit Distance (LC 72)
3. Distinct Subsequences (LC 115)

### Hard

4. Regular Expression Matching (LC 10)

---

# ⭐ If you want, I can create a **FULL 30-DAY PLAN** using this list:

* 1 pattern every 2 days
* handpicked problems
* difficulty progression
* revision days


