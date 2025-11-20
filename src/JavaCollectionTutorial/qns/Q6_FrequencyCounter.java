package JavaCollectionTutorial.qns;

import stream.qns.DataFactory;

import java.util.Map;
import java.util.stream.Collectors;

public class Q6_FrequencyCounter {
    public static void main(String[] args) {
        Map<Integer, Long> collect = DataFactory.numbers().stream().collect(Collectors.groupingBy(
                x -> x,
                Collectors.counting()
        ));
        System.out.println(collect);
    }
}
