package JavaCollectionTutorial.qns.Map;

import stream.qns.DataFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q4_MostFrequentElement {
    public static void main(String[] args) {
        Map.Entry<String, Long> first = Arrays.stream(DataFactory.paragraph().split(" ")).collect(Collectors.groupingBy(
                        x -> x,
                        TreeMap::new,
                        Collectors.counting()
                )).entrySet().stream()
                .sorted(Comparator.comparing(x -> x.getValue(), Comparator.reverseOrder())).toList().getFirst();
        System.out.println(first.getValue());
    }
}
