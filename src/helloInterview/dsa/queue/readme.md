https://chatgpt.com/g/g-p-692dc15bc8b08191be655a86cadb9a6c/c/6981ab54-d304-83a4-bbb6-089ef9773cf3

But there is one important distinction:

> **Queue is a broader data structure. Heap/Priority Queue is a specific ordering mechanism.**

For interviews, I would learn them together because many problems that look like “Queue problems” are actually **Heap problems**, especially scheduling, Top-K, merging, streaming, and greedy problems.

Here is the roadmap I recommend:

```text
QUEUE
│
├── 1. Basic Queue
│      ├── FIFO
│      ├── BFS
│      └── Level Order Traversal
│
├── 2. Deque
│      ├── Sliding Window Maximum
│      ├── Monotonic Queue
│      └── 0-1 BFS
│
└── 3. Priority Queue / HEAP
       │
       ├── Min Heap / Max Heap
       ├── Top K
       ├── Kth Largest / Smallest
       ├── K-way Merge
       ├── Two Heaps
       ├── Scheduling
       ├── Greedy + Heap
       ├── Streaming Median
       ├── Frequency problems
       └── Heap + Graph
```

Let's build this from the **interview mental model**, rather than just learning Java's `PriorityQueue`.

---

# 1. First: What exactly is a Heap?

A heap is a **complete binary tree** with a special ordering property.

### Min Heap

Parent ≤ children.

```text
          1
       /     \
      3       5
    /  \     / \
   7    8   6   9
```

The smallest element is always at the root.

```text
peek() → 1
```

### Max Heap

Parent ≥ children.

```text
          9
       /     \
      8       7
    /  \     / \
   3    5   6   1
```

The largest element is always at the root.

```text
peek() → 9
```

---

# 2. Why do we need a Heap?

Suppose:

```text
[10, 5, 20, 3, 8]
```

You repeatedly need:

> "Give me the smallest element."

A normal array:

```text
find minimum → O(n)
```

A sorted array:

```text
minimum → O(1)
```

But inserting into sorted array:

```text
insert → O(n)
```

Heap gives us a useful compromise:

| Operation      |     Heap |
| -------------- | -------: |
| Peek min/max   |     O(1) |
| Insert         | O(log n) |
| Remove min/max | O(log n) |
| Build heap     |     O(n) |

That's why heaps are so useful when the requirement is:

> **Repeatedly give me the current smallest/largest element.**

That sentence should immediately trigger:

# 🚨 HEAP

---

# 3. Heap vs Priority Queue

These terms are often mixed together.

### Heap

The underlying data structure.

### Priority Queue

An abstract data type:

> Give me the element with the highest priority.

A heap is commonly used to implement it.

In Java:

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

Internally it is a heap.

Default:

```text
MIN HEAP
```

So:

```java
pq.add(10);
pq.add(3);
pq.add(7);
pq.add(1);

System.out.println(pq.peek());
```

Output:

```text
1
```

---

# 4. Java PriorityQueue

## Min Heap

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

or explicitly:

```java
PriorityQueue<Integer> pq =
        new PriorityQueue<>(Comparator.naturalOrder());
```

---

## Max Heap

```java
PriorityQueue<Integer> pq =
        new PriorityQueue<>(Comparator.reverseOrder());
```

Now:

```java
pq.add(10);
pq.add(3);
pq.add(7);
pq.add(20);

System.out.println(pq.peek());
```

Output:

```text
20
```

---

# 5. Very important: PriorityQueue is NOT a sorted collection

This is one of the biggest interview traps.

Suppose:

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.add(10);
pq.add(3);
pq.add(7);
pq.add(1);
pq.add(5);
```

You should **not** assume iteration gives:

```text
1 3 5 7 10
```

The heap only guarantees:

```text
peek() = minimum
```

and after removing the minimum, the next minimum becomes available.

If you want sorted output:

```java
while (!pq.isEmpty()) {
    System.out.println(pq.poll());
}
```

This gives:

```text
1
3
5
7
10
```

---

# 6. The first major Heap pattern

# Pattern 1 — Top K Elements

This is probably the **most important heap pattern**.

Suppose:

```text
nums = [3, 2, 1, 5, 6, 4]
```

Find:

```text
2nd largest
```

Brute force:

```text
sort → [1,2,3,4,5,6]
```

answer = 5.

But sorting costs:

```text
O(n log n)
```

Heap can do:

```text
O(n log k)
```

when `k` is small.

---

# 7. Kth Largest → Min Heap

This is extremely important.

Suppose:

```text
k = 3
```

We want:

```text
3rd largest
```

Maintain a **min heap of size k**.

```text
nums:
[3,2,1,5,6,4]

