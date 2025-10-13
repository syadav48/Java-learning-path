Excellent — this is one of the **most asked Java interview topics** and is crucial to understand clearly.
Let’s break it down properly 👇

---

## 🔹 1. Comparable Interface

**Package:** `java.lang`
**Method:**

```java
int compareTo(T o);
```

### ➤ Purpose:

Used when you want **natural ordering** of objects — i.e. the class itself defines how its objects should be compared.

### ➤ How to Use:

You implement the `Comparable` interface **inside your class** and override `compareTo()` method.

### ➤ Example:

```java
class Student implements Comparable<Student> {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Natural ordering: by id
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3, "Amit"));
        list.add(new Student(1, "Raj"));
        list.add(new Student(2, "Neha"));

        Collections.sort(list); // uses compareTo()

        for (Student s : list) {
            System.out.println(s.id + " " + s.name);
        }
    }
}
```

### ➤ Output:

```
1 Raj
2 Neha
3 Amit
```

✅ **Key Points:**

* Defines a **default (natural) sorting order** for the class.
* You can only have **one compareTo()** logic inside a class.
* Common for: `String`, `Integer`, `Double`, etc. (they all implement Comparable).

---

## 🔹 2. Comparator Interface

**Package:** `java.util`
**Method:**

```java
int compare(T o1, T o2);
```

### ➤ Purpose:

Used when you want **custom ordering** or **multiple sorting strategies** without modifying the class.

### ➤ How to Use:

Create a separate class or lambda that implements `Comparator`.

### ➤ Example:

```java
class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class SortByName implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

class SortByIdDesc implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return Integer.compare(s2.id, s1.id);
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3, "Amit"));
        list.add(new Student(1, "Raj"));
        list.add(new Student(2, "Neha"));

        Collections.sort(list, new SortByName()); // sort by name ascending
        System.out.println("Sort by Name:");
        list.forEach(s -> System.out.println(s.id + " " + s.name));

        Collections.sort(list, new SortByIdDesc()); // sort by id descending
        System.out.println("\nSort by ID (Desc):");
        list.forEach(s -> System.out.println(s.id + " " + s.name));
    }
}
```

---

## 🔹 3. Comparator with Lambda (Java 8+)

Cleaner and more modern approach:

```java
Collections.sort(list, (s1, s2) -> s1.name.compareTo(s2.name));
```

Or using Stream API:

```java
list.stream()
    .sorted(Comparator.comparing(s -> s.name))
    .forEach(s -> System.out.println(s.name));
```

---

## 🔹 4. Difference Summary

| Feature                  | Comparable          | Comparator                                |
| ------------------------ | ------------------- | ----------------------------------------- |
| Package                  | `java.lang`         | `java.util`                               |
| Method                   | `compareTo(T o)`    | `compare(T o1, T o2)`                     |
| Sorting                  | Natural / Default   | Custom / Multiple                         |
| Used in                  | Class itself        | External class / lambda                   |
| Modifies original class? | Yes                 | No                                        |
| Example                  | `String`, `Integer` | Custom logic like sort by name, age, etc. |

---

## 🔹 5. When to Use

* ✅ **Comparable:** When your class has **only one natural sort order** (e.g., sorting students by roll number).
* ✅ **Comparator:** When you need **different sorting criteria** dynamically (e.g., sort by name, then by age, etc.).

---

## 🔹 6. Real-World Example

In applications like:

* Sorting search results (price low→high, rating high→low)
* Sorting users (alphabetically or by registration date)
* Ordering tasks by priority
  👉 You use **Comparator** for flexible, user-driven sorting.

---

Would you like me to add an **under-the-hood explanation** of how `compareTo()` is used in `Collections.sort()` (like how TimSort leverages comparison)?
