Absolutely. We’ve covered the **advanced DSA patterns**, so now it makes sense to build the foundation properly around the three things that appear underneath almost everything:

> **Array + String + HashMap**

I’ll keep exactly the same style we’ve been using: **mental model → patterns → recognition → Java templates → things to remember → mistakes → level-wise problems → final cheat sheet**.

# 1. ARRAYS — The Foundation

## 1.1 Core Mental Model

An array gives you:

```text
Index → Value
```

and usually:

```text
nums[i]        → O(1) access
nums[i] = x    → O(1)
```

But inserting/deleting in the middle requires shifting:

```text
[10, 20, 30, 40, 50]
       ↓ insert 25
[10, 20, 25, 30, 40, 50]
       ↑ shift everything →
```

So:

| Operation | Complexity |
|---|---:|
| Access `nums[i]` | O(1) |
| Update | O(1) |
| Search unsorted | O(n) |
| Search sorted | O(log n) |
| Insert middle | O(n) |
| Delete middle | O(n) |

The important point for DSA is:

> **Arrays are rarely about the array itself. They are about what pattern you apply to the array.**

---

# 2. ARRAY PATTERN MAP

The major patterns are:

```text
ARRAY
│
├── Traversal
│
├── Counting / Frequency
│
├── In-place Modification
│
├── Two Pointer
│
├── Sliding Window
│
├── Prefix Sum
│
├── Binary Search
│
├── Sorting + Greedy
│
├── HashMap / HashSet
│
├── Monotonic Stack
│
├── Heap
│
├── Difference Array
│
├── Kadane's Algorithm
│
├── Matrix / 2D Array
│
└── Divide & Conquer
```

So when you see an array problem, **don't immediately start coding**.

Ask:

```text
Is it sorted?
     ↓
Two Pointer / Binary Search

Contiguous subarray?
     ↓
Sliding Window / Prefix Sum

Need frequency/count?
     ↓
HashMap / HashSet

Need next greater/smaller?
     ↓
Monotonic Stack

Need top K?
     ↓
Heap

Need maximum subarray?
     ↓
Kadane

Many range updates?
     ↓
Difference Array

Need optimize choices?
     ↓
Greedy / DP
```

That recognition skill is much more valuable than memorizing individual solutions.

---

# 3. ARRAY PATTERN #1 — Simple Traversal

The most basic pattern.

```java
for (int i = 0; i < nums.length; i++) {
    // nums[i]
}
```

Or:

```java
for (int num : nums) {
    // num
}
```

Use when:

- find max/min
- count something
- transform elements
- check condition
- calculate sum
- find first/last occurrence

Example:

```java
int max = Integer.MIN_VALUE;

for (int num : nums) {
    max = Math.max(max, num);
}
```

### Remember

Don't complicate an O(n) problem.

If you only need:

> "Find maximum element"

you don't need HashMap, sorting, heap, etc.

---

# 4. ARRAY PATTERN #2 — Frequency Counting

Very important foundation.

Suppose:

```text
[1, 2, 2, 3, 3, 3]
```

We want:

```text
1 → 1
2 → 2
3 → 3
```

Use:

```java
Map<Integer, Integer> freq = new HashMap<>();

for (int num : nums) {
    freq.put(num, freq.getOrDefault(num, 0) + 1);
}
```

This pattern appears everywhere.

Examples:

- Majority Element
- Top K Frequent Elements
- First Unique
- Duplicate detection
- Anagrams
- Frequency comparison
- Subarray problems

If values are constrained to a small range:

```java
int[] freq = new int[1001];
```

is usually better than HashMap.

### Golden rule

> **Small known value range → frequency array.**

> **Unknown/large value range → HashMap.**

---

# 5. ARRAY PATTERN #3 — In-Place Modification

Interviewers often say:

> "Do it without using extra space."

Then think:

```text
READ → WRITE
```

Example: move zeroes.

```text
[0,1,0,3,12]
     ↓
[1,3,12,0,0]
```

Use a write pointer:

```java
int write = 0;

for (int num : nums) {
    if (num != 0) {
        nums[write++] = num;
    }
}

while (write < nums.length) {
    nums[write++] = 0;
}
```

This is essentially **two pointers**.

Common problems:

- Move Zeroes
- Remove Duplicates from Sorted Array
- Remove Element
- Sort Colors
- Partition Array

Recognition:

> "modify the array in-place"

Think:

```text
slow/write pointer
```

---

# 6. ARRAY PATTERN #4 — Kadane's Algorithm

