package helloInterview.dsa.problems.twoPointer;

public class IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        for (int end = 0; end < t.length(); end++) {
            if(s.charAt(start) == t.charAt(end)){
                start++;
            }
            if (start == s.length()) {
                return true;
            }
        }
        return false;
    }
    public boolean isSubsequenceOpt(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            j++;
        }
        return i == s.length();
    }
    public static void main(String[] args) {
        IsSubSequence isSubSequence = new IsSubSequence();
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println(isSubSequence.isSubsequence(s1, t1));
    }
}
