Yes. **Dynamic Programming is the next major jump** because unlike Linked List/Tree/Graph, DP is less about a particular data structure and more about recognizing **repeated states + optimal decisions**.

For FAANG/product interviews, I would not learn DP as “solve 50 DP problems.” I would learn it as a collection of **state-design patterns**.

The most important skill is:

> **Given a problem, can I identify what a state means, what decisions lead to that state, and whether previous states can be reused?**

---

# 1. First: What is Dynamic Programming?

At its core:

```text
DP = Recursion
   + Repeated subproblems
   + Memoization / Tabulation
```

Consider Fibonacci:

```text
F(5)

       F(5)
      /    \
   F(4)    F(3)
   /  \    /  \
 F(3) F(2) F(2) F(1)
```

Notice:

```text
F(3)
```

is calculated multiple times.

DP says:

> Calculate it once, remember it, reuse it.

---

# 2. But this definition is NOT enough for interviews

The better mental model is:

```text
                    DP
                     │
          ┌──────────┴──────────┐
          │                     │
     Overlapping             Optimal
     subproblems             substructure
          │                     │
     same state appears      answer depends
     repeatedly              on smaller states
          │                     │
          └──────────┬──────────┘
                     ↓
               STORE RESULT
```

For most interview problems, you should ask:

```text
1. What is my STATE?
2. What are my CHOICES?
3. What is my TRANSITION?
4. What is my BASE CASE?
5. What is my ANSWER?
```

This is the DP equivalent of:

```text
Backtracking:
STATE → CHOICES → CONSTRAINT → UNDO
```

---

# 3. The most important DP recognition signal

When you see:

> **"What is the maximum/minimum/number of ways/possible or impossible..."**

don't automatically think DP.

But then ask:

> **Can I break the problem into smaller versions of the same problem?**

For example:

```text
How many ways to reach step n?
```

To reach `n`, your last move was either:

```text
n-1 → n
```

or:

```text
n-2 → n
```

Therefore:

```text
ways[n] =
    ways[n-1]
  + ways[n-2]
```

That's DP.

---

# 4. The DP universe

For interviews, I would organize DP like this:

```text
                         DYNAMIC PROGRAMMING
                                  │
        ┌─────────────────────────┼─────────────────────────┐
        │                         │                         │
     1D DP                    2D DP                    Knapsack
        │                         │                         │
   Fibonacci                 Grid DP                  0/1 Knapsack
   Climbing Stairs            Paths                   Unbounded
   House Robber               LCS                     Subset Sum
   Decode Ways                Edit Distance            Partition
        │                         │
        └─────────────┐           │
                      │           │
                   Sequence      │
                      DP         │
                      │          │
               LIS / LCS         │
               Stock DP          │
               String DP        │
                      │          │
          ┌───────────┴──────────┘
          │
       Interval DP
          │
    Matrix Chain
    Burst Balloons
    Palindrome
          │
       State DP
          │
    Bitmask DP
    Digit DP
    Tree DP
    DAG DP
```

And then there are important optimization techniques:

```text
Memoization
Tabulation
Space Optimization
State Compression
Monotonic Queue / Heap optimization
Bitmask
```

---

# 5. Pattern 1 — Linear / 1D DP

This is where you should start.

Classic examples:

* Climbing Stairs
* Fibonacci
* House Robber
* Min Cost Climbing Stairs
* Decode Ways
* Maximum Subarray
* Jump Game variants

---

# 6. Climbing Stairs

Question:

> You can climb 1 or 2 steps. How many ways to reach step n?

For step `n`:

```text
last move = 1 step
OR
last move = 2 steps
```

Therefore:

```text
dp[n] = dp[n-1] + dp[n-2]
```

Java:

```java
public int climbStairs(int n) {

    if (n <= 2) {
        return n;
    }

    int prev2 = 1;
    int prev1 = 2;

    for (int i = 3; i <= n; i++) {

        int curr = prev1 + prev2;

        prev2 = prev1;
        prev1 = curr;
    }

    return prev1;
}
```

Notice something important:

We don't actually need the whole array.

Only:

```text
dp[i-1]
dp[i-2]
```

So:

```text
O(n) time
O(1) space
```

This is called:

# Space Optimization

---

# 7. Recognition pattern: "Last move"

One of the strongest DP tricks is:

> **Think about the last decision.**

For climbing stairs:

```text
             step n
             /   \
          n-1     n-2
```

For many DP problems:

```text
Answer(n)
    ↓
What could the LAST decision have been?
    ↓
Answer of smaller state
```

