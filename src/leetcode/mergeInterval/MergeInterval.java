package leetcode.mergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= current[1]){
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);
        return  result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        int[][] arr = {{1,4}, {4,5}};
        MergeInterval mergeInterval = new MergeInterval();
        System.out.println(Arrays.deepToString(mergeInterval.merge(arr)));
    }
}
