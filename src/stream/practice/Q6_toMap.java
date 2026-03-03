package stream.practice;

import stream.qns.DataFactory;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Q6_toMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> collect = DataFactory.numbers().stream().collect(
                Collectors.toMap(
                        x -> x,
                        y -> 1,
                        Integer::sum,
                        HashMap::new
                )
        );
        System.out.println(collect);
    }
}
