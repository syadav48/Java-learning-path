package javamastery.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Q2_AnagramString {
    public static boolean isanagram1(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(char ch: s.toCharArray()){
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for(char ch: t.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        System.out.println(map1 + " " + map2);
        for(int i = 0; i < s.length(); i++){
            if(map1.get(s.charAt(i)) != map2.get(s.charAt(i))){
                return false;
            }
        }
        return true;
    };
    public static boolean isanagram2(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char ch: t.toCharArray()){
            if(!map.containsKey(ch)){
                return false;
            }
            map.put(ch, map.get(ch) - 1);
            if(map.get(ch) < 0){
                return false;
            }
        }
        for(int val: map.values()){
            if(val != 0) return false;
        }


        System.out.println(map);
        return true;
    };
    public static boolean isanagram3(String s, String t){
        if (s.length() != t.length()) return false;
        char [] chararr1 = s.toCharArray();
        char [] chararr2 = t.toCharArray();
        Arrays.sort(chararr1);
        Arrays.sort(chararr2);
        return Arrays.equals(chararr1, chararr2);
    };

    public static boolean isanagram4(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Long> freq1 = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> freq2 = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return freq1.equals(freq2);
    }
    public static void main(String[] args) {
        String s = "listen";
        String t = "silent";
        String a = "herting";
        String b = "baherty";
//        System.out.println(isanagram1(s, t));
//        System.out.println(isanagram1(a, b));
//        System.out.println(isanagram2(s, t));
//        System.out.println(isanagram2(a, b));
//        System.out.println(isanagram3(s, t));
//        System.out.println(isanagram3(a, b));
        System.out.println(isanagram4(s, t));
        System.out.println(isanagram4(a, b));

    }
}
