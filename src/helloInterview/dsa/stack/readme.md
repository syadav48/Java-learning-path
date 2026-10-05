Absolutely. I'll keep **exactly the same documentation flow** we used for Two Pointer, Bit Manipulation, and Sliding Window.

# Stack — Complete Interview Deep Dive

Stack is deceptively simple:

> **LIFO — Last In, First Out.**

But in interviews, Stack is much more than `push()` and `pop()`.

The important part is recognizing the **patterns built on top of Stack**:

```text
Stack
 ├── Matching / Parentheses
 ├── Expression Evaluation
 ├── Monotonic Stack
 │    ├── Next Greater
 │    ├── Next Smaller
 │    ├── Previous Greater
 │    └── Previous Smaller
 ├── Histogram / Rectangle
 ├── Boundary / Contribution
 ├── Simulation
 ├── Stack + Greedy
 ├── Stack + String
 ├── Stack + DFS
 └── Stack + DP
```

The biggest interview payoff comes from **Monotonic Stack**.

---

# 1. Core Mental Model

A Stack supports:

```text
push
pop
peek
```

with:

```text
O(1)
```

The defining property:

```text
TOP
 ↓
[ 5 ]
[ 3 ]
[ 8 ]
[ 2 ]
 ↑
BOTTOM
```

If we push:

```text
7
```

we get:

```text
[7] ← top
[5]
[3]
[8]
[2]
```

Pop removes:

```text
7
```

Then:

```text
5
```

So:

> **The most recently added element is the first one removed.**

---

# 2. Why Does Stack Matter in DSA?

The interesting question isn't:

> "Where can I use LIFO?"

Instead ask:

> **What information from the past do I need to preserve until some future element tells me what to do with it?**

That's where Stack becomes powerful.

Example:

```text
[2, 1, 5]
```

Suppose we are waiting to know:

> What is the next greater element for `2`?

We don't know yet.

So we keep `2` somewhere.

Then:

```text
5
```

arrives.

Now we know:

```text
2 → 5
1 → 5
```

A stack can efficiently maintain these unresolved elements.

That idea leads directly to **Monotonic Stack**.

---

# 3. Java Stack Choices

You will see:

```java
Stack<Integer>
```

but for modern Java, prefer:

```java
Deque<Integer> stack = new ArrayDeque<>();
```

because `Stack` is an older synchronized class.

### Template

```java
Deque<Integer> stack = new ArrayDeque<>();

stack.push(x);
stack.pop();
stack.peek();
```

Complexity:

```text
push → O(1)
pop  → O(1)
peek → O(1)
```

---

# 4. Pattern 1 — Basic Stack / LIFO

The simplest problems directly model a stack.

Examples:

- Reverse data
- Undo operations
- Browser history
- Backtracking state
- DFS
- Parentheses
- Expression evaluation

Mental model:

```text
PUSH → PUSH → PUSH → POP → POP
```

---

# 5. Pattern 2 — Matching / Balanced Parentheses

This is the first major interview pattern.

Given:

```text
"({[]})"
```

we need to verify matching pairs.

When opening bracket arrives:

```text
(
[
{
```

push it.

When closing bracket arrives:

```text
)
]
}
```

check whether it matches the top.

---

## Template

```java
public boolean isValid(String s) {

    Deque<Character> stack = new ArrayDeque<>();

    for (char ch : s.toCharArray()) {

        if (ch == '(' || ch == '[' || ch == '{') {
            stack.push(ch);
        } else {

            if (stack.isEmpty()) {
                return false;
            }

            char top = stack.pop();

            if ((ch == ')' && top != '(') ||
                (ch == ']' && top != '[') ||
                (ch == '}' && top != '{')) {

                return false;
            }
        }
    }

    return stack.isEmpty();
}
```

---

# 6. Why Stack Works for Parentheses

Consider:

```text
{ [ ( ) ] }
```

The most recently opened bracket must be the first one closed.

```text
open {
open [
open (
```

Then:

```text
)
```

must match:

```text
(
```

That's exactly:

```text
LIFO
```

So the recognition signal is:

> **Nested / matching / properly closed → Stack**

---

# 7. Parentheses Recognition

When you see:

```text
valid parentheses
balanced brackets
nested expressions
matching symbols
properly nested
remove invalid parentheses
```