k = 3
```

Process:

```text
3 → [3]

2 → [2,3]

1 → [1,2,3]

5 → [2,3,5]

6 → [3,5,6]

4 → [4,5,6]
```

Final:

```text
minHeap = [4,5,6]
```

The smallest among these top 3 is:

```text
4
```

Therefore:

```text
3rd largest = 4
```

### Java

```java
public int findKthLargest(int[] nums, int k) {

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int num : nums) {

        pq.offer(num);

        if (pq.size() > k) {
            pq.poll();
        }
    }

    return pq.peek();
}
```

### Complexity

```text
Time:  O(n log k)
Space: O(k)
```

---

# 8. Why MIN heap for Kth Largest?

This initially feels backward.

You want:

> largest

but you use:

> min heap.

Why?

Because we want to eliminate the smaller elements.

Maintain:

```text
TOP K largest
```

The smallest among those K is the boundary.

Example:

```text
Top 3:

[7, 10, 20]
 ↑
 smallest among top 3
```

If `15` arrives:

```text
[7,10,20]
```

7 is smaller than 15:

```text
remove 7
add 15

[10,15,20]
```

So:

> **Kth Largest → Min Heap of size K**

Memorize this.

---

# 9. Kth Smallest → Max Heap

Mirror image.

For:

```text
Kth smallest
```

maintain:

```text
MAX HEAP of size K
```

Example:

```text
nums = [3,2,1,5,6,4]
k = 3
```

Maintain 3 smallest:

```text
[1,2,3]
```

The largest among these is:

```text
3
```

Therefore:

```text
3rd smallest = 3
```

Java:

```java
PriorityQueue<Integer> pq =
        new PriorityQueue<>(Comparator.reverseOrder());

for (int num : nums) {

    pq.offer(num);

    if (pq.size() > k) {
        pq.poll();
    }
}

return pq.peek();
```

---

# 10. The Top-K Master Rule

This is one of the most useful rules in heap problems:

```text
K largest
     ↓
MIN HEAP

K smallest
     ↓
MAX HEAP
```

Why?

Because the heap root represents the **boundary element**.

---

# 11. Pattern 2 — Top K Frequent Elements

Now the heap isn't storing just numbers.

Suppose:

```text
nums = [1,1,1,2,2,3]
```

Frequency:

```text
1 → 3
2 → 2
3 → 1
```

Find:

```text
top 2 frequent
```

We can maintain:

```text
frequency map
```

then:

```text
heap
```

Store:

```text
[number, frequency]
```

Use min heap based on frequency.

```java
Map<Integer, Integer> freq = new HashMap<>();

for (int num : nums) {
    freq.put(num, freq.getOrDefault(num, 0) + 1);
}

PriorityQueue<int[]> pq =
        new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {

    pq.offer(new int[]{entry.getKey(), entry.getValue()});

    if (pq.size() > k) {
        pq.poll();
    }
}
```

Again:

```text
min heap
+
size K
```

means:

> keep only the top K.

---

# 12. This gives us a generalized pattern

Whenever you see:

```text
Top K
K largest
K smallest
K most frequent
K closest
K highest priority
K lowest priority
```

think:

```text
Heap
```

Then ask:

> What should determine priority?

That's where the comparator comes in.

---

# 13. Pattern 3 — K Closest Points

Suppose:

```text
points = [
 [1,3],
 [-2,2],
 [5,8],
 [0,1]
]
```

Find K closest to origin.

Distance:

```text
x² + y²
```

For:

```text
[1,3]
```

distance:

```text
1² + 3² = 10
```

We want:

```text
smallest K distances
```

Therefore:

```text
MAX HEAP of size K
```

Why max?

Because the farthest among our current K closest points should be removed.

```java
PriorityQueue<int[]> pq =
    new PriorityQueue<>(
        (a, b) -> Integer.compare(
            distance(b),
            distance(a)
        )
    );
