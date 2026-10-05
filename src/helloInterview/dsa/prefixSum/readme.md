Absolutely. **Prefix Sum is another high-ROI pattern**, and just like Sliding Window and Stack, the trick is not memorizing individual problems. It is recognizing the transformation:

> **Turn repeated range calculations into O(1) queries by remembering the cumulative information from the beginning.**

And there is a much bigger family around it:

```text
Prefix Sum
├── Basic Range Sum
├── Prefix Sum + HashMap
├── Prefix Sum + Frequency
├── Prefix Sum + Two Pointer
├── Prefix XOR
├── 2D Prefix Sum
├── Difference Array
├── Prefix Sum + Binary Search
├── Prefix Sum + Monotonic Deque
└── Prefix Sum + DP / Greedy
```

Let's follow the exact same documentation flow.

---

# Prefix Sum — Complete Interview Deep Dive

# 1. Core Mental Model

Suppose:

```text
nums = [2, 4, 1, 3, 5]
```

and you repeatedly ask:

```text
sum(1...3)
sum(2...4)
sum(0...2)
...
```

If you calculate each range from scratch:

```text
O(n)
```

per query.

With many queries:

```text
O(n × q)
```

can become expensive.

Instead, preprocess:

```text
prefix[i] = sum of elements from 0 to i
```

For our array:

```text
nums:
  2   4   1   3   5

prefix:
  2   6   7  10  15
```

Now:

```text
sum(L...R)
=
prefix[R] - prefix[L-1]
```

So a range sum becomes:

```text
O(1)
```

That's the fundamental Prefix Sum idea.

---

# 2. The Most Important Formula

For:

```text
nums = [2,4,1,3,5]
```

Suppose:

```text
L = 1
R = 3
```

We want:

```text
4 + 1 + 3
= 8
```

Prefix:

```text
[2,6,7,10,15]
```

Then:

```text
prefix[3] - prefix[0]
=
10 - 2
=
8
```

General formula:

```text
sum(L, R) =
prefix[R] - prefix[L - 1]
```

But this has a special case when:

```text
L = 0
```

because `prefix[-1]` doesn't exist.

That's why an even better implementation is:

```text
prefix[0] = 0
```

before the array.

---

# 3. The Best Prefix Sum Template

Instead of:

```text
prefix[i] = sum(0...i)
```

use:

```text
prefix[i] = sum of first i elements
```

So:

```text
nums:
       2  4  1  3  5

prefix:
       0  2  6  7 10 15
       ↑
     empty
```

Then:

```text
sum(L...R)
=
prefix[R + 1] - prefix[L]
```

This is much cleaner.

---

## Java

```java
int n = nums.length;

int[] prefix = new int[n + 1];

for (int i = 0; i < n; i++) {
    prefix[i + 1] = prefix[i] + nums[i];
}
```

Range:

```java
int sum = prefix[right + 1] - prefix[left];
```

This eliminates special cases.

---

# 4. Why Prefix Sum Works

Think of:

```text
prefix[R]
```

as:

```text
everything from 0 → R
```

and:

```text
prefix[L]
```

as:

```text
everything from 0 → L-1
```

Subtract:

```text
0 ------------------- R
0 ------- L-1
```

Everything before `L` cancels.

Remaining:

```text
L -------- R
```

That's the entire idea.

---

# 5. Prefix Sum Recognition

When you see:

```text
range sum
sum of subarray
sum between L and R
many range queries
cumulative sum
subarray sum
running total
```

immediately consider:

```text
PREFIX SUM
```

But there is a much more important advanced signal:

> **"Find a subarray whose sum satisfies X."**

Then Prefix Sum + HashMap may be the answer.

---

# 6. Pattern 1 — Basic Range Sum

Suppose:

```text
nums = [1,2,3,4,5]
```

Queries:

```text
[1,3]
[0,2]
[2,4]
```

Build:

```text
prefix = [0,1,3,6,10,15]
```

Then:

```text
[1,3]
= prefix[4] - prefix[1]
= 10 - 1
= 9
```

### Complexity

Preprocessing:

```text
O(n)
```

Each query:

```text
O(1)
```

Total:

```text
O(n + q)
```

instead of:

```text
O(nq)
```

This is the most basic use of prefix sum.

---

# 7. Pattern 2 — Prefix Sum + HashMap

This is where Prefix Sum becomes a **major interview pattern**.

Classic problem:

> Find the number of subarrays whose sum equals K.

Example:

```text
nums = [1,2,3]
K = 3
```

