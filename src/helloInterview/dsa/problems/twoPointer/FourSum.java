package helloInterview.dsa.problems.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            // l - 3 means i need 3 more elem after i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right){
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > target){
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[left],
                                nums[right]
                        ));
                        left++;
                        right--;
                        // to skip duplicates
                        while (left < right && nums[left] == nums[left - 1]){
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    }
                }

            }
        }
        return res;
    }
    public static void main(String[] args) {
        FourSum sum = new FourSum();
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(sum.fourSum(nums, 0));
    }
}
