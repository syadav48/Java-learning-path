Absolutely. **Backtracking is one of the highest-value DSA patterns** because once you understand the template, a surprisingly large family of problems becomes variations of the same idea.

The mistake people make is learning:

> "Subsets = this code, permutations = that code, N-Queens = another code."

Instead, learn the **backtracking engine**, then recognize which part changes.

---

# 1. What is Backtracking?

At its core:

> **Choose → Explore → Undo**

Imagine you're solving a maze:

```text
Start
  ↓
choose a path
  ↓
explore
  ↓
dead end?
  ↓
go back
  ↓
choose another path
```

That's backtracking.

In DSA:

```text
                    Problem
                       │
                     choose
                       ↓
                    recurse
                       ↓
                ┌──────┴──────┐
                │             │
             success        failure
                │             │
             answer          undo
                              │
                              ↓
                       try next choice
```

---

# 2. The Fundamental Template ⭐⭐⭐

This is the template you should memorize:

```java
void backtrack(...) {

    if (isComplete()) {
        result.add(...);
        return;
    }

    for (each choice) {

        // 1. Choose
        makeChoice();

        // 2. Explore
        backtrack(...);

        // 3. Undo
        undoChoice();
    }
}
```

That's basically the entire concept.

The three lines:

```java
makeChoice();

backtrack();

undoChoice();
```

are the heart of backtracking.

---

# 3. The most important question

Whenever you see a problem, ask:

> **"What are my choices at this step?"**

For example:

### Subsets

For each number:

```text
take it
don't take it
```

### Permutations

At each position:

```text
choose any unused number
```

### Combination Sum

At each step:

```text
choose one candidate
```

### N-Queens

At each row:

```text
choose a column
```

### Word Search

At each cell:

```text
up
down
left
right
```

That's how you recognize backtracking.

---

# 4. Backtracking vs Recursion

This distinction is important.

All backtracking uses recursion in the common implementation.

But:

> **Not all recursion is backtracking.**

For example, tree traversal:

```java
dfs(root.left);
dfs(root.right);
```

is recursion, but normally there isn't a decision that gets **undone**.

Backtracking:

```java
path.add(x);

backtrack(...);

path.remove(path.size() - 1);
```

has:

```text
choose
explore
undo
```

---

# 5. The Backtracking State

Every backtracking problem has some **state**.

Usually:

```text
state =
    current position
    current path
    remaining target
    used elements
    board state
```

For example:

```java
backtrack(
    nums,
    start,
    path,
    result
);
```

You need to understand what each variable means.

---

# 6. Pattern #1 — Subsets ⭐⭐⭐

Given:

```text
[1,2,3]
```

Generate:

```text
[]
[1]
[2]
[3]
[1,2]
[1,3]
[2,3]
[1,2,3]
```

At every number:

```text
Take
Don't take
```

Tree:

```text
                  []
               /      \
            take 1    skip 1
             [1]       []
            /   \      /  \
         take 2 skip 2 ...
```

Implementation:

```java
public List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    backtrack(nums, 0, new ArrayList<>(), result);

    return result;
}

private void backtrack(
        int[] nums,
        int start,
        List<Integer> path,
        List<List<Integer>> result) {

    result.add(new ArrayList<>(path));

    for (int i = start; i < nums.length; i++) {

        // Choose
        path.add(nums[i]);

        // Explore
        backtrack(
            nums,
            i + 1,
            path,
            result
        );

        // Undo
        path.remove(path.size() - 1);
    }
}
```

This version uses the **for-loop backtracking pattern**.

---

# 7. Why `new ArrayList<>(path)`?

This is extremely important.

Don't do:

```java
result.add(path);
```

Because `path` is mutable.

You need a snapshot:

```java
result.add(new ArrayList<>(path));
```

Think:

```text
path → current working state

result → completed snapshots
```

---

# 8. Pattern #2 — Subsets With Duplicates

Input:

```text
[1,2,2]
```

Without handling duplicates, you'd generate duplicate subsets.

Sort first:

```java
Arrays.sort(nums);
```

Then:

```java
if (i > start && nums[i] == nums[i - 1]) {
    continue;
}
```

Full pattern:

```java
private void backtrack(
        int[] nums,
        int start,
        List<Integer> path,
        List<List<Integer>> result) {

    result.add(new ArrayList<>(path));

    for (int i = start; i < nums.length; i++) {

        if (i > start &&
            nums[i] == nums[i - 1]) {
            continue;
        }

        path.add(nums[i]);

        backtrack(
            nums,
            i + 1,
            path,
            result
        );

        path.remove(path.size() - 1);
    }
}
```

### Important concept

```text
i > start
```

means:

> Skip duplicate choices **at the same recursion level**.

This distinction becomes extremely important.

---

# 9. Pattern #3 — Permutations ⭐⭐⭐

Input:

```text
[1,2,3]
```

Output:

```text
[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]
```

Difference from subsets:

For subsets:

```text
start index
```


---

## Key Points
- At each recursion level, the algorithm loops through all indices `i=0..2`.
- If `used[i] == true`, that number is skipped.
- Otherwise, the number is chosen, marked as used, and added to `path`.
- When `path.size() == nums.length`, a complete permutation is added to `result`.
- Backtracking then **undoes the last choice** (removes from `path`, resets `used[i] = false`) and continues the loop to try other options.

