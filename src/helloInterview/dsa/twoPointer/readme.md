Absolutely. **Two Pointers** is one of the highest-ROI DSA patterns because it appears in arrays, strings, linked lists, sliding window, greedy, and even some graph-like problems.

I'll structure it the same way we've done for DP/Greedy/Graph: **mental model → patterns → recognition → templates → questions by level → mistakes → two-pointer vs sliding window → cheat sheet.**

---

# Two Pointers — Deep Dive

## 1. Core Mental Model

Two pointers simply means:

> **Maintain two positions in a data structure and move them intelligently instead of checking every pair.**

Typical form:

```java
int left = 0;
int right = nums.length - 1;

while (left < right) {
    // use nums[left], nums[right]

    if (...) {
        left++;
    } else {
        right--;
    }
}
```

The important part isn't having two variables called `left` and `right`.

The important part is:

> **Can I eliminate a large number of possibilities by moving one pointer?**

That's the real two-pointer idea.

---

# 2. Why Two Pointers?

Suppose:

```text
nums = [1, 2, 3, 4, 5, 6]
target = 7
```

Brute force:

```text
1 + 2
1 + 3
1 + 4
...
```

That's:

```text
O(n²)
```

But because the array is sorted:

```text
left = 1
right = 6

1 + 6 = 7
```

Done.

Or:

```text
1 + 6 = 7
```

If:

```text
sum < target
```

we know we need something larger, so:

```text
left++
```

If:

```text
sum > target
```

we need something smaller:

```text
right--
```

Each pointer moves only forward/backward.

Therefore:

```text
O(n)
```

instead of:

```text
O(n²)
```

---

# 3. The Most Important Two-Pointer Patterns

There isn't just one two-pointer pattern.

There are roughly **7 major patterns** you should recognize.

---

# Pattern 1 — Opposite Ends

```text
L →              ← R

[1  2  3  4  5  6]
```

Start:

```java
left = 0;
right = n - 1;
```

Move them toward each other.

### Typical problems

* Two Sum II
* Container With Most Water
* Valid Palindrome
* 3Sum
* 4Sum
* Boats to Save People
* Trapping Rain Water (one solution)
* Reverse String
* Reverse Array

### Recognition

Look for:

> "sorted array"

or

> "pair"

or

> "from both ends"

or

> "maximize/minimize something using left/right"

---

## Template

```java
int left = 0;
int right = nums.length - 1;

while (left < right) {

    int value = ...;

    if (condition) {
        left++;
    } else {
        right--;
    }
}
```

---

# Pattern 2 — Same Direction / Fast & Slow

Both pointers move left → right.

```text
slow →
fast →

[1 2 3 4 5 6]
```

Usually:

```java
slow = 0;
fast = 0;
```

But they move at different speeds.

---

## Classic use

### Remove duplicates

```text
[1,1,2,2,3]
 ↑
 slow

   ↑
  fast
```

`fast` scans.

`slow` maintains the valid portion.

---

### Template

```java
int slow = 0;

for (int fast = 0; fast < nums.length; fast++) {

    if (isValid(nums[fast])) {
        nums[slow] = nums[fast];
        slow++;
    }
}
```

This is an extremely important pattern.

---

### Problems

* Remove Duplicates from Sorted Array
* Remove Element
* Move Zeroes
* Remove Duplicates from Sorted Array II
* Sort Colors (related partition pattern)
* String compression
* Partition array

---

# Pattern 3 — Fast/Slow in Linked List

This is also two pointers, but the structure is different.

```text
slow → one step
fast → two steps
```

Example:

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

Used for:

* Middle of linked list
* Cycle detection
* Cycle start
* Palindrome linked list
* Nth node from end

---

# Pattern 4 — Sliding Window

This is technically a **two-pointer technique**.

```text
L →        R →
[ . . . . . . . . ]
```

But now the two pointers define a **window**.

Example:

```text
[2, 1, 5, 1, 3, 2]

L
R
```

