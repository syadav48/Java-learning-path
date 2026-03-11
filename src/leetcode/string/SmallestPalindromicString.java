    package leetcode.string;

    import java.util.Arrays;

    public class SmallestPalindromicString {
        public String smallestPalindrome(String s) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if(i % 2 == 0){
                    str.append(chars[i]);
                }
            }
            String s1 = str.toString();
            String s2 = s.length() % 2 == 0 ? str.reverse().toString() : str.reverse().substring(1);
            return s1 + s2;
        }
        public static void main(String[] args) {
            SmallestPalindromicString sm = new SmallestPalindromicString();
            System.out.println(sm.smallestPalindrome("yey")); //abbba - abb
        }
    }