Valid subarrays:

```text
[1,2]
[3]
```

Answer:

```text
2
```

Brute force:

```text
O(n²)
```

Prefix Sum + HashMap:

```text
O(n)
```

---

# 8. The Mathematical Transformation

Suppose current prefix sum is:

```text
prefix[j]
```

We want some earlier prefix:

```text
prefix[i]
```

such that:

```text
prefix[j] - prefix[i] = K
```

Rearrange:

```text
prefix[i] = prefix[j] - K
```

This is the key transformation.

So while scanning:

```text
currentPrefix = prefix[j]
```

we ask:

> **Have I seen `currentPrefix - K` before?**

If yes, every occurrence represents a valid subarray.

This is one of the most important Prefix Sum patterns.

---

# 9. Subarray Sum Equals K

```java
public int subarraySum(int[] nums, int k) {

    Map<Integer, Integer> freq = new HashMap<>();

    freq.put(0, 1);

    int prefix = 0;
    int count = 0;

    for (int num : nums) {

        prefix += num;

        int needed = prefix - k;

        count += freq.getOrDefault(needed, 0);

        freq.put(
            prefix,
            freq.getOrDefault(prefix, 0) + 1
        );
    }

    return count;
}
```

---

# 10. Why `freq.put(0, 1)`?

This is a very important detail.

Suppose:

```text
nums = [3]
K = 3
```

At `3`:

```text
prefix = 3
needed = 3 - 3 = 0
```

We need to say:

> Prefix sum `0` occurred once before the array began.

Therefore:

```java
freq.put(0, 1);
```

represents the empty prefix.

Then:

```text
prefix[0...0] = 3 - 0 = 3
```

is correctly counted.

---

# 11. The Prefix Sum + HashMap Mental Model

This is worth memorizing:

```text
Current prefix
      |
      ↓
current - target
      |
      ↓
Have I seen this prefix before?
      |
    YES
      |
      ↓
That earlier prefix defines a valid subarray
```

So:

```text
"subarray sum = K"
```

should immediately trigger:

```text
PREFIX SUM + HASHMAP
```

especially when negative numbers are allowed.

---

# 12. Why Sliding Window Fails Here

Consider:

```text
nums = [1,-1,1]
```

Negative values destroy monotonicity.

For:

```text
sum > K
```

you cannot always safely say:

```text
move left
```

because removing an element might:

```text
increase OR decrease
```

the sum.

Prefix Sum doesn't care.

It converts:

```text
subarray sum
```

into:

```text
difference of two prefix sums
```

This is a very important pattern distinction.

---

# 13. Prefix Sum vs Sliding Window

| Situation | Usually think |
|---|---|
| Positive numbers + longest/shortest condition | Sliding Window |
| Exact subarray sum K | Prefix Sum + HashMap |
| Negative numbers | Prefix Sum often |
| Many range sum queries | Prefix Sum |
| Fixed window sum | Sliding Window |
| Sum of all subarrays | Prefix/contribution |
| 2D rectangle sum | 2D Prefix Sum |

A very useful rule:

> **Sliding Window maintains a moving range. Prefix Sum remembers cumulative history.**

---

# 14. Pattern 3 — Prefix Sum + Frequency

The HashMap isn't always storing a boolean.

Sometimes:

```text
prefix → frequency
```

This allows us to count **multiple valid subarrays**.

Example:

```text
nums = [0,0,0]
K = 0
```

Prefix sums:

```text
0
0
0
0
```

Every pair of equal prefix sums gives a zero-sum subarray.

So frequency is essential.

---

# 15. Equal Prefix Sums

Suppose:

```text
prefix[i] = prefix[j]
```

Then:

```text
prefix[j] - prefix[i] = 0
```

Therefore:

> The subarray between them has sum zero.

This leads to another important recognition signal:

```text
"zero-sum subarray"
```

→ Prefix Sum + HashMap/Set.

---

# 16. Pattern 4 — Longest Subarray With Sum K

Instead of counting:

> Find the **longest** subarray with sum K.

Again:

```text
prefix[j] - prefix[i] = K
```

so:

```text
prefix[i] = prefix[j] - K
```

But now we don't want the number of occurrences.

We want:

```text
maximum distance
```

Therefore store:

```text
prefix → earliest index
```

---

## Template

