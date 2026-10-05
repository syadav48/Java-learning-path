Absolutely. **Greedy is one of those topics where pattern recognition matters more than memorizing algorithms.** And the biggest interview skill is distinguishing:

> **Greedy vs DP vs Backtracking**

You already have the other two, so now we can connect them.

For FAANG/product interviews, I'd structure Greedy as:

```text
                    GREEDY
                      │
       ┌──────────────┼──────────────┐
       │              │              │
   Selection       Scheduling      Optimization
       │              │              │
   Intervals       Meetings         Profit
   Activity        Jobs             Resources
   Fractional      Tasks            Costs
       │              │              │
       └──────────────┼──────────────┘
                      │
             ┌────────┴────────┐
             │                 │
          Greedy +            Greedy +
          Sorting             Heap
             │                 │
        Intervals         Top available
        Ordering          choice
        Comparators       Scheduling
             │                 │
             └────────┬────────┘
                      │
                  Advanced
                      │
          Two Pointer / Sweep
          Monotonic Stack
          Exchange Argument
```

---

# 1. First: What is Greedy?

The simplest definition:

> **At every step, make the locally best choice, hoping that these choices produce a globally optimal answer.**

Example:

```text
coins = [25, 10, 5, 1]
amount = 41
```

Greedy:

```text
25
10
5
1
```

Total:

```text
4 coins
```

We repeatedly choose:

> Largest coin that doesn't exceed the remaining amount.

---

# 2. But here's the catch

Greedy does **NOT** always work.

Consider:

```text
coins = [1, 3, 4]
amount = 6
```

Greedy:

```text
4
1
1

= 3 coins
```

But optimal:

```text
3
3

= 2 coins
```

So:

> **"Take the best option right now" does not automatically mean greedy is correct.**

This is the most important thing to understand.

---

# 3. Greedy vs DP

This is probably the most important distinction for interviews.

## Greedy

```text
Choose best NOW
       ↓
Never reconsider
       ↓
Continue
```

## DP

```text
Consider multiple possibilities
       ↓
Remember best result for each state
       ↓
Reuse
```

Example:

```text
Coins [1,3,4]
Amount 6
```

Greedy:

```text
take 4
remaining 2
take 1
remaining 1
take 1

3 coins
```

DP explores:

```text
take 1
take 3
take 4
```

and discovers:

```text
3 + 3 = 2
```

---

# 4. The core question

When you see an optimization problem, ask:

> **Can I safely commit to the locally best choice without needing to reconsider it later?**

If yes:

```text
GREEDY candidate
```

If no:

```text
DP / Backtracking / other algorithm
```

---

# 5. The three-way distinction

This is useful given everything you've learned so far.

```text
                 OPTIMIZATION PROBLEM
                         │
             ┌───────────┼───────────┐
             │           │           │
          GREEDY         DP      BACKTRACKING
             │           │           │
        Best choice    Compare      Explore
        right now      states       possibilities
             │           │           │
       Commit forever   Reuse       Undo
```

### Greedy

```text
"Which choice is best NOW?"
```

### DP

```text
"Which combination of decisions gives the best answer?"
```

### Backtracking

```text
"What happens if I try every possible decision?"
```

---

# 6. How do you recognize Greedy?

Look for phrases like:

```text
maximum number of
minimum number of
earliest
latest
smallest
largest
best available
minimum cost
maximum profit
```

But these words **alone don't mean greedy**.

Then look for structural clues:

### Clue 1

The problem asks you to repeatedly make a choice.

```text
Choose one item
Choose next interval
Choose next task
Choose next project
```

### Clue 2

Once you make the choice, it never needs to be undone.

### Clue 3

There is a natural ordering:

```text
sort by:
start
end
profit
deadline
weight
value
```

### Clue 4

The locally optimal choice has a reason it won't hurt the global solution.

That last part is the difficult one.

---

# 7. Greedy has two important properties

For a greedy algorithm to be correct, we generally need:

## Greedy-choice property

A globally optimal solution can be built by making a locally optimal choice first.

## Optimal substructure

After making that choice, the remaining problem is itself an optimal subproblem.

So:

```text
Greedy:
Greedy choice
      ↓
Smaller problem
      ↓
Greedy choice
      ↓
...
```

