package stream.qns;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DataFactory {

    // --- Employees -----------------------------------------------------------
    public static List<Employee> employees() {
        return Arrays.asList(
                new Employee(1, "Amit", 28, 45000, "IT", "Mumbai", List.of("Java", "SQL")),
                new Employee(2, "Riya", 32, 75000, "Finance", "Delhi", List.of("Excel", "Finance", "Auditing")),
                new Employee(3, "Suresh", 45, 120000, "IT", "Bangalore", List.of("Java", "Spring", "Docker")),
                new Employee(4, "Pooja", 22, 38000, "HR", "Mumbai", List.of("Communication")),
                new Employee(5, "John", 37, 95000, "Sales", "Delhi", List.of("Negotiation", "CRM")),
                new Employee(6, "Mary", 29, 55000, "Finance", "Chennai", List.of("Tally", "Analytics")),
                new Employee(7, "Kunal", 50, 150000, "IT", "Pune", List.of("Cloud", "Kubernetes", "Java")),
                new Employee(8, "Sara", 27, 60000, "Marketing", "Bangalore", List.of("SEO", "Content"))
        );
    }

    // --- Transactions --------------------------------------------------------
    public static List<Transaction> transactions() {
        return Arrays.asList(
                new Transaction("TXN01", Transaction.Type.CREDIT, 2500, LocalDate.now().minusDays(1)),
                new Transaction("TXN02", Transaction.Type.DEBIT, 1200, LocalDate.now().minusDays(2)),
                new Transaction("TXN03", Transaction.Type.REFUND, 500, LocalDate.now().minusDays(3)),
                new Transaction("TXN04", Transaction.Type.CREDIT, 9000, LocalDate.now().minusDays(10)),
                new Transaction("TXN05", Transaction.Type.DEBIT, 300, LocalDate.now().minusDays(5))
        );
    }

    // --- Products ------------------------------------------------------------
    public static List<Product> products() {
        return Arrays.asList(
                new Product(101, "Laptop", "Electronics", 55000),
                new Product(102, "Mouse", "Electronics", 500),
                new Product(103, "Chair", "Furniture", 2000),
                new Product(104, "Table", "Furniture", 4500),
                new Product(105, "Headphones", "Electronics", 1500)
        );
    }

    // --- Orders --------------------------------------------------------------
    public static List<Order> orders() {
        return Arrays.asList(
                new Order(1, 1001, List.of(products().get(0), products().get(1)), LocalDate.now().minusDays(2)),
                new Order(2, 1002, List.of(products().get(2), products().get(3)), LocalDate.now().minusDays(4)),
                new Order(3, 1001, List.of(products().get(4), products().get(1)), LocalDate.now().minusDays(1))
        );
    }

    // --- Map samples ---------------------------------------------------------
    public static Map<String, Integer> sampleMap() {
        return Map.of(
                "A", 10,
                "B", 20,
                "C", 30,
                "A_duplicate", 40
        );
    }

    // --- Numbers -------------------------------------------------------------
    public static List<Integer> numbers() {
        return List.of(1, 5, 2, 5, 9, 12, 3, 3, 8, 20);
    }

    public static int[] numberArray() {
        return new int[]{1, 2, 3, 4, 5, 6};
    }

    // --- Strings -------------------------------------------------------------
    public static List<String> sentences() {
        return List.of(
                "Java stream API is powerful",
                "Streams improve readability"
        );
    }

    // --- Optionals -----------------------------------------------------------
    public static List<Optional<String>> optionalStrings() {
        return List.of(
                Optional.of("Hello"),
                Optional.empty(),
                Optional.of("World"),
                Optional.empty()
        );
    }

    // --- Nested map used in real projects -----------------------------------
    public static Map<String, List<String>> roleToUsers() {
        return Map.of(
                "ADMIN", List.of("Amit", "Riya"),
                "USER", List.of("John", "Sara", "Pooja"),
                "GUEST", List.of("TempUser1", "TempUser2")
        );
    }
}

