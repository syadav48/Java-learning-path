package helloInterview.dsa.backTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadWatch {
   private int[] hours = {1,2,4,8};
   private int[] minutes = {1,2,4,8,16,32};
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        backTrackWatch(result, turnedOn, 0,0,0,0);
        return result;
    }

    private void backTrackWatch(List<String> result, int turnedOn, int count, int start, int hour, int minute) {
        if(count == turnedOn){
            if(hour < 12 && minute < 60){
                System.out.println("hour  " +  hour + "  min  "  + minute);
                result.add(String.format("%d:%02d", hour, minute));
            }
        }

        for (int i = start; i < hours.length + minutes.length; i++) {
            if(i < hours.length){
                backTrackWatch(result, turnedOn, count + 1, i + 1, hour + hours[i], minute);
            } else {
                int j = i - hours.length;
                backTrackWatch(result, turnedOn, count + 1, i + 1, hour, minute + minutes[j]);
            }
        }

    }

    public static void main(String[] args) {
        ReadWatch readWatch = new ReadWatch();
        int turnedOn = 2;
        System.out.println(readWatch.readBinaryWatch(turnedOn));
    }
}
