package helloInterview.dsa2.twoPointer.Heap;

import java.util.PriorityQueue;

public class KthLargest {
    public int kthLargest(int[] nums, int k){
        if(nums.length == 0){
            return -1;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num: nums){
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
        System.out.println(kthLargest.kthLargest(nums, 2));
    }
}
