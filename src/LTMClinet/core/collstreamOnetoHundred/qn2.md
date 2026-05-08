# Java Collections + Streams + Coding Interview Practice (100 Questions)

## Reusable `DataFactory` for Practice

Use this dataset for most stream/collection questions.

```java
import java.time.LocalDate;
import java.util.List;

enum Gender {
    MALE, FEMALE
}

class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String department;
    private Gender gender;
    private String city;
    private LocalDate joiningDate;
    private List<String> skills;

    public Employee(int id, String name, int age, double salary,
                    String department, Gender gender,
                    String city, LocalDate joiningDate,
                    List<String> skills) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.gender = gender;
        this.city = city;
        this.joiningDate = joiningDate;
        this.skills = skills;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public Gender getGender() { return gender; }
    public String getCity() { return city; }
    public LocalDate getJoiningDate() { return joiningDate; }
    public List<String> getSkills() { return skills; }

    @Override
    public String toString() {
        return name + " - " + department + " - " + salary;
    }
}

public class DataFactory {

    public static List<Employee> getEmployees() {
        return List.of(
            new Employee(1, "Amit", 28, 70000, "IT", Gender.MALE,
                    "Kolkata", LocalDate.of(2020, 5, 12),
                    List.of("Java", "Spring", "SQL")),

            new Employee(2, "Neha", 32, 90000, "HR", Gender.FEMALE,
                    "Delhi", LocalDate.of(2018, 3, 10),
                    List.of("Communication", "Hiring")),

            new Employee(3, "Raj", 26, 60000, "IT", Gender.MALE,
                    "Mumbai", LocalDate.of(2021, 7, 19),
                    List.of("Java", "React")),

            new Employee(4, "Priya", 29, 95000, "Finance", Gender.FEMALE,
                    "Pune", LocalDate.of(2019, 11, 1),
                    List.of("Excel", "Accounting")),

            new Employee(5, "Karan", 35, 120000, "IT", Gender.MALE,
                    "Bangalore", LocalDate.of(2016, 1, 15),
                    List.of("Java", "AWS", "Kafka")),

            new Employee(6, "Sneha", 27, 75000, "Support", Gender.FEMALE,
                    "Kolkata", LocalDate.of(2022, 8, 5),
                    List.of("Linux", "SQL")),

            new Employee(7, "Vikram", 31, 110000, "IT", Gender.MALE,
                    "Hyderabad", LocalDate.of(2017, 6, 30),
                    List.of("Microservices", "Docker")),

            new Employee(8, "Anjali", 24, 50000, "Support", Gender.FEMALE,
                    "Delhi", LocalDate.of(2023, 2, 20),
                    List.of("Customer Handling")),

            new Employee(9, "Rohit", 30, 85000, "Finance", Gender.MALE,
                    "Mumbai", LocalDate.of(2019, 9, 25),
                    List.of("Tax", "Accounting")),

            new Employee(10, "Pooja", 33, 105000, "IT", Gender.FEMALE,
                    "Bangalore", LocalDate.of(2015, 4, 18),
                    List.of("Java", "Spring Boot", "Kafka"))
        );
    }

    public static List<String> getWords() {
        return List.of(
            "java", "spring", "java", "kafka", "docker",
            "spring", "java", "aws", "docker", "kafka",
            "java", "react", "spring"
        );
    }

    public static List<Integer> getNumbers() {
        return List.of(5, 7, 2, 9, 1, 5, 7, 8, 2, 10, 15, 20);
    }
}
```

---

# 1. String Questions (1–20)

## Output / Concept Based

1. What is the output?

```java
String s1 = "Java";
String s2 = "Java";
System.out.println(s1 == s2);
```

2. Output?

```java
String s1 = new String("Java");
String s2 = new String("Java");
System.out.println(s1 == s2);
System.out.println(s1.equals(s2));
```

3. Difference between `==`, `equals()`, `equalsIgnoreCase()`.

4. Why is String immutable?

5. What happens internally when using `+` in loops?

6. Difference between `StringBuilder` and `StringBuffer`.

7. Why are Strings good hashmap keys?

8. Output?

```java
String s = "Java";
s.concat("8");
System.out.println(s);
```

9. Difference between `trim()` and `strip()`.

10. Output?

```java
String s = "abc";
System.out.println(s.substring(1, 2));
```

---

## Coding / Scenario Based

11. Reverse a string without using built-in reverse.

12. Check palindrome string.

13. Count vowels and consonants.

14. Find first non-repeated character.

15. Find duplicate characters.

16. Count occurrence of each character.

17. Remove duplicate characters from string.

18. Check if two strings are anagrams.

19. Sort characters by frequency.

20. Longest substring without repeating characters.

---

# 2. List Questions (21–35)

21. Difference between `ArrayList` and `LinkedList`.

22. When would LinkedList outperform ArrayList?

23. Output?

```java
List<Integer> list = List.of(1,2,3);
list.add(4);
```

24. Difference between `Arrays.asList()` and `List.of()`.

25. Scenario:
    You need frequent reads and rare inserts. Which list?

26. Remove duplicates from list preserving order.

27. Find second highest number.

28. Rotate list by K positions.

29. Merge two sorted lists.

30. Partition even and odd numbers.

31. Find missing number from 1-N.

32. Find duplicates in list.

33. Top 2 frequent numbers.

34. Find intersection of two lists.

35. Flatten nested lists using streams.

---

# 3. Set Questions (36–45)

36. Difference:
    `HashSet`, `LinkedHashSet`, `TreeSet`.

37. Why does Set not allow duplicates?

38. What happens if `equals()` and `hashCode()` are not overridden?

39. Output?

```java
Set<Integer> set = new HashSet<>();
set.add(1);
set.add(1);
System.out.println(set.size());
```