```java
Map<Integer, Integer> firstIndex = new HashMap<>();

firstIndex.put(0, -1);

int prefix = 0;
int maxLen = 0;

for (int i = 0; i < nums.length; i++) {

    prefix += nums[i];

    int needed = prefix - k;

    if (firstIndex.containsKey(needed)) {

        maxLen = Math.max(
            maxLen,
            i - firstIndex.get(needed)
        );
    }

    // Store only first occurrence
    firstIndex.putIfAbsent(prefix, i);
}
```

Important:

> **For longest, store the earliest occurrence.**

Why?

Earlier index → larger possible subarray.

---

# 17. Count vs Longest

This distinction is extremely important.

### Count subarrays

Store:

```text
prefix → frequency
```

### Longest subarray

Store:

```text
prefix → earliest index
```

### Shortest subarray

This usually needs a different strategy; blindly storing the first index isn't enough.

Remember:

```text
COUNT
→ frequency

LONGEST
→ earliest index
```

---

# 18. Pattern 5 — Equal 0s and 1s

Classic transformation.

Problem:

> Find longest subarray with equal number of 0s and 1s.

Transform:

```text
0 → -1
1 → +1
```

Now:

```text
equal 0s and 1s
```

means:

```text
sum = 0
```

Example:

```text
[0,1,0,1]
```

becomes:

```text
[-1,+1,-1,+1]
```

Now use:

```text
Prefix Sum + earliest index
```

This is an extremely important problem-solving technique:

> **Transform the condition into a prefix-sum condition.**

---

# 19. Why the Transformation Works

Suppose:

```text
zeros = 3
ones = 3
```

After transformation:

```text
3 × (-1) + 3 × (+1)
= 0
```

Therefore:

```text
equal counts
↔
subarray sum = 0
```

This same trick can solve many problems.

---

# 20. Pattern 6 — Equal Number of Multiple Values

Suppose a problem asks:

> Equal number of A, B and C.

You can't simply track one sum.

Instead track **differences**.

For example:

```text
countA - countB
countA - countC
```

Represent the state as:

```text
(diffAB, diffAC)
```

If the same state appears twice:

```text
state[i] == state[j]
```

then the subarray between them has equal counts of A, B and C.

Use:

```text
HashMap<State, earliestIndex>
```

This is an advanced prefix-state pattern.

---

# 21. Pattern 7 — Prefix Sum + Parity

Sometimes the problem doesn't care about exact sum.

It cares whether the sum is:

```text
even / odd
```

Then you only need:

```text
prefix % 2
```

If two prefix sums have the same parity:

```text
prefix[i] % 2 == prefix[j] % 2
```

their difference is even.

This can turn some parity-subarray problems into:

```text
Prefix state + HashMap
```

---

# 22. Pattern 8 — Prefix XOR

Prefix Sum has a sibling:

```text
PREFIX XOR
```

Instead of:

```text
prefix[i] = prefix[i-1] + nums[i]
```

we use:

```text
prefix[i] = prefix[i-1] ^ nums[i]
```

Example:

```text
nums:
1 2 3 4
```

Prefix XOR:

```text
0
1
1^2 = 3
3^3 = 0
0^4 = 4
```

So:

```text
[0,1,3,0,4]
```

---

# 23. XOR Range Query

For XOR:

```text
XOR(L...R)
=
prefix[R+1] ^ prefix[L]
```

Why?

Because:

```text
x ^ x = 0
```

so everything before `L` cancels.

This is exactly analogous to:

```text
sum(L...R)
=
prefix[R+1] - prefix[L]
```

---

# 24. Prefix Sum vs Prefix XOR

| Prefix Sum | Prefix XOR |
|---|---|
| `+` | `^` |
| subtract prefix | XOR prefixes |
| arithmetic cumulative state | bitwise cumulative state |
| range sum | range XOR |
| sum = K problems | XOR = K variants |

Recognition:

```text
range XOR
XOR of subarray
XOR queries
```

→ Prefix XOR.

---

# 25. Pattern 9 — 2D Prefix Sum

Now extend Prefix Sum to matrices.

Matrix:

```text
1 2 3
4 5 6
7 8 9
```

Suppose you want the sum of any rectangle.

Doing it from scratch costs:

```text
O(rows × cols)
```

per query.

2D Prefix Sum makes it:

```text
O(1)
```

per query.

---

# 26. 2D Prefix Sum Mental Model

Define:

```text
prefix[i][j]
```

as the sum of the rectangle from:

```text
(0,0)
```

to:

```text
(i-1,j-1)
```

Then:

```text
prefix[i][j]
=
matrix[i-1][j-1]
+ prefix[i-1][j]
+ prefix[i][j-1]
- prefix[i-1][j-1]
```

