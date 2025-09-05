package Intermediate.collections;

import java.util.HashMap;
import java.util.Map;

public class WordOccur {
    public static void main(String[] args) {
        String paragraph = "A Quick Brown Fox jump over the Lazy Dog and after that the Dog started jumping on her shoulder";
        Map<String, Integer> map = new HashMap<>();
        for(String word: paragraph.split(" ")){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
    }
}
