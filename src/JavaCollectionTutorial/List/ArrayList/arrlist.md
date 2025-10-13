Perfect 👏 — this is one of those **Java Collection Framework** questions that come up often in interviews — and understanding `capacity` vs `size` is crucial to writing efficient code.

Let’s break everything down clearly 👇

---

## 🧩 1️⃣ ArrayList – Internal Structure

`ArrayList` in Java is a **dynamic array**, which means it **grows automatically** when you add elements.

Internally, it uses an **array** (usually called `elementData`) to store objects.

---

## 🔍 2️⃣ Capacity vs Size

| Term         | Meaning                                                                                 | Example                                                 |
| ------------ | --------------------------------------------------------------------------------------- | ------------------------------------------------------- |
| **Capacity** | The **total number of elements** the internal array can currently hold before resizing. | If capacity = 10 → can store 10 elements before growing |
| **Size**     | The **actual number of elements** currently stored.                                     | If you added 3 items → size = 3                         |

👉 So,

```java
ArrayList<String> list = new ArrayList<>();
```

* Initially: size = 0
* Default capacity = 10 (in Java 8+, created lazily on first add)

After adding 3 elements:

```java
list.add("A");
list.add("B");
list.add("C");
```

* size = 3
* capacity = 10

When it exceeds capacity (say, add 11th element), the new capacity becomes roughly **1.5 times old capacity**.

---

## 🧮 3️⃣ Can we print capacity?

Not directly — because `capacity` is **not exposed** via any public method.
But you can see it using **reflection** (for learning/testing purposes only):

```java
import java.util.ArrayList;
import java.lang.reflect.Field;

public class CapacityCheck {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>(5);
        list.add(1);
        list.add(2);

        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(list);
        System.out.println("Capacity: " + elementData.length);
        System.out.println("Size: " + list.size());
    }
}
```

🖨 Output:

```
Capacity: 5
Size: 2
```

> ⚠️ But note: reflection should not be used in production for this. It’s just to understand how `ArrayList` works internally.

---

## 🧰 4️⃣ Ways to Create Lists

Here are **all the common ways** to create a list, and when to use each 👇

| Way                              | Example                                             | Mutability                        | When to Use                                                |
| -------------------------------- | --------------------------------------------------- | --------------------------------- | ---------------------------------------------------------- |
| **1. Using new ArrayList()**     | `List<String> list = new ArrayList<>();`            | ✅ Mutable                         | When you need a dynamic, modifiable list                   |
| **2. Using Arrays.asList()**     | `List<String> list = Arrays.asList("A", "B", "C");` | ⚠️ Fixed-size (cannot add/remove) | When you just need a list view of an array                 |
| **3. Using List.of() (Java 9+)** | `List<String> list = List.of("A", "B", "C");`       | ❌ Immutable                       | When you need a read-only list                             |
| **4. With initial capacity**     | `List<String> list = new ArrayList<>(50);`          | ✅ Mutable                         | When you know approx. number of elements — avoids resizing |
| **5. Copying another list**      | `List<String> newList = new ArrayList<>(oldList);`  | ✅ Mutable                         | When you want a modifiable copy of an existing list        |
| **6. Empty list (unmodifiable)** | `List<String> list = Collections.emptyList();`      | ❌ Immutable                       | To return an empty list safely from a method               |

---

## 💡 5️⃣ When to Use What

| Scenario                                  | Best Way                           |
| ----------------------------------------- | ---------------------------------- |
| You’ll add/remove elements dynamically    | `new ArrayList<>()`                |
| You have a fixed set of items (constants) | `List.of()`                        |
| You have an array and want a list view    | `Arrays.asList(array)`             |
| You know approximate number of items      | `new ArrayList<>(initialCapacity)` |
| Returning an empty list from a method     | `Collections.emptyList()`          |

---

## 🧠 6️⃣ Example – Demonstrating Size vs Capacity

```java
ArrayList<Integer> nums = new ArrayList<>(3);
nums.add(10);
nums.add(20);
nums.add(30);
nums.add(40);

System.out.println("Size: " + nums.size()); // 4
// Capacity will be > 3 (resized internally)
```

> Internally capacity grows as per formula:
> `newCapacity = oldCapacity + (oldCapacity >> 1)`  → i.e., 1.5x

So:

* Start with 3
* Add 4th → grows to 4 + 2 = 6 (approx.)

---

## ⚙️ Summary

| Concept                 | Description                               |
| ----------------------- | ----------------------------------------- |
| **Size**                | Number of elements actually in list       |
| **Capacity**            | Length of internal array holding elements |
| **Default capacity**    | 10 (after first add)                      |
| **Growth rate**         | ~1.5× old capacity                        |
| **Can print capacity?** | Not directly (only via reflection)        |

---

Would you like me to show a **visual diagram** (array slots showing capacity vs size growth after each addition)? It makes the concept super clear visually.
