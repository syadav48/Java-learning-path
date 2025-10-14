package javamastery.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q2_StreamLogical {
    public static List<String> sortalpha(List<String> employees){
        return employees.stream().sorted(Comparator.reverseOrder()).toList();
    }
    public static List<Integer> distinctNum(List<Integer> nums){
        return nums.stream().distinct().filter(x -> x % 2 == 0).limit(3).toList();
    }
    public static List<Integer> flatArr(List<List<Integer>> nums){
        return nums.stream().flatMap(Collection::stream).toList();
    }

    public static void main(String[] args) {
        List<String> employees = Arrays.asList("John", "Amit", "Ravi", "Deepak");
        List<Integer> nums = Arrays.asList(5, 6, 4, 6, 6, 8, 9, 11, 13, 15, 17, 9, 6, 8);
        List<List<Integer>> numbers = Arrays.asList(Arrays.asList(1,2), Arrays.asList(3,4), Arrays.asList(5));
        System.out.println(distinctNum(nums));
        System.out.println(flatArr(numbers));
    }
}
