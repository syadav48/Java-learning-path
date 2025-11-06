package leetcode.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> queue = new LinkedList<>();

    public RecentCounter() {

    }

    ;

    public int ping(int t) {
        queue.offer(t);
        List<Integer> list = new ArrayList<>();
        int count = 0;
        list.add(t - 3000);
        list.add(t);
        for (int num : queue) {
            if (num >= list.get(0) && num <= list.get(1)) {
                count++;
            }
        }
        return count;
    }

    ;

    public static class RecentCounter2 {
        Queue<Integer> queue;

        public RecentCounter2() {
            queue = new LinkedList<>();
        };

        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        };

        public static void main(String[] args) {
            RecentCounter2 recentCounter = new RecentCounter2();
            System.out.println(recentCounter.ping(1));
            recentCounter.ping(100);
            recentCounter.ping(3001);
            recentCounter.ping(3002);
        }
    }
}
