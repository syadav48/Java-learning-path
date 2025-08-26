package leetcode.arrays;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public boolean containDuplicate(int[] arr, int num){
        int count = 0;
        for (int n: arr){
            if(n == num){
                count++;
            }
        }
        return count > 1;
    };

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public int singleNumber(int[] numbs) {
        int count = 0;
        for(int n: numbs){
            if(!containDuplicate(numbs, n)){
                return n;
            };
        };
        return -1;
    }

    public int missingNumber(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for(int n : nums){
            arr.add(n);
        }

        for(int i = 1; i < arr.size() + 1; i++){
            if(!arr.contains(i)){
               return i;
            }
        }
        return -1;
    }
    public int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i>=0; i--){
            digits[i]++;
            if(digits[i] < 10){
                return  digits;
            }
            digits[i] = 0;
        }
        int [] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    };

}
public class SingleNumber {
    public static void main(String[] args){
        int[] nums = {4, 1, 2, 1, 2};
        int[] arr1 = {1,2,3,1};
        Solution obj = new Solution();
        int num = obj.singleNumber(nums);
        int[] testnum = {9,6,4,2,3,5,7,0,1};
        boolean haveDuplicate = obj.containDuplicate(nums, 2);
        int [] digits = {1, 2, 9};
        System.out.println(Arrays.toString(obj.plusOne(digits)));
        System.out.println(num);
        System.out.println(Arrays.stream(testnum).boxed().collect(Collectors.toList()));
        System.out.println(obj.containsDuplicate(arr1));
        System.out.println(obj.missingNumber(testnum));
    }
}
