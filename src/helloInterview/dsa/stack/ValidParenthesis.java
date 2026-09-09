package helloInterview.dsa.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public Boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (char ch: s.toCharArray()){
            if(map.containsKey(ch)){ // {
                if(stack.isEmpty() || stack.peek() != map.get(ch)){
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        ValidParenthesis v = new ValidParenthesis();
        System.out.println(v.isValid(""));
    }
}