---

# 8. Pattern 1 — Activity Selection / Interval Scheduling

This is probably the most important classical greedy pattern.

Suppose:

```text
[1,3]
[2,5]
[4,7]
[6,8]
```

You want:

> Maximum number of non-overlapping activities.

What should you sort by?

Not start time.

Not duration.

Sort by:

# Earliest finishing time

```text
[1,3]
[2,5]
[4,7]
[6,8]
```

Choose:

```text
[1,3]
```

Then:

```text
[4,7]
```

Answer:

```text
2
```

---

# 9. Why earliest finish?

Suppose you have:

```text
A: [1,3]
B: [1,10]
```

If you choose B:

```text
timeline blocked until 10
```

If you choose A:

```text
free after 3
```

Therefore:

> The activity that finishes earliest leaves maximum room for future activities.

This is a **greedy proof idea**.

---

# 10. Activity Selection Template

```java
Arrays.sort(intervals,
    Comparator.comparingInt(a -> a[1]));

int count = 0;
int lastEnd = Integer.MIN_VALUE;

for (int[] interval : intervals) {

    if (interval[0] >= lastEnd) {

        count++;

        lastEnd = interval[1];
    }
}
```

Pattern:

```text
INTERVALS
+
MAXIMUM NUMBER OF NON-OVERLAPPING
        ↓
SORT BY END TIME
```

Memorize this.

---

# 11. Problems related to this pattern

* Activity Selection
* Non-overlapping Intervals
* Maximum number of events
* Minimum removals to avoid overlap

For example:

> Minimum intervals to remove to make all intervals non-overlapping.

Instead of directly thinking:

```text
minimum removals
```

think:

```text
maximum intervals I can KEEP
```

Then:

```text
Activity Selection
```

This transformation is very useful.

---

# 12. Pattern 2 — Interval Merging

Now consider:

```text
[1,3]
[2,6]
[8,10]
[9,12]
```

Merge overlapping intervals:

```text
[1,6]
[8,12]
```

This is also greedy-ish, but the pattern is slightly different.

Sort by:

```text
start time
```

Then:

```text
current interval
+
next interval
```

If:

```text
next.start <= current.end
```

merge.

---

# 13. Important distinction

Two interval problems can look almost identical but use different sorting:

```text
Maximum non-overlapping intervals
        ↓
Sort by END
```

```text
Merge overlapping intervals
        ↓
Sort by START
```

This is exactly the type of recognition interviewers test.

---

# 14. Pattern 3 — Minimum Meeting Rooms

You already saw this with Heap.

Intervals:

```text
[0,30]
[5,10]
[15,20]
```

Question:

> Minimum rooms?

This is not simply the Activity Selection pattern.

We need to track:

> When does the earliest room become free?

Therefore:

```text
Sort by start
+
Min Heap of end times
```

So:

```text
GREEDY + HEAP
```

This is a major pattern.

---

# 15. General Scheduling Pattern

Suppose:

```text
tasks arrive
```

At every moment:

> Which available task should I execute?

Then:

```text
Sort by availability
+
PriorityQueue for best available choice
```

This gives:

```text
GREEDY + HEAP
```

Examples:

* Single Threaded CPU
* Meeting Rooms II
* Task Scheduler variants
* IPO
* Minimum Cost to Hire Workers
* Furthest Building You Can Reach

---

# 16. Pattern 4 — Fractional Knapsack

Suppose:

```text
weight    value
10        60
20        100
30        120
```

Capacity:

```text
50
```

Unlike 0/1 Knapsack, you can take fractions.

Calculate:

```text
value / weight
```

```text
60/10 = 6
100/20 = 5
120/30 = 4
```

Take highest ratio first.

```text
10 → 60
20 → 100
20/30 → 80
```

Total:

```text
240
```

This is classic greedy.

---

# 17. Why Fractional Knapsack is Greedy but 0/1 isn't

This is a very important DP-vs-Greedy comparison.

### Fractional

You can split an item.

Therefore:

```text
highest value/weight
```

can safely be taken first.

### 0/1

You must take the entire item or nothing.

A locally attractive item may block a better combination.

Therefore:

```text
0/1 → DP
Fractional → Greedy
```

