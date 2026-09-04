# Top 100 LeetCode Questions for Interviews (with Revision-Friendly Pseudocode)

This is the set most companies repeatedly touch:

* Arrays
* Sliding Window
* HashMap
* Stack
* LinkedList
* Binary Search
* Trees
* Heap
* Graph
* DP
* Backtracking

For revision, the best strategy is:

1. Remember pattern
2. Remember core logic
3. Remember time complexity
4. Be able to explain brute force → optimized

---

# 1. Arrays + Hashing (1–20)

---

## 1. Two Sum

### Pattern

HashMap lookup

### Pseudocode

```text
map = {}

for each number:
    diff = target - num

    if diff exists in map:
        return indexes

    store num in map
```

---

## 2. Contains Duplicate

```text
create set

for each num:
    if num already in set:
        return true

    add num

return false
```

---

## 3. Valid Anagram

```text
count chars of string1
count chars of string2

compare maps
```

---

## 4. Group Anagrams

```text
map = {}

for each word:
    sortedWord = sort(word)

    add word to map[sortedWord]
```

---

## 5. Top K Frequent Elements

```text
count frequency

sort by frequency descending

take top k
```

---

## 6. Product of Array Except Self

```text
leftProduct[]
rightProduct[]

build prefix
build suffix

answer[i] = left[i] * right[i]
```

---

## 7. Encode and Decode Strings

```text
store length + delimiter + string
```

---

## 8. Longest Consecutive Sequence

```text
put all nums in set

for each num:
    if num-1 not present:
        start sequence

        count length
```

---

## 9. Best Time to Buy and Sell Stock

```text
minPrice = INF
maxProfit = 0

for each price:
    minPrice = minimum

    profit = price - minPrice

    update maxProfit
```

---

## 10. Maximum Subarray (Kadane)

```text
currentSum += num

if currentSum < num:
    currentSum = num

maxSum = max(maxSum, currentSum)
```

---

## 11. Maximum Product Subarray

```text
track:
    maxProduct
    minProduct

because negatives can flip
```

---

## 12. Find Minimum in Rotated Sorted Array

```text
binary search

check middle vs right
```

---

## 13. Search in Rotated Sorted Array

```text
binary search

identify sorted half
```

---

## 14. 3Sum

```text
sort array

for each number:
    use two pointers
```

---

## 15. Container With Most Water

```text
left = 0
right = n-1

calculate area

move smaller height
```

---

## 16. Move Zeroes

```text
maintain insertIndex

place non-zero first

fill remaining with zero
```

---

## 17. Merge Sorted Array

```text
start from back

compare nums1 and nums2
```

---

## 18. Majority Element

```text
Boyer Moore Voting

count++
count--
```

---

## 19. Missing Number

```text
expectedSum - actualSum
```

OR

```text
xor all
```

---

## 20. Find Duplicate Number

```text
use slow fast pointer cycle detection
```

---

# 2. Sliding Window (21–30)

---

## 21. Longest Substring Without Repeating Characters

```text
set/window

while duplicate:
    remove left

expand right
```

---

## 22. Longest Repeating Character Replacement

```text
track maxFrequency

if window invalid:
    shrink left
```

---

## 23. Permutation in String

```text
fixed size sliding window

compare frequency arrays
```

---

## 24. Minimum Window Substring

```text
expand right

when valid:
    shrink left
```

---

## 25. Sliding Window Maximum

```text
use deque

remove smaller elements
```

---

## 26. Fruits Into Baskets

```text
at most 2 distinct chars

sliding window hashmap
```

---

## 27. Max Consecutive Ones III

```text
allow k zeros

shrink if zero count > k
```

---

## 28. Subarray Product Less Than K

```text
expand right

while product >= k:
    divide left
```

---

## 29. Minimum Size Subarray Sum

```text
expand window

shrink while sum >= target
```

---

## 30. Binary Subarrays With Sum

```text
prefix sum hashmap
```

---

# 3. Stack (31–40)

---

## 31. Valid Parentheses

```text
push opening

pop when closing
```

---

## 32. Min Stack

```text
maintain:
    main stack
    min stack
```

---

## 33. Evaluate Reverse Polish Notation

```text
push operands

when operator:
    pop 2
    calculate
```

---

## 34. Generate Parentheses

```text
backtracking

open < n
close < open
```

---

## 35. Daily Temperatures

```text
monotonic decreasing stack
```

---

## 36. Car Fleet

```text
sort by position descending

use stack for arrival times
```

---

## 37. Largest Rectangle in Histogram

```text
monotonic increasing stack
```

---

## 38. Basic Calculator

```text
stack + sign handling
```

---

## 39. Remove K Digits

```text
monotonic stack

remove larger previous digits
```

---

## 40. Decode String

```text
stack for count + string
```

---

# 4. Linked List (41–50)

---

## 41. Reverse Linked List

```text
prev = null

while current:
    reverse links
```

---

## 42. Merge Two Sorted Lists

```text
compare nodes

append smaller
```

---

## 43. Reorder List

```text
find middle
reverse second half
merge both
```

---

## 44. Remove Nth Node From End

```text
two pointers

move fast n steps
```

---

## 45. Linked List Cycle

```text
slow fast pointer
```

---

## 46. Find Duplicate Number

```text
cycle detection
```

---

## 47. Add Two Numbers

```text
digit by digit + carry
```

---

## 48. Copy List With Random Pointer

```text
hashmap old->new
```

---

## 49. LRU Cache

