package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTermination {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        // 1. collect
        List<Integer> collect = list.stream().skip(1).collect(Collectors.toList());
        List<Integer> collect1 = list.stream().toList();
        System.out.println(collect1);
        System.out.println(collect);

        //2. forEach
        list.forEach(System.out::println);

        // 3. reduce: combine elements to produce a single result
        Optional<Integer> reduced = list.stream().reduce(Integer::sum);
        System.out.println(reduced.get());

        // 4. count

        // 5. anyMatch, allMatch, noneMatch
        boolean anyMatch = list.stream().anyMatch(x -> x % 2 == 0);

        //6 . findFirst, findAny
        System.out.println(list.stream().findAny().get());
    }
}