think:

```text
STACK
```

---

# 8. Pattern 3 — Stack for Removing Adjacent Elements

Sometimes the stack represents the **current valid result**.

Example:

```text
"abbaca"
```

Remove adjacent duplicates.

Process:

```text
a
```

stack:

```text
[a]
```

Next:

```text
b
```

```text
[a,b]
```

Next:

```text
b
```

matches top → pop:

```text
[a]
```

Continue.

---

## Template

```java
Deque<Character> stack = new ArrayDeque<>();

for (char ch : s.toCharArray()) {

    if (!stack.isEmpty() && stack.peek() == ch) {
        stack.pop();
    } else {
        stack.push(ch);
    }
}
```

The stack becomes:

> **The answer constructed so far.**

This is an important general pattern.

---

# 9. Pattern 4 — Stack as "Undo"

Stack is excellent when an operation may need to be reversed.

Examples:

```text
Browser back
Undo
Text editor
Path simplification
Remove adjacent duplicates
Backtracking
```

Mental model:

```text
DO
 ↓
PUSH STATE

UNDO
 ↓
POP STATE
```

---

# 10. Pattern 5 — Evaluate Expressions

Stack can evaluate:

```text
2 + 3 * 4
```

or postfix:

```text
2 3 4 * +
```

or prefix:

```text
+ 2 * 3 4
```

Classic interview problems include:

- Evaluate Reverse Polish Notation
- Basic Calculator
- Basic Calculator II
- Decode String

---

# 11. Reverse Polish Notation

Expression:

```text
2 1 + 3 *
```

means:

```text
(2 + 1) * 3
```

Process:

```text
2 → push
1 → push
+ → pop 1, pop 2 → 3 → push
3 → push
* → pop 3, pop 3 → 9
```

---

## Template

```java
Deque<Integer> stack = new ArrayDeque<>();

for (String token : tokens) {

    if (isNumber(token)) {

        stack.push(Integer.parseInt(token));

    } else {

        int b = stack.pop();
        int a = stack.pop();

        int result;

        switch (token) {
            case "+":
                result = a + b;
                break;

            case "-":
                result = a - b;
                break;

            case "*":
                result = a * b;
                break;

            default:
                result = a / b;
        }

        stack.push(result);
    }
}

return stack.pop();
```

Important:

```text
a = second popped
b = first popped
```

because:

```text
a - b
```

is not the same as:

```text
b - a
```

---

# 12. Pattern 6 — Decode String

Classic:

```text
3[a2[c]]
```

Output:

```text
accaccacc
```

This has nested state.

Whenever we see:

```text
[
```

we need to save the current state.

Whenever we see:

```text
]
```

we restore it.

Stack is ideal.

Recognition:

> **Nested structure + need to return to previous state → Stack**

---

# 13. Pattern 7 — Monotonic Stack

Now we reach the **most important Stack pattern**.

A monotonic stack maintains elements in:

```text
increasing order
```

or:

```text
decreasing order
```

Example:

```text
[1, 3, 2, 4]
```

A decreasing stack might look like:

```text
4
2
1
```

depending on the processing stage.

The key idea:

> **When a new element invalidates previous elements, pop them.**

---

# 14. Why Monotonic Stack?

Suppose:

```text
[2, 1, 5]
```

We want:

> Next greater element for every element.

Brute force:

```text
2 → scan right
1 → scan right
5 → scan right
```

Potentially:

```text
O(n²)
```

Instead, maintain unresolved elements.

```text
2
```

then:

```text
1
```

Stack:

```text
[2,1]
```

Now `5` arrives.

`5 > 1`:

```text
1 → 5
```

Pop.

`5 > 2`:

```text
2 → 5
```

Pop.

Then:

```text
5
```

remains unresolved.

This gives:

```text
O(n)
```

---

# 15. The Core Monotonic Stack Template

For **Next Greater Element**:

```java
Deque<Integer> stack = new ArrayDeque<>();

for (int i = 0; i < nums.length; i++) {

    while (!stack.isEmpty()
            && nums[stack.peek()] < nums[i]) {

        int index = stack.pop();

        // nums[i] is next greater for index
    }

    stack.push(i);
}
```

Notice:

> Store **indices**, not values, when you need positions.

This is extremely important.

---

# 16. Why Is It O(n) If There Is a While Loop?

