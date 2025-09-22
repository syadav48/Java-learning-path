package leetcode.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestTriangleArea {
    public  static double largestTriangleArea(int[][] points) {
        List<Integer> list1 = Arrays.stream(points).toList().stream().map(x -> x[0]).sorted(Comparator.naturalOrder()).distinct().toList();
        List<Integer> list2 = Arrays.stream(points).toList().stream().map(x -> x[1]).sorted(Comparator.naturalOrder()).distinct().toList();
        Integer base = list1.getLast() - list1.getFirst();
        Integer height = list2.getLast() - list2.getFirst();
        double area = .5 * base * height;
        return Math.abs(area);

    }
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0},
                {0, 1},
                {1, 0},
                {0, 2},
                {2, 0}
        };
        System.out.println(largestTriangleArea(arr));

    }
}
