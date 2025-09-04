package collections.practice;

import java.util.LinkedList;

public class LinkListCreate {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(2);
        list.offer(4);
        list.offer(1);
        list.offer(7);
        list.offer(9);
        list.offer(6);
        list.addFirst(5);
        list.addLast(7);
        list.addLast(9);
        System.out.println(list);
    }
}