---

## Final Result
All permutations generated:


For permutations:

> We can choose **any unused element**.

So we need:

```java
boolean[] used;
```

Code:

```java
public List<List<Integer>> permute(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    boolean[] used = new boolean[nums.length];

    backtrack(
        nums,
        used,
        new ArrayList<>(),
        result
    );

    return result;
}
```

```java
private void backtrack(
        int[] nums,
        boolean[] used,
        List<Integer> path,
        List<List<Integer>> result) {

    if (path.size() == nums.length) {
        result.add(new ArrayList<>(path));
        return;
    }

    for (int i = 0; i < nums.length; i++) {

        if (used[i]) {
            continue;
        }

        // Choose
        used[i] = true;
        path.add(nums[i]);

        // Explore
        backtrack(
            nums,
            used,
            path,
            result
        );

        // Undo
        path.remove(path.size() - 1);
        used[i] = false;
    }
}
```
# Permutation Backtracking Walkthrough

This document explains how the recursive backtracking algorithm generates all permutations of `[1,2,3]`.  
At each step:
- `path` shows the current partial permutation.
- `used[]` shows which elements are already chosen (`T = true`, `F = false`).

---

## Branching Tree with `used[]`

Start [] , used=[F,F,F]  
├── Choose 1 → [1], used=[T,F,F]  
│    ├── Choose 2 → [1,2], used=[T,T,F]  
│    │    └── Choose 3 → [1,2,3], used=[T,T,T] ✅  
│    └── Choose 3 → [1,3], used=[T,F,T]  
│         └── Choose 2 → [1,3,2], used=[T,T,T] ✅  
├── Choose 2 → [2], used=[F,T,F]  
│    ├── Choose 1 → [2,1], used=[T,T,F]  
│    │    └── Choose 3 → [2,1,3], used=[T,T,T] ✅  
│    └── Choose 3 → [2,3], used=[F,T,T]  
│         └── Choose 1 → [2,3,1], used=[T,T,T] ✅  
└── Choose 3 → [3], used=[F,F,T]  
├── Choose 1 → [3,1], used=[T,F,T]  
│    └── Choose 2 → [3,1,2], used=[T,T,T] ✅  
└── Choose 2 → [3,2], used=[F,T,T]  
└── Choose 1 → [3,2,1], used=[T,T,T] ✅

---

## Key Points
- At each recursion level, the algorithm loops through all indices `i=0..2`.
- If `used[i] == true`, that number is skipped.
- Otherwise, the number is chosen, marked as used, and added to `path`.
- When `path.size() == nums.length`, a complete permutation is added to `result`.
- Backtracking then **undoes the last choice** (removes from `path`, resets `used[i] = false`) and continues the loop to try other options.

---

## Final Result
All permutations generated:

---

# 10. Subsets vs Permutations

This is a very important interview distinction.

### Subsets

```text
[1,2,3]

At each level:
→ move forward
```

Use:

```java
start
```

### Permutations

```text
[1,2,3]

At each level:
→ any unused element
```

Use:

```java
boolean[] used
```

Think:

```text
SUBSET
       ↓
start index


PERMUTATION
       ↓
used[]
```

---

# 11. Pattern #4 — Combination Sum ⭐⭐⭐

Problem:

```text
candidates = [2,3,6,7]
target = 7
```

Output:

```text
[2,2,3]
[7]
```

Important detail:

> You can reuse a candidate.

Therefore:

```java
backtrack(..., i, ...)
```

not:

```java
i + 1
```

Code:

```java
public List<List<Integer>> combinationSum(
        int[] candidates,
        int target) {

    List<List<Integer>> result = new ArrayList<>();

    backtrack(
        candidates,
        target,
        0,
        new ArrayList<>(),
        result
    );

    return result;
}
```

```java
private void backtrack(
        int[] candidates,
        int target,
        int start,
        List<Integer> path,
        List<List<Integer>> result) {

    if (target == 0) {
        result.add(new ArrayList<>(path));
        return;
    }

    if (target < 0) {
        return;
    }

    for (int i = start;
         i < candidates.length;
         i++) {

        path.add(candidates[i]);

        backtrack(
            candidates,
            target - candidates[i],
            i,
            path,
            result
        );

        path.remove(path.size() - 1);
    }
}
```

---



## Stack Trace Example (first branch)

1. `backtrack("", index=0)`
    - loop → pick `'a'`
2. `backtrack("a", index=1)`
    - loop → pick `'d'`
3. `backtrack("ad", index=2)`
    - base case → add `"ad"`
    - backtrack → undo `'d'`
    - loop → pick `'e'` → `"ae"`
    - loop → pick `'f'` → `"af"`
4. Backtrack → undo `'a'`
5. Loop continues with `'b'`, `'c'`.

---

## Final Result for `"23"`


---

# 12. The `i` vs `i + 1` rule ⭐⭐⭐

This is one of the most important backtracking rules.

### Can reuse current element?

Use:

```java
backtrack(..., i, ...)
```