Excellent interview example.

---

# 18. Pattern 5 — Jump Game

Given:

```text
[2,3,1,1,4]
```

Each number represents maximum jump length.

Can you reach the end?

At every position, maintain:

```text
farthest reachable index
```

Example:

```text
index:    0 1 2 3 4
nums:     2 3 1 1 4
```

Start:

```text
farthest = 2
```

At index 1:

```text
1 + 3 = 4
```

Now:

```text
farthest = 4
```

We can reach the end.

This is greedy.

---

# 19. Jump Game recognition

When the question asks:

> Can I reach the end?

Think:

```text
Maintain farthest reachable position.
```

Greedy state:

```text
farthest
```

No need to remember every possible path.

---

# 20. Jump Game II

Now:

> Minimum number of jumps?

Still greedy.

Maintain:

```text
currentEnd
farthest
jumps
```

Think of each jump as covering a range.

```text
Current jump:
[0 ........ currentEnd]

Explore all positions inside it.

Find:
farthest reachable from this range.

Then:
commit to next jump.
```

This is similar to BFS levels, but optimized into a greedy range expansion.

---

# 21. Pattern 6 — Gas Station

Classic greedy problem.

```text
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
```

Question:

> Find starting station that lets you complete the circuit.

Key observation:

If:

```text
currentTank < 0
```

after trying from `start` to `i`, then:

```text
none of start...i
```

can be the valid starting point.

So:

```text
start = i + 1
```

This is a powerful greedy elimination pattern.

---

# 22. Gas Station mental model

Maintain:

```text
totalGas
totalCost
currentTank
start
```

If:

```text
totalGas < totalCost
```

answer:

```text
-1
```

Otherwise:

```text
if currentTank < 0:
    start = i + 1
    currentTank = 0
```

Why is this greedy?

Because when an entire segment fails, you can eliminate every candidate inside that segment.

---

# 23. Pattern 7 — Two Pointer + Greedy

Greedy isn't always:

```text
sort + loop
```

Sometimes it's:

```text
two pointers
+
locally optimal choice
```

Classic:

# Assign Cookies

Children:

```text
[1,2,3]
```

Cookies:

```text
[1,1]
```

Sort both.

Give the smallest cookie that satisfies the least-demanding child.

This maximizes the number of satisfied children.

---

# 24. Another famous example — Boats to Save People

People:

```text
[3,2,2,1]
```

Boat capacity:

```text
3
```

Sort:

```text
[1,2,2,3]
```

Use:

```text
lightest + heaviest
```

If they fit:

```text
left++
right--
```

Otherwise:

```text
heaviest alone
right--
```

Why?

The heaviest person must go.

The best possible partner for them is the lightest person.

That's greedy + two pointers.

---

# 25. Pattern 8 — Huffman Coding / Repeated Minimum

You saw this with Heap.

Given:

```text
[4,3,2,6]
```

Repeatedly combine two smallest.

```text
2 + 3 = 5
4 + 5 = 9
6 + 9 = 15
```

Total:

```text
29
```

Pattern:

```text
Repeatedly choose smallest
        ↓
Min Heap
```

This appears in:

* Connect Ropes
* Huffman Coding
* Merge files
* Optimal merge pattern

---

# 26. Pattern 9 — Maximum/Minimum Resource

Sometimes greedy asks:

> How can I use the minimum resources?

or:

> How can I maximize something under constraints?

Often the pattern is:

```text
Sort
+
maintain some best/current resource
```

Examples:

* Minimum arrows to burst balloons
* Assign cookies
* Boats
* Minimum platforms
* Meeting rooms
* Gas station

---

# 27. Pattern 10 — Deadline + Profit

Classic:

# Job Sequencing with Deadlines

Suppose:

```text
Job    deadline   profit

A        2         100
B        1          19
C        2          27
D        1          25
E        3          15
```

You want maximum profit.

General idea:

```text
Sort jobs by profit descending
```

Then place each job into the latest available slot before its deadline.

Why latest?

Because it preserves earlier slots for jobs with tighter deadlines.

This is a beautiful greedy principle:

> **When assigning a task to a deadline, use the latest possible slot to preserve earlier slots.**

---

