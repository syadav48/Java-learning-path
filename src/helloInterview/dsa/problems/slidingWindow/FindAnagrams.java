package helloInterview.dsa.problems.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p.length() > s.length()){
            return list;
        }
        int[] pFreq = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(pFreq, window)){
            list.add(0);
        }

        for (int right = p.length(); right < s.length(); right++) {
            window[s.charAt(right) - 'a']++;
            window[s.charAt(right - p.length()) - 'a']--;
            if(Arrays.equals(pFreq, window)){
                list.add(right - p.length() + 1);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams.findAnagrams(s, p));
    }
}
