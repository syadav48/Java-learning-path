package leetcode.string;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String letters = s.chars().filter(x -> (Character.isLetter(x) || Character.isDigit(x))).mapToObj(ch -> String.valueOf((char) ch))
                 .collect(Collectors.joining()).toLowerCase(Locale.ROOT);
        StringBuilder str = new StringBuilder();
        for (int i = letters.length() - 1; i > -1; i--) {
            str.append(letters.charAt(i));
        }
        return str.toString().equals(letters);
    };
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("0P"));
    }
}
