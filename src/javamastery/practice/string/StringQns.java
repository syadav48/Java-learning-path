package javamastery.practice.string;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringQns {
    public static boolean checkAnagram(String s1, String s2){
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }
    public static char firstNonRepeatingChar(String s1){
        LinkedHashMap<String, Long> collect = Arrays.stream(s1.split("")).collect(
                Collectors.groupingBy(
                        x -> x,
                        LinkedHashMap::new,
                        Collectors.counting()
                )
        );
        for(Map.Entry<String, Long> entry: collect.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey().charAt(0);
            }
        }
        return '\0';
    };
    public static char firstNonRepeatingCharOpt(String s1){
        int[] freq = new int[26];
        for(char ch: s1.toCharArray()){
            freq[ch - 'a']++;
        }
        for(char ch: s1.toCharArray()){
            if(freq[ch - 'a'] == 1){
                return ch;
            }
        }
        return '\0';
    };
    public static void main(String[] args) {
        String s1 = "icebergic";
        String s2 = "gerbice";
        System.out.println(StringQns.checkAnagram(s1, s2));
        System.out.println(StringQns.firstNonRepeatingChar(s1));
        System.out.println(StringQns.firstNonRepeatingCharOpt(s1));
    }
}
