package leetcode.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class SneakyNumbers {
    public int[] getSneakyNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Long> collect = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(
                x -> x,
                Collectors.counting()
        ));
        for (Map.Entry<Integer, Long> entry: collect.entrySet()){
            if(entry.getValue() > 1){
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
    public int[] getSneakyNumbersOptimized(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for(int num: nums){
            if(!seen.add(num)){
                duplicates.add(num);
            }
        }
        return duplicates.stream().mapToInt(x -> x).toArray();
    }
    public int[] getSneakyNumbersOptimizedV2(int[] nums) {
        return Arrays.stream(nums)
                .boxed().collect(Collectors.groupingBy(
                        x -> x,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,4,3,4,6,0,9,5,8,2};
        SneakyNumbers sneakyNumbers = new SneakyNumbers();
        System.out.println(Arrays.toString(sneakyNumbers.getSneakyNumbers(nums)));
    }
}
