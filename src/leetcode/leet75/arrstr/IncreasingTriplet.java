package leetcode.leet75.arrstr;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right)/2;
            if(nums[right] > nums[mid]){
                if(nums[mid] > nums[left]){
                    return true;
                } else {
                    left++;
                    right--;
                }

            } else {
                left++;
                right--;
            }
        }
        return false;
    }

    public boolean increasingTripletOpt(int[] nums) {
       int first = Integer.MAX_VALUE;
       int second = Integer.MAX_VALUE;
       for(int num: nums){
           if(num <= first){
               System.out.println(num + "first");
               first = num;
           } else if (num <= second) {
               System.out.println(num + "second");
               second = num;
           } else {
               return true;
           }
       }
       return false;
    }


    public static void main(String[] args) {
        IncreasingTriplet triplet = new IncreasingTriplet();
        int[] nums = {2,1,5,0,4,6};
        System.out.println(triplet.increasingTripletOpt(nums));
    }
}
