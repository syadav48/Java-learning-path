package stream.qns;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q13_Bonus {
    public static void main(String[] args) {
        //1
        Map<Integer, Long> collect = DataFactory.numbers().stream().collect(Collectors.groupingBy(
                x -> x,
                Collectors.counting()
        ));
        Map<Integer, Long> collect1 = Arrays.stream(DataFactory.numberArray()).boxed().collect(Collectors.groupingBy(
                x -> x,
                Collectors.counting()
        ));
        System.out.println(collect);
        System.out.println(collect1);

        //2
        Integer integer = DataFactory.employees().stream().map(Employee::getAge)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
        System.out.println(integer);

        //3

        List<String> stringList = List.of(
                "Mango",
                "Banana",
                "Orange",
                "Apple",
                "Mango",
                "Mango",
                "Mango",
                "Banana",
                "PineApple"
        );
        List<Map.Entry<String, Long>> list = stringList.stream().collect(Collectors.groupingBy(
                        x -> x,
                        Collectors.counting()
                )).entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(2)
                .toList();

        System.out.println(list);
        System.out.println(stringList.stream().collect(Collectors.groupingBy(
                x -> x,
                Collectors.counting()
        )).entrySet());





    }
}
