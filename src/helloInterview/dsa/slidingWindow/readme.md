Absolutely. **Sliding Window is one of the highest-value DSA patterns**, and it is worth learning separately even though it is technically a specialized form of two pointers.

The key is to stop thinking of it as "two indexes moving." Think:

> **Maintain a contiguous window `[left ... right]`, efficiently update its state, and move the left boundary only when necessary.**

I'll follow the same documentation flow we used for Two Pointer and Bit Manipulation.

---

# Sliding Window — Complete Interview Deep Dive

## 1. Core Mental Model

Suppose:

```text
nums = [2, 1, 5, 1, 3, 2]
```

A window is:

```text
[2, 1, 5]
 ↑     ↑
 L     R
```

Then we move `R`:

```text
[2, 1, 5, 1]
 ↑        ↑
 L        R
```

If the window becomes invalid, move `L`:

```text
   [1, 5, 1]
    ↑     ↑
    L     R
```

So the basic mechanism is:

```text
EXPAND → CHECK → SHRINK → UPDATE
```

This is the fundamental sliding-window cycle.

---

# 2. Why Sliding Window?

Suppose we need:

> Maximum sum of a subarray of size `k`.

Brute force:

```text
Window 1 → calculate sum
Window 2 → calculate sum again
Window 3 → calculate sum again
```

This can become:

```text
O(n × k)
```

Instead:

```text
[2, 1, 5]
```

sum:

```text
8
```

Move window:

```text
[1, 5, 1]
```

Instead of recalculating:

```text
8 - 2 + 1 = 7
```

So every element enters once and leaves once.

```text
O(n)
```

That's the heart of sliding window.

---

# 3. The Two Major Types

Almost every sliding-window problem falls into one of these:

```text
                 SLIDING WINDOW
                       |
              ┌────────┴────────┐
              ↓                 ↓
          FIXED SIZE        VARIABLE SIZE
              |                 |
             K                  |
              |                 |
       max/min/sum          condition
       of every K           determines
       elements             window size
```

This distinction is **extremely important**.

---

# 4. Pattern 1 — Fixed-Size Window

The window always has size:

```text
k
```

Example:

```text
nums = [2,1,5,1,3,2]
k = 3
```

Windows:

```text
[2,1,5]
   [1,5,1]
      [5,1,3]
         [1,3,2]
```

The window size never changes.

---

# 5. Fixed Window Template

```java id="r8q2xn"
int left = 0;

for (int right = 0; right < nums.length; right++) {

    // add nums[right]

    if (right - left + 1 == k) {

        // process current window

        // remove nums[left]
        left++;
    }
}
```

This is the basic fixed-window template.

---

# 6. Fixed Window — Maximum Sum

Example:

```text
[2,1,5,1,3,2]
k = 3
```

```java id="9y0r3d"
int left = 0;
int sum = 0;
int maxSum = Integer.MIN_VALUE;

for (int right = 0; right < nums.length; right++) {

    sum += nums[right];

    if (right - left + 1 == k) {

        maxSum = Math.max(maxSum, sum);

        sum -= nums[left];
        left++;
    }
}

return maxSum;
```

Complexity:

```text
Time:  O(n)
Space: O(1)
```

---

# 7. Fixed Window Recognition

When you see:

> "subarray of size K"

> "substring of length K"

> "every K consecutive elements"

> "maximum/minimum/sum/average of K elements"

immediately think:

```text
FIXED SLIDING WINDOW
```

---

# 8. Fixed Window Questions

Typical problems:

### Level 1

- Maximum sum subarray of size K
- Average of subarrays of size K
- Count occurrences of something in every window
- Maximum number of vowels in substring of length K

### Level 2

- First negative number in every window of size K
- Sliding Window Maximum
- Maximum number of distinct elements in a window
- Permutation in String

### Level 3+

- Anagrams in a string
- Minimum operations for fixed-size windows
- Frequency-based fixed windows
- Binary array window problems

---

# 9. Pattern 2 — Variable-Size Window

This is much more important.

Window size is not fixed.

Instead:

> **A condition determines whether the current window is valid.**

Example:

> Longest subarray with sum ≤ K.

Start:

```text
L
R

[2]
```

Expand:

```text
[2,1]
```

