package LTMClinet.streams;

import stream.qns.DataFactory;
import stream.qns.Employee;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Section12 {
    public static void main(String[] args) {
        Map<String, Employee> collect = DataFactory.employees().stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(x -> x.getSalary())),
                                Optional::get
                        )
                )
        );

        System.out.println(collect);
    }
}
