package collections;

import java.util.LinkedList;

public class LearnLinkList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Hathi");
        list.add("Ghoda");
        list.add("Unt");
        list.add("Bagh");
        list.addFirst("Deer");
        list.addLast("Hiran");
        list.offer("Ox");
        System.out.println(list.get(3));
        System.out.println(list.poll());
        System.out.println(list.peek());
        System.out.println(list);
    }
}