Example:

```text
Combination Sum
```

### Cannot reuse current element?

Use:

```java
backtrack(..., i + 1, ...)
```

Example:

```text
Combination Sum II
```

This tiny difference controls a huge part of the search space.

---

# 13. Combination Sum II

Input:

```text
[10,1,2,7,6,1,5]
target = 8
```

Candidates can only be used once.

First:

```java
Arrays.sort(candidates);
```

Then:

```java
if (i > start &&
    candidates[i] == candidates[i - 1]) {
    continue;
}
```

and recursion:

```java
backtrack(
    candidates,
    target - candidates[i],
    i + 1,
    path,
    result
);
```

So you combine two concepts:

```text
duplicate handling
+
cannot reuse
```

---

# 14. Pattern #5 — Letter Combinations

Input:

```text
"23"
```

Mapping:

```text
2 → abc
3 → def
```

Output:

```text
ad
ae
af
bd
be
bf
cd
ce
cf
```

Here each position gives you a **set of choices**.

```java
private void backtrack(
        String digits,
        int index,
        StringBuilder path,
        List<String> result) {

    if (index == digits.length()) {
        result.add(path.toString());
        return;
    }

    String letters =
        mapping[digits.charAt(index) - '0'];

    for (char c : letters.toCharArray()) {

        path.append(c);

        backtrack(
            digits,
            index + 1,
            path,
            result
        );

        path.deleteCharAt(path.length() - 1);
    }
}
```

Notice:

```text
path.add()
        ↓
recursive call
        ↓
path.remove()
```

Same engine.

---
## Algorithm
- At each digit, loop through all possible letters.
- Append one letter to the current path.
- Recurse to the next digit.
- When the path length equals the number of digits, add it to the result.
- Backtrack (remove the last letter) and try the next option.

---

## Branching Tree for `"23"`

Start "" (index=0)  
├── Choose 'a' → "a" (index=1)  
│    ├── Choose 'd' → "ad" ✅  
│    ├── Choose 'e' → "ae" ✅  
│    └── Choose 'f' → "af" ✅  
├── Choose 'b' → "b" (index=1)  
│    ├── Choose 'd' → "bd" ✅  
│    ├── Choose 'e' → "be" ✅  
│    └── Choose 'f' → "bf" ✅  
└── Choose 'c' → "c" (index=1)  
├── Choose 'd' → "cd" ✅  
├── Choose 'e' → "ce" ✅  
└── Choose 'f' → "cf" ✅

---
# 15. Pattern #6 — String Partitioning ⭐⭐⭐

Palindrome Partitioning:

```text
"aab"
```

Possible:

```text
[a, a, b]
[aa, b]
```

At every position:

> Choose where to cut the string.

```text
a | ab
aa | b
```

Pattern:

```java
for (int end = start; end < s.length(); end++) {

    if (isPalindrome(start, end)) {

        path.add(s.substring(start, end + 1));

        backtrack(
            s,
            end + 1,
            path,
            result
        );

        path.remove(path.size() - 1);
    }
}
```

This is:

> **Partitioning backtracking**

---

# 16. Pattern #7 — Word Search ⭐⭐⭐

Given:

```text
A B C E
S F C S
A D E E
```

Find:

```text
"ABCCED"
```

Now your choices are spatial:

```text
       UP
       ↑
LEFT ← X → RIGHT
       ↓
      DOWN
```

You need:

```java
boolean[][] visited;
```

At each cell:

```java
visited[r][c] = true;

dfs(up);
dfs(down);
dfs(left);
dfs(right);

visited[r][c] = false;
```

That final:

```java
visited[r][c] = false;
```

is the **undo**.

---

# 17. Word Search Template

```java
private boolean dfs(
        char[][] board,
        String word,
        int r,
        int c,
        int index) {

    if (index == word.length()) {
        return true;
    }

    if (r < 0 || r >= board.length ||
        c < 0 || c >= board[0].length ||
        board[r][c] != word.charAt(index)) {

        return false;
    }

    char original = board[r][c];

    board[r][c] = '#';

    boolean found =
        dfs(board, word, r + 1, c, index + 1)
        || dfs(board, word, r - 1, c, index + 1)
        || dfs(board, word, r, c + 1, index + 1)
        || dfs(board, word, r, c - 1, index + 1);

    board[r][c] = original;

    return found;
}
```

Here we're using the board itself as `visited`.

This is often cleaner.

---

# 18. Pattern #8 — N-Queens ⭐⭐⭐

This is one of the classic backtracking problems.

For `N = 4`:

```text
. Q . .
. . . Q
Q . . .
. . Q .
```

Place exactly one queen per row.

At each row:

```text
choose column
```

Before placing:

```text
Is column safe?
Is diagonal safe?
```

Maintain:

```java
boolean[] cols;
boolean[] diag1;
boolean[] diag2;
```

This is a great example of:

> **Backtracking + pruning**

---

# 19. What is pruning?

This is one of the most important concepts at product-company level.

Without pruning:

```text
explore everything
```

With pruning:

```text
if impossible:
    stop immediately
```

Example:

```java
if (target < 0) {
    return;
}
```

