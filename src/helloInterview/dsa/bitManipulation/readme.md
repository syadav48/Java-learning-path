Absolutely. **Bit Manipulation deserves its own deep-dive**. It looks like a collection of weird tricks at first, but for interviews it is actually a relatively small set of reusable patterns.

I’ll keep the same structure: **mental model → operators → core patterns → recognition → templates → questions by level → mistakes → usage → Bit Manipulation vs other patterns → cheat sheet.**

---

# Bit Manipulation — Complete Interview Deep Dive

## 1. What is Bit Manipulation?

Every integer is stored internally as bits:

```text
5  = 0101
3  = 0011
```

Bit manipulation means operating directly on those binary bits.

The main operators are:

```text
&   AND
|   OR
^   XOR
~   NOT
<<  left shift
>>  right shift
>>> unsigned right shift
```

You don't need to think of this as "binary mathematics."

Think:

> **I have a collection of 0/1 switches, and I want to inspect, toggle, set, clear, or combine them efficiently.**

---

# 2. The Operators You MUST Know

Take:

```text
a = 5  = 0101
b = 3  = 0011
```

## AND `&`

```text
  0101
& 0011
------
  0001
```

```java
5 & 3 = 1
```

### Mental model

> AND asks: **Are both bits ON?**

```text
1 & 1 = 1
everything else = 0
```

### Main use

**Check whether a particular bit is set.**

---

# 3. OR `|`

```text
  0101
| 0011
------
  0111
```

```java
5 | 3 = 7
```

Mental model:

> **Turn ON a bit if either side has it ON.**

Main use:

* Set bits
* Combine bit masks
* Permission flags

---

# 4. XOR `^`

```text
  0101
^ 0011
------
  0110
```

```java
5 ^ 3 = 6
```

XOR:

```text
0 ^ 0 = 0
0 ^ 1 = 1
1 ^ 0 = 1
1 ^ 1 = 0
```

Mental model:

> **Different → 1, same → 0.**

This is probably the **most important operator in DSA**.

---

# 5. NOT `~`

```text
~0101
```

It flips every bit.

```text
0 → 1
1 → 0
```

Java integers are 32-bit signed integers, so:

```java
~5
```

is not simply `2`.

It's:

```text
5  = 00000000 00000000 00000000 00000101

~5 = 11111111 11111111 11111111 11111010
```

which is:

```text
-6
```

Important identity:

```text
~x = -x - 1
```

---

# 6. Left Shift `<<`

```text
5 = 0101

5 << 1

1010 = 10
```

Generally:

```text
x << k
```

means:

```text
x * 2^k
```

when no overflow is involved.

Example:

```java
5 << 2
```

```text
5 × 4 = 20
```

---

# 7. Right Shift `>>`

```text
20 = 10100

20 >> 2

00101 = 5
```

Approximately:

```text
x / 2^k
```

for positive integers.

But Java's `>>` is **signed right shift**.

It preserves the sign bit.

---

# 8. Unsigned Right Shift `>>>`

```java
x >>> k
```

fills the left side with:

```text
0
```

rather than preserving the sign bit.

This matters mostly with:

* negative numbers
* low-level Java code
* hashing
* integer bit operations

For most DSA problems, `>>` is sufficient.

---

# 9. The First Big Mental Model

Think of an integer as:

```text
bit 31 ... bit 5 bit 4 bit 3 bit 2 bit 1 bit 0
```

For example:

```text
13 = 1101

bit 3 = 1
bit 2 = 1
bit 1 = 0
bit 0 = 1
```

Most bit manipulation problems are asking you to do one of these:

```text
CHECK
SET
CLEAR
TOGGLE
COUNT
ISOLATE
SHIFT
MASK
XOR
```

This is the core of the entire topic.

---

# 10. Pattern 1 — Check if a Bit is Set

Suppose we want to check bit `k`.

Use:

```java
(num & (1 << k)) != 0
```

Example:

```text
num = 13
```

```text
13 = 1101
```

Check bit 2:

```text
1 << 2

0100
```

