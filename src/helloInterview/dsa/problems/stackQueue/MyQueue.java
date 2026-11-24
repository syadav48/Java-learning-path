package helloInterview.dsa.problems.stackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;
    public MyQueue() {
        this.inStack = new ArrayDeque<>();
        this.outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }
    public void shiftStacks(){
        if(outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }
    public int pop() {
        shiftStacks();
        return outStack.pop();
    }

    public int peek() {
        shiftStacks();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(
                "peek" +
        myQueue.peek() + " pop " +
        myQueue.pop() +   " empty " +
        myQueue.empty()
        );

    }
}