You don't need to explore deeper because the target can never recover.

N-Queens:

```text
if column is occupied:
    skip

if diagonal is occupied:
    skip
```

This can dramatically reduce the search space.

---

# 20. Backtracking Complexity

Backtracking is usually exponential.

Why?

Because you're exploring a **decision tree**.

For subsets:

```text
each element:
    take
    don't take
```

So:

```text
2 × 2 × 2 × ... n times

= 2^n
```

Subsets:

```text
Time: O(n × 2^n)
```

Why `n ×`?

Because copying each subset takes up to O(n).

---

# 21. Permutations

Number of permutations:

```text
n!
```

Therefore:

```text
O(n × n!)
```

approximately, because you copy each permutation.

---

# 22. Combination problems

Often:

```text
O(2^n)
```

or some larger exponential depending on whether elements can be reused.

The exact complexity varies significantly by problem.

For interviews, don't blindly say:

> "Backtracking is O(2^n)."

Instead say:

> "The complexity depends on the branching factor and depth of the decision tree."

That's the more accurate answer.

---

# 23. Backtracking State-Space Tree

This is the mental model I'd strongly recommend.

For:

```text
nums = [1,2,3]
```

Subsets:

```text
                       []
                 /            \
              [1]              []
            /     \          /    \
         [1,2]   [1]       [2]     []
         /   \
 [1,2,3]    [1,2]
```

You are traversing this **decision tree**.

Each recursion call represents:

> **One node in the search space.**

Each choice represents:

> **One edge.**

This is why backtracking is closely related to trees.

---

# 24. The 6 major Backtracking patterns

This is your interview cheat sheet.

```text
BACKTRACKING
│
├── 1. SUBSETS
│      └── start index
│
├── 2. PERMUTATIONS
│      └── used[]
│
├── 3. COMBINATIONS
│      └── start index
│
├── 4. PARTITIONING
│      └── choose cut position
│
├── 5. GRID / MATRIX
│      └── visited + directions
│
└── 6. CONSTRAINT PLACEMENT
       └── N-Queens / Sudoku
```

---

# 25. The patterns mapped to problems

| Pattern                  | Classic problems        |
| ------------------------ | ----------------------- |
| Subsets                  | Subsets                 |
| Subsets + duplicates     | Subsets II              |
| Permutation              | Permutations            |
| Permutation + duplicates | Permutations II         |
| Combination              | Combinations            |
| Combination reuse        | Combination Sum         |
| Combination no reuse     | Combination Sum II      |
| Partition                | Palindrome Partitioning |
| String choices           | Letter Combinations     |
| Grid DFS                 | Word Search             |
| Constraint placement     | N-Queens                |
| Constraint solving       | Sudoku                  |
| Path exploration         | Maze problems           |

---

# 26. The most important template

If you're sitting in an interview and recognize backtracking, start mentally with:

```java
void backtrack(
        State state,
        Path path) {

    if (isComplete(state)) {
        result.add(new ArrayList<>(path));
        return;
    }

    for (Choice choice : choices(state)) {

        if (!isValid(choice)) {
            continue;
        }

        // CHOOSE
        apply(choice);

        // EXPLORE
        backtrack(state, path);

        // UNDO
        undo(choice);
    }
}
```

Then identify:

```text
State
↓
Choices
↓
Constraint
↓
Goal
↓
Undo
```

That's your framework.

---

# 27. A very useful decision tree

When you see a problem, ask:

### "Does the question ask me to generate all possible..."

```text
subsets?
permutations?
combinations?
arrangements?
partitions?
paths?
boards?
```

If yes:

> **Think Backtracking.**

Then ask:

### 1. Can I reuse an element?

```text
YES → recurse with i
NO  → recurse with i + 1
```

### 2. Can order matter?

```text
YES → permutation-style
NO  → combination/subset-style
```

### 3. Are there duplicates?

```text
YES → sort + skip duplicates
```

### 4. Can I detect an invalid state early?

```text
YES → PRUNE
```

### 5. Is the search happening on a grid?

```text
YES → visited / mark-and-restore
```

---

# 28. The biggest mistakes people make

### Mistake 1 — Forgetting undo

```java
path.add(x);

backtrack(...);

// forgot:
path.remove(path.size() - 1);
```

This corrupts sibling branches.

---

### Mistake 2 — Adding the same mutable list

Wrong:

```java
result.add(path);
```

Correct:

```java
result.add(new ArrayList<>(path));
```

---

### Mistake 3 — Wrong `i` / `i+1`

```text
reuse allowed     → i
reuse prohibited  → i + 1
```

---

### Mistake 4 — Duplicate handling

Usually:

```java
Arrays.sort(nums);

if (i > start && nums[i] == nums[i - 1]) {
    continue;
}
```

But don't blindly use this in every duplicate problem. Whether the skip is correct depends on whether duplicates are allowed to occupy different positions in the same branch.

---

### Mistake 5 — No pruning

For example:

```java
if (target < 0) return;
```

can eliminate an enormous number of useless recursive calls when all candidates are positive.

---

# 29. Backtracking vs Dynamic Programming

This is an important interview distinction.

Backtracking:

> **I want to explore possible solutions.**

