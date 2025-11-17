package leetcode.arrays;

import java.util.*;

public class MinCost {
    public int minimumCost(int[] cost) {
        int[] arr = Arrays.stream(cost)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(x -> x)
                .toArray();
        if(cost.length <= 2){
           return Arrays.stream(cost).sum();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if((i + 1) % 3 != 0){
                list.add(arr[i]);
            }
        }
        System.out.println(list);
        return list.stream().reduce(0, Integer::sum);
    }
    public static void main(String[] args) {
        int[] cost = {5,5};
        MinCost minCost = new MinCost();
        System.out.println(minCost.minimumCost(cost));
    }
}