Expand:

```text
[2,1,5]
```

If invalid:

```text
sum > K
```

shrink:

```text
   [1,5]
    L R
```

Continue.

---

# 10. Variable Window Template

This is the template you should memorize.

```java id="j4flq9"
int left = 0;

for (int right = 0; right < n; right++) {

    // Add nums[right]

    while (windowIsInvalid()) {

        // Remove nums[left]
        left++;
    }

    // Current window is valid
    updateAnswer();
}
```

Mental model:

```text
EXPAND
   ↓
INVALID?
   ↓
SHRINK until valid
   ↓
UPDATE answer
```

---

# 11. The Most Important Question

Whenever you see a variable-window problem, ask:

> **What makes my window invalid?**

Examples:

```text
sum > k
```

or:

```text
distinct > k
```

or:

```text
zeros > k
```

or:

```text
frequency condition violated
```

Once you can define:

```text
window invalid
```

the implementation often becomes straightforward.

---

# 12. Longest Subarray With Sum ≤ K

Assume positive numbers:

```text
[2,1,5,1,3,2]
K = 7
```

Template:

```java id="dyq2q7"
int left = 0;
int sum = 0;
int maxLen = 0;

for (int right = 0; right < nums.length; right++) {

    sum += nums[right];

    while (sum > k) {
        sum -= nums[left];
        left++;
    }

    maxLen = Math.max(maxLen, right - left + 1);
}
```

Why `while` rather than `if`?

Because the window may need to remove **multiple elements** before becoming valid.

This is one of the most common sliding-window mistakes.

---

# 13. Longest vs Shortest — Critical Difference

This is probably the most important distinction in variable sliding windows.

## Longest valid window

Usually:

```java id="2lwhny"
while (invalid) {
    shrink();
}

answer = Math.max(answer, windowSize);
```

You shrink only enough to restore validity.

Then:

```text
UPDATE MAX
```

---

## Shortest valid window

Usually:

```java id="myo7yu"
while (valid) {

    answer = Math.min(answer, windowSize);

    shrink();
}
```

So:

```text
LONGEST
→ make valid
→ maximize

SHORTEST
→ make valid
→ minimize while still valid
```

This distinction solves a huge number of problems.

---

# 14. Example — Minimum Size Subarray Sum

Given:

```text
target = 7
nums = [2,3,1,2,4,3]
```

We want:

```text
[4,3]
```

length:

```text
2
```

Template:

```java id="4j7xsp"
int left = 0;
int sum = 0;
int minLen = Integer.MAX_VALUE;

for (int right = 0; right < nums.length; right++) {

    sum += nums[right];

    while (sum >= target) {

        minLen = Math.min(
            minLen,
            right - left + 1
        );

        sum -= nums[left];
        left++;
    }
}

return minLen == Integer.MAX_VALUE ? 0 : minLen;
```

Notice:

```text
while VALID
```

because we want to keep shrinking and find the smallest valid window.

---

# 15. Sliding Window With Frequency Map

This is probably the **most important variable-window pattern for strings**.

Example:

> Longest substring without repeating characters.

Input:

```text
abcabcbb
```

Window:

```text
[a b c]
```

Add:

```text
a
```

Duplicate occurs.

Shrink from left until valid again.

---

## Java Template

```java id="m5o9j7"
Map<Character, Integer> freq = new HashMap<>();

int left = 0;
int maxLen = 0;

for (int right = 0; right < s.length(); right++) {

    char ch = s.charAt(right);

    freq.put(ch, freq.getOrDefault(ch, 0) + 1);

    while (freq.get(ch) > 1) {

        char leftChar = s.charAt(left);

        freq.put(
            leftChar,
            freq.get(leftChar) - 1
        );

        left++;
    }

    maxLen = Math.max(
        maxLen,
        right - left + 1
    );
}
```

Mental model:

```text
window
+
frequency state
```

---

# 16. Pattern 3 — At Most K Distinct

Very important.

Problem:

> Longest substring containing at most K distinct characters.

Example:

```text
eceba
K = 2
```

Valid:

```text
ece
```

because:

```text
e,c = 2 distinct
```

Then:

```text
ec e b
```

has 3 distinct.

Shrink.

---

## Template