DP:

> **Many recursive states repeat, so I want to cache their answers.**

Example:

```text
Backtracking
       ↓
Explore search space
       ↓
Can become exponential
```

If you notice:

```text
same state
same remaining target
same index
```

being solved repeatedly, ask:

> **Can I memoize this?**

That's where Backtracking and DP start meeting.

---

# 30. Backtracking + Memoization

For example:

```text
state = (index, remainingTarget)
```

If the same state occurs multiple times:

```text
(index=3, target=10)
```

you can cache it.

This turns some exponential recursive solutions into much more efficient DP solutions.

This is a **very important transition** in advanced interviews.

---

# 31. Your Backtracking roadmap

Given the way we're building your DSA knowledge, I'd do it in this order:

```text
Backtracking
│
├── 1. Understand Choose → Explore → Undo
│
├── 2. Subsets
│
├── 3. Subsets II
│
├── 4. Combinations
│
├── 5. Combination Sum
│
├── 6. Combination Sum II
│
├── 7. Permutations
│
├── 8. Permutations II
│
├── 9. Letter Combinations
│
├── 10. Palindrome Partitioning
│
├── 11. Word Search
│
├── 12. N-Queens
│
├── 13. Sudoku
│
├── 14. Backtracking + pruning
│
└── 15. Backtracking + memoization
```

---

# 🔥 The one-page mental model

If you remember nothing else, remember this:

```text
                 BACKTRACKING
                      │
                      ↓
                 Make a choice
                      │
                      ↓
                 Is it valid?
                   /     \
                 NO       YES
                 │          │
               SKIP         ↓
                        Explore
                           │
                           ↓
                         Undo
                           │
                           ↓
                     Next choice
```

And classify the problem:

```text
ALL SUBSETS?
    → start index

ALL COMBINATIONS?
    → start index

ALL PERMUTATIONS?
    → used[]

CAN REUSE?
    → i

CANNOT REUSE?
    → i + 1

DUPLICATES?
    → sort + skip carefully

GRID?
    → visited + restore

CONSTRAINT PROBLEM?
    → validate + prune

REPEATED STATES?
    → consider memoization
```

The deeper connection with what you've already learned is actually nice:

```text
Linked List
    → pointer manipulation

Tree
    → DFS / BFS / Tree DP

Backtracking
    → DFS over a decision tree

Dynamic Programming
    → Backtracking/recursion + overlapping states + memoization
```

So **Backtracking is essentially DFS on a search-space tree**, where each edge represents a decision and `undo()` lets you return to the previous state and explore the next branch. Once that clicks, Subsets, Permutations, Combination Sum, N-Queens, Sudoku, Word Search, and many seemingly unrelated problems start looking like the same algorithm.




#qn asked here:
Yes. These are worth understanding because **N-Queens, Sudoku, and chess-style problems are where backtracking stops feeling like "generate combinations" and starts feeling like a real search algorithm**.

The common idea is:

> **Make a decision → check constraints → recursively explore → undo if necessary.**

The extra ingredient is **pruning**:

> **Don't explore a branch once you already know it cannot produce a valid answer.**

---

# 1. First: What exactly is pruning?

Imagine you're solving:

```text
Find a valid arrangement of something.
```

Without pruning:

```text
try choice 1
    try choice 1
        try choice 1
        try choice 2
        try choice 3
    try choice 2
    try choice 3
try choice 2
...
```

You're exploring enormous numbers of possibilities.

But suppose you reach:

```text
A
├── B
│   ├── C ❌
│   ├── D ❌
│   └── E ❌
└── F
```

If you know that `B` can never lead to a solution, you don't need to explore `C`, `D`, `E`.

You **prune the entire B branch**.

```text
A
├── B ❌ ← stop here
└── F
```

That's pruning.

---

# 2. N-Queens — the classic example ⭐⭐⭐

The problem:

> Put `N` queens on an `N × N` chessboard such that **no two queens attack each other**.

A chess queen can attack:

```text
horizontal →
vertical ↓
diagonal ↘
diagonal ↗
```

So:

```text
Q . . .
. Q . .
```

is invalid because they attack diagonally.

---

# 3. Let's start with 4 Queens

Board:

```text
. . . .
. . . .
. . . .
. . . .
```

We decide:

> Put one queen in each row.

Why one per row?

Because two queens in the same row would automatically attack each other.

So our search becomes:

```text
Row 0 → choose a column
Row 1 → choose a column
Row 2 → choose a column
Row 3 → choose a column
```

This is already a huge simplification.

---

# 4. The decision tree

For row 0:

```text
Q . . .
```

or:

```text
. Q . .
```

or:

```text
. . Q .
```

or:

```text
. . . Q
```

Suppose we choose:

```text
Q . . .
```

Now row 1 has:

```text
Q . . .
Q . . .  ❌ same column
. Q . .  ❌ diagonal
. . Q .  ❌ diagonal
. . . Q  ✅
```

Only column `3` is valid.

So:

```text
Q . . .
. . . Q
```

Now row 2:

```text
Q . . .
. . . Q
```

Possible:

```text
Q . . . ❌ same column
. Q . . ❌ diagonal
. . Q . ❌ diagonal
. . . Q ❌ same column
```

