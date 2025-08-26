package collections;

import java.util.ArrayDeque;

public class LearnArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> adk = new ArrayDeque<>();
        adk.offer(12);
        adk.offer(23);
        adk.offer(14);
        adk.offer(65);
        adk.offerFirst(9);
        adk.offerLast(109);
        System.out.println(adk);
        adk.poll();
        adk.peek();
        System.out.println(adk.peekFirst());
        System.out.println(adk.pollFirst());
        System.out.println(adk.peekLast());
        System.out.println(adk.pollLast());
        System.out.println(adk);

    }
}
