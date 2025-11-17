package stream.qns;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Employee {
    private final int id;
    private final String name;
    private final int age;
    private final double salary;
    private final String department;
    private final String city;
    private final List<String> skills;

    public Employee(int id, String name, int age, double salary, String dept, String city, List<String> skills) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = dept;
        this.city = city;
        this.skills = skills;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public String getCity() { return city; }
    public List<String> getSkills() { return skills; }
}