This technique becomes incredibly powerful.

---

# 8. Pattern 2 — Take / Skip DP

One of the most important patterns.

Suppose:

```text
House Robber
```

Houses:

```text
[2, 7, 9, 3, 1]
```

You cannot rob adjacent houses.

At every house:

```text
TAKE
OR
SKIP
```

Therefore:

```text
dp[i] = max(
    dp[i-1],              // skip
    nums[i] + dp[i-2]     // take
)
```

This is:

# Take / Skip DP

---

# 9. The decision tree

```text
                    house i
                   /        \
                SKIP        TAKE
                  |            |
              dp[i-1]     nums[i] + dp[i-2]
```

This pattern appears everywhere.

Think:

```text
Can I choose an item?
     │
     ├── YES → TAKE
     │
     └── NO → SKIP
```

Typical problems:

* House Robber
* Maximum sum of non-adjacent elements
* Delete and Earn
* Weighted scheduling variants
* Some subsequence problems

---

# 10. Pattern 3 — Grid DP

Now the state has two dimensions.

Example:

```text
1 1 1
1 1 1
1 1 1
```

Question:

> How many ways to reach bottom-right if you can move right/down?

To reach:

```text
(i,j)
```

you could come from:

```text
(i-1,j)
```

or:

```text
(i,j-1)
```

Therefore:

```text
dp[i][j] =
    dp[i-1][j]
  + dp[i][j-1]
```

---

# 11. Grid DP recognition

When you see:

```text
Grid
+
move restrictions
+
minimum/maximum/count paths
```

think:

```text
GRID DP
```

Examples:

* Unique Paths
* Unique Paths II
* Minimum Path Sum
* Dungeon Game
* Cherry Pickup variants

---

# 12. Grid DP mental model

```text
        ↓
     [i-1][j]
        ↓
[i][j-1] → [i][j]
```

Ask:

> From which previous states can I arrive here?

That's usually your transition.

---

# 13. Pattern 4 — 0/1 Knapsack

This is arguably the **most important DP family**.

Suppose:

```text
weights = [1,3,4]
values  = [15,20,30]

capacity = 4
```

Each item can be used:

```text
0 times
OR
1 time
```

Hence:

# 0/1 Knapsack

At item `i`:

```text
SKIP item
TAKE item
```

But now we also track capacity.

State:

```text
dp[i][capacity]
```

meaning:

> Best value using first i items with this capacity.

Transition:

```text
skip:
dp[i-1][capacity]

take:
value[i] + dp[i-1][capacity-weight[i]]
```

Therefore:

```text
dp[i][c] =
max(
    dp[i-1][c],
    value[i] + dp[i-1][c-weight[i]]
)
```

---

# 14. The huge clue: "Each item once"

Whenever you hear:

```text
Each item can be selected at most once
```

think:

# 0/1 Knapsack

Problems:

* 0/1 Knapsack
* Partition Equal Subset Sum
* Target Sum
* Subset Sum
* Last Stone Weight
* Ones and Zeroes

---

# 15. Pattern 5 — Unbounded Knapsack

Now:

> You can use an item unlimited times.

Example:

```text
coins = [1,2,5]
amount = 11
```

Coin `1` can be used repeatedly:

```text
1 + 1 + 1 + ...
```

That's:

# Unbounded Knapsack

Typical problems:

* Coin Change
* Coin Change II
* Rod Cutting
* Unbounded Knapsack
* Combination Sum variants

The conceptual difference:

```text
0/1:
item → use once

Unbounded:
item → reuse
```

You already saw a similar distinction in backtracking:

```text
reuse allowed → recurse with i
no reuse → recurse with i+1
```

DP has the same conceptual distinction.

---

# 16. 0/1 vs Unbounded — critical interview trap

Consider:

```text
dp[i][capacity]
```

### 0/1:

If you take item `i`:

```text
dp[i-1][capacity-weight]
```

You move to previous items.

### Unbounded:

If you take item `i`:

```text
dp[i][capacity-weight]
```

You can take the same item again.

This distinction is **extremely important**.

---

# 17. Pattern 6 — Subset / Partition DP

These problems often look different but are actually knapsack.

Example:

```text
nums = [1,5,11,5]
```

Can we divide into two subsets with equal sum?

Total:

```text
22
```

Each subset must sum:

```text
11
```

So the problem becomes:

> Can I select some numbers whose sum is 11?

That's:

```text
Subset Sum
```

which is:

```text
0/1 Knapsack
```

This transformation is important.

---

# 18. Recognition

Whenever you see:

```text
partition
subset
target sum
equal sum
select elements
can we achieve sum X?
```

Think:

```text
Subset Sum / Knapsack DP
```

---

# 19. Pattern 7 — String DP

Now we move into one of the most important FAANG categories.

Classic problems:

* Longest Common Subsequence
* Edit Distance
* Distinct Subsequences
* Word Break
* Interleaving String
* Palindromic Subsequence

---

# 20. LCS — Longest Common Subsequence

Given:

```text
s1 = "abcde"
s2 = "ace"
```

Answer:

```text
"ace"
```

length:

```text
3
```

State:

```text
dp[i][j]
```

means:

> LCS between first i characters of s1 and first j characters of s2.

Now look at last characters.

If:

```text
s1[i-1] == s2[j-1]
```

then:

```text
dp[i][j] =
    1 + dp[i-1][j-1]
```

Otherwise:

```text
dp[i][j] =
    max(
        dp[i-1][j],
        dp[i][j-1]
    )
```

---

# 21. LCS mental model

This is extremely important:

```text
             s1[i]
                \
                 compare
                /
             s2[j]
```

If equal:

```text
        match
          ↓
 diagonal
```

If different:

```text
        mismatch
        /      \
   skip s1    skip s2
```

So:

```text
MATCH
→ diagonal

MISMATCH
→ left/right
```

This visual pattern appears in many string DP problems.

---

# 22. Pattern 8 — Edit Distance

Transform:

```text
horse
```

into:

```text
ros
```

Operations:

```text
insert
delete
replace
```

State:

```text
dp[i][j]
```

= minimum operations to transform first `i` characters into first `j`.

If characters match:

```text
dp[i][j] = dp[i-1][j-1]
```

Otherwise:

```text
dp[i][j] =
1 + min(
    dp[i-1][j],     // delete
    dp[i][j-1],     // insert
    dp[i-1][j-1]    // replace
)
```

Recognition:

```text
String A → String B
+
minimum operations
```

Think:

# Edit Distance DP

---

# 23. Pattern 9 — Sequence DP

Now problems where you're selecting elements while maintaining an ordering relationship.

Classic:

# Longest Increasing Subsequence

```text
[10,9,2,5,3,7,101,18]
```

Answer:

```text
[2,3,7,101]
```

length:

```text
4
```

A classic DP state:

```text
dp[i]
```

means:

> LIS ending at index i.

Then:

```text
for j < i:

    if nums[j] < nums[i]:

        dp[i] =
            max(
                dp[i],
                dp[j] + 1
            );
```

---

# 24. LIS recognition

When you see:

```text
subsequence
+
increasing/decreasing
+
longest
```

think:

```text
LIS
```

More broadly:

> **Sequence + ordering constraint + longest/maximum**

often leads to sequence DP.

Advanced LIS can be solved in:

```text
O(n log n)
```

using binary search, which is important for harder product-company interviews.

---

# 25. Pattern 10 — Stock DP

This is a very important family.

Problems:

* Best Time to Buy/Sell Stock
* Unlimited Transactions
* Cooldown
* Transaction Fee
* At Most K Transactions

The key idea:

> Your state depends on whether you currently hold a stock.

State:

```text
dp[i][0] = maximum profit on day i when NOT holding stock
dp[i][1] = maximum profit on day i when holding stock
```

Transitions:

```text
not holding:
max(
    previous not holding,
    previous holding + price
)
```

Holding:

```text
max(
    previous holding,
    previous not holding - price
)
```

This is called:

# State Machine DP

---

# 26. State Machine DP

This is a broader pattern.

Think:

```text
       BUY
       ↓
NOT HOLDING ─────→ HOLDING
       ↑             │
       └── SELL ─────┘
```

Each state represents a condition.

Examples:

```text
holding / not holding
cooldown / normal
transaction count
```

This pattern is extremely useful for:

* Stock problems
* Paint House
* State transitions
* Some scheduling problems

---

# 27. Pattern 11 — DP with State + Position

A very common advanced pattern.

Instead of:

```text
dp[i]
```

you may need:

```text
dp[i][state]
```

Examples:

```text
dp[i][holding]
dp[i][transactions]
dp[i][cooldown]
dp[i][color]
```

The important question becomes:

> **What information about the past actually affects my future decisions?**

That information becomes part of the DP state.

This is one of the most important DP skills for hard interviews.

---

# 28. Pattern 12 — Interval DP

