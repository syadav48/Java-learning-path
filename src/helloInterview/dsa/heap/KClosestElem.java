package helloInterview.dsa.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElem {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for(int num: arr){
            int distance = Math.abs(num - x);
            if(heap.size() < k){
                heap.offer(new int[]{-distance, num});
            } else if (distance < -heap.peek()[0]) {
                heap.poll();
                heap.offer(new int[]{-distance, num});
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int[] pair: heap){
            list.add(pair[1]);
        }
        Collections.sort(list);
        return list;
    }
    public static void main(String[] args) {
        KClosestElem kClosestElem = new KClosestElem();
        int[] nums = {1,1,2,3,4,5};
        System.out.println(kClosestElem.findClosestElements(nums, 4, 3));
    }

}
