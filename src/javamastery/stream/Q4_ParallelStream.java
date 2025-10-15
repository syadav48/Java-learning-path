package javamastery.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q4_ParallelStream {
    public static Integer sum(List<Integer> list){
        return list.parallelStream().reduce(0, Integer::sum);
    }
    public static Integer sumToInt(List<Integer> list){
        return list.parallelStream().mapToInt(x -> x).sum();
    }
    public static Integer sumToInt2(List<Integer> list){
        return list.parallelStream().mapToInt(Integer::intValue).sum();
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 9, 11, 7);
        System.out.println(sumToInt(list));
    }
}