Very important array pattern.

Question:

> Maximum sum contiguous subarray?

Example:

```text
[-2,1,-3,4,-1,2,1,-5,4]
```

Answer:

```text
[4,-1,2,1] = 6
```

Mental model:

At every position:

```text
Should I:
1. extend previous subarray?
2. start a new subarray?
```

Therefore:

```java
int current = nums[0];
int best = nums[0];

for (int i = 1; i < nums.length; i++) {
    current = Math.max(nums[i], current + nums[i]);
    best = Math.max(best, current);
}
```

Complexity:

```text
Time  O(n)
Space O(1)
```

Recognition:

```text
maximum sum
+
contiguous subarray
```

→ **Kadane**

Variants:

- Maximum Subarray
- Maximum Circular Subarray
- Maximum Product Subarray → modified idea
- Best subarray under constraints → sometimes DP

---

# 7. ARRAY PATTERN #5 — Sorting + Processing

Sometimes sorting turns a difficult problem into an easy one.

Example:

```text
[7,1,5,3,6,4]
```

Sort:

```text
[1,3,4,5,6,7]
```

Then:

- duplicates become adjacent
- equal values become groups
- intervals become ordered
- greedy choices become possible
- two pointers become possible

Typical:

```java
Arrays.sort(nums);
```

But remember:

> Sorting destroys the original order.

So before sorting ask:

```text
Does original index/order matter?
```

If yes, don't blindly sort.

---

# 8. ARRAY PATTERN #6 — Two Pointer

We've already covered this deeply.

Think:

```text
left →          ← right
```

Typical when:

- sorted array
- pair sum
- triplets
- remove duplicates
- partition
- palindrome
- merge-like problems

Example:

```java
int left = 0;
int right = nums.length - 1;

while (left < right) {

    int sum = nums[left] + nums[right];

    if (sum == target) {
        return true;
    } else if (sum < target) {
        left++;
    } else {
        right--;
    }
}
```

Recognition:

> **Sorted + pair relationship → Two Pointer**

---

# 9. ARRAY PATTERN #7 — Sliding Window

Already covered deeply.

Think:

```text
[left ........ right]
```

Use for:

> contiguous + window condition

Examples:

- maximum sum of K elements
- longest substring
- at most K distinct
- minimum window
- maximum consecutive ones

---

# 10. ARRAY PATTERN #8 — Prefix Sum

Already covered deeply.

Think:

```text
prefix[i] = sum before i
```

Then:

```text
sum(L,R)
=
prefix[R+1] - prefix[L]
```

Especially important for:

```text
subarray sum = K
negative numbers
range queries
equal balances
```

---

# 11. ARRAY PATTERN #9 — Binary Search

If the array is sorted:

```text
[1,3,5,7,9,12]
```

don't automatically use O(n).

Think:

```text
Can I eliminate half the search space?
```

Basic:

```java
int left = 0;
int right = nums.length - 1;

while (left <= right) {

    int mid = left + (right - left) / 2;

    if (nums[mid] == target) {
        return mid;
    }

    if (nums[mid] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
```

Important variants:

```text
First occurrence
Last occurrence
Lower bound
Upper bound
Rotated sorted array
Peak element
Binary search on answer
```

The bigger pattern:

> **Binary Search is not just "search in sorted array".**

It is:

> **Find a boundary where a condition changes from false → true.**

---

# 12. STRING — Core Mental Model

A String is basically:

```text
characters + indexing + frequency + ordering
```

In Java:

```java
String s = "hello";

s.charAt(i);
s.length();
s.substring(l, r);
```

But remember:

> Java `String` is immutable.

This is expensive:

```java
String result = "";

for (...) {
    result += c;
}
```

because many new String objects can be created.

Use:

```java
StringBuilder sb = new StringBuilder();

sb.append(c);

String result = sb.toString();
```

---

# 13. STRING PATTERN MAP

```text
STRING
│
├── Character Traversal
├── Frequency Counting
├── HashMap / HashSet
├── Two Pointer
├── Sliding Window
├── Stack
├── StringBuilder
├── Sorting
├── Prefix / KMP
├── Trie
├── Palindrome
├── Anagram
└── DP
```

This is important:

> Most string problems are actually array/hashmap/sliding-window problems where the elements happen to be characters.

---

# 14. STRING PATTERN #1 — Character Frequency

Example:

```text
"banana"
```

Frequency:

```text
b → 1
a → 3
n → 2
```