Then:

```text
1101
0100
----
0100
```

Non-zero → bit is set.

---

## Template

```java
boolean isSet = (num & (1 << k)) != 0;
```

### Recognition

If the problem says:

> Check whether kth bit is set.

Immediately think:

```text
num & (1 << k)
```

---

# 11. Pattern 2 — Set a Bit

Turn bit `k` ON.

```java
num = num | (1 << k);
```

Example:

```text
num = 8

1000
```

Set bit 1:

```text
1000
0010
----
1010
```

Result:

```text
10
```

Template:

```java
num |= (1 << k);
```

---

# 12. Pattern 3 — Clear a Bit

Turn bit `k` OFF.

Use:

```java
num & ~(1 << k)
```

Example:

```text
num = 15

1111
```

Clear bit 2:

```text
1 << 2 = 0100

~0100 = 1011
```

Then:

```text
1111
1011
----
1011
```

Result:

```text
11
```

Template:

```java
num &= ~(1 << k);
```

---

# 13. Pattern 4 — Toggle a Bit

Use XOR.

```java
num ^= (1 << k);
```

Because:

```text
0 ^ 1 = 1
1 ^ 1 = 0
```

So XOR with `1` flips the bit.

This is a very important mental model:

> **XOR is the toggle operation.**

---

# 14. Pattern 5 — Check Odd / Even

One of the simplest and most useful bit tricks.

```java
if ((n & 1) == 0)
    // even
else
    // odd
```

Why?

The least significant bit determines parity.

```text
2 = 10 → last bit 0
4 = 100 → last bit 0
6 = 110 → last bit 0
```

Odd:

```text
1 = 001
3 = 011
5 = 101
7 = 111
```

last bit = `1`.

---

# 15. Pattern 6 — Remove the Lowest Set Bit

This is one of the **most important bit tricks**.

```java
n = n & (n - 1);
```

Example:

```text
n = 12

1100
```

`n - 1`:

```text
1011
```

AND:

```text
1100
1011
----
1000
```

The lowest `1` disappeared.

Therefore:

```text
n & (n - 1)
```

means:

> **Remove the lowest set bit.**

---

# 16. Why is This So Important?

It gives the classic:

## Count Number of Set Bits

```java
int count = 0;

while (n != 0) {
    n = n & (n - 1);
    count++;
}
```

If:

```text
n = 13

1101
```

Iterations:

```text
1101
1100
1000
0000
```

There are:

```text
3
```

set bits.

Complexity:

```text
O(number of set bits)
```

rather than always O(32).

---

# 17. Pattern 7 — Isolate Lowest Set Bit

Use:

```java
n & -n
```

Example:

```text
n = 12

1100
```

`-12` in two's complement:

```text
0100
```

Then:

```text
1100
0100
----
0100
```

Result:

```text
4
```

So:

```java
n & -n
```

gives:

> **the value of the lowest set bit.**

This is extremely important for:

* Fenwick Tree
* subset/bitmask algorithms
* certain XOR problems
* low-level bit tricks

---

# 18. Pattern 8 — Power of Two

A positive number is a power of two iff it contains exactly one set bit.

Examples:

```text
1  = 0001
2  = 0010
4  = 0100
8  = 1000
16 = 10000
```

So:

```java
n > 0 && (n & (n - 1)) == 0
```

Example:

```text
8

1000
0111
----
0000
```

But:

```text
10

1010
1001
----
1000
```

not zero.

Therefore:

```java
boolean isPowerOfTwo =
        n > 0 && (n & (n - 1)) == 0;
```

---

# 19. Pattern 9 — XOR Cancellation

This is where many famous interview questions come from.

Important XOR properties:

```text
x ^ x = 0

x ^ 0 = x

x ^ y = y ^ x

(a ^ b) ^ c
=
a ^ (b ^ c)
```

Therefore:

```text
1 ^ 2 ^ 3 ^ 2 ^ 1
```

becomes:

```text
(1^1) ^ (2^2) ^ 3
```

```text
0 ^ 0 ^ 3
```