Why subtract?

Because the top-left region was counted twice.

---

# 27. 2D Prefix Formula

```text
P(i,j)
=
A(i,j)
+
P(i-1,j)
+
P(i,j-1)
-
P(i-1,j-1)
```

Visual:

```text
        ┌──────────────┐
        │      A       │
        │              │
        │              │
        └──────────────┘
```

The two prefix regions overlap at:

```text
top-left
```

so subtract once.

---

# 28. Querying a Rectangle

Suppose rectangle:

```text
(row1, col1)
        ↓
        ┌─────────┐
        │         │
        │   R     │
        │         │
        └─────────┘
                  ↑
              (row2,col2)
```

Formula:

```text
sum =
prefix[row2+1][col2+1]
- prefix[row1][col2+1]
- prefix[row2+1][col1]
+ prefix[row1][col1]
```

This is exactly the 2D version of:

```text
large region
- unwanted regions
+ overlap
```

---

# 29. 2D Prefix Sum Recognition

When you see:

```text
matrix
rectangle sum
submatrix sum
many region queries
grid cumulative sum
```

think:

```text
2D PREFIX SUM
```

Classic problem:

> Range Sum Query 2D — Immutable.

---

# 30. Pattern 10 — Difference Array

This is closely related to Prefix Sum but works in the **opposite direction**.

Prefix Sum answers:

> What is the cumulative value at this point?

Difference Array helps:

> Apply many range updates efficiently.

Suppose:

```text
nums = [0,0,0,0,0]
```

Operation:

```text
add 3 to [1,3]
```

Instead of updating:

```text
index 1
index 2
index 3
```

we mark:

```text
diff[1] += 3
diff[4] -= 3
```

Then prefix-sum the difference array.

Result:

```text
[0,3,3,3,0]
```

---

# 31. Difference Array Mental Model

For range update:

```text
[L, R] += X
```

do:

```java
diff[L] += X;

if (R + 1 < n) {
    diff[R + 1] -= X;
}
```

Then reconstruct:

```java
int current = 0;

for (int i = 0; i < n; i++) {

    current += diff[i];

    nums[i] = current;
}
```

So:

```text
Range updates
→ Difference Array
→ Prefix Sum
```

This is a very useful connection.

---

# 32. Prefix Sum and Difference Array

Think of them as inverses:

```text
Original Array
     |
     | difference
     ↓
Difference Array
     |
     | prefix sum
     ↓
Original / Updated Array
```

Or:

```text
Prefix Sum:
array → cumulative information

Difference:
range update → boundary information
```

---

# 33. Pattern 11 — Prefix Sum + Binary Search

Suppose all values are positive and we want:

> Find the first prefix sum ≥ target.

Since prefix sums are increasing:

```text
prefix:
2 5 8 12 17 21
```

we can binary search.

This gives:

```text
O(log n)
```

per query/search.

Recognition:

```text
positive numbers
+
cumulative sum
+
find first position meeting threshold
```

→ Prefix Sum + Binary Search.

---

# 34. Pattern 12 — Prefix Sum + Monotonic Deque

Advanced but important.

Problem:

> Shortest Subarray With Sum At Least K

Here numbers may be negative.

Normal sliding window fails.

We create:

```text
prefix[i]
```

and want:

```text
prefix[j] - prefix[i] >= K
```

with minimum:

```text
j - i
```

Then maintain candidate prefix indices in a **monotonic deque**.

This combines:

```text
Prefix Sum
+
Monotonic Deque
```

This is a Level 5 pattern.

---

# 35. Why Monotonic Deque?

Suppose prefix sums are:

```text
[0, 2, 5, 3, 7]
```

If an earlier prefix is larger than a later prefix:

```text
5
3
```

the `5` may be useless.

Why?

For the same future `j`:

```text
prefix[j] - 3
```

is better than:

```text
prefix[j] - 5
```

and `3` is later, so it also gives a shorter interval.

Therefore remove dominated candidates.

This is a powerful advanced optimization.

---

# 36. Pattern 13 — Prefix Sum + Contribution

Prefix Sum can also help calculate:

> Sum of all subarrays.

Suppose:

```text
nums = [1,2,3]
```

Subarrays:

```text
[1]
[2]
[3]
[1,2]
[2,3]
[1,2,3]
```

Instead of enumerating all:

For each element:

```text
nums[i]
```

count how many subarrays contain it.

Number of choices:

```text
left choices = i + 1
right choices = n - i
```