# 28. Pattern 11 — Minimum Arrows / Interval Covering

Balloons:

```text
[10,16]
[2,8]
[1,6]
[7,12]
```

One arrow can burst overlapping balloons.

Sort by end.

Keep the current arrow position at the earliest ending interval.

If next interval starts after arrow:

```text
need another arrow
```

Pattern:

```text
Interval covering
+
minimum resources
        ↓
Sort by END
```

---

# 29. Pattern 12 — Minimum Platforms

Train arrivals/departures.

You want minimum platforms so no train waits.

Sort:

```text
arrival[]
departure[]
```

Use two pointers:

```text
arrival[i] <= departure[j]
```

Need another platform.

Otherwise:

```text
departure
```

frees one.

This is:

```text
Sorting
+
Two pointers
+
Greedy
```

---

# 30. Pattern 13 — Lexicographically Smallest/Largest

Greedy also appears in strings.

For example:

> Remove K digits to make the smallest number.

Given:

```text
1432219
k = 3
```

Answer:

```text
1219
```

The key greedy idea:

> If the current digit is larger than the next digit, removing the current digit improves the number.

This naturally leads to:

```text
Monotonic Stack
```

So:

```text
Greedy
+
Monotonic Stack
```

This is an important advanced pattern.

---

# 31. Monotonic Stack + Greedy

Typical problems:

* Remove K Digits
* Next Greater Element
* Daily Temperatures
* Largest Rectangle in Histogram
* Stock Span
* Remove duplicate letters

The data structure maintains a useful ordering so that locally bad elements are removed.

For example:

```text
1 4 3
```

If trying to minimize number and:

```text
4 > 3
```

4 is a candidate for removal.

---

# 32. Pattern 14 — Greedy + Sorting

This is probably the most common implementation.

General form:

```java
Arrays.sort(items);

for (item : items) {

    if (canTake(item)) {
        take(item);
    }
}
```

But the important question is:

> **What should I sort by?**

That is usually the entire problem.

Examples:

```text
Activity Selection
→ end time
```

```text
Merge Intervals
→ start time
```

```text
Fractional Knapsack
→ value/weight descending
```

```text
Job Sequencing
→ profit descending
```

```text
Meeting scheduling
→ start time + heap
```

---

# 33. Pattern 15 — Greedy + Heap

You've already learned this pattern.

General form:

```text
Sort by when things become available
             ↓
Put available choices into heap
             ↓
Take best available choice
             ↓
Repeat
```

Examples:

```text
IPO
Single Threaded CPU
Meeting Rooms
Task Scheduling
Minimum Cost problems
```

This is one of the most useful combinations for product-company interviews.

---

# 34. Pattern 16 — Greedy + DSU

Less common but important.

Example:

# Kruskal's MST

Sort edges by weight:

```text
smallest → largest
```

Then:

```text
if union(u,v) succeeds:
    take edge
else:
    skip
```

This is:

```text
Greedy
+
DSU
```

Why?

Always take the cheapest edge that doesn't create a cycle.

---

# 35. Pattern 17 — Greedy + Graph

Dijkstra is an interesting example.

At every step:

> Choose the unprocessed node with the smallest known distance.

That's a greedy choice.

But it only works because:

```text
edge weights >= 0
```

Therefore:

```text
Dijkstra
=
Graph
+
Greedy
+
Min Heap
```

This is a very useful connection.

---

# 36. Pattern 18 — Exchange Argument

This is more advanced, but it's how you **prove** many greedy algorithms.

Suppose your algorithm chooses:

```text
A
```

but an optimal solution chooses:

```text
B
```

If you can replace:

```text
B → A
```

without making the solution worse, then you can transform an optimal solution into one that agrees with your greedy choice.

That's called an:

# Exchange Argument

Activity selection is a classic example.

Greedy chooses earliest finish:

```text
A
```

Suppose optimal solution chose:

```text
B
```

Since A finishes no later than B:

```text
end(A) <= end(B)
```

replace B with A.

The rest of the optimal schedule remains possible.

Therefore:

```text
Greedy choice is safe.
```

---

# 37. Why this matters in interviews

You may be asked:

> "Why does your greedy solution work?"

Don't just say:

> "Because we always choose the best option."

