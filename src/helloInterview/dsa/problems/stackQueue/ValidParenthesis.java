package helloInterview.dsa.problems.stackQueue;

import Interview.javaCore.interfaceExample.C;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (char ch: s.toCharArray()){
            if(map.containsKey(ch)){
                if(stack.isEmpty() || stack.peek() != map.get(ch)){
                    return false;
                }
                stack.pop();
            }  else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    public boolean isValidOpt(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch: s.toCharArray()){
            if(ch == '('){
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else {
                if(stack.isEmpty() || stack.pop() != ch){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        String str = "()[]{}";
        System.out.println(validParenthesis.isValidOpt(str));
    }
}
