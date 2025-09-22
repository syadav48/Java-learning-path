package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class RansomNotes {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(char ch: magazine.toCharArray()){
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for(char ch: ransomNote.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        for(char ch: ransomNote.toCharArray()){
            if(!map1.containsKey(ch)){
               return false;
            } else if (map2.get(ch) > map1.get(ch)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canConstruct("aaaaa", "aaabb"));
    }
}
