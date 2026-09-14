package helloInterview.dsa2.twoPointer.stack;

import java.util.Stack;

public class RemoveStar {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*'){
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        for (char ch: stack){
            stringBuilder.append(ch);
        }
        System.out.println(stack);
        return stringBuilder.toString();

    }
    public static void main(String[] args) {
        RemoveStar star = new RemoveStar();
        System.out.println(star.removeStars("leet**cod*e"));
        System.out.println(star.removeStars("erase*****"));
    }
}