That's not a proof.

Instead say:

> "The greedy choice is safe because I can replace the corresponding choice in any optimal solution without reducing the quality of the solution."

That's a much stronger interview explanation.

---

# 38. Greedy vs DP — Detailed Comparison

|                      | Greedy                              | DP                                |
| -------------------- | ----------------------------------- | --------------------------------- |
| Decision             | Local best                          | Compare possibilities             |
| Reconsider decision? | No                                  | Effectively yes                   |
| Store states?        | Usually no                          | Yes                               |
| Subproblems          | Usually not overlapping in same way | Overlapping                       |
| Proof                | Greedy-choice property              | Recurrence + optimal substructure |
| Typical              | Sorting, intervals, heap            | Knapsack, strings, sequences      |
| Complexity           | Often O(n log n)                    | Often O(n²), O(n·capacity)        |
| Example              | Activity Selection                  | 0/1 Knapsack                      |

---

# 39. The classic Greedy vs DP examples

These are worth memorizing because interviewers love the distinction.

### Coin Change

```text
General denomination:
→ DP
```

### Fractional Knapsack

```text
→ Greedy
```

### 0/1 Knapsack

```text
→ DP
```

### Activity Selection

```text
→ Greedy
```

### Weighted Interval Scheduling

```text
→ DP
```

This last pair is particularly important.

---

# 40. Why weighted interval scheduling is DP

Intervals:

```text
start   end   profit
1       3      50
2       5      100
4       6      70
```

If you simply choose earliest finishing interval, you may lose a much more profitable combination.

Now you have to decide:

```text
Take interval
OR
skip interval
```

and if you take it:

```text
jump to the next compatible interval
```

This becomes:

```text
dp[i] =
max(
    skip current,
    profit[current] + dp[nextCompatible]
)
```

That's DP.

Beautiful distinction:

```text
Unweighted interval scheduling
→ Greedy

Weighted interval scheduling
→ DP
```

---

# 41. Another important distinction: Jump Game

### Jump Game I

```text
Can I reach?
```

Greedy.

### Some richer Jump Game variants

If you need:

```text
number of ways
minimum cost
different state constraints
```

you may need:

```text
DP / BFS / heap
```

So don't memorize:

> "Jump Game = Greedy."

Instead understand:

> **What information determines the future?**

---

# 42. Greedy Recognition Flowchart

Use this during interviews:

```text
                  OPTIMIZATION PROBLEM
                           │
                           ▼
                 Can I make a decision
                   at each step?
                      /        \
                    NO          YES
                    │            │
                 DP/etc          ▼
                         Is there an obviously
                         safe local choice?
                           /          \
                         NO            YES
                         │              │
                        DP        Greedy candidate
                                      │
                                      ▼
                              Can I prove the
                              choice is safe?
                                /       \
                              NO         YES
                              │           │
                          DP/etc       GREEDY
```

The phrase:

# "safe local choice"

is the key.

---

# 43. Another recognition flow

```text
Problem
  │
  ├── Intervals?
  │      │
  │      ├── maximize non-overlap
  │      │      → sort by END
  │      │
  │      ├── merge overlaps
  │      │      → sort by START
  │      │
  │      └── minimum resources
  │             → sort + heap
  │
  ├── Repeatedly choose best available?
  │      → Greedy + Heap
  │
  ├── Can split item?
  │      → Fractional Greedy
  │
  ├── Reachability/range?
  │      → Greedy / Two Pointer
  │
  ├── Need smallest/largest ordering?
  │      → Sort + Greedy
  │
  ├── Minimum/maximum but choices interact?
  │      → Check DP
  │
  └── Need explore multiple possibilities?
         → Backtracking / DP
```

---

# 44. Common Greedy Mistakes

## Mistake 1 — Assuming local optimum is globally optimal

This is the biggest one.

```text
"Take largest"
"Take smallest"
"Take earliest"
```

doesn't automatically mean correct.

You need a reason.

---

# 45. Mistake 2 — Using Greedy for 0/1 Knapsack

This is a classic trap.

Sorting by:

```text
value
weight
value/weight
```

doesn't guarantee optimality.

Use:

```text
DP
```

for standard 0/1 Knapsack.

---

