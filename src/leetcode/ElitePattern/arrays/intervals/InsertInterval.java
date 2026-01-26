package leetcode.ElitePattern.arrays.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> inputs = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0]){
                inputs.add(intervals[i]);
                inputs.add(newInterval);
            } else {
                inputs.add(intervals[i]);
            }

        }
        List<int[]> result = new ArrayList<>();
        int[] current = inputs.get(0);
        for (int i = 1; i < inputs.size(); i++) {
            if(inputs.get(i)[0] <= current[1]){
                current[1] = Math.max(current[1], inputs.get(i)[1]);
            } else {
                result.add(current);
                current = inputs.get(i);
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }

    public int[][] optimizedInsert(int[][] intervals, int[] newInterval){
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        //Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while (i < n){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals = {{1,2}, {3,5}, {6,7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        System.out.println(Arrays.deepToString(insertInterval.optimizedInsert(intervals, newInterval)));
    }
}
