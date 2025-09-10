package leetcode.arrays;


import java.util.Arrays;
import java.util.List;

public class ThirdMax {
    public static int thirdMax(int[] nums) {
         List<Integer> list = Arrays.stream(nums).boxed().distinct().sorted().toList();
         if(list.size() >= 3){
             return list.get(list.size() - 3);
         }
         return  list.getLast();
    }
    public static void main(String[] args) {
        int[] arr = {2, 1};
        System.out.println(thirdMax(arr));
    }
}
