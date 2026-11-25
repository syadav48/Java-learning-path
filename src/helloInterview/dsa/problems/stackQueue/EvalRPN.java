package helloInterview.dsa.problems.stackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token: tokens){
            switch (token){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int b1 = stack.pop();
                    int a1 = stack.pop();
                    stack.push(a1 - b1);
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    int b2 = stack.pop();
                    int a2 = stack.pop();
                    stack.push(a2/b2);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN.evalRPN(tokens));
    }
}
