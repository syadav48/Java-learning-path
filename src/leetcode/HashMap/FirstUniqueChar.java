package leetcode.HashMap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(Character ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
               return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }
    public static int firstUniq(String s) {
        int[] freq = new int[26];
        System.out.println(Arrays.toString(freq));
        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;
        }
        System.out.println(Arrays.toString(freq));
        for (int i = 0; i < s.length(); i++) {
            if(freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int res = firstUniq("leetcode");
        System.out.println(res);
    }
}
