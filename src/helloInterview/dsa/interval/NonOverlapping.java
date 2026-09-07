package helloInterview.dsa.interval;

import java.util.Arrays;

public class NonOverlapping {
    public int nonOverlappingIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1;
        int end = intervals[0][1];
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            if(intervals[i][0] >= end){
                end = intervals[i][1];
                count++;
            }
        }
        return n - count;
    }
    public static void main(String[] args) {
        int[][] intervals = {{7, 10}, {4, 6}, {11, 17}, {2, 18}};
        NonOverlapping nonOverlapping = new NonOverlapping();
        System.out.println(nonOverlapping.nonOverlappingIntervals(intervals));
    }
}
