package leetcode.string;

import java.util.HashMap;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] split = paragraph.split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String s: split){
           hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }
        System.out.println(hashMap);
        return "S";
    }
    public static void main(String[] args) {
        MostCommonWord commonWord = new MostCommonWord();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(commonWord.mostCommonWord(paragraph, banned));
    }
}
