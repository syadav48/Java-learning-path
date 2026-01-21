package stream.InterviewPractice;

import stream.qns.DataFactory;
import stream.qns.Employee;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Q5_collectors {
    public static void main(String[] args) {
        String collect = DataFactory.products().stream().map(x -> x.getName()).collect(Collectors.joining(","));
        System.out.println(collect);
        Set<Integer> collect1 = DataFactory.numbers().stream().collect(Collectors.toSet());
        System.out.println(collect1);

        Map<Integer, String> collect2 = DataFactory.products().stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));

        System.out.println(collect2);

        Map<String, Long> collect3 = DataFactory.employees().stream().collect(
                Collectors.groupingBy(
                        x -> x.getDepartment(), Collectors.counting()
                )
        );

        Map<Boolean, List<Integer>> collect4 = DataFactory.numbers().stream().collect(
                Collectors.partitioningBy(x -> x % 2 == 0)
        );
        System.out.println(collect3);
        System.out.println(collect4);

        Map<String, Double> collect5 = DataFactory.employees().stream().collect(
                Collectors.toMap(x -> x.getName(), x -> x.getSalary())
        );
        System.out.println(collect5);

        IntSummaryStatistics collect6 = DataFactory.numbers().stream().collect(
                Collectors.summarizingInt(x -> x)
        );
        System.out.println(collect6);
    }

}
