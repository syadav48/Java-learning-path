package collections;

import java.util.*;

public class LearnSet {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new TreeSet<>();
        Set<Integer> set3 = new LinkedHashSet<>();
        set1.add(1);
        set1.add(21);
        set1.add(21);
        set1.add(112);
        set1.add(131);
        set2.add(22);
        set2.add(23);
        set2.add(26);
        set2.add(12);
        set2.add(12);
        set3.add(15);
        set3.add(16);
        set3.add(12);
        set3.add(12);
        set3.add(22);
        set3.add(25);

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
    }

    public static class LearnIntStream {
    }
}
