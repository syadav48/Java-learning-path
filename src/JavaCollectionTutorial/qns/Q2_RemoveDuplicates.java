package JavaCollectionTutorial.qns;

import java.util.*;

public class Q2_RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(i);
        }
        list.add(5);
        list.add(5);
        System.out.println(list);
        List<Integer> list1 = list.stream().distinct().toList();
        Set<Integer> set = new HashSet<>(list);
        System.out.println(list1);
        System.out.println(set.stream().toList());

        // without using set or stream
        List<Integer> list2 = new ArrayList<>();
        for (Integer integer : list) {
            if (!list2.contains(integer)) {
                list2.add(integer);
            }
        }

        // fastest and recommended: O(n): done
        boolean[] seen = new boolean[100];

        List<Integer> unique = new ArrayList<>();
        for(Integer integer: list){
            if(!seen[integer]){
                seen[integer] = true;
                unique.add(integer);
            }
        }
        System.out.println(Arrays.toString(seen));
        System.out.println(unique);


    }
}