```java id="2v2tgc"
Map<Character, Integer> freq = new HashMap<>();

int left = 0;
int maxLen = 0;

for (int right = 0; right < s.length(); right++) {

    char ch = s.charAt(right);

    freq.put(ch, freq.getOrDefault(ch, 0) + 1);

    while (freq.size() > k) {

        char leftChar = s.charAt(left);

        freq.put(
            leftChar,
            freq.get(leftChar) - 1
        );

        if (freq.get(leftChar) == 0) {
            freq.remove(leftChar);
        }

        left++;
    }

    maxLen = Math.max(
        maxLen,
        right - left + 1
    );
}
```

Recognition:

> **"At most K distinct" → sliding window + frequency map.**

---

# 17. Pattern 4 — Exactly K Distinct

This is a very important trick.

Problem:

> Number of subarrays with exactly K distinct elements.

Instead of directly solving:

```text
exactly K
```

use:

```text
exactly K
=
atMost(K) - atMost(K - 1)
```

So:

```java id="v0j3ve"
answer =
    atMostK(nums, k)
    -
    atMostK(nums, k - 1);
```

This is one of the most useful advanced sliding-window transformations.

---

# 18. Why Does This Work?

Suppose:

```text
atMost(3)
```

counts:

```text
1 distinct
2 distinct
3 distinct
```

And:

```text
atMost(2)
```

counts:

```text
1 distinct
2 distinct
```

Subtract:

```text
atMost(3) - atMost(2)
```

leaves:

```text
exactly 3
```

This pattern appears repeatedly.

---

# 19. Pattern 5 — Exactly / At Most / At Least

Remember:

```text
EXACTLY K
=
AT MOST K
-
AT MOST K-1
```

This is particularly useful for:

- distinct elements
- odd numbers
- zeros
- frequency constraints
- binary arrays

Example:

> Number of subarrays with exactly K odd numbers.

Convert:

```text
exactly K odds
```

into:

```text
atMost(K) - atMost(K-1)
```

---

# 20. Pattern 6 — Binary Array Sliding Window

Example:

> Longest subarray containing at most K zeros.

Input:

```text
[1,1,1,0,0,0,1,1]
```

K:

```text
2
```

Window state is simply:

```text
zeroCount
```

Template:

```java id="4ccp7b"
int left = 0;
int zeros = 0;
int maxLen = 0;

for (int right = 0; right < nums.length; right++) {

    if (nums[right] == 0) {
        zeros++;
    }

    while (zeros > k) {

        if (nums[left] == 0) {
            zeros--;
        }

        left++;
    }

    maxLen = Math.max(
        maxLen,
        right - left + 1
    );
}
```

This is the pattern behind:

- Max Consecutive Ones III
- Longest subarray after replacing K zeros
- Minimum flips to satisfy a window condition

---

# 21. Pattern 7 — Character Replacement

Classic problem:

> Longest substring after replacing at most K characters.

Example:

```text
A A B A B
```

Suppose:

```text
K = 1
```

We track:

```text
windowLength
maxFrequency
```

Condition:

```text
windowLength - maxFrequency <= K
```

Why?

Because everything except the most frequent character must be replaced.

---

## Template

```java id="2klb5p"
int[] freq = new int[26];

int left = 0;
int maxFreq = 0;
int maxLen = 0;

for (int right = 0; right < s.length(); right++) {

    int index = s.charAt(right) - 'A';

    freq[index]++;

    maxFreq = Math.max(
        maxFreq,
        freq[index]
    );

    while ((right - left + 1) - maxFreq > k) {

        freq[s.charAt(left) - 'A']--;
        left++;
    }

    maxLen = Math.max(
        maxLen,
        right - left + 1
    );
}
```

This is a very important **window-state derivation** problem.

---

# 22. Pattern 8 — Minimum Window

One of the hardest and most important sliding-window patterns.

Classic:

> Minimum Window Substring

Given:

```text
s = "ADOBECODEBANC"
t = "ABC"
```

Answer:

```text
"BANC"
```

Concept:

```text
Expand until valid
        ↓
Shrink while valid
        ↓
Record smallest
```

Unlike longest-window problems:

```text
while (window is valid) {
    update answer;
    remove left;
}
```

