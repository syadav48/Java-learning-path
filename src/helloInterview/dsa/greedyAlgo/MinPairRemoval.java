package helloInterview.dsa.greedyAlgo;

import java.util.Arrays;
import java.util.Stack;

public class MinPairRemoval {
    private int count = 0;
    public int minimumPairRemoval(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]){
                nums[i+1] = nums[i+1] + nums[i+2];
                nums[i+2] = nums[i+3];
                count += minimumPairRemoval(nums);
            }
            System.out.println(Arrays.toString(nums));
        }
        return count;
    }
    public int minimumPairRemovalOpt(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int operation = 0;
        for(int num: nums){
            stack.push(num);

            while (stack.size() >= 2){
                int top = stack.pop();
                int prev = stack.peek();
                System.out.println(top + "top" + prev + "prev");
                if(prev > top){
                    stack.pop();
                    stack.push(top + prev);
                    operation++;
                } else {
                    stack.push(top);
                    break;
                }
            }
        }

        return operation;

    }
    public static void main(String[] args) {
        MinPairRemoval removal = new MinPairRemoval();
        int[] nums = {5,2,3,1};
        System.out.println(removal.minimumPairRemovalOpt(nums));
    }
}
