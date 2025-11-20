package JavaCollectionTutorial.qns.Set;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Q3_CommonElements {
    public static void main(String[] args) {
        //1
        Set<Integer> set1 = new HashSet<Integer>(Set.of(1,2,3,4,5,6));
        Set<Integer> set2 = new HashSet<Integer>(Set.of(7,3,4,5,8,9));
        Integer first = set1.stream().distinct().findFirst().orElseThrow();
        Set<Integer> collect = set1.stream().filter(set2::contains).collect(Collectors.toSet());
        System.out.println(collect + " " + first);

        // most effecinet:
        Set<Integer> set = new HashSet<>(set1);
        set.retainAll(set2);
        System.out.println(set);


    }
}