# 46. Mistake 3 — Using Greedy for arbitrary Coin Change

Again:

```text
coins = [1,3,4]
amount = 6
```

Greedy:

```text
4+1+1
```

optimal:

```text
3+3
```

Use DP for arbitrary denominations.

---

# 47. Mistake 4 — Choosing the wrong interval sorting

This is extremely common.

```text
Maximum non-overlap
→ END

Merge intervals
→ START
```

Don't mix them.

---

# 48. Mistake 5 — Sorting when original order matters

Some problems have a sequence where you are not allowed to reorder.

Greedy sorting can destroy the problem structure.

Always ask:

> **Am I allowed to reorder the elements?**

If no, be careful.

---

# 49. Mistake 6 — Forgetting equal boundaries

Intervals:

```text
[1,3]
[3,5]
```

Can they coexist?

Depends on the problem.

If:

```text
end <= start
```

is allowed:

```text
YES
```

If overlap at the endpoint counts:

```text
NO
```

Interviewers love these boundary conditions.

---

# 50. Mistake 7 — Confusing "minimum" with "greedy"

Just because the question says:

> minimum

doesn't mean greedy.

Examples:

```text
Minimum coins
→ DP

Minimum path cost
→ DP / Dijkstra

Minimum meeting rooms
→ Greedy + Heap

Minimum arrows
→ Greedy
```

The structure determines the algorithm.

---

# 51. Mistake 8 — Overcomplicating a greedy problem with DP

Suppose:

> Select maximum number of non-overlapping intervals.

You could formulate DP:

```text
dp[i]
```

But greedy is simpler:

```text
sort by end
```

Good interview skill means recognizing the simpler correct algorithm.

---

# 52. Level-wise Greedy Preparation

I'd prepare Greedy like this.

## Level 1 — Basic Greedy

Master:

```text
1. Assign Cookies
2. Lemonade Change
3. Best Time to Buy/Sell Stock I
4. Jump Game
5. Jump Game II
```

Learn:

```text
local decision
farthest
two pointers
```

---

## Level 2 — Interval Greedy

```text
6. Activity Selection
7. Non-overlapping Intervals
8. Merge Intervals
9. Minimum Number of Arrows
10. Meeting Rooms
11. Meeting Rooms II
```

Master:

```text
sort by start
sort by end
heap for active intervals
```

---

## Level 3 — Sorting + Greedy

```text
12. Fractional Knapsack
13. Boats to Save People
14. Assign Cookies
15. Minimum Platforms
16. Gas Station
```

Master:

```text
sort
two pointers
elimination
```

---

## Level 4 — Heap + Greedy

```text
17. IPO
18. Task Scheduler
19. Single Threaded CPU
20. Furthest Building You Can Reach
21. Minimum Cost to Hire Workers
22. Connect Ropes
```

Master:

```text
available choices
+
best current choice
```

---

## Level 5 — Advanced Greedy

```text
23. Job Sequencing
24. Remove K Digits
25. Reorganize String
26. Partition Labels
27. Candy
28. Huffman Coding
29. Kruskal
30. Dijkstra
```

Now you start seeing:

```text
Greedy
+
Stack
Greedy
+
Heap
Greedy
+
DSU
Greedy
+
Graph
```

---

# 53. Greedy Pattern Map

Keep this:

```text
                         GREEDY
                           │
          ┌────────────────┼─────────────────┐
          │                │                 │
       SORTING           HEAP            TWO POINTER
          │                │                 │
      Intervals        Scheduling         Boats
      Activity          IPO               Cookies
      Fractional       CPU               Platforms
      Job Sequencing   Resources
          │                │
          └────────────────┼─────────────────┐
                           │                 │
                       STACK              GRAPH
                           │                 │
                       Remove K           Dijkstra
                       Digits             Kruskal
                       Monotonic          Prim
                           │
                           │
                      ADVANCED
                           │
                 Exchange Argument
                 Greedy Proof
```

---

# 54. The most important Greedy patterns to memorize

If you only remember these:

```text
1. Sort + choose
```

```text
2. Sort by END
   → interval scheduling
```

```text
3. Sort by START
   → interval merging
```

```text
4. Sort + Heap
   → scheduling/resources
```

