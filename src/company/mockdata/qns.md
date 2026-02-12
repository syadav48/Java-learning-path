This is a **very smart way** to master Collections + Streams.
Instead of random LeetCode-style problems, you want a **realistic industrial dataset** and then practice every single API on top of it.

Good. Let’s design this properly.

---

# 🏭 Industrial IT Data Factory Design

We’ll simulate a mid-size product company with:

* Employees
* Departments
* Projects
* Clients
* Tasks
* Assets (Laptops, Servers)
* Attendance
* Salaries
* Tickets (Support system)
* Transactions (Finance)

This gives enough relational depth to practice:

* Filtering
* Sorting
* Mapping
* Grouping
* Partitioning
* Aggregation
* FlatMapping
* Optional
* Comparator
* Custom collectors
* Map transformations
* Parallel streams
* Immutable collectors
* Advanced collectors

---

# 🧱 1. Domain Model Structure

---

## 👨‍💻 Employee

![Image](https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https%3A//images.ctfassets.net/wp1lcwdav1p1/3NXKQQDcOjzgvxj6RbYEeJ/b0968e6fe41e1dde3d328a7ced39cfb2/GettyImages-1341554760.jpg?auto=format%2Ccompress\&dpr=1\&f=faces\&fit=fill\&fl=progressive\&fm=jpg\&h=680\&q=60\&w=1000\&w=1500)

![Image](https://images.prismic.io/wildgoose/3a553239-8fde-489a-9ae2-cda33cee940b_team-meeting-games-for-the-office.webp?auto=compress%2Cformat)

![Image](https://miro.medium.com/1%2AWxaPQoonUZLcPCISd6WrnQ.jpeg)

![Image](https://miro.medium.com/v2/resize%3Afit%3A1400/0%2AUIiWfg8cXRGdGVJ0)

```java
class Employee {
    Long id;
    String name;
    int age;
    Gender gender;
    String email;
    String city;
    double salary;
    LocalDate joiningDate;
    Department department;
    List<Project> projects;
    List<Skill> skills;
}
```

---

## 🏢 Department

```java
class Department {
    Long id;
    String name;
    String location;
    double budget;
}
```

---

## 📁 Project

```java
class Project {
    Long id;
    String name;
    ProjectStatus status;
    LocalDate startDate;
    LocalDate endDate;
    double budget;
    Client client;
}
```

---

## 🏢 Client

```java
class Client {
    Long id;
    String name;
    String country;
    ClientType type;
}
```

---

## 🎫 Ticket

```java
class Ticket {
    Long id;
    TicketPriority priority;
    TicketStatus status;
    Employee assignedTo;
    LocalDate createdDate;
    LocalDate resolvedDate;
}
```

---

## 💰 Transaction

```java
class Transaction {
    Long id;
    TransactionType type;
    double amount;
    LocalDate date;
    String reference;
}
```

---

# 🏗 2. DataFactory Class

```java
public final class DataFactory {

    private DataFactory() {}

    public static List<Employee> getEmployees() { ... }

    public static List<Department> getDepartments() { ... }

    public static List<Project> getProjects() { ... }

    public static List<Client> getClients() { ... }

    public static List<Ticket> getTickets() { ... }

    public static List<Transaction> getTransactions() { ... }

}
```

Populate:

* 50 Employees
* 5 Departments
* 15 Projects
* 10 Clients
* 200 Tickets
* 500 Transactions

Make realistic salary ranges, joining dates, statuses etc.

---

# 🎯 Now The Important Part

# 🔥 100 Structured Practice Questions

Organized by concept.

---

# 🟢 PART 1 — Basic Filtering (filter, count, forEach)

1. Get all employees earning > 10 LPA
2. Employees from Bangalore
3. Female employees
4. Employees joined after 2020
5. Employees older than 30
6. Count employees in HR
7. Count employees in each city
8. Tickets that are OPEN
9. High priority tickets
10. Transactions above 1 lakh

---

# 🟢 PART 2 — Mapping (map, mapToInt, mapToDouble)

11. List of employee names
12. List of emails
13. Salaries only
14. Project names
15. Client countries
16. Employee age list
17. Map employees to salary incremented by 10%
18. Extract joining year
19. Ticket durations (resolved - created)
20. Convert employee list to id list

---

# 🟢 PART 3 — Sorting (sorted, Comparator)

21. Sort employees by salary ascending
22. Sort by salary descending
23. Sort by name
24. Sort by age then salary
25. Sort projects by budget
26. Sort tickets by priority
27. Sort employees by joining date
28. Top 5 highest paid employees
29. Youngest employee
30. Oldest employee

---

# 🟢 PART 4 — Aggregation (reduce, sum, average, min, max)

31. Total salary payout
32. Average salary
33. Highest salary
34. Lowest salary
35. Total transaction amount
36. Average age
37. Count total tickets
38. Total project budget
39. Max transaction
40. Min transaction

---

# 🟢 PART 5 — Grouping (Collectors.groupingBy)

41. Group employees by department
42. Group by city
43. Group by gender
44. Group projects by status
45. Group tickets by status
46. Group employees by joining year
47. Salary sum per department
48. Average salary per department
49. Count employees per department
50. Group transactions by month

---

# 🟢 PART 6 — Partitioning (partitioningBy)

51. Employees earning > 15 LPA
52. Employees older than 35
53. Projects active vs completed
54. Tickets resolved vs unresolved
55. Transactions > 1 lakh
56. Employees in Bangalore vs others
57. High budget projects
58. Employees joined before 2022
59. High priority tickets
60. Profit vs expense transactions

---

# 🟢 PART 7 — FlatMap

61. List all skills of all employees
62. Distinct skills
63. Employees working on more than 2 projects
64. All project names from employees
65. All client names
66. Flatten ticket assignments
67. Flatten nested lists
68. Unique cities
69. Unique departments
70. All emails in lowercase

---

# 🟢 PART 8 — Advanced Collectors

71. Collect to Set
72. Collect to LinkedHashSet
73. Collect to TreeSet
74. toMap (id → name)
75. toMap (name → salary)
76. Handling duplicate keys in toMap
77. Joining employee names
78. Joining names with delimiter
79. SummarizingDouble salary
80. CollectingAndThen

---

# 🟢 PART 9 — Optional Usage

81. Find employee by id
82. Highest salary employee Optional
83. IfPresent example
84. orElse vs orElseGet
85. Optional map
86. Optional flatMap
87. Optional filter
88. Throw exception if not found
89. Find first employee in HR
90. Find any employee

---

# 🟢 PART 10 — Parallel Streams & Performance

91. Parallel salary sum
92. Parallel grouping
93. Compare sequential vs parallel time
94. Reduce with identity
95. Reduce without identity
96. Custom collector
97. Immutable list (toUnmodifiableList)
98. Map transformation
99. Concurrent groupingBy
100. Custom comparator chaining

---

# 📌 Why This Design Works

You will practice:

* List
* Set
* Map
* Stream API
* Comparator
* Optional
* Collectors
* Reduce
* Functional interfaces
* Method references
* Lambda
* Custom collectors
* Parallel streams

And most importantly:

You’ll understand **how enterprise data behaves**, not toy examples.

---

# 🚀 If You Want Next Level

I can:

1. Give you fully implemented DataFactory with realistic mock data
2. Create a GitHub-style folder structure
3. Create solution skeleton classes
4. Create answer key separately
5. Convert this into 30-day structured mastery plan

---

Now let me challenge you:

Do you want:

* Easy level data?
* Medium real-world?
* Complex relational (with cross joins & heavy nested structures)?

Choose carefully.
