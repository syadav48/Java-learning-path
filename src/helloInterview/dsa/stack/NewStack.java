package helloInterview.dsa.stack;

import java.util.Stack;

public class NewStack {

    public static void main(String[] args) {
        Stack<Integer> stacks = new Stack<>();
        int[] nums = {1,2,3,4,5};
        for (int num: nums){
            stacks.push(num);
        }
        System.out.println(stacks);
        System.out.println(stacks.pop());
        System.out.println(stacks.peek());

    }
}