```

This is a very common interview pattern:

```text
K smallest according to some metric
        ↓
MAX HEAP
```

---

# 14. Pattern 4 — K-way Merge

This is a **very important FAANG-level heap pattern**.

Suppose you have sorted arrays:

```text
A = [1,4,7]
B = [2,5,8]
C = [3,6,9]
```

Merge them:

```text
[1,2,3,4,5,6,7,8,9]
```

Naively, repeatedly scanning the heads:

```text
O(k * n)
```

Heap gives:

```text
O(N log k)
```

where:

```text
k = number of lists
N = total elements
```

---

# 15. How K-way merge works

Put the first element of every list into min heap:

```text
Heap:

1(A)
2(B)
3(C)
```

Take:

```text
1
```

Then insert next element from A:

```text
4(A)
```

Heap:

```text
2(B)
3(C)
4(A)
```

Take:

```text
2
```

Insert:

```text
5(B)
```

Continue.

The heap always tells us:

> Which list currently has the smallest next element?

This pattern appears in:

* Merge K sorted lists
* Merge K sorted arrays
* Smallest range covering K lists
* External sorting
* Multi-source streams

---

# 16. What do we store in the Heap?

Usually:

```java
class Node {
    int value;
    int row;
    int index;
}
```

or:

```java
int[] {value, listIndex, elementIndex}
```

This is an important heap interview skill:

> **The heap element does not have to be just an integer.**

It can represent:

```text
[value, index]
[value, frequency]
[distance, point]
[time, task]
[profit, project]
```

---

# 17. Pattern 5 — Two Heaps

Now we move into more interesting problems.

Classic example:

# Find Median from Data Stream

Numbers arrive:

```text
5
10
2
3
```

After every insertion:

```text
median?
```

Sorting every time would be expensive.

Instead use:

```text
MAX HEAP       MIN HEAP
left           right

smaller        larger
```

Example:

```text
        5 | 10
       /       \
   smaller    larger
```

Actually conceptually:

```text
MAX HEAP          MIN HEAP

   5                 10
  /                  \
 2                    20
```

Maintain:

```text
size difference ≤ 1
```

Then:

### Odd number of elements

Median = root of larger heap.

### Even number

Median:

```text
(maxHeap.peek() + minHeap.peek()) / 2
```

---

# 18. Two Heap Mental Model

Think:

```text
         MEDIAN
           |
    ----------------
    |              |
 smaller          larger
 MAX HEAP         MIN HEAP
```

Why?

Because:

```text
MAX HEAP
```

gives largest element from left half.

And:

```text
MIN HEAP
```

gives smallest element from right half.

These are exactly the two elements around the median.

---

# 19. Pattern 6 — Scheduling Problems

This is another huge category.

Suppose:

```text
tasks:
A → 3
B → 1
C → 2
```

At any moment:

> Which available task should execute next?

That's a Priority Queue.

Typical structure:

```text
sort events by start time

while events remain:

    add all currently available jobs

    choose highest-priority job using heap

    execute it
```

This appears in:

* Meeting Rooms
* CPU Scheduling
* Task Scheduling
* Minimum Meeting Rooms
* Single-threaded CPU
* Course scheduling variants
* Server assignment
* Event simulation

---

# 20. Meeting Rooms II

Suppose:

```text
[0,30]
[5,10]
[15,20]
```

Question:

> Minimum rooms?

Sort by start time.

Then maintain a min heap of:

```text
end times
```

Process:

```text
[0,30]