```text
5. Two Pointer + Greedy
   → pairing/assignment
```

```text
6. Repeated minimum/maximum
   → Heap
```

```text
7. Farthest reachable
   → Jump Game
```

```text
8. Eliminate impossible candidates
   → Gas Station
```

```text
9. Greedy + Monotonic Stack
   → lexicographic/minimum sequence
```

```text
10. Greedy + DSU
    → Kruskal/MST
```

```text
11. Greedy + Graph
    → Dijkstra
```

---

# 55. The deeper connection with your previous topics

Now your DSA map is becoming quite powerful:

```text
ARRAY
   ↓
Two Pointer / Sliding Window / Prefix

LINKED LIST
   ↓
Fast-Slow / Reverse / Dummy

TREE
   ↓
DFS / BFS / Tree DP

GRAPH
   ↓
DFS / BFS / Dijkstra / DSU / Topological

QUEUE
   ↓
BFS / Multi-source / Deque

HEAP
   ↓
Top-K / Scheduling / Best Available

BACKTRACKING
   ↓
Choose → Explore → Undo

DP
   ↓
State → Transition → Reuse

GREEDY
   ↓
Choose → Prove → Commit
```

That last line is worth remembering:

# DP

```text
Choose → compare possibilities → remember
```

# Greedy

```text
Choose → prove choice is safe → commit
```

# Backtracking

```text
Choose → explore → undo
```

These three are often the hardest to distinguish in interviews.

---

# 56. The ultimate Greedy vs DP checklist

When you encounter a new optimization problem:

### Step 1

Ask:

> Can I make a decision sequentially?

If no:

```text
DP / graph / math / etc.
```

If yes:

```text
continue
```

### Step 2

Ask:

> Is there a naturally best local choice?

If yes:

```text
greedy candidate
```

### Step 3

Ask:

> If I make this choice, can I prove I never need to undo it?

If yes:

```text
GREEDY
```

If no:

```text
DP / backtracking
```

### Step 4

Ask:

> Does the same subproblem/state occur repeatedly?

If yes:

```text
DP
```

### Step 5

Ask:

> Am I exploring possibilities because multiple choices may matter?

If yes:

```text
Backtracking / DP
```

---

# 57. One final interview-level example

Suppose interviewer gives:

> Given jobs with start time, end time and profit, maximize total profit without overlapping jobs.

Your thought process should be:

```text
Jobs
 ↓
Intervals
 ↓
Non-overlap
 ↓
But there is PROFIT
 ↓
Can I simply choose earliest ending?
```

No.

Because:

```text
earliest ending ≠ highest profit
```

So:

```text
Weighted Interval Scheduling
        ↓
DP
```

Now change the question:

> Maximize the number of non-overlapping jobs.

Now:

```text
No profit
 ↓
Every job has equal value
 ↓
Earliest finish is safe
 ↓
Greedy
```

That's exactly the kind of distinction a product-company interviewer is looking for.

---

# 58. Your Greedy "cheat sheet"

```text
GREEDY
│
├── Activity Selection
│     → sort by END
│
├── Merge Intervals
│     → sort by START
│
├── Non-overlap removal
│     → maximize intervals kept
│     → END
│
├── Interval covering
│     → END
│
├── Meeting Rooms
│     → START + Heap
│
├── Fractional Knapsack
│     → value/weight
│
├── 0/1 Knapsack
│     → NOT greedy → DP
│
├── Coin Change
│     → generally DP
│
├── Jump Game
│     → farthest reachable
│
├── Gas Station
│     → eliminate failed starts
│
├── Boats
│     → sort + two pointers
│
├── Cookies
│     → sort + two pointers
│
├── Scheduling
│     → sort + Heap
│
├── Connect Ropes
│     → Min Heap
│
├── Remove K Digits
│     → Greedy + Monotonic Stack
│
├── Kruskal
│     → sort + DSU
│
└── Dijkstra
      → Min Heap + Greedy
```

The **single most important rule** I'd carry into interviews is:

> **Don't ask "Does this look like Greedy?" Ask "What is my local choice, and why is it safe to permanently commit to it?"**

If you can answer that second part rigorously, you probably have a genuine greedy solution rather than a greedy-looking heuristic.
