package JavaCollectionTutorial.qns.Set;

import java.util.HashSet;
import java.util.Set;

public class Q4_ElemDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<Integer>(Set.of(1,2,3,4,5,6));
        Set<Integer> set2 = new HashSet<Integer>(Set.of(4,5,6,7,8,9));
        Set<Integer> set = new HashSet<>(set1);
        set.removeAll(set2);
        System.out.println(set);

    }


}
