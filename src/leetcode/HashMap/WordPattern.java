package leetcode.HashMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] list = s.split(" ");
        StringBuilder str = new StringBuilder();
        if(pattern.length() != list.length){
            return false;
        }
        for(int i = 0; i < list.length; i++){
            if(!map.containsKey(pattern.charAt(i)) && !map.containsValue(list[i])){
                map.put(pattern.charAt(i), list[i]);
            }
        }
        for(int i = 0; i < pattern.length(); i++){
            if(i != 0){
                str.append(" ");
            }
            str.append(map.get(pattern.charAt(i)));
        }

        return str.toString().equals(s);
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
