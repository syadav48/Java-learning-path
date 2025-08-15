Alright — let’s break this into **easy-to-digest notes** so you remember `Comparator` and `Comparable` once and for all.

---

## **1. Comparable vs Comparator in Java**

| Feature              | `Comparable`                                           | `Comparator`                                                     |
| -------------------- | ------------------------------------------------------ | ---------------------------------------------------------------- |
| **Package**          | `java.lang`                                            | `java.util`                                                      |
| **Purpose**          | Defines **natural ordering** of objects                | Defines **custom ordering** of objects                           |
| **Method**           | `compareTo(T obj)`                                     | `compare(T obj1, T obj2)`                                        |
| **Modification**     | Modify the **class** whose objects you want to compare | Create a separate comparator class or use lambda/anonymous class |
| **Sorting Logic**    | Built **inside** the class itself                      | Can be **external** and have multiple sorting strategies         |
| **Single/Multiple**  | Only **one** way of sorting per class                  | Multiple ways of sorting possible                                |
| **Example Use Case** | Students sorted by **rollNo** always                   | Students sorted sometimes by **name**, sometimes by **marks**    |

---

## **2. Comparable Example**

```java
class Student implements Comparable<Student> {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Student other) {
        return this.age - other.age; // Ascending order by age
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(23, "Surya"));
        list.add(new Student(19, "Rahul"));
        list.add(new Student(21, "Viki"));

        Collections.sort(list); // Uses compareTo()
        System.out.println(list);
    }
}
```

**Output**

```
Rahul (19), Viki (21), Surya (23)
```

---

## **3. Comparator Example (Custom Sorting)**

```java
import java.util.*;

class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
            new Student(23, "Surya"),
            new Student(19, "Rahul"),
            new Student(21, "Viki")
        );

        // Sort by Name
        Comparator<Student> nameSort = (s1, s2) -> s1.name.compareTo(s2.name);

        // Sort by Age Descending
        Comparator<Student> ageSortDesc = (s1, s2) -> s2.age - s1.age;

        Collections.sort(list, nameSort);
        System.out.println("By Name: " + list);

        Collections.sort(list, ageSortDesc);
        System.out.println("By Age Desc: " + list);
    }
}
```

**Output**

```
By Name: [Rahul (19), Surya (23), Viki (21)]
By Age Desc: [Surya (23), Viki (21), Rahul (19)]
```

---

## **4. Key Points**

* **Comparable** → Natural order (e.g., `String`, `Integer` already implement it)
* **Comparator** → Flexible multiple custom orderings
* Both return:

  * `0` → equal
  * `<0` → first comes before second
  * `>0` → first comes after second
* **Lambda Expressions** make Comparators shorter:

  ```java
  Collections.sort(list, (a, b) -> a.age - b.age);
  ```
* **Default Methods** in Comparator since Java 8:

  * `thenComparing()` → for multi-level sorting

  ```java
  Comparator<Student> comp = Comparator.comparing(Student::getName)
                                        .thenComparing(Student::getAge);
  ```

---

## **5. Real-world Analogy**

* **Comparable** → Like having a built-in "sort by price" in every product by default in an e-commerce website.
* **Comparator** → Like being able to choose "sort by price", "sort by rating", or "sort by popularity" at runtime.

---

If you want, I can also **make a diagram showing Comparable vs Comparator visually** so it sticks in your mind better.
Do you want me to make that diagram?
