package helloInterview.dsa.stack.monotonic;

import java.util.*;

public class NextGreaterElem {
    public int[] nextGreaterTemp(int[] nums){
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty()
                    && nums[stack.peek()] < nums[i]) {

                result[stack.pop()] = nums[i];
            }

            stack.push(i);
            //2,1,2,4,3
            System.out.println(stack);
            System.out.println(Arrays.toString(result));
            System.out.println(Arrays.toString(nums));
        }
        return result;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> nextGreater = new HashMap<>();
        for(int num: nums2){
            while (!stack.isEmpty() && stack.peek() < num){
                int smaller = stack.pop();
                nextGreater.put(smaller, num);
            }
            stack.push(num);
        }
        System.out.println(stack);
        System.out.println(nextGreater);
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nextGreater.getOrDefault(nums1[i], -1);
        }
        return res;
    }
    public static void main(String[] args) {
        NextGreaterElem nextGreaterElem = new NextGreaterElem();
        int[] nums1 = {4,1,2}; // -1, 3, -1
        int[] nums2 = {1,3,4,2};
        int[] nums3 = {2,1,2,4,3};
        //System.out.println(Arrays.toString(nextGreaterElem.nextGreaterTemp(nums3)));
        System.out.println(Arrays.toString(nextGreaterElem.nextGreaterElement(nums1, nums2)));
    }
}
