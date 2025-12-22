package leetcode.math;

import java.util.*;
import java.util.stream.Collectors;

public class RecoverOrder {
    public int[] recoverOrder(int[] order, int[] friends) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < order.length; i++) {
            for(int friend: friends){
                if(friend == order[i]){
                    list.add(order[i]);
                    System.out.println(order[i]);
                }
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
    public int[] optimumRecoverOrder(int[] order, int[] friends) {
        Set<Integer> collect = Arrays.stream(friends).boxed().collect(Collectors.toSet());
        return Arrays.stream(order)
                .filter(collect::contains)
                .toArray();
    }
    public static void main(String[] args) {
        RecoverOrder recoverOrder = new RecoverOrder();
        int[] order = {3,1,2,5,4};
        int[] friends = {1,3,4};
        System.out.println(Arrays.toString(recoverOrder.optimumRecoverOrder(order, friends)));
    }
}
