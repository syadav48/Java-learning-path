package helloInterview.dsa.problems.arrString;

import java.util.Arrays;

public class ConcOfArray {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*(nums.length)];
        for (int i = 0; i < ans.length; i++) {
            if(i < nums.length){
                ans[i] = nums[i];
            } else {
                ans[i] = nums[i - nums.length];
            }
        }
        return ans;
    }
    public int[] getConcatenationOpt(int[] nums) {

        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }

        return ans;
    }
    public static void main(String[] args) {
        ConcOfArray conc = new ConcOfArray();
        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(conc.getConcatenation(nums)));
    }
}
