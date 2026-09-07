package helloInterview.dsa.interval;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        //phase-1
        while (i < n && intervals[i][1] < newInterval[0]){
            merged.add(intervals[i]);
        }
        // phase - 2
        while (i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        merged.add(newInterval);
        // phase - 3
        for (int j = i; j < n; j++) {
            merged.add(intervals[j]);
        }
        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[] args) {
        InsertIntervals intervals = new InsertIntervals();
        int[][] interval = {{1,3}, {6, 9}};
        int[] newIntervals = {2, 5};
        intervals.insert(interval, newIntervals);
    }

}
