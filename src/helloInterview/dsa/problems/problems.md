# Your 200-Question DSA Roadmap — Java Interview Preparation

Since your goal is to clear DSA rounds for Java full-stack and senior software developer roles, I recommend a curated set of 200 problems in a deliberate order, rather than solving 200 random LeetCode questions.

The goal isn't just to complete 200 questions. It is to recognize patterns, solve unseen variations, explain time and space complexity, and write correct code under interview pressure.

We'll progress from arrays and strings to sliding window, hashing, binary search, linked lists, stacks, trees, graphs, backtracking, and dynamic programming.

## 1. Your 200-question distribution

# 200 problems

Curated interview preparation

The study allocation is weighted toward foundational patterns, trees, graphs, and dynamic programming.

# 30

Arrays and strings

# 25

Hashing and two pointers

# 25

Sliding window and prefix sum

# 20

Binary search and sorting

# 25

Linked lists, stacks and queues

# 25

Trees and graphs

# 50

Recursion, backtracking, DP, greedy and heaps

This is a pattern-based plan, not a ranking of the most important topics. We'll also revisit arrays, hashing, and trees inside harder problems.

## 2. The complete problem list

I've selected problems around reusable patterns, using the official [LeetCode Top Interview 150](https://leetcode.com/studyplan/top-interview-150/?utm_source=chatgpt.com) and [NeetCode roadmap](https://neetcode.io/roadmap?utm_source=chatgpt.com) as references. Both organize interview preparation by topic, rather than relying on random questions.&#x20;

