package helloInterview.dsa.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSubSeq {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            if(queue.size() < k){
                queue.offer(num);
                max = Math.max(max, queue.peek());
            } else if (num > max) {
                queue.poll();
                queue.offer(num);
            }
        }
        return queue.stream().mapToInt(x -> x).toArray();
    }
    public static void main(String[] args) {
        MaxSubSeq seq = new MaxSubSeq();
        int[] nums = {3,4,3,3};
        int k = 2;
        System.out.println(Arrays.toString(seq.maxSubsequence(nums, k)));
    }
}