This is where DP starts getting more advanced.

Instead of:

```text
dp[i]
```

or:

```text
dp[i][j]
```

we interpret:

```text
dp[l][r]
```

as:

> Answer for interval `[l...r]`.

Examples:

* Matrix Chain Multiplication
* Burst Balloons
* Palindrome problems
* Minimum Cost to Cut a Stick
* Merge Stones

---

# 29. Interval DP mental model

Suppose:

```text
[l ........ r]
```

Ask:

> Where should I split this interval?

```text
[l ..... k | k+1 ..... r]
```

Then:

```text
dp[l][r]
=
best over all split positions k
```

Generic:

```java
for (int len = 2; len <= n; len++) {

    for (int l = 0; l + len <= n; l++) {

        int r = l + len - 1;

        for (int k = l; k < r; k++) {

            // combine left + right
        }
    }
}
```

Recognition:

```text
interval/range
+
choose a split
+
minimum/maximum cost
```

→ Interval DP.

---

# 30. Pattern 13 — Palindrome DP

String problems involving:

```text
palindrome
longest
minimum cuts
substring/subsequence
```

often use DP.

For palindrome:

```text
dp[l][r]
```

means:

> Is `s[l..r]` a palindrome?

Transition:

```text
s[l] == s[r]
AND
dp[l+1][r-1]
```

So:

```text
dp[l][r] =
    s[l] == s[r]
    &&
    dp[l+1][r-1]
```

This can then be used for:

* Longest Palindromic Substring
* Palindrome Partitioning
* Minimum Cuts

---

# 31. Pattern 14 — Grid + Obstacles

Example:

```text
0 0 0
0 1 0
0 0 0
```

`1 = obstacle`.

Need number of paths.

The recurrence remains:

```text
dp[i][j] =
    dp[i-1][j]
  + dp[i][j-1]
```

but:

```text
obstacle
→ dp[i][j] = 0
```

This is a good reminder:

> DP transition often stays the same; the constraint changes the state/base condition.

---

# 32. Pattern 15 — Tree DP

You already know Trees, so this is a natural extension.

Example:

# House Robber III

Each tree node represents a house.

If you rob a node:

```text
you cannot rob its children
```

So each node needs two states:

```text
rob
skip
```

Return:

```text
int[] {
    rob,
    skip
}
```

For a node:

```text
rob =
    node.val
    + left.skip
    + right.skip

skip =
    max(left.rob, left.skip)
    + max(right.rob, right.skip)
```

This is:

# Tree DP

Recognition:

```text
Tree
+
optimization/counting
+
parent/child dependency
```

Think:

> What information should each child return to its parent?

---

# 33. Pattern 16 — DAG DP

A Directed Acyclic Graph has a natural ordering.

Therefore you can do DP over it.

For example:

```text
A → B → D
 \→ C → D
```

If:

```text
dp[node]
```

means best value reaching node:

```text
dp[B] = dp[A] + weight(A,B)
```

You process nodes in:

```text
topological order
```

This is:

# DAG DP

Important connection:

```text
Graph
+
No cycles
+
Optimization/counting
```

→ DP on DAG.

---

# 34. Pattern 17 — Bitmask DP

This is one of the more advanced FAANG patterns.

Suppose you have:

```text
n <= 20
```

and need to know:

> Which elements have already been chosen?

Represent the selected set using bits.

For:

```text
n = 4
```

```text
0000 → none
0001 → element 0
0011 → elements 0,1
1011 → elements 0,1,3
```

Then:

```text
dp[mask]
```

or:

```text
dp[mask][last]
```

can represent the state.

---

# 35. Bitmask DP recognition

Look for:

```text
small n
+
choose/order subsets
+
each item used once
+
state depends on which items are already used
```

Think:

# Bitmask DP

Classic problem:

**Travelling Salesman Problem**

```text
dp[mask][i]
```

means:

> Minimum cost after visiting the cities represented by `mask` and currently being at city i.

This is advanced but absolutely worth knowing for high-level FAANG interviews.

---

# 36. Pattern 18 — Digit DP

Another advanced pattern.

Problems such as:

> Count numbers between 1 and N satisfying some digit property.

For example:

```text
How many numbers ≤ N
have no repeated digits?
```

Instead of iterating all numbers, construct the number digit by digit.

State might look like:

```text
dp[position][tight][started][mask]
```

This is advanced.

Recognition:

```text
count numbers
+
range [0,N]
+
digit constraints
```

→ Digit DP.

