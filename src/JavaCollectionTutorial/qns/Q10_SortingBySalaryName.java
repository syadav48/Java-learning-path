package JavaCollectionTutorial.qns;

import stream.qns.DataFactory;
import stream.qns.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q10_SortingBySalaryName {
    public static void main(String[] args) {
        List<Employee> sorted = DataFactory.employees().stream().sorted(
                Comparator.comparing(
                        Employee::getSalary,
                        Comparator.reverseOrder()
                ).thenComparing(Comparator.comparing(Employee::getName))
        ).toList();
        System.out.println(sorted.stream().map(Employee::getName).toList());
    }
}