This is the same amortized-analysis idea we saw in Sliding Window.

Every element:

```text
push → at most once
pop  → at most once
```

Therefore:

```text
O(n + n)
=
O(n)
```

not:

```text
O(n²)
```

This is a common interview question.

---

# 17. The Four Fundamental Monotonic Stack Problems

You should memorize this matrix:

| Question | Stack |
|---|---|
| Next Greater | Decreasing stack |
| Next Smaller | Increasing stack |
| Previous Greater | Decreasing stack |
| Previous Smaller | Increasing stack |

But be careful: whether the stack is described as increasing/decreasing depends on exactly what you store and how you phrase the invariant.

The safest approach is:

> **Derive the `while` condition from what you are waiting to find.**

---

# 18. Next Greater Element

Example:

```text
[2,1,2,4,3]
```

Answer:

```text
[4,2,4,-1,-1]
```

For each element:

> Find first greater element on the right.

Template:

```java
int[] result = new int[nums.length];
Arrays.fill(result, -1);

Deque<Integer> stack = new ArrayDeque<>();

for (int i = 0; i < nums.length; i++) {

    while (!stack.isEmpty()
            && nums[stack.peek()] < nums[i]) {

        result[stack.pop()] = nums[i];
    }

    stack.push(i);
}
```

---

# 19. Next Smaller Element

Now:

> Find first smaller element on the right.

Change:

```java
nums[stack.peek()] > nums[i]
```

```java
while (!stack.isEmpty()
        && nums[stack.peek()] > nums[i]) {

    result[stack.pop()] = nums[i];
}
```

Same framework.

Only the comparison changes.

This is a huge pattern-recognition shortcut.

---

# 20. Previous Greater

Instead of looking right, process direction/invariant accordingly.

One common approach:

```java
for (int i = 0; i < n; i++) {

    while (!stack.isEmpty()
            && nums[stack.peek()] <= nums[i]) {
        stack.pop();
    }

    if (!stack.isEmpty()) {
        result[i] = nums[stack.peek()];
    }

    stack.push(i);
}
```

The top after popping represents the nearest valid previous greater element.

---

# 21. Previous Smaller

Same idea:

```java
while (!stack.isEmpty()
        && nums[stack.peek()] >= nums[i]) {

    stack.pop();
}
```

Then:

```java
if (!stack.isEmpty()) {
    result[i] = nums[stack.peek()];
}
```

---

# 22. The Most Important Recognition Signal

If a problem says:

```text
next greater
next smaller
previous greater
previous smaller
nearest greater
nearest smaller
first larger on the right
first smaller on the left
```

your brain should immediately say:

```text
MONOTONIC STACK
```

---

# 23. Pattern 8 — Circular Array + Monotonic Stack

Example:

```text
[1,2,1]
```

Circular means after the last element we return to the beginning.

A common trick:

```text
process 2*n elements
```

using:

```java
nums[i % n]
```

Template:

```java
for (int i = 2 * n - 1; i >= 0; i--) {

    int value = nums[i % n];

    while (!stack.isEmpty()
            && stack.peek() <= value) {
        stack.pop();
    }

    if (i < n) {
        result[i] =
            stack.isEmpty() ? -1 : stack.peek();
    }

    stack.push(value);
}
```

Classic problem:

> Next Greater Element II

---

# 24. Pattern 9 — Daily Temperatures

Very famous.

Input:

```text
[73,74,75,71,69,72,76,73]
```

For each day:

> How many days until a warmer temperature?

This is really:

```text
Next Greater Element
```

but answer wants:

```text
distance
```

So store indices.

```java
int[] answer = new int[temperatures.length];

Deque<Integer> stack = new ArrayDeque<>();

for (int i = 0; i < temperatures.length; i++) {

    while (!stack.isEmpty()
            && temperatures[stack.peek()] < temperatures[i]) {

        int prev = stack.pop();

        answer[prev] = i - prev;
    }

    stack.push(i);
}
```

This problem is extremely important because it teaches:

> **Monotonic stack + indices = distance to next boundary.**

---

# 25. Pattern 10 — Stock Span

Given:

```text
[100,80,60,70,60,75,85]
```

For each day:

> How many consecutive previous days had price ≤ today's price?

Again:

```text
Previous Greater
```