---

# 23. Minimum Window State

We usually maintain:

```text
required frequency
current frequency
formed count
```

For example:

```text
t = "AABC"
```

Required:

```text
A → 2
B → 1
C → 1
```

The window is valid when all requirements are satisfied.

This is a key advanced pattern:

> **The window has a state that tells us whether the requirement has been satisfied.**

---

# 24. Sliding Window + HashSet

Some problems don't need frequencies.

Example:

> Longest substring without repeating characters.

Could use:

```java id="q9bjqa"
Set<Character> set
```

instead of a frequency map.

Template:

```java id="wq1bty"
Set<Character> set = new HashSet<>();

int left = 0;
int maxLen = 0;

for (int right = 0; right < s.length(); right++) {

    while (set.contains(s.charAt(right))) {
        set.remove(s.charAt(left));
        left++;
    }

    set.add(s.charAt(right));

    maxLen = Math.max(
        maxLen,
        right - left + 1
    );
}
```

Use:

```text
Set
```

when you only care about membership.

Use:

```text
Map / frequency array
```

when counts matter.

---

# 25. Sliding Window + Deque

Another major pattern.

Problem:

> Maximum value in every window of size K.

Example:

```text
[1,3,-1,-3,5,3,6,7]
k = 3
```

Output:

```text
[3,3,5,5,6,7]
```

A simple heap gives:

```text
O(n log k)
```

But a **monotonic deque** gives:

```text
O(n)
```

---

# 26. Monotonic Deque

Maintain indices in decreasing value order:

```text
front = largest
```

For every new element:

```text
while back value <= current:
    remove back
```

Then:

```text
while front index is outside window:
    remove front
```

Front is always the maximum.

Template:

```java id="2v1w2k"
Deque<Integer> deque = new ArrayDeque<>();

for (int right = 0; right < nums.length; right++) {

    while (!deque.isEmpty()
            && nums[deque.peekLast()] <= nums[right]) {
        deque.pollLast();
    }

    deque.offerLast(right);

    int left = right - k + 1;

    while (!deque.isEmpty()
            && deque.peekFirst() < left) {
        deque.pollFirst();
    }

    if (right >= k - 1) {
        // nums[deque.peekFirst()] is max
    }
}
```

---

# 27. Sliding Window + Heap

Sometimes window problems need more complicated ordering.

For example:

- Median in every window
- Kth largest in every window

A heap can maintain window statistics.

But:

```text
Sliding Window Maximum
```

usually prefers:

```text
Monotonic Deque
```

because it achieves O(n).

---

# 28. Fixed vs Variable — Decision Tree

```text id="6wh8df"
              SLIDING WINDOW
                    |
             Window size fixed?
              /           \
            YES            NO
             |              |
             ↓              ↓
         size = K       condition
             |              |
             |        ┌─────┴──────┐
             |        ↓            ↓
             |      LONGEST      SHORTEST
             |        |            |
             |        ↓            ↓
             |    while invalid  while valid
             |        |            |
             |        ↓            ↓
             |     maximize      minimize
             |
             ↓
       fixed-size stats
```

---

# 29. Longest vs Shortest Decision

This is worth memorizing separately.

### Longest valid

```java id="q6g2o5"
for (right...) {

    expand();

    while (invalid()) {
        shrink();
    }

    answer = Math.max(answer, length);
}
```

### Shortest valid

```java id="9m7b7k"
for (right...) {

    expand();

    while (valid()) {

        answer = Math.min(answer, length);

        shrink();
    }
}
```

This simple difference appears everywhere.

---

# 30. The Most Important Sliding Window Question

Before coding, answer these four:

### 1. What is my window?

```text
[left ... right]
```

### 2. What state am I maintaining?

Examples:

```text
sum
frequency
distinct count
zero count
max frequency
deque
```

### 3. What makes the window invalid?

Examples:

```text
sum > K
distinct > K
zeros > K
missing required characters
```

### 4. When do I update the answer?

This determines whether you're solving:

```text
longest
shortest
count
maximum
minimum
```

---

# 31. Counting Subarrays — Important Pattern

Sliding window isn't only for finding length.

It can **count** valid subarrays.

Suppose:

> Count subarrays with at most K distinct elements.

