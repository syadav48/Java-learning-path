Perfect 👍 this is exactly how to level up fast.  
Here’s your **next 100 questions set (Strings + Collections + Streams)**

✅ Strictly:

*   Scenario-based
*   Output-based
*   Coding-focused
*   Covers **String, List, Set, Map, Comparable/Comparator, Streams, Optional, Collectors**

***

# 🔥 PART 0: DataFactory (USE THIS IN STREAM QUESTIONS)

Use this dataset for most stream-based scenarios 👇

```java
import java.util.*;

class Employee {
    int id;
    String name;
    String dept;
    double salary;
    int age;

    Employee(int id, String name, String dept, double salary, int age) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.age = age;
    }

    public String toString() {
        return name + " - " + dept + " - " + salary;
    }

    public String getDept() { return dept; }
    public double getSalary() { return salary; }
    public String getName() { return name; }
    public int getAge() { return age; }
}

class DataFactory {
    public static List<Employee> getEmployees() {
        return Arrays.asList(
            new Employee(1, "Amit", "IT", 70000, 30),
            new Employee(2, "Rahul", "HR", 50000, 25),
            new Employee(3, "Neha", "IT", 90000, 35),
            new Employee(4, "Priya", "Finance", 60000, 28),
            new Employee(5, "Karan", "IT", 75000, 32),
            new Employee(6, "Sneha", "HR", 52000, 26)
        );
    }

    public static List<String> getNames() {
        return Arrays.asList("Java", "Spring", "AWS", "Java", "Docker");
    }

    public static List<Integer> getNumbers() {
        return Arrays.asList(10, 20, 30, 40, 50, 60);
    }
}
```

***

# 🔥 PART 1: OUTPUT-BASED (Strings + Collections + Streams) (1–35)

### Strings

1.

```java
String s1 = "Java";
String s2 = "Java";
System.out.println(s1 == s2);
```

2.

```java
String s1 = new String("Java");
String s2 = new String("Java");
System.out.println(s1 == s2);
```

3.

```java
String s = "Java";
s.concat("8");
System.out.println(s);
```

4.

```java
String s = "Java";
s = s.concat("8");
System.out.println(s);
```

5.

```java
String s1 = "Java";
String s2 = "Ja" + "va";
System.out.println(s1 == s2);
```

***

### Collections

6.

```java
List<Integer> list = Arrays.asList(1,2,3);
list.add(4);
```

7.

```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add(1, "C");
System.out.println(list);
```

8.

```java
Set<String> set = new HashSet<>();
set.add("A");
set.add("B");
set.add("A");
System.out.println(set);
```

9.

```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("A", 2);
System.out.println(map.get("A"));
```

10.

```java
Map<String, Integer> map = new HashMap<>();
map.put(null, 1);
map.put(null, 2);
System.out.println(map);
```

***

### Streams

11.

```java
DataFactory.getNumbers().stream()
    .filter(n -> n > 20)
    .forEach(System.out::println);
```

12.

```java
DataFactory.getNumbers().stream()
    .map(n -> n * 2)
    .limit(3)
    .forEach(System.out::println);
```

13.

```java
DataFactory.getNames().stream()
    .distinct()
    .forEach(System.out::println);
```

14.

```java
DataFactory.getNames().stream()
    .sorted()
    .forEach(System.out::println);
```

15.

```java
Optional<Integer> result = DataFactory.getNumbers()
    .stream()
    .reduce((a,b)->a+b);
System.out.println(result.get());
```

***

### Mixed

16–35:

*   string interning vs new object
*   `equals` vs `==`
*   `StringBuilder` mutability
*   removing from list during iteration
*   `ConcurrentModificationException`
*   stream `findFirst()` vs `findAny()`
*   stream laziness (no terminal op)
*   `peek()` behavior
*   `flatMap` output scenarios
*   `Collectors.toMap()` duplicate keys (exception)
*   groupingBy output structure

***

# ⚡ PART 2: SCENARIO-BASED (36–70)

### Strings

36. Why string is immutable—what breaks if mutable? (scenario reasoning)

37. You store password in String vs char\[] → what issue?

38. Two string literals + runtime concat → memory behavior?

39. Intern() usage scenario?

***

### Collections

40. When would HashSet fail to remove duplicates? (custom object)

41. You override equals but not hashCode → result?

42. Iterating map while modifying → exception scenario

43. ArrayList vs LinkedList in real scenario (insert vs read heavy)

44. Why TreeSet sorts but HashSet doesn’t?

45. Duplicate keys in HashMap—what happens internally?

46. Need thread-safe list → which collection?

47. Null in TreeSet → allowed?

48. HashMap capacity resizing scenario

49. Worst-case complexity of HashMap with poor hashCode?

***

### Streams

50. Stream pipeline without terminal → result?

51. Parallel stream causing wrong result → why?

52. What happens if map returns null?

53. `filter` removes everything → reduce behavior?

54. Why streams cannot be reused?

55. Difference:

*   `map` vs `flatMap` real example

56. groupingBy vs partitioningBy scenario

57. When to use `collect` vs `reduce`?

58. Optional empty case → get() behavior?

59. Stream short-circuiting scenario

60–70:

*   duplicate key in `toMap`
*   sorting by multiple fields
*   filter + map chaining debugging
*   null pointer during stream
*   performance issues using boxed types
*   misuse of parallel streams
*   comparator stability
*   stream pipeline debugging
*   collecting into Set vs List difference

***

# 💻 PART 3: CODING QUESTIONS (71–100)

### Strings

71. Reverse string without using built-in methods.

72. Check palindrome.

73. Count frequency of characters.

74. Remove duplicates from string.

75. Find first non-repeating character.

76. Anagram checker.

77. Replace spaces with %20.

***

### Collections

78. Sort list of custom objects (salary).

79. Sort using Comparator (name, then age).

80. Remove duplicates from list.

81. Find top 3 highest numbers.

82. Convert List → Map.

83. Find frequency of elements using Map.

84. Merge two maps.

85. Find intersection of two lists.

86. Find second highest number.

***

### Streams (USE DataFactory)

87. Get all employees in IT dept.

88. Get names of employees.

89. Find average salary.

90. Find highest salary.

91. Group employees by department.

92. Count employees per department.

93. Find employee with max salary.

94. Sort employees by salary descending.

95. Get list of employee names in uppercase.

96. Find employees with salary > 60000.

97. Find second highest salary.

98. Partition employees by age > 30.

99. Convert employee list → Map\<name, salary>.

100.    Find duplicate names from list.

***

# ✅ How to Use This (IMPORTANT)

👉 Practice like interviewer:

*   Predict output
*   Write code manually
*   Explain reasoning aloud

👉 Priority topics:

*   Strings (VERY frequent)
*   HashMap internals (VERY HIGH)
*   Streams chaining (MUST KNOW)

***

# 🚀 Next Step (Recommended)

If you want to maximize selection chances, I can:

✅ Give **Top 40 most asked + solutions**  
✅ Take **mock interview (real questions)**  
✅ Give **Amazon / Infosys / TCS pattern questions**  
✅ Provide **cheat sheet for last-day revision**

Just tell: *“mock interview”* or *“top 40 with answers”* 👍
