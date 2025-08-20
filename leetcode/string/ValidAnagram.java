class Solution {
    public boolean isAnagram(String s, String t) {
        boolean isEqual = s.length() == t.length();
            return isEqual;
    }
}

public class ValidAnagram {
    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.isAnagram("anagram", "nagaram");
    }
}
