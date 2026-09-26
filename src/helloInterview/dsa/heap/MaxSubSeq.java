package helloInterview.dsa.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSubSeq {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < nums.length; i++) {
            if(heap.size() < k){
                heap.offer(new int[]{nums[i], i});
            } else if (heap.peek()[0] < nums[i]) {
                heap.poll();
                heap.offer(new int[]{nums[i], i});
            }
        }
        System.out.println(Arrays.toString(heap.stream().mapToInt(x -> x[0]).toArray()));
        return heap.stream().mapToInt(x -> x[0]).toArray();

    }
    public static void main(String[] args) {
        MaxSubSeq seq = new MaxSubSeq();
        int[] nums = {-1,-2,3,4};
        int k = 3;
        System.out.println(seq.maxSubsequence(nums, k));
    }
}
