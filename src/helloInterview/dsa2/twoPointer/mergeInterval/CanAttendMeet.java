package helloInterview.dsa2.twoPointer.mergeInterval;

import helloInterview.dsa.linkList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanAttendMeet {
    public int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i-1][1] > intervals[i][0]){
                int[] curr = new int[2];
                curr[0] = intervals[i-1][0];
                curr[1] = intervals[i][1];
                list.add(curr);
            } else {
                list.add(intervals[i]);
            }
        }
        System.out.println(list);
        for (int[] num: list){
            System.out.println(Arrays.toString(num));
        }
        return list.toArray(new int[list.size()][]);

    }
    public int[][] mergeIntervalsOpt(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if(current[1] >= intervals[i][0]){
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                list.add(current);
                current = intervals[i];
            }
        }
        list.add(current);
        return list.toArray(new int[list.size()][]);

    }
    public static void main(String[] args) {
        int[][] inervals = {{1,3}, {2,6},{8,10},{15,18}};
        int[][] inervals1 = {{1,4},{4,5}};
        int[][] inervals2 = {{4,7}, {1,4}};
        CanAttendMeet canAttendMeet = new CanAttendMeet();
        canAttendMeet.mergeIntervalsOpt(inervals);
        canAttendMeet.mergeIntervalsOpt(inervals1);
        canAttendMeet.mergeIntervalsOpt(inervals2);
    }
}
