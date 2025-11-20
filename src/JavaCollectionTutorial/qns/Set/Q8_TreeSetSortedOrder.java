package JavaCollectionTutorial.qns.Set;

import java.util.Set;
import java.util.TreeSet;

public class Q8_TreeSetSortedOrder {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        set.add("Apple");
        set.add("banana");
        set.add("Cherry");
        set.add("apple");  // duplicate in case-insensitive terms
        set.add("Banana");
        System.out.println(set);

    }
}
