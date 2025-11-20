package JavaCollectionTutorial.qns.Set;

import java.util.HashSet;
import java.util.Set;

public class Q9_MultipleNull {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Set.of(1,2,3,4,5,6,7,8));
        set.add(null);
        set.add(null);
        set.add(null);
        System.out.println(set);
        //Hashset -> allow one null, linkedhashSet allow one but TreeSet doesn't throws null pointer exception
        //as it compares value for sorting
    }
}
