package company.mockdata.model;

import company.mockdata.enums.Gender;
import company.mockdata.enums.Skill;

import java.time.LocalDate;
import java.util.List;

public class Employee {
    private Long id;
    private String name;
    private int age;
    private Gender gender;
    private String email;
    private String city;
    private double salary;
    private LocalDate joiningDate;
    private Department department;
    private List<Project> projects;
    private List<Skill> skills;

    public Employee(Long id, String name, int age, Gender gender,
                    String email, String city, double salary,
                    LocalDate joiningDate, Department department,
                    List<Project> projects, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.city = city;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.department = department;
        this.projects = projects;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Skill> getSkills() {
        return skills;
    }
// getters
}

