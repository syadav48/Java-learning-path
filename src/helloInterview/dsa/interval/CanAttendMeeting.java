package helloInterview.dsa.interval;

import java.util.Arrays;

public class CanAttendMeeting {
    public Boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0){
            return true;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals[0].length; i++) {
            if(intervals[i][0] < intervals[i - 1][1]){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        CanAttendMeeting canAttendMeeting = new CanAttendMeeting();
        int[][] intervals = {{1,5}, {3,9}, {6, 8}};
        System.out.println(canAttendMeeting.canAttendMeetings(intervals));
    }
}
