package collections.practice;

import java.util.TreeSet;

public class TreeCreate {
    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(24);
        tree.add(5);
        tree.add(11);
        System.out.println(tree);
    }
}
