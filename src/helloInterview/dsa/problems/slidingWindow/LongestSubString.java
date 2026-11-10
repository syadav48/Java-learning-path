package helloInterview.dsa.problems.slidingWindow;

import java.util.HashMap;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.get(ch) > 1){
                char startChar = s.charAt(left);
                map.put(startChar, map.get(startChar) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    public int lengthOfLongestSubstringOpt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
    public static void main(String[] args) {
        LongestSubString longestSubString = new LongestSubString();
        String s = "abcabcbb";
        System.out.println(longestSubString.lengthOfLongestSubstring(s));
    }
}