Contribution:

```text
nums[i] × (i+1) × (n-i)
```

This is technically a **contribution technique**, but it belongs naturally with the prefix/range-sum family.

---

# 37. Pattern 14 — Prefix Sum + HashMap for Longest/Count

This is the family you should know extremely well.

```text
                    PREFIX SUM
                         |
                 current prefix
                         |
                 need previous prefix
                         |
              ┌──────────┴───────────┐
              ↓                      ↓
         Count occurrences       Find longest
              |                      |
          frequency             earliest index
              |                      |
       Subarray sum K        Longest sum K
```

This one transformation solves a large number of problems.

---

# 38. Pattern 15 — Prefix State, Not Just Prefix Sum

This is a more advanced mental model.

The actual pattern is:

> **Store a cumulative state, then find two equal/related states.**

The state doesn't necessarily have to be a number.

It can be:

```text
prefix sum
prefix XOR
parity
frequency difference
(countA - countB)
(countA-countB, countA-countC)
```

So the generalized pattern is:

```text
PREFIX STATE + HASHMAP
```

This is much more powerful than just memorizing "prefix sum."

---

# 39. Example — Equal Number of 0 and 1

State:

```text
0 → -1
1 → +1
```

Prefix sum:

```text
state
```

Same state twice:

```text
prefix[j] == prefix[i]
```

means:

```text
sum(i+1...j) = 0
```

which means:

```text
equal 0 and 1
```

So:

```text
Original problem
      ↓
Transform
      ↓
Prefix state
      ↓
HashMap
```

This is a core interview technique.

---

# 40. Example — Equal Number of A, B, C

State:

```text
countA - countB
countA - countC
```

Store:

```text
Map<Pair, earliestIndex>
```

If the same pair occurs again:

```text
differenceA-B unchanged
differenceA-C unchanged
```

therefore:

```text
A count = B count = C count
```

inside that interval.

This is advanced Prefix State thinking.

---

# 41. Prefix Sum Recognition Flowchart

```text
                     ARRAY / MATRIX
                           |
                  Need cumulative info?
                     /            \
                   YES             NO
                    |
                    ↓
             Range / Subarray?
                    |
          ┌─────────┴──────────┐
          ↓                    ↓
      Range Query          Subarray Property
          |                    |
          ↓                    ↓
      Prefix Sum        Need exact sum?
          |                    |
          |             ┌──────┴──────┐
          |             ↓             ↓
          |            YES           NO
          |             |             |
          |             ↓             ↓
          |       Prefix + Map    Transform state
          |                           |
          ↓                           ↓
       2D Matrix                  Prefix State
          |                           |
          ↓                           ↓
      2D Prefix                 HashMap / DP
```

---

# 42. The Most Important Recognition Signals

```text
"range sum"
        → Prefix Sum

"many range queries"
        → Prefix Sum

"subarray sum = K"
        → Prefix Sum + HashMap

"count subarrays with sum K"
        → Prefix Sum + frequency

"longest subarray sum K"
        → Prefix Sum + earliest index

"zero-sum subarray"
        → Prefix Sum + HashMap

"equal 0s and 1s"
        → Transform + Prefix Sum

"equal counts"
        → Prefix State + HashMap

"range XOR"
        → Prefix XOR

"rectangle sum"
        → 2D Prefix Sum

"many range updates"
        → Difference Array

"negative numbers + shortest sum ≥ K"
        → Prefix Sum + Monotonic Deque
```

---

# 43. Prefix Sum vs Sliding Window

This deserves a dedicated table.

| Signal | Prefix Sum | Sliding Window |
|---|---|---|
| Range sum queries | ✅ | ❌ |
| Exact subarray sum K | ✅ | Sometimes |
| Negative numbers | ✅ | Usually problematic |
| Positive numbers | ✅ | ✅ |
| Longest valid contiguous | Sometimes | Often |
| Fixed-size window | Possible | Usually simpler |
| Many queries | Excellent | Usually no |
| Count subarrays | Excellent with Map | Often |
| Frequency constraints | ❌ | Excellent |
| Distinct characters | ❌ | Sliding Window |
| Dynamic range updates | Difference Array | ❌ |

The important distinction:

> **Prefix Sum remembers the past. Sliding Window maintains the present range.**

---

# 44. Prefix Sum vs Two Pointer

Two Pointer often relies on:

```text
ordering / monotonic movement
```

Prefix Sum relies on:

```text
cumulative state
```

Example:

```text
[1,-2,3]
```

