🔥 Excellent — this is one of the *most fundamental yet tricky* areas of Java collections and functional programming.
Understanding **`Comparable`**, **`Comparator`**, **`comparing()`**, and **lambda/method references** will make you a **pro** at sorting and custom ordering — a must-have skill for Java backend interviews and real-world work (like sorting users, orders, or transactions).

Let’s break it all down **step-by-step with deep explanation + examples + 10 practice problems** 👇

---

## 🧩 1️⃣ Comparable vs Comparator — The Core Difference

| Feature                    | `Comparable<T>`                                   | `Comparator<T>`                                   |
| -------------------------- | ------------------------------------------------- | ------------------------------------------------- |
| **Package**                | `java.lang`                                       | `java.util`                                       |
| **Purpose**                | Defines *natural ordering* of objects             | Defines *custom ordering* of objects              |
| **Method to implement**    | `compareTo(T o)`                                  | `compare(T o1, T o2)`                             |
| **Modifies class itself?** | ✅ Yes (class implements `Comparable`)             | ❌ No (external comparator)                        |
| **Used by**                | `Collections.sort(list)` (no comparator argument) | `Collections.sort(list, comparator)`              |
| **When to use**            | When object has a *default sorting logic*         | When you want *different ways to sort* same class |

---

## 🧠 2️⃣ `Comparable<T>` – Natural Ordering (Inside Class)

Example: Sort by `id` (ascending) naturally.

```java
class Employee implements Comparable<Employee> {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Employee e) {
        return this.id - e.id;  // ascending
    }

    public String toString() {
        return id + " - " + name;
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Employee> list = List.of(
            new Employee(3, "Amit"),
            new Employee(1, "Raj"),
            new Employee(2, "Sita")
        );

        List<Employee> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        System.out.println(sorted);
    }
}
```

✅ Output:

```
[1 - Raj, 2 - Sita, 3 - Amit]
```

---

## ⚙️ 3️⃣ `Comparator<T>` – Custom Sorting (Outside Class)

You can define multiple sorting logics for the same class.

```java
import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id; this.name = name; this.salary = salary;
    }

    public String toString() {
        return id + " - " + name + " - " + salary;
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(3, "Amit", 40000));
        list.add(new Employee(1, "Raj", 50000));
        list.add(new Employee(2, "Sita", 45000));

        // Sort by salary
        Comparator<Employee> bySalary = (e1, e2) -> Double.compare(e1.salary, e2.salary);
        Collections.sort(list, bySalary);

        System.out.println(list);
    }
}
```

✅ Output:

```
[3 - Amit - 40000.0, 2 - Sita - 45000.0, 1 - Raj - 50000.0]
```

---

## ⚡ 4️⃣ Using **Lambda Expressions**

Since `Comparator` is a **functional interface**, we can write it concisely:

```java
list.sort((e1, e2) -> e1.name.compareTo(e2.name));
```

or even shorter using `Comparator.comparing` 👇

```java
list.sort(Comparator.comparing(e -> e.name));
```

---

## 💥 5️⃣ Using **Method Reference**

If the getter or field name matches your sorting logic:

```java
list.sort(Comparator.comparing(Employee::getSalary));
```

or in reverse order:

```java
list.sort(Comparator.comparing(Employee::getSalary).reversed());
```

---

## 🧮 6️⃣ Chaining Comparators (thenComparing)

When multiple sort conditions are needed:

```java
list.sort(Comparator.comparing(Employee::getSalary)
                    .thenComparing(Employee::getName));
```

> Sorts by salary first; if same salary, then by name.

---

## 🧩 7️⃣ Static Helper Methods in `Comparator`

| Method                         | Description              |
| ------------------------------ | ------------------------ |
| `comparing(Function)`          | Compares by a property   |
| `thenComparing(Function)`      | Secondary comparison     |
| `reverseOrder()`               | Reverse natural order    |
| `naturalOrder()`               | Default natural ordering |
| `nullsFirst()` / `nullsLast()` | Handles null safely      |

