package leetcode.HashMap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FastestSubArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Long> collect = Arrays.stream(nums).boxed().collect(
                Collectors.groupingBy(
                        x -> x,
                        Collectors.counting()
                )
        );


        Arrays.stream(nums).boxed().findFirst().orElseThrow();

        System.out.println(collect);
        return 5;
    }
    public static void main(String[] args) {
        int [] nums = {1,2,2,3,1,4,2};
        FastestSubArray fastestSubArray = new FastestSubArray();
        fastestSubArray.findShortestSubArray(nums);
        // {1 = {count: 1, indexes: [0, 4]}, 2 = {count: 3, indexes: [1, 6]}, {count: 1, indexes: [3, 3]}, count: 1, indexes: [6,6]}

    }
}
