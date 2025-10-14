package javamastery.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class EnglishEmployee {
    private String name;
    private String department;

    public EnglishEmployee(String department) {
        this.department = department;
        this.name = "EnglishEmployee-" + System.currentTimeMillis(); // dummy name
    }

    public EnglishEmployee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EnglishEmployee{name='" + name + "', department='" + department + "'}";
    }
}

public class Q4_GroupingBy {
    public static void groupByDepartment(List<EnglishEmployee> list) {
        Map<String, List<EnglishEmployee>> map = list.stream().collect(Collectors.groupingBy(EnglishEmployee::getDepartment));

        // Pretty print version
        map.forEach((department, EnglishEmployees) -> {
            System.out.println("Department: " + department + " (" + EnglishEmployees.size() + " EnglishEmployees)");
            EnglishEmployees.forEach(EnglishEmployee ->
                    System.out.println("  - " + EnglishEmployee));
            System.out.println();
        });
    }

    public static void main(String[] args) {
        EnglishEmployee EnglishEmployee1 = new EnglishEmployee("John", "Spinning");
        EnglishEmployee EnglishEmployee2 = new EnglishEmployee("Jane", "Textile");
        EnglishEmployee EnglishEmployee3 = new EnglishEmployee("Bob", "IT");
        EnglishEmployee EnglishEmployee4 = new EnglishEmployee("Alice", "Spinning");
        EnglishEmployee EnglishEmployee5 = new EnglishEmployee("Charlie", "Spinning");

        List<EnglishEmployee> lists = Arrays.asList(EnglishEmployee1, EnglishEmployee2, EnglishEmployee3, EnglishEmployee4, EnglishEmployee5);
        groupByDepartment(lists);
    }
}