```text
3
```

Everything appearing twice disappears.

---

# 20. Classic Problem — Single Number

Given:

```text
[4,1,2,1,2]
```

Every number occurs twice except one.

Solution:

```java
int result = 0;

for (int num : nums) {
    result ^= num;
}

return result;
```

Because:

```text
4 ^ 1 ^ 2 ^ 1 ^ 2

1^1 = 0
2^2 = 0

result = 4
```

Complexity:

```text
O(n)
O(1)
```

This is one of the most important XOR patterns.

---

# 21. Pattern 10 — Missing Number

Given:

```text
[3,0,1]
```

Numbers should be:

```text
0,1,2,3
```

Missing:

```text
2
```

XOR:

```java
int result = nums.length;

for (int i = 0; i < nums.length; i++) {
    result ^= i;
    result ^= nums[i];
}

return result;
```

Everything cancels except missing number.

---

# 22. Pattern 11 — Find Two Unique Numbers

Suppose:

```text
[1,2,1,3,2,5]
```

Unique:

```text
3,5
```

First XOR everything:

```text
xor = 3 ^ 5
```

Since:

```text
3 ^ 5 != 0
```

there must be at least one bit where they differ.

Find a distinguishing bit:

```java
int diff = xor & -xor;
```

This isolates the lowest set bit.

Then divide numbers into two groups:

```text
bit = 0
bit = 1
```

XOR each group.

You get:

```text
3
5
```

This is an important **advanced XOR pattern**.

---

# 23. Pattern 12 — Bitmask as a Set

This is where bit manipulation becomes much more powerful.

Suppose we have:

```text
{A, B, C, D}
```

Represent membership using bits:

```text
A → bit 0
B → bit 1
C → bit 2
D → bit 3
```

Suppose:

```text
1011
```

means:

```text
A ✓
B ✓
C ✗
D ✓
```

So one integer represents a set.

This is called a:

> **Bitmask**

---

# 24. Bitmask Operations

### Add element

```java
mask |= (1 << k);
```

### Remove element

```java
mask &= ~(1 << k);
```

### Check membership

```java
(mask & (1 << k)) != 0
```

### Toggle membership

```java
mask ^= (1 << k);
```

This is the foundation of many advanced problems.

---

# 25. Pattern 13 — Enumerate All Subsets

For:

```text
[n = 3]
```

there are:

```text
2^3 = 8
```

subsets.

Represent each subset by:

```text
000
001
010
011
100
101
110
111
```

Template:

```java
int n = nums.length;

for (int mask = 0; mask < (1 << n); mask++) {

    for (int i = 0; i < n; i++) {

        if ((mask & (1 << i)) != 0) {
            // nums[i] is selected
        }
    }
}
```

Complexity:

```text
O(n * 2^n)
```

This is a major pattern.

---

# 26. Bitmask vs Backtracking

Both can generate subsets.

### Backtracking

```text
Choose
Explore
Undo
```

Complexity:

```text
O(n * 2^n)
```

### Bitmask

```text
000
001
010
011
...
111
```

Also:

```text
O(n * 2^n)
```

When `n` is small, both are valid.

But bitmask is especially useful when:

> **The state itself needs to represent which elements have already been selected.**

---

# 27. Pattern 14 — Subsets of a Mask

Advanced but important.

Suppose:

```text
mask = 10110
```

We want all submasks.

Classic technique:

```java
for (int sub = mask; sub > 0; sub = (sub - 1) & mask) {
    // sub is a submask
}
```

This is an advanced competitive-programming pattern.

You'll see it in:

* subset DP
* bitmask DP
* partition problems
* optimization over subsets

---

# 28. Pattern 15 — Bitmask DP

This is where Bit Manipulation and DP meet.

Suppose you have:

```text
n <= 20
```

and need to track:

> Which elements have already been used?

Instead of:

```text
boolean[] used
```

you can use:

```text
mask
```

Example:

```text
mask = 10101
```

means:

```text
elements 0,2,4 are used
```

State:

```text
dp[mask]
```

or:

```text
dp[mask][last]
```

This appears in:

* Traveling Salesman Problem
* Assignment problems
* minimum cost permutation
* Hamiltonian path
* subset optimization

---

# 29. Pattern 16 — XOR for Missing / Duplicate Information

A whole family of problems revolves around cancellation.

Whenever you see:

> Every element occurs twice except one

Think:

```text
XOR
```

Whenever you see:

> Find missing number from 0...n

Think:

```text
XOR
```

Whenever you see:

> Exactly two elements appear once, others twice

Think:

```text
XOR + split by distinguishing bit
```

This recognition is extremely important.

---

# 30. Pattern 17 — XOR and Prefix XOR

Just like prefix sum:

```text
prefix[i] = nums[0] ^ nums[1] ^ ... ^ nums[i]
```

Then XOR of a range:

```text
L ... R
```

can be calculated using:

```text
prefix[R] ^ prefix[L-1]
```

because the earlier elements cancel.

Example:

```text
A ^ B ^ C ^ D ^ E
```

If:

```text
prefix[4] = A^B^C^D^E
prefix[1] = A^B
```

then:

```text
prefix[4] ^ prefix[1]
```

gives:

```text
C ^ D ^ E
```

This is the XOR equivalent of prefix sum.

---

# 31. Pattern 18 — XOR Swap

You may see:

```java
a ^= b;
b ^= a;
a ^= b;
```

This swaps values without a temporary variable.

But in modern Java:

> **Don't use this in interviews unless specifically discussing the trick.**

A normal temp variable is clearer.

```java
int temp = a;
a = b;
b = temp;
```

The important thing is knowing XOR properties, not showing off the trick.

---

# 32. Pattern 19 — Gray Code

Gray Code is another classic bit problem.

The formula:

```java
gray = n ^ (n >> 1);
```

For example:

```text
n = 3

3     = 011
3>>1  = 001

011 ^ 001
-------
010
```

Gray code:

```text
2
```

This appears in:

* encoding
* state transitions
* bit manipulation problems

Usually Level 4/5.

---

# 33. Pattern 20 — Power of Two / Four

Power of two:

```java
n > 0 && (n & (n - 1)) == 0
```

Power of four requires additional checking.

For example:

```text
1
4
16
64
```

One approach:

```java
n > 0
&& (n & (n - 1)) == 0
&& (n & 0x55555555) != 0
```

The mask ensures the single set bit is at an even position.

You don't need to memorize this immediately.

Understand:

```text
Power of 2
→ exactly one set bit
```

Then derive the extra constraint.

---

# 34. Pattern 21 — Extracting a Bit Range

Sometimes a problem asks:

> Get bits from position `L` to `R`.

Create a mask.

Conceptually:

```text
00011111000
```

Then:

```java
num & mask
```

This is more common in advanced bit manipulation/system-level questions than normal LeetCode interviews.

---

# 35. Pattern 22 — Turn Off Rightmost Set Bit

Already seen:

```java
n & (n - 1)
```

This deserves its own cheat-sheet entry.

```text
n & (n - 1)
```

means:

> **remove the lowest/rightmost 1-bit.**

Applications:

* count set bits
* power of two
* Fenwick Tree
* subset tricks

---

# 36. Pattern 23 — Get Rightmost Set Bit

```java
n & -n
```

means:

> **isolate the lowest/rightmost 1-bit.**

Applications:

* Fenwick Tree
* split XOR groups
* bitmask algorithms

Memorize this pair:

```text
n & (n - 1)
→ remove lowest 1

n & -n
→ isolate lowest 1
```

---

# 37. Pattern 24 — Count Bits from 0 to N

Classic problem:

> Count number of 1 bits for every number from `0` to `n`.

DP + Bit Manipulation:

```java
int[] bits = new int[n + 1];

for (int i = 1; i <= n; i++) {
    bits[i] = bits[i >> 1] + (i & 1);
}
```

Because:

```text
i >> 1
```

removes the last bit.

And:

```text
i & 1
```

