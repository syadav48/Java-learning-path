package JavaCollectionTutorial.qns.Set;

import java.util.*;

public class Q5_SetToList {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>(Set.of(1,2,3,4,56,6,17,0,-9,-1));
        System.out.println(set);
        List<Integer> list = set.stream().sorted().toList();
        List<Integer> list1 = new ArrayList<>(set);
        Collections.sort(list1);
        System.out.println(list);
        System.out.println(list1);
    }
}
