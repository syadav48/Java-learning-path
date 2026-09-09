package helloInterview.dsa.heap;

import java.util.PriorityQueue;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0){
            return -1;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num: nums){
            if(heap.size() < k){
                heap.offer(num);
            } else if (num > heap.peek()) {
                heap.poll();
                heap.offer(num);
            }
        }
        return heap.peek();

    }
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();
        int[] nums = {5, 3, 2, 1, 4};
        System.out.println(kthLargest.findKthLargest(nums, 2));
    }
}
