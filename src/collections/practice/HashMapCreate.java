package collections.practice;

import java.util.HashMap;

public class HashMapCreate {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        String sentence = "A quick brown fox brown fox jum over over the lazy dog dog dog";
        HashMap <String, Integer> countMap = new HashMap<>();
        map.put(203, "Surya");
        map.put(204, "Sangita");
        map.put(205, "Sangam");
        map.put(206, "Satyi");
        map.put(207, "Satyia");
        for(String str: sentence.split(" ")){
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        System.out.println(map);
        System.out.println(countMap);
    }


}
