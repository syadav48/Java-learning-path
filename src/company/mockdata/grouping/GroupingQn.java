package company.mockdata.grouping;

import company.mockdata.DataFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingQn {
    public static void main(String[] args) {
        LinkedHashMap<String, List<String>> collect = DataFactory.employees().collect(
                Collectors.groupingBy(
                        x -> x.getDepartment().getName(),
                        LinkedHashMap::new,
                        Collectors.mapping(DataFactory.Employee::getName, Collectors.toList())
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

        Map<Integer, List<String>> collect2 = DataFactory.getEmployees().stream().collect(
                Collectors.groupingBy(
                        x -> x.getJoiningDate().getYear(),
                        Collectors.mapping(x -> x.getName(), Collectors.toList())
                )
        );
        System.out.println(collect2);




    }
}
