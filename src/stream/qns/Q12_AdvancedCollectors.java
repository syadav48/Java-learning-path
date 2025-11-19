package stream.qns;

import java.util.*;
import java.util.stream.Collectors;

public class Q12_AdvancedCollectors {
    public static void main(String[] args) {
        //1
        Map<String, Optional<Employee>> stringOptionalMap = DataFactory.employees().stream()
                .collect(Collectors.groupingBy(
                        Employee::getName,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                ));
        Optional<Employee> suresh = stringOptionalMap.get("Suresh");
        System.out.println(suresh.get().getSalary());

        Map<String, Optional<Double>> collected = DataFactory.employees().stream()
                .collect(Collectors.groupingBy(
                        Employee::getName,
                        Collectors.mapping(
                                Employee::getSalary,
                                Collectors.maxBy(Comparator.comparing(x -> x))
                        )
                ));
        System.out.println(collected);

        Map<String, Double> collected2 = DataFactory.employees().stream()
                .collect(Collectors.groupingBy(
                        Employee::getName,
                        Collectors.collectingAndThen(
                                Collectors.mapping(
                                        Employee::getSalary,
                                        Collectors.maxBy(Comparator.comparing(x -> x))
                                ),
                                opt -> opt.orElse(null)   // ← HERE
                        )
                ));

        System.out.println(collected2);

        //2
        Map<String, ArrayList<String>> collected1 = DataFactory.employees().stream().collect(Collectors.toMap(
                Employee::getCity,
                x -> new ArrayList<>(List.of(x.getName())),
                (x, y) -> {
                    x.addAll(y);
                    return x;
                }
        ));
        Map<String, List<String>> map = new HashMap<>();
        collected1.values().stream().sorted();
        for (String str : collected1.keySet()) {
            map.put(str, collected1.get(str).stream().sorted().toList());
        }
        System.out.println(collected1);
        System.out.println(map);

        Map<String, List<String>> collected3 = DataFactory.employees().stream().collect(Collectors.groupingBy(
                Employee::getCity,
                Collectors.collectingAndThen(
                        Collectors.mapping(x -> x.getName(), Collectors.toList()),
                        list -> list.stream().sorted().toList()
                )
        ));
        System.out.println(collected3);
        //3

        Map<String, Map<String, List<Employee>>> result =
                DataFactory.employees().stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,   // 1st level: department
                                Collectors.groupingBy(
                                        Employee::getName // 2nd level: gender
                                )
                        ));
        System.out.println(result );

        //4
        Map<String, Double> collected4 = DataFactory.employees().stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.summingDouble(Employee::getSalary)
        ));
        System.out.println(collected4);

        //5
        List<Integer> list = DataFactory.numbers().stream().collect(Collectors.toUnmodifiableList());



    }
}
