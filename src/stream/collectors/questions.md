Perfect ✅ — let’s build a **Collector Mastery Question Set** (Intermediate → Advanced).

## We’ll use **two dummy classes** that are realistic for interview-style collector problems:

### 🧩 Dummy Classes to Use for All Questions

```java
class Employee {
    private String name;
    private String department;
    private double salary;
    private int age;
    private String city;
    private boolean isActive;

    // constructor, getters, setters, toString()
    public Employee(String name, String department, double salary, int age, String city, boolean isActive) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.city = city;
        this.isActive = isActive;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }
    public String getCity() { return city; }
    public boolean isActive() { return isActive; }

    @Override
    public String toString() {
        return name + " (" + department + ", " + salary + ")";
    }
}

class Person {
    private String name;
    private int age;
    private String gender;
    private List<String> hobbies;

    public Person(String name, int age, String gender, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobbies = hobbies;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public List<String> getHobbies() { return hobbies; }

    @Override
    public String toString() {
        return name + " (" + gender + ", " + age + ")";
    }
}
```

---

## 🎯 20 Java Collector Questions — Intermediate → Advanced

Each question is designed to target one or more **Collector** concepts.

---

### 🟩 **Intermediate Level**

#### 1️⃣ Basic Collectors.toList()

**Q:** Collect all employee names into a list using `Collectors.toList()`.
➡️ Concept: `map() + toList()`

---

#### 2️⃣ Collectors.toSet()

**Q:** Get a set of unique departments from employees.
➡️ Concept: `map() + toSet()`

---

#### 3️⃣ Collectors.joining()

**Q:** Join all employee names separated by commas (e.g., `"Suresh, Ramesh, Rajesh"`).
➡️ Concept: `joining(", ")`

---

#### 4️⃣ Collectors.counting()

**Q:** Count how many employees are from the “IT” department.
➡️ Concept: `filter() + counting()`

---

#### 5️⃣ Collectors.summingDouble()

**Q:** Find the total salary of all employees in “HR” department.
➡️ Concept: `filter() + summingDouble(Employee::getSalary)`

---

#### 6️⃣ Collectors.averagingInt()

**Q:** Calculate the average age of all employees.
➡️ Concept: `averagingInt(Employee::getAge)`

---

#### 7️⃣ Collectors.maxBy()

**Q:** Find the employee with the highest salary.
➡️ Concept: `maxBy(Comparator.comparing(Employee::getSalary))`

---

#### 8️⃣ Collectors.minBy()

**Q:** Find the youngest employee.
➡️ Concept: `minBy(Comparator.comparing(Employee::getAge))`

---

#### 9️⃣ Collectors.groupingBy() (Simple)

**Q:** Group all employees by department.
➡️ Concept: `groupingBy(Employee::getDepartment)`

---

#### 🔟 groupingBy() + counting()

**Q:** Count how many employees are in each department.
➡️ Concept: `groupingBy(Employee::getDepartment, counting())`

---

### 🟨 **Upper Intermediate**

#### 11️⃣ groupingBy() + summingDouble()

**Q:** Find total salary expense per department.
➡️ Concept: `groupingBy(Employee::getDepartment, summingDouble(Employee::getSalary))`

---

#### 12️⃣ groupingBy() + averagingDouble()

**Q:** Find the average salary per department.
➡️ Concept: `groupingBy(Employee::getDepartment, averagingDouble(Employee::getSalary))`

---

#### 13️⃣ groupingBy() + mapping()

**Q:** Group employees by city, but only collect their names (not full objects).
➡️ Concept: `groupingBy(Employee::getCity, mapping(Employee::getName, toList()))`

---

#### 14️⃣ groupingBy() + maxBy()

**Q:** Find the highest-paid employee per department.
➡️ Concept: `groupingBy(Employee::getDepartment, maxBy(Comparator.comparing(Employee::getSalary)))`

---

#### 15️⃣ partitioningBy()

**Q:** Partition employees into two groups: active and inactive.
➡️ Concept: `partitioningBy(Employee::isActive)`

---

### 🟥 **Advanced Level**

#### 16️⃣ partitioningBy() + counting()

**Q:** Count how many employees are active vs inactive.
➡️ Concept: `partitioningBy(Employee::isActive, counting())`

---

#### 17️⃣ collectingAndThen()

**Q:** Get the **name** of the employee with the highest salary (not the whole object).
➡️ Concept:

```java
collectingAndThen(
  maxBy(Comparator.comparing(Employee::getSalary)),
  opt -> opt.map(Employee::getName).orElse("N/A")
)
```

---

#### 18️⃣ groupingBy() + downstream collector + collectingAndThen()

**Q:** Get each department’s **highest-paid employee name**.
➡️ Concept:

```java
groupingBy(Employee::getDepartment,
  collectingAndThen(
    maxBy(Comparator.comparing(Employee::getSalary)),
    opt -> opt.map(Employee::getName).orElse("N/A")
  )
)
```

---

#### 19️⃣ nested groupingBy()

**Q:** Group employees by department, then by city.
➡️ Concept:

```java
groupingBy(Employee::getDepartment,
  groupingBy(Employee::getCity)
)
```

---

#### 20️⃣ flatMapping() (Java 9+)

**Q:** From a list of `Person`, get a map of gender → unique hobbies.
➡️ Concept:

```java
groupingBy(Person::getGender,
  flatMapping(person -> person.getHobbies().stream(), toSet())
)
```

---

### 🔥 BONUS CHALLENGES

| #  | Question                                                    | Concepts Tested                                        |
| -- | ----------------------------------------------------------- | ------------------------------------------------------ |
| 21 | Create a list of top 3 highest salaries                     | `sorted() + limit() + map()`                           |
| 22 | Find department having highest average salary               | `groupingBy + averaging + maxBy entrySet()`            |
| 23 | Get city-wise list of employees sorted by salary descending | `groupingBy + collectingAndThen + sorted()`            |
| 24 | Convert list of employees → Map<name, salary>               | `toMap(Employee::getName, Employee::getSalary)`        |
| 25 | Handle duplicate keys in toMap()                            | `toMap(..., (a,b)->a)`                                 |
| 26 | Find 2nd highest salary using stream skip/limit             | `sorted + skip(1)`                                     |
| 27 | Partition employees age > 40 and count per group            | `partitioningBy(emp -> emp.getAge() > 40, counting())` |

---

Would you like me to make a **code + expected output version** of these 20 questions next?
(Each with input list, logic, and expected result — so you can practice or interview-train directly.)