So maintain a monotonic stack.

This demonstrates an important principle:

> Many seemingly different problems are actually the same nearest-greater/smaller pattern.

---

# 26. Pattern 11 — Largest Rectangle in Histogram

One of the most important stack problems.

Given:

```text
[2,1,5,6,2,3]
```

Find largest rectangle.

Answer:

```text
10
```

because:

```text
5 × 2 = 10
```

using bars:

```text
5,6
```

---

# 27. Why Stack Works for Histogram

For every bar, we need:

```text
nearest smaller on left
nearest smaller on right
```

Then:

```text
width =
rightSmaller - leftSmaller - 1
```

and:

```text
area =
height × width
```

This turns:

```text
Histogram
```

into:

```text
Nearest Smaller Element
+
Stack
```

This is a huge interview pattern.

---

# 28. Histogram Template

A common implementation uses a sentinel:

```java
public int largestRectangleArea(int[] heights) {

    Deque<Integer> stack = new ArrayDeque<>();

    int maxArea = 0;

    for (int i = 0; i <= heights.length; i++) {

        int current =
            (i == heights.length) ? 0 : heights[i];

        while (!stack.isEmpty()
                && current < heights[stack.peek()]) {

            int height = heights[stack.pop()];

            int left =
                stack.isEmpty() ? -1 : stack.peek();

            int width = i - left - 1;

            maxArea =
                Math.max(maxArea, height * width);
        }

        stack.push(i);
    }

    return maxArea;
}
```

The sentinel `0` forces remaining bars to be processed.

---

# 29. Histogram Mental Model

For every bar:

```text
       height
         |
         |
     |   |   |
     |   |   |
-----|---|---|-----
     ← width →
```

Find:

```text
nearest smaller left
nearest smaller right
```

Then:

```text
area =
height × width
```

This is one of the most reusable stack transformations.

---

# 30. Pattern 12 — Maximal Rectangle

Now take a binary matrix:

```text
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
```

For each row, convert it into histogram heights.

Example:

```text
row 1:
1 0 1 1 1

heights:
1 0 1 1 1
```

Next row:

```text
1 1 1 2 2
```

Then run:

```text
Largest Rectangle in Histogram
```

So:

```text
Maximal Rectangle
=
Histogram
+
Monotonic Stack
```

This is a classic advanced combination.

---

# 31. Pattern 13 — Remove K Digits

Problem:

```text
num = "1432219"
k = 3
```

Want the smallest possible number.

Greedy idea:

> If the current digit is smaller than the previous digit, remove the previous larger digit.

Use a monotonic increasing stack.

```java
Deque<Character> stack = new ArrayDeque<>();

for (char ch : num.toCharArray()) {

    while (!stack.isEmpty()
            && k > 0
            && stack.peek() > ch) {

        stack.pop();
        k--;
    }

    stack.push(ch);
}
```

Then remove remaining digits if:

```text
k > 0
```

This is:

```text
Monotonic Stack
+
Greedy
```

Very important.

---

# 32. Pattern 14 — Remove Duplicate Letters

Problem:

> Remove duplicate characters so every letter appears once and result is lexicographically smallest.

This uses:

```text
Stack
+
Greedy
+
Frequency
+
Visited
```

The general idea:

If:

```text
current < stack.top
```

and the top character occurs again later:

```text
pop top
```

This is a more advanced version of the same:

> **Remove a previous choice if a better future choice exists.**

---

# 33. Pattern 15 — Lexicographically Smallest String

Whenever you see:

```text
remove K elements
lexicographically smallest
keep best order
delete previous larger elements
```

consider:

```text
MONOTONIC STACK + GREEDY
```

Classic problems:

- Remove K Digits
- Remove Duplicate Letters
- Most competitive subsequence problems
- Smallest subsequence of distinct characters

---

# 34. Pattern 16 — Stack for Path Simplification

Example:

```text
"/a/./b/../../c/"
```

Simplify to:

```text
"/c"
```

Interpret:

```text
.. → go back
.  → stay
name → enter directory
```

Stack represents the current path.

```java
Deque<String> stack = new ArrayDeque<>();

for (String part : path.split("/")) {

    if (part.equals("") || part.equals(".")) {
        continue;
    }

    if (part.equals("..")) {

        if (!stack.isEmpty()) {
            stack.pop();
        }

    } else {
        stack.push(part);
    }
}
```

