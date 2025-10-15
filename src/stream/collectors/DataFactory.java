package stream.collectors;

import java.util.Arrays;
import java.util.List;

public class DataFactory {
    public static List<Employee> getEmployees(){
          List<Employee> employees = Arrays.asList(
                new Employee("Suresh", "IT", 85000, 30, "Delhi", true),
                new Employee("Ramesh", "HR", 55000, 42, "Mumbai", true),
                new Employee("Mahesh", "Finance", 72000, 38, "Pune", false),
                new Employee("Rajesh", "IT", 95000, 28, "Delhi", true),
                new Employee("Lokesh", "Finance", 88000, 35, "Bangalore", true),
                new Employee("Dinesh", "HR", 60000, 45, "Chennai", false),
                new Employee("Naresh", "IT", 99000, 33, "Bangalore", true),
                new Employee("Kiran", "Finance", 67000, 31, "Pune", true),
                new Employee("Sanjay", "HR", 53000, 41, "Mumbai", true),
                new Employee("Pankaj", "IT", 78000, 26, "Delhi", false)
        );
          return employees;
    }
    public static List<Person> getPerson(){
        List<Person> people = Arrays.asList(
                new Person("Amit", 25, "Male", Arrays.asList("Reading", "Cricket", "Music")),
                new Person("Neha", 22, "Female", Arrays.asList("Dancing", "Traveling", "Music")),
                new Person("Rohit", 30, "Male", Arrays.asList("Cooking", "Traveling")),
                new Person("Priya", 28, "Female", Arrays.asList("Painting", "Reading", "Yoga")),
                new Person("Karan", 35, "Male", Arrays.asList("Gaming", "Movies", "Music")),
                new Person("Sneha", 27, "Female", Arrays.asList("Reading", "Cooking", "Movies")),
                new Person("Vikas", 32, "Male", Arrays.asList("Cycling", "Traveling")),
                new Person("Anita", 24, "Female", Arrays.asList("Yoga", "Music", "Photography"))
        );
        return people;
    }
}
