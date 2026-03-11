package Interview;

import java.util.*;
import java.util.stream.Collectors;

public class NonRepeatingChar {
    public static char nonrepeatingchar(String str){
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap();
        for(char s: str.toCharArray()){
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry  : hashMap.entrySet()){
            if(entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
        return '\0';
    }
    public static char nonrepeatchar(String str){
        Map<String, Long> collect = Arrays.stream(str.split("")).collect(Collectors.groupingBy(
                x -> x,
                Collectors.counting()
        ));
        for(Map.Entry<String, Long> map:  collect.entrySet()){
            if(map.getValue() == 1){
               return map.getKey().charAt(0);
            }
        }
        return '\0';
    }
    public static char norepeatchar(String str){
        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++){
            if(freq[str.charAt(i)] == 1){
                return str.charAt(i);
            }
        }
        return '\0';
    }

    public static char norepeatch(String str){
        int[] freq = new int[26];
        for(char ch: str.toCharArray()){
            freq[ch - 'a']++;
        }
        System.out.println(Arrays.toString(freq));
        for(char c: str.toCharArray()){
            if(freq[c - 'a'] == 1){
                return c;
            }
        }
        return '\0';
    }


    public static void main(String[] args) {
        //System.out.println(NonRepeatingChar.nonrepeatingchar("aabbcdd"));
        //System.out.println(NonRepeatingChar.nonrepeatchar("aabbcdd"));
        System.out.println(NonRepeatingChar.norepeatch("aabbcdd"));
    }
}
