package helloInterview.dsa.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomII {
    public int meetingRooms(int[][] schedules){
        Arrays.sort(schedules, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] schedule: schedules){
            if(!pq.isEmpty() && schedule[0] >= pq.peek()){
                pq.poll();
            }
            pq.offer(schedule[1]);
        }
        return pq.size();
    }
    public static void main(String[] args) {
        MeetingRoomII meetingRoomII = new MeetingRoomII();
        int[][] schedules = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(meetingRoomII.meetingRooms(schedules));
    }
}
