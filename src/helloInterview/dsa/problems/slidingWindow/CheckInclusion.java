package helloInterview.dsa.problems.slidingWindow;

import java.util.Arrays;

public class CheckInclusion {
    public boolean checkPerm(String s1, String s2){
        int[] freq = new int[26];
        for(char ch: s1.toCharArray()){
            freq[ch - 'a']++;
        }
        for(char ch: s2.toCharArray()){
            freq[ch-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(freq[i] != 0){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        for (int i = 0; i <= s2.length() - len; i++) {
            if(checkPerm(s1, s2.substring(i, i + len))){
                return true;
            }
        }
        return false;
    }
    public boolean checkInclusionOpt(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] s1Freq =  new int[26];
        int[] window = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(s1Freq, window)){
            return true;
        }
        for (int right = s1.length(); right < s2.length(); right++) {
            window[s2.charAt(right) - 'a']++;
            window[s2.charAt(right - s1.length()) - 'a']--;
            if(Arrays.equals(s1Freq, window)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(checkInclusion.checkInclusionOpt(s1, s2));
    }
}