Once the window `[left...right]` is valid:

```text
Every subarray ending at right
and starting from left to right
is valid.
```

Number of valid subarrays:

```text
right - left + 1
```

So:

```java id="aq3b8m"
count += right - left + 1;
```

This is a **very important insight**.

---

# 32. Why `right - left + 1`?

Suppose:

```text
[2,1,3,4]
      L   R
```

If the window is valid, these are all valid ending at `R`:

```text
[L ... R]
[L+1 ... R]
[L+2 ... R]
...
[R ... R]
```

Number:

```text
R - L + 1
```

This is one of the most important sliding-window counting tricks.

---

# 33. Count Subarrays With Exactly K Distinct

Use:

```text id="e0x4yl"
exactly(K)
=
atMost(K)
-
atMost(K-1)
```

And:

```java id="z2qbyx"
count += right - left + 1;
```

Together these solve an enormous class of problems.

---

# 34. Sliding Window + Prefix Sum — Important Warning

Sliding window works beautifully when the condition is **monotonic**.

For example, with positive numbers:

```text
sum > K
```

If the window becomes too large, removing elements can reduce the sum.

But if numbers can be negative:

```text
[5,-10,8]
```

the sum doesn't behave monotonically.

Then ordinary sliding window may fail.

This is a critical recognition point.

---

# 35. When Sliding Window DOES NOT Work

Suppose:

```text
nums = [2,-1,2,-3,5]
```

and condition:

```text
sum <= K
```

Because of negative numbers:

```text
adding an element
```

can:

```text
increase OR decrease sum
```

So you can't safely reason:

```text
sum too large → move left
```

in the usual monotonic way.

You may need:

- Prefix Sum
- HashMap
- Monotonic Queue
- Binary Search
- DP

depending on the exact problem.

This is a very common interview trap.

---

# 36. Sliding Window Recognition

Look for:

```text
subarray
substring
contiguous
consecutive
window
longest
shortest
maximum
minimum
at most K
at least K
exactly K
contains all
contains no
replace at most K
delete at most K
```

Then ask:

> **Can I maintain the required property incrementally as the window moves?**

If yes:

```text
Sliding Window
```

---

# 37. Common Mistakes

## Mistake 1 — Using `if` instead of `while`

Wrong:

```java id="1c8t8d"
if (invalid()) {
    left++;
}
```

Often correct:

```java id="knj3qz"
while (invalid()) {
    left++;
}
```

Because several elements may need to be removed.

---

# 38. Mistake 2 — Updating Answer at Wrong Time

For longest:

```text
make valid
→ update
```

For shortest:

```text
while valid
→ update
→ shrink
```

For counting:

```text
window valid
→ count += right-left+1
```

---

# 39. Mistake 3 — Forgetting to Remove State

If you add:

```java id="o1spg8"
freq[s.charAt(right)]++;
```

when moving left:

```java id="1gj6m6"
freq[s.charAt(left)]--;
```

must happen.

Otherwise your window state doesn't represent the actual window.

---

# 40. Mistake 4 — Forgetting to Remove Zero Frequency

With:

```java id="jot4z7"
Map<Character,Integer>
```

after decrementing:

```text
A → 0
```

you may need:

```java id="w4n5p1"
map.remove('A');
```

especially when checking:

```text
map.size()
```

for distinct count.

---

# 41. Mistake 5 — Sorting

Sliding window usually relies on:

```text
CONTIGUITY
```

Sorting destroys the original sequence.

So if the problem says:

```text
subarray
substring
contiguous
```

don't casually sort.

---

# 42. Mistake 6 — Using Sliding Window With Negative Numbers

This is one of the biggest traps.

For sum-based problems:

```text
positive numbers
→ sliding window often works

negative numbers
→ be suspicious
```

It isn't an absolute rule, but it is an excellent warning signal.

---

# 43. Mistake 7 — Confusing Subarray and Subsequence

Sliding window operates on:

```text
CONTIGUOUS
```

elements.

Example:

```text
[1,2,3,4]
```

Subarray:

```text
[2,3]
```

Subsequence:

```text
[1,3,4]
```

Subsequence is not necessarily contiguous.

Don't automatically use sliding window for subsequences.

---

