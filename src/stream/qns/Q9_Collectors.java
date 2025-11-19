package stream.qns;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q9_Collectors {
    public static void main(String[] args) {
        //1
        List<List<String>> list = DataFactory.sentences().stream()
                .map(e -> Arrays.stream(e.split(" "))
                        .toList()).toList();
        System.out.println(list);
        String str = "Learning Java's collection and other framework";
        List<String> list1 = Arrays.stream(str.split(" ")).toList();
        System.out.println(list1);

        //2
        Set<Integer> hashSet = new HashSet<>(DataFactory.numbers());
        System.out.println(hashSet);

        //3
        Map<Integer, List<Integer>> map = DataFactory.numbers().stream().collect(Collectors
                .toMap(x -> x, x -> new ArrayList<>(List.of(x)),
                        (x, y) -> {
                            x.addAll(y);
                            return x;
                        }
                ));
        System.out.println(map);

        //4
        Map<String, List<String>> hashMap = DataFactory.employees().stream().collect(Collectors.toMap(
                Employee::getDepartment,
                x -> new ArrayList<>(List.of(x.getName())),
                (x, y) -> {
                    x.addAll(y);
                    return x;
                }
        ));
        System.out.println(hashMap);

        //5
        Map<Transaction.Type, Long> countByType =
                DataFactory.transactions().stream()
                        .collect(Collectors.groupingBy(
                                Transaction::getType,
                                Collectors.counting()
                        ));
        System.out.println(countByType);

        Map<Transaction.Type, Integer> countByType2 =
                DataFactory.transactions().stream()
                        .collect(Collectors.toMap(
                                Transaction::getType,   // key: type
                                t -> 1,                 // value: 1 transaction
                                Integer::sum,           // merge duplicates: add counts
                                HashMap::new
                        ));
        System.out.println(countByType2);


        //6
        Map<Boolean, List<Integer>> partionedBy = DataFactory.numbers().stream().collect(
                Collectors.partitioningBy(x -> x % 2 == 0)
        );
        System.out.println(partionedBy);

        //7
        Map<String, Double> map1 = DataFactory.employees().stream().collect(
                Collectors.groupingBy(
                        Employee::getName,
                        Collectors.averagingInt(x -> (int) x.getSalary())
                )
        );
        Map<String, Double> map2 = DataFactory.employees().stream().collect(
                Collectors.toMap(
                        Employee::getName,
                        Employee::getSalary
                )
        );
        System.out.println(map2);

    }

}
