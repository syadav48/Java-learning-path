Kadane’s Algorithm is one of the **most famous and elegant algorithms** in dynamic programming.
It solves the **Maximum Subarray Sum Problem** in **O(n)** time.

---

# 🎯 **What Problem Does Kadane's Algorithm Solve?**

Given an array of integers (can include negatives), find the **maximum possible sum of a contiguous subarray**.

Example:

```
nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
```

The maximum sum subarray is:

```
[4, -1, 2, 1] = 6
```

---

# 🧠 **The Core Idea**

When you iterate through the array, at every index you decide:

> **Should I extend the previous subarray OR start a new one?**

For each element `nums[i]`, you compute:

```
currentMax = max(nums[i], currentMax + nums[i])
```

Then update the global max:

```
maxSoFar = max(maxSoFar, currentMax)
```

This ensures:

* If the previous sum becomes negative → **start new subarray**
* If it’s positive → **keep adding**

This is why the algorithm is fast and optimal.

---

# ✅ **Kadane’s Algorithm (Java)**

```java
public int maxSubArray(int[] nums) {
    int current = nums[0];
    int max = nums[0];

    for (int i = 1; i < nums.length; i++) {
        current = Math.max(nums[i], current + nums[i]);
        max = Math.max(max, current);
    }

    return max;
}
```

Time complexity: **O(n)**
Space complexity: **O(1)**

---

# 🧩 **Why It Works (Intuition)**

Imagine you are carrying a running sum:

* If the running sum becomes **negative**, carrying it forward will only **damage** the next segment.
* If the running sum is **positive**, it helps increase future sums.

So:

* Drop the sum when negative.
* Keep it when positive.

---

# 📌 **Small Example: nums = [-2, 1]**

| i | nums[i] | current calculation | current | max |
| - | ------- | ------------------- | ------- | --- |
| 0 | -2      | —                   | -2      | -2  |
| 1 | 1       | max(1, -2 + 1 = -1) | 1       | 1   |

Final answer: **1**

---

# ⭐ Why Two-Pointer Approach Fails But Kadane Works

The max subarray must be **contiguous**, and its boundaries cannot be determined by comparing left/right values.
Removing elements based on heuristics breaks valid subarrays.

Kadane checks **every possible subarray ending at each index**, but in a smart constant-time way.

---

If you want, I can visualize Kadane’s algorithm step-by-step using a trace diagram.
