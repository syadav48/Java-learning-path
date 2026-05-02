package LTMClinet.core.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckingAnagram {
    public static boolean checkAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public static String reverse(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static String reverseEachWord(String s) {
        String collect = Arrays.stream(s.split(" ")).toList().stream().map(x -> new StringBuilder(x).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(collect);
        return Arrays.stream(s.split(" ")).map(x -> reverse(x)).collect(Collectors.joining(" "));
    }

    public static boolean countVowel(Character ch) {

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }

        return false;
    }

    public static void countVowCons(String s) {
        Map<String, Integer> map = new HashMap<>();
        int vc = 0;
        int cc = 0;
        for (char ch : s.toCharArray()) {
            if (countVowel(ch)){
                map.put("Vowel", ++vc);
            } else {
                map.put("Consonant", ++cc);
            }
        }
        System.out.println(map);

    }

    public static void main(String[] args) {
        String s = "silent";
        String t = "listen";
        System.out.println(checkAnagram(s, t));
        String str = "Java is fun"; //"avaJ si nuf"
        System.out.println(reverseEachWord(str));
        countVowCons(s);
    }
}
