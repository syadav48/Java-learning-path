package collectors;

import java.util.*;
import java.util.stream.Collectors;

public class LearnCollectors {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 5, 6, 8, 19, 27, 56, 45, 27);
        List<Integer> newList = list.stream().filter(x -> x % 2 == 0).toList();
        System.out.println(newList);
        List<String> stringList = Arrays.asList("Surya", "Vicky", "Bhiwandi", "Pawnee", "Nitesh", "Surya");
        Set<String> listset = stringList.stream().collect(Collectors.toSet());
        System.out.println(listset);
        String concatstr = stringList.stream().collect(Collectors.joining(","));
        System.out.println(concatstr);
        Long count = list.stream().collect(Collectors.counting());
        System.out.println(count);
        double avg = list.stream().collect(Collectors.averagingInt(n -> n));
        System.out.println(avg);
        Map<Integer, List<String>> str = stringList.stream().collect(Collectors.groupingBy(x -> x.length()));
        System.out.println(str);
        Map<Boolean, List<Integer>> partioned = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(partioned);
        Set<Integer> treeSet = list.stream().collect(Collectors.toCollection(() -> new TreeSet<>()));
        System.out.println(treeSet);
        Integer sum = list.stream().collect(Collectors.summingInt(x -> x));
        System.out.println(sum);
        Map<Character, List<String>> listMap = stringList.stream().collect(Collectors.groupingBy(x -> x.charAt(0)));
        System.out.println(listMap);


    }
}
