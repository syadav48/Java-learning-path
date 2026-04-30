package Intermediate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class InterviewQns {
    public static char firstNonRepeatingChar(String str){
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for(char ch: str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        System.out.println(map);
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 'c';
    }
    public static void main(String[] args) {
        String s = "Stress";
        // firstNonRepeating
        System.out.println(firstNonRepeatingChar(s));
    }
}
