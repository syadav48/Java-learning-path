package javamastery.practice;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayQns {
    public int[] removeDuplicates(int[] arr){
        HashSet<Integer> nums = new HashSet<>();
        for(int num: arr){
            if(!nums.contains(num)){
                nums.add(num);
            }
        }
        int[] array = Arrays.stream(arr).boxed().collect(
                Collectors.toMap(
                        x -> x,
                        x -> x,
                        (a, b) -> a,
                        HashMap::new
                )
        ).values().stream().mapToInt(x -> x.intValue()).toArray();
        //return nums.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }
    public int secondLargest(int[] arr){
        return Arrays.stream(arr).boxed().max(Comparator.comparing(
                x -> x
        )).orElseThrow();
    }
    public static void main(String[] args) {
        ArrayQns arrayQns = new ArrayQns();
        int[] arr = {1,2,3,3,3,3,3,44,4,4};
        System.out.println(Arrays.toString(arrayQns.removeDuplicates(arr)));
        System.out.println(arrayQns.secondLargest(arr));
    }
}
