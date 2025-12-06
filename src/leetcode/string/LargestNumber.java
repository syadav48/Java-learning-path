package leetcode.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<List<String>> list = new ArrayList<>();
        for(int num : nums){
          list.add(
                  Arrays.stream(Integer.toString(num).split(""))
                          .toList()
          );
        }
        List<String> collect = list.stream().flatMap(Collection::stream).toList();
        System.out.println(collect);
        //return "5";
        return collect.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining(""));
    }
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(nums));
    }
}
