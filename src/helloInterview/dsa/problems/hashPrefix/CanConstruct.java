package helloInterview.dsa.problems.hashPrefix;

import java.util.Arrays;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] freq = new int[26];
        for (char ch: magazine.toCharArray()){
            freq[ch - 'a']++;
        }
        for(char ch: ransomNote.toCharArray()){
            freq[ch - 'a']--;
            if (freq[ch - 'a'] < 0) {
                return false;
            }
        }
        System.out.println(Arrays.toString(freq));
        return true;
    }
    public static void main(String[] args) {
        CanConstruct canConstruct = new CanConstruct();
        String ransomNotes = "a";
        String magazine = "b";
        System.out.println(canConstruct.canConstruct(ransomNotes, magazine));
    }
}