Again:

> Stack represents current state with undo.

---

# 35. Pattern 17 — Stack + DFS

DFS can be implemented recursively:

```java
dfs(node);
```

or explicitly with a stack:

```java
Deque<Node> stack = new ArrayDeque<>();
```

Recursive DFS:

```text
call stack
```

is itself using a stack internally.

So:

```text
Recursion
≈
Implicit Stack
```

This is an important connection.

---

# 36. Iterative DFS

```java
Deque<Integer> stack = new ArrayDeque<>();

stack.push(start);
visited[start] = true;

while (!stack.isEmpty()) {

    int node = stack.pop();

    for (int next : graph[node]) {

        if (!visited[next]) {

            visited[next] = true;
            stack.push(next);
        }
    }
}
```

This is useful when:

- recursion depth may be huge
- iterative implementation is required
- you need explicit state control

---

# 37. Pattern 18 — Stack + Backtracking

Backtracking recursion:

```text
choose
explore
undo
```

implicitly uses the call stack.

You can think of:

```text
recursive call stack
```

as storing:

```text
current path/state
```

This connection helps explain why recursion and stack often appear together.

---

# 38. Pattern 19 — Stack + Greedy

Important examples:

```text
Remove K Digits
Remove Duplicate Letters
Most Competitive Subsequence
```

Pattern:

```text
current choice
      ↓
compare with previous choices
      ↓
can previous choice be improved?
      ↓
pop
```

This is a powerful mental model:

> **Stack stores previous decisions that are still candidates.**

---

# 39. Pattern 20 — Stack + DP

Sometimes stack provides boundaries while DP computes values.

Examples:

- Largest Rectangle
- Maximal Rectangle
- Trapping Rain Water variants
- Histogram-based DP problems

You don't necessarily need to memorize "Stack + DP" as a separate algorithm.

Instead recognize:

```text
previous/next boundary
+
state
```

---

# 40. The Most Important Monotonic Stack Matrix

Memorize the problem transformation:

```text
             LOOKING FOR
                  |
       ┌──────────┼──────────┐
       ↓          ↓          ↓
     GREATER     SMALLER    EQUAL
       |
  ┌────┴────┐
  ↓         ↓
 NEXT     PREVIOUS
  |          |
  ↓          ↓
NGE/NSE   PGE/PSE
```

Where:

```text
NGE = Next Greater Element
NSE = Next Smaller Element
PGE = Previous Greater Element
PSE = Previous Smaller Element
```

These four patterns are the foundation.

---

# 41. How to Decide Increasing vs Decreasing Stack

Don't blindly memorize it.

Ask:

> **When does the current element resolve the element at the top?**

### Looking for Next Greater

If:

```text
current > stack.top
```

then current resolves top.

So:

```java
while (current > stack.top)
    pop();
```

### Looking for Next Smaller

If:

```text
current < stack.top
```

then:

```java
while (current < stack.top)
    pop();
```

This is safer than memorizing stack names.

---

# 42. Store Values or Indices?

This is a very important decision.

### Store values when:

You only need:

```text
next greater VALUE
```

Example:

```text
[2,1,5]
```

Answer:

```text
[5,5,-1]
```

Could store values.

### Store indices when:

You need:

```text
position
distance
width
boundaries
```

Examples:

- Daily Temperatures
- Largest Rectangle
- Stock Span
- Next Greater with indices

Rule:

> **If the answer involves position/distance/width, store indices.**

---

# 43. Pattern 21 — Contribution Technique

An advanced monotonic-stack pattern.

Suppose we want:

> Sum of subarray minimums.

Instead of enumerating every subarray, calculate:

> How many subarrays consider each element as the minimum?

For element:

```text
nums[i]
```

find:

```text
previous smaller boundary
next smaller boundary
```

Then:

```text
leftChoices
=
i - previousSmaller

rightChoices
=
nextSmaller - i
```

Contribution:

```text
nums[i]
× leftChoices
× rightChoices
```

This transforms:

```text
O(n²)
```

into:

```text
O(n)
```

using a monotonic stack.

---

# 44. Why Contribution Works

Suppose:

```text
[3,1,2]
```

For `1`, it is the minimum of:

```text
[1]
[3,1]
[1,2]
[3,1,2]
```

