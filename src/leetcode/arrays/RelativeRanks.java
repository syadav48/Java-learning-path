package leetcode.arrays;

import java.util.*;

public class RelativeRanks {
    public static String[] findRelativeRanks(int[] score) {
        Map<Integer, String> map = new HashMap<>();
        List<Integer> list = Arrays.stream(score).boxed().sorted(Comparator.reverseOrder()).toList();
        List<String> strs = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            if(i == 0){
                map.put(list.get(i), "Gold Medal");
            } else if(i == 1){
                map.put(list.get(i), "Silver Medal");
            } else if(i == 2){
                map.put(list.get(i), "Bronze Medal");
            } else {
                map.put(list.get(i), String.valueOf(i+1));
            }
        }
        System.out.println(map);
        for(int i = 0; i < score.length; i++){
            strs.add(map.get(score[i]));
        }
        return strs.stream().toArray(String[]::new);
    }
    public static void main(String[] args) {
            int [] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(findRelativeRanks(arr)));
    }
}
