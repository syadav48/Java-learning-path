package helloInterview.dsa.twoPointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Level1 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (right >= left){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }
    public boolean isPalindrome(String s) {
        String check =  s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = s.length() - 1;
        while (right >= left) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        System.out.println(check);
        return true;
    }
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (right >= left){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                res[0] = left+1;
                res[1] = right+1;
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    public void moveZeroes(int[] nums) {
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }

    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert result set to array
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }
        return result;
    }
    public static void main(String[] args) {
        Level1 level1 = new Level1();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        String str = "A man, a plan, a canal: Panama";
        int[] nums = {2,3,4};
        int[] numbers = {0,0,1,1,1,2,2,3,3,4};
        int[] nums1 = {3,2,2,3};
        int[] nums2 = {0,1,0,3,12};
        int[] nums3 = {1,2,3,0,0,0};
        int[] nums4 = {2,5,6};


        level1.reverseString(s);
        System.out.println(level1.isPalindrome(str));
        System.out.println(Arrays.toString(level1.twoSum(nums, 6)));
        System.out.println(level1.removeDuplicates(numbers));
        System.out.println(level1.removeElement(nums1, 3));
        level1.moveZeroes(nums2);

        level1.merge(nums3, 3, nums4, 3);
    }
}