Number of choices:

```text
left choices × right choices
```

This is the deeper idea:

> **Instead of counting subarrays, count how many subarrays each element contributes to.**

This appears in:

- Sum of Subarray Minimums
- Sum of Subarray Ranges
- Largest Rectangle
- Maximum/minimum contribution problems

---

# 45. Pattern 22 — Trapping Rain Water

There are multiple solutions.

One is:

```text
Two Pointer
```

Another is:

```text
Monotonic Stack
```

Stack version maintains indices while heights are increasing.

When a taller wall arrives, it can close a basin.

This is a useful example showing:

> **One problem can belong to multiple patterns.**

---

# 46. Stack Recognition Flowchart

```text
                         STACK?
                            |
          ┌─────────────────┼──────────────────┐
          ↓                 ↓                  ↓
      Nested/matching   Previous/Next      Remove/Undo
          |              greater/smaller       |
          ↓                 |                  ↓
     Parentheses           ↓              Stack state
     Decode String     MONOTONIC STACK
     Expressions           |
                           |
                 ┌─────────┼─────────┐
                 ↓         ↓         ↓
                NGE       NSE      Boundaries
                 |         |         |
             Daily      Histogram  Contribution
           Temperatures  Rectangle  Subarray mins
```

---

# 47. The Strongest Recognition Signals

When you see:

```text
next greater
next smaller
previous greater
previous smaller
nearest greater
nearest smaller
first larger to right
first smaller to left
```

→ **Monotonic Stack**

When you see:

```text
balanced
nested
matching
parentheses
brackets
```

→ **Stack**

When you see:

```text
undo
back
previous state
nested decoding
```

→ **Stack**

When you see:

```text
remove K
lexicographically smallest
remove previous larger
best subsequence
```

→ **Monotonic Stack + Greedy**

When you see:

```text
histogram
rectangle
subarray minimum contribution
```

→ **Monotonic Stack**

---

# 48. Stack vs Queue

Very important distinction.

| Requirement | Pattern |
|---|---|
| Last in, first out | Stack |
| First in, first out | Queue |
| Nested/matching | Stack |
| BFS | Queue |
| DFS | Stack |
| Next greater/smaller | Monotonic Stack |
| Sliding window max/min | Monotonic Deque |
| Undo | Stack |
| Level order | Queue |
| Expression evaluation | Stack |

---

# 49. Stack vs Two Pointer

Some problems may look similar.

### Two Pointer

Tracks:

```text
left
right
```

usually exploiting:

- sorted order
- contiguity
- opposite directions
- relative movement

### Stack

Tracks:

```text
unresolved previous elements
```

especially when:

> A future element determines the fate of a previous element.

This distinction is powerful.

Example:

```text
[2,1,5]
```

Two pointer isn't naturally useful for:

> next greater element.

But stack is perfect because:

```text
5
```

resolves both:

```text
1 → 5
2 → 5
```

---

# 50. Stack vs Heap

Another common confusion.

### Heap

Question:

> **What is the globally smallest/largest/best element right now?**

### Monotonic Stack

Question:

> **What is the nearest previous/next element satisfying a relation?**

So:

```text
Top K
→ Heap

Next Greater
→ Monotonic Stack
```

---

# 51. Common Mistakes

## Mistake 1 — Using `Stack` unnecessarily

Prefer:

```java
Deque<Integer> stack = new ArrayDeque<>();
```

---

## Mistake 2 — Storing values when indices are required

For:

```text
Daily Temperatures
```

you need:

```text
i - previousIndex
```

so store indices.

---

## Mistake 3 — Wrong inequality

These differ:

```java
<
<=
>
>=
```

Especially with duplicates.

For example:

```text
Sum of Subarray Minimums
```

often requires asymmetric handling:

```text
<
```

on one side and:

```text
<=
```

on the other.

This prevents counting equal values twice.

---

# 52. Mistake 4 — Forgetting Remaining Elements

For:

```text
Next Greater
```

elements remaining in the stack have:

```text
no greater element
```

so answer:

```text
-1
```

For histogram, remaining bars still need processing.

That's why the sentinel:

```text
0
```

is often added.

---

# 53. Mistake 5 — Not Understanding Why the Stack Is Monotonic

Don't just memorize:

```text
while (...)
    pop();
```

Ask:

> What invariant does the stack maintain?

Example:

```text
Next Greater
```

The stack contains elements still waiting for a greater element.

The order is maintained so that a new larger element can resolve several at once.

---

# 54. Mistake 6 — Confusing "Next" and "Nearest"

"Next greater" means:

> first greater element in the required direction.

Not:

> largest greater element.

Example:

```text
[2,5,3,7]
```

For `2`:

```text
next greater = 5
```

not:

```text
7
```

This is exactly why monotonic stack works.

---

# 55. Mistake 7 — Using Stack When the Problem Needs Global Ordering

Example:

> Find the largest element.

No need for stack.

Example:

> Find top K largest.

Use:

```text
Heap
```

Stack is about **order/history/boundaries**, not simply "efficient storage."

---

# 56. Complexity

Basic Stack:

```text
push → O(1)
pop  → O(1)
peek → O(1)
```

Monotonic Stack:

```text
Time: O(n)
Space: O(n)
```

Why?

Each element:

```text
push once
pop at most once
```

Therefore:

```text
O(2n)
=
O(n)
```

---

# 57. Level-Wise Problem Segregation

Now the actual preparation roadmap.

---

# 🟢 Level 1 — Stack Fundamentals

Master basic LIFO.

1. Implement Stack
2. Valid Parentheses
3. Min Stack
4. Baseball Game
5. Backspace String Compare
6. Remove All Adjacent Duplicates
7. Simplify Path
8. Evaluate Reverse Polish Notation

### Goal

Become comfortable with:

```text
push
pop
peek
isEmpty
```

and stack-based state.

---

# 🟡 Level 2 — Core Interview Stack

1. Min Stack
2. Evaluate Reverse Polish Notation
3. Daily Temperatures
4. Next Greater Element I
5. Next Greater Element II
6. Online Stock Span
7. Asteroid Collision
8. Decode String
9. Remove K Digits
10. Basic Calculator II

### Goal

Recognize:

```text
Stack
+
state
```

---

# 🟠 Level 3 — Monotonic Stack

This is the most important level.

1. Next Greater Element I
2. Next Greater Element II
3. Daily Temperatures
4. Online Stock Span
5. Next Smaller Element
6. Previous Greater Element
7. Previous Smaller Element
8. Largest Rectangle in Histogram
9. Trapping Rain Water
10. Remove K Digits

### Goal

Master:

```text
NGE
NSE
PGE
PSE
```

---

# 🔴 Level 4 — Advanced Monotonic Stack

1. Largest Rectangle in Histogram
2. Maximal Rectangle
3. Sum of Subarray Minimums
4. Sum of Subarray Ranges
5. Asteroid Collision
6. Remove Duplicate Letters
7. Most Competitive Subsequence
8. 132 Pattern
9. Final Prices With a Special Discount
10. Car Fleet

### Goal

Understand:

```text
boundaries
contribution
greedy removal
```

---

# 🟣 Level 5 — FAANG / Advanced

1. Sum of Subarray Minimums
2. Sum of Subarray Ranges
3. Maximum Width Ramp
4. 132 Pattern
5. Largest Rectangle in Histogram
6. Maximal Rectangle
7. Trapping Rain Water
8. Basic Calculator
9. Basic Calculator III
10. Minimum Number of Increments on Subarrays to Form a Target Array
11. Remove Duplicate Letters
12. Most Competitive Subsequence

At this level, the question isn't:

> "Do I know Stack?"

It's:

> **"What invariant should my stack maintain?"**

---

# 58. The Must-Solve Stack Set

If you don't want to solve 50 stack questions, make these your core set:

```text
1. Valid Parentheses
2. Min Stack
3. Evaluate Reverse Polish Notation
4. Daily Temperatures
5. Next Greater Element I
6. Next Greater Element II
7. Online Stock Span
8. Asteroid Collision
9. Decode String
10. Remove K Digits
11. Largest Rectangle in Histogram
12. Trapping Rain Water
13. Maximal Rectangle
14. Sum of Subarray Minimums
15. Remove Duplicate Letters
```

If you can solve these without looking at solutions, you have a very strong Stack foundation.

---

# 59. Stack Pattern Map

