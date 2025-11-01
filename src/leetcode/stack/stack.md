That’s *exactly* how you should be thinking — not just solving problems, but mastering the **concepts and patterns** behind them 👏

Here’s a complete **Stack Mastery Sheet** — clean, practical, and built for LeetCode-style thinking.

---

# 🧱 STACK — Concept, Notes, and Patterns

---

## 🔹 1. What is a Stack?

A **stack** is a data structure that follows **LIFO (Last In, First Out)**.

### Example:

Imagine a pile of plates —
you put one on top (push), and the last one placed is removed first (pop).

| Operation   | Description                       |
| ----------- | --------------------------------- |
| `push(x)`   | Add element x to top              |
| `pop()`     | Remove and return top element     |
| `peek()`    | View top element without removing |
| `isEmpty()` | Check if stack is empty           |

---

## 🔹 2. Stack Implementation in Java

### Using `java.util.Stack`:

```java
Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
int top = stack.peek();  // 20
stack.pop();             // removes 20
boolean empty = stack.isEmpty(); // false
```

### Using `Deque` (Recommended — faster, modern):

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);
stack.push(20);
stack.pop();
stack.peek();
```

---

## 🔹 3. Complexity

| Operation          | Time |
| ------------------ | ---- |
| Push               | O(1) |
| Pop                | O(1) |
| Peek               | O(1) |
| Search (if needed) | O(n) |

---

## 🔹 4. Core Stack Thinking Patterns

### 🧩 Pattern 1: **Matching / Balancing**

Use stack to check **balanced parentheses**, **valid strings**, **remove duplicates**, etc.

🧠 Key idea:

* Push open symbols.
* Pop on closing symbols.
* Stack empty → valid.

Example Problems:

* Valid Parentheses
* Remove Adjacent Duplicates
* Make String Great

---

### 🧩 Pattern 2: **Monotonic Stack**

Maintain stack in **increasing or decreasing order** to track **next greater/smaller elements**.

🧠 Core idea:

* Pop while current breaks monotonic order.
* Used to find **next greater element**, **temperature days**, **histogram area**, etc.

Example flow:

```java
for (int i = 0; i < n; i++) {
    while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        int idx = stack.pop();
        nextGreater[idx] = arr[i];
    }
    stack.push(i);
}
```

💡 Pattern triggers:

> “Next greater/smaller”, “previous greater/smaller”, “span”, “temperature”, “stock”.

---

### 🧩 Pattern 3: **Auxiliary Stack / Two-Stack Technique**

When one stack alone isn’t enough.

Examples:

* Implement `MinStack` → one normal stack + one min-tracking stack.
* Implement queue using two stacks (classic interview question).

---

### 🧩 Pattern 4: **Stack for Evaluation**

Used for **postfix, prefix**, or **infix** expressions.

🧠 Concept:

* Read tokens.
* Push operands.
* On operator, pop two operands → apply → push result.

---

### 🧩 Pattern 5: **Recursion Simulation**

When recursion is too deep, or you want to manually control the call stack (DFS, parsing, backtracking).

You push frames manually (like function calls).

---

## 🔹 5. Tricks & Tips 🧠

| Trick                                               | Explanation                                                |
| --------------------------------------------------- | ---------------------------------------------------------- |
| 🔸 Use `StringBuilder` as stack for string problems | Faster than `Stack<Character>`                             |
| 🔸 `while (!stack.isEmpty() && condition)`          | Common monotonic stack loop pattern                        |
| 🔸 Don’t modify and iterate same stack              | Use index or two stacks                                    |
| 🔸 For char comparison (case toggle)                | `Math.abs(a - b) == 32` for 'a'-'A'                        |
| 🔸 When restarting loop feels messy                 | Think "Can I model this as a stack?"                       |
| 🔸 Stack can store indices                          | Great for range-based problems (`i - stack.peek()`)        |
| 🔸 Think visually                                   | Draw stack top-down — it clarifies popping logic instantly |

---

## 🔹 6. Common Mistakes 😅

1. Forgetting `isEmpty()` check before `peek()` or `pop()`
2. Using wrong data structure (like List) instead of Stack for O(1) pop
3. Modifying stack while iterating over it
4. Mixing push/pop order (especially when using indices)
5. Confusing stack content (indices vs values)

---

## 🔹 7. Stack-Based Problem Categories

| Category                       | Common Problems                                                          | Core Idea                |
| ------------------------------ | ------------------------------------------------------------------------ | ------------------------ |
| ✅ Parentheses / String Cleanup | Valid Parentheses, Remove Duplicates, Make String Great                  | Push/Pop character pairs |
| 🔥 Next Greater/Smaller        | Next Greater Element, Daily Temperatures, Largest Rectangle in Histogram | Monotonic Stack          |
| 🧮 Expression Evaluation       | Evaluate Reverse Polish Notation, Infix to Postfix                       | Operands & operators     |
| 🪜 DFS / Recursion Replacement | Binary Tree Traversal, Expression Parsing                                | Manual call stack        |
| 🧰 Min/Max tracking            | Min Stack, Max Stack                                                     | Use helper stack         |

---

## 🔹 8. Practice Patterns Summary

| Problem Type    | Stack Usage          | Key Operation               |
| --------------- | -------------------- | --------------------------- |
| String cleanup  | push/pop chars       | condition on adjacent       |
| Valid string    | push open, pop close | validate balance            |
| Histogram area  | push indices         | pop when smaller found      |
| Next greater    | push indices         | compare current & stack top |
| Expression eval | push operands        | apply operator              |
| Decode string   | nested stack         | push partial results        |

---

## 🔹 9. Example Short Implementations

### 🧩 1. Basic Stack

```java
Stack<Integer> st = new Stack<>();
st.push(10);
st.pop();
st.peek();
```

### 🧩 2. String-based Stack

```java
StringBuilder stack = new StringBuilder();
for (char c : s.toCharArray()) {
    if (stack.length() > 0 && stack.charAt(stack.length() - 1) == c)
        stack.deleteCharAt(stack.length() - 1);
    else
        stack.append(c);
}
```

### 🧩 3. Monotonic Stack (Next Greater)

```java
int[] res = new int[n];
Stack<Integer> st = new Stack<>();
for (int i = 0; i < n; i++) {
    while (!st.isEmpty() && arr[st.peek()] < arr[i])
        res[st.pop()] = arr[i];
    st.push(i);
}
```

---

## 🔹 10. Golden Rule 💡

> **When you need to “look back” or “undo” something — think Stack.**

Examples:

* Compare current with last seen → Stack.
* Remove previous when invalid → Stack.
* Evaluate nested → Stack.
* Next greater/smaller → Stack.

---

Would you like me to make a **visual cheat sheet (diagram style)** summarizing these patterns (stack flow, monotonic stack, string cleanup, etc.) — one you can keep as quick reference?
