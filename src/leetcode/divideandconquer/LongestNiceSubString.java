package leetcode.divideandconquer;

public class LongestNiceSubString {
    public String longestNiceSubstring(String s) {
        if(s.length() < 2) return "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean a = !s.contains(Character.toString(Character.toLowerCase(ch)));
            boolean b = !s.contains(Character.toString(Character.toUpperCase(ch)));
            if(a || b){
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                System.out.println(left + " " + right + " ");
                return  left.length() >= right.length() ? left : right;
            }

        }
        return s;
    }

    public static void main(String[] args) {
        LongestNiceSubString longestNiceSubString = new LongestNiceSubString();
        System.out.println(longestNiceSubString.longestNiceSubstring("YazaAayz"));
    }
}
