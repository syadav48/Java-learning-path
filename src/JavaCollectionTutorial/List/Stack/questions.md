Perfect — since you’ve already covered **Stack theory (using LinkedList, not Deque)**, let’s now move to **intermediate-level coding and logic questions** that deepen understanding of Stack operations (`push`, `pop`, `peek`, etc.), recursion-based use cases, and problem-solving applications.

Here are **10 intermediate Stack questions** with short hints and sample inputs/outputs 👇

---

| #      | Question                                                      | Description / Expected Output                                                    | Hint / Concept                                                        |
| ------ | ------------------------------------------------------------- | -------------------------------------------------------------------------------- | --------------------------------------------------------------------- |
| **1**  | **Reverse a String using Stack**                              | Input: `"hello"` → Output: `"olleh"`                                             | Push all characters, then pop to reverse.                             |
| **2**  | **Check for Balanced Parentheses**                            | Input: `"{[()]}"` → Output: `true`; Input: `"{[(])}"` → `false`                  | Push opening brackets, pop for closing ones, validate matching pairs. |
| **3**  | **Evaluate Postfix Expression**                               | Input: `"231*+9-"` → Output: `-4`                                                | Use Stack to evaluate operands and operators in postfix notation.     |
| **4**  | **Next Greater Element**                                      | Input: `[4, 5, 2, 10]` → Output: `[5, 10, 10, -1]`                               | Traverse from right, use Stack to track next greater values.          |
| **5**  | **Delete Middle Element of Stack (without extra DS)**         | Input: `[1,2,3,4,5]` → Output: `[1,2,4,5]`                                       | Use recursion to pop mid element, then rebuild stack.                 |
| **6**  | **Sort Stack using Recursion**                                | Input: `[3,5,1,4,2]` → Output: `[1,2,3,4,5]`                                     | Recursively pop all, insert back in sorted order.                     |
| **7**  | **Reverse Stack using only Recursion**                        | Input: `[1,2,3,4]` → Output: `[4,3,2,1]`                                         | Use recursion and helper insert-at-bottom logic.                      |
| **8**  | **Stock Span Problem**                                        | Input: `[100, 80, 60, 70, 60, 75, 85]` → Output: `[1,1,1,2,1,4,6]`               | Use Stack to track indices of prices for span calculation.            |
| **9**  | **Find Minimum Element in Stack (without using extra space)** | Input: push(5), push(2), push(10), push(1), getMin() → Output: `1`               | Use encoded values or helper min variable logic.                      |
| **10** | **Celebrity Problem (Stack approach)**                        | Input: 2D matrix of acquaintance: `M[i][j]` → Output: index of celebrity or `-1` | Pop two, eliminate non-celebs, verify last one.                       |

---

### 💡 Additional Notes:

* You can use `Stack<Integer>` or `LinkedList<Integer>` as a stack (`push()`, `pop()`, `peek()`).
* For recursion-based problems (#5, #6, #7), avoid additional data structures — rely purely on function calls.
* For algorithmic ones (#8, #10), focus on **O(n)** stack-based optimizations.

---

Would you like me to give you **solutions (with code + step-by-step explanation)** for the first 3 questions first, before going deeper into the advanced Stack questions?
