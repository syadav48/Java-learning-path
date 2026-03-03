package stream.practice;

import stream.qns.DataFactory;
import stream.qns.Employee;
import stream.qns.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Q5_Collectors {
    public static void main(String[] args) {
        String collect = DataFactory.products().stream().map(x -> x.getCategory()).collect(Collectors.joining(", "));
        System.out.println(collect);
        Map<Integer, Integer> collect1 = DataFactory.numbers().stream().collect(
                Collectors.toMap(
                        x -> x,
                        x -> x,
                        (A, B) -> A
                )
        );
        System.out.println(collect1);

        Map<String, List<String>> collect2 = DataFactory.employees().stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(
                                Employee::getName,
                                Collectors.toList()
                        )

                )
        );

        Map<Transaction.Type, Long> collect3 = DataFactory.transactions().stream().collect(
                Collectors.groupingBy(
                        Transaction::getType,
                        Collectors.counting()
                )
        );
        System.out.println(collect2);
        System.out.println(collect3);

        Map<Boolean, List<Integer>> collect4 = DataFactory.numbers().stream().collect(
                Collectors.partitioningBy(x -> x % 2 == 0)
        );

        System.out.println(collect4);

        Map<String, List<Double>> collect5 = DataFactory.employees().stream().collect(
                Collectors.groupingBy(
                        Employee::getName,
                        Collectors.mapping(Employee::getSalary, Collectors.toList())
                )
        );

        System.out.println(collect5);

         DataFactory.employees().stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println();


    }
}
