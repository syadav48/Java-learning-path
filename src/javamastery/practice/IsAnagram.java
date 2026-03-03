package javamastery.practice;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean anagramString(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        System.out.println(charArray1);

        return Arrays.equals(charArray1, charArray2);
    };
    public boolean anagramStrings(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(Character character: str1.toCharArray()){
            map1.put(character, map1.getOrDefault(character, 0) + 1);
        }
        for(Character character: str2.toCharArray()){
            map2.put(character, map2.getOrDefault(character, 0) + 1);
        }
        System.out.println(map1);
        System.out.println(map2);
        for (char ch: map1.keySet()){
            if(!map1.get(ch).equals(map2.get(ch))){
                return false;
            }
        }
        return true;
    };
    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        String str1 = "reverse";
        String str2 = "servere";
        boolean anagram = isAnagram.anagramStrings(
                str1,
                str2
        );
        System.out.println(anagram);

    }
}