There is **no valid position**.

So what do we do?

### Backtrack.

Remove:

```text
row 1, column 3
```

Try another choice for row 0.

That's the whole algorithm.

---

# 5. N-Queens is a constraint problem

At each step:

```text
Choose a column for this row.
```

Before choosing, ask:

```text
Is this column safe?
Is left diagonal safe?
Is right diagonal safe?
```

If not:

```text
PRUNE
```

Don't recurse.

---

# 6. How do we detect diagonals?

This is the interesting part.

For a cell:

```text
(row, col)
```

Two cells are on the same diagonal if:

### Main diagonal

```text
row - col
```

is equal.

Example:

```text
(0,0)
(1,1)
(2,2)
(3,3)
```

All:

```text
row - col = 0
```

Another:

```text
(0,2)
(1,3)
```

Both:

```text
row - col = -2
```

---

### Other diagonal

Use:

```text
row + col
```

Example:

```text
(0,3)
(1,2)
(2,1)
(3,0)
```

All:

```text
row + col = 3
```

So we can maintain:

```java
boolean[] cols;
boolean[] diag1;
boolean[] diag2;
```

---

# 7. N-Queens implementation

```java
public List<List<String>> solveNQueens(int n) {

    List<List<String>> result = new ArrayList<>();

    char[][] board = new char[n][n];

    for (char[] row : board) {
        Arrays.fill(row, '.');
    }

    boolean[] cols = new boolean[n];

    boolean[] diag1 = new boolean[2 * n - 1];

    boolean[] diag2 = new boolean[2 * n - 1];

    backtrack(
        0,
        n,
        board,
        cols,
        diag1,
        diag2,
        result
    );

    return result;
}
```

DFS:

```java
private void backtrack(
        int row,
        int n,
        char[][] board,
        boolean[] cols,
        boolean[] diag1,
        boolean[] diag2,
        List<List<String>> result) {

    // All rows successfully filled
    if (row == n) {

        List<String> solution = new ArrayList<>();

        for (char[] r : board) {
            solution.add(new String(r));
        }

        result.add(solution);

        return;
    }

    for (int col = 0; col < n; col++) {

        int d1 = row - col + n - 1;
        int d2 = row + col;

        // PRUNING
        if (cols[col] ||
            diag1[d1] ||
            diag2[d2]) {

            continue;
        }

        // CHOOSE
        board[row][col] = 'Q';

        cols[col] = true;
        diag1[d1] = true;
        diag2[d2] = true;

        // EXPLORE
        backtrack(
            row + 1,
            n,
            board,
            cols,
            diag1,
            diag2,
            result
        );

        // UNDO
        board[row][col] = '.';

        cols[col] = false;
        diag1[d1] = false;
        diag2[d2] = false;
    }
}
```

---

# 8. Look at the structure

Forget the N-Queens details for a moment.

The important structure is:

```java
for (each possible choice) {

    if (invalid) {
        continue;       // PRUNE
    }

    makeChoice();       // CHOOSE

    backtrack();        // EXPLORE

    undoChoice();       // BACKTRACK
}
```

That's the same backtracking template we discussed earlier.

N-Queens simply has **more complicated validation**.

---

# 9. Why N-Queens is different from Subsets

Subsets:

```text
Choice:
take / don't take
```

N-Queens:

```text
Choice:
column 0
column 1
column 2
...
column n-1
```

And constraints:

```text
column occupied?
diagonal occupied?
```

So:

```text
Subsets
→ simple choices
→ almost no pruning

N-Queens
→ many choices
→ strong constraints
→ heavy pruning
```

---

# 10. Sudoku ⭐⭐⭐

Sudoku is another perfect backtracking problem.

You have:

```text
9 × 9
```

and need to fill empty cells.

Rules:

1. Each row contains `1-9` once.
2. Each column contains `1-9` once.
3. Each `3×3` box contains `1-9` once.

Suppose:

```text
5 3 . | . 7 . | . . .
6 . . | 1 9 5 | . . .
. 9 8 | . . . | . 6 .
------+-------+------
8 . . | . 6 . | . . 3
4 . . | 8 . 3 | . . 1
7 . . | . 2 . | . . 6
------+-------+------
. 6 . | . . . | 2 8 .
. . . | 4 1 9 | . . 5
. . . | . 8 . | . 7 9
```

We find an empty cell.

Suppose:

```text
row = 0
col = 2
```

Try:

```text
1
```

Check:

```text
row valid?
column valid?
3×3 box valid?
```

If yes:

```text
place 1
```

Then recursively solve the next empty cell.

If eventually we reach:

```text
no possible number
```

then:

```text
undo 1
```

Try:

```text
2
```

then:

```text
3
...
```

That's backtracking.

---

# 11. Sudoku pseudocode

```text
solve(board):

    find an empty cell

    if no empty cell:
        return true

    for number = 1 to 9:

        if number is invalid:
            continue

        place number

        if solve(board):
            return true

        remove number

    return false
```

Notice something interesting:

Unlike N-Queens, Sudoku often asks for **one valid solution**, not all solutions.

Therefore:

