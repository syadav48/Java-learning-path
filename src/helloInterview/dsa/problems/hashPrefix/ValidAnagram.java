package helloInterview.dsa.problems.hashPrefix;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
        }
        for (int count: freq){
            if(count != 0){
                return false;
            }
        }
        System.out.println(Arrays.toString(freq));
        return true;
    }
    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(validAnagram.isAnagram(s, t));
    }
}
