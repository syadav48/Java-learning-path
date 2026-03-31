package leetcode.leet75.arrstr;

public class IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        int left = 0;
        int right = 0;
        while (right < t.length()){
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
            if (left == s.length()) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        IsSubSequence isSubSequence = new IsSubSequence();
        System.out.println(isSubSequence.isSubsequence("axc", "ahbgdc"));
    }
}
