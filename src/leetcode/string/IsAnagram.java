package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : map1.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
            if (!map1.get(entry.getKey()).equals(map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

        public static boolean isAnagram2(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Integer> countMap = new HashMap<>();

            // Step 1: Count characters in s
            for (char c : s.toCharArray()) {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }

            // Step 2: Reduce counts while scanning t
            for (char c : t.toCharArray()) {
                if (!countMap.containsKey(c)) {
                    return false; // extra char in t
                }
                countMap.put(c, countMap.get(c) - 1);
                if (countMap.get(c) < 0) {
                    return false; // too many of this char in t
                }
            }

            // Step 3: All counts should be zero (already guaranteed by length check)
            return true;
        }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