Expand:

```text
L → [2 1 5] ← R
```

If the window becomes invalid:

```text
L → [2 1 5 1 3] ← R
```

move:

```text
L →
```

until valid.

So:

> **Sliding Window is a specialized two-pointer technique.**

Not every two-pointer problem is sliding window.

---

# Pattern 5 — Two Pointers + Sorting

This is extremely important for interview problems.

Example:

## 3Sum

```text
[-1,0,1,2,-1,-4]
```

Sort:

```text
[-4,-1,-1,0,1,2]
```

Fix one number:

```text
      i
      ↓
[-4,-1,-1,0,1,2]
     L        R
```

Then use two pointers.

```text
for (int i = 0; i < n - 2; i++) {

    int left = i + 1;
    int right = n - 1;

    while (left < right) {

        int sum = nums[i] + nums[left] + nums[right];

        if (sum == 0) {
            ...
        }
        else if (sum < 0) {
            left++;
        }
        else {
            right--;
        }
    }
}
```

Complexity:

```text
Sorting       O(n log n)
Two pointer   O(n²)

Total         O(n²)
```

---

# Pattern 6 — Partition / Rearrangement

Two pointers divide an array into regions.

Example:

```text
[0,1,0,3,12]
```

Move zeros to the end.

```text
[1,3,12,0,0]
```

Another classic:

## Dutch National Flag

```text
[2,0,2,1,1,0]
```

Maintain:

```text
0s | unknown | 2s
```

Pointers:

```text
low
mid
high
```

This becomes a **three-pointer partition pattern**.

---

### Problems

* Move Zeroes
* Sort Colors
* Partition Array
* Segregate 0s and 1s
* Sort binary array
* QuickSort partition

---

# Pattern 7 — Two Pointers on Two Sequences

This is less obvious but very useful.

Suppose:

```text
A = [1,3,5,7]
B = [2,3,6,8]
```

Use:

```text
i → A
j → B
```

Example: intersection.

```java
while (i < A.length && j < B.length) {

    if (A[i] == B[j]) {
        ...
        i++;
        j++;
    }
    else if (A[i] < B[j]) {
        i++;
    }
    else {
        j++;
    }
}
```

Used in:

* Merge sorted arrays
* Intersection
* Union
* Merge two sorted lists
* Compare subsequences
* String matching
* Common elements

---

# 4. The Most Important Recognition Skill

When you see a problem, ask:

### Question 1

> Am I dealing with a pair of positions/elements?

If yes, think:

```text
Two Pointer?
```

---

### Question 2

> Is the data sorted?

If yes:

```text
Two Pointer becomes highly likely.
```

Especially:

```text
find pair
sum
difference
closest
duplicate
intersection
```

---

### Question 3

> Can I eliminate possibilities by moving one pointer?

This is the strongest signal.

Example:

```text
sum < target
```

Can you prove that moving `right` is useless?

If yes:

```text
left++
```

That's two-pointer reasoning.

---

# 5. Two Pointer Decision Tree

Use this during interviews.

```text
                 ARRAY / STRING / LIST
                         |
                         v
                 Need pair/positions?
                    /          \
                  YES           NO
                   |             |
                   v             v
               Sorted?       Same direction?
              /       \        /       \
            YES       NO     YES       NO
             |         |       |         |
             v         v       v         v
        Opposite     Can sort?  Fast/    Other
         ends          |        slow    pattern
                       |
                       v
                 Sort + pointers
```

Another useful version:

```text
Two pointers?
     |
     +-- opposite ends?
     |      |
     |      +-- pair/sum → Yes
     |      +-- palindrome → Yes
     |      +-- max/min from ends → Yes
     |
     +-- same direction?
     |      |
     |      +-- remove/filter → slow/fast
     |      +-- partition → slow/fast
     |      +-- window → sliding window
     |
     +-- two arrays?
     |      |
     |      +-- merge/intersection
     |
     +-- linked list?
            |
            +-- middle/cycle/nth from end
```

