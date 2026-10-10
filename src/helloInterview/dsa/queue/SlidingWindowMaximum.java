package helloInterview.dsa.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int[] res = new int[nums.length + 1 - k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int end = 0; end < nums.length; end++){
            pq.offer(nums[end]);
            if(end - start + 1 == k && !pq.isEmpty()){
                res[start] = pq.peek();
                start++;
                pq.poll();
            }
        }
        return res;
    }

    public int[] maxSlidingWindowOpt(int[] nums, int k) {
        int[] res = new int[nums.length + 1 - k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int end = 0; end < nums.length; end++){
            pq.offer(new int[]{nums[end], end});
            while (pq.peek()[1] <= end - k){
                pq.poll();
            }
            if(end >= k - 1){
                res[end - k + 1] = pq.peek()[0];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums1 = {1};
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindowOpt(nums, 3)));
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindowOpt(nums1, 1)));
    }
}
