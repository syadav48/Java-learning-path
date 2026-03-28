package company.mockdata;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public final class DataFactory {

    private DataFactory() {}

    // -------------------- ENUMS --------------------
    public enum Gender { MALE, FEMALE }
    public enum ProjectStatus { ACTIVE, COMPLETED, ON_HOLD }
    public enum TicketStatus { OPEN, IN_PROGRESS, RESOLVED }
    public enum TicketPriority { LOW, MEDIUM, HIGH }
    public enum TransactionType { CREDIT, DEBIT }

    // -------------------- DOMAIN --------------------
    public static class Department {
        private Long id;
        private String name;
        private String location;
        private double budget;

        public Department(Long id, String name, String location, double budget) {
            this.id = id;
            this.name = name;
            this.location = location;
            this.budget = budget;
        }

        public String getName() { return name; }
    }

    public static class Client {
        private Long id;
        private String name;
        private String country;

        public Client(Long id, String name, String country) {
            this.id = id;
            this.name = name;
            this.country = country;
        }
    }

    public static class Project {
        private Long id;
        private String name;
        private ProjectStatus status;
        private LocalDate startDate;
        private double budget;
        private Client client;

        public Project(Long id, String name, ProjectStatus status,
                       LocalDate startDate, double budget, Client client) {
            this.id = id;
            this.name = name;
            this.status = status;
            this.startDate = startDate;
            this.budget = budget;
            this.client = client;
        }

        public ProjectStatus getStatus() { return status; }
        public double getBudget() { return budget; }
    }

    public static class Employee {
        private Long id;
        private String name;
        private int age;
        private Gender gender;
        private String city;
        private double salary;
        private LocalDate joiningDate;
        private Department department;
        private List<Project> projects;

        public Employee(Long id, String name, int age, Gender gender,
                        String city, double salary, LocalDate joiningDate,
                        Department department, List<Project> projects) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.city = city;
            this.salary = salary;
            this.joiningDate = joiningDate;
            this.department = department;
            this.projects = projects;
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

        public LocalDate getJoiningDate() {
            return joiningDate;
        }

        public double getSalary() { return salary; }
        public String getCity() { return city; }
        public Department getDepartment() { return department; }
        public List<Project> getProjects() { return projects; }
    }

    public static class Ticket {
        private Long id;
        private TicketPriority priority;
        private TicketStatus status;
        private Employee assignedTo;

        public Ticket(Long id, TicketPriority priority, TicketStatus status,
                      Employee assignedTo) {
            this.id = id;
            this.priority = priority;
            this.status = status;
            this.assignedTo = assignedTo;
        }

        public Employee getAssignedTo() {
            return assignedTo;
        }

        public TicketStatus getStatus() { return status; }
    }

    // -------------------- DATA --------------------

    public static List<Employee> getEmployees() {
        List<Department> d = getDepartments();
        List<Project> p = getProjects();

        return List.of(
                new Employee(1L, "Amit", 28, Gender.MALE, "Bangalore", 1200000, LocalDate.of(2021,5,10), d.get(0), List.of(p.get(0), p.get(1))),
                new Employee(2L, "Neha", 32, Gender.FEMALE, "Pune", 1500000, LocalDate.of(2019,3,15), d.get(1), List.of(p.get(2))),
                new Employee(3L, "Rahul", 26, Gender.MALE, "Delhi", 900000, LocalDate.of(2022,1,20), d.get(0), List.of(p.get(3))),
                new Employee(4L, "Priya", 29, Gender.FEMALE, "Mumbai", 1100000, LocalDate.of(2020,7,11), d.get(2), List.of(p.get(4))),
                new Employee(5L, "Karan", 35, Gender.MALE, "Hyderabad", 2000000, LocalDate.of(2018,9,30), d.get(0), List.of(p.get(5))),
                new Employee(6L, "Sneha", 27, Gender.FEMALE, "Bangalore", 950000, LocalDate.of(2021,12,1), d.get(3), List.of(p.get(6))),
                new Employee(7L, "Vikram", 40, Gender.MALE, "Pune", 2200000, LocalDate.of(2015,6,18), d.get(2), List.of(p.get(7))),
                new Employee(8L, "Anjali", 31, Gender.FEMALE, "Delhi", 1300000, LocalDate.of(2019,4,25), d.get(1), List.of(p.get(8))),
                new Employee(9L, "Rohit", 24, Gender.MALE, "Mumbai", 800000, LocalDate.of(2023,2,14), d.get(4), List.of(p.get(9))),
                new Employee(10L, "Pooja", 30, Gender.FEMALE, "Hyderabad", 1400000, LocalDate.of(2020,10,10), d.get(3), List.of(p.get(0))),
                new Employee(11L, "Arjun", 33, Gender.MALE, "Bangalore", 1600000, LocalDate.of(2017,8,8), d.get(0), List.of(p.get(2))),
                new Employee(12L, "Meena", 28, Gender.FEMALE, "Pune", 1000000, LocalDate.of(2021,3,3), d.get(1), List.of(p.get(4)))
        );
    }

    public static List<Department> getDepartments() {
        return List.of(
                new Department(1L, "Engineering", "Bangalore", 5_000_000),
                new Department(2L, "HR", "Pune", 1_000_000),
                new Department(3L, "Finance", "Mumbai", 2_000_000),
                new Department(4L, "Marketing", "Delhi", 1_500_000),
                new Department(5L, "Support", "Hyderabad", 800_000)
        );
    }
    public static List<Client> getClients() {
        return List.of(
                new Client(1L, "Google", "USA"),
                new Client(2L, "Amazon", "USA"),
                new Client(3L, "Flipkart", "India"),
                new Client(4L, "Microsoft", "USA"),
                new Client(5L, "Infosys", "India"),
                new Client(6L, "TCS", "India"),
                new Client(7L, "Meta", "USA"),
                new Client(8L, "Netflix", "USA"),
                new Client(9L, "Adobe", "USA"),
                new Client(10L, "Paytm", "India"),
                new Client(11L, "Swiggy", "India"),
                new Client(12L, "Zomato", "India")
        );
    }

    public static List<Project> getProjects() {
        List<Client> clients = getClients();

        return List.of(
                new Project(1L, "Search Engine", ProjectStatus.ACTIVE, LocalDate.of(2023,1,1), 1_000_000, clients.get(0)),
                new Project(2L, "E-Commerce", ProjectStatus.COMPLETED, LocalDate.of(2022,5,10), 2_000_000, clients.get(2)),
                new Project(3L, "Cloud Infra", ProjectStatus.ACTIVE, LocalDate.of(2023,3,15), 3_000_000, clients.get(3)),
                new Project(4L, "Streaming", ProjectStatus.ON_HOLD, LocalDate.of(2021,8,20), 1_500_000, clients.get(7)),
                new Project(5L, "Payments", ProjectStatus.ACTIVE, LocalDate.of(2022,11,5), 800_000, clients.get(9)),
                new Project(6L, "Food Delivery", ProjectStatus.COMPLETED, LocalDate.of(2020,6,1), 1_200_000, clients.get(11)),
                new Project(7L, "AI Platform", ProjectStatus.ACTIVE, LocalDate.of(2023,7,7), 2_500_000, clients.get(6)),
                new Project(8L, "CRM Tool", ProjectStatus.ON_HOLD, LocalDate.of(2021,2,14), 700_000, clients.get(4)),
                new Project(9L, "HR System", ProjectStatus.COMPLETED, LocalDate.of(2020,12,25), 600_000, clients.get(5)),
                new Project(10L, "Analytics", ProjectStatus.ACTIVE, LocalDate.of(2022,9,9), 1_800_000, clients.get(8))
        );
    }

    public static List<Ticket> getTickets() {
        List<Employee> e = getEmployees();

        return List.of(
                new Ticket(1L, TicketPriority.HIGH, TicketStatus.OPEN, e.get(0)),
                new Ticket(2L, TicketPriority.LOW, TicketStatus.RESOLVED, e.get(1)),
                new Ticket(3L, TicketPriority.MEDIUM, TicketStatus.IN_PROGRESS, e.get(2)),
                new Ticket(4L, TicketPriority.HIGH, TicketStatus.OPEN, e.get(3)),
                new Ticket(5L, TicketPriority.LOW, TicketStatus.RESOLVED, e.get(4)),
                new Ticket(6L, TicketPriority.MEDIUM, TicketStatus.IN_PROGRESS, e.get(5)),
                new Ticket(7L, TicketPriority.HIGH, TicketStatus.OPEN, e.get(6)),
                new Ticket(8L, TicketPriority.LOW, TicketStatus.RESOLVED, e.get(7)),
                new Ticket(9L, TicketPriority.MEDIUM, TicketStatus.OPEN, e.get(8)),
                new Ticket(10L, TicketPriority.HIGH, TicketStatus.IN_PROGRESS, e.get(9))
        );
    }

    // -------------------- STREAM READY --------------------

    public static Stream<Employee> employees() {
        return getEmployees().stream();
    }

    public static Stream<Ticket> tickets() {
        return getTickets().stream();
    }

    public static Stream<Project> projects() {
        return getProjects().stream();
    }
}