# 44. Mistake 8 — Overusing HashMap

Sometimes you only need:

```text
sum
```

or:

```text
zeroCount
```

Don't create a map unnecessarily.

Use the smallest state possible.

For example:

```text
binary array
→ zeroCount
```

rather than:

```text
HashMap<Integer,Integer>
```

---

# 45. Complexity

The key sliding-window property:

> Even though there is a nested `while`, it is usually still O(n).

Why?

`right` moves:

```text
0 → n-1
```

once.

`left` also moves:

```text
0 → n-1
```

at most once.

So:

```text
O(n + n)
=
O(n)
```

not:

```text
O(n²)
```

This is called **amortized analysis**.

---

# 46. Fixed Window Complexity

Usually:

```text
Time: O(n)
Space: O(1)
```

or:

```text
O(alphabet size)
```

for frequency arrays.

---

# 47. Variable Window Complexity

With HashMap:

```text
Time: O(n)
Space: O(k)
```

where `k` is number of distinct values/characters tracked.

With a fixed alphabet:

```text
Space: O(1)
```

because alphabet size is bounded.

---

# 48. Sliding Window + Deque

For:

```text
Sliding Window Maximum
```

each index:

```text
enters deque once
leaves deque once
```

Therefore:

```text
O(n)
```

This is an important amortized-analysis example.

---

# 49. Level-Wise Problem Segregation

Now your actual preparation roadmap.

---

# 🟢 Level 1 — Fixed Window

Master the mechanics.

1. Maximum Sum Subarray of Size K
2. Maximum Average Subarray I
3. Number of Sub-arrays of Size K and Average ≥ Threshold
4. Maximum Number of Vowels in a Substring of Given Length
5. Find All Anagrams in a String
6. Permutation in String

### Goal

You should instantly write:

```java
if (right - left + 1 == k)
```

---

# 🟡 Level 2 — Basic Variable Window

1. Minimum Size Subarray Sum
2. Longest Subarray with Sum ≤ K
3. Longest Substring Without Repeating Characters
4. Max Consecutive Ones III
5. Longest Substring with At Most K Distinct Characters
6. Fruit Into Baskets
7. Longest Repeating Character Replacement

### Goal

Understand:

```text
expand
→ invalid
→ shrink
→ update
```

---

# 🟠 Level 3 — Frequency / Counting

This is extremely important.

1. Permutation in String
2. Find All Anagrams in a String
3. Longest Substring with At Most K Distinct
4. Subarrays with K Different Integers
5. Number of Nice Subarrays
6. Binary Subarrays With Sum
7. Count Number of Nice Subarrays
8. Count Subarrays with At Most K Distinct
9. Subarrays with Exactly K Distinct

### Key pattern

```text
EXACTLY K
=
AT MOST K
-
AT MOST K-1
```

---

# 🔴 Level 4 — Advanced Variable Window

1. Minimum Window Substring
2. Minimum Window Subsequence
3. Longest Repeating Character Replacement
4. Subarray Product Less Than K
5. Minimum Operations to Reduce X to Zero
6. Max Consecutive Ones III
7. Longest Continuous Subarray With Absolute Diff ≤ Limit
8. Frequency of the Most Frequent Element

These require more sophisticated window state.

---

# 🟣 Level 5 — Sliding Window + Data Structures

1. Sliding Window Maximum
2. Sliding Window Minimum
3. Sliding Window Median
4. Longest Continuous Subarray With Absolute Diff ≤ Limit
5. Frequency-based window problems
6. Kth largest/smallest in every window

Patterns:

```text
Sliding Window
+
Deque
```

or:

```text
Sliding Window
+
Heap
```

or:

```text
Sliding Window
+
TreeMap / balanced structure
```

---

# ⚫ Level 6 — Advanced / FAANG

These aren't always pure sliding window problems.

1. Minimum Window Substring
2. Minimum Window Subsequence
3. Subarrays with K Different Integers
4. Count Subarrays With Median K
5. Subarrays with More Zeros Than Ones
6. Longest Subarray of 1's After Deleting One Element
7. Shortest Subarray With Sum at Least K
8. Sliding Window Median
9. Maximum Frequency After Operations
10. Advanced monotonic deque problems

Here the important skill is deciding:

