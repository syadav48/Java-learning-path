package helloInterview.dsa.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class PQ {
    public static void main(String[] args) {
        // min heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int[] arr = {3, 1, 4, 1, 5, 9, 2};
        for(int num: arr){
            heap.offer(num);
        }
        // push 0 to the heap. O(log n)
        heap.offer(0);

        System.out.println(heap);
        // peek the min element = 0. O(1)
        System.out.println(heap.peek());
        // pop and return the min element = 0. O(log n)
        System.out.println(heap.poll());




        //max heap:

        PriorityQueue<Integer> heap1 = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr1 = {3, 1, 4, 1, 5, 9, 2};
        for(int num: arr1){
            heap1.offer(num);
        }
        // push 0 to the heap. O(log n)
        heap1.offer(0);

        System.out.println(heap1);
        // peek the min element = 0. O(1)
        System.out.println(heap1.peek());
        // pop and return the min element = 0. O(log n)
        System.out.println(heap1.poll());
    }
}
