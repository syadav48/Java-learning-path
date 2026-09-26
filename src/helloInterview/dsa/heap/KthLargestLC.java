package helloInterview.dsa.heap;

import java.util.PriorityQueue;

public class KthLargestLC {
    private PriorityQueue<Integer> queue;
    private int k;
    public KthLargestLC(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for(int num: nums){
           add(num);
        }
    }
    public int add(int val) {
        queue.offer(val);
        if(queue.size() > k){
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargestLC kthLargestLC = new KthLargestLC(k, nums);
        System.out.println(kthLargestLC.add(3)); // 0, -1
        System.out.println(kthLargestLC.add(5));
        System.out.println(kthLargestLC.add(10));
        System.out.println(kthLargestLC.add(9));
        System.out.println(kthLargestLC.add(4));
    }
}