tells whether that last bit was `1`.

Alternative:

```java
bits[i] = bits[i & (i - 1)] + 1;
```

This uses the lowest-set-bit trick.

---

# 38. Pattern 25 — AND/OR Across Ranges

There are interesting properties of bitwise AND/OR.

For example, if a range is:

```text
[5,7]
```

```text
5 = 101
6 = 110
7 = 111
```

AND:

```text
101
110
111
---
100
```

Range AND often asks:

> Which high-order bits remain unchanged across the whole range?

This leads to the common technique of repeatedly shifting both numbers right until they become equal.

Example:

```java
int rangeBitwiseAnd(int left, int right) {

    int shifts = 0;

    while (left < right) {
        left >>= 1;
        right >>= 1;
        shifts++;
    }

    return left << shifts;
}
```

This is a good Level 4 problem.

---

# 39. Pattern 26 — Maximum XOR

Another major interview family.

Problem:

> Find maximum XOR of two numbers.

Brute force:

```text
O(n²)
```

Advanced solution:

> Build the answer bit-by-bit using a binary Trie.

The idea is:

```text
For each bit from MSB → LSB:
    try to choose opposite bit
```

Why?

Because:

```text
0 ^ 1 = 1
1 ^ 0 = 1
```

So to maximize XOR, you want opposite bits starting from the most significant bit.

This connects:

```text
Bit Manipulation
+
Trie
+
Greedy
```

Very important advanced pattern.

---

# 40. Bit Manipulation + Greedy

Maximum XOR is a great example.

At each bit:

```text
Can I make this bit 1?
```

Try it.

If possible, keep it.

This is:

```text
Greedy bit-by-bit
```

rather than traditional greedy on array elements.

---

# 41. Bit Manipulation + DP

Major intersection:

```text
Bitmask DP
```

Typical constraint:

```text
n <= 20
```

Why?

Because:

```text
2^20 ≈ 1 million
```

is still manageable.

But:

```text
2^50
```

is impossible.

So whenever you see:

```text
n <= 20
+
choose/order/subset
```

think:

```text
Bitmask DP
```

---

# 42. Bit Manipulation + Trie

Look for:

```text
maximum XOR
minimum XOR
XOR pair
```

Potentially:

```text
Binary Trie
```

because a Trie lets you greedily choose the opposite bit.

---

# 43. Bit Manipulation + Math

Some problems combine:

```text
binary representation
+
mathematical properties
```

Examples:

* Power of two
* Power of four
* Number of set bits
* Reverse bits
* Integer replacement
* Divide integers using shifts
* Add without `+`

---

# 44. Add Two Numbers Without `+`

Classic bit problem.

XOR gives addition without carry:

```text
a ^ b
```

AND gives carry:

```text
(a & b) << 1
```

Therefore:

```java
while (b != 0) {

    int carry = (a & b) << 1;

    a = a ^ b;
    b = carry;
}

return a;
```

Mental model:

```text
XOR → sum without carry
AND + shift → carry
```

This is one of the best problems for understanding why XOR exists.

---

# 45. Subtraction / Two's Complement

Negative numbers use two's complement.

For `x`:

```text
-x = ~x + 1
```

Therefore:

```text
-x
```

can be understood as:

```text
invert bits
+
1
```

This explains:

```java
n & -n
```

and many low-level tricks.

You don't need to manually calculate two's complement every time, but you should understand the principle.

---

# 46. Reverse Bits

Given:

```text
00000010100101000001111010011100
```

reverse all 32 bits.

Pattern:

```java
int result = 0;

for (int i = 0; i < 32; i++) {

    result <<= 1;

    result |= (n & 1);

    n >>>= 1;
}
```

Notice:

```text
n & 1
```

extracts the lowest bit.

Then:

```text
result <<= 1
```

makes room for it.

---

# 47. Bit Manipulation Recognition Flowchart

This is the one I'd memorize.

