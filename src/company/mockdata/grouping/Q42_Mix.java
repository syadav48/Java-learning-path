package company.mockdata.grouping;

import company.mockdata.factory.DataFactory;
import company.mockdata.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Q42_Mix {
    public static void main(String[] args) {
        Double collect = DataFactory.getEmployees().stream().collect(
                Collectors.averagingInt(x -> x.getAge())
        );
        System.out.println(collect);

        Optional<String> collect1 = DataFactory.getEmployees().stream().max(Comparator.comparingDouble(Employee::getSalary)).map(Employee::getName);
        System.out.println(collect1);

        Map<Boolean, List<String>> collect2 = DataFactory.getEmployees().stream().collect(
                Collectors.partitioningBy(x -> x.getSalary() > 15_00_000,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
        System.out.println(collect2);


    }
}