```text
                         STACK
                           |
          ┌────────────────┼────────────────┐
          ↓                ↓                ↓
       BASIC            MONOTONIC         STATE
          |                |                |
     Parentheses           |             Decode
     Expression            |             Path
     Undo                   |             Duplicates
     DFS                    |
                            |
                 ┌──────────┼──────────┐
                 ↓          ↓          ↓
                GREATER   SMALLER   BOUNDARY
                 |          |          |
                NGE        NSE       Histogram
                PGE        PSE       Rectangle
                                      Contribution
                           |
                           ↓
                       GREEDY
                           |
                    Remove K Digits
                    Remove Letters
                    Competitive Subsequence
```

---

# 60. Stack Pattern Recognition Cheat Sheet

```text
========================================================
                    STACK CHEAT SHEET
========================================================

BASIC
--------------------------------------------------------
LIFO
push()
pop()
peek()

Java:
Deque<Integer> stack = new ArrayDeque<>();


MATCHING / NESTING
--------------------------------------------------------
Parentheses
Brackets
Nested expressions
Decode String

→ STACK


UNDO / STATE
--------------------------------------------------------
Undo
Back
Previous state
Path simplification
Adjacent duplicate removal

→ STACK


EXPRESSION
--------------------------------------------------------
RPN
Calculator
Prefix/Postfix

→ STACK


MONOTONIC STACK
--------------------------------------------------------

Next Greater
→ pop while current > top

Next Smaller
→ pop while current < top

Previous Greater
→ remove invalid previous elements

Previous Smaller
→ remove invalid previous elements


CLASSIC PROBLEMS
--------------------------------------------------------
Daily Temperatures
Stock Span
Next Greater Element
Next Smaller Element


BOUNDARY PROBLEMS
--------------------------------------------------------
Histogram
Maximal Rectangle
Subarray Minimum
Subarray Maximum

→ nearest smaller/greater


GREEDY + STACK
--------------------------------------------------------
Remove K Digits
Remove Duplicate Letters
Most Competitive Subsequence

Current better than previous?
→ pop previous choice


INDEX RULE
--------------------------------------------------------
Need value?
→ store value

Need distance / position / width?
→ store index


COMPLEXITY
--------------------------------------------------------
Basic Stack:
O(1) push/pop/peek

Monotonic Stack:
O(n)

Each element:
push once
pop at most once


RECOGNITION
--------------------------------------------------------
nested / matching
        → Stack

next / previous greater
        → Monotonic Stack

next / previous smaller
        → Monotonic Stack

histogram / rectangle
        → Monotonic Stack

remove K / lexicographically smallest
        → Monotonic Stack + Greedy

undo / previous state
        → Stack

top K
        → Heap

sliding window max/min
        → Monotonic Deque
========================================================
```

---

# 61. The Most Important Mental Model

Don't memorize:

```text
"Daily Temperatures = Stack"
"Largest Rectangle = Stack"
"Stock Span = Stack"
```

Instead recognize the common structure:

```text
          FUTURE ELEMENT
                 |
                 ↓
        resolves previous
             elements
                 |
                 ↓
        ┌────────────────┐
        │  STACK         │
        │ unresolved     │
        │ elements       │
        └────────────────┘
```

For example:

```text
[2, 1, 5]
```

Before `5` arrives:

```text
stack:
2
1
```

`5` arrives:

```text
5 > 1
→ resolve 1

5 > 2
→ resolve 2
```

That's the essence of a monotonic stack.

---

# 62. The Golden Rule

When you see an unfamiliar Stack problem, ask:

```text
1. Is there nesting/matching?
       ↓
     Stack

2. Am I waiting for a future element
   to resolve a previous element?
       ↓
     Monotonic Stack

3. Is it next/previous greater/smaller?
       ↓
     Monotonic Stack

4. Do I need nearest boundaries?
       ↓
     Monotonic Stack

5. Can a new choice make previous
   choices permanently useless?
       ↓
     Stack + Greedy

6. Do I need global smallest/largest/top K?
       ↓
     Heap, not Stack
```

The **single most valuable Stack pattern for interviews is Monotonic Stack**. Once you understand that a stack can represent **"unresolved previous elements waiting for a future element"**, problems like Daily Temperatures, Stock Span, Next Greater Element, Histogram, Subarray Minimums, and several seemingly unrelated hard problems start looking like variations of the same algorithm.