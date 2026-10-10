package helloInterview.dsa.queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        int maxFreq = 1;
        int maxFreqCount = 1;

        for(char task: tasks){
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry: freq.entrySet()){
            pq.offer(entry);
        }
        while (!pq.isEmpty()){
          maxFreq = pq.poll().getValue();
          if(pq.peek().getValue() == maxFreq){
              pq.poll();
              maxFreqCount++;
          }
        }

        return Math.max(((maxFreq -1)*n+1)+maxFreqCount, tasks.length);
    }
    public int leastIntervalOpt(char[] tasks, int n) {
       int[] freq = new int[26];
       for(char task: tasks){
           freq[task - 'A']++;
       }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int maxCount = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == maxFreq) {
                maxCount++;
            } else {
                break;
            }
        }
        int partCount = maxFreq - 1;
        int partLength = n + 1;
        int emptySlots = partCount * partLength + maxCount;
        return Math.max(emptySlots, tasks.length);
    }
    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        char[] tasks1 = {'A', 'C', 'A','B', 'D', 'B'};
        System.out.println(taskScheduler.leastInterval(tasks, 2));
        System.out.println(taskScheduler.leastInterval(tasks1, 1));
    }
}
