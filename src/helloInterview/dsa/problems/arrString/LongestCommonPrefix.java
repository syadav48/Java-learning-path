package helloInterview.dsa.problems.arrString;

import java.util.Stack;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                //1. checking every string, if any one is shorter than the first return immediately
                //2. check if not equal with ch, return immediately
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){
                    return first.substring(0, i);
                }
            }
        }
        // this return is specifically for first one is the shortest string
        return first;
    }
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix1 = new LongestCommonPrefix();
        String[] strings = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix1.longestCommonPrefix(strings));
    }
}
