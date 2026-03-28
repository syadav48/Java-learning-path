package leetcode.leet75.arrstr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = Arrays.stream(candies).max().orElseThrow();
        for (int i = 0; i < candies.length; i++) {
            int num = candies[i] + extraCandies;
            if(num >= max){
                list.add(true);
            } else {
                list.add(false);
            }

        }
        return list;
    }
    public static void main(String[] args) {
        GreatestCandies gt = new GreatestCandies();
        int[] candies = {12,1,12};
        int extraCandies = 10;
        System.out.println(gt.kidsWithCandies(candies, extraCandies));
    }
}
