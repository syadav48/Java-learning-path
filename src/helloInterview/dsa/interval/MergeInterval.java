package helloInterview.dsa.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = new int[2];
            if(intervals[i-1][1] >= intervals[i][0]){
                interval[0] = intervals[i-1][0];
                interval[1] = intervals[i][1];
                list.add(interval);
            } else {
                list.add(intervals[i]);
            }
        }
        System.out.println(list);
        for (int[] interval : list) {
            System.out.println(Arrays.toString(interval));
        }
        return list.toArray(new int[list.size()][]);
    }
    public int[][] mergeOpt(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] interval: intervals) {
            if(list.isEmpty() || interval[0] > list.get(list.size() - 1)[1]){
                list.add(interval);
            } else {
                list.get(list.size() - 1)[1] = Math.max(interval[1], list.get(list.size() - 1)[1]);
            }
            
        }
        for (int[] interval : list) {
            System.out.println(Arrays.toString(interval));
        }
        return list.toArray(new int[list.size()][]);
    }
    public static void main(String[] args) {
        MergeInterval mergeInterval = new MergeInterval();
        int[][] ints = {{1,3}, {2,6}, {8, 10}, {15, 18}};
        mergeInterval.mergeOpt(ints);
    }

}
