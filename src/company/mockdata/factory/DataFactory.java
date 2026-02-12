package company.mockdata.factory;

import company.mockdata.enums.*;
import company.mockdata.model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public final class DataFactory {

    private static final Random random = new Random();

    private DataFactory() {}

    // ================== DEPARTMENTS ==================

    public static List<Department> getDepartments() {
        return List.of(
                new Department(1L, "Engineering", "Bangalore", 5_00_00_000),
                new Department(2L, "HR", "Mumbai", 50_00_000),
                new Department(3L, "Finance", "Delhi", 1_00_00_000),
                new Department(4L, "DevOps", "Hyderabad", 2_00_00_000),
                new Department(5L, "Support", "Chennai", 75_00_000)
        );
    }

    // ================== CLIENTS ==================

    public static List<Client> getClients() {
        return IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Client(
                        (long) i,
                        "Client-" + i,
                        i % 2 == 0 ? "India" : "USA",
                        ClientType.values()[random.nextInt(ClientType.values().length)]
                ))
                .toList();
    }

    // ================== PROJECTS ==================

    public static List<Project> getProjects() {
        List<Client> clients = getClients();

        return IntStream.rangeClosed(1, 15)
                .mapToObj(i -> new Project(
                        (long) i,
                        "Project-" + i,
                        ProjectStatus.values()[random.nextInt(ProjectStatus.values().length)],
                        LocalDate.now().minusDays(random.nextInt(1000)),
                        LocalDate.now().plusDays(random.nextInt(500)),
                        10_00_000 + random.nextInt(50_00_000),
                        clients.get(random.nextInt(clients.size()))
                ))
                .toList();
    }

    // ================== EMPLOYEES ==================

    public static List<Employee> getEmployees() {
        List<Department> departments = getDepartments();
        List<Project> projects = getProjects();

        String[] cities = {"Bangalore", "Mumbai", "Delhi", "Hyderabad", "Chennai"};

        return IntStream.rangeClosed(1, 50)
                .mapToObj(i -> new Employee(
                        (long) i,
                        "Employee-" + i,
                        22 + random.nextInt(18),
                        Gender.values()[random.nextInt(Gender.values().length)],
                        "employee" + i + "@company.com",
                        cities[random.nextInt(cities.length)],
                        3_00_000 + random.nextInt(20_00_000),
                        LocalDate.now().minusDays(random.nextInt(2000)),
                        departments.get(random.nextInt(departments.size())),
                        projects.stream().limit(random.nextInt(5) + 1).toList(),
                        Arrays.stream(Skill.values())
                                .limit(random.nextInt(5) + 1)
                                .toList()
                ))
                .toList();
    }

    // ================== TICKETS ==================

    public static List<Ticket> getTickets() {
        List<Employee> employees = getEmployees();

        return IntStream.rangeClosed(1, 200)
                .mapToObj(i -> {
                    LocalDate created = LocalDate.now().minusDays(random.nextInt(100));
                    boolean resolved = random.nextBoolean();
                    return new Ticket(
                            (long) i,
                            TicketPriority.values()[random.nextInt(TicketPriority.values().length)],
                            resolved ? TicketStatus.RESOLVED : TicketStatus.OPEN,
                            employees.get(random.nextInt(employees.size())),
                            created,
                            resolved ? created.plusDays(random.nextInt(10)) : null
                    );
                })
                .toList();
    }

    // ================== TRANSACTIONS ==================

    public static List<Transaction> getTransactions() {
        return IntStream.rangeClosed(1, 500)
                .mapToObj(i -> new Transaction(
                        (long) i,
                        TransactionType.values()[random.nextInt(TransactionType.values().length)],
                        10_000 + random.nextInt(5_00_000),
                        LocalDate.now().minusDays(random.nextInt(365)),
                        "TXN-" + i
                ))
                .toList();
    }
}