heap:
30
```

Next:

```text
[5,10]
```

10 < 30:

Need another room.

```text
heap:
10,30
```

Next:

```text
[15,20]
```

Remove 10 because:

```text
10 <= 15
```

Reuse that room.

Add 20:

```text
20,30
```

Maximum heap size:

```text
2
```

Therefore:

```text
2 rooms
```

The key pattern:

> **Intervals + minimum available resource → Min Heap of end times**

---

# 21. Pattern 7 — Greedy + Heap

This is one of the most powerful combinations.

Typical problem:

> You have several choices. At each step, choose the currently best available option.

That's:

```text
Greedy
+
Priority Queue
```

For example:

```text
projects with capital requirements and profits
```

You have:

```text
capital = 10
```

Only projects requiring ≤ 10 are currently available.

Among them:

> choose maximum profit.

So:

```text
sort by capital requirement
+
max heap by profit
```

This is a classic pattern.

---

# 22. The General Greedy + Heap Template

```java
Arrays.sort(projects, Comparator.comparingInt(p -> p.capital));

PriorityQueue<Project> pq =
        new PriorityQueue<>(
            (a, b) -> b.profit - a.profit
        );

int i = 0;

for (int round = 0; round < k; round++) {

    while (i < projects.length &&
           projects[i].capital <= currentCapital) {

        pq.offer(projects[i]);
        i++;
    }

    if (pq.isEmpty()) {
        break;
    }

    currentCapital += pq.poll().profit;
}
```

The mental model:

```text
SORT → expose available choices
HEAP → choose best available choice
```

This pattern is extremely important.

---

# 23. Pattern 8 — Heap + Graph

Heap becomes especially important in graph algorithms.

The classic example:

# Dijkstra

Suppose:

```text
A --4-- B
|      |
1      2
|      |
C --3-- D
```

We want shortest path.

At every step:

> Pick the unprocessed node with smallest known distance.

That is exactly:

```text
MIN HEAP
```

Heap contains:

```text
(distance, node)
```

Example:

```java
PriorityQueue<int[]> pq =
    new PriorityQueue<>(
        Comparator.comparingInt(a -> a[0])
    );
```

Then:

```java
pq.offer(new int[]{0, source});
```

Whenever we discover a shorter distance:

```java
pq.offer(new int[]{newDistance, neighbor});
```

Important:

Java's PriorityQueue doesn't support decrease-key efficiently, so we often insert the new pair and ignore stale entries when popped.

---

# 24. Pattern 9 — Heap + Greedy Resource Allocation

Examples:

```text
Assign workers
Schedule machines
Hire workers
Minimum cost
Maximum profit
Connect ropes
Merge files
```

Classic:

# Connect Ropes with Minimum Cost

Given:

```text
[4,3,2,6]
```

Connect two smallest:

```text
2 + 3 = 5
```

Then:

```text
[4,5,6]
```

Again:

```text
4 + 5 = 9
```

Then:

```text
[6,9]
```

Again:

```text
15
```

Total:

```text
5 + 9 + 15 = 29
```

Algorithm:

```text
MIN HEAP
```

Repeatedly:

```text
a = poll()
b = poll()

cost += a + b

offer(a + b)
```

This is a classic:

> **Repeatedly combine the two smallest → Min Heap**

---

# 25. Pattern 10 — Frequency + Heap

Suppose:

```text
"AABBBCC"
```

frequency:

```text
A → 2
B → 3
C → 2
```

Problems such as:

* reorganize string
* task scheduler
* rearrange characters
* most frequent element
* reduce frequency
* Huffman coding

often use:

```text
frequency map
+
heap
```

For example, reorganizing:

```text
AAABB
```

You want:

```text
ABABA
```

At every step:

> choose the most frequent character that doesn't violate the constraint.

That becomes:

```text
MAX HEAP by frequency
```

---

# 26. Pattern 11 — Heap + Cooldown

Classic Task Scheduler style problems.

Suppose:

```text
A A A B B B
```

Cooldown:

```text
n = 2
```

You cannot execute:

```text
A A
```

within two intervals.

We maintain:

```text
MAX HEAP
```

for currently available tasks.

And another structure for:

```text
cooldown tasks
```

Conceptually:

```text
        MAX HEAP
       available
           |
           ↓
      execute task
           |
           ↓
      cooldown queue
           |
           ↓
       becomes available
```

This combines:

```text
Priority Queue + Queue
```

This is exactly why understanding both Queue and Heap together is valuable.

---

# 27. Queue vs PriorityQueue vs Deque

This distinction should become automatic.

### Queue

```text
FIFO
```

Example:

```text
A B C