> **Is sliding window actually valid, or do I need prefix sum / deque / binary search / another technique?**

---

# 50. The Most Important Problems to Master

You don't need 100 sliding-window problems.

If you understand these deeply, you'll cover most interview patterns:

### Must Know

```text
1. Maximum Sum Subarray of Size K
2. Minimum Size Subarray Sum
3. Longest Substring Without Repeating Characters
4. Longest Substring with At Most K Distinct Characters
5. Fruit Into Baskets
6. Longest Repeating Character Replacement
7. Max Consecutive Ones III
8. Permutation in String
9. Find All Anagrams
10. Subarrays with K Different Integers
11. Number of Nice Subarrays
12. Minimum Window Substring
13. Sliding Window Maximum
14. Longest Continuous Subarray With Absolute Diff ≤ Limit
15. Subarray Product Less Than K
```

---

# 51. Sliding Window Pattern Map

```text id="9t9hba"
                    SLIDING WINDOW
                          |
             ┌────────────┴────────────┐
             ↓                         ↓
          FIXED SIZE              VARIABLE SIZE
             |                         |
          size = K               condition-based
             |                         |
       ┌─────┴─────┐             ┌─────┴──────┐
       ↓           ↓             ↓            ↓
      sum        frequency     LONGEST      SHORTEST
      max        distinct        |             |
      min        anagram        while         while
      count      vowels        invalid       valid
                                 ↓             ↓
                              maximize      minimize
```

Then another layer:

```text id="k6w4zw"
VARIABLE WINDOW
      |
      ├── sum/state
      |
      ├── HashMap / frequency
      |
      ├── Set
      |
      ├── Deque
      |
      ├── Heap
      |
      └── atMost(K)
             |
             ↓
       exactly K
       =
       atMost(K)
       -
       atMost(K-1)
```

---

# 52. Sliding Window vs Two Pointer

This distinction is worth making very clear.

### Two Pointer

General technique:

```text
L ---------------- R
```

Pointers can represent:

- pair endpoints
- linked-list positions
- partitions
- two arrays
- window boundaries

### Sliding Window

Specialized two-pointer technique:

```text
[L ............ R]
```

where the range is:

> **contiguous and dynamically maintained.**

Therefore:

```text
Every sliding window problem
is fundamentally two-pointer.

But not every two-pointer problem
is sliding window.
```

---

# 53. Sliding Window vs Prefix Sum

This is another important interview decision.

### Positive numbers + contiguous + condition

Think:

```text
Sliding Window
```

### Negative numbers involved

Be suspicious.

Potentially:

```text
Prefix Sum
+
HashMap
```

or:

```text
Prefix Sum
+
Monotonic Deque
```

For example:

```text
Subarray Sum Equals K
```

usually:

```text
Prefix Sum + HashMap
```

not sliding window.

Why?

Because negative numbers destroy the monotonic behavior required for the standard window approach.

---

# 54. Sliding Window vs Two Pointer vs Prefix Sum

| Signal | Pattern |
|---|---|
| Pair + sorted | Two Pointer |
| Contiguous + fixed K | Fixed Sliding Window |
| Contiguous + positive numbers + condition | Sliding Window |
| String + frequency condition | Sliding Window |
| At most K | Sliding Window |
| Exactly K | AtMost(K) − AtMost(K−1) |
| Negative numbers + exact sum | Prefix Sum + HashMap |
| Range max/min | Sliding Window + Deque |
| Range kth/median | Sliding Window + Heap/Tree |
| Subsequence | Usually not Sliding Window |

---

# 55. The Golden Sliding Window Framework

Before writing code, always write this mentally:

```text
WINDOW:
[left ... right]

STATE:
What information describes the window?

EXPAND:
right++

INVALID:
What condition breaks?

SHRINK:
left++

ANSWER:
When do I record the result?
```

For example:

### Longest substring with at most K distinct

```text
WINDOW:
[left ... right]

STATE:
frequency map

EXPAND:
right++

INVALID:
distinct > K

SHRINK:
remove nums[left]

ANSWER:
max length
```

### Minimum Window Substring

```text
WINDOW:
[left ... right]

STATE:
required/current frequencies

EXPAND:
right++

VALID:
all required characters satisfied

SHRINK:
while valid

ANSWER:
minimum length
```

