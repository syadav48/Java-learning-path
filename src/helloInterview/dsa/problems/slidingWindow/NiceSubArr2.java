package helloInterview.dsa.problems.slidingWindow;

public class NiceSubArr2 {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0;
        int oddCount = 0;
        int result = 0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right] % 2 == 1){
                oddCount++;
            }
            while (oddCount > k){
                if(nums[left] % 2 == 1){
                    oddCount--;
                }
                left++;
            }
            result += right - left + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        NiceSubArr2 niceSubArr2 = new NiceSubArr2();
        int[] nums = new int[]{2,4,6};
        int k = 1;
        System.out.println(niceSubArr2.numberOfSubarrays(nums, k));
    }
}