```text
                    BIT PROBLEM
                         |
             ┌───────────┼────────────┐
             ↓           ↓            ↓
          XOR clues    Bit position   Binary state
             |             |             |
             |             |             |
        duplicates       check bit     subset
        missing          set bit       selection
        unique           clear bit     used elements
        two uniques      toggle        state compression
             |             |             |
             ↓             ↓             ↓
            XOR         MASKING       BITMASK
```

Another:

```text
Number problem
     |
     +-- odd/even?
     |      → n & 1
     |
     +-- kth bit?
     |      → 1 << k
     |
     +-- set bit?
     |      → |
     |
     +-- clear bit?
     |      → & ~
     |
     +-- toggle?
     |      → ^
     |
     +-- count 1s?
     |      → n & (n-1)
     |
     +-- power of 2?
     |      → n & (n-1)
     |
     +-- unique / missing?
     |      → XOR
     |
     +-- subset state?
     |      → bitmask
     |
     +-- n <= 20 + subset/order?
     |      → bitmask DP
     |
     +-- maximum XOR?
            → binary Trie
```

---

# 48. Question Recognition Cheat Sheet

| Problem clue        | Pattern            |
| ------------------- | ------------------ |
| Odd/even            | `n & 1`            |
| Check kth bit       | `n & (1 << k)`     |
| Set kth bit         | `n \| (1 << k)`    |
| Clear kth bit       | `n & ~(1 << k)`    |
| Toggle kth bit      | `n ^ (1 << k)`     |
| Count set bits      | `n & (n-1)`        |
| Power of 2          | `n & (n-1)`        |
| Lowest set bit      | `n & -n`           |
| One unique number   | XOR                |
| Missing number      | XOR                |
| Two unique numbers  | XOR + split        |
| Generate subsets    | Bitmask            |
| Set membership      | Bitmask            |
| Subset DP           | Bitmask DP         |
| `n <= 20` + subsets | Bitmask DP         |
| Maximum XOR         | Binary Trie        |
| Reverse bits        | Shift + mask       |
| Add without `+`     | XOR + carry        |
| Range XOR           | Prefix XOR         |
| Range AND           | Common prefix bits |
| Gray code           | `n ^ (n >> 1)`     |

---

# 49. Level-Wise Problem Segregation

Now let's make your actual preparation roadmap.

---

# 🟢 Level 1 — Bit Fundamentals

These should become automatic.

### Problems

1. Number of 1 Bits
2. Power of Two
3. Missing Number
4. Single Number
5. Binary Number with Alternating Bits
6. Counting Bits
7. Reverse Bits
8. Number Complement
9. Hamming Distance
10. Hamming Weight

### Goal

You should automatically know:

```text
&   → check
|   → set
^   → toggle/cancel
~   → invert
<<  → shift left
>>  → shift right
```

And:

```text
n & 1
n & (n-1)
n & -n
```

---

# 🟡 Level 2 — Core Interview

### Problems

1. Single Number
2. Single Number II
3. Missing Number
4. Hamming Distance
5. Counting Bits
6. Reverse Bits
7. Power of Two
8. Power of Four
9. Number Complement
10. Sum of Two Integers
11. Binary Watch
12. Subsets

### Goal

Recognize:

```text
XOR
mask
shift
```

without hesitation.

---

# 🟠 Level 3 — XOR Patterns

This deserves its own category.

1. Single Number
2. Single Number II
3. Single Number III
4. Missing Number
5. Find the Difference
6. Hamming Distance
7. Total Hamming Distance
8. XOR Queries of a Subarray
9. Decode XORed Array
10. Find XOR of All Numbers
11. Maximum XOR of Two Numbers in an Array

Focus on understanding:

```text
x ^ x = 0
x ^ 0 = x
```

rather than memorizing solutions.

---

# 🔴 Level 4 — Bitmask

Now the topic becomes more advanced.

1. Subsets
2. Letter Case Permutation
3. Find the Maximum XOR
4. Maximum Product of Word Lengths
5. Smallest Sufficient Team
6. Partition to K Equal Sum Subsets
7. Matchsticks to Square
8. Maximum Compatibility Score Sum
9. Can I Win
10. Minimum XOR Sum of Two Arrays

