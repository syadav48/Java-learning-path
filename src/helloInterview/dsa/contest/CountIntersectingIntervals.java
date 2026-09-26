package helloInterview.dsa.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountIntersectingIntervals {
    public int countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int end = intervals.length;
        long count = 0;
        for (int i = 0; i < end; i++) {
            for (int j = i+1; j < end; j++) {
                if(intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][0]){
                    count++;
                }
            }
        }
        return Math.toIntExact(count);
    }
    public int countIntersectingIntervalsOpt(int[][] intervals) {
        List<int[]> events = new ArrayList<>();
        for(int[] interval: intervals){
            events.add(new int[]{interval[0], 1});
            events.add(new int[]{interval[1], -1});
        }
        for(int[] event: events){
            System.out.println(Arrays.toString(event));
        }
        System.out.println(events);
        events.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int[] event: events){
            System.out.println(Arrays.toString(event));
        }
        int active = 0, count = 0;
        for(int[] e: events){
            if(e[1] == 1){
                count += active;
                active++;
            } else {
                active--;
            }
            System.out.println(count + " active:" + active);
        }
        return count;
    }
    public static void main(String[] args) {
        CountIntersectingIntervals intersectingIntervals = new CountIntersectingIntervals();
        int[][] intervals = {{1,2},{2,3},{3,4}};
        System.out.println(intersectingIntervals.countIntersectingIntervalsOpt(intervals));
    }
}
