package helloInterview.dsa.twoPointer;

import java.util.Arrays;

public class Level2 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int min = Integer.MAX_VALUE;
        int area = Integer.MIN_VALUE;
        while (right >= left){
            min = Math.min(height[left], height[right]);
             area  = Math.max(area, ((right - left) * min));
             if(height[left] > height[right]){
                 right--;
             } else {
                 left++;
             }

        }

        return area;
    }
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int round = 0;
        int left = 0;
        int right = people.length - 1;
        while (right >= left){
            if(people[left] + people[right] <= limit){
                left++;
            }
            right--;
            round++;
        }
        return round;
    }
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];
        int pos = right;
        while (right >= left){
            int leftSqr = nums[left] * nums[left];
            int rightSqr = nums[right] * nums[right];
            if(leftSqr > rightSqr){
                res[pos] = leftSqr;
                left++;
            } else {
                res[pos] = rightSqr;
                right--;
            }
            pos--;
        }
        return res;
    }
    public boolean validPalindrome(String s) {
        int right = s.length() - 1;
        int left = 0;
        while (right > left) {
            if(s.charAt(left) != s.charAt(right)){
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (right >= left){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean backspaceCompare(String s, String t) {
        return checkString(s).equals(checkString(t));
    }

    private String checkString(String t) {
        StringBuilder str = new StringBuilder();
        for(char ch: t.toCharArray()){
            if(ch == '#'){
                if(str.length() > 0){
                    str.deleteCharAt(str.length() - 1);
                }
            }  else {
                str.append(ch);
            }
        }
        return str.toString();
    }

    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];
        while (right >= left){
            if(nums[left] % 2 != 0){
                res[right] = nums[left];

            } else  {
                res[left] = nums[left];
            }
            right--;
            left++;

            System.out.println(Arrays.toString(res));
            System.out.println(Arrays.toString(nums));
        }
        return res;
    }

    public static void main(String[] args) {
        Level2 level2 = new Level2();
        int[] height = new int[]{1,1};
        level2.maxArea(height);
        int[] people = {3,2,2,1};
        int[] nums = {-4,-1,0,3,10};
        String s = "abca";
        System.out.println(level2.numRescueBoats(people, 3));
        System.out.println(Arrays.toString(level2.sortedSquares(nums)));
        System.out.println(level2.validPalindrome(s));


        String s1 = "ab#c";
        String t1 = "ad#c";

        System.out.println(level2.backspaceCompare(s1, t1));

        int[] nums3 = {3,1,2,4};
        System.out.println(Arrays.toString(level2.sortArrayByParity(nums3)));

    }
}