If only lowercase English letters:

```java
int[] freq = new int[26];

for (char c : s.toCharArray()) {
    freq[c - 'a']++;
}
```

This is much faster and simpler than a HashMap.

For arbitrary Unicode/general characters:

```java
Map<Character, Integer> freq = new HashMap<>();
```

---

# 15. STRING PATTERN #2 — Anagram

Two strings are anagrams if they contain the same characters with the same frequencies.

```text
listen
silent
```

Same frequency.

Simple solution:

```java
int[] freq = new int[26];

for (char c : s.toCharArray()) {
    freq[c - 'a']++;
}

for (char c : t.toCharArray()) {
    freq[c - 'a']--;
}

for (int x : freq) {
    if (x != 0) return false;
}

return true;
```

Recognition:

```text
same characters
+
same frequency
```

→ **Frequency counting**

---

# 16. STRING PATTERN #3 — Palindrome

Example:

```text
racecar
```

Use two pointers:

```java
int left = 0;
int right = s.length() - 1;

while (left < right) {

    if (s.charAt(left) != s.charAt(right)) {
        return false;
    }

    left++;
    right--;
}

return true;
```

Recognition:

```text
reads same forward/backward
```

→ **Two Pointer**

Important combination:

> Palindrome + substring → often two pointer / DP / expand-around-center.

---

# 17. STRING PATTERN #4 — Expand Around Center

For longest palindromic substring.

Instead of checking every substring:

```text
center
  ↓
a b a
  ↑
expand outward
```

There are two centers:

```text
Odd:
  a b a
    ↑

Even:
  a b b a
    ↑ ↑
```

Template:

```java
private int expand(String s, int left, int right) {

    while (left >= 0 &&
           right < s.length() &&
           s.charAt(left) == s.charAt(right)) {

        left--;
        right++;
    }

    return right - left - 1;
}
```

Complexity:

```text
O(n²)
```

Recognition:

> Palindrome around a center → **Expand Around Center**

---

# 18. STRING PATTERN #5 — String + Sliding Window

This is one of the most important combinations.

Example:

> Longest substring without repeating characters.

Maintain:

```text
[left .... right]
```

and a set/map of characters.

```java
Set<Character> set = new HashSet<>();

int left = 0;
int answer = 0;

for (int right = 0; right < s.length(); right++) {

    while (set.contains(s.charAt(right))) {
        set.remove(s.charAt(left));
        left++;
    }

    set.add(s.charAt(right));

    answer = Math.max(answer, right - left + 1);
}
```

Recognition:

```text
substring
+
longest/shortest
+
character constraint
```

→ **Sliding Window**

---

# 19. STRING PATTERN #6 — String + HashMap

Classic:

> Find first non-repeating character.

First pass:

```java
Map<Character, Integer> freq = new HashMap<>();

for (char c : s.toCharArray()) {
    freq.put(c, freq.getOrDefault(c, 0) + 1);
}
```

Second pass:

```java
for (int i = 0; i < s.length(); i++) {
    if (freq.get(s.charAt(i)) == 1) {
        return i;
    }
}
```

Why two passes?

Because:

```text
frequency requires knowing the whole string
```

then:

```text
original order determines the answer
```

This is a very common interview pattern.

---

# 20. STRING PATTERN #7 — Stack

Strings + nested structure:

```text
"3[a2[c]]"
```

or:

```text
"((()))"
```

or:

```text
"abccba"
```

Think Stack when you see:

```text
nested
matching
undo
previous state
decode
parentheses
```

Examples:

- Valid Parentheses
- Decode String
- Remove Adjacent Duplicates
- Simplify Path
- Basic Calculator

---

# 21. STRING PATTERN #8 — StringBuilder

Whenever constructing a string repeatedly:

```java
StringBuilder sb = new StringBuilder();

for (char c : s.toCharArray()) {
    if (...) {
        sb.append(c);
    }
}

return sb.toString();
```

Useful for:

- reverse
- filtering
- transformations
- constructing answer
- backtracking output

For reversal:

```java
String reversed = new StringBuilder(s)
        .reverse()
        .toString();
```

---

# 22. HASHMAP — The Real Mental Model

This is perhaps the most important basic concept.

A HashMap gives:

```text
KEY → VALUE
```

Average:

```text
put     O(1)
get     O(1)
remove  O(1)
containsKey O(1)
```

Think:

> **I need to remember something about something I've already seen.**

That is the real HashMap signal.

---

# 23. HASHMAP PATTERN MAP

