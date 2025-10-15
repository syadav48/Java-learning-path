package javamastery.stream.Intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q9_PartitionedBy {
    public static void partitionedBy(List<Integer> list){
        Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(map);
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        partitionedBy(list);
    }
}