Two pointer may struggle with sum conditions.

Prefix sum works naturally.

So:

```text
Pair + sorted
→ Two Pointer

Subarray sum relationship
→ Prefix Sum
```

---

# 45. Prefix Sum vs HashMap

HashMap itself isn't the pattern.

The combination is:

```text
Prefix Sum
+
HashMap
```

The prefix gives us:

```text
current - previous
```

The HashMap gives us:

```text
Have I seen the required previous state?
```

So:

```text
Prefix Sum = transformation
HashMap = lookup
```

This is a very useful way to think about it.

---

# 46. Common Mistakes

## Mistake 1 — Off-by-One

Using:

```text
prefix[R] - prefix[L]
```

when your prefix definition actually requires:

```text
prefix[R+1] - prefix[L]
```

Avoid this by using:

```java
int[] prefix = new int[n + 1];
```

with:

```text
prefix[0] = 0
```

---

# 47. Mistake 2 — Forgetting Empty Prefix

For:

```text
subarray sum K
```

always consider:

```java
map.put(0, 1);
```

For longest:

```java
map.put(0, -1);
```

These represent:

```text
before the array starts
```

This single detail causes many wrong answers.

---

# 48. Mistake 3 — Storing the Wrong Occurrence

For:

### Count

Store every occurrence:

```text
prefix → frequency
```

For:

### Longest

Keep earliest:

```java
map.putIfAbsent(prefix, i);
```

Do **not** overwrite it.

Because:

```text
earlier index
→ longer subarray
```

---

# 49. Mistake 4 — Using Sliding Window With Negative Numbers

Example:

```text
[5,-10,8]
```

If the problem asks for an exact sum, don't automatically reach for sliding window.

Think:

```text
Prefix Sum + HashMap
```

---

# 50. Mistake 5 — Integer Overflow

Prefix sums can become larger than an `int`.

If:

```text
n = 100000
nums[i] = 100000
```

sum can reach:

```text
10^10
```

which exceeds:

```text
int ≈ 2.1 × 10^9
```

Use:

```java
long[] prefix;
```

or:

```java
Map<Long, Integer>
```

when necessary.

This is an important interview detail.

---

# 51. Mistake 6 — Forgetting the Difference Array Boundary

For:

```text
[L,R] += X
```

do:

```java
diff[L] += X;
```

and:

```java
if (R + 1 < n) {
    diff[R + 1] -= X;
}
```

Otherwise the update accidentally continues beyond `R`.

---

# 52. Mistake 7 — Thinking Prefix Sum Only Means Addition

The deeper pattern is:

```text
PREFIX STATE
```

Examples:

```text
sum
XOR
parity
frequency difference
balance
```

Once you understand this, many "prefix sum" problems become easier.

---

# 53. Complexity

### Basic Prefix Sum

Build:

```text
O(n)
```

Query:

```text
O(1)
```

### Prefix + HashMap

Usually:

```text
O(n)
```

with:

```text
O(n)
```

space.

### 2D Prefix

Build:

```text
O(rows × cols)
```

Query:

```text
O(1)
```

### Difference Array

Range update:

```text
O(1)
```

Final reconstruction:

```text
O(n)
```

This is why it is excellent when there are many range updates.

---

# 54. Level-Wise Problem Segregation

Now the preparation roadmap.

---

# 🟢 Level 1 — Basic Prefix Sum

Master the fundamental mechanics.

1. Running Sum of 1D Array
2. Range Sum Query — Immutable
3. Find Pivot Index
4. Left and Right Sum Differences
5. Find the Middle Index in Array
6. Sum of All Odd Length Subarrays
7. Range Sum Query 2D — Immutable

### Goal

Understand:

```text
prefix[i+1] = prefix[i] + nums[i]
```

and:

```text
range = prefix[R+1] - prefix[L]
```

---

# 🟡 Level 2 — Prefix Sum + HashMap

Extremely important.

1. Subarray Sum Equals K
2. Continuous Subarray Sum
3. Longest Subarray With Sum K
4. Subarray Sums Divisible by K
5. Zero Sum Subarray
6. Binary Subarrays With Sum
7. Count Number of Nice Subarrays

### Goal

Master:

```text
currentPrefix - target
```

and:

```text
prefix → frequency
```

---

# 🟠 Level 3 — Prefix State Transformation

Very important for product interviews.

1. Contiguous Array
2. Subarray Sums Divisible by K
3. Find the Longest Subarray With Equal 0s and 1s
4. Count Subarrays With Odd Sum
5. Equal Number of 0, 1, and 2
6. Make Sum Divisible by P
7. Longest Well-Performing Interval

