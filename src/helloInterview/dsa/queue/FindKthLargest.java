package helloInterview.dsa.queue;

import java.util.*;

public class FindKthLargest {
    public List<Integer> findTopKElem(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = 0; i < k; i++){
            list.add(pq.peek());
            pq.poll();
        }
        return list;
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
    public int findKthSmallest(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
    public List<Integer> findTopKFreqElem(int[] nums, int k){
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if(pq.size() > k){
                pq.poll();
            }
        }
        for (int[] num: pq){
            list.add(num[0]);
        }
        return list;
    }
    public void findKClosestPoint(int[] nums){
//        PriorityQueue<int[]> pq =
//                new PriorityQueue<>(
//                        (a, b) -> Integer.compare(
//                                distance(b),
//                                distance(a)
//                        )
//                );

        // closest distance from origin ->

        // points = [
        // [1,3],
        // [-2,2],
        // [5,8],
        // [0,1]
        //] - Ans : [0,1]
//        This pattern appears in:
//
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int[] freqs = {1,1,1,2,2,3,3,3,3,3};
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(nums, 2));
        System.out.println(findKthLargest.findKthSmallest(nums, 4));
        System.out.println(findKthLargest.findTopKFreqElem(freqs, 2));
        System.out.println(findKthLargest.findTopKElem(nums, 3));
    }
}