```text
hashmap + doubly linked list
```

---

## 50. Merge K Sorted Lists

```text
min heap
```

---

# 5. Binary Search (51–60)

---

## 51. Binary Search

```text
while left <= right:
    mid

    adjust bounds
```

---

## 52. Search Insert Position

```text
binary search insertion point
```

---

## 53. Koko Eating Bananas

```text
binary search answer space
```

---

## 54. Capacity To Ship Packages

```text
binary search capacity
```

---

## 55. Median of Two Sorted Arrays

```text
binary search partition
```

---

## 56. TimeMap

```text
binary search timestamps
```

---

## 57. Find Peak Element

```text
binary search slope
```

---

## 58. Search 2D Matrix

```text
treat matrix as sorted array
```

---

## 59. Split Array Largest Sum

```text
binary search possible answer
```

---

## 60. Min Days to Make Bouquets

```text
binary search days
```

---

# 6. Trees (61–75)

---

## 61. Invert Binary Tree

```text
swap left right recursively
```

---

## 62. Maximum Depth of Binary Tree

```text
1 + max(left, right)
```

---

## 63. Same Tree

```text
compare recursively
```

---

## 64. Subtree of Another Tree

```text
compare every node
```

---

## 65. Lowest Common Ancestor BST

```text
go left/right based on values
```

---

## 66. Binary Tree Level Order Traversal

```text
BFS queue
```

---

## 67. Validate BST

```text
node must be within range
```

---

## 68. Kth Smallest in BST

```text
inorder traversal
```

---

## 69. Construct Binary Tree

```text
preorder gives root

split inorder
```

---

## 70. Diameter of Binary Tree

```text
leftHeight + rightHeight
```

---

## 71. Balanced Binary Tree

```text
check height difference <=1
```

---

## 72. Path Sum

```text
DFS sum tracking
```

---

## 73. Right Side View

```text
last node at each level
```

---

## 74. Count Good Nodes

```text
track max seen
```

---

## 75. Serialize Deserialize Tree

```text
DFS + null markers
```

---

# 7. Heap / Priority Queue (76–82)

---

## 76. Kth Largest Element

```text
min heap size k
```

---

## 77. Top K Frequent Words

```text
frequency map + heap
```

---

## 78. Task Scheduler

```text
max heap frequency
```

---

## 79. Find Median from Data Stream

```text
2 heaps:
maxHeap left
minHeap right
```

---

## 80. Merge K Sorted Lists

```text
min heap
```

---

## 81. Last Stone Weight

```text
max heap
```

---

## 82. K Closest Points

```text
max heap size k
```

---

# 8. Graphs (83–90)

---

## 83. Number of Islands

```text
DFS/BFS every island
```

---

## 84. Clone Graph

```text
hashmap visited
```

---

## 85. Pacific Atlantic Water Flow

```text
reverse DFS from oceans
```

---

## 86. Course Schedule

```text
topological sort
cycle detection
```

---

## 87. Graph Valid Tree

```text
DFS + no cycle
```

---

## 88. Word Ladder

```text
BFS transformation
```

---

## 89. Rotting Oranges

```text
multi-source BFS
```

---

## 90. Network Delay Time

```text
Dijkstra shortest path
```

---

# 9. Dynamic Programming (91–97)

---

## 91. Climbing Stairs

```text
dp[i] = dp[i-1] + dp[i-2]
```

---

## 92. House Robber

```text
take or skip
```

---

## 93. Coin Change

```text
minimum coins DP
```

---

## 94. Longest Increasing Subsequence

```text
DP or binary search
```

---

## 95. Longest Common Subsequence

```text
2D DP table
```

---

## 96. Word Break

```text
dp[i] checks dictionary
```

---

## 97. Partition Equal Subset Sum

```text
subset sum DP
```

---

# 10. Backtracking (98–100)

---

## 98. Subsets

```text
choose/not choose
```

---

## 99. Combination Sum

```text
pick repeatedly until target
```

---

## 100. N Queens

```text
place queen safely row by row
```

---

# MOST IMPORTANT 25 (Revise Before Interview)

If only few hours left:

1. Two Sum
2. Top K Frequent
3. Group Anagrams
4. Longest Substring Without Repeat
5. Sliding Window Maximum
6. Valid Parentheses
7. Daily Temperatures
8. Reverse LinkedList
9. Merge Two Sorted Lists
10. LRU Cache
11. Binary Search
12. Search Rotated Array
13. Koko Eating Bananas
14. Max Depth Tree
15. Level Order Traversal
16. Validate BST
17. Lowest Common Ancestor
18. Number of Islands
19. Course Schedule
20. Climbing Stairs
21. House Robber
22. Coin Change
23. Longest Common Subsequence
24. Combination Sum
25. Subsets

---

# Ultimate Interview Patterns You Must Know

| Pattern              | Questions           |
| -------------------- | ------------------- |
| Sliding Window       | substring/window    |
| Two Pointer          | sorted arrays       |
| HashMap Frequency    | counting            |
| Monotonic Stack      | next greater        |
| Heap                 | top K               |
| Binary Search Answer | optimization        |
| DFS/BFS              | graph/tree          |
| Backtracking         | combinations        |
| DP                   | choices/memoization |

---

# Golden Rule for Interviews

Whenever interviewer asks coding:

## First Say:

1. Brute force approach
2. Time complexity
3. Better approach
4. Final optimized solution
5. Edge cases

That alone separates average vs strong candidates.
