package LTMClinet.core.collstreamOnetoHundred;

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
