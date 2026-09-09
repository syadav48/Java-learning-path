package helloInterview.dsa.stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        String currString = "";
        Integer currNumber = 0;
        for (char ch: s.toCharArray()){
            if(ch == '['){
                stringStack.push(currString);
                integerStack.push(currNumber);
                currString = "";
                currNumber = 0;
            } else if (ch == ']') {
                int num = integerStack.pop();
                String prevString = stringStack.pop();
                currString = prevString + currString.repeat(num);
            } else if (Character.isDigit(ch)) {
                currNumber = currNumber*10 + (ch - '0');
            } else {
                currString += ch;
            }
        }
        return currString;
    }
    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a]2[bc]"));
        System.out.println(decodeString.decodeString("3[a2[c]]"));
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
    }
}