You don't need this early in your DP journey, but it's a genuine advanced pattern.

---

# 37. Pattern 19 — Probability DP

Some problems ask:

> Probability of reaching a state.

Instead of:

```text
min
max
count
```

the DP stores:

```text
probability
```

Examples:

* Knight Probability in Chessboard
* Dice probability problems
* Random walk problems

Same DP framework:

```text
state
→ transitions
→ combine probabilities
```

---

# 38. Pattern 20 — Counting DP

Not all DP asks for min/max.

Sometimes:

> How many ways?

Examples:

* Climbing Stairs
* Coin Change II
* Decode Ways
* Unique Paths
* Distinct Subsequences

Transition often uses:

```text
dp[state] =
sum(previous states)
```

Recognition:

```text
"How many ways..."
"How many possible..."
"Number of arrangements..."
```

Think:

# Counting DP

---

# 39. Pattern 21 — Min/Max DP

When you see:

```text
minimum cost
maximum profit
longest
shortest
maximum score
minimum operations
```

DP often becomes:

```text
dp[state] =
min/max(
    possible previous states
)
```

Examples:

```text
minimum path sum
house robber
edit distance
coin change
LIS
stock
```

The important thing is not the word "minimum."

It's:

> **Can I define the answer for a smaller state and optimize over possible previous decisions?**

---

# 40. Pattern 22 — Boolean DP

Some DP asks:

> Is it possible?

Then:

```text
dp[state] = true / false
```

Examples:

* Subset Sum
* Word Break
* Partition Equal Subset Sum
* Decode Ways variants

Transition:

```text
dp[state] =
    dp[previous1]
    ||
    dp[previous2]
```

This is:

# Feasibility DP

---

# 41. Three broad types of DP

Almost every DP problem fits into one of these result types:

```text
                    DP
                     │
       ┌─────────────┼─────────────┐
       │             │             │
     COUNT          MIN/MAX       BOOLEAN
       │             │             │
    ways            optimize       possible?
```

Examples:

```text
COUNT
Unique Paths
Coin Change II
Decode Ways
```

```text
MIN/MAX
House Robber
Knapsack
LIS
Edit Distance
Stock
```

```text
BOOLEAN
Subset Sum
Word Break
Partition
```

This classification makes the recurrence easier to design.

---

# 42. The biggest DP recognition question

When you see a problem, don't immediately ask:

> "Which DP pattern is this?"

Ask:

### Question 1

> Is there a smaller version of the same problem?

If no:

```text
probably not DP
```

If yes:

```text
continue
```

### Question 2

> Will I calculate the same smaller problem repeatedly?

If yes:

```text
DP candidate
```

### Question 3

> What information defines that smaller problem?

That becomes:

```text
STATE
```

This is the most important step.

---

# 43. How to DESIGN a DP

Suppose you're stuck.

Use this exact process.

```text
STEP 1
What is changing?
```

Maybe:

```text
index
capacity
position
remaining amount
two string indices
tree node
mask
```

That gives the state.

---

```text
STEP 2
What decisions can I make?
```

For example:

```text
take
skip
buy
sell
move right
move down
insert
delete
replace
```

---

```text
STEP 3
What happens after each decision?
```

That gives the transition.

---

```text
STEP 4
When does the process stop?
```

Base case.

---

```text
STEP 5
What does dp[state] represent?
```

If you can't say this in one sentence, your DP is probably not ready.

---

# 44. Example: House Robber from scratch

Don't memorize the formula.

Start with:

```text
nums = [2,7,9,3,1]
```

Question:

> Maximum money?

At house `i`:

```text
What can I do?
```

```text
SKIP
TAKE
```

If skip:

```text
dp[i-1]
```

If take:

```text
nums[i] + dp[i-2]
```

Therefore:

```text
dp[i] =
max(
    dp[i-1],
    nums[i] + dp[i-2]
)
```

That's DP design.

---

# 45. Example: Coin Change from scratch

Coins:

```text
[1,2,5]
amount = 11
```

Question:

> Minimum number of coins?

Define:

```text
dp[x] =
minimum coins required to make amount x
```

What can be the last coin?

```text
1
2
5
```

Therefore:

```text
dp[x] =
1 + min(
    dp[x-1],
    dp[x-2],
    dp[x-5]
)
```

provided the amount is valid.

That's the pattern:

```text
Current state
↓
Try every possible last choice
↓
Take minimum
```

---

# 46. "Last decision" is incredibly powerful

For many DP problems:

```text
What's the last thing I did?
```

