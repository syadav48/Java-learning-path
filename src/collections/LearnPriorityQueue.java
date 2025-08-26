package collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Task {
    String name;
    int priority;
    Task(String name, int priority){
        this.name = name;
        this.priority = priority;
    }
    public String toString(){
        return name + "(priority " + priority + ")";
    }
}
public class LearnPriorityQueue {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int[] nums = {5, 2, 9, 1, 7, 6};
        int k = 3;
        Queue<Integer> minHeap = new PriorityQueue<>(k);
        Queue<Integer> pque = new PriorityQueue<>(2 );
        Queue<Task> prq = new PriorityQueue<>((a, b) -> b.priority - a.priority);

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        pq.offer(12);
        pq.offer(22);
        pq.offer(24);
        pq.offer(56);
        prq.offer(new Task("Write report", 2));
        prq.offer(new Task("Fix Bugs", 5));
        prq.offer(new Task("Check Mail", 1));
        prq.offer(new Task("Deploy Code", 4));
        System.out.println("Top " + k + " largest: " + minHeap);
        System.out.println(pq);
        System.out.println(prq);
        System.out.println(pq.poll());
        System.out.println(pq.peek());
    }
}