### Maximum sum of K elements

```text
WINDOW:
exactly K

STATE:
sum

EXPAND:
right++

SHRINK:
when size == K

ANSWER:
max sum
```

---

# 56. The 10 Recognition Signals to Memorize

```text id="9w3c9v"
"size K"
        → Fixed Window

"longest substring"
        → Variable Window

"shortest subarray"
        → Variable Window

"at most K"
        → Sliding Window

"exactly K"
        → AtMost(K) - AtMost(K-1)

"distinct characters"
        → HashMap/Set + Window

"contains all characters"
        → Frequency Window

"replace/delete at most K"
        → Window + violation count

"max/min in every window"
        → Monotonic Deque

"negative numbers + exact sum"
        → Be suspicious of Sliding Window
```

---

# 57. Final Sliding Window Cheat Sheet

```text id="q7n5mj"
=====================================================
                 SLIDING WINDOW
=====================================================

CORE IDEA
-----------------------------------------------------
Maintain a contiguous window [left ... right].

EXPAND → CHECK → SHRINK → UPDATE


TYPE 1: FIXED WINDOW
-----------------------------------------------------

Window size = K

Template:

left = 0

for right = 0 ... n-1:

    add(right)

    if windowSize == K:

        update answer

        remove(left)
        left++


TYPE 2: VARIABLE WINDOW
-----------------------------------------------------

Window size determined by condition.

Template:

left = 0

for right = 0 ... n-1:

    add(right)

    while INVALID:

        remove(left)
        left++

    update answer


LONGEST
-----------------------------------------------------

while INVALID:
    shrink

maximize answer


SHORTEST
-----------------------------------------------------

while VALID:
    update answer
    shrink


COUNT
-----------------------------------------------------

if window valid:

    count += right - left + 1


EXACTLY K
-----------------------------------------------------

exactly(K)
=
atMost(K)
-
atMost(K - 1)


COMMON WINDOW STATE
-----------------------------------------------------

sum
frequency map
frequency array
HashSet
distinct count
zero count
max frequency
deque
heap


FIXED WINDOW SIGNALS
-----------------------------------------------------

"size K"
"length K"
"every K elements"
"every K characters"


VARIABLE WINDOW SIGNALS
-----------------------------------------------------

"longest"
"shortest"
"at most K"
"at least K"
"contains all"
"replace at most K"
"delete at most K"


DATA STRUCTURE COMBINATIONS
-----------------------------------------------------

Window + HashMap
→ frequency / distinct

Window + Set
→ uniqueness

Window + Deque
→ max/min

Window + Heap
→ median / kth

Window + Prefix Sum
→ special cases


IMPORTANT WARNING
-----------------------------------------------------

Negative numbers can break normal
sum-based sliding-window reasoning.

Subarray != subsequence.


COMPLEXITY
-----------------------------------------------------

Usually O(n)

Why?

left moves at most n times.
right moves at most n times.

Space:
O(1), O(K), or O(alphabet)


CORE MENTAL MODEL
-----------------------------------------------------

WINDOW
   ↓
STATE
   ↓
VALID / INVALID
   ↓
SHRINK / EXPAND
   ↓
ANSWER
=====================================================
```

---

## The one mental model I'd want you to retain

When you encounter an unfamiliar problem, don't immediately think **"sliding window."**

Think:

```text
Is the answer about a CONTIGUOUS range?
              ↓
Can I maintain the range's STATE incrementally?
              ↓
Can I define when the window becomes INVALID?
              ↓
Can moving LEFT always restore validity?
              ↓
YES
 ↓
SLIDING WINDOW
```

And then classify it:

```text
fixed size?
    → fixed window

longest valid?
    → shrink while invalid, maximize

shortest valid?
    → shrink while valid, minimize

count valid?
    → right - left + 1

exactly K?
    → atMost(K) - atMost(K-1)

max/min per window?
    → monotonic deque

negative numbers?
    → STOP and verify whether sliding window is actually valid
```

That is the **core interview-level sliding-window framework**. Once these patterns are internalized, most "new" sliding-window problems become variations of maintaining the correct **window state + validity condition**, rather than completely new algorithms.