poll → A
```

Use for:

```text
BFS
level order
processing order
```

---

### PriorityQueue

```text
highest/lowest priority first
```

Example:

```text
5 1 10

poll → 1
```

Use for:

```text
Top K
scheduling
Dijkstra
merge
greedy
median
```

---

### Deque

Can operate from both ends:

```text
addFirst()
addLast()

pollFirst()
pollLast()
```

Use for:

```text
sliding window
monotonic queue
BFS variants
0-1 BFS
```

---

# 28. Queue Pattern: BFS

You already know trees, so this should be straightforward.

```java
Queue<TreeNode> queue = new LinkedList<>();

queue.offer(root);

while (!queue.isEmpty()) {

    TreeNode node = queue.poll();

    System.out.println(node.val);

    if (node.left != null)
        queue.offer(node.left);

    if (node.right != null)
        queue.offer(node.right);
}
```

The pattern:

```text
put → offer
take → poll
```

---

# 29. Queue Pattern: Level Order

The important trick is:

```java
int size = queue.size();

for (int i = 0; i < size; i++) {
    TreeNode node = queue.poll();

    ...
}
```

Why?

Because `size` represents:

> number of nodes in the current level.

This allows:

```text
Level 0
Level 1
Level 2
...
```

---

# 30. Queue Pattern: Multi-source BFS

Very important for FAANG interviews.

Suppose:

```text
0 = empty
1 = source
```

There are multiple starting points.

Instead of:

```text
BFS from each source
```

put all sources into the queue initially:

```text
queue:

source1
source2
source3
```

Then BFS simultaneously.

Used in:

* Rotting Oranges
* Walls and Gates
* 01 Matrix
* Fire spreading
* Infection simulation
* Nearest source problems

Mental trigger:

> **Multiple starting points + shortest distance in unweighted graph → Multi-source BFS**

---

# 31. Deque Pattern — Sliding Window Maximum

Now we get to a very important Queue problem.

Given:

```text
[1,3,-1,-3,5,3,6,7]
```

window:

```text
k = 3
```

Need:

```text
[3,3,5,5,6,7]
```

A normal queue won't work efficiently.

We use:

```text
Deque
```

specifically a:

# Monotonic Deque

Maintain indices such that values are decreasing:

```text
3
-1
-3
```

When a larger value arrives:

```text
5
```

remove smaller values from the back:

```text
3
-1
-3

→

5
```

Now the front is always:

```text
maximum
```

Complexity:

```text
O(n)
```

This is much better than:

```text
O(nk)
```

---

# 32. Why store indices instead of values?

Very important.

Suppose:

```text
nums = [1,3,-1]
```

We need to know when an element leaves the window.

If we store:

```text
values
```

we don't know exactly where it came from.

So store:

```text
indices
```

Then:

```java
while (!deque.isEmpty() &&
       deque.peekFirst() <= i - k) {

    deque.pollFirst();
}
```

This is a classic interview trick:

> **Sliding window + need to know expiration → store indices.**

---

# 33. Queue Pattern — Monotonic Queue

The general idea:

```text
Deque
+
monotonic ordering
```

Two variants:

### Monotonic decreasing

Front = maximum.

```text
[9, 7, 5, 2]
```

### Monotonic increasing

Front = minimum.

```text
[2, 5, 7, 9]
```

Used for:

```text
Sliding Window Maximum
Sliding Window Minimum
range optimization
DP optimization
```

This is conceptually similar to heaps, but with a major difference:

> A monotonic deque exploits **window expiration/order** and can achieve O(n).

---

# 34. Heap vs Monotonic Deque

Suppose:

> Maximum in every window of size K.

Could we use a max heap?

Yes.

```text
Max Heap
```

But complexity:

```text
O(n log n)
```

or depending on implementation:

```text
O(n log k)
```

Monotonic deque:

```text
O(n)
```

Why?

Because each element enters and leaves the deque at most once.

This is an important optimization pattern.

---

# 35. Heap Pattern Recognition Cheat Sheet

When you see:

```text
K largest
```

→ Min Heap.

```text
K smallest
```

→ Max Heap.

```text
K most frequent
```

→ Heap by frequency.

```text
K closest
```

→ Heap by distance.

```text
Merge K sorted
```

→ Min Heap.

```text
Repeatedly take smallest
```

→ Min Heap.

```text
Repeatedly take largest
```

→ Max Heap.

```text
Median of stream
```

→ Two Heaps.

```text
Schedule available jobs
```

→ Heap.

```text
Minimum rooms/resources
```

→ Min Heap.

```text
Maximum profit among available choices
```

→ Max Heap.

```text
Shortest weighted path
```

→ Min Heap + Graph.

```text
Repeatedly combine smallest
```

→ Min Heap.

```text
Frequency + rearrangement
```

→ Max Heap.

---

# 36. Queue Pattern Recognition Cheat Sheet

```text
Shortest path in unweighted graph
        ↓