---

# 6. Opposite-End Template

## Two Sum II

```java
public int[] twoSum(int[] numbers, int target) {

    int left = 0;
    int right = numbers.length - 1;

    while (left < right) {

        int sum = numbers[left] + numbers[right];

        if (sum == target) {
            return new int[]{left + 1, right + 1};
        }

        if (sum < target) {
            left++;
        } else {
            right--;
        }
    }

    return new int[]{-1, -1};
}
```

### Why?

Because sorted order gives us information.

If:

```text
numbers[left] + numbers[right] < target
```

then keeping `left` cannot help.

So:

```text
left++
```

---

# 7. Container With Most Water

Classic interview problem.

```text
[1,8,6,2,5,4,8,3,7]
 L                 R
```

Area:

```text
min(height[L], height[R]) * (R-L)
```

Move the **shorter side**.

```java
while (left < right) {

    int height = Math.min(height[left], height[right]);
    int width = right - left;

    max = Math.max(max, height * width);

    if (height[left] < height[right]) {
        left++;
    } else {
        right--;
    }
}
```

### Why move the smaller one?

Because the shorter wall is limiting the area.

If you move the taller wall:

```text
width decreases
height cannot exceed the current shorter wall
```

So there is no benefit.

This is exactly the type of **proof** you need in two-pointer problems.

---

# 8. Valid Palindrome

String:

```text
"racecar"
```

Pointers:

```text
L → r a c e c a r ← R
```

Compare:

```java
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

> Compare from both ends.

Immediate two-pointer signal.

---

# 9. Remove Duplicates

Input:

```text
[1,1,2,2,3]
```

We want:

```text
[1,2,3]
```

Use:

```text
slow = position for next unique element
fast = scanner
```

```java
int slow = 1;

for (int fast = 1; fast < nums.length; fast++) {

    if (nums[fast] != nums[fast - 1]) {
        nums[slow] = nums[fast];
        slow++;
    }
}

return slow;
```

The conceptual model:

```text
[valid | unknown]
       ↑
      slow

              ↑
             fast
```

---

# 10. Move Zeroes

Input:

```text
[0,1,0,3,12]
```

Output:

```text
[1,3,12,0,0]
```

Use `slow` as the next position for a non-zero.

```java
int slow = 0;

for (int fast = 0; fast < nums.length; fast++) {

    if (nums[fast] != 0) {
        int temp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = temp;

        slow++;
    }
}
```

Mental model:

```text
[non-zero | unknown]
          ↑
         slow

                 ↑
                fast
```

---

# 11. 3Sum

This is one of the most important two-pointer problems.

```text
nums = [-1,0,1,2,-1,-4]
```

Sort:

```text
[-4,-1,-1,0,1,2]
```

Fix:

```text
i
↓
-4 -1 -1 0 1 2
    L       R
```

Then:

```text
sum < target → L++
sum > target → R--
sum == target → record + move both
```

Complexity:

```text
O(n²)
```

### Important mistake

For duplicate handling:

```java
if (i > 0 && nums[i] == nums[i - 1]) {
    continue;
}
```

and after finding an answer:

```java
while (left < right && nums[left] == nums[left + 1]) {
    left++;
}

while (left < right && nums[right] == nums[right - 1]) {
    right--;
}
```

---

# 12. Boats to Save People

Very good combination of:

```text
Greedy + Sorting + Two Pointers
```

Sort:

```text
[1,2,2,3]
```

Boat capacity:

```text
3
```

Take:

```text
heaviest + lightest
```

If they fit:

```text
left++
right--
```

Otherwise:

```text
right--
```

Why?

The heaviest person must go somewhere.

If the heaviest can't pair with the lightest, they can't pair with anyone.

So the heaviest gets a boat alone.

That's greedy + two pointers.

---

# 13. Trapping Rain Water

Another advanced two-pointer problem.

```text
leftMax
rightMax
```

Instead of precomputing arrays, maintain:

```java
int left = 0;
int right = height.length - 1;

