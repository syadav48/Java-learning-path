Perfect — let’s do a **deep, complete breakdown of `Stack` in Java** — its structure, use cases, how it extends `Vector`, and when to use it (vs LinkedList, Deque, etc.).
This is a **classic interview topic** — often tested alongside `Queue`, `Deque`, and `LinkedList`.

---

# 🧱 Stack in Java — Full Concept

---

## 🧠 1️⃣ What is a Stack?

A **Stack** is a **linear data structure** that follows the **LIFO (Last In, First Out)** principle.

> 🧩 The last element pushed into the stack is the first one popped out.

Think of it like a **stack of plates** —
you put plates one over another (push), and remove from the top (pop).

---

## ⚙️ 2️⃣ Class Definition

In Java, `Stack` is a **class** in the `java.util` package.

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
```

✅ **Hierarchy:**

```
java.lang.Object
   ↳ java.util.AbstractCollection
        ↳ java.util.AbstractList
             ↳ java.util.Vector
                  ↳ java.util.Stack
```

So yes —
👉 `Stack` **extends Vector** (and therefore inherits all its synchronized methods).
That means **Stack is thread-safe** — but slower in single-threaded use.

---

## 🧩 3️⃣ Core Methods of Stack

| Method                | Description                                            |
| --------------------- | ------------------------------------------------------ |
| `push(E item)`        | Pushes (adds) an element to the top                    |
| `pop()`               | Removes and returns the top element                    |
| `peek()`              | Returns top element without removing                   |
| `empty()`             | Returns true if stack is empty                         |
| `search(Object o)`    | Returns 1-based position from top (or -1 if not found) |
| Inherited from Vector | `size()`, `capacity()`, `contains()`, `clear()` etc.   |

---

## 🔍 4️⃣ Example

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // Push elements
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Stack: " + stack); // [A, B, C]

        // Peek top element
        System.out.println("Top element: " + stack.peek()); // C

        // Pop element
        System.out.println("Popped: " + stack.pop()); // C

        System.out.println("After pop: " + stack); // [A, B]

        // Search element
        System.out.println("Position of A: " + stack.search("A")); // 2

        // Empty check
        System.out.println("Is empty? " + stack.empty()); // false
    }
}
```

---

## 🧩 5️⃣ Real-World Use Cases

| Use Case                     | Description                                |
| ---------------------------- | ------------------------------------------ |
| **Undo/Redo in Editors**     | Actions stored in stack → undo last action |
| **Browser Back/Forward**     | Each visited page pushed to stack          |
| **Expression Evaluation**    | For postfix/infix/prefix expressions       |
| **Recursion Tracking**       | Call stack maintains active method calls   |
| **Parentheses Matching**     | Checking balanced parentheses              |
| **DFS (Depth-First Search)** | Stack is used to explore nodes             |

---

## 🧮 6️⃣ Stack Implementation Using LinkedList

Although `Stack` extends `Vector`,
the **modern recommendation** is to use **`Deque`** (e.g. `LinkedList` or `ArrayDeque`) for stack behavior — because it’s faster and non-synchronized.

### Example using LinkedList

```java
import java.util.LinkedList;

public class LinkedListStack {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();

        // Push (addFirst)
        stack.addFirst(10);
        stack.addFirst(20);
        stack.addFirst(30);

        System.out.println("Stack: " + stack); // [30, 20, 10]

        // Peek (getFirst)
        System.out.println("Top: " + stack.getFirst()); // 30

        // Pop (removeFirst)
        System.out.println("Popped: " + stack.removeFirst()); // 30

        System.out.println("Stack after pop: " + stack); // [20, 10]
    }
}
```

✅ This uses `addFirst()` and `removeFirst()` for **LIFO behavior**.
Much more efficient and modern than `Stack`.

---

## ⚖️ 7️⃣ Stack vs LinkedList vs ArrayDeque

| Feature             | Stack                     | LinkedList (as stack)        | ArrayDeque                         |
| ------------------- | ------------------------- | ---------------------------- | ---------------------------------- |
| **Synchronization** | ✅ Yes (thread-safe)       | ❌ No                         | ❌ No                               |
| **Performance**     | 🐢 Slower                 | ⚡ Faster                     | ⚡⚡ Fastest                         |
| **Growable**        | Yes                       | Yes                          | Yes                                |
| **Preferred Use**   | Multithreaded legacy code | Simple stack with LinkedList | ✅ Modern Java stack implementation |

---

## 🧠 8️⃣ Points to Remember

1. `Stack` is **synchronized** (thread-safe) because it extends `Vector`.
2. Slower in single-threaded environments — prefer `ArrayDeque` or `LinkedList`.
3. Follows **LIFO** order.
4. Avoid mixing `Vector` methods (`add`, `remove`) directly with stack operations — stick to `push`, `pop`, `peek`.
5. `search()` returns **1-based index** from top.
6. For **multi-threaded apps**, still works fine — but rarely used today.

---

## 💡 9️⃣ Real World Example: Balanced Parentheses

```java
import java.util.Stack;

public class BalancedParentheses {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '['))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[()]}";
        System.out.println(isBalanced(s)); // true
    }
}
```

✅ Perfect interview example using Stack.

---

## 🧩 10️⃣ Quick Summary

| Concept                | Details                                                     |
| ---------------------- | ----------------------------------------------------------- |
| **Type**               | Legacy synchronized class (extends Vector)                  |
| **Order**              | LIFO                                                        |
| **Thread-safe**        | ✅ Yes                                                       |
| **Modern Alternative** | `ArrayDeque`                                                |
| **Common Uses**        | Undo/Redo, DFS, Expression evaluation, Parentheses matching |
| **Important Methods**  | push(), pop(), peek(), empty(), search()                    |

---

Would you like me to show the **same balanced parentheses** example rewritten using **`ArrayDeque` (modern way)** — it’s much faster and what you should actually use in real Java projects today?
