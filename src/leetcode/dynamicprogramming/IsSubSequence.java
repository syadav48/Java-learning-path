package leetcode.dynamicprogramming;

public class IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            if(s.indexOf(t.charAt(i)) != -1){
                stringBuilder.append(t.charAt(i));
            }
        }
        return stringBuilder.length() >= s.length();
    }
    public boolean isSubsequence2(String s, String t) {
        int i = 0, j = 0;
       while (i < s.length() && j < t.length()){
           if(s.charAt(i) == t.charAt(j)){
               i++;
           }
           j++;
       }
       return i == s.length();
    }
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
//        String s = "ab";
//        String t = "baab";
        IsSubSequence isSubSequence = new IsSubSequence();
        System.out.println(isSubSequence.isSubsequence2(s, t));
    }
}
