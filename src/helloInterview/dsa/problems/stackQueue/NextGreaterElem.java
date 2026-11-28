package helloInterview.dsa.problems.stackQueue;

import java.util.*;

public class NextGreaterElem {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nge = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int num: nums2){
            while (!stack.isEmpty() && stack.peek() < num){
                nge.put(stack.pop(), num);
            }
            stack.push(num);
        }
        while (!stack.isEmpty()){
            nge.put(stack.pop(), -1);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nge.get(nums1[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        NextGreaterElem nextGreaterElem = new NextGreaterElem();
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        // [3,4,0,0]
        System.out.println(Arrays.toString(nextGreaterElem.nextGreaterElement(nums1, nums2)));
    }
}
