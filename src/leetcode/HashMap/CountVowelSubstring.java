package leetcode.HashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountVowelSubstring {
    public int countVowelSubstrings(String word) {
        int count = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                if (!isVowel(c)) {
                    break; // stop when non-vowel appears
                }
                set.add(c);
                if (set.size() == 5) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public static void main(String[] args) {
        CountVowelSubstring count = new CountVowelSubstring();
        String s = "aeiouu";
        System.out.println(count.countVowelSubstrings(s));
    }
}