Here you'll start seeing:

```text
mask
```

as a **state** rather than merely a bit trick.

---

# 🟣 Level 5 — Bitmask DP / Advanced

These are much more relevant for strong FAANG/competitive interviews.

1. Traveling Salesman Problem
2. Shortest Hamiltonian Path
3. Assignment Problem using bitmask
4. Minimum XOR Sum of Two Arrays
5. Smallest Sufficient Team
6. Partition problems using masks
7. Subset DP
8. SOS DP
9. Submask enumeration
10. Advanced state-compression DP

Key state:

```text
dp[mask]
```

or:

```text
dp[mask][last]
```

---

# ⚫ Level 6 — Advanced Bit Tricks

Not necessary for every interview, but useful for very strong preparation.

* Maximum XOR with Binary Trie
* Range Bitwise AND
* Gray Code
* Divide using bit operations
* Integer replacement
* Bitwise AND/OR properties
* Submask enumeration
* Fenwick Tree's `i & -i`
* XOR basis / linear basis
* Bitset optimization
* SOS DP

Don't prioritize these before mastering Levels 1–4.

---

# 50. Most Important Questions to Actually Solve

If your goal is **product-based interview preparation**, I'd prioritize these:

### Must Solve

```text
1. Single Number
2. Missing Number
3. Number of 1 Bits
4. Counting Bits
5. Power of Two
6. Reverse Bits
7. Hamming Distance
8. Subsets
9. Single Number III
10. Sum of Two Integers
11. Maximum XOR of Two Numbers
12. Range Bitwise AND
```

### Then

```text
13. Single Number II
14. Power of Four
15. XOR Queries of a Subarray
16. Letter Case Permutation
17. Maximum Product of Word Lengths
18. Smallest Sufficient Team
19. Minimum XOR Sum
20. Can I Win
```

### Advanced

```text
21. TSP / Bitmask DP
22. Shortest Hamiltonian Path
23. Submask DP
24. SOS DP
25. XOR Basis
```

---

# 51. Common Mistakes

## Mistake 1 — Forgetting Java is signed

Java `int`:

```text
32 bits
```

with one sign bit.

So:

```java
~5
```

is:

```text
-6
```

not `something like 2`.

---

## Mistake 2 — Using `>>` when `>>>` is required

For positive numbers:

```text
>> and >>> 
```

often appear identical.

For negative numbers:

```text
>>  → preserves sign
>>> → fills with 0
```

---

## Mistake 3 — Integer overflow with shifts

This:

```java
1 << 31
```

is negative because Java `int` has 32 bits.

If you need unsigned-style larger masks, consider:

```java
1L << k
```

with `long`.

---

## Mistake 4 — Forgetting parentheses

Prefer:

```java
if ((n & (1 << k)) != 0)
```

rather than relying on operator precedence.

Bit expressions can become very difficult to read.

---

## Mistake 5 — Confusing bit position and bit value

If:

```text
k = 3
```

then:

```java
1 << k
```

is:

```text
1000
```

The **position** is 3.

The **value** is 8.

---

# 52. Mistake — Using XOR for Everything

XOR is powerful but not magic.

For example:

```text
[2,2,3,3,4,4,5]
```

Single Number works.

But if numbers appear:

```text
3 times
```

plain XOR isn't enough.

That's why:

```text
Single Number II
```

needs a different technique.

So always inspect the frequency structure.

---

# 53. Mistake — Ignoring Constraints

Bitmask DP is powerful because:

```text
n <= 20
```

But if:

```text
n = 100
```

you cannot blindly do:

```text
2^n
```

Always check constraints.

---

# 54. Bit Manipulation vs Other Patterns

This is important for your DSA pattern recognition.

