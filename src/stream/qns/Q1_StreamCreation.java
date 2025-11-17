package stream.qns;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q1_StreamCreation {
    public static void main(String[] args) {
//        1

        List<Integer> list1 = DataFactory.numbers();
        Stream<Integer> listStream = list1.stream();
        System.out.println(listStream.toList());

        // 2
        int[] arr = DataFactory.numberArray();
        long evenCount = Arrays.stream(arr).boxed().filter(x -> x % 2 == 0).count();
        List<Integer> list = List.of(1,2,2,2,3,5,5);
        System.out.println(list.stream().toList());
        System.out.println(evenCount);

        // 3
        Stream<String> s1 = Stream.of("A", "B");
        Stream<String> s2 = Stream.of("C", "D");
        String str1 = Stream.concat(s1, s2).collect(Collectors.joining(""));
        System.out.println(str1);

        //4
        Stream.generate(() -> Math.random()*100).limit(20).forEach(System.out::println);

        //5
        Map<String, Integer> map = DataFactory.sampleMap();
        Stream<String> keySet = map.keySet().stream();
        Stream<Integer> valueSet = map.values().stream();
        HashSet<Map.Entry<String, Integer>> set = new HashSet<>(map.entrySet());
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();
        System.out.println(keySet.toList());
        System.out.println(valueSet.toList());
        System.out.println(entryStream.toList());


    }
}