BFS / Queue
```

```text
Tree level order
        ↓
Queue
```

```text
Multiple sources
        ↓
Multi-source BFS
```

```text
Sliding window max/min
        ↓
Monotonic Deque
```

```text
Elements enter and expire from both ends
        ↓
Deque
```

```text
0/1 weighted edges
        ↓
Deque / 0-1 BFS
```

---

# 37. The deeper connection

This is the important part.

Don't memorize:

```text
"Use PriorityQueue for problem X."
```

Instead recognize the **selection requirement**.

Ask:

### Question 1

> Do I need elements in arrival order?

```text
YES → Queue
```

### Question 2

> Do I need elements from both ends?

```text
YES → Deque
```

### Question 3

> Do I need the smallest/largest current element?

```text
YES → Heap
```

### Question 4

> Do I need the maximum/minimum inside a moving window?

```text
YES → Monotonic Deque
```

### Question 5

> Do I need the top K?

```text
YES → Heap
```

### Question 6

> Do I need the median?

```text
YES → Two Heaps
```

### Question 7

> Do I repeatedly choose the best currently available option?

```text
YES → Greedy + Heap
```

---

# 38. One huge interview pattern

There is a very useful transformation:

```text
"At every step, choose the best available X"
```

becomes:

```text
PriorityQueue
```

For example:

```text
At every moment:
choose smallest available task
```

→ Min Heap.

```text
At every moment:
choose highest profit available project
```

→ Max Heap.

```text
At every moment:
choose closest point
```

→ Min Heap.

```text
At every moment:
choose least frequent character
```

→ Min Heap.

The word **"available"** is especially important.

Often the full pattern is:

```text
SORT by when something becomes available
+
HEAP by what should be selected
```

This is a very common FAANG-level greedy pattern.

---

# 39. Heap implementation you should know

You don't normally implement a heap from scratch in interviews because Java gives:

```java
PriorityQueue
```

But you should understand the underlying structure.

Array representation:

```text
             0
          /     \
         1       2
       /  \     /  \
      3    4   5    6
```

For index `i`:

```text
parent = (i - 1) / 2

left    = 2 * i + 1

right   = 2 * i + 2
```

This is why a heap doesn't need explicit TreeNode objects.

---

# 40. Heapify

Suppose:

```text
[5, 3, 8, 1, 2]
```

Building a heap from all elements can be:

```text
O(n)
```

not:

```text
O(n log n)
```

This is an important theoretical interview question.

Why?

Because bottom-up heapification starts from the last non-leaf nodes and fixes the heap.

Java:

```java
PriorityQueue<Integer> pq =
    new PriorityQueue<>(Arrays.asList(...));
```

Conceptually performs heap construction.

---

# 41. Common Heap mistakes

### Mistake 1

Using:

```java
PriorityQueue<Integer>
```

and assuming iteration is sorted.

Wrong.

---

### Mistake 2

Using max heap for K largest.

Usually wrong if you're maintaining only K elements.

Correct:

```text
K largest → min heap
```

---

### Mistake 3

Removing arbitrary elements frequently.

Java's:

```java
pq.remove(value)
```

is not O(log n).

It can be:

```text
O(n)
```

because it has to find the element.

---

### Mistake 4

Using a heap when a monotonic deque gives O(n).

Especially:

```text
Sliding Window Maximum
```

---

### Mistake 5

Using heap without thinking about the comparator.

For objects:

```java
PriorityQueue<Task> pq =
    new PriorityQueue<>(
        Comparator.comparingInt(t -> t.priority)
    );
