package LTMClinet.core.easy;

import stream.qns.DataFactory;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] arr){
        return Arrays.stream(arr).distinct().toArray();
    }
    public static int[] includeDuplicates(int[] arr){
        HashSet<Integer> seen = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(!seen.add(arr[i])){
                seen.add(arr[i]);
                list.add(arr[i]);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
    public static void countNumbers(int[] arr){
        Map<Integer, Long> collect = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(
                x -> x,
                Collectors.counting()
        ));
        System.out.println(collect);
    }
    public static int findSecondHighest(int[] arr){
        Integer max = Integer.MIN_VALUE;
        Integer secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }
        }
        return secondMax;
    }
    public static int findMissingNo(int[] arr){
        int length = arr.length;
        int sum = ((length) * (length + 1))/2;
        int arrsum = Arrays.stream(arr).sum();
        return arrsum - sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,2,5,2,23,23,4};
        int[] nums = {1,2,3,4,5,7};
        int[] ints = RemoveDuplicates.removeDuplicates(arr);
        int[] ints1 = RemoveDuplicates.includeDuplicates(arr);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
        RemoveDuplicates.countNumbers(arr);
        System.out.println(RemoveDuplicates.findSecondHighest(arr));
        System.out.println(findMissingNo(nums));
    }
}
