package stream.InterviewPractice;

import stream.qns.DataFactory;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q6_Bonus {
    public static void main(String[] args) {
        List<Integer> numbers = DataFactory.numbers();
        HashMap<Integer, Integer> map = new HashMap<>();
        Map<Integer, Long> collect = numbers.stream().collect(
                Collectors.groupingBy(
                        x -> x, Collectors.counting()
                )
        );
        for (Integer num: numbers){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(collect);
        System.out.println(map);


        Double list = DataFactory.products().stream().map(x -> x.getPrice())
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();

        System.out.println(list);
    }
}
