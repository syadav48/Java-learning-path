package leetcode.mergeInterval;


import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;

public class TimeConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        LocalTime start1 = LocalTime.parse(event1[0]);
        LocalTime end1 = LocalTime.parse(event1[1]);

        LocalTime start2 = LocalTime.parse(event2[0]);
        LocalTime end2 = LocalTime.parse(event2[1]);

        return !start1.isAfter(end2) && !start2.isAfter(end1);
    };
    public static void main(String[] args) {
        TimeConflict timeConflict = new TimeConflict();
        String[] event1 = {"01:00","02:00"};
        String[] event2 = {"01:20","03:00"};
        System.out.println(timeConflict.haveConflict(event1, event2));
    }
}
