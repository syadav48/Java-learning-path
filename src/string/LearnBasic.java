package string;
//https://chatgpt.com/c/68b72cc4-01a4-8333-9d6d-d4716e61bd88
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LearnBasic {
    public static void main(String[] args) {
        String str1 = "hello";
        String reversed = new StringBuilder(str1).reverse().toString();
        System.out.println(reversed);
        String str2 = "madam";
        String isPalindrome = new StringBuilder(str2).reverse().toString();
        System.out.println(str2.equals(isPalindrome));
        String str3 = "Java Programming";
        String str4 = " Java is fun ";
        Map<Character, Integer> map = new HashMap<>();
        int vowel = 0;
        int consonant = 0;
        for(char c : str3.toCharArray()){
            if(Character.isLetter(c)){
                if("aeiou".indexOf(c) != -1){
                    vowel++;
                }else {
                    consonant++;
                }
            }
        }
        System.out.println("Vowel:" + vowel + "Consonant: " + consonant);
        for(char c: str1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);
        System.out.println(str4.trim());



        }
    }