```java
if (solve(board)) {
    return true;
}
```

can immediately stop the search.

---

# 12. Sudoku Java implementation

```java
public boolean solveSudoku(char[][] board) {

    return solve(board);
}

private boolean solve(char[][] board) {

    for (int row = 0; row < 9; row++) {

        for (int col = 0; col < 9; col++) {

            if (board[row][col] != '.') {
                continue;
            }

            for (char num = '1'; num <= '9'; num++) {

                if (!isValid(board, row, col, num)) {
                    continue;
                }

                // CHOOSE
                board[row][col] = num;

                // EXPLORE
                if (solve(board)) {
                    return true;
                }

                // UNDO
                board[row][col] = '.';
            }

            // No number worked
            return false;
        }
    }

    // No empty cells
    return true;
}
```

Validation:

```java
private boolean isValid(
        char[][] board,
        int row,
        int col,
        char num) {

    for (int i = 0; i < 9; i++) {

        // Row
        if (board[row][i] == num) {
            return false;
        }

        // Column
        if (board[i][col] == num) {
            return false;
        }

        // 3x3 box
        int boxRow = 3 * (row / 3) + i / 3;
        int boxCol = 3 * (col / 3) + i % 3;

        if (board[boxRow][boxCol] == num) {
            return false;
        }
    }

    return true;
}
```

---

# 13. Where is the pruning in Sudoku?

This:

```java
if (!isValid(...)) {
    continue;
}
```

is pruning.

Suppose:

```text
empty cell
```

has candidates:

```text
1 2 3 4 5 6 7 8 9
```

But:

```text
1 → invalid
2 → invalid
3 → valid
```

We don't explore:

```text
1
2
```

at all.

That's pruning.

---

# 14. Sudoku can be optimized even further

The basic solution searches the board from:

```text
row 0 → col 0
```

to:

```text
row 8 → col 8
```

But we can do something smarter.

Instead of picking **any empty cell**, choose:

> **The empty cell with the fewest possible candidates.**

Example:

```text
Cell A → {1,2,3,4,5}
Cell B → {7}
Cell C → {2,5,8}
```

Choose:

```text
Cell B
```

because it has only one possibility.

This is called:

> **Minimum Remaining Values (MRV)**

It's a classic constraint-solving optimization.

The general principle:

> **Make the most constrained decision first.**

This can massively reduce the search tree.

---

# 15. Chess problems

"Chess" isn't one specific DSA pattern.

But several chess-style problems are excellent examples of **state-space search + backtracking**.

For example:

### Knight's Tour

A knight must visit every square exactly once.

Knight moves:

```text
        X   X
      X       X

          K

      X       X
        X   X
```

At each position there can be up to 8 moves.

So:

```text
current position
       ↓
try move 1
       ↓
try move 2
       ↓
...
```

But some moves eventually lead to dead ends.

Then:

```text
undo
```

and try another move.

---

# 16. Knight's Tour

Suppose:

```text
N = 5
```

Board:

```text
. . . . .
. . . . .
. . . . .
. . . . .
. . . . .
```

Start:

```text
0 . . . .
. . . . .
. . . . .
. . . . .
. . . . .
```

Move:

```text
0 . . . .
. . 1 . .
. . . . .
. 2 . . .
. . . . .
```

Continue until:

```text
0  ...
...
... 24
```

Every square must be visited exactly once.

---

# 17. Knight's Tour algorithm

```java
boolean solve(
        int[][] board,
        int row,
        int col,
        int move) {

    if (move == n * n) {
        return true;
    }

    for (int i = 0; i < 8; i++) {

        int nextRow = row + dr[i];
        int nextCol = col + dc[i];

        if (!isSafe(nextRow, nextCol)) {
            continue;
        }

        board[nextRow][nextCol] = move;

        if (solve(
                board,
                nextRow,
                nextCol,
                move + 1)) {

            return true;
        }

        board[nextRow][nextCol] = -1;
    }

    return false;
}
```

Again:

```text
choose
 ↓
explore
 ↓
success?
 ↓
NO → undo
```

---

# 18. Why chess problems can explode

Suppose each position has up to 8 possible moves.

At depth `k`:

```text
8^k
```

potential paths.

For a large board, brute-force exploration becomes enormous.

That's where **pruning and heuristics** become important.

---

# 19. A very famous chess pruning idea

Suppose you're playing a game:

```text
Your move
  ↓
Opponent move
  ↓
Your move
  ↓
Opponent move
```

This is **Minimax**.

You search possible game states.

But you don't need to explore every branch.

That's where:

> **Alpha-Beta Pruning**

comes in.

It is a different but related concept from ordinary backtracking.

---

# 20. Alpha-Beta Pruning

Imagine:

```text
                 MAX
              /       \
            MIN       MIN
           /   \      /   \
          5     6    2     ?
```

The first MIN gives:

```text
5
```

MAX currently knows:

```text
best = 5
```

Second MIN already has:

```text
2
```

Since MIN can choose `2`, MAX wouldn't choose this branch if it already has `5`.

Therefore the remaining:

```text
?
```

doesn't matter.

We can **prune** it.

That's alpha-beta pruning.

---

