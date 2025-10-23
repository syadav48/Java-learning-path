package leetcode.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class IsIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
       Map<Character, Integer> map1 = new LinkedHashMap<>();
       Map<Character, Integer> map2 = new LinkedHashMap<>();
       for(char ch: s.toCharArray()){
           map1.put(ch, map1.getOrDefault(ch, 0) + 1);
       }
        for(char ch: t.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        return map1.values().containsAll(map2.values());
    }
    public static void main(String[] args) {
        String s = "egg";
        String t = "adbd";
        System.out.println(isIsomorphic(s, t));
    }
}
