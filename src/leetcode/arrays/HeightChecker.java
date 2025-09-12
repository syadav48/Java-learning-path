package leetcode.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int count = 0;
        List<Integer> rightOrder = Arrays.stream(heights).boxed().sorted(Comparator.naturalOrder()).toList();
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != rightOrder.get(i)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] heights = {5,1,2,3,4};
        System.out.println(heightChecker(heights));
    }
}
