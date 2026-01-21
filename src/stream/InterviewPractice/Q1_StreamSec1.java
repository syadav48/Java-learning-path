package stream.InterviewPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Q1_StreamSec1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        long count = Arrays.stream(arr).filter(x -> x % 2 == 0).count();
        System.out.println(count);

        Stream<String> s1 = Stream.of("A","B");
        Stream<String> s2 = Stream.of("C","D");
        Stream<String> concat = Stream.concat(s1, s2);
        System.out.println(concat.toList());

        Stream.generate(() -> Math.random()*20).limit(20).forEach(System.out::println);

        Map<String, Integer> map = Map.of("A",1, "B",2, "C",3);

        HashSet<Map.Entry<String, Integer>> entries = new HashSet<>(map.entrySet());
        map.keySet().stream();
        map.values().stream();
    }
}