int leftMax = 0;
int rightMax = 0;
int water = 0;
```

At each step:

```text
if height[left] < height[right]
    process left
else
    process right
```

The idea:

> The smaller boundary determines how much water can be trapped.

This is a great Level 4/5 problem because it tests whether you understand **why a pointer can safely move**.

---

# 14. Two Pointer + Sliding Window

This distinction is important.

### Two Pointer

```text
left ---------------- right
```

Pointers might represent:

* endpoints
* two values
* positions
* partitions
* two lists

### Sliding Window

```text
[left ........ right]
```

The pointers specifically represent a **contiguous range**.

Usually:

```java
for (int right = 0; right < n; right++) {

    add(nums[right]);

    while (windowInvalid()) {
        remove(nums[left]);
        left++;
    }

    updateAnswer();
}
```

So:

> **Sliding Window ⊂ Two Pointer**

Conceptually.

---

# 15. Two Pointer vs Sliding Window

| Problem                    | Pattern                |
| -------------------------- | ---------------------- |
| Two Sum II                 | Two pointer            |
| 3Sum                       | Two pointer            |
| Valid Palindrome           | Two pointer            |
| Container With Most Water  | Two pointer            |
| Remove Duplicates          | Fast/slow              |
| Move Zeroes                | Fast/slow              |
| Longest substring          | Sliding window         |
| Minimum window substring   | Sliding window         |
| Max sum subarray of size K | Sliding window         |
| Sliding window maximum     | Sliding window + deque |
| Linked List Cycle          | Fast/slow              |

---

# 16. Two Pointer + Greedy

Very common.

Example:

```text
Boats to Save People
Assign Cookies
Minimum Platforms
```

The pattern becomes:

```text
Sort
 ↓
Greedy decision
 ↓
Two pointers
```

Example:

```text
[1,2,2,3]
 ↑     ↑
light heavy
```

Try to pair them.

---

# 17. Two Pointer + Binary Search?

Don't confuse these.

For example:

```text
Two Sum
```

can be solved with:

```text
HashMap
Binary Search
Two Pointer
```

depending on constraints.

But two pointer is particularly attractive when:

```text
array sorted
+
pair relationship
+
monotonic movement
```

---

# 18. Two Pointer + HashMap

Sometimes sorting destroys useful information.

Example:

```text
Two Sum
```

Unsorted:

```text
[3,2,4]
target = 6
```

Use:

```text
HashMap
```

rather than two pointers.

Why?

Because sorting:

```text
[2,3,4]
```

loses original indices unless you preserve them.

So:

```text
Unsorted + need indices
→ HashMap