The key skill:

> **Transform the original condition into a prefix-state condition.**

---

# 🔴 Level 4 — Difference Array / 2D Prefix

1. Corporate Flight Bookings
2. Range Addition
3. Car Pooling
4. Shifting Letters II
5. Range Sum Query 2D
6. Matrix Block Sum
7. Number of Ways to Paint N × 3 Grid variants
8. 2D difference-array problems

### Goal

Understand:

```text
Range updates
→ Difference Array

Range queries
→ Prefix Sum
```

---

# 🟣 Level 5 — Advanced Prefix

1. Shortest Subarray With Sum at Least K
2. Maximum Size Subarray Sum Equals k
3. Subarray Sum Closest
4. Maximum Subarray Min-Product
5. Sum of Subarray Minimums
6. Sum of Subarray Ranges
7. Prefix Sum + Monotonic Deque
8. Prefix Sum + Binary Search

These combine:

```text
Prefix
+
Deque
+
Stack
+
Binary Search
```

---

# ⚫ Level 6 — Advanced Prefix-State / FAANG

1. Equal Frequency State problems
2. Multi-dimensional prefix state
3. Prefix XOR + Trie
4. Prefix XOR + HashMap
5. Prefix Sum + Monotonic Queue
6. Prefix Sum + Coordinate Compression
7. 2D Difference Array
8. Advanced offline range queries

At this point, Prefix Sum is no longer a standalone technique.

It becomes a **state transformation tool**.

---

# 55. Must-Solve Prefix Sum Set

You don't need 100 problems.

I'd make these your core set:

```text
1. Running Sum of 1D Array
2. Range Sum Query — Immutable
3. Find Pivot Index
4. Subarray Sum Equals K
5. Continuous Subarray Sum
6. Contiguous Array
7. Subarray Sums Divisible by K
8. Binary Subarrays With Sum
9. Count Number of Nice Subarrays
10. Longest Well-Performing Interval
11. Corporate Flight Bookings
12. Car Pooling
13. Range Sum Query 2D
14. Shortest Subarray With Sum at Least K
15. Make Sum Divisible by P
```

If you can solve these and explain **why each one uses prefix state**, your Prefix Sum foundation is very strong.

---

# 56. Prefix Sum Pattern Map

```text
                         PREFIX
                           |
                ┌──────────┴───────────┐
                ↓                      ↓
             PREFIX SUM            PREFIX XOR
                |                      |
        ┌───────┼────────┐             |
        ↓       ↓        ↓             ↓
      Range   Subarray  State       XOR Range
      Query    Sum K     Problems
        |       |        |
        |       |        ├── Equal counts
        |       |        ├── Parity
        |       |        └── Balance
        |       |
        |       └── HashMap
        |
        ├── 2D Prefix
        |
        └── Difference Array

ADVANCED:
Prefix + Binary Search
Prefix + Monotonic Deque
Prefix + Stack
Prefix + Trie
```

---

# 57. The General Prefix-State Pattern

This is the most important concept to take away.

Suppose you have some cumulative state:

```text
S[0], S[1], S[2], ...
```

If a subarray property can be expressed using:

```text
S[j] - S[i]
```

or:

```text
S[j] ^ S[i]
```

or:

```text
S[j] == S[i]
```

then:

```text
PREFIX STATE
```

may be the right pattern.

Examples:

```text
Sum = K
→ S[j] - S[i] = K

Sum = 0
→ S[j] = S[i]

Equal 0/1
→ balance[j] = balance[i]

XOR = K
→ prefixXor[j] ^ prefixXor[i] = K

Equal A/B/C
→ state[j] = state[i]
```

This is much more powerful than simply memorizing "prefix sum."

---

# 58. The Prefix Sum Decision Tree

```text
                    CONTIGUOUS RANGE?
                           |
                         YES
                           |
                    Need cumulative
                       information?
                           |
              ┌────────────┴────────────┐
              ↓                         ↓
        Range queries              Subarray property
              |                         |
              ↓                         ↓
         Prefix Sum              Can express using
                                  prefix state?
                                      |
                              ┌───────┴────────┐
                              ↓                ↓
                             YES               NO
                              |                 |
                              ↓                 ↓
                       Prefix + Map       Other pattern
                              |
                  ┌───────────┼────────────┐
                  ↓           ↓            ↓
                Count       Longest      Exact state
                  |           |            |
             Frequency   Earliest idx   HashMap
```

