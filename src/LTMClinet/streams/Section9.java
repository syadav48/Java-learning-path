package LTMClinet.streams;

import stream.qns.DataFactory;
import stream.qns.Employee;
import stream.qns.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Section9 {
    public static void main(String[] args) {
        String collect = DataFactory.sentences().stream().collect(Collectors.joining(","));
        Set<Integer> collect1 = DataFactory.numbers().stream().collect(Collectors.toSet());
        // collect
        List<Integer> collect2 = DataFactory.numbers().stream().collect(
                Collectors.toMap(
                        x -> x,
                        x -> x,
                        (x, y) -> y,
                        HashMap::new
                )
        ).values().stream().toList();
        System.out.println(collect);
        System.out.println(collect1);
        System.out.println(collect2);

        Map<String, List<String>> collect3 = DataFactory.employees().stream().collect(Collectors.groupingBy(
                x -> x.getDepartment(),
                Collectors.mapping(Employee::getName, Collectors.toList())
        ));
        System.out.println(collect3);
        Map<Transaction.Type, Long> collect4 = DataFactory.transactions().stream().collect(
                Collectors.groupingBy(
                        x -> x.getType(),
                        Collectors.counting()
                )
        );
        Map<Boolean, List<Integer>> collect5 = DataFactory.numbers().stream().collect(Collectors.partitioningBy(
                x -> x % 2 == 0,
                Collectors.mapping(x -> x, Collectors.toList())
        ));
        System.out.println(collect5);

        Map<String, List<Double>> collect6 = DataFactory.employees().stream().collect(
                Collectors.groupingBy(
                        x -> x.getName(),
                        Collectors.mapping(x -> x.getSalary(), Collectors.toList())
                )
        );
        System.out.println(collect6);
    }
}
