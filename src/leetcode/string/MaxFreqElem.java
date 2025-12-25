package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class MaxFreqElem {
    public int maxFreqSum(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int vowelMax = 0;
        int constMax = 0;
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getKey() == 'a' || entry.getKey() == 'e' || entry.getKey() == 'i'
            || entry.getKey() == 'o' || entry.getKey() == 'u'
            ){
                vowelMax = Math.max(vowelMax, entry.getValue());
            } else {
                constMax = Math.max(constMax, entry.getValue());
            }
        }
        return vowelMax + constMax;
    }
    public static void main(String[] args) {
        MaxFreqElem maxFreqElem = new MaxFreqElem();
        System.out.println(maxFreqElem.maxFreqSum("aeiaeia"));
    }
}