Sorted + pair relationship
→ Two pointers
```

---

# 19. The Most Important Question

Whenever you want to use two pointers:

> **What guarantees that I can safely move this pointer?**

This is the heart of the pattern.

For Two Sum II:

```text
sum < target
→ left++
```

because increasing right is impossible/useful? More precisely, with current `right`, we need a larger left value; and any smaller left value would only make the sum smaller.

For Container:

```text
left height < right height
→ left++
```

because current left height limits every container using this left boundary, and reducing width cannot improve it by moving right.

For palindrome:

```text
left/right must match
→ move both
```

For remove duplicates:

```text
fast scans
slow stores valid output
```

Different proof, same two-pointer family.

---

# 20. Common Mistakes

## Mistake 1 — Using two pointers just because there are two indices

Bad reasoning:

> "There are two indexes, so two pointers."

No.

You need a **movement invariant**.

---

## Mistake 2 — Assuming array must be sorted

Not necessarily.

Two pointers also work for:

```text
palindrome
partition
move zeroes
linked list
sliding window
two sequences
```

---

## Mistake 3 — Sorting when original order matters

Example:

```text
subarray
subsequence
original indices
```

Sorting can destroy the problem's meaning.

---

## Mistake 4 — Wrong pointer movement

For example:

```java
if (sum < target) {
    right--;
}
```

when it should be:

```java
left++;
```

This is why you should explain **why** you're moving the pointer.

---

## Mistake 5 — Infinite loops

Bad:

```java
while (left < right) {

    if (...) {
        // forgot left++
    }
}
```

Every iteration should guarantee progress.

---

## Mistake 6 — Duplicate handling in 3Sum

You may find:

```text
[-1,0,1]
[-1,0,1]
```

multiple times.

Sorting + duplicate skipping is essential.

---

## Mistake 7 — Mixing index and value

Example:

```java
nums[left]
```

is value.

```java
left
```

is index.

Sounds obvious, but many pointer bugs come from mixing these.

---

# 21. Complexity Pattern

Most two-pointer solutions have:

```text
Time: O(n)
Space: O(1)
```

Examples:

```text
Palindrome
Move Zeroes
Remove duplicates
Container
Two Sum II
```

But not always.

### 3Sum

```text
O(n²)
```

because:

```text
outer loop = O(n)
two pointer = O(n)
```

plus sorting:

```text
O(n log n)
```

Overall:

```text
O(n²)
```

---

# 22. Level-Wise Questions

Now the important part for your preparation.

---

# 🟢 Level 1 — Fundamentals

Master the mechanics.

### Arrays / Strings

1. Reverse String
2. Reverse Array
3. Valid Palindrome
4. Two Sum II
5. Remove Duplicates from Sorted Array
6. Remove Element
7. Move Zeroes
8. Merge Sorted Array
9. Intersection of Two Arrays II
10. Merge Two Sorted Arrays

### Linked List

11. Middle of Linked List
12. Linked List Cycle
13. Remove Nth Node From End

### Goal

You should immediately recognize:

```text
left/right
slow/fast
```

and write the template without thinking.

---

# 🟡 Level 2 — Core Interview

Now understand pointer movement.

1. Container With Most Water
2. Boats to Save People
3. Squares of a Sorted Array
4. Valid Palindrome II
5. Backspace String Compare
6. Partition Array
7. Sort Array By Parity
8. Minimum Difference Between Largest and Smallest Value
9. Intersection of Two Sorted Arrays
10. Is Subsequence
11. Long Pressed Name
12. Move Zeroes

The important skill:

> Why am I moving this pointer?

---

# 🟠 Level 3 — Two Pointer + Sorting

Very important for product-company interviews.

1. 3Sum
2. 3Sum Closest
3. 4Sum
4. 4Sum II — understand why this is actually HashMap rather than classic two pointer
5. Three Sum Smaller
6. Boats to Save People
7. Assign Cookies
8. Minimum Platforms
9. Array Partition
10. Interval-related two-pointer problems

Focus on:

```text
sort
→ fix something
→ two pointers
```

---

# 🔴 Level 4 — Advanced

These test the underlying invariant.

1. Trapping Rain Water
2. Container With Most Water
3. Minimum Window-type problems
4. Subarrays with constraints
5. Remove Duplicates II
6. Partition / Dutch National Flag
7. 3Sum variants
8. 4Sum
9. Longest Mountain in Array
10. Shortest Unsorted Continuous Subarray

Here the challenge isn't syntax.

It's:

> **What exactly does each pointer represent?**

---

# 🟣 Level 5 — FAANG / Hard Pattern Recognition

These aren't necessarily "pure" two-pointer problems.

They combine techniques.

### Two Pointer + Greedy

```text
Boats
Jump-related variants
Scheduling
```

### Two Pointer + Sliding Window

```text
Longest substring
Minimum window
Subarray constraints
```

### Two Pointer + Monotonic Structure

```text
Trapping Rain Water
Sliding Window Maximum
```

### Two Pointer + Sorting

```text
3Sum
4Sum
closest-sum problems
```

### Two Pointer + Linked List

```text
Cycle
Cycle start
Palindrome
Intersection
Reorder List
```

### Two Pointer + Partition

```text
QuickSort partition
Dutch National Flag
Move Zeroes
Sort Colors
```

---

# 23. What You Actually Need to Master

Don't memorize 50 problems.

Master these **8 patterns**:

```text
                 TWO POINTER
                      |
       ┌──────────────┼───────────────┐
       ↓              ↓               ↓
 Opposite Ends    Same Direction    Two Sequences
       |              |               |
   Pair/Sum        Fast/Slow       Merge/Intersection
   Palindrome      Remove/Filter
   Container       Partition
       |
       ├───────────────┐
       ↓               ↓
  Sorting + TP     Sliding Window
       |               |
     3Sum            Subarray
     4Sum            Substring
     Closest         Frequency
       |
       ↓
  Greedy + TP
       |
  Boats / Cookies
