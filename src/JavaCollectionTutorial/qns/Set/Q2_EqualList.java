package JavaCollectionTutorial.qns.Set;

import java.util.*;

public class Q2_EqualList {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,4,6,7,8,6,9,0,-1,1,1,1,2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(-1,1,1,1,2,1,2,3,4,4,6,7,8,6,9,0));
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        System.out.println(set1 + "   " + set2);
        System.out.println(set1.equals(set2));

    }
}
