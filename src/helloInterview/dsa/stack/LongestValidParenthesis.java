package helloInterview.dsa.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestValidParenthesis {
    public Integer longest_valid_parentheses(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for(char ch: s.toCharArray()){
            if(map.containsKey(ch)){
                if(stack.isEmpty() || stack.peek() != map.get(ch)){
                    continue;
                }
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        System.out.println(stack);
        return n - stack.size();
    }
    public Integer longest_valid_parenthesesOpt(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
   public static void main(String[] args) {
        LongestValidParenthesis validParenthesis = new LongestValidParenthesis();
       System.out.println(validParenthesis.longest_valid_parenthesesOpt("((()()())"));
       System.out.println(validParenthesis.longest_valid_parenthesesOpt(")()())"));
       System.out.println(validParenthesis.longest_valid_parenthesesOpt("(()"));
    }
}
