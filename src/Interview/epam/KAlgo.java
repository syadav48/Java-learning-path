package Interview.epam;

public class KAlgo {
    public static int maxSubArray(int[] nums) {
        int max = nums[0], curr = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(max, curr);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(KAlgo.maxSubArray(arr));
    }
}