# 21. Ordinary Backtracking vs Alpha-Beta

Don't confuse them.

### Normal backtracking

```text
Find valid solution
```

Example:

```text
N-Queens
Sudoku
Knight's Tour
```

### Minimax + Alpha-Beta

```text
Find best move against an opponent
```

Example:

```text
Chess
Tic-Tac-Toe
Connect Four
```

The underlying idea of cutting off useless branches is similar, but the algorithmic framework is different.

---

# 22. N-Queens vs Sudoku vs Chess

This is a useful comparison:

| Problem       | State      | Choices      | Constraint     | Pruning                 |
| ------------- | ---------- | ------------ | -------------- | ----------------------- |
| N-Queens      | Board      | Column       | Queen attacks  | Unsafe column/diagonal  |
| Sudoku        | Board      | 1-9          | Row/column/box | Invalid number          |
| Knight's Tour | Board      | 8 moves      | Visit once     | Visited/dead end        |
| Word Search   | Grid       | 4 directions | Match word     | Wrong character         |
| Chess         | Game state | Legal moves  | Game rules     | Alpha-beta / heuristics |

---

# 23. The deeper pattern

Now look at all of them:

### N-Queens

```text
State = board + row
Choices = columns
Constraint = queen attack
```

### Sudoku

```text
State = board + empty cell
Choices = numbers 1-9
Constraint = Sudoku rules
```

### Knight's Tour

```text
State = board + current position
Choices = knight moves
Constraint = unvisited cell
```

### Word Search

```text
State = position + word index
Choices = directions
Constraint = matching character
```

### Combination Sum

```text
State = index + remaining target
Choices = candidates
Constraint = target >= 0
```

**They're all the same algorithmic skeleton.**

---

# 24. This is the mental model I want you to use

When you encounter a strange problem in an interview, write this down mentally:

```text
BACKTRACKING

What is my STATE?
       ↓
What are my CHOICES?
       ↓
What makes a choice INVALID?
       ↓
Can I PRUNE?
       ↓
What is the SUCCESS condition?
       ↓
How do I UNDO?
```

For N-Queens:

```text
STATE:
current row

CHOICES:
columns

INVALID:
same column / diagonal

PRUNE:
skip invalid column

SUCCESS:
row == n

UNDO:
remove queen
```

For Sudoku:

```text
STATE:
current empty cell

CHOICES:
1...9

INVALID:
row / column / box

PRUNE:
skip invalid number

SUCCESS:
no empty cell

UNDO:
restore '.'
```

For Knight's Tour:

```text
STATE:
current position + move count

CHOICES:
8 knight moves

INVALID:
outside board / visited

PRUNE:
dead end

SUCCESS:
visited n² cells

UNDO:
mark cell unvisited
```

---

# 25. One advanced idea: ordering your choices

Here's where you move beyond basic FAANG-style backtracking.

Sometimes the order in which you explore choices matters enormously.

For Sudoku:

```text
Choose cell with fewest candidates
```

For Knight's Tour:

> Try the square with the fewest onward moves first.

This is called **Warnsdorff's heuristic**.

For general constraint problems:

> **Choose the most constrained variable first.**

This family of ideas is called **constraint satisfaction / CSP**.

You don't necessarily need to implement a generic CSP framework in interviews, but understanding this principle is valuable.

---

# 26. A useful hierarchy

Think of backtracking skill in levels:

```text
LEVEL 1
Basic Backtracking

Choose
Explore
Undo

        ↓

LEVEL 2
Pruning

Reject invalid branches early

        ↓

LEVEL 3
Efficient State

HashSet
boolean[]
bitmask
visited[]

        ↓

LEVEL 4
Better Choice Ordering

Most constrained first

        ↓

LEVEL 5
Memoization

Cache repeated states

        ↓

LEVEL 6
Game Search

Minimax
Alpha-Beta
Heuristics
```

For product-company interviews, **Levels 1–4 are extremely useful**. Levels 5–6 become important for harder problems and specialized roles.

---

# 27. The three problems I'd actually practice

Don't solve 20 random problems yet.

Master these three:

### 1. N-Queens

Learn:

```text
state
constraint
diagonal indexing
pruning
```

### 2. Sudoku Solver

Learn:

```text
constraint validation
pruning
state mutation
undo
```

### 3. Word Search

Learn:

```text
grid DFS
visited
mark
explore
restore
```

After those, **Knight's Tour** becomes much easier because you're essentially combining grid DFS with stronger constraints.

And then understand **Minimax + Alpha-Beta** separately for chess/game-search problems.

---

## The key realization

Backtracking isn't really about queens, Sudoku, or chess.

It's about this:

```text
                  SEARCH SPACE
                       │
              ┌────────┼────────┐
              ↓        ↓        ↓
            choice   choice   choice
              │
           invalid?
           /      \
         YES       NO
          │         │
       PRUNE        ↓
                recurse
                   │
                failure?
                   │
                   ↓
                 UNDO
                   │
                   ↓
             next choice
```

Once you can look at an unfamiliar problem and identify **state → choices → constraints → pruning → success → undo**, you've learned the actual backtracking pattern rather than just memorizing N-Queens or Sudoku.
