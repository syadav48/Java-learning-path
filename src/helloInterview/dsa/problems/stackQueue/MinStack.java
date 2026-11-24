package helloInterview.dsa.problems.stackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }

    public void push(int value) {
        stack.push(value);
        if(minStack.isEmpty() || value <= minStack.peek()){
            minStack.push(value);
        }
    }

    public void pop() {
        int removed = stack.pop();
        if(removed == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty()){
            return -1;
        }
       return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println( minStack.top());
        System.out.println(minStack.getMin());

    }
}