Examples:

### Coin Change

Last coin.

### LIS

Last element in subsequence.

### LCS

Last character.

### Edit Distance

Last operation.

### Grid DP

Last move.

### Knapsack

Last item.

### House Robber

Last house decision.

This gives you the transition.

---

# 47. DP vs Backtracking

You already learned Backtracking.

They are closely related.

Backtracking:

```text
                    choices
                       ↓
                explore everything
                       ↓
                  undo choice
```

DP:

```text
                    choices
                       ↓
                same state repeats
                       ↓
                 cache result
```

So you can think:

> **DP is often optimized recursive search.**

Example:

```text
                    f(n)
                  /     \
               f(n-1)  f(n-2)
```

Backtracking/recursion:

```text
calculate everything
```

Memoized DP:

```text
calculate f(3) once
reuse it
```

---

# 48. DP vs Greedy

This is another important interview distinction.

Greedy:

> Make the best decision **right now**.

DP:

> Consider possible decisions and remember the best result for each state.

Example:

```text
Coin Change
coins = [1,3,4]
amount = 6
```

Greedy:

```text
4 + 1 + 1
= 3 coins
```

Optimal:

```text
3 + 3
= 2 coins
```

So greedy fails.

DP finds the optimal combination.

---

# 49. DP vs Divide and Conquer

Divide and conquer:

```text
problem
 ↓
independent subproblems
 ↓
solve separately
 ↓
combine
```

DP:

```text
problem
 ↓
overlapping subproblems
 ↓
reuse results
```

The word:

# OVERLAPPING

is critical.

---

# 50. Memoization vs Tabulation

Two ways to implement DP.

## Memoization

Top-down.

```java
int solve(int n) {

    if (memo[n] != -1) {
        return memo[n];
    }

    memo[n] =
        solve(n - 1)
        +
        solve(n - 2);

    return memo[n];
}
```

You start from:

```text
answer
↓
dependencies
```

---

## Tabulation

Bottom-up.

```java
dp[0] = ...
dp[1] = ...

for (int i = 2; i <= n; i++) {
    dp[i] = ...
}
```

You start from:

```text
base cases
↓
answer
```

---

# 51. Which should you use in interviews?

I recommend:

### First solve recursively

Understand:

```text
state
choices
transition
```

Then:

```text
memoization
```

Then if useful:

```text
tabulation
```

Then:

```text
space optimization
```

This progression helps you understand DP instead of memorizing arrays.

---

# 52. DP Optimization Ladder

Very useful:

```text
Recursion
    ↓
Memoization
    ↓
Tabulation
    ↓
Space Optimization
    ↓
Advanced optimization
```

Example:

```text
Fibonacci

Recursion:
O(2^n)

Memoization:
O(n) time
O(n) space

Tabulation:
O(n) time
O(n) space

Space optimized:
O(n) time
O(1) space
```

---

# 53. Advanced DP Optimization

For hard problems, you'll eventually encounter:

```text
Bitmask
Monotonic Queue
Convex Hull Trick
Divide & Conquer Optimization
Knuth Optimization
Rolling Hash
State Compression
```

You don't need these initially.

But knowing they exist helps you understand the hierarchy.

---

# 54. DP Recognition Cheat Sheet

This is the part I'd keep in your notes.

```text
"How many ways?"
        ↓
Counting DP
```

```text
"Minimum / Maximum?"
        ↓
Optimization DP
```

```text
"Can it be done?"
        ↓
Boolean DP
```

```text
"Each item once?"
        ↓
0/1 Knapsack
```

```text
"Can reuse item?"
        ↓
Unbounded Knapsack
```

```text
"Subset / partition / target sum?"
        ↓
Knapsack DP
```

```text
"Grid + paths?"
        ↓
Grid DP
```

```text
"Two strings?"
        ↓
2D String DP
```

```text
"Longest subsequence + ordering?"
        ↓
LIS / Sequence DP
```

```text
"Transform string A → B?"
        ↓
Edit Distance DP
```

```text
"Buy/Sell/hold?"
        ↓
State Machine DP
```

```text
"Range [l,r] + split?"
        ↓
Interval DP
```

```text
"Tree + optimization?"
        ↓
Tree DP
```

```text
"DAG + optimization?"
        ↓
DAG DP
```

```text
"Small n ≤ ~20 + subsets?"
        ↓
Bitmask DP
```

```text
"Count numbers ≤ N with digit restrictions?"
        ↓
Digit DP
```

---

# 55. The DP Pattern Map