```text
HashMap
│
├── Frequency
├── Seen / Duplicate
├── Value → Index
├── Prefix State → Frequency
├── Prefix State → Earliest Index
├── Complement Lookup
├── Grouping
├── Mapping
├── Memoization
├── Sliding Window State
└── Graph / Adjacency Representation
```

---

# 24. HASHMAP PATTERN #1 — Seen Before

Question:

> Does array contain duplicate?

Use:

```java
Set<Integer> seen = new HashSet<>();

for (int num : nums) {

    if (seen.contains(num)) {
        return true;
    }

    seen.add(num);
}

return false;
```

You don't even need HashMap.

This gives a useful rule:

> If you only care whether something exists → **HashSet**.

> If you need information associated with it → **HashMap**.

---

# 25. HASHMAP PATTERN #2 — Complement Lookup

Classic Two Sum.

```text
nums = [2,7,11,15]
target = 9
```

When we see `7`:

```text
needed = 9 - 7 = 2
```

Have we seen 2?

Yes.

```java
Map<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < nums.length; i++) {

    int needed = target - nums[i];

    if (map.containsKey(needed)) {
        return new int[]{map.get(needed), i};
    }

    map.put(nums[i], i);
}
```

Mental model:

> **Current + previous = target**

So:

```text
needed = target - current
```

This pattern appears everywhere.

---

# 26. HASHMAP PATTERN #3 — Value → Index

Sometimes the question says:

> Find something involving the previous occurrence.

Store:

```java
map.put(value, index);
```

Examples:

- Two Sum
- Longest substring
- duplicate distance
- first/last occurrence
- longest subarray

Important distinction:

```text
value → frequency
value → index
value → earliest index
value → latest index
```

The question determines what the value should be.

---

# 27. HASHMAP PATTERN #4 — Prefix State → Frequency

This is the powerful pattern we covered in Prefix Sum.

Example:

```text
Subarray Sum = K
```

Store:

```text
prefix sum → number of occurrences
```

```java
Map<Integer, Integer> map = new HashMap<>();
map.put(0, 1);

int prefix = 0;
int count = 0;

for (int num : nums) {

    prefix += num;

    count += map.getOrDefault(prefix - k, 0);

    map.put(prefix, map.getOrDefault(prefix, 0) + 1);
}
```

The deeper pattern:

> **Current state - previous state = desired condition**

---

# 28. HASHMAP PATTERN #5 — State → Earliest Index

Suppose we want:

> Longest subarray satisfying something.

Then generally:

```text
state → earliest index
```

Why earliest?

Because:

```text
currentIndex - earliestIndex
```

is maximum.

Example:

```java
Map<Integer, Integer> first = new HashMap<>();

first.put(0, -1);
```

Then:

```java
first.putIfAbsent(state, i);
```

Very important.

### Count problem

```text
state → frequency
```

### Longest problem

```text
state → earliest index
```

That's a major interview distinction.

---

# 29. HASHMAP PATTERN #6 — Grouping

Example:

> Group Anagrams

Convert each word to a common key.

For example:

```text
eat → aet
tea → aet
ate → aet
```

Then:

```java
Map<String, List<String>> map = new HashMap<>();

for (String word : words) {

    char[] chars = word.toCharArray();
    Arrays.sort(chars);

    String key = new String(chars);

    map.computeIfAbsent(key, k -> new ArrayList<>())
       .add(word);
}
```

Mental model:

> **Create a canonical key for equivalent objects.**

This is a huge pattern.

---

# 30. HASHMAP PATTERN #7 — Mapping

Sometimes you need:

```text
A → B
```

and potentially:

```text
B → A
```

Example:

> Isomorphic Strings

You need consistent mapping:

```text
egg
add
```

Mapping:

```text
e → a
g → d
```

And no two characters should map inconsistently.

This becomes:

```text
HashMap + HashMap
```

or arrays of size 256.

---

# 31. HASHMAP PATTERN #8 — Sliding Window State

HashMap is often the state inside sliding window.

Example:

```text
"eceba"
```

Longest substring with at most 2 distinct characters.

Maintain:

```java
Map<Character, Integer> freq = new HashMap<>();
```

When expanding:

```java
freq.put(c, freq.getOrDefault(c, 0) + 1);
```

When shrinking:

```java
char leftChar = s.charAt(left);

freq.put(leftChar, freq.get(leftChar) - 1);

if (freq.get(leftChar) == 0) {
    freq.remove(leftChar);
}

left++;
```

