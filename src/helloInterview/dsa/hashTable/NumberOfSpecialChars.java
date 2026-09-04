package helloInterview.dsa.hashTable;

import java.util.*;
import java.util.stream.Collectors;

public class NumberOfSpecialChars {
    public int numberOfSpecialChars(String word) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int res = 0;
        for (char ch: word.toCharArray()){
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Long> collect = hashMap.keySet().stream().map(Character::toLowerCase).collect(Collectors.groupingBy(
                x -> x,
                Collectors.counting()
        ));
        for(Map.Entry<Character, Long> map: collect.entrySet()){
            if(map.getValue() > 1){
                res++;
            }
        }
        return res;
    }
    public int numberOfSpecialCharsOpt(String word) {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();
        int res = 0;
        for(char ch: word.toCharArray()){
            if(Character.isLowerCase(ch)){
                lower.add(ch);
            } else {
                upper.add(ch);
            }
        }
        for(char ch: lower){
            if(upper.contains(Character.toUpperCase(ch))){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfSpecialChars numberOfSpecialChars = new NumberOfSpecialChars();
        System.out.println(numberOfSpecialChars.numberOfSpecialChars("aaAbcBC"));
        System.out.println(numberOfSpecialChars.numberOfSpecialChars("abc"));
        System.out.println(numberOfSpecialChars.numberOfSpecialChars("abBCab"));
        System.out.println(numberOfSpecialChars.numberOfSpecialCharsOpt("aaAbcBC"));
        System.out.println(numberOfSpecialChars.numberOfSpecialCharsOpt("abc"));
        System.out.println(numberOfSpecialChars.numberOfSpecialCharsOpt("abBCab"));
    }
}
