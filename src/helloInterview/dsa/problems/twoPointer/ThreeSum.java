package helloInterview.dsa.problems.twoPointer;

import java.util.*;

public class ThreeSum {
    private int[] twoSum(int target, int left, int[] nums){
        int right = nums.length - 1;
        while (right >= left){
            if(nums[left] + nums[right] > target){
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[]{-1, -1};
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            int[] arr = twoSum(nums[i], i + 1, nums);
            Integer n1 = arr[0];
            Integer n2 = arr[1];
            if(!Arrays.stream(arr).allMatch(x -> x == -1)){
                list.add(nums[i]);
                list.add(n1);
                list.add(n2);
            }
            res.add(list);
        }
        System.out.println(Arrays.toString(nums));
        return res;
    }
    public List<List<Integer>> threeSumOpt(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0){
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    res.add(Arrays.asList(
                            nums[i],
                            nums[left],
                            nums[right]
                    ));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]){
                        right--;
                    }

                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        //[-4, -1, -1, 0, 1, 2]

        System.out.println(threeSum.threeSumOpt(nums));
    }
}