[image](https://www.google.com/s2/favicons?domain=https://leetcode.com\&sz=32)

LeetCode

+1



Difficulty labels below are approximate preparation levels: Easy, Medium, and a few Hard stretch problems. The order is intentional; don't skip straight to the hardest question in a topic.

## Phase 1 — Arrays and strings (Questions 1–22)

Goal: master iteration, indexing, in-place modification, character processing, and basic array patterns.

| #  | LeetCode problem                                                                                                                                               | Level  |
| -- | -------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------ |
| 1  | [Running Sum of 1d Array](https://leetcode.com/problems/running-sum-of-1d-array/?utm_source=chatgpt.com)                                                       | Easy   |
| 2  | [Richest Customer Wealth](https://leetcode.com/problems/richest-customer-wealth/?utm_source=chatgpt.com)                                                       | Easy   |
| 3  | [Find Pivot Index](https://leetcode.com/problems/find-pivot-index/?utm_source=chatgpt.com)                                                                     | Easy   |
| 4  | [Concatenation of Array](https://leetcode.com/problems/concatenation-of-array/?utm_source=chatgpt.com)                                                         | Easy   |
| 5  | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/?utm_source=chatgpt.com)                               | Easy   |
| 6  | [Remove Element](https://leetcode.com/problems/remove-element/?utm_source=chatgpt.com)                                                                         | Easy   |
| 7  | [Move Zeroes](https://leetcode.com/problems/move-zeroes/?utm_source=chatgpt.com)                                                                               | Easy   |
| 8  | [Missing Number](https://leetcode.com/problems/missing-number/?utm_source=chatgpt.com)                                                                         | Easy   |
| 9  | [Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/?utm_source=chatgpt.com)                     | Easy   |
| 10 | [Majority Element](https://leetcode.com/problems/majority-element/?utm_source=chatgpt.com)                                                                     | Easy   |
| 11 | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?utm_source=chatgpt.com)                                       | Easy   |
| 12 | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/?utm_source=chatgpt.com)                                                                     | Medium |
| 13 | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/?utm_source=chatgpt.com)                                             | Medium |
| 14 | [Rotate Array](https://leetcode.com/problems/rotate-array/?utm_source=chatgpt.com)                                                                             | Medium |
| 15 | [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/?utm_source=chatgpt.com)                                                                   | Medium |
| 16 | [Spiral Matrix](https://leetcode.com/problems/spiral-matrix/?utm_source=chatgpt.com)                                                                           | Medium |
| 17 | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/?utm_source=chatgpt.com)                                                           | Easy   |
| 18 | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/?utm_source=chatgpt.com)                                                                     | Easy   |
| 19 | [Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/?utm_source=chatgpt.com)                                                   | Medium |
| 20 | [Reverse String](https://leetcode.com/problems/reverse-string/?utm_source=chatgpt.com)                                                                         | Easy   |
| 21 | [Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/?utm_source=chatgpt.com) | Easy   |
| 22 | [String Compression](https://leetcode.com/problems/string-compression/?utm_source=chatgpt.com)                                                                 | Medium |

Patterns to master: array traversal, in-place updates, Kadane's algorithm, matrix boundaries, string manipulation, and character indexing.

## Phase 2 — Hashing and prefix sums (Questions 23–36)

Goal: use `HashMap`, `HashSet`, frequency counting, and cumulative sums to avoid unnecessary nested loops.

| #  | LeetCode problem                                                                                                             | Level  |
| -- | ---------------------------------------------------------------------------------------------------------------------------- | ------ |
| 23 | [Two Sum](https://leetcode.com/problems/two-sum/?utm_source=chatgpt.com)                                                     | Easy   |
| 24 | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/?utm_source=chatgpt.com)                               | Easy   |
| 25 | [Valid Anagram](https://leetcode.com/problems/valid-anagram/?utm_source=chatgpt.com)                                         | Easy   |
| 26 | [Ransom Note](https://leetcode.com/problems/ransom-note/?utm_source=chatgpt.com)                                             | Easy   |
| 27 | [Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/?utm_source=chatgpt.com)               | Easy   |
| 28 | [Group Anagrams](https://leetcode.com/problems/group-anagrams/?utm_source=chatgpt.com)                                       | Medium |
| 29 | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/?utm_source=chatgpt.com)                     | Medium |
| 30 | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/?utm_source=chatgpt.com)           | Medium |
| 31 | [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/?utm_source=chatgpt.com)                         | Medium |
| 32 | [Range Sum Query — Immutable](https://leetcode.com/problems/range-sum-query-immutable/?utm_source=chatgpt.com)               | Easy   |
| 33 | [Contiguous Array](https://leetcode.com/problems/contiguous-array/?utm_source=chatgpt.com)                                   | Medium |
| 34 | [Subarray Sums Divisible by K](https://leetcode.com/problems/subarray-sums-divisible-by-k/?utm_source=chatgpt.com)           | Medium |
| 35 | [Find the Difference of Two Arrays](https://leetcode.com/problems/find-the-difference-of-two-arrays/?utm_source=chatgpt.com) | Easy   |
| 36 | [Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/?utm_source=chatgpt.com)                     | Medium |

Patterns to master: complement lookup, frequency maps, grouping by canonical keys, prefix sum, prefix-sum frequency maps, and remainder counting.

## Phase 3 — Two pointers (Questions 37–48)

Goal: recognize when two moving indices can replace nested loops.

| #  | LeetCode problem                                                                                                                 | Level  |
| -- | -------------------------------------------------------------------------------------------------------------------------------- | ------ |
| 37 | [Two Sum II — Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?utm_source=chatgpt.com)     | Medium |
| 38 | [Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/?utm_source=chatgpt.com)                     | Easy   |
| 39 | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/?utm_source=chatgpt.com)                                       | Easy   |
| 40 | [Is Subsequence](https://leetcode.com/problems/is-subsequence/?utm_source=chatgpt.com)                                           | Easy   |
| 41 | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/?utm_source=chatgpt.com) | Easy   |
| 42 | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/?utm_source=chatgpt.com)                     | Medium |
| 43 | [3Sum](https://leetcode.com/problems/3sum/?utm_source=chatgpt.com)                                                               | Medium |
| 44 | [4Sum](https://leetcode.com/problems/4sum/?utm_source=chatgpt.com)                                                               | Medium |
| 45 | [Sort Colors](https://leetcode.com/problems/sort-colors/?utm_source=chatgpt.com)                                                 | Medium |
| 46 | [Boats to Save People](https://leetcode.com/problems/boats-to-save-people/?utm_source=chatgpt.com)                               | Medium |
| 47 | [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/?utm_source=chatgpt.com)                                 | Hard   |
| 48 | [Partition Labels](https://leetcode.com/problems/partition-labels/?utm_source=chatgpt.com)                                       | Medium |

Question 39 and 41 revisit earlier problems deliberately: solve them again without looking at the previous code, focusing on the pointer invariant.

## Phase 4 — Sliding window (Questions 49–62)

Goal: solve contiguous substring/subarray problems by maintaining a window instead of repeatedly recalculating it.

| #  | LeetCode problem                                                                                                                                                                                                     | Level  |
| -- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------ |
| 49 | [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/?utm_source=chatgpt.com)                                                                                                       | Easy   |
| 50 | [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/?utm_source=chatgpt.com)                                                                                                           | Medium |
| 51 | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/?utm_source=chatgpt.com)                                                               | Medium |
| 52 | [Permutation in String](https://leetcode.com/problems/permutation-in-string/?utm_source=chatgpt.com)                                                                                                                 | Medium |
| 53 | [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/?utm_source=chatgpt.com)                                                                                                 | Medium |
| 54 | [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/?utm_source=chatgpt.com)                                                                             | Medium |
| 55 | [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/?utm_source=chatgpt.com)                                                                                                         | Medium |
| 56 | [Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/?utm_source=chatgpt.com)                                                                                                                       | Medium |
| 57 | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/?utm_source=chatgpt.com)                                                                                                           | Hard   |
| 58 | [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/?utm_source=chatgpt.com)                                                                                                               | Hard   |
| 59 | [Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/?utm_source=chatgpt.com)                                                                                                   | Medium |
| 60 | [Number of Sub-arrays of Size K and Average Greater Than or Equal to Threshold](https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/?utm_source=chatgpt.com) | Medium |
| 61 | [Longest Nice Subarray](https://leetcode.com/problems/longest-nice-subarray/?utm_source=chatgpt.com)                                                                                                                 | Medium |
| 62 | [Count Number of Nice Subarrays](https://leetcode.com/problems/count-number-of-nice-subarrays/?utm_source=chatgpt.com)                                                                                               | Medium |

Patterns to master: fixed-size windows, variable-size windows, frequency-count windows, shrinking conditions, and monotonic deque.

## Phase 5 — Binary search and sorting (Questions 63–74)

Goal: master sorted search, boundary conditions, and searching over a possible answer.

| #  | LeetCode problem                                                                                                                                                         | Level  |
| -- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ------ |
| 63 | [Binary Search](https://leetcode.com/problems/binary-search/?utm_source=chatgpt.com)                                                                                     | Easy   |
| 64 | [Search Insert Position](https://leetcode.com/problems/search-insert-position/?utm_source=chatgpt.com)                                                                   | Easy   |
| 65 | [First Bad Version](https://leetcode.com/problems/first-bad-version/?utm_source=chatgpt.com)                                                                             | Easy   |
| 66 | [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/?utm_source=chatgpt.com) | Medium |
| 67 | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/?utm_source=chatgpt.com)                                                   | Medium |
| 68 | [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/?utm_source=chatgpt.com)                                       | Medium |
| 69 | [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/?utm_source=chatgpt.com)                                                                           | Medium |
| 70 | [Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/?utm_source=chatgpt.com)                                                                         | Medium |
| 71 | [Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/?utm_source=chatgpt.com)                                 | Medium |
| 72 | [Find Peak Element](https://leetcode.com/problems/find-peak-element/?utm_source=chatgpt.com)                                                                             | Medium |
| 73 | [Time Based Key-Value Store](https://leetcode.com/problems/time-based-key-value-store/?utm_source=chatgpt.com)                                                           | Medium |
| 74 | [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/?utm_source=chatgpt.com)                                                         | Hard   |

Patterns to master: lower and upper bounds, rotated arrays, binary search on the answer, monotonic feasibility conditions, and sorted-data queries.

## Phase 6 — Linked lists (Questions 75–84)

Goal: become comfortable with references, pointer changes, dummy nodes, and fast/slow pointers.

| #  | LeetCode problem                                                                                                           | Level  |
| -- | -------------------------------------------------------------------------------------------------------------------------- | ------ |
| 75 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/?utm_source=chatgpt.com)                           | Easy   |
| 76 | [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/?utm_source=chatgpt.com)               | Easy   |
| 77 | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/?utm_source=chatgpt.com)                               | Easy   |
| 78 | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/?utm_source=chatgpt.com)                     | Easy   |
| 79 | [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/?utm_source=chatgpt.com) | Medium |
| 80 | [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/?utm_source=chatgpt.com)                     | Easy   |
| 81 | [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/?utm_source=chatgpt.com)                         | Medium |
| 82 | [Reorder List](https://leetcode.com/problems/reorder-list/?utm_source=chatgpt.com)                                         | Medium |
| 83 | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/?utm_source=chatgpt.com)                                   | Medium |
| 84 | [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/?utm_source=chatgpt.com)       | Medium |

Patterns to master: pointer reversal, dummy head, fast/slow pointers, in-place merging, cycle entry, and node mapping.

## Phase 7 — Stacks, queues and monotonic stacks (Questions 85–96)

Goal: understand LIFO/FIFO, expression processing, and finding the next greater or smaller element.

| #  | LeetCode problem                                                                                                           | Level  |
| -- | -------------------------------------------------------------------------------------------------------------------------- | ------ |
| 85 | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/?utm_source=chatgpt.com)                               | Easy   |
| 86 | [Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/?utm_source=chatgpt.com)         | Easy   |
| 87 | [Min Stack](https://leetcode.com/problems/min-stack/?utm_source=chatgpt.com)                                               | Medium |
| 88 | [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/?utm_source=chatgpt.com) | Medium |
| 89 | [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/?utm_source=chatgpt.com)                             | Medium |
| 90 | [Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/?utm_source=chatgpt.com)                     | Easy   |
| 91 | [Online Stock Span](https://leetcode.com/problems/online-stock-span/?utm_source=chatgpt.com)                               | Medium |
| 92 | [Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/?utm_source=chatgpt.com)     | Hard   |
| 93 | [Asteroid Collision](https://leetcode.com/problems/asteroid-collision/?utm_source=chatgpt.com)                             | Medium |
| 94 | [Simplify Path](https://leetcode.com/problems/simplify-path/?utm_source=chatgpt.com)                                       | Medium |
| 95 | [Decode String](https://leetcode.com/problems/decode-string/?utm_source=chatgpt.com)                                       | Medium |
| 96 | [Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/?utm_source=chatgpt.com)                           | Medium |

Patterns to master: matching brackets, stack simulation, auxiliary state, monotonic increasing/decreasing stacks, and expression evaluation.

## Phase 8 — Trees and binary search trees (Questions 97–115)

Goal: master recursion, tree traversal, tree properties, BST invariants, and ancestor/path problems.

| #   | LeetCode problem                                                                                                                                                             | Level  |
| --- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------ |
| 97  | [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/?utm_source=chatgpt.com)                                                           | Easy   |
| 98  | [Same Tree](https://leetcode.com/problems/same-tree/?utm_source=chatgpt.com)                                                                                                 | Easy   |
| 99  | [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/?utm_source=chatgpt.com)                                                                               | Easy   |
| 100 | [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/?utm_source=chatgpt.com)                                                                                       | Easy   |
| 101 | [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/?utm_source=chatgpt.com)                                                 | Medium |
| 102 | [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/?utm_source=chatgpt.com)                                                                     | Easy   |
| 103 | [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/?utm_source=chatgpt.com)                                                                           | Easy   |
| 104 | [Path Sum](https://leetcode.com/problems/path-sum/?utm_source=chatgpt.com)                                                                                                   | Easy   |
| 105 | [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/?utm_source=chatgpt.com)                                                             | Medium |
| 106 | [Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/?utm_source=chatgpt.com)                       | Medium |
| 107 | [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/?utm_source=chatgpt.com)                                                             | Medium |
| 108 | [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/?utm_source=chatgpt.com)                                                         | Medium |
| 109 | [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?utm_source=chatgpt.com) | Medium |
| 110 | [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/?utm_source=chatgpt.com)                                                           | Hard   |
| 111 | [Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?utm_source=chatgpt.com)                                     | Medium |
| 112 | [Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/?utm_source=chatgpt.com)                                                                     | Easy   |
| 113 | [Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/?utm_source=chatgpt.com)                                               | Medium |
| 114 | [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/?utm_source=chatgpt.com)                                         | Hard   |
| 115 | [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/?utm_source=chatgpt.com)                                   | Medium |

Patterns to master: preorder/inorder/postorder, BFS level traversal, recursion return values, global vs. local state, BST range validation, and path aggregation.

## Phase 9 — Heaps, intervals and greedy algorithms (Questions 116–129)

Goal: choose the smallest/largest item efficiently, merge overlapping ranges, and recognize when a local choice can lead to a global optimum.

| #   | LeetCode problem                                                                                                         | Level  |
| --- | ------------------------------------------------------------------------------------------------------------------------ | ------ |
| 116 | [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/?utm_source=chatgpt.com) | Medium |
| 117 | [Last Stone Weight](https://leetcode.com/problems/last-stone-weight/?utm_source=chatgpt.com)                             | Easy   |
| 118 | [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/?utm_source=chatgpt.com)           | Medium |
| 119 | [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/?utm_source=chatgpt.com)       | Hard   |
| 120 | [Merge Intervals](https://leetcode.com/problems/merge-intervals/?utm_source=chatgpt.com)                                 | Medium |
| 121 | [Insert Interval](https://leetcode.com/problems/insert-interval/?utm_source=chatgpt.com)                                 | Medium |
| 122 | [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/?utm_source=chatgpt.com)             | Medium |
| 123 | [Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/?utm_source=chatgpt.com)                               | Medium |
| 124 | [Task Scheduler](https://leetcode.com/problems/task-scheduler/?utm_source=chatgpt.com)                                   | Medium |
| 125 | [Jump Game](https://leetcode.com/problems/jump-game/?utm_source=chatgpt.com)                                             | Medium |
| 126 | [Jump Game II](https://leetcode.com/problems/jump-game-ii/?utm_source=chatgpt.com)                                       | Medium |
| 127 | [Gas Station](https://leetcode.com/problems/gas-station/?utm_source=chatgpt.com)                                         | Medium |
| 128 | [Assign Cookies](https://leetcode.com/problems/assign-cookies/?utm_source=chatgpt.com)                                   | Easy   |
| 129 | [Hand of Straights](https://leetcode.com/problems/hand-of-straights/?utm_source=chatgpt.com)                             | Medium |

Patterns to master: min/max heap, top-K, two heaps, interval merging, sorting by endpoints, greedy reachability, and scheduling.

## Phase 10 — Recursion and backtracking (Questions 130–141)

Goal: learn how to explore choices, undo decisions, and prune unnecessary branches.

| #   | LeetCode problem                                                                                                                     | Level  |
| --- | ------------------------------------------------------------------------------------------------------------------------------------ | ------ |
| 130 | [Pow(x, n)](https://leetcode.com/problems/powx-n/?utm_source=chatgpt.com)                                                            | Medium |
| 131 | [Subsets](https://leetcode.com/problems/subsets/?utm_source=chatgpt.com)                                                             | Medium |
| 132 | [Subsets II](https://leetcode.com/problems/subsets-ii/?utm_source=chatgpt.com)                                                       | Medium |
| 133 | [Permutations](https://leetcode.com/problems/permutations/?utm_source=chatgpt.com)                                                   | Medium |
| 134 | [Combination Sum](https://leetcode.com/problems/combination-sum/?utm_source=chatgpt.com)                                             | Medium |
| 135 | [Combination Sum II](https://leetcode.com/problems/combination-sum-ii/?utm_source=chatgpt.com)                                       | Medium |
| 136 | [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/?utm_source=chatgpt.com) | Medium |
| 137 | [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/?utm_source=chatgpt.com)                                   | Medium |
| 138 | [Word Search](https://leetcode.com/problems/word-search/?utm_source=chatgpt.com)                                                     | Medium |
| 139 | [Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/?utm_source=chatgpt.com)                             | Medium |
| 140 | [N-Queens](https://leetcode.com/problems/n-queens/?utm_source=chatgpt.com)                                                           | Hard   |
| 141 | [Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/?utm_source=chatgpt.com)                                   | Medium |

Patterns to master: choose/explore/unchoose, include/exclude, permutations, combinations, constraint pruning, and recursion trees.

## Phase 11 — Graphs (Questions 142–166)

This section deserves extra attention given your earlier difficulty with graphs. Follow the sequence below, and do not jump directly to Dijkstra or MST.

| #   | LeetCode problem                                                                                                                                     | Level  |
| --- | ---------------------------------------------------------------------------------------------------------------------------------------------------- | ------ |
| 142 | [Find if Path Exists in Graph](https://leetcode.com/problems/find-if-path-exists-in-graph/?utm_source=chatgpt.com)                                   | Easy   |
| 143 | [Flood Fill](https://leetcode.com/problems/flood-fill/?utm_source=chatgpt.com)                                                                       | Easy   |
| 144 | [Number of Islands](https://leetcode.com/problems/number-of-islands/?utm_source=chatgpt.com)                                                         | Medium |
| 145 | [Max Area of Island](https://leetcode.com/problems/max-area-of-island/?utm_source=chatgpt.com)                                                       | Medium |
| 146 | [Number of Provinces](https://leetcode.com/problems/number-of-provinces/?utm_source=chatgpt.com)                                                     | Medium |
| 147 | [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/?utm_source=chatgpt.com)                                                             | Medium |
| 148 | [01 Matrix](https://leetcode.com/problems/01-matrix/?utm_source=chatgpt.com)                                                                         | Medium |
| 149 | [Clone Graph](https://leetcode.com/problems/clone-graph/?utm_source=chatgpt.com)                                                                     | Medium |
| 150 | [Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/?utm_source=chatgpt.com)                                                      | Medium |
| 151 | [Course Schedule](https://leetcode.com/problems/course-schedule/?utm_source=chatgpt.com)                                                             | Medium |
| 152 | [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/?utm_source=chatgpt.com)                                                       | Medium |
| 153 | [Redundant Connection](https://leetcode.com/problems/redundant-connection/?utm_source=chatgpt.com)                                                   | Medium |
| 154 | [Min Cost to Connect All Points](https://leetcode.com/problems/min-cost-to-connect-all-points/?utm_source=chatgpt.com)                               | Medium |
| 155 | [Network Delay Time](https://leetcode.com/problems/network-delay-time/?utm_source=chatgpt.com)                                                       | Medium |
| 156 | [Path With Minimum Effort](https://leetcode.com/problems/path-with-minimum-effort/?utm_source=chatgpt.com)                                           | Medium |
| 157 | [Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/?utm_source=chatgpt.com)                             | Medium |
| 158 | [All Paths From Source to Target](https://leetcode.com/problems/all-paths-from-source-to-target/?utm_source=chatgpt.com)                             | Medium |
| 159 | [Evaluate Division](https://leetcode.com/problems/evaluate-division/?utm_source=chatgpt.com)                                                         | Medium |
| 160 | [Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/?utm_source=chatgpt.com)                                                               | Medium |
| 161 | [Open the Lock](https://leetcode.com/problems/open-the-lock/?utm_source=chatgpt.com)                                                                 | Medium |
| 162 | [Surrounded Regions](https://leetcode.com/problems/surrounded-regions/?utm_source=chatgpt.com)                                                       | Medium |
| 163 | [Accounts Merge](https://leetcode.com/problems/accounts-merge/?utm_source=chatgpt.com)                                                               | Medium |
| 164 | [Satisfiability of Equality Equations](https://leetcode.com/problems/satisfiability-of-equality-equations/?utm_source=chatgpt.com)                   | Medium |
| 165 | [Path With Maximum Probability](https://leetcode.com/problems/path-with-maximum-probability/?utm_source=chatgpt.com)                                 | Medium |
| 166 | [Minimum Number of Vertices to Reach All Nodes](https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/?utm_source=chatgpt.com) | Medium |

Learn these subtopics in this order:

1. Graph representation and BFS/DFS: 142–150.
2. Directed cycles and topological sort: 151–152.
3. DSU and connectivity: 153, 163–164.
4. MST with Prim's or Kruskal's: 154.
5. Dijkstra and modified shortest paths: 155–157, 165.
6. Grid traversal, state-space BFS, and graph modeling: 143–149, 158–162, 166.

For Bellman–Ford, additionally implement the standard \\(V-1\\) relaxation passes yourself, then solve [Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/?utm_source=chatgpt.com) using bounded edge relaxations. This problem is useful for understanding why the number of edges used matters.

## Phase 12 — Dynamic programming (Questions 167–190)

DP deserves its own structured practice because it is usually the biggest jump from straightforward implementation to deeper reasoning.

| #   | LeetCode problem                                                                                                                                     | Level  |
| --- | ---------------------------------------------------------------------------------------------------------------------------------------------------- | ------ |
| 167 | [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/?utm_source=chatgpt.com)                                                             | Easy   |
| 168 | [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/?utm_source=chatgpt.com)                                           | Easy   |
| 169 | [House Robber](https://leetcode.com/problems/house-robber/?utm_source=chatgpt.com)                                                                   | Medium |
| 170 | [House Robber II](https://leetcode.com/problems/house-robber-ii/?utm_source=chatgpt.com)                                                             | Medium |
| 171 | [Fibonacci Number](https://leetcode.com/problems/fibonacci-number/?utm_source=chatgpt.com)                                                           | Easy   |
| 172 | [Decode Ways](https://leetcode.com/problems/decode-ways/?utm_source=chatgpt.com)                                                                     | Medium |
| 173 | [Coin Change](https://leetcode.com/problems/coin-change/?utm_source=chatgpt.com)                                                                     | Medium |
| 174 | [Coin Change II](https://leetcode.com/problems/coin-change-ii/?utm_source=chatgpt.com)                                                               | Medium |
| 175 | [Combination Sum IV](https://leetcode.com/problems/combination-sum-iv/?utm_source=chatgpt.com)                                                       | Medium |
| 176 | [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/?utm_source=chatgpt.com)                               | Medium |
| 177 | [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/?utm_source=chatgpt.com)                                       | Medium |
| 178 | [Edit Distance](https://leetcode.com/problems/edit-distance/?utm_source=chatgpt.com)                                                                 | Medium |
| 179 | [Unique Paths](https://leetcode.com/problems/unique-paths/?utm_source=chatgpt.com)                                                                   | Medium |
| 180 | [Unique Paths II](https://leetcode.com/problems/unique-paths-ii/?utm_source=chatgpt.com)                                                             | Medium |
| 181 | [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/?utm_source=chatgpt.com)                                                           | Medium |
| 182 | [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/?utm_source=chatgpt.com)                                       | Medium |
| 183 | [Target Sum](https://leetcode.com/problems/target-sum/?utm_source=chatgpt.com)                                                                       | Medium |
| 184 | [Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/?utm_source=chatgpt.com)                             | Medium |
| 185 | [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/?utm_source=chatgpt.com)                                               | Medium |
| 186 | [Word Break](https://leetcode.com/problems/word-break/?utm_source=chatgpt.com)                                                                       | Medium |
| 187 | [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/?utm_source=chatgpt.com)                                           | Medium |
| 188 | [Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/?utm_source=chatgpt.com) | Medium |
| 189 | [Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/?utm_source=chatgpt.com)                                     | Hard   |
| 190 | [Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/?utm_source=chatgpt.com)                                         | Hard   |

Patterns to master: one-dimensional DP, take/skip, memoization vs. tabulation, grid DP, subsequence DP, knapsack, state-machine DP, and interval/string DP.

Do not memorize a separate formula for every question. For each one, write down:

- State: what does `dp[i]` or `dp[i][j]` mean?
- Transition: how does the current state depend on earlier states?
- Base cases: what is known before the main computation?
- Evaluation order: which states must be computed first?
- Complexity: how many states and transitions are there?

## Phase 13 — Bit manipulation and math (Questions 191–200)

Goal: get comfortable with XOR, bit masks, parity, and basic number theory.

| #   | LeetCode problem                                                                                 | Level  |
| --- | ------------------------------------------------------------------------------------------------ | ------ |
| 191 | [Single Number](https://leetcode.com/problems/single-number/?utm_source=chatgpt.com)             | Easy   |
| 192 | [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/?utm_source=chatgpt.com)       | Easy   |
| 193 | [Counting Bits](https://leetcode.com/problems/counting-bits/?utm_source=chatgpt.com)             | Easy   |
| 194 | [Missing Number](https://leetcode.com/problems/missing-number/?utm_source=chatgpt.com)           | Easy   |
| 195 | [Reverse Bits](https://leetcode.com/problems/reverse-bits/?utm_source=chatgpt.com)               | Easy   |
| 196 | [Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/?utm_source=chatgpt.com) | Medium |
| 197 | [Power of Two](https://leetcode.com/problems/power-of-two/?utm_source=chatgpt.com)               | Easy   |
| 198 | [Pow(x, n)](https://leetcode.com/problems/powx-n/?utm_source=chatgpt.com)                        | Medium |
| 199 | [Sqrt(x)](https://leetcode.com/problems/sqrtx/?utm_source=chatgpt.com)                           | Easy   |
| 200 | [Happy Number](https://leetcode.com/problems/happy-number/?utm_source=chatgpt.com)               | Easy   |

Patterns to master: XOR cancellation, bit counting, shifts, masks, fast exponentiation, binary search for integer square root, and cycle detection in numeric sequences.

A few problems intentionally revisit earlier concepts, such as `Missing Number` and `Pow(x, n)`. Solve them again using the specific technique you are practicing in this phase.

## 3. How to use this list to clear your DSA round

Solving all 200 once is not enough. Your target should be independent problem-solving, not a high solved count.

### Follow this rule for every problem

Step 1 — Attempt independently

Spend 25–35 minutes on Easy/Medium problems. Identify the brute-force solution first, then improve it.

Step 2 — Document the pattern

Write the intuition, approach, Java code, time complexity, space complexity, and one tricky test case.

Step 3 — Revisit after 2–3 days

Close your previous solution and implement it again from memory. If you cannot, mark it for revision.

Step 4 — Explain aloud

Pretend the interviewer asks why your solution works, why another approach is slower, and how your code handles edge cases.

### A realistic timeline

| Daily commitment | Approximate time for 200 problems |
| ---------------- | --------------------------------- |
| 1 problem/day    | 6–7 months                        |
| 2 problems/day   | 3–4 months                        |
| 3 problems/day   | 10–12 weeks                       |

These estimates assume time for learning, debugging, and revision. Three new problems every day is not necessarily better than two problems that you can solve again independently.

## 4. Your progress tracker

Use this tracker to record completed problems. The main list above is your reference; this tracker helps you see how consistently you are working.

## DSA preparation dashboard

Problems completed

# 0 / 200

# 0%

Problems completed so far

0–200

0

100

200

### Plan your pace

New problems per day

1 problem — slower, deeper learning

2 problems — balanced pace

3 problems — intensive preparation

Minutes per day for DSA

30 minutes

1 hour

1.5 hours

2 hours

Estimated time to finish remaining problems

# 100 days

At 2 new problems/day, excluding revision days and difficult problems that need extra time.

&#x20;Copy progress summary

## 5. My recommendation for you

Start with Questions 1–36. Don't skip the easy problems because they build the fundamentals needed for sliding window, prefix sum, graphs, and DP.

For Java interviews, also practice writing clean methods without relying on IDE autocomplete, handling nulls and boundary conditions where applicable, and explaining complexity clearly.

Once you have completed your first 10 questions, bring me the question numbers you struggled with and your code for one or two of them. We can debug your reasoning, identify the pattern you missed, and strengthen that topic before moving forward.

Your goal is not to memorize 200 solutions. It is to recognize 20–30 core patterns and apply them to unfamiliar problems.