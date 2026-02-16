package company.mockdata.grouping;

import company.mockdata.enums.ProjectStatus;
import company.mockdata.factory.DataFactory;
import company.mockdata.model.Department;
import company.mockdata.model.Employee;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q41Grouping {
    public static void main(String[] args) {
        Map<String, List<String>> collect = DataFactory.getEmployees().stream().collect(
                Collectors.groupingBy(
                        x -> x.getDepartment().getName(),
                        Collectors.mapping(x -> x.getName(), Collectors.toList())
                )
        );
        System.out.println(collect);

        Map<String, List<String>> collect1 = DataFactory.getEmployees().stream().collect(
                Collectors.groupingBy(
                        x -> x.getCity(),
                        Collectors.mapping(x -> x.getName(), Collectors.toList())
                )
        );
        System.out.println(collect1);

        Map<ProjectStatus, List<String>> collect2 = DataFactory.getProjects().stream().collect(
                Collectors.groupingBy(
                        x -> x.getStatus(),
                        Collectors.mapping(x -> x.getName(), Collectors.toList())
                )
        );
        System.out.println(collect2);


        Map<LocalDate, List<String>> collect3 = DataFactory.getEmployees().stream().collect(
                Collectors.groupingBy(
                        x -> x.getJoiningDate(),
                        Collectors.mapping(x -> x.getName(), Collectors.toList())
                )
        );
        System.out.println(collect3);

        Map<String, Double> collect4 = DataFactory.getEmployees().stream().collect(
                Collectors.groupingBy(
                        x -> x.getDepartment().getName(),
                        //Collectors.summingDouble(Employee::getSalary)
                        Collectors.reducing(0.0, Employee::getSalary, Double::sum)
                )
        );
        System.out.println(collect4);

        Map<String, Double> collect5 = DataFactory.getEmployees().stream().collect(
                Collectors.groupingBy(
                        x -> x.getDepartment().getName(),
                        Collectors.averagingDouble(Employee::getSalary)
                )
        );
        System.out.println(collect5);

        Map<String, Long> collect6 = DataFactory.getEmployees().stream().collect(
                Collectors.groupingBy(
                        x -> x.getDepartment().getName(),
                        Collectors.counting()
                )
        );

        System.out.println(collect6);

        Map<Month, List<Long>> collect7 = DataFactory.getTransactions().stream().collect(
                Collectors.groupingBy(
                        x -> x.getDate().getMonth(),
                        Collectors.mapping(x -> x.getId(), Collectors.toList())
                )
        );
        System.out.println(collect7);
    }
}