So:

```text
Sliding Window
      +
 HashMap
```

is one of the most important combinations in DSA.

---

# 32. ARRAY + STRING + HASHMAP — THE BIG COMBINATION MAP

This is what I would remember for interviews:

```text
                 ARRAY / STRING
                       │
       ┌───────────────┼────────────────┐
       ↓               ↓                ↓
    Sorted?       Contiguous?       Frequency?
       │               │                │
       ↓               ↓                ↓
 Two Pointer      Sliding Window    HashMap
 Binary Search    Prefix Sum        Frequency Array
       │               │
       └───────┬───────┘
               ↓
          Optimization
               │
     ┌─────────┼─────────┐
     ↓         ↓         ↓
    Stack     Heap      DP/Greedy
```

---

# 33. THE MOST IMPORTANT HASHMAP DECISION TREE

When you think:

> "Maybe HashMap?"

ask **what am I storing?**

### A. Only existence?

```text
seen?
```

→ `HashSet`

### B. Frequency?

```text
value → count
```

→ `HashMap`

### C. Position?

```text
value → index
```

→ `HashMap`

### D. First/earliest position?

```text
state → earliest index
```

→ `HashMap`

### E. Count previous states?

```text
state → frequency
```

→ `HashMap`

### F. Equivalent objects?

```text
canonicalKey → list
```

→ `HashMap<List>`

### G. Sliding-window frequency?

```text
character → count
```

→ `HashMap`

This decision tree alone solves a **huge number of Easy/Medium problems**.

---

# 34. ARRAY / STRING / HASHMAP — COMMON TRAPS

## Trap 1 — Using HashMap when array is enough

If:

```text
characters = a-z
```

prefer:

```java
int[26]
```

instead of:

```java
HashMap<Character, Integer>
```

---

## Trap 2 — Sorting unnecessarily

If you need original positions:

```text
nums = [3,2,4]
```

sorting destroys index information.

Think HashMap or store `(value,index)`.

---

## Trap 3 — Forgetting duplicates

For:

```text
[2,2,3]
```

frequency matters.

Never assume values are unique unless stated.

---

## Trap 4 — `containsKey()` + `get()` unnecessarily

Instead of:

```java
if (map.containsKey(x)) {
    int count = map.get(x);
}
```

often:

```java
map.getOrDefault(x, 0);
```

is cleaner.

---

## Trap 5 — Modifying HashMap while iterating

Be careful with:

```java
for (Integer key : map.keySet()) {
    map.remove(key);
}
```

This can cause `ConcurrentModificationException`.

---

## Trap 6 — String concatenation in loops

Avoid:

```java
result += c;
```

Prefer:

```java
StringBuilder
```

---

## Trap 7 — `==` vs `.equals()`

For Strings:

```java
s1.equals(s2)
```

not:

```java
s1 == s2
```

`==` compares references.

---

# 35. JAVA ARRAY / STRING / HASHMAP CHEAT SHEET

### Array

```java
int n = nums.length;

Arrays.sort(nums);

Arrays.fill(nums, 0);

int[] copy = Arrays.copyOf(nums, nums.length);
```

### String

```java
s.length();

s.charAt(i);

s.substring(l, r);

s.toCharArray();

s.equals(t);

s.indexOf("abc");
```

### StringBuilder

```java
StringBuilder sb = new StringBuilder();

sb.append(c);
sb.deleteCharAt(i);
sb.reverse();

String result = sb.toString();
```

### HashMap

```java
Map<Integer, Integer> map = new HashMap<>();

map.put(key, value);

map.get(key);

map.getOrDefault(key, 0);

map.containsKey(key);

map.remove(key);

map.putIfAbsent(key, value);
```

### HashSet

```java
Set<Integer> set = new HashSet<>();

set.add(x);
set.contains(x);
set.remove(x);
```

---

# 36. MUST-KNOW PROBLEMS

## Arrays — Foundation

### Level 1

- Find Maximum
- Find Minimum
- Reverse Array
- Second Largest
- Check Sorted
- Remove Duplicates
- Move Zeroes
- Rotate Array
- Linear Search
- Merge Sorted Arrays

### Level 2

- Two Sum
- Best Time to Buy/Sell Stock
- Maximum Subarray
- Majority Element
- Missing Number
- Find Duplicate Number
- Product Except Self
- Sort Colors
- Merge Intervals

### Level 3

