package leetcode.enumeration;

import java.util.Arrays;
//In DSA, Enumeration = brute force listing of all possibilities (subsets, permutations, ranges, paths, etc.)
// Enumeration = systematically listing all possible cases/solutions/values.
//In programming, it means trying out all possibilities (brute-force style), and then checking which one satisfies the condition.
public class GreatestLetter {
    public static String greatestLetter(String s) {

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) - 'A' < 26){
                freq1[s.charAt(i) - 'A']++;
            } else {
                freq2[s.charAt(i) - 'a']++;
            }
        }
        for(int i = freq1.length - 1; i >= 0; i--){
            if(freq1[i] != 0 && freq2[i] != 0){
                return String.valueOf((char) ('A' + i));
            }
        }
        return  "";
    }
    public static String greatestLetterII(String s) {

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                freq1[ch - 'A']++;
            } else if (ch >= 'a' && ch <= 'z') {
                freq2[ch - 'a']++;
            }
        }
        for(int i = freq1.length - 1; i >= 0; i--){
            if(freq1[i] != 0 && freq2[i] != 0){
                return String.valueOf((char) ('A' + i));
            }
        }
        return  "";
    }
    public static void main(String[] args) {
        System.out.println(greatestLetter("lEeTcOdE"));
        System.out.println(greatestLetter("arRAzFif"));
        System.out.println(greatestLetter("AbCdEfGhIjK"));
    }
}
