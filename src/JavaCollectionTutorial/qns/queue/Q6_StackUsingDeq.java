package JavaCollectionTutorial.qns.queue;

import java.util.ArrayDeque;

public class Q6_StackUsingDeq {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        // push on the top
        arrayDeque.push(3);
        arrayDeque.push(6);
        arrayDeque.push(8);
        arrayDeque.push(5);
        System.out.println(arrayDeque);

        System.out.println(arrayDeque.peek());

        System.out.println(arrayDeque.pop());
    }
}
