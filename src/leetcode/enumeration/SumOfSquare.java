package leetcode.enumeration;

import java.util.ArrayList;
import java.util.List;

public class SumOfSquare {
    public static int sumOfSquares(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < nums.length+1; i++){
            if(nums.length % i == 0){
                list.add(nums[i - 1]);
            }
        }
        System.out.println(list);
        return list.stream().map(x -> x * x).reduce(0, (a, b) -> a + b);
    };
    public static void main(String[] args) {
        int[] nums = {2,7,1,19,18,3};
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(sumOfSquares(nums));
        System.out.println(sumOfSquares(nums1));
    }
}
