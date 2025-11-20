package JavaCollectionTutorial.qns.Set;

import java.util.*;

public class Q1_RemoveDuplicates {
    public static void main(String[] args) {
        //1
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,4,6,7,8,6,9,0,-1,1,1,1,2));
        HashSet<Integer> set1 = new HashSet<>(list);

        //2
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>(list);
        System.out.println(set1 + " " + set2);
    }
}