| Problem signal          | Think           |
| ----------------------- | --------------- |
| Pair in sorted array    | Two Pointer     |
| Duplicate cancellation  | XOR             |
| Odd/even                | Bit             |
| kth bit                 | Bit             |
| Subset state            | Bitmask         |
| `n <= 20`, subset/order | Bitmask DP      |
| Repeated subproblem     | DP              |
| Contiguous range        | Sliding Window  |
| Prefix XOR query        | Prefix XOR      |
| Maximum XOR             | Binary Trie     |
| Connectivity            | DSU             |
| Next greater element    | Monotonic Stack |

---

# 55. Bit Manipulation + Data Structures

Bit manipulation doesn't exist in isolation.

It frequently combines with other topics:

```text
Bit
 ├── DP
 │    └── Bitmask DP
 │
 ├── Trie
 │    └── Maximum XOR
 │
 ├── Prefix
 │    └── Prefix XOR
 │
 ├── Fenwick Tree
 │    └── i & -i
 │
 ├── Greedy
 │    └── Maximum XOR
 │
 └── Backtracking
      └── subset representation
```

This is why learning the fundamentals is valuable even if you don't solve hundreds of pure bit problems.

---

# 56. Your Bit Manipulation Master Cheat Sheet

```text
================================================
              BIT MANIPULATION
================================================

OPERATORS
------------------------------------------------
&      AND
|      OR
^      XOR
~      NOT
<<     left shift
>>     signed right shift
>>>    unsigned right shift


BASIC OPERATIONS
------------------------------------------------

Check kth bit:
(num & (1 << k)) != 0

Set kth bit:
num | (1 << k)

Clear kth bit:
num & ~(1 << k)

Toggle kth bit:
num ^ (1 << k)


COMMON TRICKS
------------------------------------------------

Odd:
n & 1

Remove lowest set bit:
n & (n - 1)

Isolate lowest set bit:
n & -n

Power of 2:
n > 0 && (n & (n - 1)) == 0


XOR
------------------------------------------------

x ^ x = 0
x ^ 0 = x
x ^ y = y ^ x

Unique element:
XOR all elements

Missing number:
XOR indices + values

Two unique:
XOR → isolate differing bit → split


BITMASK
------------------------------------------------

Check membership:
mask & (1 << k)

Add:
mask | (1 << k)

Remove:
mask & ~(1 << k)

Toggle:
mask ^ (1 << k)


SUBSETS
------------------------------------------------

for mask = 0 ... (1 << n)

    if (mask & (1 << i)) != 0
        element i selected


BITMASK DP
------------------------------------------------

dp[mask]
dp[mask][last]

Use when:
n is small (~20)
+
subset/order state


ADVANCED
------------------------------------------------

Maximum XOR → Binary Trie

Range XOR → Prefix XOR

Range AND → Common prefix

Gray Code → n ^ (n >> 1)

Submasks:
sub = (sub - 1) & mask

Lowest set bit:
n & -n
================================================
```

---

# 57. The Most Important Mental Model

You don't need to become a "bit trick memorizer."

Think of the topic as **four layers**:

```text
                BIT MANIPULATION
                       |
       ┌───────────────┼────────────────┐
       ↓               ↓                ↓
   BASIC BITS        XOR             BITMASK
       |               |                |
 check/set/clear   cancellation     subsets
 toggle/shift      unique/missing    state
       |               |                |
       └───────────────┼────────────────┘
                       ↓
                ADVANCED COMBINATIONS
                       |
              ┌────────┼─────────┐
              ↓        ↓         ↓
           Trie       DP       Prefix
        Maximum XOR  Bitmask     XOR
```

And the **highest-value recognition rules** are:

```text
"odd/even"                 → n & 1

"kth bit"                  → 1 << k

"set/clear/toggle"         → OR / AND / XOR

"every number twice..."    → XOR

"missing number"           → XOR

"count 1 bits"             → n & (n-1)

"power of 2"               → n & (n-1)

"lowest set bit"           → n & -n

"subsets / selected items" → Bitmask

"n <= 20 + subset state"   → Bitmask DP

"maximum XOR"              → Binary Trie
```

If you get these **11 recognition signals** automatic, you've covered the vast majority of the bit-manipulation patterns that matter for normal product-company DSA interviews.
