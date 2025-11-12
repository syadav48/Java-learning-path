package leetcode.HashMap;

import java.util.*;
import java.util.stream.Collectors;

public class ShortestWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
         String lowerCase = licensePlate.toLowerCase();
         Map<Character, Integer> map = new HashMap<>();
         List<String> list = new ArrayList<>();
        for (int i = 0; i < lowerCase.length(); i++) {
            char ch = lowerCase.charAt(i);
            if(Character.isLetter(ch)){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        System.out.println(map);

        for (int i = 0; i < words.length; i++) {
            Map<Character, Integer> map1 = new HashMap<>(map);
            for (int j = 0; j < words[i].length(); j++) {
                if(map1.get(words[i].charAt(j)) != null && map1.get(words[i].charAt(j)) > 0){
                    map1.put(words[i].charAt(j), map1.get(words[i].charAt(j)) - 1);
                }
            }
            if(map1.values().stream().allMatch(x -> x == 0)){
                list.add(words[i]);
            }
        }
        List<String> list1 = list.stream().sorted(Comparator.comparing(x -> x.length())).toList();
        System.out.println(list1);
        return list1.get(0);
    }
    public static void main(String[] args) {
        String lp = "1s3 PSt";
        String[] words = {"step","steps","stripe","stepple"};
        ShortestWord shortestWord = new ShortestWord();
        System.out.println(shortestWord.shortestCompletingWord(lp, words));
    }
}
