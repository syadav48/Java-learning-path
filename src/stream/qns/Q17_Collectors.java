package stream.qns;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Q17_Collectors {
    public static void main(String[] args) {
        String collect = DataFactory.products().stream().map(x -> x.getName()).collect(Collectors.joining(", "));
        System.out.println(collect);
        Set<Integer> collect1 = DataFactory.numbers().stream().collect(Collectors.toSet());
        System.out.println(collect1);

        Map<Integer, Integer> collect2 = DataFactory.numbers().stream().collect(Collectors.toMap(
                x -> x,
                y -> y,
                (a, b) -> a
        ));
        System.out.println(collect2);

        Map<String, List<String>> collect3 = DataFactory.employees().stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(x -> x.getName(), Collectors.toList())
                )
        );

        Map<Transaction.Type, Long> collect4 = DataFactory.transactions().stream().collect(
                Collectors.groupingBy(
                        x -> x.getType(),
                        Collectors.counting()

                )
        );
        System.out.println(collect3);
        System.out.println(collect4);
    }
}
