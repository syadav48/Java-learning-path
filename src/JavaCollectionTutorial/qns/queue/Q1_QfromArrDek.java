package JavaCollectionTutorial.qns.queue;

import java.util.ArrayDeque;

public class Q1_QfromArrDek {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        //enqueue
        arrayDeque.offer(10);
        arrayDeque.offer(20);
        arrayDeque.offer(30);
        arrayDeque.offer(40);

        System.out.println(arrayDeque);

        //Dequeue
        arrayDeque.poll();
        arrayDeque.poll();

        //10
        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque.peek());

        // both side insertion and deletion
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(5);
        deque.offerFirst(7);
        deque.offerLast(9);
        deque.offer(4);
        deque.offer(8);
        deque.offerLast(3);
        deque.offerFirst(2);
        System.out.println(deque);
        System.out.println(deque.peekFirst());


    }
}
