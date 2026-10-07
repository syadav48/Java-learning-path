package helloInterview.dsa.stack;

import java.util.Comparator;
import java.util.Stack;

public class RemoveDuplicateLetter {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(!stack.contains(ch)){
                stack.push(ch);
            }
        }

        stack.sort((Comparator.naturalOrder()));
        System.out.println(stack);
        for(char ch: stack){
            sb.append(ch);
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        RemoveDuplicateLetter rdl = new RemoveDuplicateLetter();
        String str = "cbacdcbc";
        System.out.println(rdl.removeDuplicateLetters(str));
    }
}
