package JavaCollectionTutorial.qns.List;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q14_NonRepeated {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 1, 4, 5, 6, 2, 3, 7, 9, 11);
        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(
                x -> x,
                Collectors.counting()
        ));
        // works but not guranteed, if multiple have the same frequency
        Map.Entry<Integer, Long> integerLongEntry = collect.entrySet().stream().sorted(Comparator.comparing(x -> x.getValue()))
                .findFirst().orElseThrow();
        System.out.println(integerLongEntry.getKey());

        // working one:
        Integer integer = list.stream().filter(x -> collect.get(x) == 1).findFirst().orElseThrow();
        System.out.println(integer);

    }
}