- 3Sum
- 4Sum
- Subarray Sum Equals K
- Maximum Product Subarray
- Longest Consecutive Sequence
- Container With Most Water
- Trapping Rain Water
- First Missing Positive

---

# 37. STRINGS — MUST KNOW

### Level 1

- Reverse String
- Valid Palindrome
- Valid Anagram
- First Unique Character
- Longest Common Prefix
- Reverse Words
- String Compression

### Level 2

- Longest Substring Without Repeating Characters
- Group Anagrams
- Valid Parentheses
- Isomorphic Strings
- Longest Palindromic Substring
- Permutation in String
- Find All Anagrams

### Level 3

- Minimum Window Substring
- Decode String
- Remove Duplicate Letters
- Word Break
- Longest Common Subsequence
- Edit Distance
- Palindrome Partitioning
- Word Search

### Advanced

- KMP
- Z Algorithm
- Rabin-Karp
- Trie
- Manacher's Algorithm
- Suffix structures

---

# 38. HASHMAP — MUST KNOW

If you're comfortable with these, your HashMap foundation is strong:

1. Two Sum
2. Contains Duplicate
3. Valid Anagram
4. First Unique Character
5. Group Anagrams
6. Isomorphic Strings
7. Happy Number
8. Longest Consecutive Sequence
9. Subarray Sum Equals K
10. Longest Subarray Sum K
11. Continuous Subarray Sum
12. Contiguous Array
13. Subarray Sums Divisible by K
14. Top K Frequent Elements
15. LRU Cache

---

# 39. THE BIGGEST THING TO REMEMBER

Don't memorize:

```text
Two Sum → HashMap
3Sum → Two Pointer
Subarray Sum K → Prefix Sum
Longest Substring → Sliding Window
```

Instead memorize the **reason**.

### Ask these questions:

```text
1. Is the data sorted?
        ↓
   Binary Search / Two Pointer

2. Is it contiguous?
        ↓
   Sliding Window / Prefix Sum

3. Do I need frequency?
        ↓
   HashMap / Frequency Array

4. Do I need to know if I've seen something?
        ↓
   HashSet

5. Do I need previous index?
        ↓
   HashMap

6. Do I need longest range?
        ↓
   Earliest index

7. Do I need number of ranges?
        ↓
   Frequency

8. Is it nested?
        ↓
   Stack

9. Is it next/previous greater/smaller?
        ↓
   Monotonic Stack

10. Is it top K?
        ↓
   Heap

11. Is it maximum contiguous sum?
        ↓
   Kadane

12. Is it range sum?
        ↓
   Prefix Sum

13. Is it many range updates?
        ↓
   Difference Array

14. Is it optimization with choices?
        ↓
   Greedy / DP
```

---

# 40. FINAL DSA FOUNDATION MAP

This is the sheet I would actually keep beside you while solving problems:

```text
                    PROBLEM
                       │
                       ▼
               What is the structure?
                       │
        ┌──────────────┼───────────────┐
        ▼              ▼               ▼
      ARRAY          STRING          GRAPH/TREE
        │              │
        └──────┬───────┘
               ▼
          Is it sorted?
               │
        YES ───┴───→ Binary Search / Two Pointer
               │
               NO
               ▼
        Is it contiguous?
               │
        YES ───┴───→ Sliding Window / Prefix Sum
               │
               NO
               ▼
        Need frequency?
          │          │
         YES         NO
          ↓           ↓
       HashMap      Other pattern
          │
          ▼
   Need only existence?
       │          │
      YES         NO
       ↓           ↓
   HashSet      HashMap
                  │
          ┌───────┼────────┐
          ↓       ↓        ↓
       count    index    state
          │       │        │
       freq      pos    prefix state
                           │
                           ▼
                    Prefix + HashMap
```

And then:

```text
Future resolves previous
        ↓
Monotonic Stack

Best K elements
        ↓
Heap

Maximum contiguous sum
        ↓
Kadane

Nested / matching
        ↓
Stack

Repeated range queries
        ↓
Prefix Sum

Repeated range updates
        ↓
Difference Array

Optimization with decisions
        ↓
Greedy / DP

Explore all possibilities
        ↓
Backtracking

Relationships between states
        ↓
Graph / Tree
```

### The real goal

At this point, don't think:

> **"I need to learn more and more DSA topics."**

Think:

> **"I need to become very fast at mapping a problem to a pattern."**

You've already covered most of the major patterns. **Arrays + Strings + HashMap are the foundation layer underneath many of them**, so getting these three extremely comfortable will make the advanced topics much easier to recognize.