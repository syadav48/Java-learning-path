package stream.collectors;

import java.util.List;

public class Employee {
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