This is the structure I'd recommend you eventually memorize:

```text
                         DYNAMIC PROGRAMMING
                                  │
       ┌──────────────────────────┼──────────────────────────┐
       │                          │                          │
     1D DP                     2D DP                     State DP
       │                          │                          │
 Fibonacci                    Grid DP                  Stock
 Climbing                     LCS                      Cooldown
 House Robber                 Edit Distance             Transactions
 Decode Ways                  Palindrome
                               │
                               │
                     ┌─────────┴─────────┐
                     │                   │
                 Knapsack             Sequence
                     │                   │
               0/1 Knapsack             LIS
               Unbounded               LCS
               Subset Sum              Subsequence
               Partition
                     │
       ┌─────────────┴───────────────┐
       │                             │
   Interval DP                  Graph/Tree DP
       │                             │
 Matrix Chain                     Tree DP
 Burst Balloons                   DAG DP
 Palindrome                       Shortest DAG
 Cut Stick
       │
       └───────────────┬───────────────
                       │
                    Advanced
                       │
                Bitmask DP
                Digit DP
                Probability DP
                State Compression
```

---

# 56. The FAANG-level DP decision tree

When you receive a new DP-looking problem, use this:

```text
                    PROBLEM
                       │
                       ▼
          Is there a smaller version
             of the same problem?
                  /          \
                NO            YES
                │              │
           Probably not        ▼
                              Does the
                         same state repeat?
                           /          \
                         NO            YES
                         │              │
                    Divide/Greedy      DP
                                        │
                                        ▼
                              What defines state?
                                        │
                  ┌─────────────────────┼─────────────────────┐
                  │                     │                     │
                index                 grid               capacity
                  │                     │                     │
                 1D                   2D                  Knapsack
                  │
          ┌───────┴────────┐
          │                │
       position          state
          │                │
       sequence       stock/cooldown
```

Then ask:

```text
What are my choices?
```

and:

```text
What is my recurrence?
```

---

# 57. The most important DP states

If you can recognize these state shapes, you will solve a huge percentage of interview DP:

```text
dp[i]
```

→ one-dimensional / sequence.

```text
dp[i][j]
```

→ two dimensions / two indices / grid / strings.

```text
dp[i][capacity]
```

→ knapsack.

```text
dp[i][state]
```

→ state machine.

```text
dp[l][r]
```

→ interval.

```text
dp[node][state]
```

→ tree DP.

```text
dp[mask]
```

→ subset/state compression.

```text
dp[mask][last]
```

→ permutation/subset ordering.

```text
dp[position][tight][mask]
```

→ digit DP.

These shapes are more useful than memorizing individual problem names.

---

# 58. The "state = minimum sufficient information" principle

This is probably the **most advanced DP concept you should internalize**.

Suppose you're solving a stock problem.

You have processed 100 days.

Do you need to remember all 100 days?

No.

Maybe you only need:

```text
current day
holding/not holding
transactions remaining
```

Therefore:

```text
dp[day][holding][transactions]
```

is sufficient.

That's DP state design.

Ask:

> **What information from the past can actually affect my future decisions?**

Store **only that**.

This is how you move from basic DP to hard DP.

---

# 59. Common DP mistakes

## Mistake 1 — Jumping straight to a DP array

Don't start:

```java
int[][] dp = new int[n][n];
```

before defining:

> What does `dp[i][j]` mean?

First write the sentence.

Example:

```text
dp[i][j] =
LCS length between first i chars of s1
and first j chars of s2.
```

Then code.

---

## Mistake 2 — Wrong state

Suppose the future depends on:

```text
index
+
whether previous element was selected
```

but you only use:

```text
dp[index]
```

Your state loses information.

---

## Mistake 3 — Mixing 0/1 and unbounded

Huge interview trap.

```text
0/1:
use previous item state

unbounded:
same item can remain available
```

---

## Mistake 4 — Wrong iteration direction

For 0/1 knapsack with 1D DP:

```java
for (int w = capacity; w >= weight; w--)
```

For unbounded:

```java
for (int w = weight; w <= capacity; w++)
```

This difference determines whether the same item can be reused.

---

# 60. Mistake 5 — Confusing subsequence and substring

Very important.

### Substring

Contiguous:

```text
abcde

"bcd"
```

### Subsequence

Can skip:

```text
abcde

"ace"
```

This changes the DP completely.

---

# 61. Mistake 6 — Assuming every optimization problem is DP

Consider:

> Find maximum element.

That's not DP.

Consider:

> Activity selection with a greedy property.

Could be greedy.

Consider:

> Shortest path in a graph.

Could be BFS/Dijkstra.

So:

```text
Optimization ≠ automatically DP
```

You need:

```text
smaller states
+
overlapping subproblems
```

---

# 62. Mistake 7 — Using DP when greedy is sufficient

If a local choice is provably optimal:

```text
Greedy
```

may be simpler and faster.

Interviewers often want you to distinguish:

```text
Greedy
vs
DP
```

rather than blindly applying DP.

---

# 63. Mistake 8 — Not recognizing graph/tree DP

This is a common transition for people learning DP.

They think:

```text
DP = array
```

Not true.

DP is about:

```text
state
+
transition
+
reuse
```

The state can be:

```text
array index
grid cell
tree node
graph node
bitmask
string indices
```

That's why:

```text
Tree DP
Graph DP
DAG DP
```

are legitimate DP categories.

---

# 64. The DP interview hierarchy

For your preparation, I'd go in this order:

### Level 1 — Foundation

```text
Fibonacci
Climbing Stairs
Min Cost Climbing Stairs
House Robber
Maximum Subarray
```

### Level 2 — Grid

```text
Unique Paths
Unique Paths II
Minimum Path Sum
```

### Level 3 — Knapsack

```text
0/1 Knapsack
Subset Sum
Partition Equal Subset Sum
Target Sum
Coin Change
Coin Change II
```

### Level 4 — String

```text
LCS
Longest Common Substring
Edit Distance
Distinct Subsequences
Word Break
Palindrome DP
```

### Level 5 — Sequence

```text
LIS
LIS O(n log n)
Maximum Sum Increasing Subsequence
Russian Doll Envelopes
```

### Level 6 — State Machine

```text
Stock I
Stock II
Stock with Cooldown
Stock with Fee
Stock with K Transactions
```

### Level 7 — Advanced

```text
Interval DP
Tree DP
DAG DP
Bitmask DP
Digit DP
Probability DP
```

---

# 65. What I would consider "FAANG-ready DP"

You don't need to memorize hundreds of recurrences.

You should be able to see:

```text
                    UNKNOWN PROBLEM
                          │
                          ▼
                  Define the STATE
                          │
                          ▼
                  Identify CHOICES
                          │
                          ▼
              Write the TRANSITIONS
                          │
                          ▼
                  Define BASE CASE
                          │
                          ▼
                 Memoization / DP
                          │
                          ▼
                 Optimize if needed
```

And recognize these **core families**:

```text
1. 1D DP
2. Take / Skip
3. Grid DP
4. 0/1 Knapsack
5. Unbounded Knapsack
6. Subset / Partition
7. String DP
8. LCS
9. Edit Distance
10. LIS / Sequence DP
11. State Machine DP
12. Interval DP
13. Tree DP
14. DAG DP
15. Bitmask DP
16. Digit DP
17. Probability / Counting DP
```

---

# 66. The one-page DP mental model

If I had to compress the entire topic for your interview notebook:

```text
                         DP
                          │
              ┌───────────┴───────────┐
              │                       │
          REPEATED STATE          OPTIMAL SUBSTRUCTURE
              │                       │
              └───────────┬───────────┘
                          ↓
                        STATE
                          │
               ┌──────────┼───────────┐
               │          │           │
             INDEX      GRID       CAPACITY
               │          │           │
              1D         2D       KNAPSACK
               │
       ┌───────┼─────────┐
       │       │         │
    TAKE/SKIP STOCK    SEQUENCE
       │                 │
   House Robber         LIS
                         LCS
                          │
                ┌─────────┴─────────┐
                │                   │
             STRING              INTERVAL
                │                   │
          Edit Distance       dp[l][r]
          Palindrome
                │
                └──────────┐
                           │
                      ADVANCED
                           │
              ┌────────────┼────────────┐
              │            │            │
           TREE DP       DAG DP      BITMASK
                                       │
                                    DIGIT DP
```

And the **recognition rule**:

> **If a problem asks for count/min/max/possibility and you can describe the answer for a smaller state, check whether the same state can be reached repeatedly. If yes, you probably have DP.**

The biggest jump from your previous topics is that **DP is not primarily about knowing an algorithm; it's about designing the state**.

For the next step, I'd recommend going **very deep into DP pattern-by-pattern**, starting with **1D DP → Take/Skip → Knapsack**, because those three teach almost all the fundamental DP mechanics. After that, LCS/String DP and State Machine DP become much easier.
