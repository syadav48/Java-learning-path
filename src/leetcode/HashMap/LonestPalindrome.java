package leetcode.HashMap;

import string.OnlyDigit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonestPalindrome {
    public static int longestPalindrome(String s) {
        boolean isSame = s.chars().allMatch(c -> c == s.charAt(0));
        if(isSame){
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Integer isEven = map.values().stream().toList().stream().filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);
        boolean isOdd = map.values().stream().toList().stream().filter(x -> x % 2 != 0)
                .toList().contains(1);
        System.out.println(map);
        return isOdd ? isEven + 1 : isEven;
    };

    public static int longestPalindrome2(String s) {
        if(s == null || s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int length = 0;
        boolean hasOdd = false;
        for(int freq: map.values()){
            length += (freq/2)*2;
            if(freq % 2 == 1){
                hasOdd = true;
            }
        }
        if (hasOdd) length++;
        return length;
    };

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("abcccccdd"));
        System.out.println(longestPalindrome2("a"));
        System.out.println(longestPalindrome2("bb"));
        System.out.println(longestPalindrome2("ccc"));
        System.out.println(longestPalindrome2("bananas"));
    }
}
