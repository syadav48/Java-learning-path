package helloInterview.dsa.problems.slidingWindow;

public class SubArrProdLessK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0;
        int product = 1;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k){
                product /= nums[left];
                left++;
            }
            System.out.println(count + " : count" + " : product" + product);
            count += right - left + 1;
        }
        return count;
    }
    public static void main(String[] args) {
        SubArrProdLessK prodLessK = new SubArrProdLessK();
        int[] nums = new int[]{10, 5, 2, 6};
        //10,5,2,6,[10,5],[5,2],[2,6],[5,2,6],[10,5,2]
        int k = 100;
        System.out.println(prodLessK.numSubarrayProductLessThanK(nums, k));
    }
}