Example:

```java
list.sort(Comparator.comparing(Employee::getName, Comparator.nullsLast(String::compareTo)));
```

---

## 🧠 8️⃣ Practical Example – Mixing All Concepts

```java
import java.util.*;

class Student {
    String name;
    int marks;
    int age;

    Student(String name, int marks, int age) {
        this.name = name; this.marks = marks; this.age = age;
    }

    public String toString() {
        return name + " (" + marks + ", " + age + ")";
    }
}

public class StudentSorting {
    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Amit", 80, 22),
            new Student("Raj", 80, 21),
            new Student("Sita", 95, 23),
            new Student("Ravi", 60, 20)
        );

        List<Student> sorted = new ArrayList<>(students);

        // Sort by marks desc, then by age asc
        sorted.sort(
            Comparator.comparingInt((Student s) -> s.marks).reversed()
                      .thenComparingInt(s -> s.age)
        );

        sorted.forEach(System.out::println);
    }
}
```

✅ Output:

```
Sita (95, 23)
Amit (80, 22)
Raj (80, 21)
Ravi (60, 20)
```

---

## 🧰 9️⃣ When to Use What

| Scenario                                                | Use                                |
| ------------------------------------------------------- | ---------------------------------- |
| Class has a *natural ordering* (like Student by rollNo) | `Comparable`                       |
| Need *multiple custom sorts* (by salary, name, etc.)    | `Comparator`                       |
| Want inline one-time sort                               | `Lambda` or `Comparator.comparing` |
| Want concise and clean syntax                           | Method reference                   |
| Need multi-level sort                                   | `thenComparing`                    |

---

## 🧩 10️⃣ Bonus: Stream API with Comparators

Sorting using **Stream API**:

```java
employees.stream()
    .sorted(Comparator.comparing(Employee::getName))
    .forEach(System.out::println);
```

Reversed order:

```java
employees.stream()
    .sorted(Comparator.comparing(Employee::getSalary).reversed())
    .forEach(System.out::println);
```

---

## 🧠 11️⃣ 10 Intermediate-Level Practice Questions

Try these to master the concept 👇

1. **Sort a list of strings by length** (ascending and descending).
2. **Sort a list of employees by salary**, then by name alphabetically.
3. **Sort a list of integers** but put all even numbers before odd numbers.
4. Given a list of students, **sort by marks descending**, then **by age ascending**.
5. Create a custom comparator to **sort products by price**, handling `null` names safely using `Comparator.nullsLast`.
6. Given a list of cities, **sort ignoring case** (case-insensitive).
7. Given a list of people, **sort by last name**, extracted from full name.
8. Use `Stream.sorted()` with a comparator that **sorts employees by salary >50k first**, then others.
9. Given a list of books, **sort by publication year descending**, then by title ascending using method reference.
10. Implement a class implementing both **Comparable** and also use an **external Comparator** for an alternate sorting logic — e.g., by ID (natural) and by Name (custom).

---

## 🧾 Summary Table

| Concept                  | Type                   | Defined In             | Method                          | Used For      |
| ------------------------ | ---------------------- | ---------------------- | ------------------------------- | ------------- |
| `Comparable<T>`          | Interface              | `java.lang`            | `compareTo()`                   | Natural order |
| `Comparator<T>`          | Interface (Functional) | `java.util`            | `compare()`                     | Custom order  |
| `Comparator.comparing()` | Static method          | `java.util.Comparator` | Build comparators using lambdas |               |
| `thenComparing()`        | Chain comparators      | `java.util.Comparator` | Multi-level sorting             |               |
| `reversed()`             | Reverse order          | `java.util.Comparator` | Descending sort                 |               |

---

Would you like me to make a **small mini-project example** (like a “Student Management” or “Employee Dashboard”) that demonstrates all of these concepts — `Comparable`, `Comparator`, `Lambda`, `Method Reference`, and multi-level sorting — together in one real scenario?