---

# 59. Prefix Sum vs the Major Patterns

This is the pattern-recognition map you should keep with your DSA notes:

| Problem signal | Think |
|---|---|
| Pair + sorted | **Two Pointer** |
| Contiguous + variable window | **Sliding Window** |
| Range sum queries | **Prefix Sum** |
| Exact subarray sum K | **Prefix Sum + HashMap** |
| Negative numbers + subarray sum | **Prefix Sum** |
| Equal 0/1 | **Prefix State** |
| Range XOR | **Prefix XOR** |
| Many range updates | **Difference Array** |
| Matrix rectangle queries | **2D Prefix Sum** |
| Shortest subarray sum ≥ K with negatives | **Prefix + Monotonic Deque** |
| Next greater/smaller | **Monotonic Stack** |
| Top K | **Heap** |
| Repeated state | **DP** |

---

# 60. Final Prefix Sum Cheat Sheet

```text
=========================================================
                    PREFIX SUM
=========================================================

CORE IDEA
---------------------------------------------------------
Remember cumulative information so that a range/subarray
can be derived from two prefix states.


1D PREFIX
---------------------------------------------------------

prefix[0] = 0

prefix[i + 1]
=
prefix[i] + nums[i]


RANGE SUM
---------------------------------------------------------

sum(L...R)
=
prefix[R + 1] - prefix[L]


BASIC COMPLEXITY
---------------------------------------------------------

Build:
O(n)

Query:
O(1)


SUBARRAY SUM = K
---------------------------------------------------------

currentPrefix - previousPrefix = K

previousPrefix
=
currentPrefix - K

→ HashMap


COUNT
---------------------------------------------------------

Map:
prefix → frequency

Initialize:
map.put(0, 1)


LONGEST
---------------------------------------------------------

Map:
prefix → earliest index

Initialize:
map.put(0, -1)

Keep earliest occurrence.


PREFIX STATE
---------------------------------------------------------

Don't limit yourself to sum.

State can be:
sum
XOR
parity
balance
frequency differences
(countA-countB, countA-countC)


EQUAL 0 / 1
---------------------------------------------------------

0 → -1
1 → +1

Equal counts
→ sum = 0


PREFIX XOR
---------------------------------------------------------

prefix[i + 1]
=
prefix[i] ^ nums[i]

Range XOR:
prefix[R + 1] ^ prefix[L]


2D PREFIX
---------------------------------------------------------

prefix[i][j]
=
matrix[i-1][j-1]
+ prefix[i-1][j]
+ prefix[i][j-1]
- prefix[i-1][j-1]


DIFFERENCE ARRAY
---------------------------------------------------------

Range update [L,R] += X

diff[L] += X
diff[R+1] -= X

Then prefix-sum diff.


ADVANCED
---------------------------------------------------------

Prefix + Binary Search
Prefix + Monotonic Deque
Prefix + Stack
Prefix + Trie
Prefix + Coordinate Compression


RECOGNITION
---------------------------------------------------------

"range sum"
        → Prefix Sum

"many range queries"
        → Prefix Sum

"subarray sum K"
        → Prefix + HashMap

"zero sum"
        → Prefix + HashMap

"longest sum K"
        → Prefix + earliest index

"count sum K"
        → Prefix + frequency

"equal counts"
        → Prefix State + HashMap

"range XOR"
        → Prefix XOR

"matrix rectangle sum"
        → 2D Prefix

"many range updates"
        → Difference Array

"negative numbers + shortest sum ≥ K"
        → Prefix + Monotonic Deque
=========================================================
```

---

# 61. The Golden Rule

When you see an unfamiliar problem, don't immediately think:

> "This is a Prefix Sum problem."

Instead ask:

```text
Is the problem about a CONTIGUOUS range?
             ↓
Can I represent the information
up to position i as a STATE?
             ↓
Can the answer between i and j
be expressed using those two states?
             ↓
YES
             ↓
PREFIX STATE
```

Then determine what the state is:

```text
sum?
    → Prefix Sum

XOR?
    → Prefix XOR

parity?
    → Prefix parity

equal counts?
    → balance state

multiple equal frequencies?
    → state tuple

matrix region?
    → 2D Prefix

range updates?
    → Difference Array
```

And the **highest-value transformation to remember** is:

> **Subarray problem → prefix state → relation between two prefix states → HashMap lookup.**

That one idea is responsible for a surprisingly large percentage of the harder Prefix Sum interview problems.