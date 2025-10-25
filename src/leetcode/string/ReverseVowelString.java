package leetcode.string;

import java.util.Arrays;
import java.util.List;

public class ReverseVowelString {
    public static boolean isVowel(String str){
        List<String> list = Arrays.asList("A", "E", "I", "O", "U", "a", "e", "i", "o", "u");
        return list.contains(str);
    }
    public static String reverseVowels(String s) {
        StringBuilder str = new StringBuilder();
        for(String ch : s.split("")){
            if(isVowel(ch)){
                str.append(ch);
            }
        }
        return "S";

    }
    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
    }
}
