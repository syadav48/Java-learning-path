package Interview.Delloite;

import company.mockdata.DataFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollClass {
    public static void main(String[] args) {
        Map<String, List<String>> collect = DataFactory.getEmployees().stream().collect(
                Collectors.groupingBy(
                        x -> x.getDepartment().getName(),
                        Collectors.mapping(x -> x.getName(), Collectors.toList())
                )
        );
        System.out.println(collect);
        Map<String, String> collect1 = DataFactory.getEmployees().stream().collect(
                Collectors.groupingBy(
                        x -> x.getDepartment().getName(),
                        Collectors.mapping(x -> x.getName(), Collectors.joining(", "))
                )
        );
        System.out.println(collect1);

        String name = DataFactory.getEmployees().stream().collect(Collectors.maxBy(
                Comparator.comparing(x -> x.getSalary())
        )).orElseThrow().getName();
        System.out.println(name);


    }
}