```

---

# 24. Master Template Sheet

### Template 1 — Opposite Ends

```java
int left = 0;
int right = n - 1;

while (left < right) {

    if (...) {
        left++;
    } else {
        right--;
    }
}
```

---

### Template 2 — Fast / Slow

```java
int slow = 0;

for (int fast = 0; fast < n; fast++) {

    if (...) {
        nums[slow] = nums[fast];
        slow++;
    }
}
```

---

### Template 3 — Two Sorted Arrays

```java
int i = 0;
int j = 0;

while (i < a.length && j < b.length) {

    if (a[i] < b[j]) {
        i++;
    } else if (a[i] > b[j]) {
        j++;
    } else {
        // match
        i++;
        j++;
    }
}
```

---

### Template 4 — Linked List Fast/Slow

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;
}
```

---

### Template 5 — Sliding Window

```java
int left = 0;

for (int right = 0; right < n; right++) {

    add(nums[right]);

    while (invalid()) {
        remove(nums[left]);
        left++;
    }

    updateAnswer();
}
```

---

### Template 6 — 3Sum

```java
Arrays.sort(nums);

for (int i = 0; i < n - 2; i++) {

    if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
    }

    int left = i + 1;
    int right = n - 1;

    while (left < right) {

        int sum = nums[i] + nums[left] + nums[right];

        if (sum == target) {

            // answer

            left++;
            right--;

        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
}
```

---

# 25. The Golden Rule

When you see:

```text
pair
sorted
sum
closest
palindrome
opposite ends
remove duplicates
partition
merge sorted
linked-list middle/cycle
contiguous range
```

your brain should immediately scan:

```text
              TWO POINTER?
                   |
        ┌──────────┼──────────┐
        ↓          ↓          ↓
    L ↔ R       slow/fast   L → R
   opposite      same       window
     ends       direction
```

And before coding, say:

> **What does each pointer represent, and what mathematical/logical fact allows me to move it?**

If you can answer that, you usually have the solution.

---

## Two Pointer vs the other major patterns

This is probably the most useful mental map for your overall DSA preparation:

| Signal                                    | Think                     |
| ----------------------------------------- | ------------------------- |
| Pair + sorted                             | **Two Pointer**           |
| Pair + unsorted + need lookup             | **HashMap**               |
| Contiguous + variable range               | **Sliding Window**        |
| Contiguous + cumulative relation          | **Prefix Sum**            |
| Repeated best/min/max                     | **Heap**                  |
| Need all combinations                     | **Backtracking**          |
| Repeated states                           | **DP**                    |
| Locally safe decision                     | **Greedy**                |
| Sorted search space / monotonic condition | **Binary Search**         |
| Next greater/smaller                      | **Monotonic Stack**       |
| Connectivity                              | **DFS/BFS/DSU**           |
| Shortest unweighted path                  | **BFS**                   |
| Shortest weighted path                    | **Dijkstra/Bellman-Ford** |

### Final mental model

```text
Two Pointer is not:

"Use two indexes."

It is:

"Use two moving boundaries/positions to eliminate
unnecessary possibilities in one pass."
```

That distinction is what takes you from **knowing the pattern** to **recognizing it in an unfamiliar interview problem**.
