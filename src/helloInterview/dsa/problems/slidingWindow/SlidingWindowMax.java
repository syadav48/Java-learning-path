package helloInterview.dsa.problems.slidingWindow;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
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
        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(slidingWindowMax.maxSlidingWindow(nums, k)));
    }
}
