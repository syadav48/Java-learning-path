package helloInterview.dsa.problems.arrString;

import java.util.*;

public class FindDisappearedNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
    public List<Integer> findDisappearedNumbersOpt(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            System.out.println(Arrays.toString(nums));
            if(nums[idx] > 0){
                nums[idx] = -nums[idx];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        FindDisappearedNumber findDisappearedNumber = new FindDisappearedNumber();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumber.findDisappearedNumbersOpt(nums));
    }
}
