package leetcode.string;

import java.util.Arrays;

public class RemoveOuterParenthesis {
    public String removeOuterParentheses(String s) {
        int depth = 0;
        StringBuilder builder = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(ch == '(' ){
                if(depth > 0){
                    builder.append(ch);
                }
                depth++;
            } else {
                depth--;
                if(depth > 0){
                    builder.append(ch);
                }
            }

        }
        return builder.toString();
    }

    public static void main(String[] args) {
        RemoveOuterParenthesis removeOuterParenthesis = new RemoveOuterParenthesis();
        String str = "(()())(())(()(()))"; //
        System.out.println(removeOuterParenthesis.removeOuterParentheses(str));
    }
}
