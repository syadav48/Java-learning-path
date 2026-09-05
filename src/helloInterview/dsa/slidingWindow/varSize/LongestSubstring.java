package helloInterview.dsa.slidingWindow.varSize;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);

        }
        return max;
    }
    public Integer longestSubstringWithoutRepeatOpt(String s) {
        HashMap<Character, Integer> state = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            state.put(ch, state.getOrDefault(ch, 0) + 1);
            while (state.get(ch) > 1){
                char startChar = s.charAt(start);
                state.put(startChar, state.get(startChar) - 1);
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        System.out.println(state + " state: " + start);
        return max;
    }
    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.longestSubstringWithoutRepeatOpt("eghghhgg")); // 3
        //System.out.println(longestSubstring.longestSubstringWithoutRepeat("substring")); // 8
    }
}