```

For multiple criteria:

```java
PriorityQueue<Task> pq =
    new PriorityQueue<>(
        Comparator.comparingInt((Task t) -> t.priority)
                  .thenComparingInt(t -> t.time)
    );
```

---

# 42. The Heap Interview Tree

I'd organize your preparation like this:

```text
                    HEAP
                     │
       ┌─────────────┼─────────────┐
       │             │             │
     Basic          Top-K        Greedy
       │             │             │
 Min/Max Heap   Kth Largest    Scheduling
 PriorityQueue  Kth Smallest   Resources
 Comparator     K Frequent      Profit
                K Closest       Ropes
                     │
              ┌──────┴──────┐
              │             │
          K-way Merge    Two Heaps
              │             │
        Merge K Lists    Median
        Smallest Range   Streaming
                            │
                     ┌──────┴──────┐
                     │             │
                  Graph          Queue
                     │             │
                 Dijkstra       BFS
                 Prim           Multi-source
                                Deque
                                  │
                           Monotonic Queue
                                  │
                        Sliding Window Max
```

---

# 43. What I would actually prepare for FAANG/product interviews

Don't solve 100 random heap questions.

Master these **patterns**:

### Level 1 — Foundation

1. Implement/use Min Heap
2. Max Heap
3. Custom comparator
4. Heap operations
5. Kth Largest
6. Kth Smallest

### Level 2 — Top K

7. Top K Frequent Elements
8. K Closest Points
9. Kth Largest in Stream
10. K Largest Elements

### Level 3 — Merge

11. Merge K Sorted Lists
12. Kth Smallest in Sorted Matrix
13. Smallest Range Covering K Lists

### Level 4 — Two Heaps

14. Find Median from Data Stream
15. Sliding Median

### Level 5 — Scheduling

16. Meeting Rooms II
17. Task Scheduler
18. Single-Threaded CPU
19. Employee Free Time

### Level 6 — Greedy + Heap

20. IPO / maximize capital
21. Connect Ropes
22. Minimum Cost to Hire K Workers
23. Reorganize String
24. Furthest Building You Can Reach

### Level 7 — Graph + Heap

25. Dijkstra
26. Network Delay Time
27. Cheapest Flights variants
28. Prim's MST

### Level 8 — Queue / Deque

29. Binary Tree Level Order
30. Rotting Oranges
31. 01 Matrix
32. Sliding Window Maximum
33. Sliding Window Minimum
34. 0-1 BFS

---

# 44. The most important mental model

For your DSA preparation, I'd memorize this instead of individual solutions:

```text
QUEUE
↓
"Who came first?"
↓
FIFO
↓
BFS
```

```text
DEQUE
↓
"Who is at either end?"
↓
Sliding window / monotonic queue
```

```text
HEAP
↓
"Who is currently smallest/largest/best?"
↓
PriorityQueue
```

```text
TOP K
↓
Keep only K candidates
↓
Opposite heap
```

```text
TWO HEAPS
↓
Split data around a boundary
↓
Median
```

```text
K-WAY MERGE
↓
One candidate from each source
↓
Min Heap
```

```text
GREEDY + HEAP
↓
Available choices + best current choice
↓
Sort + PriorityQueue
```

```text
GRAPH + HEAP
↓
Repeatedly process minimum-cost state
↓
Dijkstra / Prim
```

And one particularly useful interview sentence:

> **A heap is useful whenever I repeatedly need access to the minimum/maximum element while the underlying collection is changing.**

That is the core idea behind almost every heap problem.

### Recommended next step

Since you specifically want to **deep-dive into Queue questions too**, I would do the next part as a proper **Queue/Deque interview playbook**, covering **BFS → level-order → multi-source BFS → shortest path → circular queue → deque → monotonic queue → sliding-window max/min → 0-1 BFS**, with Java templates and the exact signals that tell you which pattern to use. Then we can do the **Heap problem set pattern-by-pattern** rather than mixing them together.