40. Find unique elements from list.

41. Find first duplicate element.

42. Sort elements using TreeSet.

43. Find union of two sets.

44. Find intersection of two sets.

45. Scenario:
    Need insertion order + uniqueness.

---

# 4. Map Questions (46–60)

46. Difference:
    `HashMap`, `LinkedHashMap`, `TreeMap`.

47. Why are keys immutable ideally?

48. Internal working of HashMap.

49. What is hash collision?

50. What happens when two keys have same hashcode?

51. Output?

```java
Map<String, Integer> map = new HashMap<>();
map.put(null, 1);
map.put(null, 2);
System.out.println(map);
```

52. Count word frequency using Map.

53. Sort map by value.

54. Find highest occurring word.

55. Group employees by department.

56. Group employees by city.

57. Convert List<Employee> to Map<id, employee>.

58. Scenario:
    Need sorted keys.

59. Scenario:
    Need insertion order in map.

60. Find duplicate elements using HashMap.

---

# 5. Comparable / Comparator (61–70)

61. Difference between Comparable and Comparator.

62. When should Comparable be used?

63. Sort employees by salary ascending.

64. Sort employees by salary descending.

65. Sort by name then age.

66. Sort by department then salary.

67. Output?

```java
Collections.sort(list);
```

Without Comparable implemented.

68. Scenario:
    Cannot modify Employee class but need custom sorting.

69. Find highest salaried employee.

70. Find youngest employee per department.

---

# 6. Stream API Questions (71–90)

## Basic Streams

71. Find all even numbers.

72. Find squares of numbers.

73. Find numbers greater than 10.

74. Convert names to uppercase.

75. Count employees in IT department.

76. Find max salary.

77. Find min salary.

78. Find average salary.

79. Find sum of salaries.

80. Sort employees by salary.

---

## Moderate Stream Questions

81. Group employees by department.

82. Count employees per department.

83. Find highest paid employee in each department.

84. Find second highest salary.

85. Find duplicate elements in list.

86. Top 2 frequent words.

87. Flatten employee skills list.

88. Find common elements between two lists.

89. Partition employees based on salary > 80k.

90. Find employee names joined by comma.

---

# 7. Collectors Questions (91–96)

91. Difference:
    `groupingBy` vs `partitioningBy`.

92. Use `mapping()` collector.

93. Use `collectingAndThen()`.

94. Create map of department -> employee names.

95. Find average salary department-wise.

96. Count occurrences using `Collectors.counting()`.

---

# 8. Optional Questions (97–100)

97. Why Optional was introduced?

98. Difference:
    `orElse()` vs `orElseGet()`.

99. What happens here?

```java
Optional<String> opt = Optional.of(null);
```

100. Scenario:
     Repository returns null frequently. How Optional helps?

---

# High-Probability Client Round Questions

These are VERY commonly asked in service-based companies:

## MUST PRACTICE

* Second highest salary
* Highest salary department-wise
* Count frequency of words
* Find duplicates
* Remove duplicates preserving order
* GroupingBy examples
* Comparator chaining
* Stream flattening
* Map sorting
* Top K frequent elements
* Anagram
* First non-repeated character
* Partition even/odd
* Employee transformations
* Convert List to Map
* Optional handling
* Difference between map/filter
* Difference between findFirst/findAny
* Stream lazy evaluation

---

# Some Strong Moderate-Level Coding Questions

## 1. Top 2 Frequent Words

```java
Map<String, Long> freq =
    words.stream()
         .collect(Collectors.groupingBy(
             Function.identity(),
             Collectors.counting()
         ));

freq.entrySet().stream()
    .sorted((a,b) -> Long.compare(b.getValue(), a.getValue()))
    .limit(2)
    .forEach(System.out::println);
```

---

## 2. Second Highest Salary

```java
employees.stream()
    .map(Employee::getSalary)
    .distinct()
    .sorted(Comparator.reverseOrder())
    .skip(1)
    .findFirst();
```

---

## 3. Highest Paid Employee Per Department

```java
employees.stream()
    .collect(Collectors.groupingBy(
        Employee::getDepartment,
        Collectors.maxBy(
            Comparator.comparing(Employee::getSalary)
        )
    ));
```

---

## 4. Find Duplicate Elements

```java
Set<Integer> seen = new HashSet<>();

numbers.stream()
    .filter(n -> !seen.add(n))
    .forEach(System.out::println);
```

---

# What Interviewers Usually Check

In client rounds, they typically judge:

* Can you think while coding?
* Can you use collections properly?
* Can you explain stream pipeline?
* Do you know time complexity?
* Can you write readable code?
* Can you debug outputs?
* Can you choose correct collection?
* Can you handle edge cases?

Not just syntax.

---

# Important Areas To Revise Tonight

## 1. Streams Pipeline

* filter
* map
* flatMap
* reduce
* sorted
* distinct
* limit
* skip
* collect

---

## 2. Collectors

* groupingBy
* partitioningBy
* mapping
* counting
* joining
* summarizingDouble

---

## 3. Comparator Chaining

```java
Comparator.comparing(Employee::getDepartment)
          .thenComparing(Employee::getSalary)
```

---

## 4. Time Complexity

Know these:

| Operation | ArrayList      | HashMap  | HashSet  |
| --------- | -------------- | -------- | -------- |
| Search    | O(n)           | O(1) avg | O(1) avg |
| Insert    | O(1) amortized | O(1) avg | O(1) avg |
| Delete    | O(n)           | O(1) avg | O(1) avg |

---

# Final Preparation Advice for LTM Client Round

If stuck:

* Speak your approach first
* Clarify assumptions
* Use meaningful variable names
* Mention edge cases
* Start brute force → improve
* Explain why you chose a collection

That matters a lot in client-facing interviews.
