Perfect 🔥 — that’s an excellent next step for mastering `Comparator`.
Let’s create a **realistic dummy dataset** (like in interviews) and then move to **10 mixed intermediate + advanced Comparator questions** — including sorting, chaining, and custom logic.

---

## 🧱 Step 1: Dummy Data Factory

Let’s define a class `Employee` and create a list of employees.

### **Employee.java**

```java
class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String department;

    public Employee(int id, String name, int age, double salary, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return String.format("%d - %s - %d yrs - %.2f - %s", id, name, age, salary, department);
    }
}
```

---

### **DataFactory.java**

```java
import java.util.*;

public class DataFactory {
    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee(101, "Alice", 28, 70000, "IT"),
                new Employee(102, "Bob", 35, 85000, "Finance"),
                new Employee(103, "Charlie", 25, 55000, "IT"),
                new Employee(104, "David", 40, 95000, "HR"),
                new Employee(105, "Eve", 30, 80000, "Finance"),
                new Employee(106, "Frank", 29, 70000, "HR"),
                new Employee(107, "Grace", 32, 90000, "IT"),
                new Employee(108, "Hank", 45, 120000, "Management"),
                new Employee(109, "Ivy", 27, 68000, "IT"),
                new Employee(110, "Jack", 33, 87000, "Finance")
        );
    }
}
```

---

## 🚀 Step 2: 10 Intermediate to Advanced Comparator Questions

Each question will include the **task** and a **hint or expected approach**.
You can try implementing them using either:

* `Collections.sort(list, comparator)` or
* `list.stream().sorted(comparator)`

---

### **1️⃣ Sort employees by salary (ascending)**

> *Basic Comparator usage*

🧠 Hint:

```java
Comparator.comparingDouble(Employee::getSalary)
```

---

### **2️⃣ Sort employees by salary descending**

> *Use reversed comparator*

🧠 Hint:

```java
Comparator.comparingDouble(Employee::getSalary).reversed()
```

---

### **3️⃣ Sort employees by department, then by salary ascending**

> *Multi-level sorting (chaining with `thenComparing`)*

🧠 Hint:

```java
Comparator.comparing(Employee::getDepartment)
          .thenComparing(Employee::getSalary)
```

---

### **4️⃣ Sort by department, then descending salary, then by name alphabetically**

> *Mix ascending and descending in chain*

🧠 Hint:

```java
Comparator.comparing(Employee::getDepartment)
          .thenComparing(Comparator.comparing(Employee::getSalary).reversed())
          .thenComparing(Employee::getName)
```

---

### **5️⃣ Sort employees whose name length is shortest first, then by name alphabetically**

> *Sort using derived/computed property*

🧠 Hint:

```java
Comparator.comparingInt((Employee e) -> e.getName().length())
          .thenComparing(Employee::getName)
```

---

### **6️⃣ Sort by custom rule:**

> Employees of **IT department first**, then others —
> within each group, sort by salary descending.

🧠 Hint:

```java
Comparator.comparing((Employee e) -> !e.getDepartment().equals("IT"))
          .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())
```

---

### **7️⃣ Sort employees by last character of their name, then by age**

> *Uncommon string-based comparator logic*

🧠 Hint:

```java
Comparator.comparing((Employee e) -> e.getName().charAt(e.getName().length() - 1))
          .thenComparing(Employee::getAge)
```

---

### **8️⃣ Sort employees such that**

> those **earning more than 80k** come first,
> then sort by name alphabetically.

🧠 Hint:

```java
Comparator.comparing((Employee e) -> e.getSalary() <= 80000)
          .thenComparing(Employee::getName)
```

---

### **9️⃣ Sort by multiple derived fields:**

> Sort by **age group** (≤30 first, then >30),
> then by **salary descending**,
> then by **department alphabetically**.

🧠 Hint:

```java
Comparator.comparing((Employee e) -> e.getAge() > 30)
          .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())
          .thenComparing(Employee::getDepartment)
```

---

### **🔟 Sort employees by department, and inside each department —**

> find the **highest paid employee first**, then the rest in descending salary order.

🧠 Hint:

```java
Comparator.comparing(Employee::getDepartment)
          .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed())
```

---

## 🧩 Bonus Challenge

**Combine custom sorting + filtering:**

> Display the top 3 highest-paid employees in the IT department using Comparator.

🧠 Hint:

```java
list.stream()
    .filter(e -> e.getDepartment().equals("IT"))
    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
    .limit(3)
    .forEach(System.out::println);
```

---

Would you like me to extend this with **real outputs** (showing sorted lists for each question) so you can verify your code results easily?
