package helloInterview.dsa2.twoPointer.Heap;

import Multithreading.LifeCycle;

import java.util.PriorityQueue;

public class KthLargestNum {
    public KthLargestNum(int k, int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            if(pq.size() < k){
                pq.add(num);
            }
        }
    }

    public int add(int val) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(val);
        return pq.peek();
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargestNum kthLargestNum = new KthLargestNum(3, nums);
        System.out.println(kthLargestNum.add(3));
        System.out.println(kthLargestNum.add(5));
        System.out.println(kthLargestNum.add(10));
        System.out.println(kthLargestNum.add(9));
        System.out.println(kthLargestNum.add(4));
    }
}
